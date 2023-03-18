package com.example.khara

import android.Manifest
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    var list = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addPermissions()
        val btnWrite = findViewById<Button>(R.id.btnWrite)
        val readFileList = ReadFromFile().readFile(this)
        btnWrite.setOnClickListener {
            if (readFileList.size > 0) {
                WriteToFile().writeToFile(this, readFileList)
            }
        }
    }

    fun addPermissions() {
        val PERMISSION_ALL = 1
        val PERMISSIONS = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
//            ,
//            Manifest.permission.READ_MEDIA_IMAGES,
//            Manifest.permission.READ_MEDIA_AUDIO,
//            Manifest.permission.READ_MEDIA_VIDEO
        )
        ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL)

    }
}