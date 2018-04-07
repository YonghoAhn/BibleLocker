package club.biblelocker.biblelocker

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import club.biblelocker.biblelocker.utils.JsonParser
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val jsonParser = JsonParser()
        val todayString = jsonParser.getBuddaString(applicationContext)
        txtView.text = todayString.content
        textView.text = jsonParser.getBibleString(applicationContext).content
    }
}
