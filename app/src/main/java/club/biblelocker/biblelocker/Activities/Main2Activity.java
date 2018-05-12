package club.biblelocker.biblelocker.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ajalt.reprint.core.Reprint;

import club.biblelocker.biblelocker.R;


public class Main2Activity extends AppCompatActivity {

    LinearLayout motionlock, pinlock, patternlock, fingerlock, passlock;
    ImageView test_pattern;
    TextView now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context mContext = this;
        Reprint.initialize(mContext);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);


        motionlock = findViewById(R.id.motion_lock);
        pinlock = findViewById(R.id.pin_lock);
        now = findViewById(R.id.nowwhat);
        test_pattern = findViewById(R.id.pattern_testimg);
        patternlock = findViewById(R.id.pattern_lock);
        fingerlock = findViewById(R.id.fingerprint);
        passlock = findViewById(R.id.passtext);

        passlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt = new Intent(Main2Activity.this, PasswordLock.class);
                startActivity(intentt);
                finish();
            }
        });


        fingerlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                boolean hasPrint = Reprint.isHardwarePresent();
                boolean hasRegister = Reprint.hasFingerprintRegistered();

                if (hasPrint == true) {
                    if (hasRegister == true) {

                        Toast.makeText(Main2Activity.this, "지문인식 잠금이 설정되었습니다.", Toast.LENGTH_SHORT).show();


                    } else {
                        Toast.makeText(Main2Activity.this, "등록된 지문이 없습니다.\n지문을 등록해주세요.", Toast.LENGTH_SHORT).show();
                    }

                } else {

                    Toast.makeText(Main2Activity.this, "지문 인식 기기가 아닙니다.", Toast.LENGTH_SHORT).show();
                }


            }
        });


        test_pattern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Main2Activity.this, PatternTest.class);
                startActivity(intent);


            }
        });

        now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Main2Activity.this, check_pinpass(), Toast.LENGTH_SHORT).show();

            }
        });

        motionlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MotionLock.class);
                startActivity(intent);
                finish();
            }
        });

        pinlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Main2Activity.this, PinLock.class);
                startActivity(intent2);
                finish();
            }
        });

        patternlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Main2Activity.this, PatternLock.class);
                startActivity(intent3);
                finish();

            }
        });


    }


    private String check_pinpass() {
        SharedPreferences pref = getSharedPreferences("pass_way", Activity.MODE_PRIVATE);
        String motion_pass_check = pref.getString("pass_way", "");
        return motion_pass_check;
    }


}
