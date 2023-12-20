package com.ltrsoft.policeapp.News;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ltrsoft.policeapp.Adapter.NewsAdapter;
import com.ltrsoft.policeapp.Classes.News;
import com.ltrsoft.policeapp.R;

import java.util.ArrayList;

public class NewsFragment extends Fragment {
    public NewsFragment() {}
    private RecyclerView recyclerView ;
    ArrayList <News>list=new ArrayList<>();
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_fragment, container, false);
        recyclerView = view.findViewById(R.id.recycler_news);
        list.add(new News(R.drawable.news1,"Braeking News","12-03-2024"));
        list.add(new News(R.drawable.newspaper,"Braeking News","12-03-2024"));
        list.add(new News(R.drawable.newssample,"Braeking News","12-03-2024"));
        list.add(new News(R.drawable.news1,"Braeking News","12-03-2024"));
        list.add(new News(R.drawable.newspaper,"Braeking News","12-03-2024"));
        list.add(new News(R.drawable.news1,"Braeking News","12-03-2024"));
        list.add(new News(R.drawable.newspaper,"Braeking News","12-03-2024"));
        list.add(new News(R.drawable.newssample,"Braeking News","12-03-2024"));
        list.add(new News(R.drawable.news1,"Braeking News","12-03-2024"));
        list.add(new News(R.drawable.newspaper,"Braeking News","12-03-2024"));

        NewsAdapter adapter = new NewsAdapter(list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }
}