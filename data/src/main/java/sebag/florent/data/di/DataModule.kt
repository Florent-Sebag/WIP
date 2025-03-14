package sebag.florent.data.di

import org.koin.dsl.module
import sebag.florent.data.repositories.BadgeRepositoryImpl
import sebag.florent.data.repositories.PostsRepositoryImpl
import sebag.florent.domain.repositories.BadgeRepository
import sebag.florent.domain.repositories.PostsRepository
import sebag.florent.domain.usecases.GetFeedUseCase

val dataModule = module {
    single<BadgeRepository> { BadgeRepositoryImpl() }
    single<PostsRepository> { PostsRepositoryImpl() }
}