package com.aarondevs.cafeterialpd.shared

import kotlinx.cinterop.ExperimentalForeignApi
import platform.AVFAudio.AVAudioPlayer
import platform.AVFAudio.AVAudioSession
import platform.AVFAudio.AVAudioSessionCategoryPlayback
import platform.AVFAudio.setActive
import platform.Foundation.NSBundle

actual fun logDebug(message: String) {
    println(message)
}

private var audioPlayer: AVAudioPlayer? = null

@OptIn(ExperimentalForeignApi::class)
actual fun playSound(fileName: String) {
    val session = AVAudioSession.sharedInstance()
    session.setCategory(AVAudioSessionCategoryPlayback, error = null)
    session.setActive(true, error = null)

    val url = NSBundle.mainBundle.URLForResource(fileName, withExtension = "mp3") ?: return

    audioPlayer = AVAudioPlayer(contentsOfURL = url, error = null)
    audioPlayer?.prepareToPlay()
    audioPlayer?.play()
}