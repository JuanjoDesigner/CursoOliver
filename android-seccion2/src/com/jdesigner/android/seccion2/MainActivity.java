package com.jdesigner.android.seccion2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private ListView listaValores;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Cargamos el array y el adaptador con los datos del array
		final String[] valores = getResources().getStringArray(R.array.valores_array);
		final ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.valores_array, android.R.layout.simple_expandable_list_item_1);

		// Cargamos la lista de valores (ListView)
		listaValores = (ListView)findViewById(R.id.listaValores);
		//adaptador.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);
		listaValores.setAdapter(adaptador);
		
		// Capturamos el control del TextView y de la lista de valores ListView
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
