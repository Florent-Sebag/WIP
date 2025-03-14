package sebag.florent.presentation.view.feed.ui

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CreatePostModalComposable(
    onPostCreated: (String, Uri?) -> Unit,
    onDismiss: () -> Unit
) {
    var postContent by remember { mutableStateOf("") }
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->
            selectedImageUri = uri
        }
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "New post",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp).align(Alignment.CenterHorizontally)
        )

        Button(
            onClick = {
                launcher.launch("image/*")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Icon(imageVector = Icons.Default.Image, contentDescription = "Choose a picture")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Choose a picture")
        }

        TextField(
            value = postContent,
            onValueChange = { postContent = it },
            label = { Text("Description") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .heightIn(min = 100.dp, max = 300.dp),
            maxLines = 10
        )

        Button(
            onClick = {
                onPostCreated(
                    postContent,
                    selectedImageUri
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Publish") }

        TextButton(
            onClick = onDismiss,
            modifier = Modifier.fillMaxWidth()
        ) { Text("Cancel") }
    }
}