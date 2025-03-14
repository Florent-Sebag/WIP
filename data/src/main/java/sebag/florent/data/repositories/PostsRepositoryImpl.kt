package sebag.florent.data.repositories

import android.net.Uri
import androidx.core.net.toUri
import io.bloco.faker.Faker
import sebag.florent.domain.model.Post
import sebag.florent.domain.repositories.PostsRepository
import java.util.UUID

class PostsRepositoryImpl : PostsRepository {
    private val faker = Faker()
    private val posts = mutableListOf<Post>()

    init {
        generateMockPosts()
    }

    override suspend fun addPost(content: String, photoUri: Uri?) : List<Post> {
        posts.add(
            index = 0,
            Post(
                id = UUID.randomUUID().toString(),
                authorAvatar = "https://picsum.photos/300/200?random=$51".toUri(),
                authorName = "Marvin from 42",
                timePosted = "Now",
                content = content,
                photoUri = photoUri,
            )
        )
        return posts
    }

    override suspend fun getPostList(): List<Post> = posts.toList()

    private fun generateMockPosts() {
        repeat(20) { index ->
            posts.add(
                Post(
                    id = UUID.randomUUID().toString(),
                    authorAvatar = faker.company.logo().toUri(),
                    authorName = faker.name.firstName(),
                    timePosted = faker.date.backward(numberOfDays = 30).toString(),
                    content = faker.lorem.paragraph(),
                    photoUri = if (faker.bool.bool()) "https://picsum.photos/300/200?random=$index".toUri() else null,
                    likesCount = faker.number.between(0, 1000),
                    isLiked = faker.bool.bool(),
                    commentsCount = faker.number.between(0, 500)
                )
            )
        }
    }
}