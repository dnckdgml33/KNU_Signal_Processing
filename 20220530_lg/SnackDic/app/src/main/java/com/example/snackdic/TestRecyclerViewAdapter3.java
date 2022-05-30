package com.example.snackdic;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TestRecyclerViewAdapter3 extends RecyclerView.Adapter<TestRecyclerViewAdapter3.ItemViewHolder>{

    Intent intent;
    private ArrayList<TestVo2> mList;
    public TestRecyclerViewAdapter3(ArrayList<TestVo2> list){
        this.mList = list;
    }

    // 뷰홀더 상속 및 구현
    public class ItemViewHolder extends RecyclerView.ViewHolder{
        protected TextView content;

        public ItemViewHolder(@NonNull final View itemView) {
            super(itemView);
            this.content = itemView.findViewById(R.id.text_content);
        }

        public void onBind(TestVo2 vo){
            content.setText(vo.getContent());
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyclerview_item2, viewGroup, false);

        ItemViewHolder viewHolder = new ItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder viewholder, final int position) {
        viewholder.onBind(mList.get(position));

        viewholder.content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mname =mList.get(position).getContent();

                intent = new Intent(v.getContext(), listActivity3.class);
                intent.putExtra("mname", mname);
                v.getContext().startActivity(intent);
                Toast.makeText(v.getContext(), mname, Toast.LENGTH_SHORT).show();

            }
        });
    }



    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

    public ArrayList<TestVo2> getListData() {
        return mList;
    }

    public void setListData(ArrayList<TestVo2> listData) {
        this.mList = listData;
    }

    public void addItem(TestVo2 data) {
        mList.add(data);
    }


}