package com.decagon.week5testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_profile_page.*

class ProfilePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // set layout to desired XML
        setContentView(R.layout.activity_profile_page)

        // check if incoming intent has bundle or parcelable or if its null
        intent?.let {

            // set the value of USER in parcelable coming from main activity to a variable user
            val user: User? = intent.extras?.getParcelable(MainActivity.USER)

            // ensure the value from the parcelable is not nul, set the values to appropriate text views.
            if (user != null) {
                profilePage_email.text = user.email
                profilePage_gender.text = user.gender
                profilePage_name.text = user.name
                profilePage_number.text = user.phoneNumber
            }
        }
    }
}