package co.instil.databinding

import android.databinding.BindingAdapter
import android.support.v4.content.ContextCompat
import android.widget.EditText

@BindingAdapter("textLengthWarning")
fun textLengthWarning(view: EditText, textLengthWarningEnabled: Boolean) {
    if (!textLengthWarningEnabled) {
        view.clearOnTextChangedListener()
        return
    }

    view.onTextChanged {
        if (view.text.length > 10) {
            view.setTextColor(ContextCompat.getColor(view.context, R.color.red))
        } else {
            view.setTextColor(ContextCompat.getColor(view.context, R.color.black))
        }
    }
}