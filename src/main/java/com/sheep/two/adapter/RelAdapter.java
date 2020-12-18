package com.sheep.two.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sheep.two.R;
import com.sheep.two.bean.NewsBean;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

public class RelAdapter extends RecyclerView.Adapter<RelAdapter.HomeHolder> {
    private ArrayList<NewsBean.NewsDTO> list;
    private Context context;

    public RelAdapter(ArrayList<NewsBean.NewsDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_news,parent,false);
        return new HomeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        holder.title.setText(list.get(position).getTile());
        holder.content.setText(list.get(position).getContent());

        Glide.with(context).load(list.get(position).getImageUrl()).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HomeHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView title;
        private TextView content;

        public HomeHolder(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv_news);
            title=itemView.findViewById(R.id.tv_title);
            content=itemView.findViewById(R.id.tv_content);
        }
    }
}
