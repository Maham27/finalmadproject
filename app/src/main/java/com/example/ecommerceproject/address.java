package com.example.ecommerceproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class address extends AppCompatActivity implements adressadptor.clickedadess{
    Button btna;
    RecyclerView recyclerView;
    private List<adressdata> t;
    private adressadptor adp;
    FirebaseFirestore e;
    FirebaseAuth auth;
    Button btna,btnp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        btna=findViewById(R.id.btna);
        recyclerView=findViewById(R.id.addresrecycler);
       btnp=findViewById(R.id.btnp)

        e=FirebaseFirestore.getInstance();
        auth=FirebaseAuth.getInstance();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        t=new ArrayList<>();
        adp=new adressadptor(getApplicationContext(),t,this);
        recyclerView.setAdapter(adp);

        //e.collection()
        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(address.this,MainActivity2.class);
                startActivity(intent);
            }
        });

        btnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(address.this,payment.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void setAddress(String address) {

    }
}