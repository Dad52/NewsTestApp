package com.ands.newstestapp.data.repository

import com.ands.newstestapp.common.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

/**
 * Created by Dad52(Sobolev) on 6/24/2022.
 */
abstract class BaseRepository {

    suspend fun <T> safeApiCall(calledApi: suspend () -> Response<T>): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<T> = calledApi()

                if (response.isSuccessful) {
                    Resource.Success(data = response.body()!!)
                } else {
                    Resource.Error(errorMessage = response.errorBody().toString())
                }

            } catch (e1: HttpException) {
                Resource.Error(errorMessage = "Something went wrong")

            } catch (e2: IOException) {
                Resource.Error(errorMessage = "Check your internet connection")

            } catch (e3: Exception) {
                Resource.Error(errorMessage = "Something went wrong")
            }
        }
    }

    fun tryAgain() {
//TODO
    }

}