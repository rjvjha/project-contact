package com.example.rajeevjha.contact.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rajeevjha.contact.R
import com.example.rajeevjha.contact.adapter.MessagesAdapter
import com.example.rajeevjha.contact.model.Message
import com.example.rajeevjha.contact.utils.Constants
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {

    lateinit var nickName: String
    lateinit var mAdapter: MessagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        mAdapter = MessagesAdapter()
        mAdapter.updateMessageList(getDummyMessages())

        nickName = intent.getStringExtra(Constants.NICK_NAME)

        initMessageRecyclerView()
    }

    private fun getDummyMessages(): List<Message> {
        val messageList = ArrayList<Message>(20)

        for (i in 0..5) {
            messageList.add(
                Message(
                    Constants.SENDER_MESSAGE_TYPE,
                    "Rahul", "hello", "Today at 5:30"
                )
            )

        }
        for (i in 0..5) {
            messageList.add(
                Message(
                    Constants.RECEIVER_MESSAGE_TYPE,
                    "Rajeev", "helloooo!", "Today at 5:30"
                )
            )

        }
        return messageList

    }

    private fun initMessageRecyclerView() {
        chatMessagesRecyclerView.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@ChatActivity)

        }
    }
}
