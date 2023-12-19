package com.ltrsoft.policeapp.News;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ltrsoft.policeapp.R;
public class NewsViewFragment extends Fragment {

    public NewsViewFragment() {
    }
    private  ImageView newsimg;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_view_fragment, container, false);
        newsimg = view.findViewById(R.id.newsi);
        Bundle bundle=getArguments();
        newsimg.setImageResource(bundle.getInt("news_img"));
        return view;
    }
}