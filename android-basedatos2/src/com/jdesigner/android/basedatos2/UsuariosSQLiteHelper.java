package com.jdesigner.android.basedatos2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuariosSQLiteHelper extends SQLiteOpenHelper {

	public UsuariosSQLiteHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// Definimos las sentencias a ejecutar al crear la bbdd
		db.execSQL("CREATE TABLE Usuarios ( codigo INTEGER, nombre TEXT, email TEXT)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Definimos las sentencias a ejecutar al cambiar de versión de la bbdd
		db.execSQL("DROP TABLE IF EXISTS Usuarios");
		
		db.execSQL("CREATE TABLE Usuarios ( codigo INTEGER, nombre TEXT, email TEXT)");
	}

}
