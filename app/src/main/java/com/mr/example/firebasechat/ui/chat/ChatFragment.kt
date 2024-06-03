package com.mr.example.firebasechat.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.mr.example.firebasechat.data.Message
import com.mr.example.firebasechat.databinding.FragmentChatBinding

/** Fragment class for displaying a chat messages in a RecyclerView
 * Implements ValueEventListener interface to listen to changes in the Firebase database
 * @see ValueEventListener
 */
class ChatFragment : Fragment() {
    
    private lateinit var binding: FragmentChatBinding
    private val args: ChatFragmentArgs by navArgs() // get safe args using Navigation component
    private var listAdapter: ChatAdapter = ChatAdapter() // declare adapter variable
    private lateinit var chatName: String // declare room name variable
    private lateinit var recipientUid: String // declare recipient UID variable
    private val messages: ArrayList<Message> = ArrayList() // create an array list to store messages
    private var isFirstGet: Boolean =
        true // initialize flag to true to indicate that it's the first time to get the messages

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isFirstGet =
            true // set the flag to true to indicate that it's the first time to get the messages
        chatName = args.chat.chatName // get the chat name from the safe args
        recipientUid = args.chat.recipientUid // get the recipient UID from the safe args
        // TODO: Placeholder
        // Start listening to messages from the chat room
        startListeningToMessages()
        // Set up the buttons and the RecyclerView
        setupButtons()
        setupRecyclerView()
    }
    /**
     * Start listening to messages from the chat room
     * specifies the ChatFragment to be the listener for changes in the database
     */
    private fun startListeningToMessages() {
        // TODO: Placeholder
    }
    /**
     * Set up the buttons in the chat fragment
     * - sets the click listener for the send button
     */
    private fun setupButtons() {
        // TODO: Placeholder
    }

    /**
     * Set up the RecyclerView in the chat fragment
     */
    private fun setupRecyclerView() {
        with(binding.messageList) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = listAdapter
        }
    }

    /**
     * Shows the list of messages in the RecyclerView
     * @param messages List of messages to be displayed
     */
    private fun showList(messages: List<Message>) {
        binding.messageList.visibility = View.VISIBLE // make the recycler view visible
        listAdapter.submitList(messages) // submit the list of messages to the adapter
        // scroll to the last position so the last message is visible as soon as it's added
        binding.messageList.scrollToPosition(this.messages.size - 1)
        // If it's not the first time getting data, notify the adapter that an item has been inserted
        if (!isFirstGet)
            listAdapter.notifyItemInserted(this.messages.size)
    }


    // This function is called when the fragment view is about to be destroyed.
    override fun onDestroyView() {
        super.onDestroyView()
        // TODO: Placeholder
    }
}

