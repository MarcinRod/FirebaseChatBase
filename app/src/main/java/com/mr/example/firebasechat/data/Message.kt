package com.mr.example.firebasechat.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Simple data model for representing a Message
 * @param author Name of the author of the message
 * @param message Content of the message
 * @param timestamp Timestamp when the message was sent
 * NOTE: The default values are provided to create a mandatory empty constructor for
 * Firebase Realtime Database
 */
@Parcelize
data class Message(val author: String = "",
                   val message: String = "",
                   val timestamp: Long = 0L) : Parcelable
