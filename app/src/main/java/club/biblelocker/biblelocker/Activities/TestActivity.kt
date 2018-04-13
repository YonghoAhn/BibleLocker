package club.biblelocker.biblelocker.Activities

import android.app.AlarmManager
import android.app.AlarmManager.RTC_WAKEUP
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.Toolbar
import club.biblelocker.biblelocker.BroadcastReceiver.AlarmReceiver
import club.biblelocker.biblelocker.MainActivity
import club.biblelocker.biblelocker.R
import junit.framework.Test
import kotlinx.android.synthetic.main.activity_test.*
import java.util.*
import java.util.Calendar.HOUR_OF_DAY
import java.util.Calendar.MINUTE

class TestActivity : AppCompatActivity() {

    fun getStatusBarHeight() : Int {
        var result = 0
        val resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId)
        }
        return result
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val alarmManager : AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val calendar = Calendar.getInstance()

        val alarmIntent = Intent(this, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this,0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        alarm_on.setOnClickListener({

            if (Build.VERSION.SDK_INT < 23)
            {
                calendar.set(HOUR_OF_DAY,timePicker.currentHour)
                calendar.set(MINUTE,timePicker.currentMinute)
            }
            else {
                calendar.set(HOUR_OF_DAY, timePicker.hour)
                calendar.set(MINUTE, timePicker.minute)
            }

            Log.d("MisakaMOE",calendar.time.toString())

            alarmManager.set(
                    RTC_WAKEUP,
                    calendar.timeInMillis,
                    pendingIntent
            )

            Toast.makeText(this,"Alarm set",Toast.LENGTH_SHORT).show()
            Log.d("MisakaMOE", "Alarm Set")

        })

    }
}
