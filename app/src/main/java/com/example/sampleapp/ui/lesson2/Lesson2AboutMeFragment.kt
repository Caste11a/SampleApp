package com.example.sampleapp.ui.lesson2

import android.content.Context
import android.content.Context.*
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
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

        // 関数をボタンにアタッチする
        view.findViewById<Button>(R.id.done_button).setOnClickListener{
            addNickName(view)
        }

        // ニックネームの編集用
        view.findViewById<TextView>(R.id.nickname_text).setOnClickListener {
            updateNickname(view)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Doneボタン押下後の処理
    private fun addNickName(view: View)
    {
        val editText = view.findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = view.findViewById<TextView>(R.id.nickname_text)
        val doneButton = view.findViewById<Button>(R.id.done_button)

        nicknameTextView.text = editText.text
        // 編集テキスト、ボタンを非表示にする
        editText.visibility = View.GONE
        doneButton.visibility = View.GONE
        // ニックネームテキストを表示する
        nicknameTextView.visibility = View.VISIBLE

        // キーボードを非表示にする
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    // update editText
    private fun updateNickname(view: View) {
        val editText = view.findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = view.findViewById<TextView>(R.id.nickname_text)
        val doneButton = view.findViewById<Button>(R.id.done_button)

        // 編集テキストを表示
        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        // ニックネームテキスト・登録ボタンを非表示
        nicknameTextView.visibility = View.GONE

        editText.requestFocus()

        // キーボードの表示
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)

    }
}