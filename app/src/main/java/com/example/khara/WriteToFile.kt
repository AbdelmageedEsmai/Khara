package com.example.khara

import android.content.Context
import android.os.Environment
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter

class WriteToFile {

    fun writeToFile(context: Context, list: MutableList<String>) {
        val file = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
            "englishStrings.txt"
        )
        try {
            if (!file.exists())
                file.createNewFile()
            val fos = FileOutputStream(file)
            val osw = OutputStreamWriter(fos)
            for (text in list) {
                osw.write(text)
            }
            osw.flush()
            osw.close()
            fos.close()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }

    }

}