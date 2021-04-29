package com.haohao.framwork.haoframwork.mvp.manager;

import com.haohao.framwork.haoframwork.mvp.bean.ExpressInfo;
import com.haohao.framwork.haoframwork.mvp.net.RetrofitHelper;
import com.haohao.framwork.haoframwork.mvp.net.RetrofitService;

import java.util.Map;

import io.reactivex.Observable;
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
 * @description 数据处理(初始化Retrofit,拿到RetrofitService,拿到接口地址,进行网络请求,返回Observable<javabean>)
 */

public class DataManager {

    private static DataManager dataManager;
    private RetrofitService retrofitService;

    public static DataManager getInstance() {
        return dataManager == null ? dataManager = new DataManager() : dataManager;
    }

    /**
     * 初始化Retrofit,拿到RetrofitService
     */
    private DataManager() {
        retrofitService = RetrofitHelper.getInstance().getRetrofitService();
    }


    /************下边开始进行网络请求,在各自的presenter中调用各自的下边的网络请求的方法,在presenter中拿到Observable<javabean>*****************/


    /**
     * 获取快递信息 -键值对方式
     * @return Observable<ExpressInfo>
     */
    public Observable<ExpressInfo> getExpressInfo(Map<String,String> map) {
        return retrofitService.getExpressInfoRx(map);
    }

    /**
     * 传参以 json方式
     * @param body
     * @return
     */
    public Observable<ExpressInfo> getExpressInfo(RequestBody body) {
        return retrofitService.getExpressInfoRx(body);
    }

}
