package com.example.ddengjabi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.core.view.size
import kotlinx.android.synthetic.main.activity_add_player.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.mutableMapOf as mutableMapOf1

class AddPlayer : AppCompatActivity() {

    /*********************************************************/
    /************************전역 변수************************/
    /*********************************************************/
    private var order: Int = 1
    private var idx: Int = 1
    private var playerList: ArrayList<String> = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_player)

        /*****************************************************/
        /************************Event************************/
        /*****************************************************/
        //게임 시작 버튼 클릭시
        startGameButton.setOnClickListener {
            var inputedName = TextView(this)
            if(lapLayOut.isEmpty()){
                Toast.makeText(this, "플레이어를 입력해주세요.", Toast.LENGTH_LONG).show()

            }else if(idx < 3){
               Toast.makeText(this, "최소 2명의 플레이어가 필요합니다.", Toast.LENGTH_LONG).show()

            }else{
                val intent = Intent(this, stopWatch::class.java)
                intent.putStringArrayListExtra("playerList", playerList)
                startActivity(intent)

            }
        }

        //플레이어 추가 버튼 클릭시
        addInputLineFab.setOnClickListener {
            val sPlayerName = inputNameEditBox.text
            if(!sPlayerName.isEmpty()){
                val textTitle = TextView(this)
                val textView = TextView(this)
                textView.text = "${order}: ${sPlayerName}"
                textTitle.text = "순서"

                if(idx == 1){
                    lapLayOut.addView(textTitle, 0)
                    lapLayOut.addView(textView, idx)
                }else{
                    lapLayOut.addView(textView, idx)
                }
                idx++
                order++
                val inputName: String = sPlayerName.toString()
                inputNameEditBox.text = null
                playerList.add(inputName)
            }else{
                Toast.makeText(this, "이름을 입력해주세요.", Toast.LENGTH_LONG).show()
            }
        }

    }
}

