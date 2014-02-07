package com.jdesigner.android.tabs;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.util.Log;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Resources res = getResources();
		TabHost tabs = (TabHost)findViewById(android.R.id.tabhost);
		tabs.setup();
		
		TabHost.TabSpec spec = tabs.newTabSpec("tab1");
		spec.setContent(R.id.tab1);
		spec.setIndicator("", res.getDrawable(android.R.drawable.ic_btn_speak_now));
		tabs.addTab(spec);
		
		spec = tabs.newTabSpec("tab2");
		spec.setContent(R.id.tab2);
		spec.setIndicator("", res.getDrawable(android.R.drawable.ic_dialog_map));
		tabs.addTab(spec);
		
		spec = tabs.newTabSpec("tab3");
		spec.setContent(R.id.tab3);
		spec.setIndicator("", res.getDrawable(android.R.drawable.ic_lock_idle_alarm));
		tabs.addTab(spec);
		
		tabs.setCurrentTab(0);
		
		tabs.setOnTabChangedListener(new OnTabChangeListener() {
			
			@Override
			public void onTabChanged(String tabId) {
				Log.i("AndroidTabsDemo", "Pulsada pestaña: " + tabId);
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
