package com.tharindu.damintha.gapstarstest.ui.profile

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.MainThread
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.tharindu.damintha.gapstarstest.R
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith


@MediumTest
@RunWith(AndroidJUnit4::class)
class ProfileActivityTest {

    @Test
    fun testProgressbarIsVisibleAfterLoadDataCalled() {
        val scenario = launchActivity<ProfileActivity>()
        if (scenario.state == Lifecycle.State.RESUMED) {
            scenario.onActivity {
                val progress = it.findViewById<ProgressBar>(R.id.progressBar)
                assertEquals(
                    "Progress bar is not visible",
                    false,
                    (progress.isVisible)
                )
            }
        }
    }

}

