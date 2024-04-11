package pl.put.travelmate.ui.components

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.Stop
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay


fun formatTime(seconds: Int): String {
    val hours = seconds / 3600
    val minutes = (seconds % 3600) / 60
    val secs = seconds % 60
    return String.format("%02d:%02d:%02d", hours, minutes, secs)
}

fun saveTime(context: Context, time: Int) {
    val sharedPref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
    with (sharedPref.edit()) {
        putInt("time", time)
        apply()
    }
}

fun getTime(context: Context): Int {
    val sharedPref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
    return sharedPref.getInt("time", 0)
}

@Composable
fun Stopwatch(context: Context) {
    var time by remember { mutableIntStateOf(getTime(context)) }
    var isRunning by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = isRunning) {
        while (isRunning) {
            delay(1000L)
            time++
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            saveTime(context, time)
        }
    }

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(formatTime(time), style = MaterialTheme.typography.headlineSmall, modifier = Modifier.padding(8.dp))
        FilledIconButton(
            onClick = { isRunning = !isRunning },
        ) {
            if (isRunning) {
                Icon(
                    Icons.Outlined.Stop,
                    contentDescription = "Stop",
                    tint = MaterialTheme.colorScheme.background,
                )
            } else {
                Icon(
                    Icons.Outlined.PlayArrow,
                    contentDescription = "Start",
                    tint = MaterialTheme.colorScheme.background,
                )
            }
        }
        FilledIconButton(onClick = {time = 0; isRunning = false}) {
            Icon(Icons.Outlined.Clear, contentDescription = "Clear")
        }
    }

}