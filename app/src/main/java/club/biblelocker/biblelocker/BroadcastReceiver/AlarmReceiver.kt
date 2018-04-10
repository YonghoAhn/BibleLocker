package club.biblelocker.biblelocker.BroadcastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import club.biblelocker.biblelocker.Activities.TestActivity

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val instance = TestActivity::getInstance


        var alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        }
        val ringtone = RingtoneManager.getRingtone(context, alarmUri)
        ringtone.play()
    }
}
