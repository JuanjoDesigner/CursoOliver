package com.jdesigner.android.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;

public class DialogoSeleccion extends DialogFragment {
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		final String[] items = { "Espa�ol", "Ingl�s", "Franc�s" };

		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

		builder.setTitle("Selecci�n").setItems(items,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int item) {
						Log.i("Dialogos", "Opci�n elegida: " + items[item]);
					}
				});

		return builder.create();
	}
}
