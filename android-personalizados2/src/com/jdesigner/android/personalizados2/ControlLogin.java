package com.jdesigner.android.personalizados2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ControlLogin extends LinearLayout {
	private EditText txtUsuario;
	private EditText txtClave;
	private Button btnLogin;
	private TextView lblMensaje;

	private OnLoginListener listener;

	public ControlLogin(Context context) {
		super(context);
		
		inicializar();
	}

	public ControlLogin(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		inicializar();
		
		// Procesamos los atributos XML personalizados
				TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.ControlLogin);

				String textoBoton = a.getString(R.styleable.ControlLogin_login_text);

				btnLogin.setText(textoBoton);

				a.recycle();
	}

	private void inicializar() {
		 //Utilizamos el layout 'control_login' como interfaz del control
	    String infService = Context.LAYOUT_INFLATER_SERVICE;
	    LayoutInflater li =
	        (LayoutInflater)getContext().getSystemService(infService);
	    li.inflate(R.layout.control_login, this, true);
	 
		//Capturamos los controles de los distintos elemento
	    txtUsuario = (EditText)findViewById(R.id.txtUsuario);
	    txtClave = (EditText)findViewById(R.id.txtClave);
	    btnLogin = (Button)findViewById(R.id.btnLogin);
	    lblMensaje = (TextView)findViewById(R.id.lblMensaje);

		//Asignamos los eventos necesario
		asignarEventos();
	}
	
	public void setOnLoginListener(OnLoginListener l) 
	{
		listener = l;
	}

	private void asignarEventos()
	{
		btnLogin.setOnClickListener(new OnClickListener() 
		{
			public void onClick(View v) {
				listener.onLogin(txtUsuario.getText().toString(), 
						         txtClave.getText().toString());
			}
		});
	}

	
	public void setMensaje(String msg)
	{
	    lblMensaje.setText(msg);
	}


}
