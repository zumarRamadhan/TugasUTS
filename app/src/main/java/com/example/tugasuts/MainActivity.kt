package com.example.tugasuts

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Penyesuaian insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ambil semua inputan
        val editUsername = findViewById<EditText>(R.id.editUsername)
        val editEmail = findViewById<EditText>(R.id.editEmail)
        val editFirstName = findViewById<EditText>(R.id.editFirstName)
        val editLastName = findViewById<EditText>(R.id.editLastName)
        val editPassword = findViewById<EditText>(R.id.editPassword)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val btnCancel = findViewById<Button>(R.id.btnCancel)

        // Tombol Kirim
        btnSubmit.setOnClickListener {
            val username = editUsername.text.toString().trim()
            val email = editEmail.text.toString().trim()
            val firstName = editFirstName.text.toString().trim()
            val lastName = editLastName.text.toString().trim()
            val password = editPassword.text.toString().trim()

            if (username.isEmpty() || email.isEmpty() || firstName.isEmpty() ||
                lastName.isEmpty() || password.isEmpty()
            ) {
                Toast.makeText(this, "Semua kolom harus diisi!", Toast.LENGTH_LONG).show()
            } else {
                val fullName = "$firstName $lastName"
                Toast.makeText(
                    this,
                    "Pendaftaran berhasil!\nNama: $fullName",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        // Tombol Batal
        btnCancel.setOnClickListener {
            editUsername.text.clear()
            editEmail.text.clear()
            editFirstName.text.clear()
            editLastName.text.clear()
            editPassword.text.clear()
            Toast.makeText(this, "Form dibersihkan", Toast.LENGTH_SHORT).show()
        }
    }
}
