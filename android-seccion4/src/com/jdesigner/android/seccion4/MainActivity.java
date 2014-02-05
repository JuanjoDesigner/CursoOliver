package com.jdesigner.android.seccion4;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private String[] datos = new String[25];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		for(int i=0; i<25; i++) {
			datos[i] = "Dato " + (i+1);
		}
		
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
		
		final TextView lblMensaje = (TextView)findViewById(R.id.lblMensaje);
		GridView gridOpciones = (GridView)findViewById(R.id.gridOpciones);
		gridOpciones.setAdapter(adaptador);
		
		gridOpciones.setOnItemClickListener(
				   new AdapterView.OnItemClickListener() {
				      public void onItemClick(AdapterView<?> parent,
				         android.view.View v, int position, long id) {
				    	  lblMensaje.setText("Opción seleccionada: " + datos[position]);
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
