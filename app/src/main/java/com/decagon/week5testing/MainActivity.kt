package com.decagon.week5testing

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.decagon.week5testing.databinding.ActivityMainBinding

/**
 * @param name -> username Input by the user
 * @param phoneNumber -> PhoneNumber input by user
 * @param email -> email input by user
 * @param gender -> Gender selected by user
*  @param ValidatedName -> Holds value of validated username Input by the user
 * @param ValidatedPhoneNumber -> Holds value of validated PhoneNumber input by user
 * @param ValidatedEmail -> Holds value of validated email input by user
 * @param ValidatedGender -> Holds value of validated gender selected by user
 *
 */

class MainActivity : AppCompatActivity() {

    // create companion object to access variable USER from Profile Page.
    companion object{
        const val USER = "user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // activate binding
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set click listener to button
        binding.registerButton.setOnClickListener{

            // inputs by the user
        val name = binding.editNameInput.text.toString().trim()
        val phoneNumber = binding.editPhoneNumber.text.toString().trim()
        val email = binding.mail.text.trim()
        val gender = binding.selectGender.selectedItem.toString().trim()


            // inputs by the user validated through the Validator Class methods
        val validatedName = Validator.validateName(name)
        val validatedPhoneNumber = Validator.validatePhoneNumber(phoneNumber)
        val validatedEmail = Validator.validateEmail(email)
        val validatedGender = Validator.validateGender(gender)


            // lunches the next activity if all inputs are validated and true
        if (validatedEmail && validatedPhoneNumber && validatedName && validatedGender){

            // create  new user parcelable object from the user data class.
            val user = User(name, email.toString(), phoneNumber, gender)

            // create new intent to profile page
            val intent = Intent(this, ProfilePage::class.java)

            // send verified data to second activity using parcelable via its key - value pair.
            intent.putExtra(USER, user)
            startActivity(intent)

        } else {

            // send error messages based on specific invalid input.
            when {
                !validatedName -> Toast.makeText(this, "Name cannot be less than 2 characters", Toast.LENGTH_LONG).show()
                !validatedPhoneNumber -> Toast.makeText(this, "Please input a valid Nigerian Phone Number starting with 0 or 234.", Toast.LENGTH_LONG).show()
                !validatedEmail -> Toast.makeText(this, "Please input a valid email address", Toast.LENGTH_LONG).show()
                !validatedGender -> Toast.makeText(this, "Please select a gender", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
