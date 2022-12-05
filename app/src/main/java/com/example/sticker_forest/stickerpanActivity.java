package com.example.sticker_forest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class stickerpanActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private boolean toBoolean(int n){
        return n != 0;
    }

    TextView textView;
    TextView updateTaskEdit;

    ImageView updateImageView1;
    ImageView updateImageView2;
    ImageView updateImageView3;
    ImageView updateImageView4;
    ImageView updateImageView5;
    ImageView updateImageView6;
    ImageView updateImageView7;
    ImageView updateImageView8;
    ImageView updateImageView9;

    String task;
    int id;

    int apple1;
    int apple2;
    int apple3;
    int apple4;
    int apple5;
    int apple6;
    int apple7;
    int apple8;
    int apple9;

    boolean i1;
    boolean i2;
    boolean i3;
    boolean i4;
    boolean i5;
    boolean i6;
    boolean i7;
    boolean i8;
    boolean i9;

    private ToDoDB db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stickerpan);
        setTitle("");

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        textView = findViewById(R.id.nameTitle);

        SharedPreferences sharedPreferences= getSharedPreferences("name", MODE_PRIVATE);
        String inputNext = sharedPreferences.getString("inputName","");
        textView.setText(inputNext + "의 숲");    // TextView에 SharedPreferences에 저장되어있던 값 찍기.



        updateTaskEdit = findViewById(R.id.goal);
        updateImageView1 = findViewById(R.id.black_apple_1);
        updateImageView2 = findViewById(R.id.black_apple_2);
        updateImageView3 = findViewById(R.id.black_apple_3);
        updateImageView4 = findViewById(R.id.black_apple_4);
        updateImageView5 = findViewById(R.id.black_apple_5);
        updateImageView6 = findViewById(R.id.black_apple_6);
        updateImageView7 = findViewById(R.id.black_apple_7);
        updateImageView8 = findViewById(R.id.black_apple_8);
        updateImageView9 = findViewById(R.id.black_apple_9);


        getAndSetIntentDate();

        db = new ToDoDB(this);

    }

    public void getAndSetIntentDate() {

        if(getIntent().hasExtra("task")){
            //데이터 가져오기
            task = getIntent().getStringExtra("task");

            //데이터 넣기
            updateTaskEdit.setText(task);

        }

        if(getIntent().hasExtra("id")){
            //데이터 가져오기
            id = getIntent().getIntExtra("id", 0);

            i1 = toBoolean(getIntent().getIntExtra("apple1", 0));
            apple1 = getIntent().getIntExtra("apple1", 0);
            i2 = toBoolean(getIntent().getIntExtra("apple2", 0));
            apple2 = getIntent().getIntExtra("apple2", 0);
            i3 = toBoolean(getIntent().getIntExtra("apple3", 0));
            apple3 = getIntent().getIntExtra("apple3", 0);
            i4 = toBoolean(getIntent().getIntExtra("apple4", 0));
            apple4 = getIntent().getIntExtra("apple4", 0);
            i5 = toBoolean(getIntent().getIntExtra("apple5", 0));
            apple5 = getIntent().getIntExtra("apple5", 0);
            i6 = toBoolean(getIntent().getIntExtra("apple6", 0));
            apple6 = getIntent().getIntExtra("apple6", 0);
            i7 = toBoolean(getIntent().getIntExtra("apple7", 0));
            apple7 = getIntent().getIntExtra("apple7", 0);
            i8 = toBoolean(getIntent().getIntExtra("apple8", 0));
            apple8 = getIntent().getIntExtra("apple8", 0);
            i9 = toBoolean(getIntent().getIntExtra("apple9", 0));
            apple9 = getIntent().getIntExtra("apple9", 0);


            //apple 1
            ImageView black_apple_1 = (ImageView) findViewById(R.id.black_apple_1);
            if (apple1 == 1){
                updateImageView1.setImageResource(R.drawable.apple);
            }
            else{
                updateImageView1.setImageResource(R.drawable.black_apple);
            }

            black_apple_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i1 == false){
                        black_apple_1.setImageResource(R.drawable.apple);
                        db.updateApple1(id, 1);
                        i1 = true;
                    }else {
                        black_apple_1.setImageResource(R.drawable.black_apple);
                        db.updateApple1(id, 0);
                        i1 = false;
                    }
                }
            });

            //apple 2
            ImageView black_apple_2 = (ImageView) findViewById(R.id.black_apple_2);
            if (apple2 == 1){
                updateImageView2.setImageResource(R.drawable.apple);
            }
            else{
                updateImageView2.setImageResource(R.drawable.black_apple);
            }

            black_apple_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i2 == false){
                        black_apple_2.setImageResource(R.drawable.apple);
                        db.updateApple2(id, 1);
                        i2 = true;
                    }else {
                        black_apple_2.setImageResource(R.drawable.black_apple);
                        db.updateApple2(id, 0);
                        i2 = false;
                    }
                }
            });

            //apple 3
            ImageView black_apple_3 = (ImageView) findViewById(R.id.black_apple_3);
            if (apple3 == 1){
                updateImageView3.setImageResource(R.drawable.apple);
            }
            else{
                updateImageView3.setImageResource(R.drawable.black_apple);
            }

            black_apple_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i3 == false){
                        black_apple_3.setImageResource(R.drawable.apple);
                        db.updateApple3(id, 1);
                        i3 = true;
                    }else {
                        black_apple_3.setImageResource(R.drawable.black_apple);
                        db.updateApple3(id, 0);
                        i3 = false;
                    }
                }
            });

            //apple 4
            ImageView black_apple_4 = (ImageView) findViewById(R.id.black_apple_4);
            if (apple4 == 1){
                updateImageView4.setImageResource(R.drawable.apple);
            }
            else{
                updateImageView4.setImageResource(R.drawable.black_apple);
            }

            black_apple_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i4 == false){
                        black_apple_4.setImageResource(R.drawable.apple);
                        db.updateApple4(id, 1);
                        i4 = true;
                    }else {
                        black_apple_4.setImageResource(R.drawable.black_apple);
                        db.updateApple4(id, 0);
                        i4 = false;
                    }
                }
            });

            //apple 5
            ImageView black_apple_5 = (ImageView) findViewById(R.id.black_apple_5);
            if (apple5 == 1){
                updateImageView5.setImageResource(R.drawable.apple);
            }
            else{
                updateImageView5.setImageResource(R.drawable.black_apple);
            }

            black_apple_5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i5 == false){
                        black_apple_5.setImageResource(R.drawable.apple);
                        db.updateApple5(id, 1);
                        i5 = true;
                    }else {
                        black_apple_5.setImageResource(R.drawable.black_apple);
                        db.updateApple5(id, 0);
                        i5 = false;
                    }
                }
            });

            //apple 6
            ImageView black_apple_6 = (ImageView) findViewById(R.id.black_apple_6);
            if (apple6 == 1){
                updateImageView6.setImageResource(R.drawable.apple);
            }
            else{
                updateImageView6.setImageResource(R.drawable.black_apple);
            }

            black_apple_6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i6 == false){
                        black_apple_6.setImageResource(R.drawable.apple);
                        db.updateApple6(id, 1);
                        i6 = true;
                    }else {
                        black_apple_6.setImageResource(R.drawable.black_apple);
                        db.updateApple6(id, 0);
                        i6 = false;
                    }
                }
            });

            //apple 7
            ImageView black_apple_7 = (ImageView) findViewById(R.id.black_apple_7);
            if (apple7 == 1){
                updateImageView7.setImageResource(R.drawable.apple);
            }
            else{
                updateImageView7.setImageResource(R.drawable.black_apple);
            }

            black_apple_7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i7 == false){
                        black_apple_7.setImageResource(R.drawable.apple);
                        db.updateApple7(id, 1);
                        i7 = true;
                    }else {
                        black_apple_7.setImageResource(R.drawable.black_apple);
                        db.updateApple7(id, 0);
                        i7 = false;
                    }
                }
            });

            //apple 8
            ImageView black_apple_8 = (ImageView) findViewById(R.id.black_apple_8);
            if (apple8 == 1){
                updateImageView8.setImageResource(R.drawable.apple);
            }
            else{
                updateImageView8.setImageResource(R.drawable.black_apple);
            }

            black_apple_8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i8 == false){
                        black_apple_8.setImageResource(R.drawable.apple);
                        db.updateApple8(id, 1);
                        i8 = true;
                    }else {
                        black_apple_8.setImageResource(R.drawable.black_apple);
                        db.updateApple8(id, 0);
                        i8 = false;
                    }
                }
            });

            //apple 9
            ImageView black_apple_9 = (ImageView) findViewById(R.id.black_apple_9);
            if (apple9 == 1){
                updateImageView9.setImageResource(R.drawable.apple);
            }
            else{
                updateImageView9.setImageResource(R.drawable.black_apple);
            }

            black_apple_9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (i9 == false){
                        black_apple_9.setImageResource(R.drawable.apple);
                        db.updateApple9(id, 1);
                        i9 = true;
                    }else {
                        black_apple_9.setImageResource(R.drawable.black_apple);
                        db.updateApple9(id, 0);
                        i9 = false;
                    }
                }
            });
        }
    }

}