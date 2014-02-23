package com.jdesigner.android.notificaciones;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// capturar el control y programar el click del botón
		Button btnTitulo = (Button) findViewById(R.id.btnTitulo);

		btnTitulo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// configurar el elemento notificación
				NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
						MainActivity.this)
						.setSmallIcon(android.R.drawable.stat_sys_warning)
						.setLargeIcon(
								(((BitmapDrawable) getResources().getDrawable(
										R.drawable.ic_launcher)).getBitmap()))
						.setContentTitle("Mensaje de Alerta")
						.setContentText("Ejemplo de notificación.")
						.setContentInfo("4").setTicker("Alerta!");

				// definir la actividad a ejecutar desde la notificación
				Intent notIntent = new Intent(MainActivity.this,
						MainActivity.class);

				PendingIntent contIntent = PendingIntent.getActivity(
						MainActivity.this, 0, notIntent, 0);

				mBuilder.setContentIntent(contIntent);

				// lanzar la notificación
				NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				mNotificationManager.notify(0, mBuilder.build());
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
