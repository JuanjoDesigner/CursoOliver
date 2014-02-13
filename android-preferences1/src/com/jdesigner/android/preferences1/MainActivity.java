package com.jdesigner.android.preferences1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText txtUsuario;
	private EditText txtCorreo;
	private Button btnPreferences;
	private SharedPreferences prefs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Capturando los controles
		txtUsuario = (EditText)findViewById(R.id.txtUsuario);
		txtCorreo = (EditText)findViewById(R.id.txtCorreo);
		btnPreferences = (Button)findViewById(R.id.btnPreferences);
		
		// recuperamos los campos de preferencias
		prefs = getSharedPreferences("mispreferences", Context.MODE_PRIVATE);
		txtUsuario.setText(prefs.getString("usuario", ""));
		txtCorreo.setText(prefs.getString("correo", ""));
		
		btnPreferences.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SharedPreferences.Editor editor = prefs.edit();
				editor.putString("usuario", txtUsuario.getText().toString());
				editor.putString("correo", txtCorreo.getText().toString());
				editor.commit();
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
