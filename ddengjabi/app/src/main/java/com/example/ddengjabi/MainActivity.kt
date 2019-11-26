package com.example.ddengjabi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //플레이어 추가 버튼 클릭시
        addPlayerFab.setOnClickListener {
            val intent = Intent(this, AddPlayer::class.java);
            startActivity(intent);
        }

        //게임 시작 버튼 클릭시
        startButton.setOnClickListener {
            val intent = Intent(this, stopWatch::class.java);
            startActivity(intent);
        }
    }
}

//TODO 화면 이동까지만 마무리됨 버튼 이벤트, 기능들 추가필요