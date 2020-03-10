package com.uss.my_first_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.*
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        send_msg_to_activity.setOnClickListener{

            var msg: String = et.text.toString()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("user_msg", msg)
            startActivity(intent)
        }

        btn_other_app.setOnClickListener{

            val msg = et.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, msg)
            intent.type= "text/plain"
            startActivity(Intent.createChooser(intent, "Share to :"))
        }
    }
}
