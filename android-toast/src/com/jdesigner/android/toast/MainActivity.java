package com.jdesigner.android.toast;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Capturamos el controlador de los botones
		Button btnToast1 = (Button) findViewById(R.id.btnToast1);
		Button btnToast2 = (Button) findViewById(R.id.btnToast2);
		Button btnToast3 = (Button) findViewById(R.id.btnToast3);

		// Programamos los click de los botones
		btnToast1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast toast1 = Toast.makeText(getApplicationContext(),
						"Prueba de mensaje emergente por defecto", Toast.LENGTH_SHORT);
				toast1.show();
			}
		});
		
		btnToast2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast toast2 = Toast.makeText(getApplicationContext(), "Prueba de mensaje emergente Gravity", Toast.LENGTH_LONG);
				toast2.setGravity(Gravity.CENTER|Gravity.LEFT, 0, 0);
				toast2.show();
			}
		});
		
		btnToast3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast toast3 = new Toast(getApplicationContext());
				
				LayoutInflater inflater = getLayoutInflater();
				View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup)findViewById(R.id.LinearLayout2));
				TextView txtTexto = (TextView)layout.findViewById(R.id.txtTexto);
				txtTexto.setText("Prueba de mensaje emergente personalizado");
				
				toast3.setView(layout);
				toast3.setDuration(Toast.LENGTH_LONG);
				toast3.show();
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
