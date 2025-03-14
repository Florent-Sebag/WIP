package sebag.florent.presentation.view.feed

import android.net.Uri
import sebag.florent.domain.model.Post

sealed class FeedState {

    data object Init : FeedState()
    data object Loading : FeedState()
    data object Success : FeedState()

    data class FetchSuccess(val posts: List<Post>): FeedState()
    data class CreateNewPost(val content: String, val photoUri: Uri?): FeedState()
    data class Error(val message: String) : FeedState()

}