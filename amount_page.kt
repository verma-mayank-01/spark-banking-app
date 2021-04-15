package com.example.banking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class amount_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amount_page)

        val amount = findViewById<EditText>(R.id.amount)
        val btn = findViewById<Button>(R.id.send)
        val money= arrayListOf<String>(
            "40000", "10000","15000","120000","30000","60000","75000","20000","65000","200000")



        //Toast.makeText(this@amount_page,amnt, Toast.LENGTH_SHORT).show()

        btn.setOnClickListener {
            val amnt = amount.text.toString()
            val send = intent.getStringExtra("sender")
            val s1 = intent.getStringExtra("name_sender")

            val snd = send.toString()
            val indx = Integer.parseInt(snd)
            val mon = money[indx].toInt()
            val remaining = mon - Integer.parseInt(amnt)
            money[indx] = remaining.toString()

            val databaseHandler: DatabaseHandler= DatabaseHandler(this)
            databaseHandler.updateEmployee(EmpModelClass(indx,s1.toString(), remaining.toString()))

            Toast.makeText(this@amount_page, remaining.toString() ,Toast.LENGTH_SHORT).show()

            //val intentamnt = Intent(this@amount_page, transaction_page::class.java)


            val intent1 = Intent(this@amount_page, customer_list::class.java)
            intent1.putExtra("remain",remaining.toString())
            intent1.putExtra("position1", snd)

            val intent4 = Intent(this@amount_page, reciever_list::class.java)
            intent4.putExtra("ns",s1)
            intent4.putExtra("add",amnt)
            intent4.putExtra("money",money)
            intent4.putExtra("amount", amnt)
            startActivity(intent4)
        }







        //Toast.makeText(this@amount_page, "Selected: $sender", Toast.LENGTH_SHORT).show()
    }
}
