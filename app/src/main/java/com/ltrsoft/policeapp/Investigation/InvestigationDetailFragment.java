package com.ltrsoft.policeapp.Investigation;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.io.IOException;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.ltrsoft.policeapp.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class InvestigationDetailFragment extends Fragment {
    public InvestigationDetailFragment() {}
    private TextView fir_id,complaint_subject,complaint_type_name,complaintORfir_name,status_name;
    private TextView suspect_name,suspect_address,suspect_gender,suspect_mobile_no,suspect_dob;
    private TextView investigation_witness_name, investigation_witness_address,investigation_witness_dob,investigation_witness_gender,
            investigation_witness_mobile;
    private TextView victim_name, victim_address,victim_gender,victim_mobile_no,victim_dob;
    private Button addinfobtn;
    private String fir;
    private TextView invstdownload;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.investigation_detail_fragment, container, false);
        Bundle b= getArguments();

        addinfobtn = view.findViewById(R.id.addinfobtn);

        fir_id = view.findViewById(R.id.ifirno);
        complaint_subject = view.findViewById(R.id.invstcompalin_name);
        complaint_type_name = view.findViewById(R.id.crime_type);
        complaintORfir_name = view.findViewById(R.id.complainorfir);
        status_name = view.findViewById(R.id.status);
        suspect_name = view.findViewById(R.id.s_name);
        suspect_address = view.findViewById(R.id.sadress);
        suspect_gender = view.findViewById(R.id.sgender);
        suspect_mobile_no = view.findViewById(R.id.suspect_no);
        suspect_dob = view.findViewById(R.id.sdob);
        investigation_witness_name = view.findViewById(R.id.wname);
        investigation_witness_address = view.findViewById(R.id.wadress);
        investigation_witness_dob = view.findViewById(R.id.wdob);
        investigation_witness_gender = view.findViewById(R.id.wgender);
        investigation_witness_mobile = view.findViewById(R.id.witness_mobno);
        victim_name = view.findViewById(R.id.vname);
        victim_address = view.findViewById(R.id.vadress);
        victim_gender = view.findViewById(R.id.vgender);
        victim_mobile_no = view.findViewById(R.id.victim_mobno);
        victim_dob = view.findViewById(R.id.vdob);
        invstdownload = view.findViewById(R.id.investigationpdf);
        fir=b.getString("fir_id");

        if (b!=null) {
            fir_id.setText(b.getString("fir_id"));
            complaint_subject.setText(b.getString("complaint_subject"));
            complaint_type_name.setText(b.getString("complaint_type_name"));
            complaintORfir_name.setText(b.getString("complaintORfir_name"));
            status_name.setText(b.getString("status_name"));
            suspect_name.setText(b.getString("suspect_name"));
            suspect_address.setText(b.getString("suspect_address"));
            suspect_gender.setText(b.getString("suspect_gender"));
            suspect_mobile_no.setText(b.getString("suspect_mobile_no"));
            suspect_dob.setText(b.getString("suspect_dob"));
            investigation_witness_name.setText(b.getString("investigation_witness_name"));
            investigation_witness_address.setText(b.getString("investigation_witness_address"));
            investigation_witness_dob.setText(b.getString("investigation_witness_dob"));
            investigation_witness_gender.setText(b.getString("investigation_witness_gender"));
            investigation_witness_mobile.setText(b.getString("investigation_witness_mobile"));
            victim_name.setText(b.getString("victim_name"));
            victim_address.setText(b.getString("victim_address"));
            victim_gender.setText(b.getString("victim_gender"));
            victim_mobile_no.setText(b.getString("victim_mobile_no"));
            victim_dob.setText(b.getString("victim_dob"));
        }
        addinfobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "fir id = "+fir, Toast.LENGTH_SHORT).show();
                InvestigationFormFragment invstFragment =new InvestigationFormFragment();
                //  AppCompatActivity activity=(AppCompatActivity)view.getContext();
                Bundle bundle = new Bundle();
                bundle.putString("fir_id",fir);
                invstFragment.setArguments(bundle);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, invstFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        invstdownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               File pdfFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "investigation.pdf");

                try {

                    PdfWriter writer = new PdfWriter(new FileOutputStream(pdfFile));
                    PdfDocument pdf = new PdfDocument(writer);
                    Document document = new Document(pdf);
                    document.add(new Paragraph("            Investigation Details"));
                    document.add(new Paragraph("FIR No :         "+b.getString("fir_id")));
                    document.add(new Paragraph("Complain Name :         "+b.getString("complaint_subject")));
                    document.add(new Paragraph("Crime Type    :         "+b.getString("complaint_type_name")));
                    document.add(new Paragraph("status :  "+b.getString("status_name")));
                    document.add(new Paragraph("Complain/FIR :      "+b.getString("complaintORfir_name")+"\n"));

                    document.add(new Paragraph("            Suspect Details"));
                    document.add(new Paragraph("Suspect Name:        "+b.getString("suspect_name")));
                    document.add(new Paragraph("Suspect Adress:        "+b.getString("suspect_address")));
                    document.add(new Paragraph("DOb :"+b.getString("suspect_dob")));
                    document.add(new Paragraph("Gender :"+b.getString("suspect_gender")));
                   // document.add(new Paragraph("Adhaar No :"+b.getString("suspect_name")));
                    document.add(new Paragraph("Mob no :"+b.getString("suspect_mobile_no")+"\n"));

                    document.add(new Paragraph("            Witness Details"));
                    document.add(new Paragraph("Witness Name:        "+b.getString("investigation_witness_name")));
                    document.add(new Paragraph("DOb :"+b.getString("investigation_witness_dob")));
                    document.add(new Paragraph("Gender :"+b.getString("investigation_witness_gender")));
                    document.add(new Paragraph("Address :"+b.getString("investigation_witness_address")));
                    document.add(new Paragraph("Mob no :"+"\n"+b.getString("investigation_witness_mobile")));


                    document.add(new Paragraph("            Victim Details"));
                    document.add(new Paragraph("Suspect Name:        "+b.getString("victim_name")));
                    document.add(new Paragraph("DOb :"+b.getString("victim_dob")));
                    document.add(new Paragraph("Gender :"+b.getString("victim_gender")));
                    document.add(new Paragraph("Address :"+b.getString("victim_address")));
                    document.add(new Paragraph("Mob no :"+"\n"+b.getString("victim_mobile_no")));
                    document.close();
                    Log.d("PdfGenerator", "PDF created successfully at: " + pdfFile.getAbsolutePath());
                   // Toast.makeText(getContext(), "PDF created successfully at: " + pdfFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();
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
}