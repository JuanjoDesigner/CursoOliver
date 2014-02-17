package com.jdesigner.android.preferences2;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Obtenemos el controlador de lpos botones
		Button btnPreferencias = (Button)findViewById(R.id.btnPreferencias);
		Button btnObtenerPreferencias = (Button)findViewById(R.id.btnObtenerPreferencias);
		
		//Programamos los clic de los botones
		btnPreferencias.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, OpcionesActivity.class));
				
			}
		});
		
        btnObtenerPreferencias.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				SharedPreferences pref =
					PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

				Log.i("", "Opci�n 1: " + pref.getBoolean("opcion1", false));
				Log.i("", "Opci�n 2: " + pref.getString("opcion2", ""));
				Log.i("", "Opci�n 3: " + pref.getString("opcion3", ""));
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
