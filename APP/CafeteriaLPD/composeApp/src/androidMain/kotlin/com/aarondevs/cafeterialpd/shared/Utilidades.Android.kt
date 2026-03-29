package com.aarondevs.cafeterialpd.shared

import android.content.Context
import android.media.MediaPlayer
import android.util.Log

actual fun logDebug(message: String) {
    Log.d("Informacion: ", message)
}


private lateinit var appContext: Context
fun initSound(context: Any) {
    appContext = (context as Context).applicationContext
}

actual fun playSound(fileName: String) {
    if (!::appContext.isInitialized) return

    val resId = appContext.resources.getIdentifier(
        fileName,
        "raw",
        appContext.packageName
    )

    if (resId == 0) return

    MediaPlayer.create(appContext, resId)?.apply {
        setOnCompletionListener { release() }
        start()
    }
}