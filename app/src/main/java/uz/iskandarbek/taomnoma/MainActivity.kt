package uz.iskandarbek.taomnoma

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import uz.iskandarbek.taomnoma.activitys.TaomnomaActivity
import uz.iskandarbek.taomnoma.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.apply {
            start.setOnClickListener {
                startActivity(Intent(this@MainActivity, TaomnomaActivity::class.java))
            }
        }
    }
}