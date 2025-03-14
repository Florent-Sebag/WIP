package sebag.florent.domain.repositories

import android.net.Uri
import sebag.florent.domain.model.Badge
import sebag.florent.domain.model.Post

interface PostsRepository {

    suspend fun addPost(content: String, photoUri: Uri?) : List<Post>

    suspend fun getPostList(): List<Post>
}