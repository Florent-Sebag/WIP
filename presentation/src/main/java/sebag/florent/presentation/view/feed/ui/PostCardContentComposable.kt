package sebag.florent.presentation.view.feed.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import sebag.florent.domain.model.Post

@Composable
fun PostCardContentComposable(post: Post) {
    if (post.content.isNotEmpty()) {
        Text(
            text = post.content,
            fontSize = 14.sp,
            modifier = Modifier.padding(vertical = 4.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
    }

    // **Image du post**
    post.photoUri?.let { uri ->
        AsyncImage(
            model = uri,
            contentDescription = "Image du post",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${post.likesCount} Likes",
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "${post.commentsCount} Comments",
            fontSize = 12.sp
        )
    }
}