package com.tatry.harryretrofit.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.tatry.harryretrofit.R
import com.tatry.harryretrofit.databinding.FragmentReceptionBinding
import com.tatry.harryretrofit.databinding.FragmentRestRoomBinding

class RestRoomFragment : Fragment() {

    private var _binding: FragmentRestRoomBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rest_room, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvRest.setOnClickListener {
            findNavController().navigate(R.id.action_restRoomFragment_to_cageFragment)
        }
    }
}