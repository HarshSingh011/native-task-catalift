package com.example.myapplication.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentDogFragementBinding


class Dog : Fragment() {

    private lateinit var _binding: FragmentDogFragementBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDogFragementBinding.inflate(inflater, container, false)
        return _binding.root
    }

}