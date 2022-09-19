[![GitHub Versions](https://github.com/jedisct1/libsodium/workflows/CI/badge.svg)](https://github.com/1079374315/GSLS_Tool/tags)
[![CSDN](https://img.shields.io/badge/Android%20Arsenal-Fragmentation-brightgreen.svg?style=flat)](https://blog.csdn.net/qq_39799899)
[![Github](https://travis-ci.org/YoKeyword/Fragmentation.svg?branch=master)](https://github.com/1079374315)
[![](https://jitpack.io/v/1079374315/GSLS_Tool.svg)](https://jitpack.io/#1079374315/GSLS_Tool)

<img src="https://csdnimg.cn/medal/linkedin@240.png"  width="40px"><img src="https://csdnimg.cn/medal/github@240.png"  width="40px"><img src="https://csdnimg.cn/medal/maimai@240.png"  width="40px"><img src="https://csdnimg.cn/medal/qiandao10@240.png"  width="40px"><img src="https://csdnimg.cn/medal/yuedu3@240.png"  width="40px"><img src="https://csdnimg.cn/medal/chizhiyiheng@240.png"  width="40px"><img src="https://csdnimg.cn/medal/1024@240.png"  width="40px"><img src="https://csdnimg.cn/medal/qixiebiaobing4@240.png"  width="40px"><img src="https://csdnimg.cn/medal/yuanli_xuexili@240.png"  width="40px"><img src="https://csdnimg.cn/medal/yuanli_xinren@240.png"  width="40px"><img src="https://csdnimg.cn/medal/yuanli_tansuoS@240.png"  width="40px"><img src="https://csdnimg.cn/medal/fenxiangjingying@240.png"  width="40px">

# <a href="https://blog.csdn.net/qq_39799899"><img src="http://gsls.3vfree.cn/Servers/img/GT/logo.png"  width="200px"></a>[GT库源码](https://github.com/1079374315/GSLS_Tool)
#### ============[关注我，查找更简单(*￣︶￣)](https://github.com/1079374315/GSLS_Tool)

#### [gt-DataBinding-v1.0.7-更新详情](http://gsls.3vfree.cn/Servers/index.html)

# 最新版本: v1.4.2.2
发布时间：2022.9.19

# 此次版本更新：
````
/**
 * CSDN 博客/官网教程:https://blog.csdn.net/qq_39799899
 * GitHub https://github.com/1079374315/GT
 * 新增 MVC、MVP、MVVM (辅助框架)、
 * GT.EventBus (数据传递)框架、
 * Observable (异步框架）、
 * HttpCall (网络请求框架)、
 * Glide (图片加载框架，支持三级缓存)
 * 内容如下：
 * 1.新增 GT_PopupWindow 类
 * 2.LOG 类新增 GT.logt("标记日志"); GT.errt("标记日志");
 * 3.优化 时间与时间戳互转的方法
 * 4.新增 编程辅助框架 MVC/MVP/MVVM/GT/GT_Binding模式
 * 5.增强 AnnotationAssist 反射、注解工具类
 * 6.增强分享功能
 * 7.优化所有的 DataBinding自动生成类 ，增强 GT_BindingViewModel 并支持 通过泛类映射实例化 ，增加了 适配器的 DataBinding
 * 8.增加 WebViewUtils 类
 * 9.GT.Thread 增加线程池管理功能
 * 10.新增 GT.EventBus 类，具体使用教程清参考官网教程
 * 11.新增异步操作的框架 Observable 具体使用教程清参考官网
 * 12.增加 GT_Cache GT内部缓存类 （随时随地从缓存里拿对象使用）
 * 目前支持:GT_SharedPreferences、Hibernate、GT_Fragment、HttpCall、SerialPortUtils、GT_Socket.TCP
 * 13.去掉 OkGo 与 OkHttp 的封装类，增加 HttpCall 网络请求框架(支持网络请求与文件下载上传) ,具体使用教程清参考官网
 * 14.新增图片加载类 GT.Glide 使用方法类似于 Glide框架  GT.Glide.with(MainActivity.this).load(url).into(imageView);
 * 支持功能：
 * (1).加载图片的类型非常丰富
 * (2).支持三级缓存,可设置是否缓存
 * (3).占位图（图片完成前的图）
 * (4).异常图（图片加载异常的）
 * (5).高斯模糊(如：.blurTransformation(5))
 * (6).GIF(可使用 GTImageView 组件 来实现圆角动态图)
 * (6).支持圆角图片(.roundedCorners(30,0,30,90))
 * (6).指定图片大小(与设置缩略图同一个 api 方法)
 * 16.将 Permission 权限申请类 转移到 AppAuthorityManagement 类中
 * 17.新增 StrColor 类，动态设置文字颜色
 * 18. Observable 异步线程操作，让你的业务流程，干净又清爽
 * 19.新增 ImageViewTools 强大的图片工具包
 * 20.新增 GTImageView 加载图片组件,可以圆角动态图
 * 21.新增 NeverCrash 类，防止APP奔溃类，APP产生奔溃后，会捕获，并将异常手机信息与异常原因发送出来
 * 22.所有UI基类增加 手机 与 Pad 布局切换功能，并全部支持 DataBinding
 * 23.增加 Zip 工具包
 * 24.优化 GT调试悬浮窗
 * 25.优化 热修复类、下载app类、安装app类
 * 26.HttpUtil 类增加下载文件 API
 * 27.新增 GT_Notification 通知封装类 (让自定义通知更加简单)
 * <p>
 * 优化:
 * 1.修复适配器 布局限制的问题,且增加瀑布流一键设置功能
 * 2.新增 BaseFragment 类中 show 与 hide 方法用于监听 Fragment 在不经历生命周期时的调用
 * 3.修复 GT_DataBinding 在不同布局的相同 ID的组件上，获取异常的情况.
 * 解决项目包名大于三层后 适配器在 GT_DataBinding 自动生成的时候，出现 ID,R路径 少生成一个的问题
 * 4.HttpUtil 类修改了使用方法 需要实例化进行请求 如：new GT.HttpUtil().postRequest(....)
 * 5.优化 HttpCall 无法请求下载文件的问题，新版教程请参考官网
 * 
 */
 
````

## 为了更好的使用该库，推荐阅读下面的文章:
### [GT库官方教程入口](https://blog.csdn.net/qq_39799899/article/details/119696907)

#### [第1章：集成GT库 (推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(集成GT库成功！！！)
#### [第2章：日志log类(推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(可以让你轻轻松松找到日志处)
#### [第3章：吐司类   (推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(轻松自定义吐司)
#### [第4章：DataSendReception(新品指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(跨APP/跨进程/收发消息)
#### [第5章：SaveObject (推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(数据永久性存储池)
#### [第6章：GT_SharedPreferences(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(可存储实体类的SP)
#### [第7章：GT_IO(推荐指数：✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(内部 IO 流存储)
#### [第8章：FileUtils(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(轻轻松松自定义可视文件组件)
#### [第9章：Hibernate(热度推荐：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/105935756?spm=1001.2014.3001.5501)(对原生SQLite数据库的封装)
#### [第10章：CleanDataUtils(推荐指数：✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(管理手机数据)
#### [第11章：GT_Random(推荐指数：✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(随机类)
#### [第12章：SerialPortUtils(新品指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(串口类，无需增添第三文件，可直接构建使用！！！)
#### [第13章：DataUtils(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(数据格式装换类)
#### [第14章：Network(推荐指数：✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(网络类用于判断是否可联网，获取P地址等...)
#### [第15章：JSON(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(json 与 Bean 互转)
#### [第16章：HttpUtil与HttpCall(推荐指数：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/125697371?spm=1001.2014.3001.5501)(超简单实用的网络请求框架)
#### [第17章：WebViewUtils(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(轻松加载APP、PC网页、拔网页代码)
#### [第18章：GT_Date(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(强大的日期工具包)
#### [第19章：ScreenOperation(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(手机屏幕操作)
#### [第20章：ApplicationUtils(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(小工具包)
#### [第21章：UpdateApp(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(下载APP并自动安装)
#### [第22章：RepairAPP(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(APP热更新：悄无声息的解决线上bug)
#### [第23章：BaseArrayAdapters(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(针对与 ArrayAdapter 进行封装)
#### [第24章：BaseAdapter(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(针对与 RecyclerView.Adapter 进行封装)
#### [第25章：Encryption(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(加密工具包)
#### [第26章：ProgressDialogUtils(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(多种加载进度条)
#### [第27章：GT_Animation(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(强大的GT动画库)
#### [第28章：WindowUtils(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(WindowUtils 窗体类，封装了APP窗口类工具)
#### [第29章：ViewUtils(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(自定义View工具集合，可直接添加到xml 布局文件中)
#### [第30章：GT_Activity(推荐指数：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(封装 Activity 管理器)
#### [第31章：GT_Fragment(推荐指数：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(封装 Fragment 管理器)
#### [第32章：GT_Dialog(推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(封装 Dialog 管理器)
#### [第33章：GT_FloatingWindow(推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(封装 悬浮窗 管理器)
#### [第34章：设备监听类 DeviceListening(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(手机设备的监听)
#### [第35章：多媒体类(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(手机设备的音乐、音频，视频等)
#### [第36章：GT注解(推荐指数：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(GT高级使用方法)
#### [第37章：GT线程(推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(容易上瘾，请勿上头)
#### [第38章：Permission(新品推荐：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(超级简单且轻量级的动态授权框架)
#### [第39章：GT黑科技(新品指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(黑科技会越来越多，重点发展路线)
###### [黑科技1号：超简单无障碍服务-自带基础寻找组件工具包(新品指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)
#### [第40章：GT-DataBinding(新品指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(彻底解放 findViewById)
#### [第43章：GT-MVVM架构(新品推荐：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907)(超简单GT_MVVM入门系列)
#### [第41章：GT-EventBus(新品推荐：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/123871288?spm=1001.2014.3001.5501)(解决数据传递框架)
#### [第45章：GT-Observable(新品推荐：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/123982353?spm=1001.2014.3001.5501)(异步线程切换框架)





# 如何使用
### 注意：以下为android的使用方式
**1. 项目下app的build.gradle中依赖：**

````gradle
第一步 1. 将以下存储库将其添加到根构建中。存储库末尾的 settings.gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven { url 'https://jitpack.io' }//必要的
    }
}

	
	
第二步 2. 添加依赖关系
dependencies {

	//GT基础功能(必要的)
	implementation 'com.github.1079374315:GSLS_Tool:v1.4.2.2'
	
	//使用 gt-DataBinding 才需要添加以下注册,否则可以不添加
        annotationProcessor 'com.github.1079374315:GSLS_Tool:v1.4.2.2'//注册 gt-DataBinding 功能
	
	//同步后如果出现 ：The number of method references in a .dex file cannot exceed 64K. 错误，
	//请参考该篇文章解决错误：https://blog.csdn.net/qq_39799899/article/details/120165435?spm=1001.2014.3001.5501
}
````

**2. GT包混淆：** [整体项目混淆参考](https://github.com/1079374315/GSLS_Tool/blob/master/gt/proguard-rules.pro)

````gradle
#不混淆GT库
-keep public class com.gsls.gt.GT { *; }
#不混淆 继承GT类 或 继承GT内部类 的类
-keep public class * extends com.gsls.gt.GT { *; }
-keep public class * extends com.gsls.gt.GT$* { *; }

## 其余的看情况混淆

````
## 部分功能使用到的权限：（权限参考）
````
    <!-- U盘操作 --> 
    <uses-permission android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS" tools:ignore="ProtectedPermissions" />
    <uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW" /> <!-- 悬浮窗 -->
    <uses-permission android:name="android.permission.INTERNET" /> <!-- 网络权限 -->
    <!-- SD读写权限 -->
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.READ_PHONE_STATE" /> <!-- 读取手机权限 -->
    <uses-permission android:name="android.permission.READ_CONTACTS" />
    <uses-permission android:name="android.permission.WAKE_LOCK" />
    <uses-permission android:name="android.permission.WRITE_CONTACTS" />
    <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
    <uses-permission android:name="android.permission.SEND_SMS" />
    <uses-permission android:name="android.permission.RECEIVE_SMS" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_LOCATION_EXTRA_COMMANDS" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    
````
