package com.example.cookbook.presentation.ui.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cookbook.R
import com.example.cookbook.databinding.FragmentMyRecipesBinding
import com.example.cookbook.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSettingsBinding.inflate(inflater, container,false)
        val root:View = binding.root
        return root
        //return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}