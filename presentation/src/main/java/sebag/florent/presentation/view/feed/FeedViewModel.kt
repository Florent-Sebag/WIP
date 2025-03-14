package sebag.florent.presentation.view.feed

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import sebag.florent.domain.usecases.CreatePostUseCase
import sebag.florent.domain.usecases.GetFeedUseCase


class FeedViewModel(
    private val data: FeedData,
    private val getFeedUseCase: GetFeedUseCase,
    private val createPostUseCase: CreatePostUseCase
) : ViewModel() {

    val state: StateFlow<FeedState> = data.state

    init {
        viewModelScope.launch {
            state.collect { currentState ->
                handleStateChange(currentState)
            }
        }
    }

    fun createPost(content: String, photoUri: Uri?) = data.createPost(content, photoUri)

    private fun handleStateChange(state: FeedState) {
        when (state) {
            is FeedState.Init -> getFeed()
            is FeedState.CreateNewPost -> createNewPost(state.content, state.photoUri)
            else -> Unit
        }
    }

    private fun getFeed() {
        viewModelScope.launch {
            val result = runCatching { getFeedUseCase.invoke() }
            result.fold(
                onSuccess = { posts ->
                    data.onFetchSuccess(posts)
                },
                onFailure = {
                    data.error()
                }
            )
        }
    }

    private fun createNewPost(content: String, photoUri: Uri?) {
        viewModelScope.launch {
            val result = runCatching { createPostUseCase.invoke(content, photoUri) }
            result.fold(
                onSuccess = { posts ->
                    data.onFetchSuccess(posts.toList())
                },
                onFailure = {
                    data.error()
                }
            )
        }
    }
}