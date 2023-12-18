package com.ltrsoft.policeapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.policeapp.Classes.InvestigationClass;
import com.ltrsoft.policeapp.R;

import java.util.ArrayList;

public class InvestigationAdapter extends RecyclerView.Adapter<InvestigationAdapter.ViewHolder> {
    public ArrayList<InvestigationClass>list;

    public InvestigationAdapter(ArrayList<InvestigationClass> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.investigation_recycle_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            InvestigationClass invstclass = list.get(position);
            holder.invst_id.setText(invstclass.getInv_id());
            holder.invst_name.setText(invstclass.getInv_name());
            holder.invst_location.setText(invstclass.getInv_location());
            holder.invst_time.setText(invstclass.getInv_time());
    }

    @Override
    public int getItemCount() {return list.size();    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView invst_name,invst_id,invst_location,invst_time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            invst_id = itemView.findViewById(R.id.invst_id);
            invst_name = itemView.findViewById(R.id.invst_name);
            invst_location = itemView.findViewById(R.id.invst_location);
            invst_time = itemView.findViewById(R.id.invst_time);
        }
    }
}
