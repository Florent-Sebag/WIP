package sebag.florent.presentation.view.profile

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sebag.florent.presentation.view.profile.ui.ProfileComposable

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel,
    state: ProfileState,
    onNavigationRequested: (String) -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.onScreenVisible()
    }

    when (state) {
        is ProfileState.Init -> {
            CircularProgressIndicator(modifier = Modifier.fillMaxWidth().padding(16.dp))
        }

        is ProfileState.FetchSuccess -> {
            ProfileComposable(state.badges)
        }

        else -> Unit
    }
}