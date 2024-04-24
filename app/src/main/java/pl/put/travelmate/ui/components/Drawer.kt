package pl.put.travelmate.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Mood
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun Drawer(
    navController: NavController,
    state: DrawerState,
    content: @Composable () -> Unit
) {
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = state,
        drawerContent = {
            ModalDrawerSheet {
                Column(Modifier.verticalScroll(rememberScrollState())) {
                    Spacer(Modifier.height(12.dp))
                    NavigationDrawerItem(
                        label = { Text("Main") },
                        icon = { Icon(Icons.Filled.Home, contentDescription = "Main") },
                        selected = false,
                        onClick = {
                            navController.navigate("main");
                            scope.launch {
                                state.close()
                            }
                        })
                    NavigationDrawerItem(
                        label = { Text("Easy Trail") },
                        icon = { Icon(Icons.Filled.Mood, contentDescription = "Easy trails") },
                        selected = false,
                        onClick = {
                            navController.navigate("easyTrails")
                            scope.launch {
                                state.close()
                            }
                        })
                    NavigationDrawerItem(
                        label = { Text("Medium Trail") },
                        icon = { Icon(Icons.Filled.Warning, contentDescription = "Medium trails") },
                        selected = false,
                        onClick = {
                            navController.navigate("mediumTrails")
                            scope.launch {
                                state.close()
                            }
                        })
                }
            }
        }
    ) {
        content()
    }
}

