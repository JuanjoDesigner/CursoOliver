package com.jdesigner.android.thread;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ProgressBar pb;
	private Button bt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		pb = (ProgressBar) findViewById(R.id.progressBar);
		bt = (Button) findViewById(R.id.button);

		bt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pb.setMax(100);
				pb.setProgress(0);

				for (int i = 0; i < 10; i++) {
					tareaLarga();
					pb.incrementProgressBy(10);
				}
				
				Toast.makeText(getApplicationContext(), "Tarea finalizada", Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void tareaLarga() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
	}
}
