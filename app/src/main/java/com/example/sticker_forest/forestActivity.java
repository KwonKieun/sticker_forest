package com.example.sticker_forest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;



public class forestActivity extends AppCompatActivity {
    EditText inputName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forest);
        setTitle("");

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        inputName = findViewById(R.id.inputName);

        Button btnNewActivity2 = (Button) findViewById(R.id.btnNewActivity2);
        btnNewActivity2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(inputName.getText().toString().isEmpty()){ // 공백 또는 size=0이면
                    //Toast.makeText(this, "값을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else {
                    SharedPreferences sharedPreferences= getSharedPreferences("name", MODE_PRIVATE);    // test 이름의 기본모드 설정
                    SharedPreferences.Editor editor= sharedPreferences.edit(); //sharedPreferences를 제어할 editor를 선언
                    editor.putString("inputName",inputName.getText().toString()); // key,value 형식으로 저장
                    editor.commit();    //최종 커밋. 커밋을 해야 저장이 된다.
                }


                Intent intent = new Intent(forestActivity.this,
                        treelistActivity.class);
                startActivity(intent);
            }
        });

    }

}
