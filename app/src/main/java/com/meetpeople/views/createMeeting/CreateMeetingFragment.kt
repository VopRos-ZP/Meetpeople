package com.meetpeople.views.createMeeting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.meetpeople.databinding.FragmentCreateMeetingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateMeetingFragment : Fragment() {

    private lateinit var binding: FragmentCreateMeetingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateMeetingBinding.inflate(inflater, container, false)
        return binding.root
    }

}