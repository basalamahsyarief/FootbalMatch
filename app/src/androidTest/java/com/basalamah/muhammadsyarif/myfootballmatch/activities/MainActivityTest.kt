package com.basalamah.muhammadsyarif.myfootballmatch.activities

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.basalamah.muhammadsyarif.myfootballmatch.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun NextMatch() {
        Thread.sleep(5000)
        onView(withId(R.id.rvNext)).run {
            Thread.sleep(5000)
            perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
            Thread.sleep(2000)
            perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(2))
            Thread.sleep(2000)
            perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click()))
            Thread.sleep(5000)
        }
    }

    @Test
    fun PastMatch() {
        for(i in 0..20) {

            Thread.sleep(5000)
            onView(withId(R.id.navigation_dashboard)).perform(click())
            //Thread.sleep(5000)
            onView(withId(R.id.rvPast)).run {
                Thread.sleep(3000)
                perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
            }
            Thread.sleep(5000)
            onView(withId(R.id.ic_fav)).perform(click())
            Thread.sleep(1000)
            pressBack()
            onView(withId(R.id.navigation_favorite)).perform(click())
            onView(withId(R.id.rvFav)).check(matches(isDisplayed()))
        }
    }
}