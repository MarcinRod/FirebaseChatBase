package com.mr.example.firebasechat.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**Simple data model for representing a User
 * @param email Email of the user
 * @param lastSeen Timestamp when the user was last seen
 * @param uid UID of the user */
@Parcelize
data class User(val email: String = "", val lastSeen: Long = 0L, val uid: String = "") :
    Parcelable

// TODO: Placeholder