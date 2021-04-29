# 使用说明

[TOC]

## MVP框架的使用

* 在bean包中创建类,继承BaseBean.

* 在view包中创建接口,继承BaseView,这是activity的回调.

* 在net包中的Constant类中添加请求地址.

* 在net包中的RetrofitService中添加请求

* 在manger包中的DataManager类中添加请求的方法.

* 在presenter包中新建类继承BasePresenter,调用DataManger中的getExpressInfo方法,进行网络请求.

* activity中传参,通过presenter进行请求,实现接口方法,在里边拿到数据.

  ### 修改了网络请求中日志拦截器中的错误提示和token失效弹窗

  

