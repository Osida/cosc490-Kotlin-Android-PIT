package code.with.cal.kotlincalculatorapp


import androidx.test.espresso.DataInteraction
import androidx.test.espresso.ViewInteraction
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent

import androidx.test.InstrumentationRegistry.getInstrumentation
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*

import code.with.cal.kotlincalculatorapp.R

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anything
import org.hamcrest.Matchers.`is`

@LargeTest
@RunWith(AndroidJUnit4::class)
class AdditionTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun additionTest() {
        val appCompatButton = onView(
allOf(withText("4"),
childAtPosition(
childAtPosition(
withClassName(`is`("android.widget.LinearLayout")),
3),
0),
isDisplayed()))
        appCompatButton.perform(click())
        
        val appCompatButton2 = onView(
allOf(withText("2"),
childAtPosition(
childAtPosition(
withClassName(`is`("android.widget.LinearLayout")),
4),
1),
isDisplayed()))
        appCompatButton2.perform(click())
        
        val appCompatButton3 = onView(
allOf(withText("+"),
childAtPosition(
childAtPosition(
withClassName(`is`("android.widget.LinearLayout")),
4),
3),
isDisplayed()))
        appCompatButton3.perform(click())
        
        val appCompatButton4 = onView(
allOf(withText("1"),
childAtPosition(
childAtPosition(
withClassName(`is`("android.widget.LinearLayout")),
4),
0),
isDisplayed()))
        appCompatButton4.perform(click())
        
        val appCompatButton5 = onView(
allOf(withText("2"),
childAtPosition(
childAtPosition(
withClassName(`is`("android.widget.LinearLayout")),
4),
1),
isDisplayed()))
        appCompatButton5.perform(click())
        
        val appCompatButton6 = onView(
allOf(withText("="),
childAtPosition(
childAtPosition(
withClassName(`is`("android.widget.LinearLayout")),
5),
2),
isDisplayed()))
        appCompatButton6.perform(click())
        
        val textView = onView(
allOf(withId(R.id.resultsTV), withText("54.0"),
withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
isDisplayed()))
        textView.check(matches(withText("54.0")))
        }
    
    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
    }
