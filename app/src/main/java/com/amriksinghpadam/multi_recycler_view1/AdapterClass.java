package com.amriksinghpadam.multi_recycler_view1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.VHolder> {
    ArrayList<String> imgList;
    ArrayList<String> textList;
    Context context;

    AdapterClass(ArrayList<String> imgList,ArrayList<String> textList, Context context){
        this.imgList = imgList;
        this.textList = textList;
        this.context = context;
        imgList = new ArrayList<>();
        textList = new ArrayList<>();
    }
    @NonNull
    @Override
    public VHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_itme_recycler,parent,false);
        VHolder holder = new VHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull VHolder holder, int position) {
        Glide.with(context).asBitmap().load(imgList.get(position)).into(holder.img);
        holder.text.setText(textList.get(position));
    }

    @Override
    public int getItemCount() {
        return textList.size();
    }

    public static class VHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView text;
        LinearLayout layout;
        public VHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgId);
            text = itemView.findViewById(R.id.textId);
            layout = itemView.findViewById(R.id.layoutId);

        }
    }

}
