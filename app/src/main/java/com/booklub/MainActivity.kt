package com.booklub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.booklub.ui.LoginScreen
import com.booklub.ui.SignUpScreen
import com.booklub.ui.theme.BooklubTheme
import com.booklub.ui.theme.ForumScreen
import com.booklub.ui.theme.MainScreenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BooklubTheme {
                SignUpScreen {
                    ForumScreen();
                }
            }
        }
    }
}
