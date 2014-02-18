package com.jdesigner.android.basedatos1;

import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Abrimos nuestra BBDD "DBUsuarios" en modo escritura
		UsuariosSQLiteHelper usdb = new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);
		SQLiteDatabase db = usdb.getWritableDatabase();
		
		// Verificamos si hemos abierto la BBDD
		if(db != null) {
			// creamos un buche para insertar 10 registros
			for (int i = 0; i < 10; i++) {
				db.execSQL("INSERT INTO Usuarios VALUES (" + i + ", 'Usuario" + i + "')");
			}
			
			// Cerramos la BBDD
			db.close();
		} else {
			Log.e("BBDD", "Error al abrir la bbdd DBUsuarios");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
