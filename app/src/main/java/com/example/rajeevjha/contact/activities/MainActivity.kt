package com.example.rajeevjha.contact.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rajeevjha.contact.R
import com.example.rajeevjha.contact.utils.Constants
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nickName = nickNameEditText.text.toString()
        val intent = Intent(this, ChatActivity::class.java)
        intent.apply {
            putExtra(Constants.NICK_NAME, nickName)
        }

        connectButton.setOnClickListener {
            startActivity(intent)
        }
    }
}
