package co.instil.databinding

import android.databinding.ObservableField

class DemoViewModel {

    val buttonVisible = true
    val text = ObservableField("Data binding works!")

    fun buttonClicked() {
        text.set("Button clicked!")
    }

}
