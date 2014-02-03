package com.jdesigner.android.controles1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	private TextView lblTexto;
	private Button btnBoton1;
	private ToggleButton btnBoton2;
	private ImageButton btnBoton3;
	private Button btnBoton4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Capturamos el control de la etiqueta texto para pintar los mensajes
		lblTexto = (TextView)findViewById(R.id.lblTexto);
		
		//Capturamos y tratamos el control del boton 1 (Pulsame)
		btnBoton1 = (Button)findViewById(R.id.btnBoton1);
		
		btnBoton1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				lblTexto.setText("Pulsado Boton 1 de Pulsame!");
			}
		});

		//Capturamos y tratamos el control del boton  (on-off)
		btnBoton2 = (ToggleButton)findViewById(R.id.btnBoton2);
		
		btnBoton2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(btnBoton2.isChecked() ) {
					lblTexto.setText("Pulsado Boton 2 como ON!");
				} else {
					lblTexto.setText("Pulsado Boton 2 como OFF!");
				}
			}
		});

		//Capturamos y tratamos el control del boton 1 (Pulsame)
		btnBoton3 = (ImageButton)findViewById(R.id.btnBoton3);
		
		btnBoton3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				lblTexto.setText("Pulsado Boton 3 de Imagen!");
			}
		});

		//Capturamos y tratamos el control del boton 1 (Pulsame)
		btnBoton4 = (Button)findViewById(R.id.btnBoton4);
		
		btnBoton4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				lblTexto.setText("Pulsado Boton 4 de Pulsame con Imagen!");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
