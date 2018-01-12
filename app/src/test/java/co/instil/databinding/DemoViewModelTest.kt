package co.instil.databinding

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Test

class DemoViewModelTest {

    private val target = DemoViewModel()

    @Test
    fun shouldUpdateTextWithButtonClicked() {
        assertThat(target.text.get(), `is`("Data binding works!"))

        target.buttonClicked()

        assertThat(target.text.get(), `is`("Button clicked!"))
    }

}