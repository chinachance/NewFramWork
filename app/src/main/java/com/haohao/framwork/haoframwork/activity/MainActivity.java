package com.haohao.framwork.haoframwork.activity;

import android.Manifest;
import android.os.Bundle;
import android.widget.TextView;

import com.haohao.framwork.haoframwork.R;
import com.haohao.framwork.haoframwork.framwork.BaseActivity;
import com.haohao.framwork.haoframwork.utils.HttpInterceptorUtil;
import com.vondear.rxtool.RxPermissionsTool;

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
 * @description
 */

public class MainActivity extends BaseActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initPermission();
    }

    private void initPermission() {
        RxPermissionsTool.with(this)
                .addPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .addPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .addPermission(Manifest.permission.CAMERA)
                .addPermission(Manifest.permission.READ_PHONE_STATE)
                .addPermission(Manifest.permission.ACCESS_WIFI_STATE)
                .addPermission(Manifest.permission.CHANGE_WIFI_STATE)
                .addPermission(Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS)
                .addPermission(Manifest.permission.READ_CONTACTS)
                .addPermission(Manifest.permission.WRITE_CONTACTS)
                .addPermission(Manifest.permission.RECORD_AUDIO)
                .initPermission();
    }

    private void initView() {
        tv = (TextView) findViewById(R.id.tv);
        tv.setOnClickListener(v -> {
//            startActivity(new Intent(this, OpenGlActivity.class));
            HttpInterceptorUtil.getInstance().showTokenDialog();
        });
    }

    /**
     * 页面初始化时的网络请求
     */
    @Override
    public void initRequest() {
        super.initRequest();
    }
}
