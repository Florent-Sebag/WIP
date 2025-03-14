package sebag.florent.domain.usecases

import android.net.Uri
import sebag.florent.domain.model.Post
import sebag.florent.domain.repositories.BadgeRepository
import sebag.florent.domain.repositories.PostsRepository

class CreatePostUseCase(
    private val postRepository: PostsRepository,
    private val badgeRepository: BadgeRepository
) {

    suspend operator fun invoke(content: String, photoUri: Uri?) : List<Post> {
        badgeRepository.incrementUserPostNumber()
        return postRepository.addPost(content, photoUri)
    }
}