package club.biblelocker.biblelocker.utils

import android.content.Context
import android.util.Log
import club.biblelocker.biblelocker.R
import club.biblelocker.biblelocker.models.TodayString
import org.json.JSONArray
import java.io.InputStreamReader

class JsonParser {
    fun getBuddaString(context : Context) : TodayString
    {
        val returnValue = TodayString("", "", 0, 0, 0, 1)
        try {
            val jObject = JSONArray(InputStreamReader(context.resources.openRawResource(R.raw.budda)).readText()).getJSONObject(1).getJSONArray("sentences").getJSONObject(1) //Short index
            returnValue.content = jObject.getString("line")
            returnValue.part = jObject.getString("part")
            returnValue.num = jObject.getInt("num")
            returnValue.len = jObject.getInt("len")
        } catch (e: Exception) {
            Log.d("MisakaMOE", e.message)
        }
        return returnValue
    }

    fun getBibleString(context: Context): TodayString {
        val returnValue = TodayString("", "", 0, 0, 0, 1)
        try {
            val jObject = JSONArray(InputStreamReader(context.resources.openRawResource(R.raw.bible)).readText()).getJSONObject(0).getJSONArray("sentences").getJSONObject(0).getJSONArray("dex").getJSONObject(0) //Short index
            returnValue.content = jObject.getString("line")
            returnValue.part = jObject.getString("part")
            returnValue.num = jObject.getInt("num")
            returnValue.len = jObject.getInt("len")
            returnValue.page = jObject.getInt("page")
            returnValue.rows = jObject.getInt("rows")
        } catch (e: Exception) {
            Log.d("MisakaMOE", e.message)
        }
        return returnValue
    }
}