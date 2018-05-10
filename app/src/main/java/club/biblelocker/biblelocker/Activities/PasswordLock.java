package club.biblelocker.biblelocker.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import club.biblelocker.biblelocker.R;

public class PasswordLock extends AppCompatActivity {

    TextView passtx;
    EditText passedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_lock);
    }
}
