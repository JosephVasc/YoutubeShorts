package com.example.youtubeshorts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val username = findViewById(R.id.et_user_name) as EditText
        val password = findViewById(R.id.et_password) as EditText
        findViewById<Button>(R.id.btn_login).setOnClickListener {
            if ( username.text.toString() == "jung" && password.text.toString() == "comp415"){
                val intent = Intent(this, HomeFeed::class.java)
                startActivity(intent)
            }
            else{
                val toast: Toast = Toast.makeText(this ,"invalid login", Toast.LENGTH_LONG)
                toast.show()
            }
        }
    }
}