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
        ArrayList<CaseClass>caseClass1=list;
        holder.complain_name.setText(caseClass.getComplain_name());
        holder.crime_type.setText(caseClass.getComplaint_type_name());
        holder.crime_status.setText(caseClass.getStatus_name());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity=(AppCompatActivity)view.getContext();
                CaseDetailFragment detailFragment = new CaseDetailFragment();
                Bundle b = new Bundle();
                b.putString("complain_name", caseClass.getComplain_name());
                b.putString("crime_type", caseClass.getComplaint_type_name());
                b.putString("complaint_description", caseClass.getComplaint_description());
                b.putString("complaint_against", caseClass.getComplaint_against());
                b.putString("user_address", caseClass.getUser_address());
                b.putString("latitude", caseClass.getLatitude());
                b.putString("longitude", caseClass.getLatitude());
                b.putString("incident_date", caseClass.getIncident_date());
                detailFragment.setArguments(b);
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, detailFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {return list.size();}

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView complain_name,crime_type,crime_status;
        public LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            complain_name = itemView.findViewById(R.id.complain_name);
             crime_type= itemView.findViewById(R.id.crime_type);
            crime_status = itemView.findViewById(R.id.crime_status);
            layout=itemView.findViewById(R.id.case_layout);
        }
    }
}
