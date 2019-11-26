package com.example.ddengjabi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_player.*

class AddPlayer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_player)

        //게임 시작 버튼 클릭시
        startGameButton.setOnClickListener {
            val intent = Intent(this, stopWatch::class.java);
            startActivity(intent);
        }
    }
}

