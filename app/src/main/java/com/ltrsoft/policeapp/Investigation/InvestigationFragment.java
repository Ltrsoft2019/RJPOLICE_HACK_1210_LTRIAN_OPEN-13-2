package com.ltrsoft.policeapp.Investigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.policeapp.Adapter.CaseAdapter;
import com.ltrsoft.policeapp.Adapter.InvestigationAdapter;
import com.ltrsoft.policeapp.Classes.CaseClass;
import com.ltrsoft.policeapp.Classes.InvestigationClass;
import com.ltrsoft.policeapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class InvestigationFragment extends Fragment {
    public InvestigationFragment() {}
    private RecyclerView recyclerView ;
    ArrayList<InvestigationClass> list=new ArrayList<>();
    public final static String INVESTIGATION_URL ="https://rj.ltr-soft.com//police_api/investigation/investigation_detail.php";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.investigation_fragment, container, false);
        recyclerView = view.findViewById(R.id.investigation_recycler);

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.POST, INVESTIGATION_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
               // Toast.makeText(getContext(), "response"+response, Toast.LENGTH_SHORT).show();
                for (int i=0 ; i<response.length();i++) {
                    try {
                      JSONObject jsonObject = response.getJSONObject(i);
                      //fir_id,complaint_subject,complaint_type_name,complaintORfir_name,status_name
                        //    ,suspect_fname,suspect_mname,suspect_lname,suspect_address,suspect_gender,suspect_mobile_no,suspect_photo,
                        //            investigation_witness_fname,investigation_witness_mname,investigation_witness_lname,
                        //            investigation_witness_address,investigation_witness_dob,investigation_witness_gender,
                        //            investigation_witness_mobile,investigation_witness_photo,victim_fname,victim_mname,victim_lname,
                        //             victim_address,victim_gender,victim_mobile_no,victim_photo
                        String fir_id = jsonObject.getString("fir_id");
                        String complaint_subject = jsonObject.getString("complaint_subject");
                        String complaint_type_name = jsonObject.getString("complaint_type_name");
                        String status_name = jsonObject.getString("status_name");
                        String complaint_fir_name = jsonObject.getString("complaint_fir_name");

                        list.add(new InvestigationClass(fir_id,complaint_subject,complaint_type_name,complaint_fir_name,status_name));

                        InvestigationAdapter adapter = new InvestigationAdapter(list);

                        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(adapter);
                    } catch (JSONException e) {
                        Toast.makeText(getContext(), "json exception", Toast.LENGTH_SHORT).show();
                        throw new RuntimeException(e);
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "error response = "+error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(request);

        return view;
    }
}