package com.jdesigner.android.personalizados2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {
	private ControlLogin ctlLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ctlLogin = (ControlLogin)findViewById(R.id.ctlLogin);
		 
	    ctlLogin.setOnLoginListener(new OnLoginListener()
	    {
	    @Override
	    public void onLogin(String usuario, String password)
	    {
	        //Validamos el usuario y la contraseña
	        if (usuario.equals("demo") && password.equals("demo"))
	            ctlLogin.setMensaje("Login correcto!");
	        else
	            ctlLogin.setMensaje("Vuelva a intentarlo.");
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
