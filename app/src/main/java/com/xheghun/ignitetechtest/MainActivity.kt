package com.xheghun.ignitetechtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.xheghun.ignitetechtest.network.ApiClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_btn.setOnClickListener { validateInput() }
    }

     fun validateInput () {

        val emailAddr = email_address_edit.text.toString()
        val password = password_edit.text.toString()
        val error = "this field is required"
        when  {
            emailAddr.isEmpty() -> {
                email_address_layout.isErrorEnabled = true
                email_address_layout.error = error
            }

            password.isEmpty() -> {
                password_layout.isErrorEnabled = true
                password_layout.error = error
            }

            else -> {
                login_progress.visibility = View.VISIBLE
                password_layout.isErrorEnabled = false; password_layout.error = ""
                email_address_layout.isErrorEnabled = false; email_address_layout.error = ""
                makeNetworkRequest(emailAddr,password)
            }

        }
    }

    private fun makeNetworkRequest(email: String, password: String) {
        val call: Call<String> = ApiClient.getClient.login(email,password)
        val intent = Intent(this, ProfileActivity::class.java)
        intent.putExtra("email",email)
        call.enqueue(object: Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful){
                    login_progress.visibility = View.GONE
                    startActivity(intent)
                    finish()
                } else {
                    if (response.code() == 404) {
                        login_progress.visibility = View.GONE
                        startActivity(intent)
                        finish()
                    }
                }

            }

            override fun onFailure(call: Call<String>, t: Throwable) {
               // Snackbar.make(findViewById(R.id.root),"Network Error, check your Internet Connection ${t.message}",Snackbar.LENGTH_LONG).show()
                login_progress.visibility = View.GONE
                startActivity(intent)
            }
        })
    }
}
