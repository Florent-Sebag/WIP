package sebag.florent.presentation.view.feed.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.automirrored.outlined.Comment
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import sebag.florent.domain.model.Post

@Composable
fun PostCardBottomComposable(
    post: Post,
    onLikeClicked : () -> Unit = {},
    onCommentClicked : () -> Unit = {},
    onShareClicked : () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        LikeButton(post.isLiked, onLikeClicked)
        ActionButton(Icons.AutoMirrored.Outlined.Comment, "Comment", onCommentClicked)
        ActionButton(Icons.AutoMirrored.Filled.Send, "Share", onShareClicked)
    }
}

@Composable
fun LikeButton(isLiked: Boolean, onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = if (isLiked) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                contentDescription = "Like",
                tint = if (isLiked) Color.Red else MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
fun ActionButton(icon: ImageVector, text: String, onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = icon, contentDescription = text)
        }
    }
}