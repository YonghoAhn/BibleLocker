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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import club.biblelocker.biblelocker.R;

public class PinLockCheck extends AppCompatActivity {

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
        setContentView(R.layout.activity_pin_lock_check);

        one = findViewById(R.id.pin_one_check);

        two = findViewById(R.id.pin_two_check);

        three = findViewById(R.id.pin_three_check);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        four = findViewById(R.id.pin_four_check);

        five = findViewById(R.id.pin_five_check);

        six = findViewById(R.id.pin_six_check);

        seven = findViewById(R.id.pin_seven_check);
        pinsee = findViewById(R.id.pin_see_check);

        eight = findViewById(R.id.pin_eight_check);

        nine = findViewById(R.id.pin_nine_check);

        zero = findViewById(R.id.pin_zero_check);

        backspace = findViewById(R.id.pin_backspace_check);

        pintext = findViewById(R.id.pin_text_check);

        ok = findViewById(R.id.pin_make_ok_check);

        cancel = findViewById(R.id.pin_make_cancel_check);

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


                if (check_pinpass().equals(pin_result)) {
                    Toast.makeText(PinLockCheck.this, "눼 마다용", Toast.LENGTH_SHORT).show();
                    delete_passway();
                    save_pin_passway();
                    Intent intent = new Intent(PinLockCheck.this, Main2Activity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(PinLockCheck.this, "틀렸어용...", Toast.LENGTH_SHORT).show();
                }


            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removePreferences();
                Intent intent = new Intent(PinLockCheck.this, PinLock.class);
                startActivity(intent);
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {

    }


    private String check_pinpass() {
        SharedPreferences pref = getSharedPreferences("pin_pass", Activity.MODE_PRIVATE);
        String motion_pass_check = pref.getString("pin_pass", "");
        return motion_pass_check;
    }

    private void save_pin_passway() {


        SharedPreferences pref = getSharedPreferences("pass_way", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("pass_way", "pin");
        editor.commit();

    }


    private void delete_passway() {
        SharedPreferences pref = getSharedPreferences("pass_way", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove("pass_way");
        editor.commit();

    }

    private void removePreferences() {
        SharedPreferences pref = getSharedPreferences("pinn_pass", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove("pin_pass");
        editor.commit();
    }

}
