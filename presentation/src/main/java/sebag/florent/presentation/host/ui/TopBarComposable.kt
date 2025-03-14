package sebag.florent.presentation.host.ui

import androidx.compose.foundation.layout.height
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComposable() {
    CenterAlignedTopAppBar(
        modifier = Modifier
            .height(70.dp),
        title = { Text("WIP", fontWeight = FontWeight.Bold) }
    )
}