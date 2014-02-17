package com.jdesigner.android.preferences2;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class OpcionesActivity extends PreferenceActivity {

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		addPreferencesFromResource(R.xml.opciones);
	}
}
