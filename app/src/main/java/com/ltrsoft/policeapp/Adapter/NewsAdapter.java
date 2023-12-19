package com.ltrsoft.policeapp.Adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.policeapp.Case.CaseDetailFragment;
import com.ltrsoft.policeapp.Classes.News;
import com.ltrsoft.policeapp.News.NewsViewFragment;
import com.ltrsoft.policeapp.R;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    public ArrayList <News>list;

    public NewsAdapter(ArrayList<News> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_recycle_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News news = list.get(position);
        holder.newsImg.setImageResource(news.getNewsImgRes());
        holder.newsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity=(AppCompatActivity)view.getContext();
                NewsViewFragment viewFragment = new NewsViewFragment();
                Bundle b = new Bundle();
                b.putInt("news_img", news.getNewsImgRes());
                viewFragment.setArguments(b);
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, viewFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView newsImg,comment,like,share;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newsImg = itemView.findViewById(R.id.newsimg);
            comment = itemView.findViewById(R.id.comment);
            like = itemView.findViewById(R.id.like);
            share = itemView.findViewById(R.id.share);
        }
    }
}
