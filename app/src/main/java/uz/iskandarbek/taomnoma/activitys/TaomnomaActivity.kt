package uz.iskandarbek.taomnoma.activitys

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.iskandarbek.taomnoma.R
import uz.iskandarbek.taomnoma.RvAdapter.RvAdapter
import uz.iskandarbek.taomnoma.User
import uz.iskandarbek.taomnoma.databinding.ActivityTaomnomaBinding

class TaomnomaActivity : AppCompatActivity(), RvAdapter.RvAction {
    private val binding by lazy { ActivityTaomnomaBinding.inflate(layoutInflater) }
    private var mediaPlayer: MediaPlayer? = null
    lateinit var list: ArrayList<User>
    lateinit var adapter: RvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadData()

        adapter = RvAdapter(list, this)
        binding.rv.adapter = adapter

        mediaPlayer = MediaPlayer.create(this, R.raw.navastoki)
        mediaPlayer?.setVolume(0.05f, 0.05f)  // Ovoz balandligini past darajaga o‘rnating
        mediaPlayer?.isLooping = true  // Musiqani doimiy ravishda ijro etish=-
    }

    override fun onStart() {
        super.onStart()
        mediaPlayer?.start()  // Musiqani ijro etishni boshlash
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer?.pause()  // Musiqani to‘xtatish
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()  // Resurslarni tozalash
        mediaPlayer = null
    }


    private fun loadData() {
        list = ArrayList()
        list.add(
            User(
                "Kabob",
                R.drawable.kabob,
                "https://www.youtube.com/watch?v=Z2kPV8nw0TQ&pp=ygUQS2Fib2IgdGF5eW9ybGFzaA%3D%3D"
            )
        )
        list.add(
            User(
                "Osh",
                R.drawable.palov,
                "https://www.youtube.com/watch?v=XcT1_YbXuCI&pp=ygUOb3NoIHRheXlvcmxhc2g%3D"
            )
        )
        list.add(
            User(
                "Manti",
                R.drawable.manti,
                "https://www.youtube.com/watch?v=SQrOVm8gEYQ&pp=ygUQbWFudGkgdGF5eW9ybGFzaA%3D%3D"
            )
        )
        list.add(
            User(
                "Lag'mon",
                R.drawable.lagmon,
                "https://www.youtube.com/watch?v=i4rz5oT82jg&pp=ygUSTEFHJ01PTiB0YXl5b3JsYXNo"
            )
        )
        list.add(
            User(
                "Moshkichra",
                R.drawable.moshkichri,
                "https://www.youtube.com/watch?v=IyNbzFQZz7c&pp=ygUVbW9zaGtpY2hyYSB0YXl5b3JsYXNo"
            )
        )
        list.add(
            User(
                "Shashlik",
                R.drawable.shashlik,
                "https://www.youtube.com/watch?v=hDSd5HejgOo&pp=ygUSc2hhc2hsaWt0YXl5b3JsYXNo"
            )
        )
        list.add(
            User(
                "Somsa",
                R.drawable.somsa,
                "https://www.youtube.com/watch?v=6DH_adTfgdA&pp=ygUQc29tc2EgdGF5eW9ybGFzaA%3D%3D"
            )
        )
        list.add(
            User(
                "Tandir go'sht",
                R.drawable.tandirgosht,
                "https://www.youtube.com/watch?v=1zXF_OE5Ahs&pp=ygUXdGFuZGlyIGcnb3NodHRheXlvcmxhc2g%3D"
            )
        )
        list.add(
            User(
                "Dimlama",
                R.drawable.dimlama,
                "https://www.youtube.com/watch?v=k20Eesb4Hig&pp=ygUTZGltbGFtYSAndGF5eW9ybGFzaA%3D%3D"
            )
        )
        list.add(
            User(
                "Sho'rva",
                R.drawable.shorva,
                "https://www.youtube.com/watch?v=Nll2_JhtRdM&pp=ygUSc2hvcnZhICd0YXl5b3JsYXNo"
            )
        )
        list.add(
            User(
                "Shavla",
                R.drawable.shovla,
                "https://www.youtube.com/watch?v=FxmC5YS8-lU&pp=ygUSc2hhdmxhICd0YXl5b3JsYXNo"
            )
        )
        list.add(
            User(
                "Chuchvara",
                R.drawable.chuchvara,
                "https://www.youtube.com/watch?v=jHo1UjXc4HM&pp=ygUUY2h1Y2h2YXJhJ3RheXlvcmxhc2g%3D"
            )
        )
        list.add(
            User(
                "Qovurma lag'mon",
                R.drawable.qovurmalagmon,
                "https://www.youtube.com/watch?v=yYu2H1Nc1kQ&pp=ygUbcW92dXJtYSBsYWcnbW9uICd0YXl5b3JsYXNo"
            )
        )
        list.add(
            User(
                "Norin",
                R.drawable.norin,
                "https://www.youtube.com/watch?v=g6KwbEO7Vyc&pp=ygUQbm9yaW4gdGF5eW9ybGFzaA%3D%3D"
            )
        )
    }

    override fun onClick(user: User) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(user.videLink))
        startActivity(intent)
    }
}