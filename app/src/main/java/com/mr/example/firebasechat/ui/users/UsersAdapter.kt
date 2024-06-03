package com.mr.example.firebasechat.ui.users


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mr.example.firebasechat.R
import com.mr.example.firebasechat.data.User
import com.mr.example.firebasechat.databinding.UserViewHolderBinding
import com.mr.example.firebasechat.helpers.RVItemClickListener
import com.mr.example.firebasechat.helpers.toDateTimeString

/** Adapter class for displaying users in a RecyclerView using a ListAdapter subclass
 * @see User
 * @see ListAdapter
 * @param clickListener An RVItemClickListener object used to handle clicks on the RecyclerView items
 * @param Comparator An object used to determine if two items represent the same User object
 */

class UsersAdapter(private val clickListener: RVItemClickListener) :
    ListAdapter<User, UsersAdapter.ViewHolder>(Comparator) {

    // A companion object with an implementation of DiffUtil's ItemCallback to compare User objects
    object Comparator : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.uid == newItem.uid
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.uid == newItem.uid && oldItem.lastSeen == newItem.lastSeen
        }
    }

    // Creates a ViewHolder for the RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflates the view from the ForumsScreenItemBinding and returns a new instance of ViewHolder
        return ViewHolder(
            UserViewHolderBinding.inflate(
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
    inner class ViewHolder(val binding: UserViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        // Binds the Chat object to the views in the ViewHolder layout
        fun bind(user: User) {
            // Sets the user name from the email address
            binding.userName.text = user.email.substringBefore('@')
            // Sets the last seen text from the lastSeen property of the User object
            binding.details.text =
                binding.root.context.getString(
                    R.string.last_seen_format,
                    user.lastSeen.toDateTimeString()
                )
            // Sets an item click listener on the root view of the ViewHolder
            binding.root.setOnClickListener {
                clickListener.onItemClick(user)
            }
        }
    }
}


