package com.example.gymprofitapp.utils

import android.accounts.AccountManager
import android.accounts.AccountManagerCallback
import android.accounts.AccountManagerFuture
import android.os.Bundle

class OnTokenAcquired: AccountManagerCallback<Bundle> {
    override fun run(future: AccountManagerFuture<Bundle>?) {
        val bundle: Bundle =future!!.result
        val token = bundle.getString(AccountManager.KEY_AUTHTOKEN)
    }
}