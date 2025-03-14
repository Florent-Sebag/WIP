package sebag.florent.domain.usecases

import sebag.florent.domain.model.Post
import sebag.florent.domain.repositories.PostsRepository

class GetFeedUseCase(private val postRepository: PostsRepository) {

    suspend operator fun invoke(): List<Post> = postRepository.getPostList()
}