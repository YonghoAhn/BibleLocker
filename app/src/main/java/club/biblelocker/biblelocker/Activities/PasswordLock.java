package club.biblelocker.biblelocker.Activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import club.biblelocker.biblelocker.R;

public class PasswordLock extends AppCompatActivity {

    TextView PassText;
    EditText PassEdit;
    Button PassOk, PassCancel;
    String Pass = null;
    String PassCheck = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_lock);

        PassText = findViewById(R.id.pass_text);
        PassEdit = findViewById(R.id.pass_edit);
        PassOk = findViewById(R.id.pass_next);
        PassCancel = findViewById(R.id.pass_cancel);

        PassOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pass = PassEdit.getText().toString();

                if (Pass.length() < 4) {

                    Toast.makeText(PasswordLock.this, "네글자 이상 입력해 주세요.", Toast.LENGTH_SHORT).show();

                } else if (Pass.length() > 16) {

                    Toast.makeText(PasswordLock.this, "16글자 이하로 입력해 주세요.", Toast.LENGTH_SHORT).show();

                } else if (CheckNumber(Pass) == true) {

                    Toast.makeText(PasswordLock.this, "적어도 한글자 이상의 문자를 포함해주세요.", Toast.LENGTH_SHORT).show();

                } else {
                    //처음 입력에서 모든 조건을 충족함.
                    PassOk.setText("완료");
                    PassEdit.setText("");
                    PassText.setText("다시 한번 입력해 주세요.");

                    PassOk.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            PassCheck = PassEdit.getText().toString();
                            if (PassCheck.equals(Pass)) {
                                Toast.makeText(PasswordLock.this, "눼 맞아용", Toast.LENGTH_SHORT).show();

                                save_passway();
                                save_password();
                                Intent intent = new Intent(PasswordLock.this, Main2Activity.class);
                                startActivity(intent);
                                finish();

                            } else {
                                Toast.makeText(PasswordLock.this, "틀렸세용...", Toast.LENGTH_SHORT).show();

                            }


                        }
                    });


                }


            }
        });


        PassCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();


            }
        });


    }

    public boolean CheckNumber(String str) {
        //숫자만 확인
        return str.matches("(^[0-9]*$)");
    }

    private void save_password() {

        SharedPreferences pref = getSharedPreferences("password", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("password", PassCheck);
        editor.commit();

    }

    private void save_passway() {

        SharedPreferences pref = getSharedPreferences("pass_way", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("pass_way", "password");
        editor.commit();
    }


}
