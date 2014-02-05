package com.jdesigner.android.seccion3;

import com.jdesigner.android.seccion2.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
		private ListView listaValores;
		
		private Titular[] valores = new Titular[] {
		    		new Titular("Título 1", "Subtítulo largo 1"),
		    		new Titular("Título 2", "Subtítulo largo 2"),
		    		new Titular("Título 3", "Subtítulo largo 3"),
		    		new Titular("Título 4", "Subtítulo largo 4"),
		    		new Titular("Título 5", "Subtítulo largo 5")};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Cargamos el array de valores y AdaptadorTitular con los datos del array
		AdaptadorTitulares adaptador = new AdaptadorTitulares(this);

		// Capturamos el control del TextView y de la lista de valores ListView
		final TextView txtMensaje = (TextView)findViewById(R.id.txtMensaje);

		// Cargamos la lista de valores (ListView)
		listaValores = (ListView)findViewById(R.id.listaValores);

		listaValores.setAdapter(adaptador);
		
		listaValores.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				//Alternativa 1:
			    String opcionSeleccionada = ((Titular)a.getAdapter().getItem(position)).getTitulo();
			 
			    //Alternativa 2:
			    //String opcionSeleccionada = 
			    //       ((TextView)v.findViewById(R.id.LblTitulo))
			    //           .getText().toString();
			 
			    txtMensaje.setText("Opción seleccionada: " + opcionSeleccionada);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	class AdaptadorTitulares extends ArrayAdapter<Titular> {
		
	    Activity context;
	    
        AdaptadorTitulares(Activity context) {
            super(context, android.R.layout.simple_list_item_1, valores);
            this.context = context;
        }
 
        public View getView(int position, View convertView, ViewGroup parent) {
        	View item = convertView;
        	
        	if(item == null) {
        	
        		
        		LayoutInflater inflater = context.getLayoutInflater();
        		item = inflater.inflate(R.layout.listitem_titular, null);
        	}
        	
        	TextView lblTitulo = (TextView)item.findViewById(R.id.lblTitulo);
        	lblTitulo.setText(valores[position].getTitulo());
 
        	TextView lblSubtitulo = (TextView)item.findViewById(R.id.lblSubtitulo);
        	lblSubtitulo.setText(valores[position].getSubtitulo());
 
        	return(item);

        }
	}
}
