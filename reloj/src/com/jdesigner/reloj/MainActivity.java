package com.jdesigner.reloj;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	private int hora;
	private int min;
	private int seg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Capturamos el control de los EditText y del Button
		final EditText txtHora = (EditText)findViewById(R.id.txtHora);
		final EditText txtMinuto = (EditText)findViewById(R.id.txtMinuto);
		final EditText txtSegundo = (EditText)findViewById(R.id.txtSegundo);
		final Button btnValidar = (Button)findViewById(R.id.btnValidar);
		final Button btnReset = (Button)findViewById(R.id.btnReset);
		final TextView txtSalida = (TextView)findViewById(R.id.txtSalida);
		final TextView txtMensaje = (TextView)findViewById(R.id.txtMensaje);
		
		// Programamos el click del button
		btnValidar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if((txtHora.getText().length() == 0) || (txtMinuto.getText().length() == 0) || (txtSegundo.getText().length() == 0)) {
					// Si algún campo esta vacio, presentamos error
					txtSalida.setText("00:00:00");
					txtMensaje.setText("Hora, Minuto y Segundo son datos obligatorios");
				} else {
					// Si los campos son correctos, preparamos la salida
					hora = Integer.parseInt(txtHora.getText().toString());
					min  = Integer.parseInt(txtMinuto.getText().toString());
					seg  = Integer.parseInt(txtSegundo.getText().toString());
					
					// calculamos la hora
					min += seg / 60;
					seg = seg % 60;
					hora += min / 60;
					min = min % 60;
					
					// Presentamos la hora formateada
					txtSalida.setText(String.format("%02d:%02d:%02d", hora, min, seg));
					txtMensaje.setText("");
				}
			}
		});
		
		btnReset.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				txtHora.requestFocus();
				txtHora.setText("");
				txtMinuto.setText("");
				txtSegundo.setText("");
				txtSalida.setText("00:00:00");
				txtMensaje.setText("");
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
