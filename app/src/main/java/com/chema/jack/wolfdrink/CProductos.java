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
public class CProductos extends ActionBarActivity {

    private ImageButton BtnCerv;
    private Button BtnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productos);

        BtnCerv = (ImageButton)findViewById(R.id.IBtnCer);
        BtnAceptar = (Button)findViewById(R.id.BtnAceptarPro);

        BtnCerv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent = new Intent(CProductos.this, CCerveza.class);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

        BtnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent = new Intent(CProductos.this, CCompras.class);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
    }

}
