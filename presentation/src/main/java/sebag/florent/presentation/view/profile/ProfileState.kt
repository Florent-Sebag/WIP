package sebag.florent.presentation.view.profile

import sebag.florent.domain.model.Badge

sealed class ProfileState {

    data object Init : ProfileState()
    data object Loading : ProfileState()
    data object Success : ProfileState()

    data class FetchSuccess(val badges: List<Badge>): ProfileState()

}