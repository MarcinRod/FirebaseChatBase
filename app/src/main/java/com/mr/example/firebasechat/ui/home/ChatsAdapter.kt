package com.mr.example.firebasechat.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mr.example.firebasechat.R
import com.mr.example.firebasechat.data.Chat
import com.mr.example.firebasechat.databinding.ChatViewHolderBinding
import com.mr.example.firebasechat.helpers.RVItemClickListener
import com.mr.example.firebasechat.helpers.toDateTimeString


/**
 * Adapter class for displaying chats in a RecyclerView using a ListAdapter subclass
 * @see Chat
 * @see ListAdapter
 * @see RVItemClickListener
 * @param clickListener An RVItemClickListener object used to handle clicks on the RecyclerView items
 * @param Comparator An object used to determine if two items represent the same Chat object
 */
class ChatsAdapter(private val clickListener: RVItemClickListener) :
    ListAdapter<Chat, ChatsAdapter.ViewHolder>(ChatDiffCallback()) {

    // A companion object with an implementation of DiffUtil's ItemCallback to compare Chat objects
    class ChatDiffCallback : DiffUtil.ItemCallback<Chat>() {
        // Compares two Chat objects to determine if they represent the same item
        override fun areItemsTheSame(oldItem: Chat, newItem: Chat): Boolean {
            return oldItem.chatName == newItem.chatName
        }

        // Compares the contents of two Chat objects to determine if they are the same
        override fun areContentsTheSame(oldItem: Chat, newItem: Chat): Boolean {
            return oldItem.chatName == newItem.chatName && oldItem.lastMessage == newItem.lastMessage && oldItem.recipientLastSeen == newItem.recipientLastSeen
        }
    }
    // TODO: TO JEST ZBEDNE JUZ RACZEJ
//    override fun submitList(list: List<Chat>?) {
//        super.submitList(list?.let { ArrayList(it) })
//    }

    // Creates a ViewHolder for the RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflates the view from the ForumsScreenItemBinding and returns a new instance of ViewHolder
        return ViewHolder(
            ChatViewHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    // Binds the ViewHolder to the item at the specified position
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        // Calls the bind method of the ViewHolder, passing in the Chat object at the specified position
        holder.bind(item)

    }

    // ViewHolder class for the RecyclerView
    inner class ViewHolder(private val binding: ChatViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        // Binds the Chat object to the views in the ViewHolder layout
        fun bind(chat: Chat) {
           // Creates a recipient string by removing the current user's name from the chatName
            // The chatName is in the format "user1_user2" where one of users is the current user
            // TODO: Placeholder
            val recipient = "temp recipient"

            // Sets the text of the chatName TextView with a specified format
            // and recipient variable
            binding.chatUserName.text =
                binding.root.context.getString(R.string.chat_with_format, recipient)
            // Show the last seen time of the chat recipient
            binding.details.text = binding.root.context.getString(
                R.string.last_seen_format,
                chat.recipientLastSeen.toDateTimeString()
            )

            // Sets the visibility of the unread messages TextView based on the
            // last message of the chat object
            binding.unreadMsgs.visibility = if (chat.lastMessage.isEmpty()) {
                View.GONE
            } else {
                View.VISIBLE
            }

            // Sets an item click listener on the root view of the ViewHolder
            binding.root.setOnClickListener {
                clickListener.onItemClick(chat)
            }
        }
    }
}
