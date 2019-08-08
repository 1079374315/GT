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



[GT 的依赖 （第一章）：正确的使用姿势](http://#)

[GT 使用的 log 教程（第二章）：正确的使用姿势](http://#)

[GT 待更新 ......](https://#)


# 如何使用
### 注意：以下为androidx的使用方式，如果使用的是android.support包，[点击这里`master`分支](https://#)
**1. 项目下app的build.gradle中依赖：**

````gradle
Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
Step 2. Add the dependency
dependencies {
	        implementation 'com.github.1079374315:GT:v1.0.1'
	}
````

## [进一步使用、ChangeLog，查看wiki](https://#)

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
