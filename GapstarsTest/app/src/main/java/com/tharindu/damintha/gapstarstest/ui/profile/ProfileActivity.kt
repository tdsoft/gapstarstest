package com.tharindu.damintha.gapstarstest.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tharindu.damintha.gapstarstest.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }

    override fun onResume() {
        super.onResume()
        GlobalScope.launch {
//            val response = apolloClient.query(GithubProfile()).await()
//
//            Log.d("LaunchList", "Success ${response?.data}")
        }

    }
}