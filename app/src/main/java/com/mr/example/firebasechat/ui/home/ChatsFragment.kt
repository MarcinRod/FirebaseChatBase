package com.mr.example.firebasechat.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LayoutAnimationController
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mr.example.firebasechat.R
import com.mr.example.firebasechat.data.Chat
import com.mr.example.firebasechat.databinding.FragmentChatsBinding
import com.mr.example.firebasechat.helpers.RVItemClickListener

/**
 * Fragment class for displaying a list of started chats in a RecyclerView of the Initial Screen
 * Implements RVItemClickListener interface to handle clicks on the RecyclerView items:
 * - Navigates to the ChatFragment when a chat item is clicked
 * Implements ValueEventListener interface to listen to changes in the Firebase database
 * @see RVItemClickListener
 * @see ValueEventListener
 */
class ChatsFragment : Fragment(), RVItemClickListener {

    private lateinit var binding: FragmentChatsBinding
    // Declare an instance of the ChatsAdapter class and set the click listener to this fragment
    private val chatsAdapter: ChatsAdapter = ChatsAdapter(this)
    // TODO: Placeholder
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatsBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.chatsProgress.visibility = View.VISIBLE
        // TODO: Placeholder
    }

    /**
     * Set up the RecyclerView with the ChatsAdapter and a LinearLayoutManager
     */
    private fun setupRecyclerView() {
        with(binding.chatsList) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = chatsAdapter
        }
    }

    private fun showList(chats: List<Chat>) {
            with(binding.chatsList) {
                // Load an animation for the chats list
                // - this will animate the list items when they are displayed
                val animation: LayoutAnimationController =
                    android.view.animation.AnimationUtils.loadLayoutAnimation(
                        requireContext(),
                        R.anim.layout_animation_fall_down
                    )

                // Set the animation as the layout animation for the chatsList
                layoutAnimation = animation

                // Schedule the layout animation for the chatsList
                scheduleLayoutAnimation()
            }
            // Submit the list of rooms to the listAdapter
            chatsAdapter.submitList(chats)
    }

    /**
     * Stop listening to changes in the user's chats when the fragment is stopped
     */
    override fun onStop() {
        super.onStop()
        // TODO: Placeholder
    }



    override fun onItemClick(item: Any) {
        // Navigate to the chat fragment.
        // Since onItemClick accepts Any object we need to check if the item is a Chat object
        if (item is Chat) {
            val action = ChatsFragmentDirections.actionNavigationChatsToChatFragment(item)
            findNavController().navigate(action)
        }
    }

}