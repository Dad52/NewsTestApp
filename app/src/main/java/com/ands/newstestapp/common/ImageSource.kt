package com.ands.newstestapp.common

import android.content.Context
import android.view.RoundedCorner
import android.widget.ImageView
import androidx.annotation.DrawableRes
import coil.load
import coil.transform.RoundedCornersTransformation
import com.ands.newstestapp.R
import com.bumptech.glide.Glide

/**
 * Created by Dad52(Sobolev) on 6/3/2022.
 */
interface ImageSource {
    fun show(url: String, imageView: ImageView)

    class NetImageSource(
//        private val context: Context,
        @DrawableRes private val placeHolderResourceId: Int = R.drawable.ic_baseline_image_24,
        @DrawableRes private val errorResourceId: Int = R.drawable.ic_baseline_error_24,
        private val radiusRoundedCorner: Float = 0f
    ) : ImageSource {
        override fun show(url: String, imageView: ImageView) {
            imageView.load(url) {
                placeholder(placeHolderResourceId)
                error(errorResourceId)
                transformations(RoundedCornersTransformation(radiusRoundedCorner))
            }
        }
//        override fun show(url: String, imageView: ImageView) {
//            Glide.with(context)
//                .load(url)
//                .fitCenter()
//                .placeholder(placeHolderResourceId)
//                .error(errorResourceId)
//                .transform(RoundedCorners)
//                .into(imageView)
//        }
    }
}