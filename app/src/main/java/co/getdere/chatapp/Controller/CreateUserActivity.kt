package co.getdere.chatapp.Controller

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import co.getdere.chatapp.R
import co.getdere.chatapp.Services.AuthService
import kotlinx.android.synthetic.main.activity_create_user.*
import java.util.*

class CreateUserActivity : AppCompatActivity() {

    var userAvater = "profileDefault"
    var avatarColor = "[0.5, 0.5, 0.5, 1]"

    lateinit var nameInput: String
    lateinit var emailInput: String
    lateinit var passwordInput: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)

        nameInput = create_user_name_text.text.toString()
        emailInput = create_email_text.text.toString()
        passwordInput = create_password_text.text.toString()

    }

    fun generateUserAvatar(view: View) {
        val random = Random()
        val color = random.nextInt(2)
        val avatar = random.nextInt(28)

        if (color == 0) {
            userAvater = "light$avatar"
        } else {
            userAvater = "dark$avatar"
        }
        val resourceId = resources.getIdentifier(userAvater, "drawable", packageName)
        create_avatar_image_view.setImageResource(resourceId)
    }


    fun generateColorClicked(view: View) {

        val random = Random()
        val r = random.nextInt(255)
        val g = random.nextInt(255)
        val b = random.nextInt(255)

        create_avatar_image_view.setBackgroundColor(Color.rgb(r, g, b))

        val savedR = r.toDouble() / 255
        val savedG = g.toDouble() / 255
        val savedB = b.toDouble() / 255

        avatarColor = "[$savedR, $savedG, $savedB, 1"
    }

    fun createUserClicked(view: View) {
        AuthService.registerUser(this, emailInput, passwordInput, { registerSuccess ->
            if (registerSuccess) {
//                AuthService.loginUser(this, emailInput, passwordInput, { loginSuccess ->
//                    if (loginSuccess) {
//                    }
//                })
            }
        })
    }

}
