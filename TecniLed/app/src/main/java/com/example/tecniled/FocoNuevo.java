package com.example.tecniled;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

public class FocoNuevo extends AppCompatActivity {

    private EditText etnombre, etmarca, etmesa, etdmx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foco_nuevo);
        etnombre = (EditText) findViewById(R.id.etNombreFoco);
        etmarca = (EditText) findViewById(R.id.etMarca);
        etmesa = (EditText) findViewById(R.id.etMesaControl);
        etdmx = (EditText) findViewById(R.id.etCanalDMX);
    }

    public void onClick(View v) throws IOException {

        switch (v.getId()){
            case R.id.btnAceptarFoco:
                String nombre = etnombre.getText().toString();
                String marca = etmarca.getText().toString();
                int mesa = Integer.parseInt(etmesa.getText().toString());
                int dmx = Integer.parseInt(etdmx.getText().toString());
                Foco foco = new Foco(null, nombre,marca,mesa,dmx);
                OperacionesBaseDatos.insertarFoco(foco);
                this.finish();
                break;
        }

    }

    private void guardarFoco(Foco foco){
        try {
            OutputStreamWriter fileout = new OutputStreamWriter(
                    openFileOutput("focos.csv", Context.MODE_APPEND)
            );
            fileout.write(foco.toString()+"\n");
            fileout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}