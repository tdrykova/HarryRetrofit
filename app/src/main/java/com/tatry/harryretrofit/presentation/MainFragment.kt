package com.tatry.harryretrofit.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import coil.load
import com.tatry.harryretrofit.R
import com.tatry.harryretrofit.databinding.FragmentMainBinding
import kotlinx.coroutines.launch

private const val TAG = "MainFragment555"

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory()
    }
//    viewModel = ViewModelProvider(this)[MainViewModel::class.java]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.character.collect {
                with(binding) {
                    tvName.text = it.name
                    tvHouse.text = it.hogwartsHouse
                    imageCharacter.load(it.imageUrl)
                }

            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect {
                when (it) {
                    ProgressState.Loading -> binding.progressBar.isVisible = true
                    ProgressState.Success -> binding.progressBar.isVisible = false
                }
            }
        }

        binding.btnRandom.setOnClickListener {
//            viewModel.randomCharacter()
            // для вызова фрагмента из фрагмента - родитель: активити
            parentFragmentManager.commit {
                replace<DbFragment>(R.id.fragment_container)
                addToBackStack(DbFragment::class.java.simpleName)
            }
//            parentFragmentManager.popBackStack()
        }

//        binding.tvFromActivity.text = arguments?.getString(KEY_FOR_STRING)
        binding.tvFromActivity.text = arguments?.getParcelable(KEY_FOR_STRING)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        private const val KEY_FOR_STRING = "data activity"
        fun newInstance(obj: DataForTransfer): Fragment {
//            args.putString(KEY_FOR_STRING, VALUE_FROM_ACTIVITY)
            return MainFragment().apply {
                arguments = Bundle().apply {
//                    putString(KEY_FOR_STRING, str)
                    putParcelable(KEY_FOR_STRING, obj)
                }
            }
//            fragment.arguments = args
        }

    }

}