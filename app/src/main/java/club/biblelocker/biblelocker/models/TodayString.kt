package club.biblelocker.biblelocker.models

/**
 * Created by misakamoe on 2018. 4. 6..
 */

data class TodayString (
        val content : String,
        val part : String,
        val page : Int?,
        val rows : Int?,
        val len : Int,
        val num : Int
)