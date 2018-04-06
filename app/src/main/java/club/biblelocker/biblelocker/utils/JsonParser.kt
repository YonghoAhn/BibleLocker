package club.biblelocker.biblelocker.utils

import android.content.Context
import club.biblelocker.biblelocker.R
import org.json.JSONObject


/**
 * Created by misakamoe on 2018. 4. 6..
 */

class JsonParser {
    fun getBibleString(context : Context) : String
    {
        val returnValue : String = ""

        val rawFile = ByteArray(context.resources.openRawResource(R.raw.budda).available())
        val origin = String(rawFile)
        val jObject : JSONObject = JSONObject(origin)
        for()
        {

        }

        return returnValue
    }
}