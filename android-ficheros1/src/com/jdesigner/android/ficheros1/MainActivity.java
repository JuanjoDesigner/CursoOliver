package com.jdesigner.android.ficheros1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Capturamos los controles del layout
		final TextView lblTexto = (TextView)findViewById(R.id.lblTexto);
		Button btnMemoria = (Button)findViewById(R.id.btnMemoria);
		Button btnRaw = (Button)findViewById(R.id.btnRaw);
		Button btnSD = (Button)findViewById(R.id.btnSD);
		
		// Deshabilitamos el btnSD si la memoria no está disponible
		if(Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
			btnSD.setEnabled(false);
		} else {
			btnSD.setEnabled(true);
		}
		
		// Programamos el boton btnMemoria
		btnMemoria.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				try {
					OutputStreamWriter fout = new OutputStreamWriter(
							openFileOutput("prueba_int.txt", MODE_PRIVATE));
					fout.write("Prueba de texto grabado en fichero de la memoria interna");
					fout.close();
				} catch (Exception e) {
					Log.e("Ficheros", "Error al abrir/grabar el fichero Momoria");
				}
				
				try {
					BufferedReader fin = new BufferedReader(
							new InputStreamReader(openFileInput("prueba_int.txt")));
					lblTexto.setText(fin.readLine());
					fin.close();
					
				} catch (Exception e) {
					Log.e("Ficheros", "Error al abrir/leer el fichero Memoria");
				}
			}
		});

		btnRaw.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				try {
					InputStream fraw = getResources().openRawResource(R.raw.prueba_raw);
						 
					BufferedReader brin = new BufferedReader(new InputStreamReader(fraw));
						 
					lblTexto.setText(brin.readLine());
						 
					fraw.close();
						    
				} catch (Exception e) {
					Log.e("FicheroRaw", "Error al abrir/leer el fichero Raw");
				}
				
			}
		});

		btnSD.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				try {
					File ruta_sd = Environment.getExternalStorageDirectory();
					
					File f = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");
					 
				    OutputStreamWriter fout =
				        new OutputStreamWriter(
				            new FileOutputStream(f));
				 
				    fout.write("Prueba de texto grabado en fichero de la memoria SD");
				    fout.close();
				} catch (Exception e) {
					Log.e("FicheroSD", "Error al abrir/escribir el fichero SD");
				}

				try {
					File ruta_sd = Environment.getExternalStorageDirectory();
					 
				    File f = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");
				 
				    BufferedReader fin =
				        new BufferedReader(
				            new InputStreamReader(
				                new FileInputStream(f)));
				 
				    lblTexto.setText(fin.readLine());
				    fin.close();
				} catch (Exception e) {
					Log.e("FicheroSD", "Error al abrir/leer el fichero SD");
				}

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
