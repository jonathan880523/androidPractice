package com.example.ddengjabi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_stop_watch.*
import java.util.*
import kotlin.concurrent.timer

class stopWatch : AppCompatActivity() {

    /*********************************************************/
    /************************전역 변수************************/
    /*********************************************************/

    private var playerList: ArrayList<String> = arrayListOf()
    private var timeList: ArrayList<Int> = arrayListOf()
    private var playerNo: Int = 0;
    private var playerCnt: Int = 0;

    //타이머 동작을 위한 변수
    private var time = 0;
    private var timerTask: Timer? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stop_watch)

        /******************************************************/
        /************************초기화************************/
        /******************************************************/
        //처음엔 결과 버튼 hide
        resultFab.hide()

        //등록된 선수가 있는지 없는지 체크
        if(intent.hasExtra("playerList")){
            //선수가 있으면 첫 선수부터 시작
            playerList = intent.getStringArrayListExtra("playerList")

            //게임 시작 후 첫 번째는 무조건 1번째 선수로 시작
            showName()
            playerCnt = playerList.count()      //등록된 선수의 수
            //화면 이동 되면 바로 숫자 카운팅
            start()

        }else{
            //등록된 선수가 없으면 선수등록 엑티비티로 이동
            Toast.makeText(this, "플레이어를 먼저 등록해주세요.", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, AddPlayer::class.java)
            startActivity(intent)
        }

        /*****************************************************/
        /************************Event************************/
        /*****************************************************/

        //땡잡이 버튼 클릭시
        saveTimeButton.setOnClickListener {
            var stopedTime = this.time
            var lapMilli = stopedTime % 100     //멈춘 milli
            var tens = lapMilli/10              //10의 자리 숫자
            var ones = lapMilli - (tens * 10)   //1의 자리 숫자
            var plus: Int = tens + ones;        //두 수의 합
            if(plus >= 10){
                plus = plus - 10                //두 수의 합 중 일의자리만 필요
            }

            //결과값을 Toast로 표시
            Toast.makeText(this, "${plus}", Toast.LENGTH_SHORT).show()
            //timeList에 선수 순서별로 시간 저장
            timeList.add(playerNo, plus)

            if(playerNo == playerCnt - 1){   //마지막 선수가 끝나면 숫자 멈춤
                stop()
            }else{
                playerNo++
                //다음 선수 보여줌
                showName()
            }
        }

        //결과 버튼 클릭시
        resultFab.setOnClickListener {
            intent = Intent(this, Result::class.java)
            intent.putIntegerArrayListExtra("result", timeList)
            intent.putStringArrayListExtra("player", playerList)
            startActivity(intent)

        }

    }//end onCreat

    /*********************************************************/
    /************************Functions************************/
    /*********************************************************/
    //숫자 카운팅
    private fun start(){
        timerTask = timer(period = 10){
            time++;

            val sec = time / 100
            val milli = time % 100

            runOnUiThread{
                secTextView.text = "${sec}"
                milliTextView.text = "${milli}"
            }
        }
    }

    //타이머 정지 및 초기화
    private fun stop(){
        timerTask?.cancel()                  //시간 멈춤
        secTextView.text = "0"                //숫자 초기화
        milliTextView.text = "00"
        saveTimeButton.isEnabled = false     //땡잡이 버튼 disable
        Toast.makeText(this, "모든 플레이어가 숫자를 정했습니다. 결과 버튼을 클릭해 주세요.", Toast.LENGTH_LONG).show()
        resultFab.show()                      //결과 버튼 visible
    }

    //플레이할 플레이어 보여주기
    private fun showName(){
        playerName.text = "player ${playerNo + 1}  ${playerList[playerNo]}"
    }

}
