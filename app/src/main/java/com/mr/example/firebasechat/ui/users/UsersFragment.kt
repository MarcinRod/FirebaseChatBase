package com.mr.example.firebasechat.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mr.example.firebasechat.R
import com.mr.example.firebasechat.data.Chat
import com.mr.example.firebasechat.data.User
import com.mr.example.firebasechat.databinding.FragmentUsersBinding
import com.mr.example.firebasechat.helpers.RVItemClickListener


/**
 * Fragment class for displaying a list of users in a RecyclerView of the Users Screen
 * Implements RVItemClickListener interface to handle clicks on the RecyclerView items:
 * - Navigates to the ChatFragment when a user item is clicked
 * Implements ValueEventListener interface to listen to changes in the Firebase database
 * @see RVItemClickListener
 * @see ValueEventListener
 */
class UsersFragment : Fragment(), RVItemClickListener{

    private lateinit var binding: FragmentUsersBinding
    // Declare an instance of the UsersAdapter class and set the click listener to this fragment
    private val usersAdapter = UsersAdapter(this)
  
    // TODO: Placeholder
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUsersBinding.inflate(inflater, container, false)
        // Make the progress bar visible
        binding.usersProgress.visibility = View.VISIBLE
        // Attach the adapter to the RecyclerView
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        with(binding.usersList) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = usersAdapter
        }
    }

    private fun showList(users: List<User>) {
        // Make the usersList invisible for visual effects
        binding.usersList.visibility = View.INVISIBLE
        // Schedule a delayed task to make the usersList visible
        binding.root.postDelayed({
            // Make the forumList visible
            with(binding.usersList) {
                visibility = View.VISIBLE

                // Load an animation for the usersList
                val animation: LayoutAnimationController =
                    AnimationUtils.loadLayoutAnimation(
                        requireContext(),
                        R.anim.layout_animation_fall_down
                    )

                // Set the animation as the layout animation for the usersList
                layoutAnimation = animation

                // Schedule the layout animation for the usersList
                scheduleLayoutAnimation()
            }
            // Submit the list of rooms to the listAdapter
            usersAdapter.submitList(users)

        }, 50)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: Placeholder
    }

    override fun onItemClick(item: Any) {
        // TODO: Placeholder
    }

    /**
     * Navigates to the ChatFragment with the specified chat
     * @param chat Chat object to be passed to the ChatFragment
     */
    private fun navigateToChat(chat: Chat) {
        // Navigate to the ChatFragment
        findNavController().navigate(
            UsersFragmentDirections.actionNavigationUsersToChatFragment(chat)
        )
    }


    override fun onDestroyView() {
        super.onDestroyView()
        // TODO: Placeholder
    }
}
