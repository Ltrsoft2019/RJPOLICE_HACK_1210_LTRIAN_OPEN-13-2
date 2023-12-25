package com.ltrsoft.policeapp.Adapter;

import static android.app.PendingIntent.getActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.policeapp.Case.CaseDetailFragment;
import com.ltrsoft.policeapp.Classes.InvestigationClass;
import com.ltrsoft.policeapp.Investigation.InvestigationDetailFragment;
import com.ltrsoft.policeapp.Navigation.NavigationFragment;
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
        holder.investigation_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity=(AppCompatActivity)v.getContext();
                InvestigationDetailFragment detailFragment = new InvestigationDetailFragment();
                Bundle bundle = new Bundle();

                bundle.putString("fir_id",invstclass.getFir_id());
                bundle.putString("complaint_subject",invstclass.getComplaint_subject());
                bundle.putString("complaint_type_name",invstclass.getComplaint_type_name());
                bundle.putString("complaintORfir_name",invstclass.getComplaintORfir_name());
                bundle.putString("status_name",invstclass.getStatus_name());
                bundle.putString("suspect_name",invstclass.getSuspect_name());
                bundle.putString("suspect_address",invstclass.getSuspect_address());
                bundle.putString("suspect_gender",invstclass.getSuspect_gender());
                bundle.putString("suspect_mobile_no",invstclass.getSuspect_mobile_no());
                bundle.putString("suspect_photo",invstclass.getSuspect_photo());
                bundle.putString("investigation_witness_name",invstclass.getInvestigation_witness_name());
                bundle.putString("investigation_witness_address",invstclass.getInvestigation_witness_address());
                bundle.putString("investigation_witness_dob",invstclass.getInvestigation_witness_dob());
                bundle.putString("investigation_witness_gender",invstclass.getInvestigation_witness_gender());
                bundle.putString("investigation_witness_mobile",invstclass.getInvestigation_witness_mobile());
                bundle.putString("investigation_witness_photo",invstclass.getInvestigation_witness_photo());
                bundle.putString("victim_name",invstclass.getVictim_name());
                bundle.putString("victim_gender",invstclass.getVictim_gender());
                bundle.putString("victim_mobile_no",invstclass.getFir_id());
                bundle.putString("victim_photo",invstclass.getVictim_photo());
                bundle.putString("suspect_dob",invstclass.getSuspect_dob());
                bundle.putString("victim_dob",invstclass.getVictim_dob());

                detailFragment.setArguments(bundle);
                    activity.getSupportFragmentManager().beginTransaction().
                            replace(R.id.fragment_container,detailFragment)
                            .addToBackStack(null)
                            .commit();

            }
        });
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
