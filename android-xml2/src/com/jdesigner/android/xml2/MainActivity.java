package com.jdesigner.android.xml2;

import java.util.List;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView txtResultado;
	private List<Noticia> noticias;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		txtResultado = (TextView) findViewById(R.id.txtResultado);

		// Con Tarea As�ncrona
		CargarXmlTask tarea = new CargarXmlTask();
		tarea.execute("http://www.elmundo.com/images/rss/noticias.xml");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// Tarea As�ncrona para cargar un XML en segundo plano
	private class CargarXmlTask extends AsyncTask<String, Integer, Boolean> {

		protected Boolean doInBackground(String... params) {

			RssParserSax2 saxparser = new RssParserSax2(params[0]);

			noticias = saxparser.parse();

			return true;
		}

		protected void onPostExecute(Boolean result) {

			// Tratamos la lista de noticias
			// Por ejemplo: escribimos los t�tulos en pantalla
			txtResultado.setText("");
			for (int i = 0; i < noticias.size(); i++) {
				txtResultado.setText(txtResultado.getText().toString()
						+ System.getProperty("line.separator")
						+ noticias.get(i).getTitulo());
			}
		}
	}
}
