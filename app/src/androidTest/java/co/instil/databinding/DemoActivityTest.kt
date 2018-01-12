package co.instil.databinding

import android.support.annotation.ColorRes
import android.support.annotation.IdRes
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.hasTextColor
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import org.hamcrest.CoreMatchers.allOf
import org.junit.Rule
import org.junit.Test

class DemoActivityTest {

    @Rule @JvmField val activityTestRule = ActivityTestRule(DemoActivity::class.java, true, true)

    @Test
    fun shouldHaveDataboundText() {
        assertViewWithTextIsDisplayed("Data binding works!")
    }

    @Test
    fun shouldChangeTextWhenButtonClicked() {
        tapViewWithId(R.id.databindingButton)

        assertViewWithTextIsDisplayed("Button clicked!")
    }

    @Test
    fun shouldHaveTextAsBlackIfLessThanTenCharactersForBindingAdapterEditText() {
        typeTextIntoView(R.id.bindingAdapterEditText, "123")

        assertThatTextForViewIsTheColor(R.id.bindingAdapterEditText, R.color.black)
    }

    @Test
    fun shouldHaveTextAsRedIfMoreThanTenCharactersForBindingAdapterEditText() {
        typeTextIntoView(R.id.bindingAdapterEditText, "1234567890123")

        assertThatTextForViewIsTheColor(R.id.bindingAdapterEditText, R.color.red)
    }

    @Test
    fun shouldHaveTextAsBlackIfLessThanTenCharactersForCustomClassEditText() {
        typeTextIntoView(R.id.customClassEditText, "123")

        assertThatTextForViewIsTheColor(R.id.customClassEditText, R.color.black)
    }

    @Test
    fun shouldHaveTextAsRedIfMoreThanTenCharactersForCustomClassEditText() {
        typeTextIntoView(R.id.customClassEditText, "1234567890123")

        assertThatTextForViewIsTheColor(R.id.customClassEditText, R.color.red)
    }

    private fun tapViewWithId(@IdRes id: Int) {
        onView(withId(id))
                .check(matches(isDisplayed()))
                .perform(click())
    }

    private fun assertViewWithTextIsDisplayed(expectedText: String) {
        onView(withText(expectedText))
                .check(matches(isDisplayed()))
    }

    private fun typeTextIntoView(@IdRes viewId: Int, text: String) {
        onView(allOf(withId(viewId), isDisplayed()))
                .perform(typeText(text))
    }

    private fun assertThatTextForViewIsTheColor(@IdRes viewId: Int, @ColorRes colorId: Int) {
        onView(allOf(withId(viewId), isDisplayed()))
                .check(matches(hasTextColor(colorId)))
    }

}