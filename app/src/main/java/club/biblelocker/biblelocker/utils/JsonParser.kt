package club.biblelocker.biblelocker.utils

import android.content.Context
import club.biblelocker.biblelocker.R
import club.biblelocker.biblelocker.models.TodayString
import org.json.JSONArray
import java.io.InputStreamReader

class JsonParser {
    fun getBuddaString(context : Context) : TodayString
    {
        var returnValue = TodayString("","",0,0,0,1)
        val origin = InputStreamReader(context.resources.openRawResource(R.raw.budda)).readText()

        val jObject = JSONArray(origin).getJSONObject(1).getJSONArray("sentences").getJSONObject(1) //Short index

        
        returnValue.content = jObject.getString("line")
        returnValue.part = jObject.getString("part")
        returnValue.num = jObject.getInt("num")
        returnValue.len = jObject.getInt("len")

        return returnValue
    }
}