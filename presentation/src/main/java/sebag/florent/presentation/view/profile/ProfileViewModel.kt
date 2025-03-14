package sebag.florent.presentation.view.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import sebag.florent.domain.usecases.GetBadgesUseCase

class ProfileViewModel(
    private val data: ProfileData,
    private val getBadgesUseCase: GetBadgesUseCase
) : ViewModel() {

    val state: StateFlow<ProfileState> = data.state

    init {
        viewModelScope.launch {
            state.collect { currentState ->
                handleStateChange(currentState)
            }
        }
    }

    fun onScreenVisible() {
        data.onScreenVisible()
    }

    private fun handleStateChange(state: ProfileState) {
        when (state) {
            is ProfileState.Init -> getBadges()
            else -> Unit
        }
    }

    private fun getBadges() {
        viewModelScope.launch {
            val result = runCatching { getBadgesUseCase.invoke() }
            result.fold(
                onSuccess = { badges ->
                    data.onFetchSuccess(badges)
                },
                onFailure = { }
            )
        }
    }
}