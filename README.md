[![CSDN](https://img.shields.io/badge/Android%20Arsenal-Fragmentation-brightgreen.svg?style=flat)](https://blog.csdn.net/qq_39799899)
[![Github](https://travis-ci.org/YoKeyword/Fragmentation.svg?branch=master)](https://github.com/1079374315)


# 最新版本: 1.0.2
发布时间：2019年8月8日 星期四 22:22

最后更新类： GT_Fragment

添加了 BaseFragments 基类，用于辅助 单 Activity 对多 Fragment 开发
添加了 BaseDialogFragments 基类	用于辅助 开发
[使用教程请参关注楼主博客](https://blog.csdn.net/qq_39799899)

![](/gif/logo.png)


为了更好的使用该库，推荐阅读下面的文章:



[GT 的依赖 （第一章）：正确的使用姿势](http://www.jianshu.com/p/d9143a92ad94)

[GT 使用的 log 教程（第二章）：正确的使用姿势](http://www.jianshu.com/p/fd71d65f0ec6)

[GT 待更新 ......](https://github.com/1079374315/GT/tree/master)


# 如何使用
### 注意：以下为androidx的使用方式，如果使用的是android.support包，[点击这里`master`分支](https://github.com/YoKeyword/Fragmentation/blob/master/README_CN.md)
**1. 项目下app的build.gradle中依赖：**

````gradle
// 以下为androidx的使用方式，如果使用的是android.support包，fragmentationx -> fragmentation 即可
implementation 'me.yokeyword:fragmentationx:1.0.1'

// 如果不想继承SupportActivity/Fragment，自己定制Support，可仅依赖:
// implementation 'me.yokeyword:fragmentationx-core:1.0.1'

// 如果想使用SwipeBack 滑动边缘退出Fragment/Activity功能，完整的添加规则如下：
implementation 'me.yokeyword:fragmentationx:1.0.1'
// swipeback基于fragmentation, 如果是自定制SupportActivity/Fragment，则参照SwipeBackActivity/Fragment实现即可
implementation 'me.yokeyword:fragmentationx-swipeback:1.0.1'

// Activity作用域的EventBus，通信更安全
implementation 'me.yokeyword:eventbus-activity-scope:1.1.0'
// Your EventBus's version
implementation 'org.greenrobot:eventbus:{version}'
````

**2. Activity `extends` SupportActivity或者 `implements` ISupportActivity：(实现方式可参考[MySupportActivity](https://github.com/YoKeyword/Fragmentation/blob/master/demo/src/main/java/me/yokeyword/sample/demo_flow/base/MySupportActivity.java))**
````java
// v1.0.0开始，不强制继承SupportActivity，可使用接口＋委托形式来实现自己的SupportActivity
public class MainActivity extends SupportActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(...);
        // 建议在Application里初始化
        Fragmentation.builder()
             // 显示悬浮球 ; 其他Mode:SHAKE: 摇一摇唤出   NONE：隐藏
             .stackViewMode(Fragmentation.BUBBLE)
             .debug(BuildConfig.DEBUG)
             ... // 更多查看wiki或demo
             .install();

        if (findFragment(HomeFragment.class) == null) {
            loadRootFragment(R.id.fl_container, HomeFragment.newInstance());  // 加载根Fragment
        }
    }
````

**3. Fragment `extends` SupportFragment或者 `implements` ISupportFragment：(实现方式可参考[MySupportFragment](https://github.com/YoKeyword/Fragmentation/blob/master/demo/src/main/java/me/yokeyword/sample/demo_flow/base/MySupportFragment.java))：**
````java
// v1.0.0开始，不强制继承SupportFragment，可使用接口＋委托形式来实现自己的SupportFragment
public class HomeFragment extends SupportFragment {

    private void xxx() {
        // 启动新的Fragment, 另有start(fragment,SINGTASK)、startForResult、startWithPop等启动方法
? ? ? ? start(DetailFragment.newInstance(HomeBean));
        // ... 其他pop, find, 设置动画等等API, 请自行查看WIKI
? ? }
}
````

## [进一步使用、ChangeLog，查看wiki](https://github.com/YoKeyword/Fragmentation/wiki)

## LICENSE
````
Copyright 2019 GSLS

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   https://github.com/1079374315/GT/tree/master

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
````
