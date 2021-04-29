package com.decagon.week5testing


import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class ValidatorTest {

    @Test
    fun whenNumberValid(){
        val number = "08187904709"

        val validNumber = Validator.validatePhoneNumber(number)

        assertThat(validNumber).isEqualTo(true)
    }

    @Test
    fun whenNameIsValid(){
        val name = "Michael Isesele"

        val validName = Validator.validateName(name)

        assertThat(validName).isEqualTo(true)
    }

    @Test
    fun whenEmailIsValid(){
        val email = "michaelisesele@gmail.com"

        val validEmail = Validator.validateEmail(email)

        assertThat(validEmail).isEqualTo(true)
    }

    @Test
    fun whenGenderIsValid(){
        val gender = "Male"

        val validGender = Validator.validateGender(gender)

        assertThat(validGender).isEqualTo(true)
    }



    @Test
    fun whenNumberSizeIsGreaterThan14(){
        val number = "+2348187904709453"

        val validNumber = Validator.validatePhoneNumber(number)

        assertThat(validNumber).isEqualTo(false)
    }

    @Test
    fun whenNumberSizeIsGreaterThan13(){
        val number = "23481879047094543"

        val validNumber = Validator.validatePhoneNumber(number)

        assertThat(validNumber).isEqualTo(false)
    }

    @Test
    fun whenNumberSizeIsLessThan13(){
        val number = "23481879053"

        val validNumber = Validator.validatePhoneNumber(number)

        assertThat(validNumber).isEqualTo(false)
    }

    @Test
    fun whenNumberSizeIsLessThan14(){
        val number = "+234818799453"

        val validNumber = Validator.validatePhoneNumber(number)

        assertThat(validNumber).isEqualTo(false)
    }

    @Test
    fun whenNumberSizeIsGreaterThan11(){
        val number = "08187904709453"

        val validNumber = Validator.validatePhoneNumber(number)

        assertThat(validNumber).isEqualTo(false)
    }

    @Test
    fun whenNumberSizeIsLessThan11(){
        val number = "081709453"

        val validNumber = Validator.validatePhoneNumber(number)

        assertThat(validNumber).isEqualTo(false)
    }

    @Test
    fun whenNumberDoesNotHAveZeroPrefix(){
        val number = "88187904709"

        val validNumber = Validator.validatePhoneNumber(number)

        assertThat(validNumber).isEqualTo(false)
    }

    @Test
    fun whenNumberMissesADigit(){
        val number = "+23481T7904709"

        val validNumber = Validator.validatePhoneNumber(number)

        assertThat(validNumber).isEqualTo(false)
    }


    @Test
    fun whenNumberMissesADigit2(){
        val number = "234818790W709"

        val validNumber = Validator.validatePhoneNumber(number)

        assertThat(validNumber).isEqualTo(false)
    }

    @Test
    fun whenNumberMissesADigit3(){
        val number = "081R790H709"

        val validNumber = Validator.validatePhoneNumber(number)

        assertThat(validNumber).isEqualTo(false)
    }


    @Test
    fun whenNameIsEmpty(){
        val name = ""

        val validName = Validator.validateName(name)

        assertThat(validName).isEqualTo(false)
    }

    @Test
    fun whenNameIsLessThan2(){
        val name = "T"

        val validName = Validator.validateName(name)

        assertThat(validName).isEqualTo(false)
    }

    @Test
    fun whenEmailHasNoSign(){
        val email = "michaeliseselegmail.com"

        val validEmail = Validator.validateEmail(email)

        assertThat(validEmail).isEqualTo(false)
    }

    @Test
    fun whenEmailHasNodomain(){
        val email = "michaelisesele@gmail."

        val validEmail = Validator.validateEmail(email)

        assertThat(validEmail).isEqualTo(false)
    }

    @Test
    fun whenEmailHasNoidentifier(){
        val email = "michaelisesele@.com"

        val validEmail = Validator.validateEmail(email)

        assertThat(validEmail).isEqualTo(false)
    }


    @Test
    fun whenEmailHasMoreTHanOneAt(){
        val email = "michaelisesele@@@gmail.com"

        val validEmail = Validator.validateEmail(email)

        assertThat(validEmail).isEqualTo(false)
    }

    @Test
    fun whenGenderIsInValid(){
        val gender = "Select Gender"

        val validGender = Validator.validateGender(gender)

        assertThat(validGender).isEqualTo(false)
    }
}