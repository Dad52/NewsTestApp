package com.ands.newstestapp.common.storage

import android.util.Log
import com.ands.newstestapp.data.models.ArticleUi
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

/**
 * Created by Dad52(Sobolev) on 6/10/2022.
 */
class CacheStorageImpl : CacheStorage {

    override fun saveListArticles(list: List<ArticleUi>) {

        val file = FileOutputStream(FILE_PATH)
        val outStream = ObjectOutputStream(file)

        list.forEach {
            outStream.writeObject(it)
            Log.e("TAG", it.toString())
        }

        outStream.close()
        file.close()

    }

    override fun getListArticles(): List<ArticleUi>? {

        val file = FileInputStream(FILE_PATH)
        val inStream = ObjectInputStream(file)

        // Method for deserialization of object

        val item = inStream.readObject() as List<ArticleUi>

        inStream.close()
        file.close()
        Log.e("TAG", "$item")
        return item
    }

    companion object {
        private const val FILE_PATH = "src/resources/myfile.txt"
    }

}