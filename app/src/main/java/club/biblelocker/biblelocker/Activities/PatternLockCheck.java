package club.biblelocker.biblelocker.Activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;
import com.andrognito.patternlockview.utils.ResourceUtils;
import com.andrognito.rxpatternlockview.RxPatternLockView;
import com.andrognito.rxpatternlockview.events.PatternLockCompleteEvent;
import com.andrognito.rxpatternlockview.events.PatternLockCompoundEvent;

import java.util.List;

import club.biblelocker.biblelocker.R;
import io.reactivex.functions.Consumer;

public class PatternLockCheck extends AppCompatActivity {

    private PatternLockView mPatternLockView;
    TextView patterncom;
    Button ok, cancel;
    String nowpattern = "";
    boolean pattern_check = false;
    boolean progress = false;
    PatternLockCompleteEvent getpattern;
    Handler mHandler = new Handler();

    @Override
    public void onBackPressed() {

    }

    private String check_patternpass() {
        SharedPreferences pref = getSharedPreferences("pattern_pass", Activity.MODE_PRIVATE);
        String motion_pass_check = pref.getString("pattern_pass", "");
        return motion_pass_check;
    }

    private void save_passway() {

        SharedPreferences pref = getSharedPreferences("pass_way", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("pass_way", "pattern");
        editor.commit();
    }

    private void delete_passway() {
        SharedPreferences pref = getSharedPreferences("pass_way", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove("pass_way");
        editor.commit();

    }

    private void removePreferences() {
        SharedPreferences pref = getSharedPreferences("pattern_pass", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove("pattern_pass");
        editor.commit();
    }


    private PatternLockViewListener mPatternLockViewListener = new PatternLockViewListener() {

        @Override
        public void onStarted() {
            Log.d(getClass().getName(), "Pattern drawing started");
        }

        @Override
        public void onProgress(List<PatternLockView.Dot> progressPattern) {
            Log.d(getClass().getName(), "Pattern progress: " +
                    PatternLockUtils.patternToString(mPatternLockView, progressPattern));
        }

        @Override
        public void onComplete(List<PatternLockView.Dot> pattern) {
            Log.d(getClass().getName(), "Pattern complete: " +
                    PatternLockUtils.patternToString(mPatternLockView, pattern));
        }

        @Override
        public void onCleared() {
            Log.d(getClass().getName(), "Pattern has been cleared");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pattern_lock_check);


        patterncom = findViewById(R.id.set_pattern_text_check);
        ok = findViewById(R.id.pattern_lock_ok_check);
        cancel = findViewById(R.id.pattern_lock_cancel_check);
        mPatternLockView = (PatternLockView) findViewById(R.id.patter_lock_vieww_checkk);
        mPatternLockView.setDotCount(3);
        mPatternLockView.setDotNormalSize((int) ResourceUtils.getDimensionInPx(this, R.dimen.pattern_lock_dot_size));
        mPatternLockView.setDotSelectedSize((int) ResourceUtils.getDimensionInPx(this, R.dimen.pattern_lock_dot_selected_size));
        mPatternLockView.setPathWidth((int) ResourceUtils.getDimensionInPx(this, R.dimen.pattern_lock_path_width));
        mPatternLockView.setAspectRatioEnabled(true);
        mPatternLockView.setAspectRatio(PatternLockView.AspectRatio.ASPECT_RATIO_HEIGHT_BIAS);
        mPatternLockView.setViewMode(PatternLockView.PatternViewMode.CORRECT);
        mPatternLockView.setDotAnimationDuration(150);
        mPatternLockView.setPathEndAnimationDuration(100);
        mPatternLockView.setCorrectStateColor(ResourceUtils.getColor(this, R.color.white));
        mPatternLockView.setWrongStateColor(ResourceUtils.getColor(this, R.color.red));
        mPatternLockView.setInStealthMode(false);
        mPatternLockView.setTactileFeedbackEnabled(true);
        mPatternLockView.setInputEnabled(true);
        mPatternLockView.addPatternLockListener(mPatternLockViewListener);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pattern_check == false) {

                    patterncom.setText("패턴을 입력해 주세요.");

                } else {

                    Toast.makeText(PatternLockCheck.this, "눼 마다용", Toast.LENGTH_SHORT).show();
                    delete_passway();
                    save_passway();
                    Intent intent = new Intent(PatternLockCheck.this, Main2Activity.class);
                    startActivity(intent);
                    finish();
                }


            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                removePreferences();
                Intent intent = new Intent(PatternLockCheck.this, PatternLock.class);
                startActivity(intent);
                finish();

            }
        });

        RxPatternLockView.patternChanges(mPatternLockView)
                .subscribe(new Consumer<PatternLockCompoundEvent>() {
                    @Override
                    public void accept(PatternLockCompoundEvent event) throws Exception {

                        if (event.getEventType() == PatternLockCompoundEvent.EventType.PATTERN_STARTED) {
                            patterncom.setText("설정할 패턴을 입력해 주세요.");
                            Log.d(getClass().getName(), "Pattern drawing started");
                            progress = true;
                        } else if (event.getEventType() == PatternLockCompoundEvent.EventType.PATTERN_PROGRESS) {
                            patterncom.setText("패턴을 입력하고 있습니다...");
                            Log.d(getClass().getName(), "Pattern progress: " +
                                    PatternLockUtils.patternToString(mPatternLockView, event.getPattern()));
                        }

                        if (event.getEventType() == PatternLockCompoundEvent.EventType.PATTERN_COMPLETE) {
                            progress = false;
                            Log.d(getClass().getName(), "Pattern complete: " +
                                    PatternLockUtils.patternToString(mPatternLockView, event.getPattern()));

                            nowpattern = PatternLockUtils.patternToString(mPatternLockView, event.getPattern());

                        }
                    }
                });


        RxPatternLockView.patternComplete(mPatternLockView)
                .subscribe(new Consumer<PatternLockCompleteEvent>() {
                    @Override
                    public void accept(PatternLockCompleteEvent patternLockCompleteEvent) throws Exception {


                        if (nowpattern.equals(check_patternpass())) {
                            patterncom.setText("패턴을 올바르게 입력하셨습니다.");
                            pattern_check = true;
                        } else {
                            mPatternLockView.setViewMode(PatternLockView.PatternViewMode.WRONG);
                            pattern_check = false;
                            patterncom.setText("패턴을 다시 입력해 주세요.");

                            mHandler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mPatternLockView.setViewMode(PatternLockView.PatternViewMode.CORRECT);
                                    if (progress == false) {
                                        mPatternLockView.clearPattern();
                                    }
                                    patterncom.setText("설정한 패턴을 다시 입력해 주세요.");
                                }
                            }, 700);


                        }

                    }
                });


    }
}
