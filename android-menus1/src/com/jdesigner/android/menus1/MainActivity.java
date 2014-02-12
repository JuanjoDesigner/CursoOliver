package com.jdesigner.android.menus1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		final TextView lblMensaje = (TextView)findViewById(R.id.lblMensaje);
		
		switch (item.getItemId()) {
		case R.id.mnajustes:
			lblMensaje.setText("Seleccionado opción Ajustes");
			return true;

		case R.id.mnmapa:
			lblMensaje.setText("Seleccionado opción Mapas");
			return true;

		case R.id.mnagendaconsulta:
			lblMensaje.setText("Seleccionado opción Consulta Agenda");
			return true;

		case R.id.mnagendaedicion:
			lblMensaje.setText("Seleccionado opción Edicion Agenda");
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
		
	}

}
