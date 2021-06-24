package com.example.gymprofitapp.ui.auth

import android.accounts.Account
import android.accounts.AccountManager
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.gymprofitapp.databinding.LoginFragmentBinding
import com.example.gymprofitapp.utils.OnTokenAcquired

class AccountManagerFragment : Fragment() {



private lateinit var accounts : Array<out Account>
private lateinit var myAccount : Account

private var _binding: LoginFragmentBinding? = null
private val binding: LoginFragmentBinding
    get() = _binding!!
private lateinit var viewModel: LoginViewModel

override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
): View {
    _binding = LoginFragmentBinding.inflate(inflater, container, false)
    return binding.root
}

override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    // TODO: Use the ViewModel
}

fun getUserAccounts(){

    val am: AccountManager = AccountManager.get(activity?.applicationContext)
    accounts = am.getAccountsByType("com.google")

    if (accounts.size > 1){
        showDialogForAccountPreference(accounts)

    }else if (accounts.size == 0){

        createAccount()

        //setAccount()
    }else{
        setAccount(accounts[0])
    }
    //myAccount = accounts[0]


    val options = Bundle()

    am.getAuthToken(
        myAccount,
        "bearer only",
        options,
        activity,
        OnTokenAcquired(),
        null
    )
}

private fun setAccount(account: Account) {
    myAccount = account
}

private fun showDialogForAccountPreference(accounts: Array<out Account>) {
    val userAccountSelection = 0

    Dialog(this.requireContext())

    setAccount(accounts[userAccountSelection])
}

private fun createAccount(): Account{
    TODO("Not yet implemented")
}
}