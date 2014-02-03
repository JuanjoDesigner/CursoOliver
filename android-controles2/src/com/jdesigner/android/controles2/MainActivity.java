package com.jdesigner.android.controles2;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.text.Editable;
import android.text.Spannable;
import android.text.style.StyleSpan;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Capturamos la etiqueta de texto para añadirle texto1
		final TextView lbltexto1 = (TextView)findViewById(R.id.lblTexto1);
		String texto = lbltexto1.getText().toString();
		texto += 123;
		lbltexto1.setText(texto);
		lbltexto1.setBackgroundColor(Color.BLUE);
		
		//Creamos un nuevo objeto de tipo Editable y marcamos 
		//cono fuente negrita la palabra "simulacro" (caracteres del 11-19)
		Editable str = Editable.Factory.getInstance().newEditable("Esto es un simulacro.");
		str.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 11, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		//Capturamos la etiqueta de texto2
		final TextView lbltexto2 = (TextView)findViewById(R.id.lblTexto2);
		lbltexto2.setText(str);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
