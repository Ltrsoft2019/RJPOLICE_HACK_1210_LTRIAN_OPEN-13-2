package com.ltrsoft.policeapp.Adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.policeapp.Case.CaseDetailFragment;
import com.ltrsoft.policeapp.Classes.CaseClass;
import com.ltrsoft.policeapp.R;

import java.util.ArrayList;

public class CaseAdapter extends RecyclerView.Adapter<CaseAdapter.ViewHolder> {
    ArrayList <CaseClass>list;

    public CaseAdapter(ArrayList<CaseClass> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.case_recycle_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CaseClass caseClass = list.get(position);
        holder.case_id.setText(caseClass.getId());
        holder.case_name.setText(caseClass.getName());
        holder.case_location.setText(caseClass.getLocation());
        holder.case_time.setText(caseClass.getTime());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity=(AppCompatActivity)view.getContext();
                CaseDetailFragment detailFragment = new CaseDetailFragment();
                Bundle b = new Bundle();
                b.putString("case_name", caseClass.getName());
                b.putString("case_id", caseClass.getId());
                b.putString("case_location", caseClass.getLocation());
                b.putString("case_time", caseClass.getTime());
                detailFragment.setArguments(b);
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, detailFragment)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {return list.size();}

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView case_name,case_id,case_location,case_time;
        public LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            case_id = itemView.findViewById(R.id.case_id);
            case_name = itemView.findViewById(R.id.case_name);
            case_location = itemView.findViewById(R.id.case_location);
            case_time = itemView.findViewById(R.id.case_time);
            layout=itemView.findViewById(R.id.case_layout);
        }
    }
}
