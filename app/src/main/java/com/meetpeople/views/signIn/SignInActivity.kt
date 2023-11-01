package com.meetpeople.views.signIn

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.meetpeople.databinding.SignInActivityBinding
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

//        lifecycleScope.launch {
//            viewModel.viewState.collect {
//                when (it) {
//                    is SignInViewState.Loading -> {/* No action */}
//                    is SignInViewState.Success -> {/* navigate to main screen */}
//                    is SignInViewState.Error -> {/* Show error */}
//                }
//            }
//        }

        binding.signInBtn.setOnClickListener {
            val phone = binding.phoneEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            viewModel.intent(SignInViewIntent.SignIn(phone, password))
        }
    }

}