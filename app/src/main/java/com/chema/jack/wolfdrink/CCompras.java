package com.chema.jack.wolfdrink;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by JACK on 05/04/2015.
 */

public class CCompras extends ActionBarActivity {

    private Button BtnSPed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compras);

        BtnSPed = (Button)findViewById(R.id.BtnSolPed);

        BtnSPed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent = new Intent(CCompras.this, CDatosCompra.class);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
    }





}
