package com.mr.example.firebasechat.ui.login

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mr.example.firebasechat.R
import com.mr.example.firebasechat.databinding.FragmentLoginBinding


/**
 * Fragment class for handling the login and registration of users
 */
class LoginRegisterFragment : Fragment() {

    // Flag indicating the state of the form. True means that the form is used for Login,
    // false means that the form is used to register user
    private var isLogin = true

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set isLogin to true
        isLogin = true
        binding.formGroup.visibility = View.INVISIBLE
        setupButtons()
    }


    // This function sets up the buttons in the login/register screen
    private fun setupButtons() {
        // TODO: Placeholder
    }


    private fun toggleLoginRegister() {
        // Toggle the isLogin flag
        isLogin = !isLogin
        if (isLogin) {
            showLoginForm()
        } else {
            showRegisterForm()
        }
    }

    private fun showLoginForm() {
        // TODO: Placeholder
    }

    private fun showRegisterForm() {
        // TODO: Placeholder
    }



    private fun navigateToChats() {
        findNavController().navigate(R.id.action_navigation_login_to_navigation_chats)
    }

    override fun onStart() {
        super.onStart()
        // TODO: Placeholder
    }

    override fun onResume() {
        super.onResume()
        // The LoginRegisterFragment handles both the login and register process
        // The Login form is the default one so the password confirm field is hidden by default
        showLoginForm()
    }

}
