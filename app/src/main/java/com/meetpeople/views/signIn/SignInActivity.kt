package com.meetpeople.views.signIn

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.meetpeople.databinding.SignInActivityBinding
import com.meetpeople.views.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignInActivity : AppCompatActivity() {

    private lateinit var binding: SignInActivityBinding
    private val viewModel: SignInViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignInActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            viewModel.viewState.collect {
                when (it) {
                    is SignInViewState.Loading -> {/* No action */}
                    is SignInViewState.Success -> {
                        /* navigate to main screen */
                        val intent = Intent(applicationContext, MainActivity::class.java)
                        startActivity(intent)
                    }
                    is SignInViewState.Error -> {
                        /* Show error */
                        Toast.makeText(
                            applicationContext,
                            it.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }

        binding.signInBtn.setOnClickListener {
            val phone = binding.phoneEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            viewModel.intent(SignInViewIntent.SignIn(phone, password))
        }
    }

}