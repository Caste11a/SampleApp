package com.example.sampleapp.ui.lesson1

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

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class Lesson1SecondFragment : Fragment() {

    private var _binding: FragmentLesson1SecondBinding? = null
    val args:Lesson1SecondFragmentArgs by navArgs()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLesson1SecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_lesson1FirstFragment_to_lesson1SecondFragment)
        }

        val count = args.num
        val countText = getString(R.string.random_heading, count)
        view.findViewById<TextView>(R.id.textview_header).text = countText

        val random = java.util.Random()
        var randomNumber = 0
        if (count > 0){
            randomNumber = random.nextInt(count + 1)
        }
        view.findViewById<TextView>(R.id.textview_random).text = randomNumber.toString()


        view.findViewById<Button>(R.id.button_second).setOnClickListener{
            val action = Lesson1SecondFragmentDirections.actionLesson1SecondFragmentToLesson1FirstFragment()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}