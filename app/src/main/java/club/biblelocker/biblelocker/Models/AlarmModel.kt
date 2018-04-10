package club.biblelocker.biblelocker.Models

/**
 * Created by Sunrin on 2018-04-10.
 */
class AlarmModel(val id:Int,
                 val name:String,
                 val days:Int,
                 val vibrate : Boolean,
                 val repeat : Boolean,
                 val song : String)