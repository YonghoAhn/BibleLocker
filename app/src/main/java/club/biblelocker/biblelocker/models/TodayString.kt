package club.biblelocker.biblelocker.models

/**
 * Created by misakamoe on 2018. 4. 6..
 */

data class TodayString (
        var content : String,
        var part : String,
        var page : Int?,
        var rows : Int?,
        var len : Int,
        var num : Int
)