package com.example.tecniled;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NuevoGrupo extends AppCompatActivity {

    private RecyclerView recView;
    private Opcion[] focos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_grupo);

        // Buscamos en el layout el RecyclerView
        recView = (RecyclerView) findViewById(R.id.RecView);

    }

    public void onClick(View v){


        switch (v.getId()){
            case R.id.btnNuevoFoco:
                Intent i = new Intent(this, FocoNuevo.class);
                startActivity(i);
                break;
        }

    }


}