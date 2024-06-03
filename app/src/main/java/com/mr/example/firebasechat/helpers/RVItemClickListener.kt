package com.mr.example.firebasechat.helpers

/** Interface definition for an item click listener in a RecyclerView */
interface RVItemClickListener {
    /** This method is called when an item in the RecyclerView is clicked
     * @param item The item that was clicked. Type: Any allows for different types of items
     */
    fun onItemClick(item:Any)
}
