package sebag.florent.presentation.view.feed.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sebag.florent.domain.model.Post

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FeedComposable(
    posts: List<Post>,
    onClickFloatButton: () -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingButtonComposable(
                onClick = { onClickFloatButton() }
            )
       },
    ) {
        PostListComposable(posts)
    }
}

@Composable
fun PostListComposable(posts: List<Post>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(posts) { post, ->
            PostCardComposable(
                post = post,
                onLikeClicked = { /*onLikeClicked(post.id)*/ },
                onCommentClicked = { /*onCommentClicked(post.id)*/ },
                onShareClicked = { /*onShareClicked(post.id)*/ }
            )
        }
    }
}

@Composable
fun PostCardComposable(
    post: Post,
    onLikeClicked: () -> Unit,
    onCommentClicked: () -> Unit,
    onShareClicked: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            PostCardHeaderComposable(post)
            Spacer(modifier = Modifier.height(12.dp))
            PostCardContentComposable(post)
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 12.dp)
            )
            PostCardBottomComposable(post, onLikeClicked, onCommentClicked, onShareClicked)
        }
    }
}
