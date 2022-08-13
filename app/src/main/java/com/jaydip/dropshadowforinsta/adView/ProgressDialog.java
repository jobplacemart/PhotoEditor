package com.jaydip.dropshadowforinsta.adView;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;

import com.jaydip.dropshadowforinsta.R;

public class ProgressDialog {
    public static Dialog show(Context context) {
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.getWindow().addFlags(2);
        dialog.setCancelable(false);
        dialog.getWindow().setDimAmount(0.7f);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(R.layout.dialog_progress);
        try {
            if (!((Activity) context).isFinishing()) {
                dialog.show();
            }
        } catch (Exception unused) {
        }
        return dialog;
    }
}
