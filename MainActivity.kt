package com.example.banking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.stream.IntStream.range

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction=findViewById<Button>(R.id.trans)
        transaction.setOnClickListener{
            val intent=Intent(this, transaction_page::class.java)
            startActivity(intent)
        }

        val customers=findViewById<Button>(R.id.customer)
        customers.setOnClickListener {
            val intent2=Intent(this,customer_list::class.java)
            startActivity(intent2)
        }

        val payment=findViewById<Button>(R.id.pay)
        payment.setOnClickListener {
            val intent3=Intent(this,payment_page::class.java)
            startActivity(intent3)
        }

        val reset = findViewById<Button>(R.id.reset)
        reset.setOnClickListener {
            val pos = intArrayOf(0,1,2,3,4,5,6,7,8,9)
            val names= arrayListOf("Sundar","Rishabh","Owaish","Sana","Piyashi","Saksham","Akansha","Priyank",
                    "Kajal","Mayo")
            val money= arrayListOf<String>(
                    "40000", "10000","15000","120000","30000","60000","75000","20000","65000","200000")

            val id = 0
            for(id in pos.indices){
                val databaseHandler: DatabaseHandler= DatabaseHandler(this)
                databaseHandler.updateEmployee(EmpModelClass(id,names[id], money[id]))
                databaseHandler.addEmployee(EmpModelClass(id,names[id],money[id]))
            }



        }
    }



}
