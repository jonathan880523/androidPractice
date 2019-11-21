package com.example.bmicalculator

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //이전에 입력한 값을 읽어오기
        loadData()

        resultButton.setOnClickListener {
            //마지막에 입력한 내용 저장
            saveData(heightEditText.text.toString().toInt(),
                        weightEditText.text.toString().toInt())

            //결과 버튼이 클릭되면 할 일을 작성하는 부분
            /*val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)*/
            //anko로 작성
            startActivity<ResultActivity>(
                "weight" to weightEditText.text.toString(),
                "height" to heightEditText.text.toString()
            )
        }


    }

    private fun saveData(height: Int, weight: Int) {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()

        editor.putInt("KEY_HEIGHT", height)
            .putInt("KEY_WEIGHT", weight)
            .apply()
    }

    private fun loadData(){
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val height = pref.getInt("KEY_HEIGHT", 0)
        val weight = pref.getInt("KEY_WEIGHT", 0)
    }
}
