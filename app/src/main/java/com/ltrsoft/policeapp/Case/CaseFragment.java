package com.ltrsoft.policeapp.Case;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ltrsoft.policeapp.Adapter.CaseAdapter;
import com.ltrsoft.policeapp.Classes.CaseClass;
import com.ltrsoft.policeapp.R;

import java.util.ArrayList;

public class CaseFragment extends Fragment {
    public CaseFragment() {}
    private RecyclerView recyclerView ;
    ArrayList <CaseClass>list=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.case_fragment, container, false);
        Toast.makeText(getContext(), "Case fragment clicked", Toast.LENGTH_SHORT).show();
        recyclerView = view.findViewById(R.id.case_recycler);
        list.add(new CaseClass("001","ganesh","latur","12.00"));
        list.add(new CaseClass("001","ganesh","latur","12.00"));
        list.add(new CaseClass("001","ganesh","latur","12.00"));
        list.add(new CaseClass("001","ganesh","latur","12.00"));
        list.add(new CaseClass("001","ganesh","latur","12.00"));
        list.add(new CaseClass("001","ganesh","latur","12.00"));
        list.add(new CaseClass("001","ganesh","latur","12.00"));
        CaseAdapter adapter = new CaseAdapter(list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }
}