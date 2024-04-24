package pl.put.travelmate
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalConfiguration
import pl.put.travelmate.data.Trail
import pl.put.travelmate.ui.theme.TravelMateTheme
import pl.put.travelmate.data.getTrails
import pl.put.travelmate.ui.components.master.MasterDetailScreen
import pl.put.travelmate.ui.components.phone.PhoneView

class MainActivity : ComponentActivity() {

    private val trails = getTrails()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val isTablet = with(LocalConfiguration.current) {
                screenWidthDp >= 600
            }

            TravelMateTheme {
                if (isTablet){
                    MasterDetailScreen(trails=trails)
                } else {
                    PhoneView(trails)
                }
            }
        }
    }

}




