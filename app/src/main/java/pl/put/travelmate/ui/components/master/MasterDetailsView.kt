package pl.put.travelmate.ui.components.master

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pl.put.travelmate.data.Difficulty
import pl.put.travelmate.data.Trail
import pl.put.travelmate.ui.components.Drawer
import pl.put.travelmate.ui.components.TravelMateAppBar
import pl.put.travelmate.ui.pages.AppDescriptionPage
import pl.put.travelmate.ui.pages.TrailDetail

@Composable
fun MasterDetailScreen(trails: List<Trail>) {
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val selectedTrail = remember { mutableStateOf<Trail?>(null) }
    val trailHistory = remember { mutableStateListOf<Trail>() }
    val currentScreen = if (selectedTrail.value != null) "details" else "main"

    Drawer(navController = navController, state = drawerState) {
        Scaffold(topBar = {
            TravelMateAppBar(navController = navController, drawerState = drawerState, currentScreen = currentScreen)
        }) {
            BackHandler(enabled = trailHistory.size > 1) {
                trailHistory.removeLast()
                selectedTrail.value = trailHistory.lastOrNull()
            }
            Column(Modifier.padding(it)) {
                Row(modifier = Modifier.fillMaxSize()) {
                    Column (modifier = Modifier.fillMaxSize().weight(1f)) {
                        NavHostMaster(trails, navController, selectedTrail, trailHistory)
                    }
                    Column (modifier = Modifier.fillMaxSize().weight(1f)) {
                        selectedTrail.value?.let { trail ->
                            TrailDetail(trail = trail)
                        } ?: AppDescriptionPage()
                    }
                }
            }
        }
    }
}
@Composable
fun NavHostMaster(
    trails: List<Trail>,
    navController: NavHostController,
    selectedTrail: MutableState<Trail?>,
    trailHistory: MutableList<Trail>
) {
    NavHost(navController, startDestination = "main") {
        composable("main") {
            TrailListMD(
                trails = trails,
                onTrailSelected = { trail ->
                    handleTrailSelection(trail, selectedTrail, trailHistory)
                })
        }
        composable("easyTrails") {
            TrailListMD(
                trails = trails.filter { it.difficulty == Difficulty.EASY },
                onTrailSelected = { trail ->
                    handleTrailSelection(trail, selectedTrail, trailHistory)
                })
        }
        composable("mediumTrails") {
            TrailListMD(
                trails = trails.filter { it.difficulty == Difficulty.MEDIUM },
                onTrailSelected = { trail ->
                    handleTrailSelection(trail, selectedTrail, trailHistory)
                })
        }
    }
}

fun handleTrailSelection(
    trail: Trail,
    selectedTrail: MutableState<Trail?>,
    trailHistory: MutableList<Trail>
) {
    if (!trailHistory.contains(trail) || trail != trailHistory.last()) {
        selectedTrail.value = trail
        trailHistory.add(trail)
    }
}
