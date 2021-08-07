package com.haohao.framwork.haoframwork.mvp.net.gsonfactory

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonIOException
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.haohao.framwork.haoframwork.utils.HttpInterceptorUtil
import okhttp3.ResponseBody
import retrofit2.Converter
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets

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
 * @date 2021/5/24
 * @description
 */
public class MyGsonResponseBodyConverter<T> internal constructor(
        private val gson: Gson,
        private val adapter: TypeAdapter<T>
) :
        Converter<ResponseBody, T> {
    @Throws(IOException::class)
    override fun convert(value: ResponseBody): T {
        var jsonReader: JsonReader? = null
//        if (BuildConfig.DEBUG) {
//            jsonReader = gson.newJsonReader(value.charStream())
//        }else{
        //对返回数据进行解密
//            val string = value.string()
//            val decrypt = AES.getInstance().decrypt(string)
//            Log.e("hao", "convert(): $decrypt")
//            val contentType = value.contentType()
//            val charset =
//                if (contentType == null) contentType!!.charset(StandardCharsets.UTF_8) else StandardCharsets.UTF_8
//            val inputStream = ByteArrayInputStream(decrypt.toByteArray())
//            val reader = InputStreamReader(inputStream, charset)
//            jsonReader = gson.newJsonReader(reader)
//        }
        //

        try {
            //处理token失效和显示错误信息
            val string = value.string()
            val baseBean: BaseBean = Gson().fromJson<BaseBean>(string, BaseBean::class.java)
            val code = baseBean.code
            val errMsg = baseBean.errMsg
            if (!StringUtils.isEmpty(code) && code.startsWith("400")) {
                //token失效 code以400开头
                HttpInterceptorUtil.getInstance().showTokenDialog()
            }
            if (!StringUtils.isEmpty(errMsg)) {
                //网络请求报错 message不为空
                HttpInterceptorUtil.getInstance().showErrorToast(errMsg)
            }
            val contentType = value.contentType()
            val charset =
                    if (contentType == null) contentType!!.charset(StandardCharsets.UTF_8) else StandardCharsets.UTF_8
            val inputStream = ByteArrayInputStream(string.toByteArray())
            val reader = InputStreamReader(inputStream, charset)
            jsonReader = gson.newJsonReader(reader)
        } catch (e: Exception) {
            Log.e("hao", "MyGsonResponseBodyConverter: ${e.toString()}")
        }

        return try {
            val result = adapter.read(jsonReader)
            if (jsonReader?.peek() != JsonToken.END_DOCUMENT) {
                throw JsonIOException("JSON document was not fully consumed.")
            }
            result
        } finally {
            value.close()
        }
    }

}