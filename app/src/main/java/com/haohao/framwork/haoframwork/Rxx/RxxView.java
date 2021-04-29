package com.haohao.framwork.haoframwork.Rxx;

import android.view.View;

import com.jakewharton.rxbinding.internal.Preconditions;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

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
 * @date 2018/10/08
 * @description 防止多次点击
 */
public class RxxView {

    public static<T extends View> Observable<T> clicks(T view){
        Preconditions.checkNotNull(view, "view == null");
        return (Observable<T>) Observable.create(new ViewClickOnSubscribe(view)).throttleFirst(2000, TimeUnit
                .MILLISECONDS, AndroidSchedulers.mainThread());
    }
}
