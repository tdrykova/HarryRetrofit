package com.tatry.harryretrofit.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.tatry.harryretrofit.R
import com.tatry.harryretrofit.databinding.FragmentCageBinding
import com.tatry.harryretrofit.databinding.FragmentMainBinding

class CageFragment : Fragment() {

    private var _binding: FragmentCageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvCage.setOnClickListener {
            findNavController().navigate(R.id.action_cageFragment_to_receptionFragment)
        }
    }
}