package com.decagon.week5testing


import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.CoreMatchers.anything
import org.hamcrest.CoreMatchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    companion object {
        const val NAME = "Michael Bash"
        const val PHONE = "08183745139"
        const val GENDER = "Male"
        const val EMAIL = "michaelisesele@gmail.com"
    }

    @get:Rule
    val activityScenerio = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_IsActivityInView() {
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun test_All_InputFields_In_VIew () {
        onView(withId(R.id.edit_NameInput)).check(matches(isDisplayed()))
        onView(withId(R.id.edit_phoneNumber)).check(matches(isDisplayed()))
        onView(withId(R.id.textInput_email)).check(matches(isDisplayed()))
        onView(withId(R.id.selectGender)).check(matches(isDisplayed()))
    }

    @Test
    fun test_register_button_visibility(){
        onView(withId(R.id.registerButton)).check(matches(isDisplayed()))
    }

    @Test
    fun test_successful_login(){
        onView(withId(R.id.edit_NameInput)).perform(replaceText(NAME))
        onView(withId(R.id.edit_phoneNumber)).perform(replaceText(PHONE))
        onView(withId(R.id.mail)).perform(replaceText(EMAIL))

        onView(withId(R.id.selectGender)).perform(click());
        onData(anything()).atPosition(1).perform(click());
        onView(withId(R.id.selectGender)).check(matches(withSpinnerText(containsString(GENDER))));

        onView(withId(R.id.registerButton)).perform(click())
        onView(withId(R.id.second_main)).check(matches(isDisplayed()))


        // check if new activity contains sent intent

        onView(withId(R.id.profilePage_email)).check(matches(isDisplayed()))
        onView(withId(R.id.profilePage_gender)).check(matches(isDisplayed()))
        onView(withId(R.id.profilePage_name)).check(matches(isDisplayed()))
        onView(withId(R.id.profilePage_number)).check(matches(isDisplayed()))


        onView(withId(R.id.profilePage_email)).check(matches(withText(EMAIL)))
        onView(withId(R.id.profilePage_gender)).check(matches(withText(GENDER)))
        onView(withId(R.id.profilePage_name)).check(matches(withText(NAME)))
        onView(withId(R.id.profilePage_number)).check(matches(withText(PHONE)))
    }
}

