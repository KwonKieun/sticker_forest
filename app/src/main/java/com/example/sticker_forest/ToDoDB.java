package com.example.sticker_forest;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class ToDoDB extends SQLiteOpenHelper {
    private SQLiteDatabase db;

    private Context context;
    public static final String DATABASE_NAME = "todoList.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "todo_list";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TASK = "task";
    public static final String COLUMN_STATUS = "status";

    public static final String COLUMN_APPLE_IMAGE1 = "apple_image1";
    public static final String COLUMN_APPLE_IMAGE2 = "apple_image2";
    public static final String COLUMN_APPLE_IMAGE3 = "apple_image3";
    public static final String COLUMN_APPLE_IMAGE4 = "apple_image4";
    public static final String COLUMN_APPLE_IMAGE5 = "apple_image5";
    public static final String COLUMN_APPLE_IMAGE6 = "apple_image6";
    public static final String COLUMN_APPLE_IMAGE7 = "apple_image7";
    public static final String COLUMN_APPLE_IMAGE8 = "apple_image8";
    public static final String COLUMN_APPLE_IMAGE9 = "apple_image9";


    public ToDoDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TASK + " TEXT, " +
                COLUMN_STATUS + " INTEGER, " +
                COLUMN_APPLE_IMAGE1 + " INTEGER, " +
                COLUMN_APPLE_IMAGE2 + " INTEGER, " +
                COLUMN_APPLE_IMAGE3 + " INTEGER, " +
                COLUMN_APPLE_IMAGE4 + " INTEGER, " +
                COLUMN_APPLE_IMAGE5 + " INTEGER, " +
                COLUMN_APPLE_IMAGE6 + " INTEGER, " +
                COLUMN_APPLE_IMAGE7 + " INTEGER, " +
                COLUMN_APPLE_IMAGE8 + " INTEGER, " +
                COLUMN_APPLE_IMAGE9 + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void openDatabase(){
        db = this.getWritableDatabase();
    }

    //목표 전체 가져오기
    public ArrayList<ToDoModel> getAllTasks(){
        ArrayList<ToDoModel> taskList = new ArrayList<>();
        Cursor cursor = null;

        String query = "SELECT * FROM " + TABLE_NAME;

        db = this.getReadableDatabase();

        if (db != null){
            cursor = db.rawQuery(query, null);

            while (cursor.moveToNext()){
                ToDoModel task = new ToDoModel();

                task.setId(cursor.getInt(0));
                task.setTask(cursor.getString(1));
                task.setStatus(cursor.getInt(2));
                task.setApple_image1(cursor.getInt(3));
                task.setApple_image2(cursor.getInt(4));
                task.setApple_image3(cursor.getInt(5));
                task.setApple_image4(cursor.getInt(6));
                task.setApple_image5(cursor.getInt(7));
                task.setApple_image6(cursor.getInt(8));
                task.setApple_image7(cursor.getInt(9));
                task.setApple_image8(cursor.getInt(10));
                task.setApple_image9(cursor.getInt(11));

                taskList.add(task);
            }
        }
        return taskList;
    }

    //목표 추가
    public void AddTask(ToDoModel task){
        openDatabase();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TASK, task.getTask());
        cv.put(COLUMN_STATUS, 0);

        db.insert(TABLE_NAME, null, cv);
    }

    //체크 상태 수정
    public void updateStatus(int id, int status){
        openDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_STATUS, status);

        db.update(TABLE_NAME, cv, "id=?", new String[]{String.valueOf(id)});
    }


    //사과 수정
    public void updateApple1(int id, int apple_image1){
        openDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_APPLE_IMAGE1, apple_image1);

        db.update(TABLE_NAME, cv, "id=?", new String[]{String.valueOf(id)});

    }

    public void updateApple2(int id, int apple_image2){
        openDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_APPLE_IMAGE2, apple_image2);

        db.update(TABLE_NAME, cv, "id=?", new String[]{String.valueOf(id)});
    }

    public void updateApple3(int id, int apple_image3){
        openDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_APPLE_IMAGE3, apple_image3);

        db.update(TABLE_NAME, cv, "id=?", new String[]{String.valueOf(id)});
    }

    public void updateApple4(int id, int apple_image4){
        openDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_APPLE_IMAGE4, apple_image4);

        db.update(TABLE_NAME, cv, "id=?", new String[]{String.valueOf(id)});
    }

    public void updateApple5(int id, int apple_image5){
        openDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_APPLE_IMAGE5, apple_image5);

        db.update(TABLE_NAME, cv, "id=?", new String[]{String.valueOf(id)});
    }

    public void updateApple6(int id, int apple_image6){
        openDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_APPLE_IMAGE6, apple_image6);

        db.update(TABLE_NAME, cv, "id=?", new String[]{String.valueOf(id)});
    }

    public void updateApple7(int id, int apple_image7){
        openDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_APPLE_IMAGE7, apple_image7);

        db.update(TABLE_NAME, cv, "id=?", new String[]{String.valueOf(id)});
    }

    public void updateApple8(int id, int apple_image8){
        openDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_APPLE_IMAGE8, apple_image8);

        db.update(TABLE_NAME, cv, "id=?", new String[]{String.valueOf(id)});
    }

    public void updateApple9(int id, int apple_image9){
        openDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_APPLE_IMAGE9, apple_image9);

        db.update(TABLE_NAME, cv, "id=?", new String[]{String.valueOf(id)});
    }

    //목표 삭제
    public void deleteTask(int id){
        openDatabase();
        db.delete(TABLE_NAME, "Id=?", new String[]{String.valueOf(id)});
    }
}
