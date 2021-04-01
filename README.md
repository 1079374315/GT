[![CSDN](https://img.shields.io/badge/Android%20Arsenal-Fragmentation-brightgreen.svg?style=flat)](https://blog.csdn.net/qq_39799899)
[![Github](https://travis-ci.org/YoKeyword/Fragmentation.svg?branch=master)](https://github.com/1079374315)
[![](https://jitpack.io/v/1079374315/GSLS_Tool.svg)](https://jitpack.io/#1079374315/GSLS_Tool)


# 最新版本: 1.3.0.1
发布时间：2021年3月21日 

## 此次版本更新： 
````
* 更新时间:2021.3.21
 * <p> CSDN 详细教程:https://blog.csdn.net/qq_39799899/article/details/98891256
 * <p> CSDN 博客:https://blog.csdn.net/qq_39799899
 * 更新内容：（1.3.0.1 版本 大更新，工具类史诗级加强！）
 * 1.重大更新内容：
 * (1).新增 SaveObject 类，采用序列化进行传递 Object(GT_Fragment|GT_Animation|Hibernate|GT_SharedPreferences|AppDataPool|均自动实现序列化)
 * (2).更新 JSON 类，史诗级增强，JSON 与 Bean 互转，还有许多其他功能方法待你探索（无需依赖gson库）
 * (3).Hibernate 类 史诗级增强，支持较为复杂的关系映射(意味着可以在表里定义实体类)
 * (4).GT_File 类 更名为 FileUtils 类, 史诗级增强, 增多许多实用性功能(轻轻松松自定义文件系统)
 * (5).新增 WebViewUtils 工具类，新增 loadPCHtml(加载PC网页) 、 loadAppHtml(加载App网页) 功能 在加载网页时，实时监听进度
 * (6).新增 ProgressDialogUtils 类 初始化简易的加载进度条。
 * <p>
 * 2.小更新与优化:
 * (1).增加 APP 错误日志捕获方法：GT.LOG.initAppErrLogTry(this);(如果想打印到本地，请打开本地打印：GT.LOG.LOG_FILE_TF = true;)
 * (2).新增 GT_Fragment 构建注解（具体教程请参考官网教程）
 * (3).GT_Fragment 新增 DIALOG 切换方式 如：gt_fragment.switchingMode(GT.GT_Fragment.DIALOG); 让切换的Fragment 进行 hide / show 操作
 * (4).增加Activity 启动 Fragment 或 DialogFragment 销毁后反馈给Activity 数据的操作，增加 Fragment 启动 DialogFragment 销毁反馈给Fragment 数据的操作
 * (5).UpdateApp App更新类优化,在下载时实时监听进度
 * (6).startActivity 、 startFragment 新增 切换动画，有内置动画，也可自定义动画,设置后会一直有效无需二次设置
 * (7).基类 BaseActivity、BaseFragment、BaseDialogFragments，增加更新UI广播 updateUi(), 与 发送更新UI广播的方法 sendUpdateUiBroadcast()
 * <p>
 * 3.bug优化
 * (1). 将GT库 minSdkVersion 调回 minSdkVersion = 16;
 
````

## 为了更好的使用该库，推荐阅读下面的文章:
### [GT库官方教程入口](https://blog.csdn.net/qq_39799899/category_9956339.html)

#### [第一章：GT库依赖篇](https://blog.csdn.net/qq_39799899/article/details/105819914)
#### [第二章：日志(log)篇](https://blog.csdn.net/qq_39799899/article/details/105820384) (常用推荐)
#### [第三章：吐司(Toast)篇](https://blog.csdn.net/qq_39799899/article/details/105845905)
#### [第四章：对话框(AlertDialog)篇](https://blog.csdn.net/qq_39799899/article/details/105846700)
#### [第五章：通知栏(Notification)篇](https://blog.csdn.net/qq_39799899/article/details/105848605)
#### [第六章：sp存储(SharedPreferences)篇](https://blog.csdn.net/qq_39799899/article/details/105849289) (常用推荐)
#### [第七章：IO 与 File篇](https://blog.csdn.net/qq_39799899/article/details/105849346)
#### [第八章：网络请求(OkGo/OkHttp3)篇](https://blog.csdn.net/qq_39799899/article/details/105849520)
#### [第九章：加载 PC 网页篇](https://blog.csdn.net/qq_39799899/article/details/105849651)
#### [第十章：ApplicationUtils篇](https://blog.csdn.net/qq_39799899/article/details/105849722) (常用推荐)
#### [第十一章：APP 迭代类篇](https://blog.csdn.net/qq_39799899/article/details/105850939)
#### [第十二章：App存储池篇](https://blog.csdn.net/qq_39799899/article/details/105851165) (常用推荐)
#### [第十三章：加密 与 权限篇](https://blog.csdn.net/qq_39799899/article/details/105851221)
#### [第十四章：Android动画篇](https://blog.csdn.net/qq_39799899/article/details/105851308)
#### [第十五章：窗体类篇](https://blog.csdn.net/qq_39799899/article/details/105851423)
#### [第十六章：Game 游戏类篇](https://blog.csdn.net/qq_39799899/article/details/105851465)
#### [第十七章：DeviceListening  设备监听类篇](https://blog.csdn.net/qq_39799899/article/details/105851553)
#### [第十八章：多媒体类篇](https://blog.csdn.net/qq_39799899/article/details/105851586)
#### [第十九章：线程类篇](https://blog.csdn.net/qq_39799899/article/details/105851643) (常用推荐)
#### [第二十章：随机类篇](https://blog.csdn.net/qq_39799899/article/details/105851774)
#### [第二十一章：BaseActivity 教程篇](https://blog.csdn.net/qq_39799899/article/details/105867114)
#### [第二十二章：AnnotationActivity 教程篇](https://blog.csdn.net/qq_39799899/article/details/105927908) (常用推荐)
#### [第二十四章：GT_Fragment 教程篇](https://blog.csdn.net/qq_39799899/category_10214456.html) (常用推荐)
#### [第二十五章：Annotations 教程篇](https://blog.csdn.net/qq_39799899/article/details/105929131) (常用推荐)

#### [总篇九章：GT Hibernate 数据库 教程篇](https://blog.csdn.net/qq_39799899/category_9975334.html) (常用推荐)

#### [GSLS_TOOL库：待更新]()

# 如何使用
### 注意：以下为android的使用方式
**1. 项目下app的build.gradle中依赖：**

````gradle
第一步 1. 将以下存储库将其添加到根构建中。存储库末尾的gradle
allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
	
	
第二步 2. 添加依赖关系
dependencies {
	//GT基础功能
	implementation 'com.github.1079374315:GSLS_Tool:v1.3.0.1'//如果不需要使用全部功能，可以只添加GT基础依赖。
	
	//GT全部功能 需要添加的包
    	implementation 'com.squareup.okhttp3:okhttp:3.12.0'//okHttp3
 	implementation 'com.lzy.net:okgo:3.0.4' //OkGo 网络框架
	implementation 'com.blankj:utilcodex:1.25.9'//集成 AndroidUtilCode 工具包

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

## 继承 GT包中的 GT.GT_Fragment.BaseDialogFragments 均不能混淆：(如果没有继承该类，可以不用混淆)
-keep class com.gsls.gt.GT$GT_Fragment$BaseDialogFragments**{*;}
-keep public class * extends com.gsls.gt.GT$GT_Fragment$BaseDialogFragments { *; }

````


## LICENSE
````
Copyright 2019 GSLS

Licensed under the Apache License, Version 1.3.0.1 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   https://github.com/1079374315/GSLS_Tool/tree/master

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
````
