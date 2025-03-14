package sebag.florent.presentation.host.ui

import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sebag.florent.presentation.host.FEED_ROUTE
import sebag.florent.presentation.host.PROFILE_ROUTE

@Composable
fun BottomBarComposable(
    currentRoute: String?,
    onItemSelected: (String) -> Unit
) {
    val items = listOf(
        BottomNavItem("Feed", Icons.Filled.Home, FEED_ROUTE),
        BottomNavItem("Profile", Icons.Filled.Person, PROFILE_ROUTE)
    )

    NavigationBar(
        modifier = Modifier.height(100.dp)
    ) {
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = { onItemSelected(item.route) },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label
                    )
                },
                label = { Text(text = item.label, fontSize = 12.sp) }
            )
        }
    }
}

data class BottomNavItem(val label: String, val icon: ImageVector, val route: String)