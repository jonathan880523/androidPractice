package com.example.ddengjabi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class Result : AppCompatActivity() {

    /*********************************************************/
    /************************전역 변수************************/
    /*********************************************************/
    private var resultArr: ArrayList<Int> = arrayListOf()
    private var playerList: ArrayList<String> = arrayListOf()
    private var saveMap = mutableMapOf<Int, String>()
    private var sortMap = mutableMapOf<String, Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        /******************************************************/
        /************************초기화************************/
        /******************************************************/

        //결과값 받아오기
        resultArr = intent.getIntegerArrayListExtra("result")
        playerList = intent.getStringArrayListExtra("player")

        for (i in 0 until(resultArr.size) step 1){
            //맵에 값 저장
            saveMap.put(resultArr.get(i), playerList.get(i))
        }

        //TODO 솔팅할 차례
    }
}
