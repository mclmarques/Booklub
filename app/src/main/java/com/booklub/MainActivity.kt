package com.booklub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.booklub.ui.SignUpScreen
import com.example.compose.BooklubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BooklubTheme {
                SignUpScreen {
                    //ForumScreen();
                }
            }
        }
    }
}
