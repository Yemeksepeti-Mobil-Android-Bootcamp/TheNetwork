package com.kodluyoruz.networkandretrofit.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

object SharedPreferencesUtil {
    const val TOKEN = "com.kodluyoruz.networkandretrofit.TOKEN"
    const val PAGE_NUMBER = "com.kodluyoruz.networkandretrofit.PAGE_NUMBER"
    private var sharedPreferences: SharedPreferences? = null

    fun initSharedPreferences(context: Context) {
        sharedPreferences =
            context.getSharedPreferences("sharedPreferencesUtil", Context.MODE_PRIVATE)
        sharedPreferences?.registerOnSharedPreferenceChangeListener { sharedPreferences, key ->
            Log.v("SharedPref", "$key changed ${sharedPreferences.all}")
        }
    }

    fun unRegister() {
        sharedPreferences?.unregisterOnSharedPreferenceChangeListener { _, _ ->

        }
    }

    fun saveString(key: String, value: String) {
        sharedPreferences?.let {
            val editor = it.edit()
            editor.putString(key, value)
            editor.apply()
        }
    }

    fun savePage(pageNumber: Int = 1) {
        sharedPreferences?.let {
            val editor = it.edit()
            editor
                .putInt(PAGE_NUMBER, pageNumber)
            editor.apply()
        }
    }

    fun getPage(): Int {
        return sharedPreferences?.getInt(PAGE_NUMBER, 1) ?: 1
    }

    fun getString(key: String, defaultVal: String = ""): String {
        return sharedPreferences?.getString(key, defaultVal) ?: ""
    }

    fun saveToken(value: String) {
        saveString(
            TOKEN, value
        )
    }

    fun getToken(): String {
        return getString(TOKEN)
    }
}