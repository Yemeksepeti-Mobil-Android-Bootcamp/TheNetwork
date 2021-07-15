package com.kodluyoruz.networkandretrofit.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kodluyoruz.networkandretrofit.R
import com.kodluyoruz.networkandretrofit.utils.SharedPreferencesUtil

class FragmentExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_example)
        SharedPreferencesUtil.initSharedPreferences(baseContext)
        SharedPreferencesUtil.saveToken("hello patika & kodluyoruz")
    }

    override fun onDestroy() {
        super.onDestroy()
        SharedPreferencesUtil.unRegister()
    }
}