package com.example.tecniled;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NuevoProyecto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_proyecto);
    }

    public void onClick(View v){

        switch (v.getId()){
            case R.id.btnNuevoGrupo:
                Intent i = new Intent(this, NuevoGrupo.class);
                startActivity(i);
                break;
        }

    }

}