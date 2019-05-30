package com.example.rajeevjha.contact.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rajeevjha.contact.R
import com.example.rajeevjha.contact.model.Message
import com.example.rajeevjha.contact.utils.Constants
import java.util.*

class MessagesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var messagesList: List<Message> = ArrayList()

    companion object {
        const val TYPE_SENDER = 0
        const val TYPE_RECEIVER = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            TYPE_SENDER -> LeftViewHolder(layoutInflater.inflate(R.layout.right_item_message, parent, false))
            else -> RightViewHolder(layoutInflater.inflate(R.layout.left_item_message, parent, false))
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = messagesList.get(position)

        when (holder) {
            is LeftViewHolder -> {
                holder.timeStampTextView.text = message.lastUpdated
                holder.messageTextView.text = message.text
            }
            is RightViewHolder -> {
                holder.timeStampTextView.text = message.lastUpdated
                holder.messageTextView.text = message.text
            }
        }
    }


    override fun getItemCount(): Int = messagesList.size

    override fun getItemViewType(position: Int): Int = when (messagesList[position].type) {
        Constants.SENDER_MESSAGE_TYPE -> TYPE_SENDER
        // other types...
        else -> TYPE_RECEIVER
    }

    fun updateMessageList(messagesList: List<Message>) {
        this.messagesList = messagesList
        notifyDataSetChanged()
    }


    class LeftViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val timeStampTextView: TextView = itemView.findViewById(R.id.timeStampTextView)
        internal val messageTextView: TextView = itemView.findViewById(R.id.messageTextView)

    }

    class RightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val timeStampTextView: TextView = itemView.findViewById(R.id.timeStampTextView)
        internal val messageTextView: TextView = itemView.findViewById(R.id.messageTextView)
    }
}