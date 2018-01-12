package co.instil.databinding

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.instil.databinding.databinding.ActivityDemoBinding

class DemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityDemoBinding>(this, R.layout.activity_demo)
        binding.vm = DemoViewModel() // Injecting the view model into the layout file
    }
}
