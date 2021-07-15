package com.picpay.desafio.android.presentation.util.extension

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.webkit.URLUtil
import com.picpay.desafio.android.R
import com.picpay.desafio.android.presentation.util.dialog.DialogData
import com.picpay.desafio.android.presentation.util.navigation.NavData

fun Context.showDialog(dialogData: DialogData): Dialog {
    val builder = AlertDialog.Builder(this)
    builder.setTitle(dialogData.title)
    builder.setMessage(dialogData.message)
    if (dialogData.confirmButtonText == null && dialogData.onConfirm == null) {
        builder.setPositiveButton(dialogData.dismissButtonText, dialogData.onDismiss)
    } else {
        builder.setPositiveButton(
            dialogData.confirmButtonText,
            dialogData.onConfirm ?: dialogData.onDismiss
        )
        if (dialogData.dismissButtonText != null || dialogData.onDismiss != null) {
            builder.setNegativeButton(dialogData.dismissButtonText, dialogData.onDismiss)
        }
    }
    dialogData.onDismiss?.let { builder.setOnCancelListener { it() } }
    builder.setCancelable(dialogData.cancelable ?: true)
    return builder.show()
}

fun AlertDialog.Builder.setPositiveButton(buttonText: String?, onClick: (() -> Unit)?) =
    setPositiveButton(
        buttonText ?: context.getString(R.string.global_ok),
        onClick?.let { { _: DialogInterface, _: Int -> it() } }
    ) ?: null

fun AlertDialog.Builder.setNegativeButton(buttonText: String?, onClick: (() -> Unit)?) =
    setNegativeButton(
        buttonText ?: context.getString(R.string.global_cancel),
        onClick?.let { { _: DialogInterface, _: Int -> it() } }
    ) ?: null

fun Context.openBrowser(url: String?) {
    url?.let {
        val formattedUrl = with(url.trim()) {
            if (URLUtil.isHttpUrl(this) || URLUtil.isHttpsUrl(this)) {
                this
            } else {
                "http://$this"
            }
        }
        val browserIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(formattedUrl)
        ).apply { addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) }
        startActivity(browserIntent)
    }
}

fun Context.onGoTo(navData: NavData?) {
    navData?.navigate(this)
}