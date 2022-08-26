package com.example.sampleapp.ui.lesson1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.sampleapp.databinding.FragmentLesson1DicerollerBinding
import androidx.navigation.fragment.navArgs
import com.example.sampleapp.R


class Lesson1DiceRollerFragment :Fragment(){

    private var _binding: FragmentLesson1DicerollerBinding? = null

    // ImageViewオブジェクトを格納する。viewが必要なのでlateinitをつける。
    private lateinit var diceImage : ImageView

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLesson1DicerollerBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Viewの初期化
        view.findViewById<Button>(R.id.button_roll).setOnClickListener{
            diceImage = view.findViewById(R.id.dice_image)
            // ダイスを降り、適切な画像に切り替わる
            rollDice(diceImage)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun rollDice(diceImage: ImageView){
        val randomInt = (1..6).random()

        val drawableResource = when (randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // 画像を更新する
        diceImage.setImageResource(drawableResource)

    }
}