package com.ltrsoft.policeapp.Investigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ltrsoft.policeapp.Adapter.CaseAdapter;
import com.ltrsoft.policeapp.Adapter.InvestigationAdapter;
import com.ltrsoft.policeapp.Classes.CaseClass;
import com.ltrsoft.policeapp.Classes.InvestigationClass;
import com.ltrsoft.policeapp.R;

import java.util.ArrayList;

public class InvestigationFragment extends Fragment {
    public InvestigationFragment() {}
    private RecyclerView recyclerView ;
    ArrayList<InvestigationClass> list=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.investigation_fragment, container, false);
        recyclerView = view.findViewById(R.id.investigation_recycler);
       // Toast.makeText(getContext(), "Investigation fragment clicked", Toast.LENGTH_SHORT).show();
       list.add(new InvestigationClass("omkar kshirsagar","ganesh sagave","kaif ","murder","Harun"));
       list.add(new InvestigationClass("omkar kshirsagar","ganesh sagave","kaif ","murder","Harun"));
       list.add(new InvestigationClass("omkar kshirsagar","ganesh sagave","kaif ","murder","Harun"));
       list.add(new InvestigationClass("omkar kshirsagar","ganesh sagave","kaif ","murder","Harun"));
       list.add(new InvestigationClass("omkar kshirsagar","ganesh sagave","kaif ","murder","Harun"));
       list.add(new InvestigationClass("omkar kshirsagar","ganesh sagave","kaif ","murder","Harun"));
        InvestigationAdapter adapter = new InvestigationAdapter(list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }
}