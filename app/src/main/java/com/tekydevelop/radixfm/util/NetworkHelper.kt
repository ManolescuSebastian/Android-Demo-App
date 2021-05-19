package com.tekydevelop.radixfm.util

import android.content.Context
import android.net.ConnectivityManager

object NetworkHelper {

    fun isNetworkAvailable(context: Context): Boolean {
        val conManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val internetInfo = conManager.activeNetworkInfo
        return internetInfo != null && internetInfo.isConnected
    }
}