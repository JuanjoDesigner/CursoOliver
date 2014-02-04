package com.jdesigner.android.seccion1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Spinner listaValores;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Cargamos lista de valores y el adaptador para lista desplegable (Spinner) desde xml
		final String[] valores = getResources().getStringArray(R.array.valores_array);
		final ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.valores_array, android.R.layout.simple_spinner_item);

		// Capturamos el controlador de la lista de valores
		listaValores = (Spinner)findViewById(R.id.listaValores);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		listaValores.setAdapter(adaptador);
		
		// Capturamos control TextView y evento OnItemSelected
		final TextView txtMensaje = (TextView)findViewById(R.id.txtMensaje);
		listaValores.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent,
		            android.view.View v, int position, long id) {
		                txtMensaje.setText("Seleccionado: " + valores[position]);
		        }
		 
		        public void onNothingSelected(AdapterView<?> parent) {
		            txtMensaje.setText("Nada seleccionado");
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
