package club.biblelocker.biblelocker;

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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class PinLock extends AppCompatActivity {

    Button one, two, three, four, five, six, seven, eight, nine, zero;

    ImageButton backspace, pinsee;

    String pin_result = "";

    String pin_no_see = "";

    boolean see_mode = false;

    TextView pintext, ok, cancel;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pin_lock);

        one = findViewById(R.id.pin_one);

        two = findViewById(R.id.pin_two);

        three = findViewById(R.id.pin_three);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        four = findViewById(R.id.pin_four);

        five = findViewById(R.id.pin_five);

        six = findViewById(R.id.pin_six);

        pinsee = findViewById(R.id.pin_see);

        seven = findViewById(R.id.pin_seven);

        eight = findViewById(R.id.pin_eight);

        nine = findViewById(R.id.pin_nine);

        zero = findViewById(R.id.pin_zero);

        backspace = findViewById(R.id.pin_backspace);

        pintext = findViewById(R.id.pin_text);

        ok = findViewById(R.id.pin_make_ok);

        cancel = findViewById(R.id.pin_make_cancel);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(10);
                pin_result = pin_result.concat("1");
                pin_no_see = pin_no_see.concat("*");

                if (see_mode == true) {
                    pintext.setText(pin_result);
                } else {
                    pintext.setText(pin_no_see);
                }

            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);
                pin_result = pin_result.concat("2");
                pin_no_see = pin_no_see.concat("*");
                pintext.setText(pin_no_see);

                if (see_mode == true) {
                    pintext.setText(pin_result);
                } else {
                    pintext.setText(pin_no_see);
                }

            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);
                pin_result = pin_result.concat("3");
                pin_no_see = pin_no_see.concat("*");
                pintext.setText(pin_no_see);

                if (see_mode == true) {
                    pintext.setText(pin_result);
                } else {
                    pintext.setText(pin_no_see);
                }

            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);
                pin_result = pin_result.concat("4");
                pin_no_see = pin_no_see.concat("*");
                pintext.setText(pin_no_see);
                if (see_mode == true) {
                    pintext.setText(pin_result);
                } else {
                    pintext.setText(pin_no_see);
                }

            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);
                pin_result = pin_result.concat("5");
                pin_no_see = pin_no_see.concat("*");
                pintext.setText(pin_no_see);
                if (see_mode == true) {
                    pintext.setText(pin_result);
                } else {
                    pintext.setText(pin_no_see);
                }

            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);
                pin_result = pin_result.concat("6");
                pin_no_see = pin_no_see.concat("*");
                pintext.setText(pin_no_see);
                if (see_mode == true) {
                    pintext.setText(pin_result);
                } else {
                    pintext.setText(pin_no_see);
                }

            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);
                pin_result = pin_result.concat("7");
                pin_no_see = pin_no_see.concat("*");
                pintext.setText(pin_no_see);
                if (see_mode == true) {
                    pintext.setText(pin_result);
                } else {
                    pintext.setText(pin_no_see);
                }

            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);
                pin_result = pin_result.concat("8");
                pin_no_see = pin_no_see.concat("*");
                pintext.setText(pin_no_see);
                if (see_mode == true) {
                    pintext.setText(pin_result);
                } else {
                    pintext.setText(pin_no_see);
                }

            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);
                pin_result = pin_result.concat("9");
                pin_no_see = pin_no_see.concat("*");
                pintext.setText(pin_no_see);
                if (see_mode == true) {
                    pintext.setText(pin_result);
                } else {
                    pintext.setText(pin_no_see);
                }

            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);
                pin_result = pin_result.concat("0");
                pin_no_see = pin_no_see.concat("*");
                pintext.setText(pin_no_see);

                if (see_mode == true) {
                    pintext.setText(pin_result);
                } else {
                    pintext.setText(pin_no_see);
                }


            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);
                if (pin_result.length() > 0 && pin_no_see.length() > 0) {

                    pin_result = pin_result.substring(0, pin_result.length() - 1);
                    pin_no_see = pin_no_see.substring(0, pin_no_see.length() - 1);


                    if (see_mode == true) {
                        pintext.setText(pin_result);
                    } else {
                        pintext.setText(pin_no_see);
                    }

                }


            }
        });

        pinsee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);
                if (see_mode == false) {

                    see_mode = true;

                    pintext.setText(pin_result);

                    pinsee.setImageResource(R.drawable.eye_off);

                } else {

                    see_mode = false;

                    pintext.setText(pin_no_see);

                    pinsee.setImageResource(R.drawable.eye_on);

                }

            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (pin_result.length() < 4) {
                    Toast.makeText(PinLock.this, "적어도 4개 이상의 비밀번호를 입력해 주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    removePreferences();
                    save_motionpass();
                    Toast.makeText(PinLock.this, pin_result, Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(PinLock.this, PinLockCheck.class);
                    startActivity(intent1);
                    finish();
                }


            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removePreferences();
                Intent intent2 = new Intent(PinLock.this, Main2Activity.class);
                startActivity(intent2);
                finish();

            }
        });


    }

    @Override
    public void onBackPressed() {

    }

    private void save_motionpass() {


        SharedPreferences pref = getSharedPreferences("pin_pass", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("pin_pass", pin_result);
        editor.commit();


    }

    private void removePreferences() {
        SharedPreferences pref = getSharedPreferences("pin_pass", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove("pin_pass");
        editor.commit();
    }

}
