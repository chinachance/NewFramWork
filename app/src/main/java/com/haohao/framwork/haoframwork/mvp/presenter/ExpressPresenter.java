package com.haohao.framwork.haoframwork.mvp.presenter;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.haohao.framwork.haoframwork.mvp.bean.ExpressInfo;
import com.haohao.framwork.haoframwork.mvp.manager.DataManager;
import com.haohao.framwork.haoframwork.mvp.view.ExpressView;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

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
 * @description 例子presenter
 */

public class ExpressPresenter extends BasePresenter {

    private ExpressView expressView;
    private DataManager dataManager;

    public ExpressPresenter(ExpressView expressView, LifecycleProvider<ActivityEvent> provider) {
        super(provider);
        this.expressView = expressView;
        dataManager = DataManager.getInstance();
    }

    /**
     * 获取快递信息
     */
    public void getExpressInfo(Map<String, String> map) {
        expressView.showProgressDialog();

        //调用DataManger中的getExpressInfo方法,进行网络请求,拿到Observable<ExpressInfo>

        //第一种方式：传参以键值对的方式
        //        Observable<ExpressInfo> expressInfo = dataManager.getExpressInfo(map);
        //第二种方式：传参以json方式
        String json = new Gson().toJson(map);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), json);
        Observable<ExpressInfo> expressInfo = dataManager.getExpressInfo(requestBody);


        expressInfo.subscribeOn(Schedulers.io()) // 在子线程中进行Http访问
                .observeOn(AndroidSchedulers.mainThread()) // UI线程处理返回接口
                .compose(getProvider().<ExpressInfo>bindUntilEvent(ActivityEvent.DESTROY)) // onDestroy取消订阅
                .subscribe(new DefaultObserver<ExpressInfo>() {  // 订阅
                    @Override
                    public void onNext(@NonNull ExpressInfo expressInfo) {
                        expressView.updateView(expressInfo);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        expressView.showError(e.getMessage());
                        expressView.hideProgressDialog();
                    }

                    @Override
                    public void onComplete() {
                        expressView.hideProgressDialog();
                    }
                });
    }
}
