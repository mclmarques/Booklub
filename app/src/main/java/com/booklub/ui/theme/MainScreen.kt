package com.booklub.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Share

@Composable
fun ForumScreen(viewModel: MainScreenViewModel = MainScreenViewModel()) {
    val forums by viewModel.forums.collectAsState()

    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(forums.size) { index ->
            ForumCard(forums[index])
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ForumCard(forum: Forum) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = forum.title, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    IconButton(onClick = { /* TODO: Add like action */ }) {
                        Icon(Icons.Default.Favorite, contentDescription = "Like")
                    }
                    IconButton(onClick = { /* TODO: Add comment action */ }) {
                        Icon(Icons.Default.Comment, contentDescription = "Comment")
                    }
                    IconButton(onClick = { /* TODO: Add share action */ }) {
                        Icon(Icons.Default.Share, contentDescription = "Share")
                    }
                }
            }
            Image(
                painter = rememberImagePainter(forum.imageUrl),
                contentDescription = "Forum Image",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewForumScreen() {
    ForumScreen()
}
