package com.tatry.harryretrofit.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.tatry.harryretrofit.R
import com.tatry.harryretrofit.databinding.FragmentDbBinding
import kotlinx.coroutines.launch

class DbFragment : Fragment() {

//    private val viewModel: DbViewModel by viewModels{
//        DbViewModelFactory()
//    }

    private val viewModel: DbViewModel by viewModels()

    private var _binding: FragmentDbBinding?= null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDbBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val applicationSingleton = requireActivity().application

//        viewModel.initDao(requireActivity().application)
        viewModel.initDao(activity?.application)

        binding.btnAdd.setOnClickListener { viewModel.onBtnAdd() }
        binding.btnUpdate.setOnClickListener { viewModel.onBtnUpdate() }
        binding.btnDelete.setOnClickListener { viewModel.onBtnDelete() }

        // подписываемся на поток (собираем приходящие данные)
        lifecycleScope.launch {
//            viewModel.allCharacters.collect{
            viewModel.characters.collect{
                binding.textView.text = it.joinToString(separator = "\r\n")
            }
        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}