package com.tatry.harryretrofit.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tatry.harryretrofit.databinding.FragmentDbBinding

class DbFragment : Fragment() {

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
//        lifecycleScope.launch {
////            viewModel.allCharacters.collect{
//            viewModel.characters.collect{
//                binding.textView.text = it.joinToString(separator = "\r\n")
//            }
//        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}