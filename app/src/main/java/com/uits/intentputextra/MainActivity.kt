package com.uits.intentputextra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mEdtValueA: EditText

    companion object {
        val RESULT_SUMMATION = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // init view
        mEdtValueA = findViewById(R.id.mEdtValueA)

        mBtnNext.setOnClickListener {
            var a = mEdtValueA.text.toString().toInt()
            var b = mEdtValueB.text.toString().toInt()
            // start
            var intentNext = Intent(this@MainActivity, CulaActivity::class.java)
            intentNext.putExtra("a", a)
            intentNext.putExtra("b", b)
            startActivity(intentNext)
        }

        mBtnNextResult.setOnClickListener {
            var a = mEdtValueA.text.toString().toInt()
            var b = mEdtValueB.text.toString().toInt()
            // start
            var intentNext = Intent(this@MainActivity, CulaActivity::class.java)
            intentNext.putExtra("a", a)
            intentNext.putExtra("b", b)
            startActivityForResult(intentNext, RESULT_SUMMATION)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RESULT_SUMMATION) {
            var result = data?.getIntExtra("result", 0)
            mTvResult.setText("${result}")
        }

    }
}