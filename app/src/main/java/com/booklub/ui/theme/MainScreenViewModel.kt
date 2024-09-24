package com.booklub.ui.theme
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class Forum(
    val title: String,
    val imageUrl: String
)

class MainScreenViewModel {
    private val _forums = MutableStateFlow<List<Forum>>(emptyList())
    val forums: StateFlow<List<Forum>> = _forums

    init {
        // Sample data to populate the list
        _forums.value = listOf(
            Forum("Tech Discussions", "https://example.com/image1.jpg"),
            Forum("Book Club", "https://example.com/image2.jpg"),
            Forum("Movie Buffs", "https://example.com/image3.jpg"),
        )
    }
}