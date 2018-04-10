package club.biblelocker.biblelocker.Activities

import android.app.AlarmManager
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import club.biblelocker.biblelocker.BroadcastReceiver.AlarmReceiver
import club.biblelocker.biblelocker.R
import kotlinx.android.synthetic.main.activity_test.*
import java.util.*

class TestActivity : AppCompatActivity() {

    var context : Context = applicationContext

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        var alarmManager : AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val calendar = Calendar.getInstance()
        val intent = Intent(applicationContext, AlarmReceiver::class.java)

    }
}
