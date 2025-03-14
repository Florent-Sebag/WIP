package sebag.florent.presentation.view.feed

import android.net.Uri
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import sebag.florent.domain.model.Post

class FeedData {

    private val _state = MutableStateFlow<FeedState>(FeedState.Init)
    val state: StateFlow<FeedState> = _state

    private fun updateState(newState: FeedState) {
        _state.value = newState
    }

    fun error() {
        updateState(FeedState.Error("An error occurred"))
    }

    fun onFetchSuccess(posts: List<Post>) {
        updateState(FeedState.FetchSuccess(posts))
    }

    fun createPost(content: String, photoUri: Uri?) {
        updateState(FeedState.CreateNewPost(content, photoUri))
    }
}