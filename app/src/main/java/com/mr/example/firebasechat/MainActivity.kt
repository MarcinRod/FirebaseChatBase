package com.mr.example.firebasechat

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.mr.example.firebasechat.firebase.FirebaseHandler
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mr.example.firebasechat.databinding.ActivityMainBinding

/**
 * Main activity class for the app
 * Implements NavController.OnDestinationChangedListener interface to listen
 * to changes in the navigation destination
 * @see NavController.OnDestinationChangedListener
 */
class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    private lateinit var binding: ActivityMainBinding
    // TODO: Placeholder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_chats, R.id.navigation_users
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Set up the bottom navigation view with the navigation controller
        navView.apply {
            setupWithNavController(navController)
            // Disable multi-stack in bottom nav
            setOnItemSelectedListener { item ->
                // Navigate to the selected item on the bottom nav
                NavigationUI.onNavDestinationSelected(item, navController)
                // Hide the back button in the action bar
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
                // Invalidate the options menu
                invalidateOptionsMenu()
                true
            }
        }
        // Add a listener to the navigation controller for destination changes
        navController.addOnDestinationChangedListener(this)

    }

    // Inflate the options menu for the action bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar_menu, menu)
        return true
    }

    // Prepare the options menu for display
    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        // TODO: Placeholder
        return super.onPrepareOptionsMenu(menu)

    }

    // Handle selection of an item from the options menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> {
                // TODO: Placeholder
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        // TODO: Placeholder
    }

    override fun onDestroy() {
        super.onDestroy()
        // TODO: Placeholder
    }
}