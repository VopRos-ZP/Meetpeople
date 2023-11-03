package com.meetpeople.views.root

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.meetpeople.R
import com.meetpeople.databinding.FragmentRootBinding
import com.meetpeople.ext.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootFragment : Fragment() {

    private lateinit var binding: FragmentRootBinding
    private val viewModel: RootViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRootBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rootNavHost =
            parentFragmentManager.findFragmentById(binding.rootNavFragment.id) as NavHostFragment
        val rootNavController = rootNavHost.navController

        binding.bottomNavigation.setupWithNavController(
            navController = rootNavController,
            navGraphIds = listOf(
                R.navigation.home_nav_graph,
                R.navigation.dialogs_nav_graph,
                R.navigation.create_meeting_nav_graph,
                R.navigation.notification_nav_graph,
                R.navigation.profile_nav_graph
            ),
            fragmentManager = childFragmentManager,
            containerId = binding.rootNavFragment.id,
            intent = requireActivity().intent
        )
    }

}