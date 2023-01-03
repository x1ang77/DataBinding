package com.xiangze.databinding.ui

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.xiangze.databinding.R
import com.xiangze.databinding.databinding.FragmentMainBinding
import com.xiangze.databinding.model.Task
import com.xiangze.databinding.viewModels.MainViewModel

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner //could be "this"
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val task = Task(0, "Data Binding", "We are learning data binding")
        binding.task = task

        viewModel.gotoLogin.asLiveData().observe(viewLifecycleOwner) {
            Log.d("debugging", "SharedFlow")
            val action = MainFragmentDirections.actionHomeToLogin()
            NavHostFragment.findNavController(this).navigate(action)
        }

        viewModel.counter.observe(viewLifecycleOwner) {
            Log.d("debugging", "Counter: $it")
        }

        binding.btnShowAlert.setOnClickListener {
            val alertDialog =
                MaterialAlertDialogBuilder(requireContext(), R.style.DataBinding_AlertDialog)
                    .setTitle("Alert dialog title")
                    .setMessage("Alert Dialog Message. Custom Design.")
                    .setPositiveButton("Positive") { _, _ ->

                    }.create()

            alertDialog.show()

            val btnPositive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)
            val layout = btnPositive.parent as LinearLayout
            layout.gravity = Gravity.CENTER_HORIZONTAL
            layout.getChildAt(0).visibility = View.GONE
        }
    }
}