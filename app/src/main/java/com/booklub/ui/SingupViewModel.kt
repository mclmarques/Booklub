package com.booklub.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class SingupViewModel: ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    var signUpState by mutableStateOf<SignUpState>(SignUpState.Idle)
        private set

    fun signUp(email: String, password: String) {
        signUpState = SignUpState.Loading
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    signUpState = SignUpState.Success
                } else {
                    signUpState = SignUpState.Error(task.exception?.message ?: "Sign-up failed")
                }
            }
    }

    sealed class SignUpState {
        object Idle : SignUpState()
        object Loading : SignUpState()
        object Success : SignUpState()
        data class Error(val message: String) : SignUpState()
    }
}