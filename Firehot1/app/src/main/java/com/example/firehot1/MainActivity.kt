package com.example.firehot1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btclear.setOnClickListener {
            name.setText("")
            Lname.setText("")
        }

        btsend.setOnClickListener {
            val first = name.text.toString()
            val last = Lname.text.toString()

            val firebase = FirebaseDatabase.getInstance()
            val ref = firebase.getReference("Employee")
            val id:String? = ref.push().key

            val Employee = Employee(id.toString(),first,last)

            ref.child(id.toString()).setValue(Employee).addOnCompleteListener{
                Toast.makeText(applicationContext,"Complete", Toast.LENGTH_LONG).show()
                name.setText("")
                Lname.setText("")
            }
        }

    }
}