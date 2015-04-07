package com.chema.jack.wolfdrink;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by JACK on 05/04/2015.
 */
public class CDatosCompra extends ActionBarActivity {

    private Button BtnPedido;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datoscompra);


        BtnPedido = (Button)findViewById(R.id.BtnPed);

        BtnPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent = new Intent(CDatosCompra.this, CValidacion.class);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

    }
}

