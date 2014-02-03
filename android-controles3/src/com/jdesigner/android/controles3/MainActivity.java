package com.jdesigner.android.controles3;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Capturamos los checkbox1 y programamos el marcado/desmarcado
		final CheckBox checkBox1 = (CheckBox)findViewById(R.id.checkBox1);
		checkBox1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked) {
					checkBox1.setText("Check marcado");
				} else {
					checkBox1.setText("Check desmarcado");
				}
				
			}
		});
		
		//Capturamos los checkbox2 y programamos el marcado/desmarcado
		final CheckBox checkBox2 = (CheckBox)findViewById(R.id.checkBox2);
		checkBox2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked) {
					checkBox2.setText("Check marcado");
				} else {
					checkBox2.setText("Check desmarcado");
				}
				
			}
		});
		
		//Capturamos el radiobutton y programamos el marcado del radiobutton
		final TextView textradiobutton = (TextView)findViewById(R.id.textRadioButton);
		final RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroup1);
		rg.clearCheck();
		rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				textradiobutton.setText("RadioButton marcado en posición " + checkedId+1);
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
