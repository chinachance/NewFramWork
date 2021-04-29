package com.haohao.framwork.haoframwork.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.haohao.framwork.haoframwork.R;
import com.haohao.framwork.haoframwork.Rxx.RxxView;

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃  神兽保佑
 * 　　　　┃　　　┃  代码无bug
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 *
 * @author hao
 * @date 2018/12/15
 * @description
 */
public class DialogUtil {

    /**
     * 显示常规弹窗
     * @param context
     * @param des 弹窗描述内容
     * @param isDismiss 是否点击确认弹窗消失
     * @param listener 点击确认回调
     * @return
     */
    public static Dialog showCustomDialog(Context context, String des, boolean isDismiss, OnCustomClickListener listener) {

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_delete, null);
        TextView tv_dialog_ident_name = (TextView) view.findViewById(R.id.tv_dialog_ident_name);
        TextView tv_cancel = (TextView) view.findViewById(R.id.tv_cancel);
        TextView tv_confirm = (TextView) view.findViewById(R.id.tv_confirm);
        ImageView iv_dialog_shut = (ImageView) view.findViewById(R.id.iv_dialog_shut);

        tv_dialog_ident_name.setText(des);

        Dialog dialog = new Dialog(context, R.style.ActionSheetDialogStyle);
        Window window = dialog.getWindow();
        window.setContentView(view);
        window.setGravity(Gravity.CENTER);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.setCanceledOnTouchOutside(false);

        RxxView.clicks(iv_dialog_shut).subscribe(v -> {
            dialog.dismiss();
        });

        RxxView.clicks(tv_cancel).subscribe(v -> {
            dialog.dismiss();
        });

        RxxView.clicks(tv_confirm).subscribe(v -> {
            listener.onClick();
            if (isDismiss) {
                dialog.dismiss();
            }
        });

        dialog.show();
        return dialog;
    }

    /**
     * 显示弹窗
     * @param context
     * @param des 弹窗描述内容
     * @param isDismiss 是否点击确认或者取消时弹窗消失
     * @param listener 点击确认和取消回调
     * @return
     */
    public static Dialog showDialog(Context context, String des, boolean isDismiss
            , OnClickListener listener) {

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_delete, null);
        TextView tv_dialog_ident_name = (TextView) view.findViewById(R.id.tv_dialog_ident_name);
        TextView tv_cancel = (TextView) view.findViewById(R.id.tv_cancel);
        TextView tv_confirm = (TextView) view.findViewById(R.id.tv_confirm);
        ImageView iv_dialog_shut = (ImageView) view.findViewById(R.id.iv_dialog_shut);

        tv_dialog_ident_name.setText(des);

        Dialog dialog = new Dialog(context, R.style.ActionSheetDialogStyle);
        Window window = dialog.getWindow();
        window.setContentView(view);
        window.setGravity(Gravity.CENTER);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.setCanceledOnTouchOutside(false);

        RxxView.clicks(iv_dialog_shut).subscribe(v -> {
            listener.onClickCancel();
            if (isDismiss) {
                dialog.dismiss();
            }
        });

        RxxView.clicks(tv_cancel).subscribe(v -> {
            listener.onClickCancel();
            if (isDismiss) {
                dialog.dismiss();
            }
        });

        RxxView.clicks(tv_confirm).subscribe(v -> {
            listener.onClickConfirm();
            if (isDismiss) {
                dialog.dismiss();
            }
        });

        dialog.show();
        return dialog;
    }

    public interface OnCustomClickListener {
        void onClick();
    }

    public interface OnClickListener {
        void onClickConfirm();
        void onClickCancel();
    }
}
