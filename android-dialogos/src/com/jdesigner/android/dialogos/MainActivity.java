package com.jdesigner.android.dialogos;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// capturamos los controle de los botones
		Button btnAlerta = (Button) findViewById(R.id.btnAlerta);
		Button btnConfirmacion = (Button) findViewById(R.id.btnConfirmacion);
		Button btnSeleccion = (Button) findViewById(R.id.btnSeleccion);
		Button btnPersonalizado = (Button) findViewById(R.id.btnPersonalizado);

		// implementamos la acción del botón de Alerta
		btnAlerta.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				FragmentManager fragmentManager = getSupportFragmentManager();
				DialogoAlerta dialogo = new DialogoAlerta();
				dialogo.show(fragmentManager, "tagAlerta");

			}
		});
		
		// implementamos la acción del botón de Confirmación
		btnConfirmacion.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FragmentManager fragmentManager = getSupportFragmentManager();
				DialogoConfirmacion dialogo = new DialogoConfirmacion();
				dialogo.show(fragmentManager, "tagConfirmacion");
			}
		});
		
		// implementamos la acción del botón de Selección
		btnSeleccion.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FragmentManager fragmentManager = getSupportFragmentManager();
				DialogoSeleccion dialogo = new DialogoSeleccion();
				dialogo.show(fragmentManager, "tagSeleccion");
			}
		});
		
		// implementamos la acción del botón Personalizado
		btnPersonalizado.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FragmentManager fragmentManager = getSupportFragmentManager();
				DialogoPersonalizado dialogo = new DialogoPersonalizado();
				dialogo.show(fragmentManager, "tagPersonalizado");
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
