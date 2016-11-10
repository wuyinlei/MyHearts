# 简介

高仿某app，数据抓取获得，持续更新中：
###界面展示：
####登录界面：
![](http://ww1.sinaimg.cn/mw690/006jcGvzgw1f93rpi0f08j30u01hcdq2.jpg)
####首页：
![](http://ww1.sinaimg.cn/mw690/006jcGvzgw1f93qitz86tj30u01hc7gz.jpg )
####咨询界面：
![](http://ww2.sinaimg.cn/mw690/006jcGvzgw1f93qjhw5oej30u01hcn5k.jpg)

####类似qq空间界面：
![](http://ww4.sinaimg.cn/mw690/006jcGvzgw1f93q1fk34yj30u01hcdoc.jpg)
####用户详情界面：
![](http://ww1.sinaimg.cn/mw690/006jcGvzgw1f93qjt01kqj30u01hcqb4.jpg)

数据都是抓取得到的，在这里只是用于学习，展示数据，禁止用于商业。如有违规地方，请指出删除，谢谢合作。


----------
 用到的开源项目：
```
 网络请求框架
  //网络框架
    compile 'com.lzy.net:okgo:2.0.0'
    //可以单独使用，不需要依赖下方的扩展包
    compile 'com.lzy.net:okrx:0.1.0'
    //RxJava扩展支持，根据需要添加
    compile 'com.lzy.net:okserver:1.1.0'
    //下载管理和上传管理扩展，根据需要添加
    compile 'com.lzy.net:okrx:0.1.0'
```

```
跑马灯
//跑马灯
    compile 'com.sunfusheng:marqueeview:1.1.0'
```

```
上拉加载，下拉刷新控件
compile 'com.cjj.materialrefeshlayout:library:1.3.0'
```

```
类似于QQ空间图片展示
compile 'com.lzy.widget:ninegridview:0.2.0'
```

```
滑动改变状态栏
compile 'com.github.ksoichiro:android-observablescrollview:1.5.0'
```

```
数据解析
compile 'com.google.code.gson:gson:2.7'
```

```
//图片加载
compile 'com.github.bumptech.glide:glide:3.7.0'
```
在此在此感谢以上开源框架以及他们的作者。没有他们的开源，也不能这么快的实现这个app，由于时间冲突(5天不到),还是存在着bug，后期会进行更新和优化。


####后面如果有时间，会对其进行分析(应该没吧。。。)

###2016-10-26日更新
* 1、集成QQ登录完成
* 2、注册登录实现（利用Bmob作为后台，mob的短信验证）

###2016-10-27日更新
* 1、用户详情界面
* 2、更新用户信息界面

###最新更新
* 1、加入朋友圈详情
* 2、加入视频url，可以播放往期视频
* 3、加入修改密码功能(仅限于注册用户)

#####图展示
![](http://ww2.sinaimg.cn/mw690/006jcGvzgw1f97047vblrj30u01hck1r.jpg)
![](http://ww1.sinaimg.cn/mw690/006jcGvzgw1f9705oy34aj30u01hcq5r.jpg)
![](http://ww2.sinaimg.cn/mw690/006jcGvzgw1f9705xndnoj30u01hc777.jpg)
![](http://ww3.sinaimg.cn/mw690/006jcGvzgw1f9706446j4j30u01hcadr.jpg)

#####更新图展示
![](http://ww3.sinaimg.cn/mw690/006jcGvzgw1f9msfmfr8lj30u01hc7ir.jpg)
![](http://ww4.sinaimg.cn/mw690/006jcGvzgw1f9msg8rk5oj30u01hcn2p.jpg)
![](http://ww1.sinaimg.cn/mw690/006jcGvzgw1f9msir6iboj30u01hc7hz.jpg)
![](http://ww1.sinaimg.cn/mw690/006jcGvzgw1f9msj02pkuj30u01hc43w.jpg)
![](http://ww4.sinaimg.cn/mw690/006jcGvzgw1f9msj7ye24j30u01hcdus.jpg)
![](http://ww1.sinaimg.cn/mw690/006jcGvzgw1f9msjgoqhlj30u01hctgw.jpg)

###如何运行此项目(确保google依赖库是同一个版本的，)
* 第一步：下载此项目的zip包到本地，并进行解压
* 第二步：进入app目录(此时可以看到src和其他文件夹)，复制这个路径地址
* 第三步：打开AS，新建一个功能(Project)，然后File-->New-->Import Module ，把路径复制进入到输入框，点击确定即可。
* 注意：由于项目中使用了lambda表达式，确保sdk版本在24及以上

###MyHearts交流群（刚开，哈哈）
群号：136471108（进群交流技术，本人技术也不是很好，但是我相信，大家一起交流，会有很好的提升）



