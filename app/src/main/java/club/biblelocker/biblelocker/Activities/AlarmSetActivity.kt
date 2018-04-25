package club.biblelocker.biblelocker.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.Toast
import club.biblelocker.biblelocker.R
import kotlinx.android.synthetic.main.activity_alarm_set.*

class AlarmSetActivity : AppCompatActivity() {

    var volume: Int = 0
    var vibrate: Boolean = false
    var repeat: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_set)

        seekVolume.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Write code to perform some action when progress is changed.
                volume = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is started.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is stopped.
            }

        })

        swVibrate.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                vibrate = p1
            }
        })

        swRepeat.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                repeat = p1
            }

        })

        make_ok.setOnClickListener {
            val hour = txtHour.text
            val min = txtMin.text
            //volume, vibrate, repeat

        }
    }
}

