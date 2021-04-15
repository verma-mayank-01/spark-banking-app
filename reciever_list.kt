package com.example.banking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class reciever_list : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reciever_list)

        val names= arrayListOf("Sundar","Rishabh","Owaish","Sana","Piyashi","Saksham","Akansha","Priyank",
                "Kajal","Mayo")
        val money= arrayListOf<String>(
            "40000", "10000","15000","120000","30000","60000","75000","20000","65000","200000")

        val mListView= findViewById<ListView>(R.id.listView)
        val adapter= ArrayAdapter<String>(this@reciever_list,android.R.layout.simple_list_item_1,names)

        mListView.adapter=adapter

        val add = intent.getStringExtra("add")
        val s2 = intent.getStringExtra("ns")
        val a1 = intent.getStringExtra("amount")
        //val amnt = intent.getIntArrayExtra("money")
       // print(amnt?.get(3))
        mListView.setOnItemClickListener { parent, view, position, id ->
            val get = money[position].toInt()
            val amount = Integer.parseInt(add)
            val added = get + amount
            money[position] = added.toString()

            val databaseHandler: DatabaseHandler= DatabaseHandler(this)
            databaseHandler.updateEmployee(EmpModelClass(position,names[position].toString(), added.toString()))

            Toast.makeText(this@reciever_list, "Transfer Successful", Toast.LENGTH_SHORT).show()





            val intent2 = Intent(this@reciever_list, customer_list::class.java)
            intent2.putExtra("final",added.toString())
            intent2.putExtra("position2",position.toString())

            //val intent = Intent(this@reciever_list, transaction_page::class.java)
            val intentr = Intent(this@reciever_list, transaction_page::class.java)
            intentr.putExtra("recvr", names[position])
            intentr.putExtra("ns1",s2)
            intentr.putExtra("a2",a1)
            startActivity(intentr)






        }
    }
}
