package com.example.ddengjabi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_stop_watch.*

class stopWatch : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stop_watch)

        //결과보기 버튼 클릭시
        resultFab.setOnClickListener {
            val intent = Intent(this, Result::class.java);
            startActivity(intent);
        }
    }
}
