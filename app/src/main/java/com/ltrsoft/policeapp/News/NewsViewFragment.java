package com.ltrsoft.policeapp.News;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ltrsoft.policeapp.R;

public class NewsViewFragment extends Fragment {

    private ImageView newsi;
    private TextView newsDescription1,news_title1;

    public NewsViewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_view_fragment, container, false);

        // Initialize views
        newsi = view.findViewById(R.id.newsi);
        newsDescription1 = view.findViewById(R.id.news_description1);
        news_title1=view.findViewById(R.id.news_title1);

        // Get arguments from the bundle
        Bundle bundle = getArguments();
       newsi.setImageResource(R.drawable.news1);

        String description=bundle.getString("news_description");
        String titile=bundle.getString("news_title");
        newsDescription1.setText(description);
        news_title1.setText(titile);


        return view;
    }
}
