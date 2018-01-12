package co.instil.databinding

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

fun EditText.onTextChanged(action: (CharSequence) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(string: Editable?) = Unit
        override fun beforeTextChanged(string: CharSequence?, start: Int, count: Int, after: Int) = Unit
        override fun onTextChanged(string: CharSequence?, start: Int, before: Int, count: Int) {
            action(string ?: "")
        }
    })
}

fun EditText.clearOnTextChangedListener() {
    onTextChanged {}
}