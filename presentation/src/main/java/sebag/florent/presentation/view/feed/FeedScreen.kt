package sebag.florent.presentation.view.feed

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import sebag.florent.presentation.view.feed.ui.CreatePostModalComposable
import sebag.florent.presentation.view.feed.ui.FeedComposable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedScreen(
    viewModel: FeedViewModel,
    state: FeedState,
    onNavigationRequested: (String) -> Unit
) {
    val bottomSheetState =  rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }


    when (state) {
        is FeedState.Init -> {
            CircularProgressIndicator(modifier = Modifier.fillMaxWidth().padding(16.dp))
        }

        is FeedState.FetchSuccess -> {
            FeedComposable(
                posts = state.posts,
                onClickFloatButton = {
                    showBottomSheet = true
                }
            )
        }

        is FeedState.Error -> {
            Toast.makeText(LocalContext.current, state.message, Toast.LENGTH_SHORT).show()
        }

        else -> Unit
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            sheetState = bottomSheetState,
            onDismissRequest = { showBottomSheet = false }
        ) {
            CreatePostModalComposable(
                onPostCreated = { content, photoUri ->
                    viewModel.createPost(content, photoUri)
                    showBottomSheet = false
                },
                onDismiss = { showBottomSheet = false }
            )
        }
    }
}
