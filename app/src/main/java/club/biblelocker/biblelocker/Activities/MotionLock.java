package club.biblelocker.biblelocker.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import club.biblelocker.biblelocker.R;

public class MotionLock extends AppCompatActivity {


    Button ok, cancel;

    LinearLayout one, two, three, four, five, six, seven, eight, nine;

    String motion_pass_result = "";

    Handler mHandler = new Handler();

    Vibrator vibrator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_motion_lock);
        ok = findViewById(R.id.make_ok);
        cancel = findViewById(R.id.make_cancel);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        one = findViewById(R.id.motion_one);
        two = findViewById(R.id.motion_two);
        three = findViewById(R.id.motion_three);
        four = findViewById(R.id.motion_four);
        five = findViewById(R.id.motion_five);
        six = findViewById(R.id.motion_six);
        seven = findViewById(R.id.motion_seven);
        eight = findViewById(R.id.motion_eight);
        nine = findViewById(R.id.motion_nine);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                one.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.motion_lock_outline_light));
                vibrator.vibrate(10);
                motion_pass_result = motion_pass_result.concat("1");

            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);
                motion_pass_result = motion_pass_result.concat("2");

            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);
                motion_pass_result = motion_pass_result.concat("3");

            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);
                motion_pass_result = motion_pass_result.concat("4");


            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);
                motion_pass_result = motion_pass_result.concat("5");

            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                vibrator.vibrate(10);
                motion_pass_result = motion_pass_result.concat("6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(10);
                motion_pass_result = motion_pass_result.concat("7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(10);
                motion_pass_result = motion_pass_result.concat("8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(10);
                motion_pass_result = motion_pass_result.concat("9");
            }
        });


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (motion_pass_result.length() < 4) {

                    Toast.makeText(MotionLock.this, "적어도 4개 이상의 모션을 입력해 주세요.", Toast.LENGTH_SHORT).show();
                    motion_pass_result = "";

                } else {
                    removePreferences();
                    save_motionpass();
                    Toast.makeText(MotionLock.this, motion_pass_result, Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(MotionLock.this, MotionLockCheck.class);
                    startActivity(intent1);
                    finish();

                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removePreferences();
                Intent intent2 = new Intent(MotionLock.this, Main2Activity.class);
                startActivity(intent2);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {

    }


    private void save_motionpass() {


        SharedPreferences pref = getSharedPreferences("motion_pass", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("motion_pass", motion_pass_result);
        editor.commit();
    }

    private void removePreferences() {
        SharedPreferences pref = getSharedPreferences("motion_pass", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove("motion_pass");
        editor.commit();
    }


}
