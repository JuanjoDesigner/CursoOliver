package com.jdesigner.android.ficheros1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView lblTexto = (TextView)findViewById(R.id.lblTexto);
		
		try {
			OutputStreamWriter fout = new OutputStreamWriter(
					openFileOutput("prueba_int.txt", MODE_PRIVATE));
			fout.write("Prueba de texto grabado en fichero de la memoria interna");
			fout.close();
		} catch (Exception e) {
			Log.e("OutputStreamWriter", "Error al abrir/grabar en el fichero");
		}
		
		try {
			BufferedReader fin = new BufferedReader(
					new InputStreamReader(openFileInput("prueba_int.txt")));
			lblTexto.setText(fin.readLine());
			fin.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
