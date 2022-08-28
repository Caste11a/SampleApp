package com.example.sampleapp.ui.lesson2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.sampleapp.databinding.FragmentLesson1SecondBinding
import androidx.navigation.fragment.navArgs
import com.example.sampleapp.R
import com.example.sampleapp.databinding.FragmentLesson2AboutmeBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class Lesson2AboutMeFragment : Fragment() {

    private var _binding: FragmentLesson2AboutmeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLesson2AboutmeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}