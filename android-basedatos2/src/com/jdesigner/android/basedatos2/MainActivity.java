package com.jdesigner.android.basedatos2;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private EditText txtCodigo;
	private EditText txtNombre;
	private TextView txtConsulta;
	
	private Button btnInsert;
	private Button btnUpdate;
	private Button btnDelete;
	private Button btnConsulta;

	private SQLiteDatabase db;

	private ContentValues valores = new ContentValues();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Capturamos los controles de pantalla
		txtCodigo = (EditText)findViewById(R.id.txtCodigo);
		txtNombre = (EditText)findViewById(R.id.txtNombre);
		txtConsulta = (TextView)findViewById(R.id.txtConsulta);
		btnInsert = (Button)findViewById(R.id.btnInsert);
		btnUpdate = (Button)findViewById(R.id.btnUpdate);
		btnDelete = (Button)findViewById(R.id.btnDelete);
		btnConsulta = (Button)findViewById(R.id.btnConsulta);

		// Abrimos la bbdd "Usuarios" en modo escritura
		UsuariosSQLiteHelper usudb = new UsuariosSQLiteHelper(this, "Usuarios", null, 1);
		db = usudb.getWritableDatabase();
		
		// Si no abrimos la bbdd seshabilitamos los botones
		if (db == null) {
			btnInsert.setEnabled(false);
			btnUpdate.setEnabled(false);
			btnDelete.setEnabled(false);
		}
		
		// Implementamos la inserción de datos
		btnInsert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				valores.clear();
				valores.put("codigo", txtCodigo.getText().toString());
				valores.put("nombre", txtNombre.getText().toString());
				if (db.insert("Usuarios", null, valores) < 0) {
					Log.e("BBDD", "Error insertando en la bbdd");
				};
			}
		});
		
		// Implementamos la modificación de datos
		btnUpdate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				valores.clear();
				valores.put("nombre", txtNombre.getText().toString());
				String[] args = new String[] {txtCodigo.getText().toString()};
				if (db.update("Usuarios", valores, "codigo=?", args) < 0) {
					Log.e("BBDD", "Error modificando en la bbdd");
				};
			}
		});

		// Implementamos el borrado de datos
		btnDelete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String[] args = new String[] {txtCodigo.getText().toString()};
				if (db.delete("Usuarios", "codigo=?", args) < 0) {
					Log.e("BBDD", "Error borrando en la bbdd");
				}
			}
		});
		
		// Implementamos la consulta de la bbdd
		btnConsulta.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Cargamos el resultado de la query a un cursos
				Cursor c = db.rawQuery("SELECT Codigo, Nombre FROM Usuarios",  null );
				
				// si hay registros visualizamos la información de cada uno de ellos
				if (c.moveToFirst()) {
					txtConsulta.setText("");
					do {
						txtConsulta.append(c.getString(0) + " - " + c.getString(1) + "\n");
					} while (c.moveToNext());
				} else {
					txtConsulta.setText("\nTabla vacia");
				}
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
