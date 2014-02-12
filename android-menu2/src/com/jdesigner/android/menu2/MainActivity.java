package com.jdesigner.android.menu2;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView lblmensaje;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Obtenemos el control de la etiqueta de texto
		lblmensaje = (TextView)findViewById(R.id.lblMensaje);
		
		// Asociamos el menu contextual a la etiqueta de texto
		registerForContextMenu(lblmensaje);
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
		case R.id.action_settings:
			lblmensaje.setText("Seleccionado Ajustes");
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		
		super.onCreateContextMenu(menu, v, menuInfo);
		
		MenuInflater inflater = getMenuInflater();
	
	    if(v.getId() == R.id.lblMensaje)
	        inflater.inflate(R.menu.menu_ctx_etiqueta, menu);
	    else if(v.getId() == R.id.opcion2)
	    {
//	        AdapterView.AdapterContextMenuInfo info =//
//	            (AdapterView.AdapterContextMenuInfo)menuInfo;
//	 
//	        menu.setHeaderTitle(lstLista.getAdapter().getItem(info.position).toString());
	 
	        inflater.inflate(R.menu.menu_ctx_lista, menu);
	    }

	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.opcion1:
			lblmensaje.setText("Seleccionado Opcion 1");
			return true;
			
		case R.id.opcion2_1:
			lblmensaje.setText("Seleccionado Opcion 2.1");
			return true;
			
		case R.id.opcion2_2:
			lblmensaje.setText("Seleccionado Opcion 2.2");
			return true;
			
		default:
			return super.onContextItemSelected(item);
		}
	}

}
