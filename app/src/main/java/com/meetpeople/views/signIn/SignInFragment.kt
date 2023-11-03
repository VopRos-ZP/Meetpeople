package com.meetpeople.views.signIn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.meetpeople.R
import com.meetpeople.databinding.FragmentSignInBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding
    private val viewModel: SignInViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        lifecycleScope.launch {
            viewModel.viewState.collect {
                when (it) {
                    is SignInViewState.Loading -> {/* No action */}
                    is SignInViewState.Success -> {
                        /* navigate to main screen */
                        navController.popBackStack(R.id.auth_graph, true)
                        navController.navigate(R.id.home_nav_graph)
                    }
                    is SignInViewState.Error -> {
                        /* Show error */
                        Toast.makeText(
                            context,
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