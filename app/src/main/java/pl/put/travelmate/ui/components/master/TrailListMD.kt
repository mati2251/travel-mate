package pl.put.travelmate.ui.components.master

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import pl.put.travelmate.R
import pl.put.travelmate.data.Trail

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
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            )
            Text(text = trail.name, style = MaterialTheme.typography.headlineMedium)
        }
    }
}
