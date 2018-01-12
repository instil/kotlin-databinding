package co.instil.databinding

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.widget.EditText

class EditTextWithTextLimitCheck @JvmOverloads constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int = R.attr.editTextStyle) : EditText(context, attrs, defStyleAttr) {

    private val red = ContextCompat.getColor(context, R.color.red)
    private val black = ContextCompat.getColor(context, R.color.black)

    fun setCustomElementTextLengthWarning(enabled: Boolean) {
        if (enabled) {
            enableTextLimitCheck()
        } else {
            disableTextLimitCheck()
        }
    }

    private fun enableTextLimitCheck() {
        onTextChanged { text ->
            if (text.length > 10) {
                setTextColor(red)
            } else {
                setTextColor(black)
            }
        }
    }

    private fun disableTextLimitCheck() {
        clearOnTextChangedListener()
    }

}