package com.example.tecniled;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){

        switch (v.getId()){
            case R.id.btnNuevoProyecto:
                Intent i = new Intent(this, NuevoProyecto.class);
                startActivity(i);
                break;
        }
    }

}