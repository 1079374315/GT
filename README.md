[![GitHub Versions](https://github.com/jedisct1/libsodium/workflows/CI/badge.svg)](https://github.com/1079374315/GSLS_Tool/tags)
[![CSDN](https://img.shields.io/badge/Android%20Arsenal-Fragmentation-brightgreen.svg?style=flat)](https://blog.csdn.net/qq_39799899)
[![Github](https://travis-ci.org/YoKeyword/Fragmentation.svg?branch=master)](https://github.com/1079374315)
[![](https://jitpack.io/v/1079374315/GSLS_Tool.svg)](https://jitpack.io/#1079374315/GSLS_Tool)

<img src="https://csdnimg.cn/medal/linkedin@240.png"  width="40px"><img src="https://csdnimg.cn/medal/github@240.png"  width="40px"><img src="https://csdnimg.cn/medal/maimai@240.png"  width="40px"><img src="https://csdnimg.cn/medal/qiandao10@240.png"  width="40px"><img src="https://csdnimg.cn/medal/yuedu3@240.png"  width="40px"><img src="https://csdnimg.cn/medal/chizhiyiheng@240.png"  width="40px"><img src="https://csdnimg.cn/medal/1024@240.png"  width="40px"><img src="https://csdnimg.cn/medal/qixiebiaobing4@240.png"  width="40px"><img src="https://csdnimg.cn/medal/yuanli_xuexili@240.png"  width="40px"><img src="https://csdnimg.cn/medal/yuanli_xinren@240.png"  width="40px"><img src="https://csdnimg.cn/medal/yuanli_tansuoS@240.png"  width="40px"><img src="https://csdnimg.cn/medal/fenxiangjingying@240.png"  width="40px">

# <a href="https://blog.csdn.net/qq_39799899"><img src="https://profile.csdnimg.cn/7/5/9/3_qq_39799899"  width="60px"></a>[GT库源码](https://github.com/1079374315/GSLS_Tool)

![libsodium](https://raw.github.com/jedisct1/libsodium/master/logo.png)
============

# 最新版本: 1.3.1.2
发布时间：2021.9.10

# 此次版本更新：
````
/**
 * 工具类说明：
 * GSLS_Tool
 * <p>
 * <p>
* 更新时间:2021.9.10
 * <p> CSDN 详细教程:https://blog.csdn.net/qq_39799899/article/details/102490617
 * <p> CSDN 博客:https://blog.csdn.net/qq_39799899
 * <p> GitHub https://github.com/1079374315/GT
 * <p>更新内容：（1.3.1.2 版本）
 * <p>内容如下：
 * <p>1.优化了 log显示
 * <p>2.增加了国际化工具包
 * <p>3.更新了简易对话框
 * <p>4.新增 Permission 权限动态申请框架
 * <p>5.新增无障碍服务基类， AccessibilityServiceBase 使用起来非常简单
 * <p>6.新增 GT_View 专门用来解决局部View特别复杂时会让 Avtibity 或 Fragment 变复杂的问题
 * <p>7.回调增加 非常用的注解绑定方法
 * <p>8.权限申请类适配可以Fragment中直接使用
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

#### [第1章：集成GT库 (推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t5)(集成GT库成功！！！)
#### [第2章：日志log类(推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t9)(可以让你轻轻松松找到日志处)
#### [第3章：吐司类   (推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t15)(轻松自定义吐司)
#### [第4章：DataSendReception(新品指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t21)(跨APP/跨进程/收发消息)
#### [第5章：SaveObject (推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t25)(数据永久性存储池)
#### [第6章：GT_SharedPreferences(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t27)(可存储实体类的SP)
#### [第7章：GT_IO(推荐指数：✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t29)(内部 IO 流存储)
#### [第8章：FileUtils(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t31)(轻轻松松自定义可视文件组件)
#### [第9章：Hibernate(热度推荐：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t33)(对原生SQLite数据库的封装)
#### [第10章：CleanDataUtils(推荐指数：✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t35)(管理手机数据)
#### [第11章：GT_Random(推荐指数：✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t37)(随机类)
#### [第12章：SerialPortUtils(新品指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t39)(串口类，无需增添第三文件，可直接构建使用！！！)
#### [第13章：DataUtils(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t41)(数据格式装换类)
#### [第14章：Network(推荐指数：✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t44)(网络类用于判断是否可联网，获取P地址等...)
#### [第15章：JSON(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t46)(json 与 Bean 互转)
#### [第16章：OkGo(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t48)(网络请求框架，需要另外依赖上 OKGO的库)
#### [第17章：OkHttp(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t52)(网络请求框架，需要另外依赖上 OkHttp的库)
#### [第18章：HttpUtil(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t54)(原始网络请求框架)
#### [第19章：WebViewUtils(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t56)(轻松加载APP、PC网页、拔网页代码)
#### [第20章：GT_Date(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t63)(强大的日期工具包)
#### [第21章：ScreenOperation(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t65)(手机屏幕操作)
#### [第22章：ApplicationUtils(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t67)(小工具包)
#### [第23章：UpdateApp(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t70)(下载APP并自动安装)
#### [第24章：RepairAPP(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t73)(APP热更新：悄无声息的解决线上bug)
#### [第25章：BaseArrayAdapters(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t76)(针对与 ArrayAdapter 进行封装)
#### [第26章：BaseAdapter(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t78)(针对与 RecyclerView.Adapter 进行封装)
#### [第27章：Encryption(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t83)(加密工具包)
#### [第28章：ProgressDialogUtils(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t88)(多种加载进度条)
#### [第29章：GT_Animation(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t94)(强大的GT动画库)
#### [第30章：WindowUtils(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t96)(WindowUtils 窗体类，封装了APP窗口类工具)
#### [第31章：ViewUtils(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t98)(自定义View工具集合，可直接添加到xml 布局文件中)
#### [第32章：GT_Activity(推荐指数：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t100)(封装 Activity 管理器)
#### [第33章：GT_Fragment(推荐指数：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t104)(封装 Fragment 管理器)
#### [第34章：GT_Dialog(推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t108)(封装 Dialog 管理器)
#### [第35章：GT_FloatingWindow(推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t114)(封装 悬浮窗 管理器)
#### [第36章：设备监听类 DeviceListening(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t119)(手机设备的监听)
#### [第37章：多媒体类(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t121)(手机设备的音乐、音频，视频等)
#### [第38章：GT注解(推荐指数：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t123)(GT高级使用方法)
#### [第39章：GT线程(推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t125)(容易上瘾，请勿上头)
#### [第40章：Permission(新品推荐：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t137)(超级简单且轻量级的动态授权框架)
#### [第41章：GT黑科技(新品指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t139)(黑科技会越来越多，重点发展路线)
###### [黑科技1号：超简单无障碍服务-自带基础寻找组件工具包(新品指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t140)





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
	implementation 'com.github.1079374315:GSLS_Tool:v1.3.1.2'//如果不需要使用全部功能，可以只添加GT基础依赖。
	//同步后如果出现 ：The number of method references in a .dex file cannot exceed 64K. 错误，请参考该篇文章：https://blog.csdn.net/qq_39799899/article/details/102490617

}
````

**2. GT包混淆：**

````gradle

## GT：（必要的混淆）
-keep class com.gsls.gt.GT**{*;}

## 继承GT包中的 GT_Fragment.BaseFragments 均不能混淆：(如果没有继承该类，可以不用混淆)
## Fragment                        
-keep class com.gsls.gt.GT$GT_Fragment$BaseFragments**{*;}
-keep public class * extends com.gsls.gt.GT$GT_Fragment$BaseFragments { *; }

## 继承 GT包中的 GT.GT_Dialog.BaseDialogFragments 均不能混淆：(如果没有继承该类，可以不用混淆)
-keep class com.gsls.gt.GT$GT_Dialog$BaseDialogFragments**{*;}
-keep public class * extends com.gsls.gt.GT$GT_Dialog$BaseDialogFragments { *; }

````


# 感谢有你们：
<a href="#"><img src="https://avatars.githubusercontent.com/u/3365442?s=88&u=6b3ddc2fb63099b1a65b24acd188256f68c25ef4&v=4"  width="40px"></a>
<a href="#"><img src="https://avatars.githubusercontent.com/u/29051537?s=88&v=4"  width="40px"></a>
<a href="#"><img src="https://avatars.githubusercontent.com/u/59863314?s=88&v=4"  width="40px"></a>
<a href="#"><img src="https://avatars.githubusercontent.com/u/63953832?s=88&v=4"  width="40px"></a>
<a href="#"><img src="https://avatars.githubusercontent.com/u/49602691?s=88&v=4"  width="40px"></a>
<a href="#"><img src="https://avatars.githubusercontent.com/u/29189439?s=88&v=4"  width="40px"></a>
<a href="#"><img src="https://avatars.githubusercontent.com/u/21036114?s=88&v=4"  width="40px"></a>
<a href="#"><img src="https://avatars.githubusercontent.com/u/14036679?s=88&v=4"  width="40px"></a>
<a href="#"><img src="https://avatars.githubusercontent.com/u/9794965?s=88&u=81de92f82bbbc33390cfd32eb69f27f5c66a6047&v=4"  width="40px"></a>
<a href="#"><img src="https://avatars.githubusercontent.com/u/8890848?s=88&v=4"  width="40px"></a>
<a href="#"><img src="https://avatars.githubusercontent.com/u/12744158?s=88&v=4"  width="40px"></a>
<a href="#"><img src="https://avatars.githubusercontent.com/u/52192471?s=88&v=4"  width="40px"></a>
<a href="#"><img src="https://avatars.githubusercontent.com/u/49230512?s=88&u=f4eadb16bdb1657698aa032430bfce4da1e5220d&v=4"  width="40px"></a>
<a href="#"><img src="https://avatars.githubusercontent.com/u/19610079?s=88&v=4"  width="40px"></a>
<a href="#"><img src="https://avatars.githubusercontent.com/u/16605385?s=88&u=ec5808193d24407fc045137834d4aba2db0731c1&v=4"  width="40px"></a>
<a href="#"><img src="https://avatars.githubusercontent.com/u/26473620?s=88&v=4"  width="40px"></a>
<a href="#"><img src="https://avatars.githubusercontent.com/u/42802245?s=88&u=762012cc0803ba21c2a46bdbfecb3ad070aa4122&v=4"  width="40px"></a>
<a href="#"><img src="https://profile.csdnimg.cn/5/F/2/3_yuanchuangyz"  width="40px"></a>
<a href="#"><img src="https://profile.csdnimg.cn/C/A/7/3_weixin_50181653"  width="40px"></a>
<a href="#"><img src="https://profile.csdnimg.cn/F/1/4/3_weixin_45117937"  width="40px"></a>
<a href="#"><img src="https://profile.csdnimg.cn/F/9/0/3_m0_52067386"  width="40px"></a>
<a href="#"><img src="https://profile.csdnimg.cn/9/3/9/3_weixin_50004011"  width="40px"></a>
<a href="#"><img src="https://profile.csdnimg.cn/8/B/F/3_m0_48728976"  width="40px"></a>
<a href="#"><img src="https://profile.csdnimg.cn/C/5/3/3_weixin_45200954"  width="40px"></a>
<a href="#"><img src="https://profile.csdnimg.cn/C/9/7/3_d103401"  width="40px"></a>
<a href="#"><img src="https://profile.csdnimg.cn/A/9/E/3_baidu_35165120"  width="40px"></a>
<a href="#"><img src="https://profile.csdnimg.cn/8/3/A/3_qq_38773852"  width="40px"></a>
<a href="#"><img src="https://profile.csdnimg.cn/B/1/9/3_rubmle"  width="40px"></a>
<a href="#"><img src="https://profile.csdnimg.cn/2/D/E/3_qq_36607515"  width="40px"></a>
<a href="#"><img src="https://profile.csdnimg.cn/B/E/6/3_qq_43397151"  width="40px"></a>
<a href="#"><img src="https://profile.csdnimg.cn/F/3/7/3_weixin_45065921"  width="40px"></a>
<a href="#"><img src="https://profile.csdnimg.cn/D/7/B/3_jihong10102006"  width="40px"></a>
<a href="#"><img src="https://profile.csdnimg.cn/B/6/4/3_qq_44994497"  width="40px"></a>
<a href="#"><img src="https://profile.csdnimg.cn/1/2/C/3_u011047998"  width="40px"></a>
<a href="#"><img src="https://profile.csdnimg.cn/3/8/2/3_weixin_35649059"  width="40px"></a>
<a href="#"><img src="https://profile.csdnimg.cn/7/6/8/3_qq_41561161"  width="40px"></a>
<a href="#"><img src="https://profile.csdnimg.cn/0/1/4/3_qq_37696855"  width="40px"></a>

# 开源贡献者
<a href="https://github.com/taylor618"><img src="https://avatars.githubusercontent.com/u/4032477?s=96&v=4"  width="40px"></a>

## LICENSE
````
Copyright 2021 GSLS

Licensed under the Apache License, Version 1.3.1.2 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   https://github.com/1079374315/GSLS_Tool/tree/master

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
````
