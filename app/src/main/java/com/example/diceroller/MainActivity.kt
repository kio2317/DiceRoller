package com.example.diceroller

// 임포트
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    // 나 앱 실행할꺼야!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**버튼과 텍트뷰.kt
         * 24번줄 activity의 id = button과 연결한다.
         * 25번줄 setOnClickListener 버튼을 눌렀을때 동작하는 것 같은 코드.
         * 26번줄  toast메시지를 출력하자.
         * 28번줄 activity의 id = textview랑 연결한다.
         * 29번줄 6이라는 숫자를 화면에 보여줘라.
         * 30번줄 rollDice함수 -->34번째 함수 연결
         * **/
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "주사위를 굴렸어요.!", Toast.LENGTH_SHORT)
            toast.show()
            val resultTextView: TextView = findViewById(R.id.textView)
            resultTextView.text = "6"
            rollDice()
        }
    }

    /**
     * 1. 주사위.kt
     * 2. 6 숫자를 dice함수에 넣기 ?
     * 3.  넣은 것을 다시 roll함수에 넣기 ?
     * 4.  textview를 봐꿔서 보여줘라.
     * 5.  diceroll은 문자열이다.
     * **/
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
/**
 * Dice 클래스 메소드.kt
 * dice int로 변경.
 * 랜덤 1~ numsides (1~6까지 랜덤값을 보여줘라.
 * **/
    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}