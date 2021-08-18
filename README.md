[![GitHub Versions](https://github.com/jedisct1/libsodium/workflows/CI/badge.svg)](https://github.com/1079374315/GSLS_Tool/tags)
[![CSDN](https://img.shields.io/badge/Android%20Arsenal-Fragmentation-brightgreen.svg?style=flat)](https://blog.csdn.net/qq_39799899)
[![Github](https://travis-ci.org/YoKeyword/Fragmentation.svg?branch=master)](https://github.com/1079374315)
[![](https://jitpack.io/v/1079374315/GSLS_Tool.svg)](https://jitpack.io/#1079374315/GSLS_Tool)

<img src="https://csdnimg.cn/medal/linkedin@240.png"  width="40px"><img src="https://csdnimg.cn/medal/github@240.png"  width="40px"><img src="https://csdnimg.cn/medal/maimai@240.png"  width="40px"><img src="https://csdnimg.cn/medal/qiandao10@240.png"  width="40px"><img src="https://csdnimg.cn/medal/yuedu3@240.png"  width="40px"><img src="https://csdnimg.cn/medal/chizhiyiheng@240.png"  width="40px"><img src="https://csdnimg.cn/medal/1024@240.png"  width="40px"><img src="https://csdnimg.cn/medal/qixiebiaobing4@240.png"  width="40px"><img src="https://csdnimg.cn/medal/yuanli_xuexili@240.png"  width="40px"><img src="https://csdnimg.cn/medal/yuanli_xinren@240.png"  width="40px"><img src="https://csdnimg.cn/medal/yuanli_tansuoS@240.png"  width="40px"><img src="https://csdnimg.cn/medal/fenxiangjingying@240.png"  width="40px">

# <a href="https://blog.csdn.net/qq_39799899"><img src="https://profile.csdnimg.cn/7/5/9/3_qq_39799899"  width="60px"></a>[GT库源码](https://github.com/1079374315/GSLS_Tool) 

![libsodium](https://raw.github.com/jedisct1/libsodium/master/logo.png)
============

# 最新版本: 1.3.0.6
发布时间：2021.7.28

# 此次版本更新： 
````
/**
 * 工具类说明：
 * GSLS_Tool
 * <p>
 * <p>
 * 更新时间:2021.7.28
 * <p> CSDN 详细教程:https://blog.csdn.net/qq_39799899/article/details/102490617
 * <p> CSDN 博客:https://blog.csdn.net/qq_39799899
 * <p> GitHub https://github.com/1079374315/GT
 * 更新内容：（1.3.0.6 版本）
 * 超级重磅更新！！！
 * 内容如下：
 * 1.Hibernate 类的更新
 * 1).Hibernate 数据库支持映射 “数组参数”、“多重继承关系”
 * 2).新增初始化 Hibernate 的方式，可在Application中进行初始化操作：new GT.Hibernate().initialize(); 与 new GT.Hibernate().getHibernate(); （注意，这两个方法均是有创建的效果）
 * 3).新增聚合函数：count(求次数)、sum(求总和)、max(求最大值)、min(求最小值)、average(求平均数)，后续待添加新的...
 * 4).修改了增删查改的方式，优化增删查改的效率，增加了 saveAll() 保存数据方法，当前测试效率：存储10万条数据，09:07:53.199——09:07:59.646 耗时6秒多，具体详情还请参考方法说明
 * 5).正式支持事务操作具体教程请参考官网:saveAll();保存全部方法默认使用事务
 * 6).支持 分库映射 若您创建了两个或两个以上的数据库，那么可以在实体类的标识上指定映射的数据库名称，
 * 实例：不指定的话，默认给所有的数据库映射表，指定单个数据库：@GT.Hibernate.GT_Entity(setSqlName = "MySQL") OR 指定多个数据库：@GT.Hibernate.GT_Entity(setSqlName = {"MySQL","DemoSQL"})
 * 7).将表字段属性设置更名为 “GT_Property”,
 * GT_Property目前支持以下功能：
 * 1).修改字段名：setOldTableValue    释：修改字段名后，数据依旧在
 * 2).设置不为空: setNotNull          释：如果操作数据为null就会操作失败
 * 3).设置限定值：setCheckValues      释：sex = 男 or 女 or 其他
 * 4).设置字段长度：setLength         释：userName varchar(100)
 * 5).设置最大值：setMax              释：设置数字的最大值
 * 6).设置最小值：setMin              释：设置数字的最小值
 * 7).设置不被持久化：setNotInit       释：将不被持久化的字段当做普通的 Java字段
 * 8).设置默认值：setDefaultValue     释：设置默认值，用法有两种，如果是多个默认值，数据库会随机选择一个默认值
 * 第一种：setDefaultValue = "默认值",
 * 第二种：setDefaultValue = {"默认值1"，"默认值2"，"默认值3"....}
 * GT_Key,主键标识目前只支持：设置自增长、设置字段长度、设置限定值、设置最大值、设置最小值
 * 8).优化了 数据库 创建时的性能，增加创建方式：可在线程中创建数据库
 * 9).支持动态创建表的操作：createTable(DemoBean.class);
 * 10).
 * 11).
 * 2.新增悬浮窗封装类 GT_FloatingWindow 用法与 GT_Fragment 类似，具体使用教程请参考官网,(新增 GT_Floating 工具类，还在优化中)
 * 3.增加可嵌套的滑动组件 ScrollView
 * 4.新增 串口类 SerialPortUtils
 * 5.新增 GT_Socket TCP 类
 * <p>
 * <p>
 * 3.新增 GT.GT_Adapters.BaseAdapter 基类
 * 4.新增 DataSendReception 数据传输类，用于传输数据目前可支持：跨类、跨进程、跨APP传输数据
 * 5.新增 适配器 AnnotationAdapter 注解基类
 * n.新版本的优化
 * <p>
 * (1).去掉所有基类自带的 log() toast() err() 类似等方法(不方便维护，故此版本去掉)
 * (2).去掉 GT_Fragment 与 DialogFragment类中内置的广播，改用 DataSendReception 方式进行传输数据，具体可参考官网教程
 * 注意：在使用 Dialog 方式切换时，会默认将Fragment加入回退栈
 * (3).修复 Fragment 与 DialogFragment 当焦点在EditText 时无法监听到返回事件
 * (4).将 DialogFragment 与 GT_AlertDialog 移植到 GT_Dialog类进行统一管理,新增了弹出DialogFragment隐藏虚拟按钮的方法
 * <p>
 * bug优化
 * 1.Hibernate 在映射表时，父表与子表有相同的属性时，出现的映射问题（当前版本默认使用子表的属性映射）
 * 2.Hibernate 在查询的时候，出现List<String> 赋值为null的情况下，查询出来会报异常日志（已优化）
 * 3.Hibernate 在多数据库创建时出现的问题
 * 4.优化了 Hibernate 的 保存所有 与 查询所有 的效率
 * 5.优化 GT_Fragment 有几率点击穿透的问题
 * 6.优化了所有注解的核心方法
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

## [第一章：集成GT库 (推荐指数：✪✪✪✪✪)]() 
## [第二章：日志log类(推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t9) 
## [第三章：吐司类   (推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t15) 
## [第四章：数据模块](https://blog.csdn.net/qq_39799899/article/details/119696907#t20) 
###[1：DataSendReception(数据发送与接收：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t21) 
###[2：SaveObject (持久性保存数据：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t25) 
###[3：GT_SharedPreferences(原始SP封装：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907#t25) 


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
	implementation 'com.github.1079374315:GSLS_Tool:v1.3.0.6'//如果不需要使用全部功能，可以只添加GT基础依赖。
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

Licensed under the Apache License, Version 1.3.0.5 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   https://github.com/1079374315/GSLS_Tool/tree/master

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
````
