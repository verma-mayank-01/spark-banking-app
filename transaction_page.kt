package com.example.banking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import java.util.ArrayList
import java.util.concurrent.Delayed

class transaction_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_page)

        val mListView= findViewById<ListView>(R.id.listview)


        val array: MutableList<String> = ArrayList()
        val sender = intent.getStringExtra("ns1")
        val recv = intent.getStringExtra("recvr")
        val amount = intent.getStringExtra("a2")
        val s= "Sender: ${sender.toString()} Reciever: ${recv.toString()} Amount: ${amount.toString()}"
        array.add(s)
        val adapter= ArrayAdapter<String>(this@transaction_page,android.R.layout.simple_list_item_1,array)


        mListView.adapter=adapter
        val btn = findViewById<Button>(R.id.back_home)
        btn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        //Toast.makeText(this@transaction_page, s, Toast.LENGTH_SHORT).show()


    }
}
