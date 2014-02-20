package com.jdesigner.android.xml1;

import java.util.List;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	// definicion de atributos
	private List<Noticia> noticias;
	private TextView txtResultado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// capturamos el control del texto
		txtResultado = (TextView) findViewById(R.id.txtResultado);

		// lanzamos un nuevo hilo para recuperar el XML
		CargarXmlTask tarea = new CargarXmlTask();
		tarea.execute("http://www.europapress.es/rss/rss.aspx");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class CargarXmlTask extends AsyncTask<String, Integer, Boolean> {

		@Override
		protected Boolean doInBackground(String... params) {
			// Estabecenos la conexión con la pagina RSS
			RssParserSax saxParser = new RssParserSax(params[0]);

			// cargamos la lista de noticias parseando el XML con SAX
			noticias = saxParser.parse();

			return true;
		}

		@Override
		protected void onPostExecute(Boolean result) {
			// tratamos la lista de noticias
			txtResultado.setText(null);
			for (Noticia noticia : noticias) {
				txtResultado.append(noticia.getTitulo() + "\n");
			}
		}

	}

}
