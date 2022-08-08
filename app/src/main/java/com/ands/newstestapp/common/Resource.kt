package com.ands.newstestapp.common

/**
 * Created by Dad52(Sobolev) on 6/24/2022.
 */
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null,
) {
    class Success<T>(data: T?) : Resource<T>(data = data)

    class Error<T>(errorMessage: String) : Resource<T>(message = errorMessage)

    class Loading<T>(loadingMessage: String = "Загрузка") : Resource<T>(message = loadingMessage)
}
