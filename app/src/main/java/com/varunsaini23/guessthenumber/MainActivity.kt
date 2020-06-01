package com.varunsaini23.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Visibility
import android.util.Log
import android.view.View
import android.widget.*
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    private lateinit var hint_tv : TextView
    private lateinit var answer_et : EditText
    private lateinit var start_game_btn : Button
    private lateinit var chk_ans_btn : Button
    private lateinit var result_iv : ImageView

    private  var randoms : Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        Glide.with(this).asGif().load(R.drawable.welcome).into(result_iv);
    }

    private fun initViews() {
        hint_tv = findViewById(R.id.hint_tv)
        answer_et = findViewById(R.id.answer_et)
        start_game_btn = findViewById(R.id.start_game_btn)
        chk_ans_btn = findViewById(R.id.chk_ans_btn)
        result_iv = findViewById(R.id.result_iv)
    }

    fun startGame(view: View) {
        randoms = (10..99).random()
        Log.d("CHK",randoms.toString())
        val a = randoms%10
        val randomss = randoms/10
        val b = randomss%10
        hint_tv.text = "I am a two digit number. When you :\n\n1. multiply my digits, you get ${a*b} and \n2. add my digits, you get ${a+b}. \n\nGuess me ??"
        hint_tv.visibility = View.VISIBLE
        answer_et.visibility = View.VISIBLE
        hint_tv.visibility = View.VISIBLE
        chk_ans_btn.visibility = View.VISIBLE
        result_iv.visibility = View.GONE
        answer_et.text.clear()
    }

    fun chk_ans(view: View) {
        result_iv.visibility = View.VISIBLE
        val value = answer_et?.text.trim().toString()
        if(value.isNotBlank()){
            Log.d("Check", value)
            answer_et.text.isNotEmpty()
            if(randoms==value.toInt() || randoms.toString().reversed()==value){
                Log.d("INSIDE If","INSIDE")
                Glide.with(this).asGif().load(R.drawable.won).into(result_iv)
            }else{
                Log.d("INSIDE Else","INSIDE")
                Glide.with(this).asGif().load(R.drawable.lose).into(result_iv)
            }
            start_game_btn.text = "Play Again"
        }else{
            result_iv.visibility = View.GONE
        }


    }
}
