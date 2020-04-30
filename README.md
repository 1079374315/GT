[![CSDN](https://img.shields.io/badge/Android%20Arsenal-Fragmentation-brightgreen.svg?style=flat)](https://blog.csdn.net/qq_39799899)
[![Github](https://travis-ci.org/YoKeyword/Fragmentation.svg?branch=master)](https://github.com/1079374315)
[![](https://jitpack.io/v/1079374315/GT.svg)](https://jitpack.io/#1079374315/GT)
[切换到CSDN](https://blog.csdn.net/qq_39799899/article/details/102490617)

# 最新版本: 1.1.6
发布时间：2020.4.30

## 此次版本更新： 
````
 更新时间:2020.4.30（大爆料：更新 Hibernate 数据库）
 <p> CSDN 详细教程:https://blog.csdn.net/qq_39799899/article/details/98891256
 <p> CSDN 博客:https://blog.csdn.net/qq_39799899
 更新内容：（1.1.6 版本）
 1.新增 LOG 日志类 分 Logcat 与 本地打印 用于打更加详细的日志。(最终效果 以最新教程为主)
 (1)可使用 setLogTAG 方法用于自定义 日志的 TAG 值
 (2)新增两种打印   本地普通打印：logs("****");   本地错误打印：errs("****");
 （默认不开启本地打印，若需要开启请参考官网教程）
 2.新增 TOAST 吐司类 用于专门管理 吐司变量,将自定义吐司的类移至 TOAST 类中。
 3.AnnotationActivity、BaseActivity 类中增加 initFragment() 操作方法
 4.权限类(AppAuthorityManagement)中添加上申请白名单权限。
 5.更新 Hibernate 数据库类，依照 J2EE 的模式，根据实体类 映射出 数据库与字段，实现无SQL代码实现SQL逻辑的效果。（具体使用教程，请参考官网教程）
 6.优化的数据池的外部数据池代码
 7.优化一下代码，默认不开启Util工具包
````

[GT库迁移至GSLS_Tool](https://github.com/1079374315/GSLS_Tool)

![](/gif/logo.png)


### 为了更好的使用该库，推荐阅读下面的文章:

#### （当前章节有问题的或发现有bug的请各位在当前章节下的评论指出来，楼主会及时的进行修复与给予当事人答复。）


[GT 待更新章节： 正在更新的 GT 库 ：](https://blog.csdn.net/qq_39799899/article/details/98891256#GT%20%E7%AC%AC%E4%BA%8C%E5%8D%81%E4%BA%8C%E7%AB%A0%EF%BC%9A%20%E6%AD%A3%E5%9C%A8%E6%9B%B4%E6%96%B0%E7%9A%84%20GT%20%E5%BA%93)


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
	implementation 'com.github.1079374315:GSLS_Tool:v1.1.6'//如果不需要使用全部功能，可以只添加GT基础依赖。
	
	//GT全部功能 需要添加的包
 	implementation 'com.google.code.gson:gson:2.8.5'  //JSON 数据解析
 	implementation 'com.lzy.net:okgo:3.0.4' //OkGo 网络框架
 	implementation 'com.squareup.okhttp3:okhttp:3.12.0'//OkHttp 网络框架
 	implementation 'com.github.bumptech.glide:glide:4.9.0'//加载图片的 glide
 	implementation 'org.jsoup:jsoup:1.10.3'//Jsoup格式化html数据
 	implementation 'com.blankj:utilcodex:1.25.9'//集成 AndroidUtilCode 工具包

}
````

````

#混淆时，GT需要添加的

#不混淆GT包
-dontwarn com.gsls.gt.**
#不混淆GT类
-keep public class com.gsls.gt.GT { *; }
#不混淆GT类的子类
-keep public class * extends com.gsls.gt.GT { *; }
#不混淆某个类的内部类
-keep class com.gsls.gt.GT$* {*;}
#还有些混淆需要注意的是，最好将使用注解的类均不进行混淆。





#比如 BaseFragment 类使用了注解 那就需要添加以下不混淆

#不混淆 BaseFragment 类
-keep public class com.***.fragment.BaseFragment { *; }
#不混淆 所有继承 BaseFragment 类
-keep public class * extends com.***.fragment.BaseFragment { *; }

````

## [当前 GT 最新版本 查看地址](https://jitpack.io/#1079374315/GT/v1.1.6)

## LICENSE
````
Copyright 2019 GSLS

Licensed under the Apache License, Version 1.1.6 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   https://github.com/1079374315/GT/tree/master

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
````
