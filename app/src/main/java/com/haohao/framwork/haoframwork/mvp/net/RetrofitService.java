package com.haohao.framwork.haoframwork.mvp.net;


import com.haohao.framwork.haoframwork.mvp.bean.ExpressInfo;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

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

public interface RetrofitService {

    /**
     * 获取快递信息-键值对方式
     * Rx方式
     * @return Observable<ExpressInfo>
     */
    @GET(Constant.UrlOrigin.get_express_info)
    Observable<ExpressInfo> getExpressInfoRx(@QueryMap Map<String, String> map);

    /**
     * 另外一种方式，json方式放到请求体里
     * @param body
     * @return
     */
    @Headers({"Content-Type: application/json", "Accept:application/json"})
    @POST(Constant.UrlOrigin.get_express_info)
    Observable<ExpressInfo> getExpressInfoRx(@Body RequestBody body);
}
