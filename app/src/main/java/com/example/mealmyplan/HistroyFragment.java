package com.example.mealmyplan;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistroyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistroyFragment extends Fragment {

    TextView tdorder, texp,ttco, tdco, ttorder, tname;
    Button btns,BtnPlan1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HistroyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistroyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HistroyFragment newInstance(String param1, String param2) {
        HistroyFragment fragment = new HistroyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment




        View view = inflater.inflate(R.layout.fragment_histroy, container, false);

        tdorder = view.findViewById(R.id.tod);
        ttorder = view.findViewById(R.id.tot);
        tdco = view.findViewById(R.id.tdco);
        ttco = view.findViewById(R.id.ttco);
        texp = view.findViewById(R.id.ttexp);
        tname = view.findViewById(R.id.ttname);
        btns = view.findViewById(R.id.bhsow);
        // BtnPlan1 = view.findViewById(R.id.bnp2);


        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference;
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                FirebaseUser user = firebaseAuth.getCurrentUser();
                String userKey = user.getUid();
                databaseReference = FirebaseDatabase.getInstance().getReference("history");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String name = snapshot.child(userKey).child("name").getValue(String.class);
                        String tdorder1 = snapshot.child(userKey).child("cdate").getValue(String.class);
                        String ttorder1 = snapshot.child(userKey).child("ctime").getValue(String.class);
                        String cadate = snapshot.child(userKey).child("cadate").getValue(String.class);
                        String catime = snapshot.child(userKey).child("catime").getValue(String.class);

                        String Edat = snapshot.child(userKey).child("expDate").getValue(String.class);

                        tdorder.setText(tdorder1);
                        ttorder.setText(ttorder1);
                        tdco.setText(cadate);
                        ttco.setText(catime);
                        texp.setText(Edat);
                        tname.setText(name);





                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });




            }
        });


//        BtnPlan1.setOnClickListener(new View.OnClickListener() {
//            @Override
//
//            public void onClick(View v)
//            {
//                DatabaseReference databaseReference;
//                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
//                FirebaseUser user = firebaseAuth.getCurrentUser();
//                String userKey = user.getUid();
//                databaseReference = FirebaseDatabase.getInstance().getReference("hotel");
//                databaseReference.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if(snapshot.child("directOrder").hasChild(userKey)){
//                            Intent intent = new Intent(getActivity().getApplicationContext(),ChossePlan1.class);
//                            startActivity(intent);
//                            //Toast.makeText(getActivity().getApplicationContext(), "order already exist " , Toast.LENGTH_SHORT).show();
//
//                        }else if(snapshot.child("CustomOrder").hasChild(userKey)){
//                            // Toast.makeText(getActivity().getApplicationContext(), "order already exist " , Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(getActivity().getApplicationContext(),ViewDirectPlan1.class);
//                            startActivity(intent);
//
//
//                        }else{
//                            Toast.makeText(getActivity().getApplicationContext(), "order Not exist " , Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//
//
//
//
//
//
//            }
//
//
//        });






        return view;
    }
}