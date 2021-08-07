package com.haohao.framwork.haoframwork.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.widget.Toast;

import com.haohao.framwork.haoframwork.activity.LoginActivity;
import com.haohao.framwork.haoframwork.application.BaseApplication;

import java.util.ArrayList;

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
 * @date 2021/4/29
 * @description 拦截器工具类
 */

public class HttpInterceptorUtil {
    private static HttpInterceptorUtil mInterceptorUtil;
    private Dialog mTokenDialog;
    private long exitTime;

    public static HttpInterceptorUtil getInstance() {
        return mInterceptorUtil == null ? mInterceptorUtil = new HttpInterceptorUtil() : mInterceptorUtil;
    }

    /**
     * 显示token失效弹窗
     */
    public void showTokenDialog() {
        if (mTokenDialog != null && mTokenDialog.isShowing()) {
            return;
        }
        ArrayList<Activity> activityStack = BaseApplication.getInstance().getActivityStack();
        Activity activity = activityStack.get(activityStack.size() - 1);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTokenDialog = DialogUtil.showDialog(activity, "请登录", false,
                        new DialogUtil.OnClickListener() {
                            @Override
                            public void onClickConfirm() {
                                //跳转到登录页
                                activity.startActivity(new Intent(activity, LoginActivity.class)
                                        .putExtra("dialog", true));
                            }

                            @Override
                            public void onClickCancel() {
                                //销毁页面
                                mTokenDialog.dismiss();
                                BaseApplication.getInstance().finishActivity(activity);
                            }
                        });
            }
        });
    }

    /**
     * token失效弹框消失
     */
    public void dismissTokenDialog() {
        if (mTokenDialog != null && mTokenDialog.isShowing()) {
            mTokenDialog.dismiss();
        }
    }

    /**
     * 显示错误信息toast
     *
     * @param msg
     */
    public void showErrorToast(String msg) {
        ArrayList<Activity> activityStack = BaseApplication.getInstance().getActivityStack();
        Activity activity = activityStack.get(activityStack.size() - 1);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if ((System.currentTimeMillis() - exitTime) > 1000 * 30) {
                    Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
                }
                exitTime = System.currentTimeMillis();
            }
        });
    }
}
