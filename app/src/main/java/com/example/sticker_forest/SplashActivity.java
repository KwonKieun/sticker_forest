
package com.example.sticker_forest;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        FirstUserCheck(); //처음 사용자 체크하는 메소드
        setTitle("");

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    private void FirstUserCheck() {

        SharedPreferences sharedPreferences = getSharedPreferences("isFirst", Activity.MODE_PRIVATE);
        boolean first = sharedPreferences.getBoolean("isFirst", false);
        if (first == false) {
            Log.d("Is first Time?", "first");
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isFirst", true);
            editor.commit(); //앱 최초 실행 시 하고싶은 작업
            Intent intent = new Intent(getApplicationContext(), forestActivity.class);
            startActivity(intent); //다음화면으로 넘어감
            finish();
        } else { //최초 실행이 아닌 경우
            Log.d("Is first Time?", "not first");
            Intent intent = new Intent(getApplicationContext(), treelist3Activity.class);
            startActivity(intent); //다음화면으로 넘어감
            finish();
        }
    }
}

