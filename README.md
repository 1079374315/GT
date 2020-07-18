[![CSDN](https://img.shields.io/badge/Android%20Arsenal-Fragmentation-brightgreen.svg?style=flat)](https://blog.csdn.net/qq_39799899)
[![Github](https://travis-ci.org/YoKeyword/Fragmentation.svg?branch=master)](https://github.com/1079374315)
[![](https://jitpack.io/v/1079374315/GSLS_Tool.svg)](https://jitpack.io/#1079374315/GSLS_Tool)


# 最新版本: 1.1.9
发布时间：2020年7月18日 

## 此次版本更新： 
````
更新时间:2020.7.18（大爆料：更新 Fragment 框架、增加启动模式 与 切换模式）
 更新内容：（1.1.9 版本）
 1.更新了 HttpUtil (网络请求)类
 2.更新了 GT_Fragment 类 增加了页面数据恢复 与 BaseFragments 的优化（BaseFragment 增加了 onBackPressed 方法）
 3.增加了 logAll 与 errAll 增加打印所有日志方法
 具体使用教程请参考官网教程
 
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
#### [第二十三章：GT_Fragment 继承篇](https://blog.csdn.net/qq_39799899/article/details/105928081) (常用推荐)
#### [第二十四章：GT_Fragment 使用篇](https://blog.csdn.net/qq_39799899/article/details/105929038) (常用推荐)
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
	implementation 'com.github.1079374315:GSLS_Tool:v1.1.9'//如果不需要使用全部功能，可以只添加GT基础依赖。
	
	//GT全部功能 需要添加的包
 	implementation 'com.google.code.gson:gson:2.8.5'  //JSON 数据解析
 	implementation 'com.lzy.net:okgo:3.0.4' //OkGo 网络框架
 	implementation 'com.squareup.okhttp3:okhttp:3.12.0'//OkHttp 网络框架
 	implementation 'com.github.bumptech.glide:glide:4.9.0'//加载图片的 glide
 	implementation 'org.jsoup:jsoup:1.10.3'//Jsoup格式化html数据
 	implementation 'com.blankj:utilcodex:1.25.9'//集成 AndroidUtilCode 工具包

}
````



## LICENSE
````
Copyright 2019 GSLS

Licensed under the Apache License, Version 1.1.9 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   https://github.com/1079374315/GSLS_Tool/tree/master

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
````
