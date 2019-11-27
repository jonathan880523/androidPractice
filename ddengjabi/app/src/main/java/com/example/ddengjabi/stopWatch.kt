package com.example.ddengjabi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_stop_watch.*

class stopWatch : AppCompatActivity() {

    private var playerList: List<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stop_watch)

        //결과보기 버튼 클릭시
        resultFab.setOnClickListener {
            val intent = Intent(this, Result::class.java);
            startActivity(intent);
        }

        //처음엔 결과 버튼 hide
        resultFab.hide()

        //등록된 선수가 있는지 없는지 체크
        if(intent.hasExtra("playerList")){
            //선수가 있으면 첫 선수부터 시작
            playerList = intent.getStringArrayListExtra("playerList")

            playerName.text = playerList[0]
        }else{
            //등록된 선수가 없으면 선수등록 엑티비티로 이동
            Toast.makeText(this, "플레이어를 먼저 등록해주세요.", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, AddPlayer::class.java)
            startActivity(intent)
        }


    }

}
