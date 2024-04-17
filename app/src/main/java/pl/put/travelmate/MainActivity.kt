package pl.put.travelmate
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pl.put.travelmate.data.Difficulty
import pl.put.travelmate.data.Trail
import pl.put.travelmate.data.TrailStep
import pl.put.travelmate.ui.components.TravelMateAppBar
import pl.put.travelmate.ui.pages.TrailDetail
import pl.put.travelmate.ui.theme.TravelMateTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsBike
import androidx.compose.material.icons.filled.DirectionsWalk
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.layout.ContentScale
import androidx.compose.material3.Icon
import androidx.compose.runtime.MutableState

class MainActivity : ComponentActivity() {

    private val trails = listOf(
        Trail(
            id = 1,
            name = "Śnieżka",
            description = "The highest peak in the Karkonosze mountains",
            distance = "10 km",
            startLocation = "Karpacz",
            stopLocation = "Śnieżka",
            elevation = 1602,
            difficulty = Difficulty.MEDIUM,
            longDescription = "Śnieżka is the highest peak in the Karkonosze mountains, located on the border between Poland and the Czech Republic. The peak is a popular destination for hikers and tourists, offering stunning views of the surrounding landscape.",
            time = "4:00",
            steps = listOf(
                TrailStep(
                    id = 1,
                    name = "Lorem Ipsum",
                    distance = "0 km",
                    time = "0:00"
                ),
                TrailStep(
                    id = 2,
                    name = "Dolor Sit",
                    distance = "2 km",
                    time = "1:00"
                ),
                TrailStep(
                    id = 3,
                    name = "Amet Consectetur",
                    distance = "4 km",
                    time = "2:00"
                ),
                TrailStep(
                    id = 4,
                    name = "Adipiscing Elit",
                    distance = "6 km",
                    time = "3:00"
                ),
                TrailStep(
                    id = 5,
                    name = "Sed Do Eius",
                    distance = "8 km",
                    time = "4:00"
                ),
                TrailStep(
                    id = 6,
                    name = "Tempor Incididunt",
                    distance = "10 km",
                    time = "5:00"
                )
            ),
            imageUrl = "data\\image.jpg"
        ),
        Trail(
            id = 2,
            name = "Morskie Oko",
            description = "A beautiful lake in the Tatra mountains",
            distance = "8 km",
            startLocation = "Zakopane",
            stopLocation = "Morskie Oko",
            elevation = 1395,
            difficulty = Difficulty.EASY,
            longDescription = "Morskie Oko is a beautiful lake located in the Tatra mountains in southern Poland. The lake is a popular destination for hikers and tourists, offering stunning views of the surrounding mountains and forests. The lake is accessible by foot or horse-drawn carriage, and there are several trails that lead to the lake. The most popular route is the green trail, which starts in Zakopane and takes about 2-3 hours to reach the lake. Once at the lake, visitors can enjoy a leisurely walk around the shore, or relax at one of the nearby mountain huts.",
            time = "4:00",
            steps = emptyList(),
            imageUrl = "data\\image.jpg"
        ),
        Trail(
            id = 3,
            name = "Bieszczady",
            description = "A remote and wild mountain range in southeastern Poland",
            distance = "15 km",
            startLocation = "Ustrzy",
            stopLocation = "Tarnica",
            elevation = 1346,
            difficulty = Difficulty.EASY,
            longDescription = "The Bieszczady mountains are a remote and wild mountain range located in southeastern Poland. The mountains are part of the Carpathian range, and are known for their rugged terrain, dense forests, and abundant wildlife. The Bieszczady mountains are a popular destination for hikers and nature lovers, offering a wide range of trails and routes to explore. The most popular route is the blue trail, which starts in Ustrzyki Dolne and takes about 4-5 hours to reach the summit of Tarnica, the highest peak in the range. Once at the top, visitors can enjoy panoramic views of the surrounding mountains and valleys, as well as the opportunity to spot rare and endangered species such as the European bison and the brown bear.",
            time = "6:00",
            steps = emptyList(),
            imageUrl = "data\\image.jpg"
        ),
        Trail(
            id = 4,
            name = "Trzy korony",
            description = "A popular peak in the Pieniny mountains",
            distance = "12 km",
            startLocation = "Szczawnica",
            stopLocation = "Trzy korony",
            elevation = 982,
            difficulty = Difficulty.MEDIUM,
            longDescription = "Trzy Korony is a popular peak in the Pieniny mountains, located on the border between Poland and Slovakia. The peak is known for its stunning views of the Dunajec river and the surrounding mountains, as well as its unique rock formations and diverse flora and fauna. The peak is accessible by foot or bike, and there are several trails that lead to the summit. The most popular route is the yellow trail, which starts in Szczawnica and takes about 3-4 hours to reach the summit. Once at the top, visitors can enjoy panoramic views of the surrounding landscape, as well as the opportunity to explore the nearby ruins of the medieval castle of Czorsztyn.",
            time = "4:00",
            steps = emptyList(),
            imageUrl = "data\\image.jpg"
        ),
        Trail(
            id = 5,
            name = "Śnieżka",
            description = "The highest peak in the Karkonosze mountains",
            distance = "10 km",
            startLocation = "Karpacz",
            stopLocation = "Śnieżka",
            elevation = 1602,
            difficulty = Difficulty.MEDIUM,
            longDescription = "Śnieżka is the highest peak in the Karkonosze mountains, located on the border between Poland and the Czech Republic. The peak is a popular destination for hikers and tourists, offering stunning views of the surrounding landscape. The mountain is accessible by foot, bike, or chairlift, and there are several trails that lead to the summit. The most popular route is the red trail, which starts in Karpacz and takes about 3-4 hours to reach the summit. Once at the top, visitors can enjoy panoramic views of the Karkonosze mountains, as well as the Giant Mountains and the Jizera Mountains in the distance.",
            time = "4:00",
            steps = emptyList(),
            imageUrl = "data\\image.jpg"
        ),
        Trail(
            id = 6,
            name = "Morskie Oko",
            description = "A beautiful lake in the Tatra mountains",
            distance = "8 km",
            startLocation = "Zakopane",
            stopLocation = "Morskie Oko",
            elevation = 1395,
            difficulty = Difficulty.EASY,
            longDescription = "Morskie Oko is a beautiful lake located in the Tatra mountains in southern Poland. The lake is a popular destination for hikers and tourists, offering stunning views of the surrounding mountains and forests. The lake is accessible by foot or horse-drawn carriage, and there are several trails that lead to the lake. The most popular route is the green trail, which starts in Zakopane and takes about 2-3 hours to reach the lake. Once at the lake, visitors can enjoy a leisurely walk around the shore, or relax at one of the nearby mountain huts.",
            time = "4:00",
            steps = emptyList(),
            imageUrl = "data\\image.jpg"
        ),
        Trail(
            id = 7,
            name = "Bieszczady",
            description = "A remote and wild mountain range in southeastern Poland",
            distance = "15 km",
            startLocation = "Ustrzy",
            stopLocation = "Tarnica",
            elevation = 1346,
            difficulty = Difficulty.EASY,
            longDescription = "The Bieszczady mountains are a remote and wild mountain range located in southeastern Poland. The mountains are part of the Carpathian range, and are known for their rugged terrain, dense forests, and abundant wildlife. The Bieszczady mountains are a popular destination for hikers and nature lovers, offering a wide range of trails and routes to explore. The most popular route is the blue trail, which starts in Ustrzyki Dolne and takes about 4-5 hours to reach the summit of Tarnica, the highest peak in the range. Once at the top, visitors can enjoy panoramic views of the surrounding mountains and valleys, as well as the opportunity to spot rare and endangered species such as the European bison and the brown bear.",
            time = "6:00",
            steps = emptyList(),
            imageUrl = ""
        ),
        Trail(
            id = 8,
            name = "Trzy korony",
            description = "A popular peak in the Pieniny mountains",
            distance = "12 km",
            startLocation = "Szczawnica",
            stopLocation = "Trzy korony",
            elevation = 982,
            difficulty = Difficulty.MEDIUM,
            longDescription = "Trzy Korony is a popular peak in the Pieniny mountains, located on the border between Poland and Slovakia. The peak is known for its stunning views of the Dunajec river and the surrounding mountains, as well as its unique rock formations and diverse flora and fauna. The peak is accessible by foot or bike, and there are several trails that lead to the summit. The most popular route is the yellow trail, which starts in Szczawnica and takes about 3-4 hours to reach the summit. Once at the top, visitors can enjoy panoramic views of the surrounding landscape, as well as the opportunity to explore the nearby ruins of the medieval castle of Czorsztyn.",
            time = "4:00",
            steps = emptyList(),
            imageUrl = ""
        )
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            val isTablet = with(LocalConfiguration.current) {
                screenWidthDp >= 600 // Common threshold for tablets
            }


            TravelMateTheme {
                if (isTablet){
                    MasterDetailScreen(trails=trails)
                } else {
                    Column {
                        TravelMateAppBar(navController = navController)
                        NavHost(navController, startDestination = "main") {
                            composable("main") {
                                AppDescriptionScreen()
                            }
                            composable("easyTrails") {
                                TrailList(trails = trails.filter { it.difficulty == Difficulty.EASY }, navController = navController)
                            }
                            composable("mediumTrails") {
                                TrailList(trails = trails.filter { it.difficulty == Difficulty.MEDIUM }, navController = navController)
                            }
                            composable("trail/{trailId}") { backStackEntry ->
                                val trailId = backStackEntry.arguments?.getString("trailId")
                                val trail = findTrailById(trailId)
                                TrailDetail(trail)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun findTrailById(trailId: String?): Trail {
        return trails.first { it.id.toString() == trailId }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TravelMateAppBar(navController: NavController) {
    TopAppBar(
        title = { Text("TravelMate") },
        actions = {
            IconButton(onClick = { navController.navigate("main") }) {
                Icon(Icons.Filled.Home, contentDescription = "Main")
            }
            IconButton(onClick = { navController.navigate("easyTrails") }) {
                Icon(Icons.Filled.DirectionsWalk, contentDescription = "Easy Trails")
            }
            IconButton(onClick = { navController.navigate("mediumTrails") }) {
                Icon(Icons.Filled.DirectionsBike, contentDescription = "Medium Trails")
            }
        }
    )
}

@Composable
fun AppDescriptionScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Welcome to TravelMate", style = MaterialTheme.typography.headlineMedium)
        Text(
            "TravelMate is your guide to exploring trails!",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun TrailList(trails: List<Trail>, navController: NavController) {
    val gridState = rememberLazyGridState()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // Możesz dostosować liczbę kolumn
        state = gridState,
        contentPadding = PaddingValues(8.dp),
        content = {
            items(trails) { trail ->
                TrailListItem(trail = trail, navController = navController)
            }
        }
    )
}


@Composable
fun TrailListItem(trail: Trail, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { navController.navigate("trail/${trail.id}") }
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.image), // Załadowanie wspólnego obrazu
                contentDescription = trail.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(150.dp).fillMaxWidth()
            )
            Text(text = trail.name, style = MaterialTheme.typography.headlineMedium)
        }
    }
}

@Composable
fun MasterDetailScreen(trails: List<Trail>) {
    val selectedTrail = remember { mutableStateOf<Trail?>(null) }
    val trailHistory = remember { mutableStateListOf<Trail>() }
    val navController = rememberNavController()

    BackHandler(enabled = trailHistory.size > 1) {
        trailHistory.removeLast()
        selectedTrail.value = trailHistory.lastOrNull()
    }

    TravelMateAppBar(navController = navController) // AppBar z przyciskami kategorii

    Row(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.weight(1f)) {
            NavHost(navController, startDestination = "allTrails") {
                composable("allTrails") {
                    TrailListMD(trails = trails, onTrailSelected = { trail ->
                        handleTrailSelection(trail, selectedTrail, trailHistory)
                    })
                }
                composable("easyTrails") {
                    TrailListMD(trails = trails.filter { it.difficulty == Difficulty.EASY }, onTrailSelected = { trail ->
                        handleTrailSelection(trail, selectedTrail, trailHistory)
                    })
                }
                composable("mediumTrails") {
                    TrailListMD(trails = trails.filter { it.difficulty == Difficulty.MEDIUM }, onTrailSelected = { trail ->
                        handleTrailSelection(trail, selectedTrail, trailHistory)
                    })
                }
            }
        }

        Column(modifier = Modifier.weight(2f).padding(8.dp)) {
            selectedTrail.value?.let { trail ->
                TrailDetail(trail = trail)
            } ?: Text("Wybierz ścieżkę", style = MaterialTheme.typography.headlineMedium)
        }
    }
}

fun handleTrailSelection(trail: Trail, selectedTrail: MutableState<Trail?>, trailHistory: MutableList<Trail>) {
    if (!trailHistory.contains(trail) || trail != trailHistory.last()) {
        selectedTrail.value = trail
        trailHistory.add(trail)
    }
}


@Composable
fun TrailListMD(trails: List<Trail>, onTrailSelected: (Trail) -> Unit) {
    val gridState = rememberLazyGridState()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        state = gridState,
        contentPadding = PaddingValues(8.dp),
        content = {
            items(trails) { trail ->
                TrailListItemMD(trail = trail, onTrailClick = { onTrailSelected(trail) })
            }
        }
    )
}

@Composable
fun TrailListItemMD(trail: Trail, onTrailClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onTrailClick)
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.image),
                contentDescription = trail.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(150.dp).fillMaxWidth()
            )
            Text(text = trail.name, style = MaterialTheme.typography.headlineMedium)
        }
    }
}

