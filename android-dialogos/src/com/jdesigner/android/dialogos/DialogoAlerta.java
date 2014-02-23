package com.jdesigner.android.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class DialogoAlerta extends DialogFragment {

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Definición de un dialogo de simple de alerta
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

		builder.setMessage("Esto es un mensaje de alerta.")
				.setTitle("Información")
				.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});

		return builder.create();
	}

}
