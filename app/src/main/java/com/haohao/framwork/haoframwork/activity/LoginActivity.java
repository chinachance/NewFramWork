package com.haohao.framwork.haoframwork.activity;

import android.app.Activity;
import android.os.Bundle;

import com.haohao.framwork.haoframwork.R;
import com.haohao.framwork.haoframwork.application.BaseApplication;
import com.haohao.framwork.haoframwork.framwork.BaseActivity;
import com.haohao.framwork.haoframwork.framwork.BaseTextView;
import com.haohao.framwork.haoframwork.utils.HttpInterceptorUtil;

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
 * @date ${DATE}
 * @description 登录页
 */
public class LoginActivity extends BaseActivity {

    private BaseTextView tv_showdialog;
    private BaseTextView tv_dismissdialog;
    /**
     * 从token失效弹窗进来
     */
    private boolean isFromDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        isFromDialog = getIntent().getBooleanExtra("dialog", false);
        initView();
    }

    private void initView() {
        tv_showdialog = (BaseTextView) findViewById(R.id.tv_showdialog);
        tv_dismissdialog = (BaseTextView) findViewById(R.id.tv_dismissdialog);

        tv_showdialog.setOnClickListener(v->{

        });

        tv_dismissdialog.setOnClickListener(v->{
            //模拟登录成功
            //......数据持久化,存储token和用户数据

            //销毁页面
            if (isFromDialog) {
                fromTokenDialogLoginSuccess();
            }else {
                finish();
            }
        });
    }

    /**
     * token失效,重新登录成功
     */
    private void fromTokenDialogLoginSuccess(){
        HttpInterceptorUtil.getInstance().dismissTokenDialog();
        BaseApplication application = BaseApplication.getInstance();
        ArrayList<Activity> activityStack = application.getActivityStack();
        if (activityStack != null && activityStack.size() > 1) {
            BaseActivity activity = (BaseActivity)activityStack.get(activityStack.size() - 2);
            activity.initRequest();
        }
        finish();
    }
}