package sebag.florent.presentation.view.profile

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import sebag.florent.domain.model.Badge

class ProfileData {

    private val _state = MutableStateFlow<ProfileState>(ProfileState.Init)
    val state: StateFlow<ProfileState> = _state

    private fun updateState(newState: ProfileState) {
        _state.value = newState
    }

    fun onFetchSuccess(badges: List<Badge>) {
        updateState(ProfileState.FetchSuccess(badges))
    }

    fun onScreenVisible() {
        updateState(ProfileState.Init)
    }
}
