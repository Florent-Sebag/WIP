package sebag.florent.domain.model

import android.net.Uri

data class Post(
    val id: String = "",
    val authorAvatar: Uri,
    val authorName: String,
    val timePosted: String,
    val content: String = "",
    val photoUri: Uri? = null,
    val likesCount: Int = 0,
    val isLiked: Boolean = false,
    val commentsCount: Int = 0,
)