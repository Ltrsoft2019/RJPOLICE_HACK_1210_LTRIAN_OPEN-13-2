package com.ltrsoft.policeapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.policeapp.Case.CaseDetailFragment;
import com.ltrsoft.policeapp.Classes.News;
import com.ltrsoft.policeapp.News.NewsViewFragment;
import com.ltrsoft.policeapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    public ArrayList <News>list;
    boolean b=false;

    public NewsAdapter(ArrayList<News> list) {
        this.list = list;
    }
    Context context;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_recycle_layout,parent,false);
        context=parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News news = list.get(position);
       // String imgurl ="https://institute.ltr-soft.com/company_details/"+news.getNews_photo_path();
        //Picasso.get().load(imgurl).into(holder.newsImg);
        holder.newsImg.setImageResource(R.drawable.news1);
        holder.title.setText(news.getNews_description());
        holder.newsDate.setText(news.getNews_date());

        holder.newsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                NewsViewFragment viewFragment = new NewsViewFragment();
                Bundle b = new Bundle();

                // Assuming `newsImg.getNews_photo_path()` returns the image path as a String
                // Pass the image path instead of resource ID if you intend to load it using Glide or Picasso
                b.putString("news_img", news.getNews_photo_path());

                b.putString("news_description", news.getNews_category_name());
                b.putString("news_title", news.getNews_title());
                viewFragment.setArguments(b);

                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, viewFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (b) {
                    holder.like.setImageResource(R.drawable.like2);
                    b=false;
                }
                else {
                    holder.like.setImageResource(R.drawable.like);
                    b=true;
                }
            }
        });

        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri imageUri = (Uri) view.getTag();
                Intent intent=new Intent();
                intent.setAction(intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"Hello");
                intent.setType("text/plain");
                if (intent.resolveActivity(context.getPackageManager())!=null){
                }
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView newsImg,comment,like,share;
        public TextView title,newsDate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newsImg = itemView.findViewById(R.id.newsimg);
            comment = itemView.findViewById(R.id.comment);
            like = itemView.findViewById(R.id.like);
            share = itemView.findViewById(R.id.share);
            title = itemView.findViewById(R.id.title);
            newsDate = itemView.findViewById(R.id.news_date);
        }
    }
}
