package com.example.ddengjabi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {

    /*********************************************************/
    /************************전역 변수************************/
    /*********************************************************/
    private var resultArr: ArrayList<Int> = arrayListOf()
    private var playerList: ArrayList<String> = arrayListOf()
    private var saveMap = mutableMapOf<Int, String>()
    private var prizeNum: Int = 0;
    private var prizePlayer: String? = null
    private var stopBreak: Boolean = true

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

        for(i in 0 .. 9){
            if(stopBreak){
                for(j in 0 until(resultArr.size) step 1){
                    var compareNum = resultArr.get(j)
                    Log.d("compareNum", "${compareNum}")
                    Log.d("i", "${i}")
                    if(i == compareNum){
                        prizePlayer = saveMap.get(i)
                        stopBreak = false
                        break
                    }
                }
            }
        }
        Toast.makeText(this, "${prizePlayer}", Toast.LENGTH_SHORT).show()
        /*var keyNum = resultArr.get(prizeNum)
        prizePlayer = saveMap.get(keyNum)*/

        pickedNameTextView.text = prizePlayer

        /*****************************************************/
        /************************Event************************/
        /*****************************************************/
        //결과보기 버튼 클릭시
        showResultButton.setOnClickListener {
            for(i in 0 until(resultArr.size) step 1){
                var textView = TextView(this)
                textView.text = "${playerList.get(i)}: ${resultArr.get(i)}";
                resultLayOut.addView(textView)
            }
        }
    }


}
