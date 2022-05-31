package com.example.snackdic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TestRecyclerViewAdapter extends RecyclerView.Adapter<TestRecyclerViewAdapter.ItemViewHolder>{

    private ArrayList<TestVo> mList;
    public TestRecyclerViewAdapter(ArrayList<TestVo> list){
        this.mList = list;
    }

    // 뷰홀더 상속 및 구현
    public class ItemViewHolder extends RecyclerView.ViewHolder{
        protected TextView id;
        protected TextView content;

        public ItemViewHolder(@NonNull final View itemView) {
            super(itemView);
            this.id = itemView.findViewById(R.id.text_view);
            this.content = itemView.findViewById(R.id.text_content);
        }

        public void onBind(TestVo vo){
            id.setText(vo.getId());
            content.setText(vo.getContent());
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyclerview_item, viewGroup, false);

        ItemViewHolder viewHolder = new ItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder viewholder, final int position) {
        viewholder.onBind(mList.get(position));

        viewholder.content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), position +"번째 텍스트 클릭!", Toast.LENGTH_SHORT).show();
            }
        });

        viewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), position +"번째 리스트클릭!", Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

    public ArrayList<TestVo> getListData() {
        return mList;
    }

    public void setListData(ArrayList<TestVo> listData) {
        this.mList = listData;
    }

    public void addItem(TestVo data) {
        mList.add(data);
    }


}