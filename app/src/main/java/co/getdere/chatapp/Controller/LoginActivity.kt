package co.getdere.chatapp.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import co.getdere.chatapp.R
import co.getdere.chatapp.Services.AuthService
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun loginLoginBtnClicked(view: View) {

        val email = login_email_text.text.toString()
        val password = login_password_text.text.toString()

        AuthService.loginUser(this, email, password, { loginSuccess ->

            if (loginSuccess) {
                AuthService.findUserByEmail(this, { findSuccess ->
                    if (findSuccess) {
                        finish()
                    }
                })
            }
        })

    }

    fun loginCreateUserBtnClicked(view: View) {
        val createUserIntent = Intent(this, CreateUserActivity::class.java)
        startActivity(createUserIntent)
        finish()
    }
}
