package com.mr.example.firebasechat.ui.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mr.example.firebasechat.data.Message
import com.mr.example.firebasechat.databinding.MessageViewHolderBinding
import com.mr.example.firebasechat.helpers.toDateTimeString

/**
 * Adapter class for displaying messages in a RecyclerView using a ListAdapter subclass
 * @see Message
 * @see ListAdapter
 * @param Comparator An object used to determine if two items represent the same Message object
 */
class ChatAdapter
    : ListAdapter<Message, ChatAdapter.ViewHolder>(Comparator) {
    // An object used to determine if two items represent the same Message object
    object Comparator : DiffUtil.ItemCallback<Message>() {
        override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean {
            return oldItem.timestamp == newItem.timestamp
        }

        // An object used to determine if two items have the same contents
        override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean {
            return oldItem.timestamp == newItem.timestamp && oldItem.message == newItem.message && oldItem.author == newItem.author
        }
    }

    // Creates a new ViewHolder object for displaying items in the RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the view using the MessageViewHolderBinding object
        return ViewHolder(
            MessageViewHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    // Binds a Message object to a ViewHolder object
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the Message object at the specified position in the list of items
        val item = getItem(position)
        // Bind the Message object to the ViewHolder object
        holder.bind(item)
    }

    // A ViewHolder object for displaying a single Message object
    inner class ViewHolder(private val binding: MessageViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root) {


        /** Binds a Message object to the ViewHolder object
         * @param message The Message object to bind
         */
        fun bind(message: Message) {
            // Set the text of the message
            binding.message.text = message.message
            // Set the message author and formatted timestamp
            binding.messageAuthor.text = buildString {
                append(message.author)
                append('@')
                append(message.timestamp.toDateTimeString())
            }
            // TODO: Placeholder
        }
    }
}
