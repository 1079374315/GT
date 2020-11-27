[![CSDN](https://img.shields.io/badge/Android%20Arsenal-Fragmentation-brightgreen.svg?style=flat)](https://blog.csdn.net/qq_39799899)
[![Github](https://travis-ci.org/YoKeyword/Fragmentation.svg?branch=master)](https://github.com/1079374315)
[![](https://jitpack.io/v/1079374315/GSLS_Tool.svg)](https://jitpack.io/#1079374315/GSLS_Tool)


# 最新版本: 1.2.9
发布时间：2020年11月27日 

## 此次版本更新： 
````
 * 更新时间:2020.11.24
 * <p> CSDN 详细教程:https://blog.csdn.net/qq_39799899/article/details/98891256
 * <p> CSDN 博客:https://blog.csdn.net/qq_39799899
 * 更新内容：（1.2.9 版本 数据传递 就是这么简单！）
 * 1.新增 SaveObject 类，采用序列化进行传递 Object(GT_Fragment|GT_Animation|Hibernate|GT_SharedPreferences|AppDataPool|均自动实现序列化)
 * 2.增加 APP 错误日志捕获方法：GT.LOG.initAppErrLogTry(this);(如果想打印到本地，请打开本地打印：GT.LOG.LOG_FILE_TF = true;)
 * 3.新增 GT_Fragment 构建注解，用法如下：（具体教程请参考官网教程）
 * 用法1：GT.GT_Fragment.Build;
 * 用法2：GT.GT_Fragment.Builds(R.id.frameLayout, Fragment_A.class); 参数一：指定一个Fragment 容器，参数二：指定预加载的Fragment页面，参数均可不填
 * 注意：使用注解时如果没有指定加载Fragment容器的话很容易报未找到视图的异常，但添加 gt_fragment.setHomeFragmentId(R.id.frameLayout); 即可
 * 4.GT_Fragment 新增 DIALOG 切换方式 如：gt_fragment.switchingMode(GT.GT_Fragment.DIALOG); 让切换的Fragment 进行 hide / show 操作
 
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
	implementation 'com.github.1079374315:GSLS_Tool:v1.2.9'//如果不需要使用全部功能，可以只添加GT基础依赖。
	
	//GT全部功能 需要添加的包
 	implementation 'com.google.code.gson:gson:2.8.5'  //JSON 数据解析
 	implementation 'com.lzy.net:okgo:3.0.4' //OkGo 网络框架
 	implementation 'com.squareup.okhttp3:okhttp:3.12.0'//OkHttp 网络框架
 	implementation 'com.github.bumptech.glide:glide:4.9.0'//加载图片的 glide
 	implementation 'org.jsoup:jsoup:1.10.3'//Jsoup格式化html数据
 	implementation 'com.blankj:utilcodex:1.25.9'//集成 AndroidUtilCode 工具包

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

## gson（使用到 GT包中SP的，需要混淆）
-dontwarn com.google.gson.**
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.** { *; }
-keep class com.google.gson.JsonObject { *; }
-keep class com.google.gson.examples.android.model.** { *; }

````


## LICENSE
````
Copyright 2019 GSLS

Licensed under the Apache License, Version 1.2.6 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   https://github.com/1079374315/GSLS_Tool/tree/master

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
````
