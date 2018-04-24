package club.biblelocker.biblelocker.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import club.biblelocker.biblelocker.R;

public class MotionLockCheck extends AppCompatActivity {

    Button ok, cancel;

    LinearLayout one, two, three, four, five, six, seven, eight, nine;

    String motion_pass_result_check = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_motion_lock_check);
        ok = findViewById(R.id.make_ok_check);
        cancel = findViewById(R.id.make_cancel_check);
        final Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        one = findViewById(R.id.motion_one_check);
        two = findViewById(R.id.motion_two_check);
        three = findViewById(R.id.motion_three_check);
        four = findViewById(R.id.motion_four_check);
        five = findViewById(R.id.motion_five_check);
        six = findViewById(R.id.motion_six_check);
        seven = findViewById(R.id.motion_seven_check);
        eight = findViewById(R.id.motion_eight_check);
        nine = findViewById(R.id.motion_nine_check);


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);

                motion_pass_result_check = motion_pass_result_check.concat("1");

            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);
                motion_pass_result_check = motion_pass_result_check.concat("2");

            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);
                motion_pass_result_check = motion_pass_result_check.concat("3");

            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);
                motion_pass_result_check = motion_pass_result_check.concat("4");


            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);
                motion_pass_result_check = motion_pass_result_check.concat("5");

            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);
                motion_pass_result_check = motion_pass_result_check.concat("6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);
                motion_pass_result_check = motion_pass_result_check.concat("7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);
                motion_pass_result_check = motion_pass_result_check.concat("8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);
                motion_pass_result_check = motion_pass_result_check.concat("9");
            }
        });


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (check_motionpass().equals(motion_pass_result_check)) {
                    Toast.makeText(MotionLockCheck.this, "눼 마다용", Toast.LENGTH_SHORT).show();
                    delete_passway();
                    save_passway();
                    Intent intent = new Intent(MotionLockCheck.this, Main2Activity.class);
                    startActivity(intent);
                    finish();

                } else {
                    motion_pass_result_check = "";
                    Toast.makeText(MotionLockCheck.this, "틀렸어용...", Toast.LENGTH_SHORT).show();

                }


            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removePreferences();
                Intent intent = new Intent(MotionLockCheck.this, MotionLock.class);
                startActivity(intent);
                finish();

            }
        });
    }


    @Override
    public void onBackPressed() {

    }


    private String check_motionpass() {
        SharedPreferences pref = getSharedPreferences("motion_pass", Activity.MODE_PRIVATE);
        String motion_pass_check = pref.getString("motion_pass", "");
        return motion_pass_check;
    }

    private void save_passway() {

        SharedPreferences pref = getSharedPreferences("pass_way", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("pass_way", "motion");
        editor.commit();
    }

    private void delete_passway() {
        SharedPreferences pref = getSharedPreferences("pass_way", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove("pass_way");
        editor.commit();

    }

    private void removePreferences() {
        SharedPreferences pref = getSharedPreferences("motion_pass", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove("motion_pass");
        editor.commit();
    }

}
