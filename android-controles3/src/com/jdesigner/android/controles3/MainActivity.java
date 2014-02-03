package com.jdesigner.android.controles3;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Capturamos los checkbox y escribimos estado
		final CheckBox checkBox1 = (CheckBox)findViewById(R.id.checkBox1);
		final CheckBox checkBox2 = (CheckBox)findViewById(R.id.checkBox2);
		final TextView txtEstado = (TextView)findViewById(R.id.txtEstado);
		
		if(checkBox1.isChecked()) {
			if(checkBox2.isChecked()) {
				txtEstado.setText("Ambos check marcados");
			} else {
				txtEstado.setText("Primer check marcado");
			}
		} else {
			if(checkBox2.isChecked()) {
				txtEstado.setText("Segundo check marcado");
			} else {
				txtEstado.setText("Ningún Check marcado");
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
