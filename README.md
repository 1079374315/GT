[![GitHub Versions](https://github.com/jedisct1/libsodium/workflows/CI/badge.svg)](https://github.com/1079374315/GSLS_Tool/tags)
[![CSDN](https://img.shields.io/badge/Android%20Arsenal-Fragmentation-brightgreen.svg?style=flat)](https://blog.csdn.net/qq_39799899)
[![](https://jitpack.io/v/1079374315/GSLS_Tool.svg)](https://jitpack.io/#1079374315/GSLS_Tool)

<img src="https://csdnimg.cn/medal/linkedin@240.png"  width="40px"><img src="https://csdnimg.cn/medal/github@240.png"  width="40px"><img src="https://csdnimg.cn/medal/maimai@240.png"  width="40px"><img src="https://csdnimg.cn/medal/qiandao10@240.png"  width="40px"><img src="https://csdnimg.cn/medal/yuedu3@240.png"  width="40px"><img src="https://csdnimg.cn/medal/chizhiyiheng@240.png"  width="40px"><img src="https://csdnimg.cn/medal/1024@240.png"  width="40px"><img src="https://csdnimg.cn/medal/qixiebiaobing4@240.png"  width="40px"><img src="https://csdnimg.cn/medal/yuanli_xuexili@240.png"  width="40px"><img src="https://csdnimg.cn/medal/yuanli_xinren@240.png"  width="40px"><img src="https://csdnimg.cn/medal/yuanli_tansuoS@240.png"  width="40px"><img src="https://csdnimg.cn/medal/fenxiangjingying@240.png"  width="40px">

# <a href="https://blog.csdn.net/qq_39799899"><img src="http://gsls.hkfree.work/Servers/img/GT/logo.png"  width="200px">[GT库源码](https://github.com/1079374315/GSLS_Tool)</a>
#### [关注我，查找更简单(*￣︶￣)](https://blog.csdn.net/qq_39799899)
#### [需要修改源码，请戳这里](https://blog.csdn.net/qq_39799899/article/details/127358406?spm=1001.2014.3001.5501)
#### [gt-DataBinding-更新详情](http://gsls.hkfree.work/Servers/index.html)

# 最新版本: v1.4.6.8
发布时间：2024.12.28 (抢先体验版)

# GT库官方群1: 814506562
````
为了方便GT库友们：
一起交流，一起贡献开源技术
希望在库友们的共同的努力下，
将我们开源GT库建设的越好用、越稳定。
致谢语：
非常感谢一路以来支持GT库的伙伴们，
因为GT库覆盖的技术方面太广涉及代码量太多，一人之力难以全面维护好，
所以在此创建 GT库官方群1 集齐GT友集体智慧，将库建设成为更好更全更稳定的库。
贡献名单：(贡献多者麻烦找我要个管理位，对GT库有疑惑的请发群里或请联系管理大大)
GSLS - 1号贡献者
1杯冰半糖 - 2号贡献者
待添加....
````


# 此次版本更新：
````
 * 更新内容如下：
 * 1.增强App工具类，并将跳转工具类 更名为 JumpUtils
 * 2.新增 视频播放器 辅助类GT_VideoView
 * 3.新增 算法类 Algorithm(后面会慢慢收集算法)
 * 4.优化数据库保存map时的问题，新增 @GT_table 为映射表的标识
 * 5.适配 Kotlin的 data 类型的数据表映射
 * 6.解决在启动旧 Fragment 后调用的show 特殊情况下会调用失败的问题
 * 7.悬浮窗优化：(默认悬浮窗是 桌面级)
 * (1)桌面级悬浮窗：可在Android桌面和各种App之上显示 (缺点，无法在系统设置页面显示)
 * (2)绑定 Activity 层级悬浮窗 ：悬浮窗 根据当前寄生的Activity进行显示和隐藏
 * (3)绑定 无障碍 层级悬浮窗：几乎所有界面都能显示包括系统设置界面。
````

## 为了更好的使用该库，推荐阅读下面的文章:
### [GT库官方教程入口](https://blog.csdn.net/qq_39799899/article/details/119696907)

#### [第1章：集成GT库 (推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/120165435?spm=1001.2014.3001.5502)(集成GT库成功！！！)
#### [第2章：日志log类(推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/128497267?spm=1001.2014.3001.5502)(可以让你轻轻松松找到日志处)
#### [第3章：吐司类   (推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t5)(轻松自定义吐司)
#### [第4章：DataSendReception(新品指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t10)(跨APP/跨进程/收发消息)
#### [第5章：SaveObject (推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t12)(数据永久性存储池)
#### [第6章：GT_SharedPreferences(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t13)(可存储实体类的SP)
#### [第7章：GT_IO(推荐指数：✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t16)(内部 IO 流存储)
#### [第8章：FileUtils(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t20)(轻轻松松自定义可视文件组件)
#### [第9章：Hibernate(热度推荐：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/105935756?spm=1001.2014.3001.5502)(对原生SQLite数据库的封装)
#### [第10章：CleanDataUtils(推荐指数：✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t25)(管理手机数据)
#### [第11章：GT_Random(推荐指数：✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t26)(随机类)
#### [第12章：SerialPortUtils(新品指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t27)(串口类，无需增添第三文件，可直接构建使用！！！)
#### [第13章：DataUtils(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t28)(数据格式装换类)
#### [第14章：Network(推荐指数：✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t30)(网络类用于判断是否可联网，获取P地址等...)
#### [第15章：JSON(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t31)(json 与 Bean 互转)
#### [第16章：HttpUtil与HttpCall(推荐指数：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/125697371?spm=1001.2014.3001.5501)(超简单实用的网络请求框架)
#### [第17章：WebViewUtils(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t34)(轻松加载APP、PC网页、拔网页代码)
#### [第18章：GT_Date(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t41)(强大的日期工具包)
#### [第19章：ScreenOperation(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t43)(手机屏幕操作)
#### [第20章：ApplicationUtils(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t45)(小工具包)
#### [第21章：UpdateApp(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t48)(下载APP并自动安装)
#### [第22章：RepairAPP(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t51)(APP热更新：悄无声息的解决线上bug)
#### [第23章：BaseArrayAdapters(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t55)(针对与 ArrayAdapter 进行封装)
#### [第24章：BaseAdapter(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t56)(针对与 RecyclerView.Adapter 进行封装)
#### [第25章：Encryption(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t60)(加密工具包)
#### [第26章：ProgressDialogUtils(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t66)(多种加载进度条)
#### [第27章：GT_Animation(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t73)(强大的GT动画库)
#### [第28章：WindowUtils(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t75)(WindowUtils 窗体类，封装了APP窗口类工具)
#### [第29章：ViewUtils(推荐指数：✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t78)(自定义View工具集合，可直接添加到xml 布局文件中)
#### [第30章：GT_Activity(推荐指数：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t80)(封装 Activity 管理器)
#### [第31章：GT_Fragment(推荐指数：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t84)(封装 Fragment 管理器)
#### [第32章：GT_Dialog(推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t92)(9种简易对话框)
#### [第33章：GT_DialogFragment(推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119999987?spm=1001.2014.3001.5502)(9种简易对话框)
#### [第34章：GT_FloatingWindow(推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/120470961?spm=1001.2014.3001.5502)(超简单的DialogFragment)
#### [第35章：设备监听类 DeviceListening(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t107)(手机设备的监听)
#### [第36章：多媒体类(推荐指数：✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t109)(手机设备的音乐、音频，视频等)
#### [第37章：GT注解(推荐指数：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t116)(GT高级使用方法)
#### [第38章：GT线程(推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t120)(容易上瘾，请勿上头)
#### [第39章：Permission(新品推荐：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t121)(超级简单且轻量级的动态授权框架)
#### [第40章：GT黑科技(新品指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t123)(黑科技会越来越多，重点发展路线)
###### [黑科技1号：超简单无障碍服务-自带基础寻找组件工具包(新品指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/119696907?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22119696907%22%2C%22source%22%3A%22qq_39799899%22%7D#t124)
#### [第41章：GT-DataBinding(新品指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/121270536?spm=1001.2014.3001.5502)(彻底解放 findViewById)
#### [第42章：GT-MVVM架构(新品推荐：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/127093032?spm=1001.2014.3001.5501)(超简单GT_MVVM入门系列)
#### [第43章：GT-EventBus(新品推荐：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/123871288?spm=1001.2014.3001.5501)(解决数据传递框架,支持跨进程传递)
#### [第44章：GT-Observable(新品推荐：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/123982353?spm=1001.2014.3001.5501)(异步线程切换框架)
#### [第45章：GT-Glide(新品推荐：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/125692488?spm=1001.2014.3001.5501)(加载图片，支持动态图)
#### [第46章：GT-GT_Notification(新品推荐：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/127001248?spm=1001.2014.3001.5501)(轻松自定义 酷狗音乐播放状态栏)
#### [第47章：GT-WebViews(新品推荐：✪✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/127265708?spm=1001.2014.3001.5501)(安卓与H5交互，可支持侵入式开发)
#### [第48章：GT_View(推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/127268713?spm=1001.2014.3001.5501)(自定义底部弹窗支付页面)
#### [第49章：GT_Notification(推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/127001248?spm=1001.2014.3001.5502)(8种通知栏,有酷狗通知栏源码)
#### [第52章：GT_MVVM(推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/127093032?spm=1001.2014.3001.5502)(懒人必备框架-MVVM)
#### [第51章：GT_WebView(推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/127265708?csdn_share_tail=%7B%22type%22%3A%22blog%22%2C%22rType%22%3A%22article%22%2C%22rId%22%3A%22127265708%22%2C%22source%22%3A%22qq_39799899%22%7D)(Android H5 混合开发)
#### [第52章：GT-Res(推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/131027023?spm=1001.2014.3001.5501#t4)(GT库资源获取)
#### [第53章：GT.ARouter(推荐指数：✪✪✪✪✪)](https://blog.csdn.net/qq_39799899/article/details/135116489?spm=1001.2014.3001.5501)(GT库路由解析)



# 如何使用
### 注意：以下为android-Java的使用方式
**1. 项目下app的build.gradle中依赖：**

````gradle
第一步 1. 将以下存储库将其添加到根构建中。存储库末尾的 settings.gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven { url 'https://jitpack.io' }//必要的
	//新版的AS 用法: maven { url = uri("https://jitpack.io") }
    }
}
	
第二步 2. 添加依赖关系
dependencies {

	//旧版的AS 常规版 依赖方式：
	implementation 'com.github.1079374315:GSLS_Tool:v1.4.6.8'//GT基础功能(必要的)
        annotationProcessor 'com.github.1079374315:GSLS_Tool:v1.4.6.8'//使用 gt-DataBinding 才需要添加以下注册,否则可以不添加

	//新版的AS build.gradle.kts 依赖方式：
	//implementation("com.github.1079374315:GSLS_Tool:v1.4.6.8")
	//annotationProcessor("com.github.1079374315:GSLS_Tool:v1.4.6.8")

	//同步后如果出现 ：The number of method references in a .dex file cannot exceed 64K. 错误，
	//请参考该篇文章解决错误：https://blog.csdn.net/qq_39799899/article/details/120165435?spm=1001.2014.3001.5501
}
````

### 注意：以下为android-Kotlin的使用方式
**1. 项目下app的build.gradle中依赖：**

````gradle
第一步 1. 将以下存储库将其添加到根构建中。存储库末尾的 settings.gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven { url 'https://jitpack.io' }//必要的
       //新版的AS 用法: maven { url = uri("https://jitpack.io") }
    }
}
	
第二步 2. 添加依赖关系
dependencies {

	//旧版的AS 常规版 依赖方式：
	implementation 'com.github.1079374315:GSLS_Tool:v1.4.6.8' //GT基础功能(必要的)
        kapt 'com.github.1079374315:GSLS_Tool:v1.4.6.8'//使用 gt-DataBinding 才需要添加以下注册,否则可以不添加

	//新版的AS build.gradle.kts 依赖方式：
	//implementation("com.github.1079374315:GSLS_Tool:v1.4.6.8")
	//kapt("com.github.1079374315:GSLS_Tool:v1.4.6.8")
	
	//同步后如果出现 ：The number of method references in a .dex file cannot exceed 64K. 错误，
	//请参考该篇文章解决错误：https://blog.csdn.net/qq_39799899/article/details/120165435?spm=1001.2014.3001.5501
}

注意：如需要使用 gt-DataBinding 才需要加上第三步，否则可不加
第三步 3. 在 build.gradle(app模块中) 引入 'kotlin-kapt'
plugins {
    ...
    id 'kotlin-kapt'  //新版 kotlin("kapt")
}

注意：如果运行编译出现 "task (current target is 1.8) and 'kaptGenerateStubsDebugKotlin' task (current target is 17) jvm" 问题，
可直接在 build.gradle(app模块中) 添加以下关系来解决:
android {
    ...
    tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile.class){
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
 
}


````

**2. 出现以下问题，请直接进入传送门进行参考解决：** [传送门](https://blog.csdn.net/qq_39799899/article/details/120165435?spm=1001.2014.3001.5502)
````gradle
1.依赖GT库详情
2.kotlin中使用 gt-DataBinding 所遇见的问题
3.注解ID 资源爆红的问题
4.同步后如果出现 ：The number of method references in a .dex file cannot exceed 64K
5.待发现与更新中....
````


**3. GT包混淆：** [整体项目混淆参考【请戳我】](https://github.com/1079374315/GSLS_Tool/blob/master/gt/proguard-rules.pro)

````gradle
#不混淆GT类
#-keep public class com.gsls.gt.GT { *; }
-keep class com.gsls.** { *; }
#不混淆 继承GT类 或 继承GT内部类 的类
-keep public class * extends com.gsls.gt.GT { *; }
-keep public class * extends com.gsls.gt.GT$* { *; }
-keep public class * extends com.gsls.gtk.GTK { *; }
-keep public class * extends com.gsls.gtk.GTK$* { *; }

## 其余的看情况混淆

````

