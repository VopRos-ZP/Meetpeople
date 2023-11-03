package com.meetpeople.views.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.meetpeople.R
import com.meetpeople.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModel.viewState.collect { state ->
                when (state) {
                    is SplashViewState.Loading -> {}
                    is SplashViewState.Error -> {}
                    is SplashViewState.Success -> {
                        val navController = Navigation.findNavController(requireActivity(), R.id.mainNavHostFragment)
                        val mainGraph = navController.navInflater.inflate(R.navigation.root_nav_graph)
                        mainGraph.setStartDestination(when (state.isSign) {
                            true -> R.id.rootFragment
                            else -> R.id.auth_graph
                        })
                        navController.graph = mainGraph
                    }
                }
            }
        }
        viewModel.intent(SplashViewIntent.Launch)
    }

}