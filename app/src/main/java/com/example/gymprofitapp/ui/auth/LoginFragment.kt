package com.example.gymprofitapp.ui.auth


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.gymprofitapp.databinding.LoginFragmentBinding
import com.example.gymprofitapp.model.login.TokenModel
import com.example.gymprofitapp.model.login.UserLoginModel
import com.example.gymprofitapp.utils.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: LoginFragmentBinding? = null
    private val binding: LoginFragmentBinding
        get() = _binding!!
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LoginFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        // TODO: Use the ViewModel

        val email = ""
        val password = ""
        val name = ""
        val userLoginModel = UserLoginModel(name, email, password)
        viewModel.getUserLogin(userLoginModel)
        subscribeObserver()
    }

    private fun subscribeObserver(){
        viewModel.dataState.observe(viewLifecycleOwner, { dataState ->
            when(dataState){
                is DataState.Success<TokenModel> -> {
                    // save to datastore
                    //updateUI
                }

                is DataState.Loading -> {

                }

                is DataState.Error -> {

                    Toast.makeText(this.requireContext(), "Unknown Account", Toast.LENGTH_LONG).show()
                }
            }

        })
    }


}