package club.biblelocker.biblelocker.Models

class AlarmDBCtrct
{
    val table = "ALARM"
    val id = "ID"
    val name = "NAME"
    val days = "DAYS"
    val vibrate = "VIBRATE"
    val repeat = "REPEAT"
    val song = "SONG"

    val sqlCreateQuery = "CREATE TABLE IF NOT EXISTS $table($id INTEGER PRIMARY KEY AUTOINCREMENT, $name TEXT NOT NULL, $days INTEGER NOT NULL, $vibrate INTEGER NOT NULL, $repeat INTEGER NOT NULL, $song TEXT NOT NULL"

    val sqlDropQuery = "DROP TABLE IF EXISTS $table"

    val sqlSelectQuery = "SELECT * FROM $table"

    val sqlInsertQuery = "INSERT OR REPLACE INTO $table ($name, $days, $vibrate, $repeat, $song) VALUES ("

    val sqlDeleteQuery = "DELETE FROM $table"
}