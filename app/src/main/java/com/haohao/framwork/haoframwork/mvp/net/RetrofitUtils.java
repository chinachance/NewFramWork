package com.haohao.framwork.haoframwork.mvp.net;

import android.util.Log;

import com.google.gson.Gson;
import com.haohao.framwork.haoframwork.mvp.bean.BaseBean;
import com.haohao.framwork.haoframwork.utils.EncodeUtils;
import com.haohao.framwork.haoframwork.utils.HttpInterceptorUtil;
import com.haohao.framwork.haoframwork.utils.StringUtil;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

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
 * @description 打印请求参数
 */

public class RetrofitUtils {

    /**
     * 获取OkHttpClient
     * 用于打印请求参数
     *
     * @return OkHttpClient
     */
    public static OkHttpClient getOkHttpClient() {

        final Boolean isShowLog = true;

        // 日志显示级别
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        // 新建log拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                if (isShowLog) {
                    try {
                        Log.i("http请求参数：", EncodeUtils.urlDecode(message));
                    } catch (Exception e) {
                        Log.i("http请求参数：", message);
                    }
                    //处理token失效和显示错误信息
                    if (message.contains("MEMBER_TOKEN_INVALID_ERROR")) {
                        //token失效
                        HttpInterceptorUtil.getInstance().showTokenDialog();
                    }else if (message.contains("errorDescription")) {
                        //网络请求报错
                        BaseBean baseBean = new Gson().fromJson(message, BaseBean.class);
                        String errorDescription = baseBean.getErrorDescription();
                        if (!StringUtil.isEmpty(errorDescription)) {
                            HttpInterceptorUtil.getInstance().showErrorToast(errorDescription);
                        }
                    }
                }
            }
        });
        loggingInterceptor.setLevel(level);
        // 定制OkHttp
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        // OkHttp进行添加拦截器loggingInterceptor
        httpClientBuilder.addInterceptor(loggingInterceptor);
        return httpClientBuilder.build();
    }
}
