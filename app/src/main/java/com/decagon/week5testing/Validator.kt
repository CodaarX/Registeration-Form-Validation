package com.decagon.week5testing

import java.util.regex.Pattern
import java.util.regex.Pattern.compile

object Validator {

    // validate phone number with regex
    fun validatePhoneNumber(phoneNumber: String): Boolean {
        val phoneValidator: Pattern = compile("^(0|234)((70)|([89][01]))([0-9]{8})$")
        return phoneValidator.matcher(phoneNumber).matches()
    }

    // validate gender
    fun validateGender(gender: String): Boolean {
        return gender != "Select Gender"
    }

    // validate email
    fun validateEmail(email: CharSequence): Boolean {
        val emailRegex = compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}"
                    + "\\@"
                    + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}"
                    + "("
                    + "\\."
                    + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}"
                    + ")+"
        )
        return email.isNotEmpty() &&  emailRegex.matcher(email).matches()
    }

    // validate name
    fun validateName(name: String): Boolean {
        return name.isNotEmpty() && name.length > 2
    }
}