package com.example.snackdic;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class TestRecyclerViewAdapter4 extends RecyclerView.Adapter<TestRecyclerViewAdapter4.ItemViewHolder>{

    Intent intent;
    private ArrayList<TestVo> mList;
    public TestRecyclerViewAdapter4(ArrayList<TestVo> list){
        this.mList = list;
    }

    // 뷰홀더 상속 및 구현
    public class ItemViewHolder extends RecyclerView.ViewHolder{
        protected TextView content;
        protected ImageView load;

        public ItemViewHolder(@NonNull final View itemView) {
            super(itemView);
            this.content = itemView.findViewById(R.id.text_content);
            this.load =  itemView.findViewById(R.id.img_FB);
        }

        public void onBind(TestVo vo){
            content.setText(vo.getContent());

            String str1 = "snackimg/";
            String to = Integer.toString(vo.getId());
            str1 = str1.concat(to);
            str1 =  str1.concat(".jpg");

            FirebaseStorage storage = FirebaseStorage.getInstance("gs://snackdic-ee898.appspot.com/");
            StorageReference storageReference = storage.getReference();
            storageReference.child(str1).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Glide.with(itemView).load(uri).into(load);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });

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

                intent = new Intent(v.getContext(), listEndActivity.class);
                intent.putExtra("mname", mname);
                v.getContext().startActivity(intent);
                Toast.makeText(v.getContext(), mname, Toast.LENGTH_SHORT).show();

            }
        });

        viewholder.load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mname =mList.get(position).getContent();

                intent = new Intent(v.getContext(), listEndActivity.class);
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