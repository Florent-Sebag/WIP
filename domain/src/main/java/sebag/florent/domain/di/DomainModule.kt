package sebag.florent.domain.di

import org.koin.dsl.module
import sebag.florent.domain.usecases.CreatePostUseCase
import sebag.florent.domain.usecases.GetBadgesUseCase
import sebag.florent.domain.usecases.GetFeedUseCase

val domainModule = module {
    factory { GetBadgesUseCase(get()) }

    factory { CreatePostUseCase(get(), get()) }

    factory { GetFeedUseCase(get()) }
}