package com.example.sticker_forest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder>{

    private Context context;
    private ArrayList<ToDoModel> todoList = new ArrayList<>();
    private ToDoDB db;

    public ToDoAdapter(ToDoDB db){
        this.db = db;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.task_list, parent, false);

        context = parent.getContext();

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        ToDoModel item = todoList.get(position);
        holder.mCheckBox.setText(item.getTask());
        holder.mCheckBox.setChecked(toBoolean(item.getStatus()));



        //체크박스 체크 이벤트
        holder.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked){
                //체크상태면 1, 아니면 0
                if(isChecked){
                    db.updateStatus(item.getId(), 1);
                }
                else{
                    db.updateStatus(item.getId(), 0);
                }
            }
        });

        holder.mainLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent = new Intent(context, stickerpanActivity.class);
                intent.putExtra("task", item.getTask());
                intent.putExtra("id", item.getId());
                intent.putExtra("apple1", item.getApple_image1());
                intent.putExtra("apple2", item.getApple_image2());
                intent.putExtra("apple3", item.getApple_image3());
                intent.putExtra("apple4", item.getApple_image4());
                intent.putExtra("apple5", item.getApple_image5());
                intent.putExtra("apple6", item.getApple_image6());
                intent.putExtra("apple7", item.getApple_image7());
                intent.putExtra("apple8", item.getApple_image8());
                intent.putExtra("apple9", item.getApple_image9());

                context.startActivity(intent);

            }
        });
    }

    //체크상태 boolean으로 변경
    private boolean toBoolean(int n){
        return n != 0;
    }

    //리스트에 데이터 담기
    public void setTasks(ArrayList<ToDoModel> todoList){
        this.todoList = todoList;
        notifyDataSetChanged();
    }

    //목표(나무) 삭제
    public void removeItem(int position){
        todoList.remove(position);
        notifyItemRemoved(position);
    }

    //목표(나무) 개수
    @Override
    public int getItemCount(){
        return todoList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        CheckBox mCheckBox;
        LinearLayout mainLayout;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            mCheckBox = itemView.findViewById(R.id.m_check_box);
            mainLayout = itemView.findViewById(R.id.main_layout);
        }
    }
}