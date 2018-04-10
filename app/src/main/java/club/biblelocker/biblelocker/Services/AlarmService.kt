package club.biblelocker.biblelocker.Services

import android.app.IntentService
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.Context
import android.support.v4.app.NotificationCompat
import club.biblelocker.biblelocker.Activities.TestActivity
import club.biblelocker.biblelocker.R

class AlarmService : IntentService("AlarmService") {

    override fun onHandleIntent(intent: Intent?) {
        sendNotification("Alarm")
    }

    private fun sendNotification(string : String)
    {
        val alarmManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val pendingIntent = PendingIntent.getActivity(this, 0, Intent(this, TestActivity::class.java),0) as PendingIntent
        val alarmNotificationBuilder = NotificationCompat.Builder(this,"MisakaMOE").setContentTitle("Alarm").setSmallIcon(R.mipmap.ic_launcher)
                .setStyle(NotificationCompat.BigTextStyle().bigText(""))
                .setContentText(string).setContentIntent(pendingIntent)
        alarmManager.notify(1,alarmNotificationBuilder.build())
    }
}
