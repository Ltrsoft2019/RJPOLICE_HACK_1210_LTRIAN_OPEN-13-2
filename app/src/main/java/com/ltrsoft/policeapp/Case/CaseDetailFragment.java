package com.ltrsoft.policeapp.Case;

import static androidx.core.content.ContextCompat.getSystemService;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.io.IOException;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import com.ltrsoft.policeapp.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CaseDetailFragment extends Fragment {
    public CaseDetailFragment() {}
    public TextView adress,incident_date,victim,compalin_desc,crime_type,complain_name;
    public Button get_loaction,add_info_btn;
    public ImageButton casePdf;
    public ImageView back;
    public Double latitude,longitude;
    private TextView download;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.case_detail_fragment, container, false);

        get_loaction=view.findViewById(R.id.location);
        casePdf = view.findViewById(R.id.case_pdf);
        back = view.findViewById(R.id.case_back);

        complain_name = view.findViewById(R.id.complain_name);
        crime_type = view.findViewById(R.id.crime_type);
        compalin_desc = view . findViewById(R.id.compalin_desc);
        victim=view.findViewById(R.id.victim);
        adress=view.findViewById(R.id.adress);
        incident_date=view.findViewById(R.id.incident_date);
        download=view.findViewById(R.id.downloadpdf);

        Bundle b = getArguments();
        if (b!=null) {
            complain_name.setText(b.getString("complain_name"));
            crime_type.setText(b.getString("crime_type"));
            compalin_desc.setText(b.getString("complaint_description"));
            victim.setText(b.getString("complaint_against"));
            adress.setText(b.getString("user_address"));
            incident_date.setText(b.getString("incident_date"));
            latitude = Double.parseDouble(b.getString("latitude"));
            longitude = Double.parseDouble(b.getString("longitude"));
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new CaseFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        get_loaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CaseMapsFragment mapsFragment =new CaseMapsFragment();
               // AppCompatActivity activity=(AppCompatActivity)view.getContext();
                Bundle bundle = new Bundle();
                bundle.putDouble("lattitude",latitude);
                bundle.putDouble("longitude",longitude);
                mapsFragment.setArguments(bundle);

                LocationManager locationManager = (LocationManager) requireActivity().getSystemService(Context.LOCATION_SERVICE);

                if (locationManager != null) {
                    boolean isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
                    boolean isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

                    if (isGpsEnabled || isNetworkEnabled) {
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, mapsFragment)
                                .addToBackStack(null)
                                .commit();
                    } else {
                        showEnableLocationDialog();
                    }
                }


            }
        });

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File pdfFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "example.pdf");

                try {

                    PdfWriter writer = new PdfWriter(new FileOutputStream(pdfFile));
                    PdfDocument pdf = new PdfDocument(writer);
                    Document document = new Document(pdf);
                    Paragraph paragraph = new Paragraph("Case Details");
                    paragraph.setTextAlignment(TextAlignment.CENTER);
                    document.add(paragraph);
                    document.add(new Paragraph("Complain Name :         "+b.getString("complain_name")));
                    document.add(new Paragraph("Crime Type    :         "+b.getString("crime_type")));
                    document.add(new Paragraph("Complain Description :  "+b.getString("complaint_description")));
                    document.add(new Paragraph("Complain Against :      "+b.getString("complaint_against")));
                    document.add(new Paragraph("Incident Date  :        "+b.getString("incident_date")));
                    document.add(new Paragraph("Address :                "+b.getString("user_address")));
                    document.close();
                    Log.d("PdfGenerator", "PDF created successfully at: " + pdfFile.getAbsolutePath());
                    Toast.makeText(getContext(), "PDF created successfully at: " + pdfFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }

                String pdfFileName ="example.pdf";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.parse(pdfFile.getAbsolutePath()), "application/pdf");
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getContext(), "You have No pdf Viewer please download", Toast.LENGTH_SHORT).show();
                    Log.d("pdf exception",e.toString());
                }
            }
        });

        return view;
    }
    private void showEnableLocationDialog() {
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
      /*  CaseMapsFragment mapsFragment =new CaseMapsFragment()
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, mapsFragment)
                .addToBackStack(null)
                .commit();*/
        startActivity(intent);
    }

}