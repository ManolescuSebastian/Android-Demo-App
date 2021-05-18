package com.tekydevelop.radixfm.util

object Helper {

    fun formatDuration(duration: Int): String {
        val minutes = duration / 60
        val seconds = duration - (minutes * 60)

        return if (duration > 59) {
            if (seconds < 10) {
                "$minutes:0$seconds"
            } else {
                "$minutes:$seconds"
            }
        } else {
            duration.toString()
        }
    }
}