package com.xiangze.databinding.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.xiangze.databinding.R
import com.xiangze.databinding.databinding.FragmentHomeBinding
import com.xiangze.databinding.models.Task
import com.xiangze.databinding.viewModel.HomeViewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val task = Task(0, "Data Binding", "We are learning data binding")
        binding.task = task

        binding.btnAlert.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext(), R.style.DataBinding_AlertDialog)
                .setTitle("Alert Dialog Title")
                .setMessage("Alert Dialog Message. Custom Design")
                .setPositiveButton("Positive") { _, _ ->

                }.create().show()
        }
    }
}

// JIT compiler