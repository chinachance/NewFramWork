package com.haohao.framwork.haoframwork.framwork;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.haohao.framwork.haoframwork.R;
import com.haohao.framwork.haoframwork.application.BaseApplication;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import androidx.appcompat.widget.Toolbar;

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
 * @date 2017/10/30
 * @description 基类activity
 */

public class BaseActivity extends RxAppCompatActivity implements IActivity {

    /**
     * 是否显示toolbar
     */
    private boolean mIsShowTitleBar;
    /**
     * 是否显示返回键
     */
    private boolean mIsShowBack;
    /**
     * 标题
     */
    private TextView mTitle;
    /**
     * toolbar
     */
    private Toolbar mToolBar;
    private ImmersionBar mImmersionBar;
    public ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        BaseApplication.getInstance().addActivity(this);
        //        sp = SharedPreferencesUtil.getInstance(this);
        if (mIsShowTitleBar) {
            initToolBar(mIsShowBack);
        }
        //初始化加载动画
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("正在加载...");
        mProgressDialog.setCanceledOnTouchOutside(false);
        initRequest();
    }

    /**
     * 是否显示toolbar(如果要显示toolbar一定要调用)
     *
     * @param showTitleBar
     */
    public void isShowToolBar(boolean showTitleBar,boolean showBack) {
        mIsShowTitleBar = showTitleBar;
        mIsShowBack = showBack;
        if (mIsShowTitleBar) {
            initToolBar(mIsShowBack);
        }
    }

    /**
     * 设置标题名
     *
     * @param title
     */
    private void showTitle(String title) {
        if (mTitle == null) {
            mTitle = (TextView) findViewById(R.id.tv_title);
        }
        if (title != null && !"".equals(title)) {
            mTitle.setText(title);
            mTitle.setVisibility(View.VISIBLE);
        } else {
            mTitle.setVisibility(View.GONE);
        }
    }


    /**
     * 初始化toolbar
     *
     * @param isShowBack 是否显示返回键
     */
    private void initToolBar(boolean isShowBack) {
        if (mToolBar == null) {
            mToolBar = (Toolbar) findViewById(R.id.tool_bar);
        }

        //把ToolBar设置上去
        setSupportActionBar(mToolBar);
        // 显示应用的Logo
        getSupportActionBar().setDisplayShowTitleEnabled(false);//是否显示title(为true会显示项目的label名称,下边的setTitle方法不生效;为false下边的setTitle方法生效)
        getSupportActionBar().setDisplayUseLogoEnabled(false);//是否显示logo

        if (isShowBack) {
            // 显示导航按钮(左侧侧滑抽屉按钮,现在为返回键)
            mToolBar.setNavigationIcon(R.mipmap.ic_btn_back);
            mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
    }


    /**
     * 显示无数据图
     *
     * @param
     * @param isShow
     */
    public void showNoDataView(boolean isShow) {

    }

    /**
     * 重写返回键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 判断用户是否点击了返回键
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 设置透明状态栏-固定状态栏
     *
     * @param black 状态栏字体是否为黑色
     */
    public void setStatusBarFixWindow(boolean black) {
        if (black) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                mImmersionBar = ImmersionBar.with(this);
                mImmersionBar.statusBarDarkFont(true)   //状态栏字体是深色，不写默认为亮色
                        //                .navigationBarColor(R.color.white) //导航栏颜色
                        //                .flymeOSStatusBarFontColor(R.color.share_view)  //修改flyme OS状态栏字体颜色
                        .fitsSystemWindows(true)
                        .init();
            }
        }else {
            mImmersionBar = ImmersionBar.with(this).fitsSystemWindows(true);
            mImmersionBar.init();
        }

    }

    /**
     * 设置透明状态栏-不固定状态栏(布局往上顶)
     * @param black 状态栏字体是否为黑色
     */
    public void setStatusBar(boolean black) {
        if (black) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                mImmersionBar = ImmersionBar.with(this);
                mImmersionBar.statusBarDarkFont(true)   //状态栏字体是深色，不写默认为亮色
                        //                .navigationBarColor(R.color.white) //导航栏颜色
                        //                .flymeOSStatusBarFontColor(R.color.share_view)  //修改flyme OS状态栏字体颜色
                        .init();
            }
        }else {
            mImmersionBar = ImmersionBar.with(this).fitsSystemWindows(false);
            mImmersionBar.init();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BaseApplication.getInstance().finishActivity(this);
        if (mImmersionBar != null) {
            mImmersionBar.destroy();  //必须调用该方法，防止内存泄漏，不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
        }
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    /**
     * 页面初始化时的网络请求
     */
    @Override
    public void initRequest() {
    }

    /**
     * 获取token
     */
    public void getToken(){

    }
}
