package com.meetpeople.views.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.meetpeople.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.intent(ProfileViewIntent.Launch)
        lifecycleScope.launch {
            viewModel.viewState.collect {
                when (it) {
                    is ProfileViewState.Loading -> {}
                    is ProfileViewState.Error -> {}
                    is ProfileViewState.Success -> {
                        binding.usernameView.text = "${it.person.lastname} ${it.person.firstname}"
                    }
                }
            }
        }
    }

}