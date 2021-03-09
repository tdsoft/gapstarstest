package com.tharindu.damintha.gapstarstest.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.tharindu.damintha.gapstarstest.R
import com.tharindu.damintha.gapstarstest.ui.profile.ProfileActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        gotoMain()
    }

    private fun gotoMain() {
        Handler(Looper.getMainLooper()).postDelayed({
            finish()
            ProfileActivity.startActivity(this@SplashActivity)
        }, 3000)
    }
}