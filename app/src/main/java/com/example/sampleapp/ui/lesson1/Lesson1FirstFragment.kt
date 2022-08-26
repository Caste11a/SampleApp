package com.example.sampleapp.ui.lesson1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.sampleapp.R
import com.example.sampleapp.databinding.FragmentLesson1FirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class Lesson1FirstFragment : Fragment() {

    private var _binding: FragmentLesson1FirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLesson1FirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // クリックリスナーを設定する
        view.findViewById<Button>(R.id.button_first).setOnClickListener{
            val myToast = Toast.makeText(context, "Hello Toast!", Toast.LENGTH_SHORT)
            myToast.show()
        }

        // カウントする
        view.findViewById<Button>(R.id.button_second).setOnClickListener{
            countMe(view)
        }

        // Lesson1SecondFragmentに遷移
        view.findViewById<Button>(R.id.button_third).setOnClickListener{
            val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
            val currentCount = showCountTextView.text.toString().toInt()
            val action = Lesson1FirstFragmentDirections.actionLesson1FirstFragmentToLesson1SecondFragment(currentCount)
            findNavController().navigate(action)
        }

        // DiceRollerに遷移
        view.findViewById<Button>(R.id.button_DiceRoller).setOnClickListener{
            val action = Lesson1FirstFragmentDirections.actionLesson1FirstFragmentToLesson1DiceRollerFragment()
            findNavController().navigate(action)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // カウントする
    private fun countMe(view: View){
        val showCountTextView = view.findViewById<TextView>(R.id.textview_first)

        val countString = showCountTextView.text.toString()

        var count = countString.toInt()
        count++

        showCountTextView.text = count.toString()
    }
}