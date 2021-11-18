package com.example.mimapa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity1 extends AppCompatActivity {

    Button mapa,ubic,sitio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        mapa=findViewById(R.id.btnmapa);
        ubic=findViewById(R.id.btnubic);
        sitio=findViewById(R.id.btnsitio);
        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent map= new Intent(MainActivity1.this,MapsActivity3.class);
                startActivity(map);
            }
        });
        ubic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ubic= new Intent(MainActivity1.this,MapsActivity2.class);
                startActivity(ubic);
            }
        });
        sitio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sitio= new Intent(MainActivity1.this,MapsActivity.class);
                startActivity(sitio);
            }
        });
    }
}