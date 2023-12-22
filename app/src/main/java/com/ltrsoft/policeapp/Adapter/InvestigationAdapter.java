package com.ltrsoft.policeapp.Adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.policeapp.Case.CaseDetailFragment;
import com.ltrsoft.policeapp.Classes.InvestigationClass;
import com.ltrsoft.policeapp.Investigation.InvestigationDetailFragment;
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
            holder.firno.setText(invstclass.getFir_id());
            holder.icrime_type.setText(invstclass.getComplaint_type_name());
            holder.icomplain_name.setText(invstclass.getComplaint_subject());
            holder.status.setText(invstclass.getStatus_name());
            holder.category.setText(invstclass.getComplaintORfir_name());
    }

    @Override
    public int getItemCount() {return list.size();    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView category,firno,status,icrime_type,icomplain_name;
        private CardView investigation_card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.iwitness);
            status = itemView.findViewById(R.id.ivictim);
            icrime_type = itemView.findViewById(R.id.isuspect);
            icomplain_name = itemView.findViewById(R.id.icrime_type);
            firno = itemView.findViewById(R.id.icomplain_name);
            investigation_card = itemView.findViewById(R.id.investigation_card);
        }
    }
}
