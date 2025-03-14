package sebag.florent.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import sebag.florent.presentation.view.feed.FeedData
import sebag.florent.presentation.view.feed.FeedViewModel
import sebag.florent.presentation.view.profile.ProfileData
import sebag.florent.presentation.view.profile.ProfileViewModel

val presentationModule = module {

    single { FeedData() }
    viewModel { FeedViewModel(get(), get(), get()) }

    single { ProfileData() }
    viewModel { ProfileViewModel(get(), get()) }
}