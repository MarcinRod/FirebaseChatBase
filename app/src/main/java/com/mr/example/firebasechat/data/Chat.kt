package com.mr.example.firebasechat.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Simple data model for representing a Chat
 * @param chatName Name of the chat room
 * @param recipientUid UID of the recipient user
 * @param recipientLastSeen Timestamp when the recipient was last seen
 * @param lastMessage Last message sent in the chat
 * NOTE: The default values are provided to create a mandatory empty constructor for
 * Firebase Realtime Database
 */
@Parcelize
data class Chat(
    val chatName: String = "",
    val recipientUid: String = "",
    val recipientLastSeen:Long = 0L,
    val lastMessage: String = "",
): Parcelable
