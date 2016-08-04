package com.android.githubretrofit.util;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;


public class Dialogs {

  private static final Dialogs instance = new Dialogs();
  private DialogInterface.OnClickListener onClickListener;

  private Dialogs() {
  }

  public static Dialogs newInstance() {
    return instance;
  }

  public void showAlertDialog(Context context, String title, String message) {
    AlertDialog.Builder dialog = new AlertDialog.Builder(context);
      dialog.setTitle(title);
      dialog.setMessage(message);
      dialog.setIcon(android.R.drawable.ic_dialog_alert);
      dialog.setPositiveButton(android.R.string.ok, onClickListener);
      dialog.show();
  }

  public Dialogs setOnClickListener(DialogInterface.OnClickListener onClickListener) {
    this.onClickListener = onClickListener;
    return this;
  }

}
