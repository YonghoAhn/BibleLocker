package club.biblelocker.biblelocker.Utils

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import club.biblelocker.biblelocker.Models.AlarmDBCtrct
import club.biblelocker.biblelocker.Models.AlarmModel

class DBHelper : SQLiteOpenHelper
{
    val database_version = 1
    val database_name = ""

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(AlarmDBCtrct::sqlCreateQuery.toString())
    }

    fun insertAlarm(db: SQLiteDatabase, alarmModel: AlarmModel)
    {
        db.beginTransaction()
        try {
            db.execSQL(AlarmDBCtrct::sqlInsertQuery.toString() + "${alarmModel.name}, ${alarmModel.days}, ${alarmModel.vibrate}, ${alarmModel.repeat}, ${alarmModel.song})")
            db.setTransactionSuccessful()
        }
        catch (e : Exception)
        {

        }
        finally {
            db.endTransaction()
        }
    }

    fun deleteAlarm(db: SQLiteDatabase, id: Int)
    {
        try {
            val deleteQuery = AlarmDBCtrct::sqlDeleteQuery.toString() + " where id=$id"
            db.execSQL(deleteQuery)
        }
        catch(e:Exception)
        {

        }
    }

    fun clearDatabase(db: SQLiteDatabase)
    {
        db.execSQL(AlarmDBCtrct::sqlDropQuery.toString())
    }

    fun getAllAlarms(db: SQLiteDatabase) : ArrayList<AlarmModel>
    {
        var alarmModel = AlarmModel(0,"",0,0,0,"")
        var alarmList = ArrayList<AlarmModel>()
        val cursor = db.rawQuery(AlarmDBCtrct::sqlSelectQuery.toString(),null)
        if(cursor!=null)
        {
            if(cursor.moveToFirst())
            {
                while(cursor.moveToNext())
                {
                    alarmModel = AlarmModel(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4), cursor.getString(5))
                    alarmList.add(alarmModel)
                }
            }
        }
        return alarmList
    }

    fun getAlarm(db: SQLiteDatabase, id:Int) : AlarmModel
    {
        val cursor = db.rawQuery(AlarmDBCtrct::sqlSelectQuery.toString(),null)
        var alarmModel = AlarmModel(0,"",0,0,0,"")
        try {
            cursor.move(id)
            alarmModel = AlarmModel(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4), cursor.getString(5))
        }
        catch (e:Exception)
        { Log.d("MisakaMOE", e.message) }
        finally {
            return alarmModel
        }

    }

    fun getDBSize(db: SQLiteDatabase) : Int{
        val cursor = db.rawQuery(AlarmDBCtrct::sqlSelectQuery.toString(),null)
        return when (cursor != null) {
            true -> cursor.count
            false -> 0
        }
    }

    constructor(context: Context, name : String, version : Int) : super(context, name, null, version)

}