package com.jdesegner.android.menu3;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView lblMensaje;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lblMensaje = (TextView)findViewById(R.id.lblMensaje);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menuOpcion1:
			lblMensaje.setText("Selecionada la opción de menú -Ajustes-");
			return true;

		case R.id.menuOpcion2:
			lblMensaje.setText("Selecionada la opción de menú -Mapas-");
			return true;

		case R.id.menuOpcion3_1:
			item.setChecked(true);
			lblMensaje.setText("Selecionada la opción de menú -Nueva Agenda-");
			return true;

		case R.id.menuOpcion3_2:
			item.setChecked(true);
			lblMensaje.setText("Selecionada la opción de menú -Editar Agenda-");
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
