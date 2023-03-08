package com.example.cookbook.presentation.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cookbook.R
import com.example.cookbook.databinding.FragmentFavoriteBinding
import com.example.cookbook.databinding.FragmentMainBinding

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        val root:View = binding.root
        return root
        //return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}