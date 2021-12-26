[![GitHub Versions](https://github.com/jedisct1/libsodium/workflows/CI/badge.svg)](https://github.com/1079374315/GSLS_Tool/tags)
[![CSDN](https://img.shields.io/badge/Android%20Arsenal-Fragmentation-brightgreen.svg?style=flat)](https://blog.csdn.net/qq_39799899)
[![Github](https://travis-ci.org/YoKeyword/Fragmentation.svg?branch=master)](https://github.com/1079374315)
[![](https://jitpack.io/v/1079374315/GSLS_Tool.svg)](https://jitpack.io/#1079374315/GSLS_Tool)

<img src="https://csdnimg.cn/medal/linkedin@240.png"  width="40px"><img src="https://csdnimg.cn/medal/github@240.png"  width="40px"><img src="https://csdnimg.cn/medal/maimai@240.png"  width="40px"><img src="https://csdnimg.cn/medal/qiandao10@240.png"  width="40px"><img src="https://csdnimg.cn/medal/yuedu3@240.png"  width="40px"><img src="https://csdnimg.cn/medal/chizhiyiheng@240.png"  width="40px"><img src="https://csdnimg.cn/medal/1024@240.png"  width="40px"><img src="https://csdnimg.cn/medal/qixiebiaobing4@240.png"  width="40px"><img src="https://csdnimg.cn/medal/yuanli_xuexili@240.png"  width="40px"><img src="https://csdnimg.cn/medal/yuanli_xinren@240.png"  width="40px"><img src="https://csdnimg.cn/medal/yuanli_tansuoS@240.png"  width="40px"><img src="https://csdnimg.cn/medal/fenxiangjingying@240.png"  width="40px">

# <a href="https://blog.csdn.net/qq_39799899"><img src="http://gsls.3vfree.cn/Servers/img/GT/logo.png"  width="200px"></a>[GT库源码](https://github.com/1079374315/GSLS_Tool)
============

#### [下载网址：DataBinding.jar](http://gsls.3vfree.cn/Servers/GT/gt-DataBinding.jar)

# 最新版本: 1.3.6.1
发布时间：2021.12.26

# 此次版本更新：
````
/**
 * 更新时间:2021.12.26
 * CSDN 博客/官网教程:https://blog.csdn.net/qq_39799899
 * GitHub https://github.com/1079374315/GT
 * 更新内容：（1.3.6.1 版本 取消GT库默认提供的权限，默认提供的权限可在官网教程处查看）
 * 内容如下：
 * 1.优化logs、errs日志的显示
 * 2.优化 GT适配器加载数据
 * 3.新增 GT_Toolkit 可视化工具(目前功能较少，今后会扩展)
 * 启动代码：(记得需要加入悬浮窗权限)
 * GT_Toolkit.setType_screenType(-1);
 * startFloatingWindow(GT_Toolkit.class);
 * 4.增加动态获取输入法高度的方法 KeyboardLayout.class 具体使用教程请参考官网
 * 5.新增 gt-DataBinding中对 DialogFragment、BaseFloatingWindow、BaseAdapter、GTView的支持
 * 6.优化 Hibernate 多线程操作
 * 7.gt-DataBinding支持解析第三布局 <include 标签的引入布局，但需要为识别的<include 标签加上 id号
 *
 *
 *
 * <p>
 * <p>
 * <p>
 * 小提示：(用于 AndroidStudio )
 * 收起所有的 方法: Ctrl + Shift +  - (减号)
 * 展开所有的 方法: Ctrl + Shift +  + (加号)
 * 代码格式化快捷键是 Ctrl + Alt + L
 */
 
````

## 为了更好的使用该库，推荐阅读下面的文章:
### [GT库官方教程入口](https://blog.csdn.net/qq_39799899/article/details/119696907)

#### [第1章：集成GT库 (推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t1)(集成GT库成功！！！)
#### [第2章：日志log类(推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t5)(可以让你轻轻松松找到日志处)
#### [第3章：吐司类   (推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t11)(轻松自定义吐司)
#### [第4章：DataSendReception(新品指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t17)(跨APP/跨进程/收发消息)
#### [第5章：SaveObject (推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t21)(数据永久性存储池)
#### [第6章：GT_SharedPreferences(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t23)(可存储实体类的SP)
#### [第7章：GT_IO(推荐指数：✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t25)(内部 IO 流存储)
#### [第8章：FileUtils(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t27)(轻轻松松自定义可视文件组件)
#### [第9章：Hibernate(热度推荐：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t29)(对原生SQLite数据库的封装)
#### [第10章：CleanDataUtils(推荐指数：✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t31)(管理手机数据)
#### [第11章：GT_Random(推荐指数：✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t33)(随机类)
#### [第12章：SerialPortUtils(新品指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t35)(串口类，无需增添第三文件，可直接构建使用！！！)
#### [第13章：DataUtils(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t37)(数据格式装换类)
#### [第14章：Network(推荐指数：✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t40)(网络类用于判断是否可联网，获取P地址等...)
#### [第15章：JSON(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t42)(json 与 Bean 互转)
#### [第16章：OkGo(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t48)(网络请求框架，需要另外依赖上 OKGO的库)
#### [第17章：OkHttp(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t48)(网络请求框架，需要另外依赖上 OkHttp的库)
#### [第18章：HttpUtil(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t50)(原始网络请求框架)
#### [第19章：WebViewUtils(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t52)(轻松加载APP、PC网页、拔网页代码)
#### [第20章：GT_Date(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t58)(强大的日期工具包)
#### [第21章：ScreenOperation(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t61)(手机屏幕操作)
#### [第22章：ApplicationUtils(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t63)(小工具包)
#### [第23章：UpdateApp(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t66)(下载APP并自动安装)
#### [第24章：RepairAPP(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t69)(APP热更新：悄无声息的解决线上bug)
#### [第25章：BaseArrayAdapters(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t72)(针对与 ArrayAdapter 进行封装)
#### [第26章：BaseAdapter(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t74)(针对与 RecyclerView.Adapter 进行封装)
#### [第27章：Encryption(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t79)(加密工具包)
#### [第28章：ProgressDialogUtils(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t84)(多种加载进度条)
#### [第29章：GT_Animation(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t90)(强大的GT动画库)
#### [第30章：WindowUtils(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t92)(WindowUtils 窗体类，封装了APP窗口类工具)
#### [第31章：ViewUtils(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t94)(自定义View工具集合，可直接添加到xml 布局文件中)
#### [第32章：GT_Activity(推荐指数：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t96)(封装 Activity 管理器)
#### [第33章：GT_Fragment(推荐指数：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t100)(封装 Fragment 管理器)
#### [第34章：GT_Dialog(推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t104)(封装 Dialog 管理器)
#### [第35章：GT_FloatingWindow(推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t119)(封装 悬浮窗 管理器)
#### [第36章：设备监听类 DeviceListening(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t126)(手机设备的监听)
#### [第37章：多媒体类(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t128)(手机设备的音乐、音频，视频等)
#### [第38章：GT注解(推荐指数：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t130)(GT高级使用方法)
#### [第39章：GT线程(推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t132)(容易上瘾，请勿上头)
#### [第40章：Permission(新品推荐：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t133)(超级简单且轻量级的动态授权框架)
#### [第41章：GT黑科技(新品指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t135)(黑科技会越来越多，重点发展路线)
###### [黑科技1号：超简单无障碍服务-自带基础寻找组件工具包(新品指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t136)
#### [第42章：GT-DataBinding(新品指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/121270536)(彻底解放 findViewById)





# 如何使用
### 注意：以下为android的使用方式
**1. 项目下app的build.gradle中依赖：**

````gradle
第一步 1. 将以下存储库将其添加到根构建中。存储库末尾的gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
	
	
第二步 2. 添加依赖关系
dependencies {

	//GT基础功能
	implementation 'com.github.1079374315:GSLS_Tool:v1.3.6.1'//如果不需要使用全部功能，可以只添加GT基础依赖。
	
	//如需使用 gt-DataBinding 才需要添加以下注册否则可以不注册，请前往官网下载最新 jar 进行注册
    	annotationProcessor files('libs/gt-DataBinding.jar')//注册 gt-DataBinding 功能
	
	//同步后如果出现 ：The number of method references in a .dex file cannot exceed 64K. 错误，请参考该篇文章：https://blog.csdn.net/qq_39799899/article/details/102490617
}
````

**2. GT包混淆：**

````gradle

## GT：（必要的混淆）
-keep class com.gsls.gt.** {*;}
## 其余的看情况混淆

````
