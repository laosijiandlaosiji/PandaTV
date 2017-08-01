package com.example.administrator.pandatv.widget.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;

import com.example.administrator.pandatv.R;

/**
 * Created by Administrator on 2017/7/31.
 */

public class CustomDialog extends Dialog {
    private static Dialog dialog;
    public CustomDialog(Context context) {
        super(context);
    }

    public CustomDialog(Context context, int themeResId) {
        super(context, themeResId);
    }
    public static void show(Context context){

        dialog = new CustomDialog(context, R.style.CustomDialog);

        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(R.layout.dialog_item);
        dialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        dialog.show();


    }

    public static void dimiss(){
        dialog.dismiss();
    }
}
