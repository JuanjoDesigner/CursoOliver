package com.jdesigner.android.basedatos1;

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
		// Lanzamos las sentecias de creación e inicialización de la BBDD
		db.execSQL("CREATE TABLE Usuarios( codigo INTEGER, nombre TEXT)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
		// Lanzamos las sentecias de modificación de estructura de la BBDD
		db.execSQL("DROP TABLE IF EXISTS Usuarios");

		db.execSQL("CREATE TABLE Usuarios( codigo INTEGER, nombre TEXT, email TEXT)");
	}

}
