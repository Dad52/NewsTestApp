package com.ands.newstestapp.common

import com.ands.newstestapp.domain.models.ArticleUi

/**
 * Created by Dad52(Sobolev) on 6/19/2022.
 */
interface ItemBind {
    fun bind(articleUi: ArticleUi)
}