package com.tharindu.damintha.gapstarstest.common

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.tharindu.damintha.gapstarstest.R


fun ViewGroup.inflate(@LayoutRes layout: Int, attachToRoot: Boolean = false) =
    LayoutInflater.from(context).inflate(layout, this, attachToRoot)!!

fun ImageView.loadImageUrl(url: String, enableCircleCrop: Boolean = false) {
    if (enableCircleCrop) {
        Glide
            .with(context)
            .load(url)
            .apply(RequestOptions().circleCrop())
            .into(this)
    } else {
        Glide
            .with(context)
            .load(url)
            .centerCrop()
            .into(this)
    }

}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}

@SuppressLint("QueryPermissionsNeeded")
fun String.openUrl(context: Context) {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.data = Uri.parse(this)
    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    } else {
        Toast.makeText(context, R.string.no_matching_app_found, Toast.LENGTH_LONG).show()
    }
}