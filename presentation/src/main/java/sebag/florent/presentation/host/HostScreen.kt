package sebag.florent.presentation.host

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel
import sebag.florent.presentation.host.ui.BottomBarComposable
import sebag.florent.presentation.host.ui.TopBarComposable
import sebag.florent.presentation.view.feed.FeedScreen
import sebag.florent.presentation.view.feed.FeedViewModel
import sebag.florent.presentation.view.profile.ProfileScreen
import sebag.florent.presentation.view.profile.ProfileViewModel

@Composable
fun HostScreen() {
    val navController = rememberNavController()
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination?.route


    LaunchedEffect(Unit) {
        navController.navigate(FEED_ROUTE)
    }

    Scaffold(
        topBar = { TopBarComposable() },
        bottomBar = { InitBottomBarNavigation(currentDestination, navController) }
    ) { paddingValues ->

        Box(modifier = Modifier.padding(paddingValues)) {
            NavHost(navController = navController, startDestination = FEED_ROUTE) {
                composable(FEED_ROUTE) { FeedDestination(navController) }
                composable(PROFILE_ROUTE) { ProfileDestination(navController) }
            }
        }
    }
}

@Composable
private fun InitBottomBarNavigation(
    currentDestination: String?,
    navController: NavHostController
) = BottomBarComposable(
    currentRoute = currentDestination,
    onItemSelected = { route ->
        if (currentDestination != route) {
            navController.navigate(route) {
                popUpTo(navController.graph.startDestinationId) { saveState = true }
                launchSingleTop = true
                restoreState = true
            }
        }
    }
)

@Composable
private fun FeedDestination(navController: NavHostController) {
    val viewModel: FeedViewModel = koinViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    FeedScreen(
        viewModel = viewModel,
        state = state,
        onNavigationRequested = { route ->
            navController.navigate(route)
        }
    )
}

@Composable
private fun ProfileDestination(navController: NavHostController) {
    val viewModel: ProfileViewModel = koinViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    ProfileScreen(
        viewModel = viewModel,
        state = state,
        onNavigationRequested = { route ->
            navController.navigate(route)
        }
    )
}

const val FEED_ROUTE = "feed"
const val PROFILE_ROUTE = "profile"
