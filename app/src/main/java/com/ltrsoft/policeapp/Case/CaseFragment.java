package com.ltrsoft.policeapp.Case;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.ltrsoft.policeapp.Adapter.CaseAdapter;
import com.ltrsoft.policeapp.Classes.CaseClass;
import com.ltrsoft.policeapp.Notification.MyFireBaseNotification;
import com.ltrsoft.policeapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CaseFragment extends Fragment {
    public CaseFragment() {}
    private RecyclerView recyclerView ;
    ArrayList <CaseClass>list=new ArrayList<>();
    private final static String CASE_URL= "https://rj.ltr-soft.com/public/police_api/data/complaint_all.php";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.case_fragment, container, false);
        //Intent intent = new Intent(CaseFragment.this , MyFireBaseNotification.class);
        //Toast.makeText(getContext(), "Case fragment clicked", Toast.LENGTH_SHORT).show();
        recyclerView = view.findViewById(R.id.case_recycler);
        if (list!=null){
            list.clear();
        }
        loadCases();
        return view;
    }

    private void loadCases() {

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.POST, CASE_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //  Toast.makeText(getContext(), "succes", Toast.LENGTH_SHORT).show();
                //  Toast.makeText(getContext(), "response ="+response.toString(), Toast.LENGTH_SHORT).show();
                for (int i = 0; i<response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        String complaint_name = jsonObject.getString("complaint_subject");
                        String status_name = jsonObject.getString("status_name");
                        String complaint_type_name = jsonObject.getString("complaint_type_name");
                        String complaint_description = jsonObject.getString("complaint_description");
                        String complaint_against = jsonObject.getString("complaint_against");
                        String incident_date = jsonObject.getString("incident_date");
                        String latitude = jsonObject.getString("latitude");
                        String longitude = jsonObject.getString("longitude");
                        String complaint_fir_id = jsonObject.getString("complaint_fir_id");
                        String created_at = jsonObject.getString("created_at");
                        String updated_at = jsonObject.getString("updated_at");
                        String user_address = jsonObject.getString("user_address");
                        list.add(new CaseClass(complaint_name,status_name,complaint_type_name,complaint_description,
                                complaint_against,incident_date,latitude,longitude,complaint_fir_id,created_at,
                                updated_at,user_address));
                        // Toast.makeText(getContext(), "lattitude= "+latitude, Toast.LENGTH_SHORT).show();
                        CaseAdapter adapter = new CaseAdapter(list);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(adapter);
                    } catch (JSONException e) {
                        Toast.makeText(getContext(), "json error"+e.toString(), Toast.LENGTH_LONG).show();
                        Log.d("error json ",e.toString());
                        throw new RuntimeException(e);
                    }

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loadCases();
                Toast.makeText(getContext(), "Eror = "+error.toString(), Toast.LENGTH_SHORT).show();
//                Log.d("erro", error.getMessage());

            }
        });
        RequestQueue  queue = Volley.newRequestQueue(getContext());
        queue.add(request);
        request.setRetryPolicy(new DefaultRetryPolicy(
                1000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


    }
}