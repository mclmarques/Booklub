package com.booklub.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel: ViewModel(){
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    // State variables
    var loginState by mutableStateOf<LoginState>(LoginState.Idle)
        private set

    // Function to log in user
    fun login(email: String, password: String) {
        loginState = LoginState.Loading
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    loginState = LoginState.Success
                } else {
                    loginState = LoginState.Error(task.exception?.message ?: "Login failed")
                }
            }
    }

    // State sealed class to represent UI states
    sealed class LoginState {
        object Idle : LoginState()
        object Loading : LoginState()
        object Success : LoginState()
        data class Error(val message: String) : LoginState()
    }
}