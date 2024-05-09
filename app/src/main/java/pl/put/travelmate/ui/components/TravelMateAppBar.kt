package pl.put.travelmate.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Mood
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import pl.put.travelmate.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TravelMateAppBar(navController: NavController, drawerState: DrawerState, currentScreen: String) {
    val scope = rememberCoroutineScope()
    val showImage = currentScreen != "main"

    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    drawerState.open()
                }
            }) {
                Icon(Icons.Filled.Menu, contentDescription = "Menu")
            }
        },
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("TravelMate")
                if (showImage) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Image(
                        painter = painterResource(id = R.drawable.image),
                        contentDescription = "Custom Image"
                    )
                }
            }
        },
        actions = {
            IconButton(onClick = { navController.navigate("main") }) {
                Icon(Icons.Filled.Home, contentDescription = "Main")
            }
            IconButton(onClick = { navController.navigate("easyTrails") }) {
                Icon(Icons.Filled.Mood, contentDescription = "Easy Trails")
            }
            IconButton(onClick = { navController.navigate("mediumTrails") }) {
                Icon(Icons.Filled.Warning, contentDescription = "Medium Trails")
            }
        }
    )
}
