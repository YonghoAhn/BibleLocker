package club.biblelocker.biblelocker.Utils

import android.content.Context
import club.biblelocker.biblelocker.Models.AlarmModel
import java.util.*

class AlarmController {


    /*
        Adds an alarm to AlarmManager and DB.

        @param [context] : application context.
        @param [calendar] : alarm calendar.

        @return the Index of Alarm
    */

    fun addAlarm(context: Context, alarmModel: AlarmModel) : Int
    {
        val db = DBHelper(context, "alarm.db",1)
        return db.insertAlarm(db.writableDatabase,alarmModel)
    }

    /*
        Remove an alarm from DB and alarmManager.

        @param [context] : application context.
        @param [int] : index of alarm

        @return successful? or not?
     */

    fun removeAlarm(context: Context, int: Int)
    {
        val db = DBHelper(context, "alarm.db",1)
        db.deleteAlarm(db.writableDatabase,int)
    }

}