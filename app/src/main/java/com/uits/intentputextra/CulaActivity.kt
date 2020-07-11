package com.uits.intentputextra

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_cula.*

/**
 * Result  Activity
 * Copyright © 2019 UITS CO.,LTD
 * Created PHUQUY on 7/11/20.
 **/
class CulaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cula)

        var a = intent.getIntExtra("a", 0)
        var b = intent.getIntExtra("b", 0)

        mTvContent.setText("Value a ${a} add Valua b ${b} = ${a + b}")

        mBtnResult.setOnClickListener {
            var intentResult = Intent()
           // var bundle = Bundle()
            intentResult.putExtra("result", (a + b))
            // result data by intent and bundle
            setResult(MainActivity.RESULT_SUMMATION, intentResult)
            finish()
        }
    }
}