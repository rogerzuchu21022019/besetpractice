package nam.rogerzuchu.bestpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import nam.rogerzuchu.bestpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindMainBinding.root)
    }
}