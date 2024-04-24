package pl.put.travelmate.ui.components.phone

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pl.put.travelmate.data.Difficulty
import pl.put.travelmate.data.Trail
import pl.put.travelmate.data.findTrailById
import pl.put.travelmate.ui.components.Drawer
import pl.put.travelmate.ui.components.TravelMateAppBar
import pl.put.travelmate.ui.pages.AppDescriptionPage
import pl.put.travelmate.ui.pages.TrailDetail

@Composable
fun PhoneView(trails: List<Trail>) {
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    Drawer(navController = navController, state = drawerState) {
        Scaffold(topBar = {
            TravelMateAppBar(navController = navController, drawerState = drawerState)
        }) {
            Column(Modifier.padding(it)) {
                PhoneNavHost(trails = trails, navController = navController)
            }
        }
    }
}

@Composable
fun PhoneNavHost(trails: List<Trail>, navController: NavHostController) {
    NavHost(navController, startDestination = "main") {
        composable("main") {
            AppDescriptionPage()
        }
        composable("easyTrails") {
            TrailList(
                trails = trails.filter { it.difficulty == Difficulty.EASY },
                navController = navController
            )
        }
        composable("mediumTrails") {
            TrailList(
                trails = trails.filter { it.difficulty == Difficulty.MEDIUM },
                navController = navController
            )
        }
        composable("trail/{trailId}") { backStackEntry ->
            val trailId = backStackEntry.arguments?.getString("trailId")
            val trail = findTrailById(trails, trailId)
            TrailDetail(trail)
        }
    }
}