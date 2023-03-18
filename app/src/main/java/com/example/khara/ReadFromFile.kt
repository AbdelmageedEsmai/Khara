package com.example.khara

import android.content.Context
import android.content.res.AssetManager
import android.util.Log
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class ReadFromFile {

    fun readFile(context: Context): MutableList<String> {
        val list = mutableListOf<String>()
        val inputStream: InputStream = context.assets.open("english_strings.txt")
        val `in` = BufferedReader(InputStreamReader(inputStream))
        var input: String?
        val stringBuffer = StringBuffer()
        while (`in`.readLine().also { input = it } != null) {
            val substring = input!!.substring(input!!.indexOf("\">"), input!!.indexOf("</string>"))
                .replace("\">", "")
            Log.e("inputValue", "" + substring)
            list.add(substring + "\n")
            stringBuffer.append(input)
        }
        `in`.close()
        return list
    }
}