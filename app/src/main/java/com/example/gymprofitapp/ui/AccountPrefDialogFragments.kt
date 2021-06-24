package com.example.gymprofitapp.ui

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
//import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.gymprofitapp.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AccountPrefDialogFragments : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage(R.string.dialog_fire_missiles)
                .setPositiveButton(R.string.fire
                ) { dialog, id ->
                    // FIRE ZE MISSILES!
                }
                .setNegativeButton(R.string.cancel
                ) { dialog, id ->
                    // User cancelled the dialog
                }
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }


}