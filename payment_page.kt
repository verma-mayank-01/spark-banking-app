package com.example.banking

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import java.util.logging.Logger.global

class payment_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_page)

        val names= arrayListOf("Sundar","Rishabh","Owaish","Sana","Piyashi","Saksham","Akansha","Priyank",
                "Kajal","Mayo")


        val money= arrayListOf<String>(
            "40000", "10000","15000","120000","30000","60000","75000","20000","65000","200000"
        )

        val mListView= findViewById<ListView>(R.id.listView)
        val adapter=ArrayAdapter<String>(this@payment_page,android.R.layout.simple_list_item_1,names)

        mListView.adapter=adapter


        mListView.setOnItemClickListener { parent, view, position, id ->
            val sender = position.toString()

            //val intetsnd = Intent(this, amount_page::class.java)


            Toast.makeText(this@payment_page, names[position], Toast.LENGTH_SHORT).show()
            val intent3= Intent(this@payment_page, amount_page::class.java)
            intent3.putExtra("sender",sender)
            intent3.putExtra("name_sender", names[position])
            startActivity(intent3)


        }


    }


}
