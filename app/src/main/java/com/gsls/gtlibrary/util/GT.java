package com.gsls.gtlibrary.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.lzy.okgo.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import static com.lzy.okgo.utils.HttpUtils.runOnUiThread;


/**
 * 工具类说明：
 * GSLS_Tool
 * <p>
 * //GT 须依赖的包：
 * implementation 'com.google.code.gson:gson:2.8.5'         //JSON 数据解析
 * implementation 'com.lzy.net:okgo:3.0.4'                  //OkGo 网络框架
 * implementation 'com.squareup.okhttp3:okhttp:3.12.0'      //OkHttp 网络框架
 * implementation 'com.github.bumptech.glide:glide:4.9.0'   //加载图片的 glide
 * implementation 'org.jsoup:jsoup:1.10.3'                  //Jsoup格式化html数据
 * <p>
 * <p>
 * <p>
 * <p>
 * 更新时间:2019.8.27
 * <p>
 *
 * 更新内容：（1.0.4版本 大更新）
 * 1.修复 调用 GT.Game.startGameWindow(); 时出现的问题。
 * 2.更新 AlertDialog 类中设置全屏的方法。
 * 3.新增 GT 注解注入 具体使用 请参考官网
 * 4.新增 BaseActivity、AnnotationActivity 类 具体使用 请参考官网
 *
 * <p>
 * <p>
 * <p>
 * 小提示：(用于 AndroidStudio )
 * 收起所有的 方法: Ctrl + Shift +  - (减号)
 * 展开所有的 方法: Ctrl + Shift +  + (加号)
 */

@SuppressWarnings("unchecked")
public class GT {

    //================================== 所有属于 GT 类的属性 =======================================

    @SuppressLint("StaticFieldLeak")
    private static GT gt = null;                 //定义 GT 对象
    private static boolean LOG_TF = true;        //控制外部所有的 Log 显示
    private static boolean GT_LOG_TF = false;    //控制内部所有的 Log 显示
    private static boolean TOAST_TF = true;      //控制外部所有的 toast 显示
    private static boolean GT_TOAST_TF = false;  //控制内部所有的 toast 显示
    private boolean isAnnotation = true;         //默认加载注解
    private Context CONTEXT;                     //设置 当前动态的 上下文对象


    //================================== 提供访问 GT 属性的接口======================================

    private GT() {
    }//设置不可实例化

    /**
     * 获取线程安全的 GT 单例对象
     *
     * @return GT  返回 GT 对象
     */
    public static GT getGT() {
        if (gt == null) {
            synchronized (GT.class) {
                if (gt == null) {
                    gt = new GT();
                }
            }
        }
        return gt;
    }

    /**
     * 获取 Context
     *
     * @return
     */
    public Context getCONTEXT() {
        return CONTEXT;
    }

    /**
     * 获取控制外部所有的 Log 显示
     *
     * @return boolean 返回当前日志提示是否开启
     */
    public Boolean getLogTf() {
        return LOG_TF;
    }

    /**
     * 设置 外部 日志是否开启
     *
     * @param logTf true 为开启 false 为关闭 默认为 true
     */
    public void setLogTf(Boolean logTf) {
        LOG_TF = logTf;
    }

    /**
     * 控制外部所有的 toast 显示 获取与设置
     *
     * @return boolean 返回 toast 是否开启的状态
     */
    public Boolean getToastTf() {
        return TOAST_TF;
    }

    /**
     * 设置 Toast 是否开启
     *
     * @param toastTf true 为开启 false 为关闭
     */
    public void setToastTf(Boolean toastTf) {
        TOAST_TF = toastTf;
    }

    /**
     * 为外部提供访问 GT Context 接口
     *
     * @param CONTEXT
     */
    public void build(Context CONTEXT) {
        this.CONTEXT = CONTEXT;
        initGTUtilActivity();//初始化 GT 必要的工具
    }

    /**
     * 为外部提供访问 GT Context 接口
     *
     * @param object
     * @param view
     */
    public void build(Object object, View view) {
        initGTUtilFragment(object, view);//初始化 GT 必要的工具
    }

    /**
     * 获取GT类内部的日志是否开启状态
     *
     * @return Boolean true 为开启 false 为关闭
     */
    public Boolean getGtLogTf() {
        return GT_LOG_TF;
    }

    /**
     * 设置 GT 类内部日志是否开启
     *
     * @param gtLogTf true 为开启 false 为关闭
     */
    public void setGtLogTf(Boolean gtLogTf) {
        GT_LOG_TF = gtLogTf;
    }

    /**
     * 获取 GT 类 内部Toast 是否开启
     *
     * @return true 为开启 false 为关闭
     */
    public Boolean getGtToastTf() {
        return GT_TOAST_TF;
    }

    /**
     * 设置 GT 类内部 Toast 是否显示
     *
     * @param gtToastTf true 为开启 false 为关闭
     */
    public void setGtToastTf(Boolean gtToastTf) {
        GT_TOAST_TF = gtToastTf;
    }

    /**
     * 返回当前 是否加载注解
     *
     * @return
     */
    public boolean isAnnotation() {
        return isAnnotation;
    }

    /**
     * 设置是否加载注解
     *
     * @param annotation
     */
    public void setAnnotation(boolean annotation) {
        isAnnotation = annotation;
    }

    //============================================= 加载 GT 必要的工具 =============================

    //初始化 GT 必要的工具 主要用于  Activity 的页面
    private void initGTUtilActivity() {
        //是否加载注解
        if (isAnnotation) {
            AnnotationAssist.initAll((Activity) CONTEXT); //初始化 IOC 注解
        }
    }

    //初始化 GT 必要的工具  主要用于 非 Activity 的页面 如：Fragment、DialogFragment 等页面
    private void initGTUtilFragment(Object object, View view) {
        //是否加载注解
        if (isAnnotation) {
            AnnotationAssist.initAll(object, view); //初始化 IOC 注解
        }
    }

    //============================================= 提示类 =========================================

    /**
     * 提示消息 Log
     *
     * @param msg object 类型的消息
     */
    public static void log_v(Object msg) {
        if (LOG_TF) {
            Log.v("GT_v", "------- " + msg);
        }
    }

    /**
     * 提示消息 Log
     *
     * @param msg object 类型的消息
     */
    public static void log_d(Object msg) {
        if (LOG_TF) {
            Log.d("GT_d", "------- " + msg);
        }
    }

    /**
     * 提示消息 Log
     *
     * @param msg object 类型的消息
     */
    public static void log_i(Object msg) {
        if (LOG_TF) {
            Log.i("GT_i", "------- " + msg);
        }
    }

    /**
     * 提示消息 Log
     *
     * @param msg object 类型的消息
     */
    public static void log_w(Object msg) {
        if (LOG_TF) {
            Log.w("GT_w", "------- " + msg);
        }
    }

    /**
     * 提示消息 Log
     *
     * @param msg object 类型的消息
     */
    public static void log_e(Object msg) {
        if (LOG_TF) {
            Log.e("GT_e", "------- " + msg);
        }
    }

    /**
     * 提示消息 Log
     *
     * @param title 日志标题
     * @param msg   日志消息
     */
    public static void log_v(Object title, Object msg) {
        if (LOG_TF) {
            Log.v("GT_v",
                    "------- Run" +
                            "\n\n---------------------" + title + "------------------------\n" +
                            "                   " + msg + "\n" +
                            "---------------------" + title + "-----------------------\n\n" +
                            "------- Close"
            );
        }

    }

    /**
     * 提示消息 Log
     *
     * @param title 日志标题
     * @param msg   日志消息
     */
    public static void log_d(Object title, Object msg) {
        if (LOG_TF) {
            Log.d("GT_d",
                    "------- Run" +
                            "\n\n---------------------" + title + "------------------------\n" +
                            "                   " + msg + "\n" +
                            "---------------------" + title + "-----------------------\n\n" +
                            "------- Close"
            );
        }

    }

    /**
     * 提示消息 Log
     *
     * @param title 日志标题
     * @param msg   日志消息
     */
    public static void log_i(Object title, Object msg) {
        if (LOG_TF) {
            Log.i("GT_i",
                    "------- Run" +
                            "\n\n---------------------" + title + "------------------------\n" +
                            "                   " + msg + "\n" +
                            "---------------------" + title + "-----------------------\n\n" +
                            "------- Close"
            );
        }

    }

    /**
     * 提示消息 Log
     *
     * @param title 日志标题
     * @param msg   日志消息
     */
    public static void log_w(Object title, Object msg) {
        if (LOG_TF) {
            Log.w("GT_w",
                    "------- Run" +
                            "\n\n---------------------" + title + "------------------------\n" +
                            "                   " + msg + "\n" +
                            "---------------------" + title + "-----------------------\n\n" +
                            "------- Close"
            );
        }

    }

    /**
     * 提示消息 Log
     *
     * @param title 日志标题
     * @param msg   日志消息
     */
    public static void log_e(Object title, Object msg) {
        if (LOG_TF) {
            Log.e("GT_e",
                    "------- Run" +
                            "\n\n---------------------" + title + "------------------------\n" +
                            "                   " + msg + "\n" +
                            "---------------------" + title + "-----------------------\n\n" +
                            "------- Close"
            );
        }

    }

    /**
     * 报错提示 该提示可通过 GT 提供的接口 的实例获取
     *
     * @return String 报错的文件与行号
     */
    public String getLineInfo() {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        return "报错的文件  " + ste.getFileName() + "  行号 " + ste.getLineNumber();
    }

    /**
     * 单个消息框 Toast
     *
     * @param msg object 类型的消息
     */
    public static void toast_s(Object msg) {
        if (TOAST_TF) {
            if (getGT().CONTEXT != null) {
                Toast.makeText(getGT().CONTEXT, String.valueOf(msg), Toast.LENGTH_SHORT).show();
            } else {
                if (LOG_TF)//设置为默认输出日志
                    log_e("GT_bug", "消息框错误日志：你没有为 Context 进行赋值 ，却引用了 Toast 导致该功能无法实现。解决措施 在调用 toast 代码之前添加：GT.getGT().setCONTEXT(activity);");
            }

        }
    }

    /**
     * 单个 Toast
     *
     * @param msg  消息
     * @param time 显示时间
     */
    public static void toast_time(Object msg, long time) {
        if (TOAST_TF) {
            if (getGT().CONTEXT != null) {
                final Toast toast = Toast.makeText(getGT().CONTEXT, String.valueOf(msg), Toast.LENGTH_LONG);
                final Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        toast.show();
                    }
                }, 0, 3000);
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        toast.cancel();
                        timer.cancel();
                    }
                }, time);
            } else {
                if (LOG_TF)//设置为默认输出日志
                    log_e("GT_bug", "消息框错误日志：你没有为 Context 进行赋值 ，却引用了 Toast 导致该功能无法实现。解决措施 在调用 toast 代码之前添加：GT.getGT().setCONTEXT(activity);");
            }

        }
    }

    /**
     * 可多个消息框 Toast
     *
     * @param context 上下文
     * @param msg     object 类型的消息
     */
    public static void toast_s(Context context, Object msg) {
        if (TOAST_TF)
            Toast.makeText(context, String.valueOf(msg), Toast.LENGTH_SHORT).show();
    }

    /**
     * 可多个消息框 Toast
     *
     * @param context 上下文
     * @param msg     object 类型的消息
     */
    public static void toast_time(Context context, Object msg, int time) {
        if (TOAST_TF) {
            final Toast toast = Toast.makeText(context, String.valueOf(msg), Toast.LENGTH_LONG);
            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    toast.show();
                }
            }, 0, 3000);
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    toast.cancel();
                    timer.cancel();
                }
            }, time);

        }
    }

    /**
     * Toast 自定义 View
     */
    public static class ToastView {

        private static Toast toast;
        private View view;

        public Toast getToast() {
            return toast;
        }

        public void ShowToast() {
            toast.show();
        }


        public View getView() {
            return view;
        }


        /**
         * @param layout 布局
         * @return
         */
        public ToastView initLayout(int layout) {
            if (TOAST_TF) {
                if (getGT().CONTEXT != null) {
                    view = LayoutInflater.from(getGT().CONTEXT).inflate(layout, null);
                    toast = new Toast(getGT().CONTEXT);
                    toast.setView(view);
                } else {
                    if (LOG_TF) {//设置为默认输出日志
                        log_e("GT_bug", "消息框错误日志：你没有为 Context 进行赋值 ，却引用了 Toast 导致该功能无法实现。解决措施 在调用 toast 代码之前添加：GT.getGT().setCONTEXT(activity);");
                    }
                }
            }
            return this;
        }

        public ToastView initLayout(int layout, Context context) {
            if (TOAST_TF) {
                if (context != null) {
                    view = LayoutInflater.from(context).inflate(layout, null);
                    toast = new Toast(context);
                    toast.setView(view);
                } else {
                    if (LOG_TF) {//设置为默认输出日志
                        log_e("GT_bug", "消息框错误日志：你没有为 Context 进行赋值 ，却引用了 Toast 导致该功能无法实现。解决措施 在调用 toast 代码之前添加：GT.getGT().setCONTEXT(activity);");
                    }
                }
            }
            return this;
        }

        /**
         * @param layout  布局
         * @param Gravity Gravity.*****  用这个变量里面的值可以控制显示位置 如果为 0 就显示默认位置
         * @return
         */
        public ToastView initLayout(int layout, int Gravity) {

            if (TOAST_TF) {
                if (getGT().CONTEXT != null) {
                    view = LayoutInflater.from(getGT().CONTEXT).inflate(layout, null);
                    toast = new Toast(getGT().CONTEXT);
                    if (Gravity != 0)
                        toast.setGravity(Gravity, 0, 0);
                    toast.setView(view);
                } else {
                    if (LOG_TF) {//设置为默认输出日志
                        log_e("GT_bug", "消息框错误日志：你没有为 Context 进行赋值 ，却引用了 Toast 导致该功能无法实现。解决措施 在调用 toast 代码之前添加：GT.getGT().setCONTEXT(activity);");
                    }
                }
            }
            return this;
        }


        public ToastView initLayout(int layout, int Gravity, Context context) {

            if (TOAST_TF) {
                if (context != null) {
                    view = LayoutInflater.from(context).inflate(layout, null);
                    toast = new Toast(context);
                    if (Gravity != 0)
                        toast.setGravity(Gravity, 0, 0);
                    toast.setView(view);
                } else {
                    if (LOG_TF) {//设置为默认输出日志
                        log_e("GT_bug", "消息框错误日志：你没有为 Context 进行赋值 ，却引用了 Toast 导致该功能无法实现。解决措施 在调用 toast 代码之前添加：GT.getGT().setCONTEXT(activity);");
                    }
                }
            }
            return this;
        }


    }


    /**
     * AlertDialog.Builder 对话框类
     */
    public static class GT_AlertDialog extends AlertDialog.Builder {

        /**
         * 初始化 上下文
         *
         * @param context
         */
        public GT_AlertDialog(Context context) {
            super(context);
        }

        /**
         * 设置按钮的对话框
         *
         * @param img             图标
         * @param title           标题
         * @param message         信息
         * @param btnName         第一个按钮名称
         * @param onClickListener 单击事件
         * @return 返回对话框操作对象
         */
        public AlertDialog.Builder dialogButton(int img, String title, String message, String btnName, DialogInterface.OnClickListener onClickListener) {
            setTitle(title).setIcon(img).setMessage(message);   //设置 标题、图标、消息
            if (btnName != null && onClickListener != null) {
                setNegativeButton(btnName, onClickListener);//设置单击事件
            }
            return this;
        }

        /**
         * 设置列表选项对话框
         * @param img       图标
         * @param title     标题
         * @param texts     类表项
         * @return 返回对话框对象
         */
        /**
         * @param img             图标
         * @param title           标题
         * @param items           类表项
         * @param onClickListener 单击事件
         * @return
         */
        public AlertDialog.Builder dialogList(int img, String title, final String[] items, DialogInterface.OnClickListener onClickListener) {
            setIcon(img).setTitle(title);
            if (items != null && onClickListener != null)
                setItems(items, onClickListener); //添加列表项
            return this;
        }

        /**
         * 设置单选列表选项对话框
         *
         * @param img             图标
         * @param title           标题
         * @param item            列表项
         * @param onClickListener 单击事件
         * @return 返回对话框对象
         */
        public AlertDialog.Builder dialogSingleChoiceList(int img, String title, String[] item, DialogInterface.OnClickListener onClickListener) {
            setIcon(img).setTitle(title);
            if (item != null && onClickListener != null)
                setSingleChoiceItems(item, 0, onClickListener);//设置按钮
            return this;
        }

        /**
         * 设置多选列表对话框
         *
         * @param img             图标
         * @param title           标题
         * @param items           列表
         * @param onClickListener 单击事件
         * @return 返回对话框对象
         */
        public AlertDialog.Builder dialogMultiChoice(int img, String title, final String[] items, DialogInterface.OnMultiChoiceClickListener onClickListener) {

            final boolean[] checkedItems = new boolean[items.length];   //初始化选中状态

            for (int i = 0; i < checkedItems.length; i++) {
                checkedItems[i] = false;   //初始化默认选项
            }
            setIcon(img).setTitle(title);//设置 图标、标题
            if (checkedItems != null && items != null && onClickListener != null)
                setMultiChoiceItems(items, checkedItems, onClickListener);
            return this;
        }

        /**
         * 自定义的 Dialog
         */
        public static class ViewDialog {

            private Dialog dialog;
            private View view;

            public Dialog getDialog() {
                return dialog;
            }

            public View getView() {
                return view;
            }

            /**
             * 设置 ViewDialog 全屏 该方法需要在 show() 方法之后调用
             *
             * @param activity
             * @return 用法如下：
             * GT.GT_AlertDialog.ViewDialog viewDialog = new GT.GT_AlertDialog.ViewDialog()
             * .initLayout(activity, R.layout.item_load, R.style.dialogNoBg, true, -1, 0, 0);
             * viewDialog.getDialog().show();
             * viewDialog.allWindow(activity);//放到此处
             */
            public ViewDialog allWindow(Activity activity) {
                WindowManager windowManager = activity.getWindowManager();
                Display display = windowManager.getDefaultDisplay();
                WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
                lp.width = display.getWidth(); //设置宽度
                lp.height = display.getHeight(); //设置宽度
                dialog.getWindow().setAttributes(lp);
                return this;
            }

            /**
             * @param context 上下文
             * @param layout  布局
             * @return
             */
            public ViewDialog initLayout(Context context, int layout) {
                dialog = new Dialog(context);
                view = LayoutInflater.from(context).inflate(layout, null);
                dialog.setContentView(view);
                return this;
            }

            /**
             * @param context 上下文
             * @param layout  布局
             * @param Style   设置样式
             * @return
             */
            public ViewDialog initLayout(Context context, int layout, int Style) {
                dialog = new Dialog(context);
                dialog = new Dialog(context, Style);
                view = LayoutInflater.from(context).inflate(layout, null);
                dialog.setContentView(view);
                return this;
            }

            /**
             * @param context       上下文
             * @param Style         样式
             * @param clickExternal 外部是否可点击
             * @param layout        布局
             * @param transparency  透明度
             * @param X             显示的 X 轴位置
             * @param Y             显示的 Y 轴位置
             * @return 当前类的对象
             * <p>
             * style 样式 参考：
             * <style name="dialogNoBg">
             * <item name="android:background">#00000000</item>
             * <item name="android:windowBackground">@android:color/transparent</item>
             * <item name="android:windowNoTitle">true</item>
             * <item name="android:windowFullscreen">true</item>
             * <item name="android:windowIsFloating">true</item>
             * </style>
             */
            public ViewDialog initLayout(Context context, int layout, int Style, boolean clickExternal, int transparency, int X, int Y) {

                if (Style != 0)
                    dialog = new Dialog(context, Style);
                else
                    dialog = new Dialog(context);

                dialog.setCancelable(clickExternal);       //设置点击外面不会消失 true为点击外面可以被取消，false 为点击外面不可被取消

                view = LayoutInflater.from(context).inflate(layout, null);
                dialog.setContentView(view);

                if (transparency != -1)
                    dialog.getWindow().setDimAmount(transparency);//设置昏暗度为0 则表示为透明， 如果是 -1 则是默认

                //修改 自定义对话框的显示位置
                android.view.Window dialogWindow = dialog.getWindow();//随意定义个Dialog
                WindowManager.LayoutParams lp = dialogWindow.getAttributes();//实例化Window
                //实例化Window操作者
                lp.x = X; // 新位置X坐标
                lp.y = Y; // 新位置Y坐标
                dialogWindow.setAttributes(lp);

                return this;
            }

        }

        /**
         * 加载自定义的 对话框 自带去掉边框
         */
        public static abstract class Loading_view extends ProgressDialog {

            public Loading_view(Context context) {
                super(context);
            }

            public Loading_view(Context context, int theme) {
                super(context, theme);
            }

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                init(getContext());
            }

            /**
             * 加载布局
             *
             * @param context
             */
            protected abstract void loadLayout(Context context);

            /**
             * 初始化布局
             *
             * @return
             */
            public abstract int initLayout();

            private void init(Context context) {
                setCancelable(true);
                setCanceledOnTouchOutside(false);
                setContentView(initLayout());//loading的xml文件

                loadLayout(context);//加载布局

                WindowManager.LayoutParams params = getWindow().getAttributes();
                params.width = WindowManager.LayoutParams.WRAP_CONTENT;
                params.height = WindowManager.LayoutParams.WRAP_CONTENT;
                getWindow().setAttributes(params);
            }

            @Override
            public void show() {//开启
                super.show();
            }

            @Override
            public void dismiss() {//关闭
                super.dismiss();
            }

        }

    }

    /**
     * Notification 通知类
     */
    public static class GT_Notification {

        private static int NOTIFYID = 0x1997; //通知id
        private static String CHANEL_ID = "com.gsls.king";
        private static String CHANEL_DESCRIPTION = "GT_Android 描述";
        private static String CHANEL_NAME = "GT_Android复习";

        /**
         * 设置 通知类的 code
         *
         * @param NotifyId
         */
        public GT_Notification setNotifyId(int NotifyId) {
            NOTIFYID = NotifyId;
            return this;
        }

        /**
         * 设置 通知类的 id
         *
         * @param ChanelId
         */
        public GT_Notification setChanelId(String ChanelId) {
            CHANEL_ID = ChanelId;
            return this;
        }

        /**
         * 设置 通知
         *
         * @param ChanelDescription
         */
        public GT_Notification setChanelDescription(String ChanelDescription) {
            CHANEL_DESCRIPTION = ChanelDescription;
            return this;
        }

        /**
         * 设置通知 名字
         *
         * @param ChanelName
         */
        public GT_Notification setChanelName(String ChanelName) {
            CHANEL_NAME = ChanelName;
            return this;
        }

        private Activity activity;

        /**
         * 实例化 通知类
         *
         * @param activity
         */
        public GT_Notification(Activity activity) {
            this.activity = activity;
        }

        /**
         * 初始化 通知类
         *
         * @param icon       图标
         * @param title      标题
         * @param text       内容
         * @param time       时间
         * @param voiceTF    是否设置声音振动
         * @param autoCancel 设置通知打开后自动消失
         * @param cla        设置跳转的 页面
         * @return 返回 通知类
         */
        public NotificationManagerCompat sendingNotice(int icon, String title, String text, int time, boolean voiceTF, boolean autoCancel, Class<?> cla) {

            /**
             * 由于 Notification.Builder 仅支持 Android 4.1及之后的版本，为了解决兼容性问题， Notification.Builder 仅支持 API 26 与 26 之前的版本
             * Google 在 Android Support v4 中加入了 NotificationCompat.Builder 类
             */
            String channelId = createNotificationChannel(activity.getApplicationContext());//创建Notification Channel
            NotificationCompat.Builder builder = new NotificationCompat.Builder(activity, channelId);//创建Notification并与Channel关联

            builder.setSmallIcon(icon);//设置通知图标
            builder.setAutoCancel(autoCancel);//设置通知打开后自动消失
            builder.setContentTitle(title);//设置标题
            builder.setContentText(text);//设置内容
            if (time == 0) builder.setWhen(System.currentTimeMillis());//设置系统当前时间为发送时间
            else builder.setWhen(time);//设置用户设置的发送时间
            if (voiceTF)
                builder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE);//设置默认的声音与默认的振动

            if (cla != null) {    //如果 cla 不为空就设置跳转的页面
                Intent intent = new Intent(activity, cla);
                PendingIntent pi = PendingIntent.getActivity(activity, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                builder.setContentIntent(pi);//设置通知栏 点击跳转
            }

            //发布通知
            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(activity.getApplicationContext());
            notificationManagerCompat.notify(NOTIFYID, builder.build());
            return notificationManagerCompat;
        }

        /**
         * 创建通知
         *
         * @param context
         * @return
         */
        private String createNotificationChannel(Context context) {
            // O (API 26)及以上版本的通知需要NotificationChannels。
            if (context != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                // 初始化NotificationChannel。
                NotificationChannel notificationChannel = new NotificationChannel(CHANEL_ID, CHANEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
                notificationChannel.setDescription(CHANEL_DESCRIPTION);

                // 向系统添加 NotificationChannel。试图创建现有通知
                // 通道的初始值不执行任何操作，因此可以安全地执行
                // 启动顺序
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.createNotificationChannel(notificationChannel);

                return CHANEL_ID;
            } else {
                return null; // 为pre-O(26)设备返回 null
            }
        }

    }

    /**
     * 跳转 Activity
     *
     * @param activityClass 跳转的类
     */
    public static void startAct(Class activityClass) {
        if (getGT().CONTEXT != null) {
            getGT().CONTEXT.startActivity(new Intent(getGT().CONTEXT, activityClass));//跳转 Activity
        } else {
            GT.log_e(getGT().getLineInfo(), "跳转 Activity 失败，CONTEXT 为 null 无法进行相应的 Activity 跳转");
        }
    }

    /**
     * 跳转 Activity
     *
     * @param intent
     */
    public static void startAct(Intent intent) {

        if (getGT().CONTEXT != null && intent != null) {
            getGT().CONTEXT.startActivity(intent);//跳转 Activity
        } else {
            GT.log_e(getGT().getLineInfo(), "跳转 Activity 失败，CONTEXT 或 Intent为 null 无法进行相应的 Activity 跳转");
        }
    }

    /**
     * 跳转 Activity
     *
     * @param context       上下文
     * @param activityClass 跳转的类
     */
    public static void startAct(Context context, Class activityClass) {
        if (context != null) {
            context.startActivity(new Intent(context, activityClass));//跳转 Activity
        }
    }

    //============================================= 数据存储类 =====================================

    /**
     * 数据持久化 SharedPreferences
     */
    public static class GT_SharedPreferences {

        private Context context;

        public void commit() {
            sp_e.apply();
        }  // 使用 apply 手动提交 如果提交后还有后续操作，建议使用 apply，先会写入内存，然后再异步写入磁盘

        public void clear() {
            sp_e.clear();
            sp_e.commit();
        }//清空    //如果使用 commit 来提交事务，是直接写入磁盘 ，如果需要频繁的提交的话， apply 的性能会优于 commit

        private SharedPreferences sp;

        public SharedPreferences getSharedPreferences() {
            return sp;
        }           //获取 SharedPreferences

        private SharedPreferences.Editor sp_e;

        public SharedPreferences.Editor getEditor() {
            return sp_e;
        }   //获取 SharedPreferences.Editor

        private boolean commit = false;             //定义是否自动提交
        public static final int PRIVATE = 0;        //只有本应用可读写
        public static final int PROTECTED = 1;      //其他应用可以只读
        public static final int PUBLIC = 2;         //其他应用可以读写
        private Gson gson = new Gson();             //是俩胡 Gson 对象

        /**
         * 初始化 SP
         *
         * @param context     上下文
         * @param SPName      存储的名字
         * @param permissions 存储可读取的权限
         * @param commit      是否自动提交
         */
        public GT_SharedPreferences(Context context, String SPName, int permissions, boolean commit) {
            this.context = context;
            this.commit = commit;
            sp = context.getSharedPreferences(SPName, permissions);//打开 或 创建 SharedPreferences
            sp_e = sp.edit();//让userData处于编辑状态
        }

        /**
         * 增加
         *
         * @param key    保存数据的 key
         * @param object 存储的数据
         * @return 返回 sp 操作对象
         */
        public GT_SharedPreferences save(String key, Object object) {
            boolean TF = true;//监测保存状态是否正常
            if (object instanceof String) {
                sp_e.putString(key, object.toString());
            } else if (object instanceof Integer) {
                sp_e.putInt(key, (Integer) object);
            } else if (object instanceof Long) {
                sp_e.putLong(key, (Long) object);
            } else if (object instanceof Float) {
                sp_e.putFloat(key, (Float) object);
            } else if (object instanceof Boolean) {
                sp_e.putBoolean(key, (Boolean) object);
            } else if (object instanceof Set) {
                sp_e.putStringSet(key, (Set) object);
            } else {
                if (GT_LOG_TF) log_v(context, "进行对象保存");
                String json = new Gson().toJson(object);
                String json_class = object.getClass().toString();
                sp_e.putString(key, json);                           //保存对象的 Json 数据
                sp_e.putString(key + "_class", json_class);            //保存对象的 class 数据
            }
            if (commit && TF) sp_e.apply();  //如果设置了自动提交 并且 保存状态正常 即可自定提交
            return this;

        }

        /**
         * 删除数据
         *
         * @param key 删除的 key
         * @return 返回 sp 操作对象
         */
        public SharedPreferences.Editor delete(String key) {
            if (query(key) != null) {
                sp_e.remove(key);
                if (commit) sp_e.apply();
            } else {
                if (GT_LOG_TF) log_v("删除失败  当前 sp 中无此 key");
            }
            return sp_e;
        }

        /**
         * 修改数据
         *
         * @param key    修改的 key
         * @param object 新的数据
         * @return 返回 sp 操作类
         */
        public GT_SharedPreferences updata(String key, Object object) {
            if (query(key) != null) {
                if (GT_LOG_TF)
                    log_v(context, "进入到 updata 查询的数据不为null");
                save(key, object);
            }
            return this;
        }

        /**
         * 查询数据
         *
         * @param key 查询数据的 key
         * @return 返回 sp 操作类
         */
        public Object query(String key) {
            Object obj = null;
            try {
                obj = sp.getInt(key, 0);
            } catch (ClassCastException e1) {
                if (GT_LOG_TF)
                    log_v(context, "Int 数据装换异常");
                try {
                    String str_class = sp.getString(key + "_class", null);     //获取对象 class 数据
                    String str = sp.getString(key, null);                          //获取对象 Json  数据
                    if (str_class == null) {      //如果 class 数据为空
                        obj = str;              //普通的 Json 数据
                    } else {
                        Object object_class = getObj(str_class);    //通过对象的 class 反射出 实例对象
                        obj = gson.fromJson(str, object_class.getClass());     //通过 Gson 与 实例对象 获取相应的 Object 对象
                    }
                } catch (ClassCastException e2) {
                    if (GT_LOG_TF)
                        log_v(context, "String 数据装换异常");
                    try {
                        obj = sp.getLong(key, 0);
                    } catch (ClassCastException e3) {
                        if (GT_LOG_TF)
                            log_v(context, "Long 数据装换异常");
                        try {
                            obj = sp.getFloat(key, 0f);
                        } catch (ClassCastException e4) {
                            if (GT_LOG_TF)
                                log_v(context, "Float 数据装换异常");
                            try {
                                obj = sp.getBoolean(key, false);
                            } catch (ClassCastException e5) {
                                if (GT_LOG_TF)
                                    log_v(context, "Boolean 数据装换异常");
                                try {
                                    obj = sp.getStringSet(key, null);
                                } catch (ClassCastException e6) {
                                    if (GT_LOG_TF)
                                        log_v(context, "StringSet 数据装换异常");
                                    obj = null;
                                }
                            }
                        }
                    }
                }
            }
            return obj;
        }

        /**
         * 查 List
         *
         * @param key  查 list 的 key
         * @param type 数据的类型
         * @return 返回 sp 操作类
         */
        public Object queryList(String key, Type type) {
            /**
             *  字符串 转 List 参数说明：
             *
             * key：与之前 save 是的 key
             *  type：
             *  Type type = new TypeToken<List<***Bean>>(){}.getType()
             *
             *  所以你只要传一个 new TypeToken<List<***Bean>>(){}.getType() 即可
             *  ***Bean 解释:   List<***Bean>   是之前 save 时 List的泛型
             *
             */
            Object obj = null;
            String str_class = sp.getString(key + "_class", null);     //获取对象 class 数据
            String str = sp.getString(key, null);                          //获取对象 Json  数据
            if (str_class != null && str_class.equals("class java.util.ArrayList")) {      //如果 class 数据为空
                obj = gson.fromJson(str, type);//字符串转 List
            }
            return obj;
        }

        /**
         * 通过 对象的.class 属性反射对象
         *
         * @param objectClass 全类名
         * @return 返回 反射的实体类
         */
        private Object getObj(String objectClass) {
            Object obj = null;
            String[] strs = objectClass.split(" ");
            String str = strs[1];
            Class<?> clazz = getClass();
            try {
                clazz = Class.forName(str);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            try {
                obj = clazz.newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            return obj;        //返回实例化好的类

        }

        /**
         * 获取所有
         *
         * @return 返回 map
         */
        public Map<String, ?> queryAll() {
            return sp.getAll();
        }

    }

    /**
     * GT_IO  Android 的 内部 IO 流
     */
    public static class GT_IO {

        /**
         * 使用实例：
         * 第一步：
         * GT.GT_IO io = new GT.GT_IO(this);//创建 IO 对象
         * 第二步：
         * io.save(editText.getText().toString(),"King");//保存数据
         * 第三步：
         * String king = io.query("King"); //获取数据
         */

        private Context context;

        /**
         * 实例化 上下文
         *
         * @param context
         */
        public GT_IO(Context context) {
            this.context = context;
        }

        /**
         * 保存数据
         *
         * @param saveData 保存的数据
         * @param dataName 保存文件名称
         * @return 返回 IO 操作对象
         */
        public GT_IO save(String saveData, String dataName) {

            FileOutputStream fos = null;//文件输出流
            try {
                fos = context.openFileOutput(dataName, context.MODE_PRIVATE);//获取文件输出流对象
                fos.write(saveData.getBytes());//保存备忘信息
                fos.flush();//清除缓存
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();//关闭输出流
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return this;
        }

        /**
         * 查询文件
         *
         * @param dataName 文件绝对路径包括文件名
         * @return
         */
        public String query(String dataName) {
            FileInputStream fis = null;//文件输入流对象
            String data = null;
            byte[] buffer = null;
            try {
                fis = context.openFileInput(dataName);//获得文件输入流对象
                buffer = new byte[fis.available()];//实例化字节数组
                fis.read(buffer);//从输入流中读取数据
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();//关闭输入流对象
                        data = new String(buffer);//把字节数组中的数据转换为字符串
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return data;
        }

    }

    /**
     * 外部存储 File
     */
    public static class GT_File {

        /**
         * 使用实例：（默认路径为 SD 卡根目录）
         * 第一步：
         *          GT.GT_File file = new GT.GT_File();//创建 File 对象
         * 第二步：
         *          file.save("第一章:","/我的小说/武侠小说/","斗罗大陆.txt");//保存数据
         * 第三步：
         *          String query = file.query("/我的小说/武侠小说/", "斗罗大陆.txt"); //获取数据
         */

        /**
         * 保存文件（默认路径为 SD 卡根目录）
         *
         * @param saveData 保存的数据
         * @param savePaht 保存的文件路径
         * @param fileName 保存文件的名称包括扩展名
         */
        public void save(String saveData, String savePaht, String fileName) {

            File fileNull = new File(Environment.getExternalStorageDirectory() + savePaht);//实例化文件对象
            if (!fileNull.exists()) {
                fileNull.mkdirs();
            }

            File file = new File(Environment.getExternalStorageDirectory() + savePaht, fileName);//实例化文件对象

            FileOutputStream fos = null;//文件输出流
            try {
                fos = new FileOutputStream(file);//获取文件输出流对象
                fos.write(saveData.getBytes());//保存备忘信息
                fos.flush();//清除缓存
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.close();//关闭输出流
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        /**
         * 查询文件
         *
         * @param queryPaht 查询文件的路径
         * @param fileName  查询文件的名称
         * @return String       返回文件数据
         */
        public String query(String queryPaht, String fileName) {

            File fileNull = new File(Environment.getExternalStorageDirectory() + queryPaht);//实例化文件对象
            if (!fileNull.exists()) {
                fileNull.mkdirs();
            }

            File file = new File(Environment.getExternalStorageDirectory() + queryPaht, fileName);//实例化文件对象


            FileInputStream fis = null;//文件输入流对象
            byte[] buffer = null;
            String data = null;
            try {
                fis = new FileInputStream(file);//获得文件输入流对象
                buffer = new byte[fis.available()];//实例化字节数组
                fis.read(buffer);//从输入流中读取数据
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();//关闭输入流对象
                        data = new String(buffer);//把字节数组中的数据转换为字符串
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            return data;
        }

    }

    /**
     * Hibernate SQL 暂时没有编辑完，待完善
     */
    public static class Hibernate {

        // 增    INSERT INTO ROLE(NAME,AGE,SEX) VALUES(:name,:age,:sex)
        // 删    DELETE 表名 WHERE NAME = '陈启申'
        // 改    UPDATE 表名 SET NAME = ? WHERE ID = ?
        // 查    SELECT * FROM ROLE WHERE id > ?
        //str    String json = new Gson().toJson(object);
        //obj    obj = new Gson().fromJson(str,object_class.getClass());     //通过 Gson 与 实例对象 获取相应的 Object 对象
        //       sp = context.getSharedPreferences(SQLName, AppCompatActivity.MODE_WORLD_WRITEABLE);//打开 sp
        //       sp_e = sp.edit();//让userData处于编辑状态

        private Context context;
        private Object password;
        private SharedPreferences sp;
        private SharedPreferences.Editor sp_e;
        private Map<Object, Object> sqlMap = new HashMap<>();
        private final static String DATABASE = "GT_DATABASE";

        //初始化 Hibernate
        public Hibernate(Context context) {
            this.context = context;
            sp = context.getSharedPreferences(DATABASE, AppCompatActivity.MODE_WORLD_WRITEABLE);//创建最底层的 sql
            sp_e = sp.edit();   //让 GT_DATABASE 处于编辑状态
        }

        //创建数据库
        public void createDatabase(String databaseName, Object password) {
            sqlMap.put(databaseName, new HashMap<>());
            String db = new Gson().toJson(sqlMap);
            log_e("创建数据库的 json 数据", db);

//            db = password;

            log_e("加密后的数据库 json 数据", db);
            sp_e.putString(databaseName, db);
            sp_e.apply();
        }

        //修改数据库
        public void alterDatabase(String formerName, String newName, Object password) {
            formerName = sp.getString("formerName", null);
            if (formerName != null) {

            } else {
                if (GT_LOG_TF) log_e("修改数据库 失败！ 原由：暂未找到需要修改的数据库名称");
            }
        }

        //删除数据库
        public void dropDatabase(String databaseName) {

        }

        //打开数据库
        public void openDatabase(String databaseName, Object password) {

        }

    }

    /**
     * 管理手机数据
     */
    public static class CleanDataUtils {

        /**
         * 需要查下缓存大小
         *
         * @param context
         * @return
         */
        public static String getTotalCacheSize(Context context) throws Exception {
            long cacheSize = getFolderSize(context.getCacheDir());
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                cacheSize += getFolderSize(context.getExternalCacheDir());
            }
            return getFormatSize(cacheSize);
        }

        /**
         * 清空缓存
         *
         * @param context
         */
        public static void clearAllCache(Context context) {
            deleteDir(context.getCacheDir());
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                deleteDir(context.getExternalCacheDir());
            }

        }

        /**
         * 删除 dir 文件
         *
         * @param dir
         * @return
         */
        private static boolean deleteDir(File dir) {
            if (dir != null && dir.isDirectory()) {
                String[] children = dir.list();
                for (int i = 0; i < children.length; i++) {
                    boolean success = deleteDir(new File(dir, children[i]));
                    if (!success) {
                        return false;
                    }
                }
            }
            return dir.delete();
        }

        /**
         * * 清除本应用内部缓存(/data/data/com.xxx.xxx/cache) * *
         *
         * @param context
         */
        public static void cleanInternalCache(Context context) {
            deleteFilesByDirectory(context.getCacheDir());
        }

        /**
         * * 清除本应用所有数据库(/data/data/com.xxx.xxx/databases) * *
         *
         * @param context
         */
        public static void cleanDatabases(Context context) {
            deleteFilesByDirectory(new File("/data/data/"
                    + context.getPackageName() + "/databases"));
        }

        /**
         * * 清除本应用SharedPreference(/data/data/com.xxx.xxx/shared_prefs) *
         *
         * @param context
         */
        public static void cleanSharedPreference(Context context) {
            deleteFilesByDirectory(new File("/data/data/"
                    + context.getPackageName() + "/shared_prefs"));
        }

        /**
         * * 按名字清除本应用数据库 * *
         *
         * @param context
         * @param dbName
         */
        public static void cleanDatabaseByName(Context context, String dbName) {
            context.deleteDatabase(dbName);
        }

        /**
         * * 清除/data/data/com.xxx.xxx/files下的内容 * *
         *
         * @param context
         */
        public static void cleanFiles(Context context) {
            deleteFilesByDirectory(context.getFilesDir());
        }

        /**
         * * 清除外部cache下的内容(/mnt/sdcard/android/data/com.xxx.xxx/cache)
         *
         * @param context
         */
        public static void cleanExternalCache(Context context) {
            if (Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED)) {
                deleteFilesByDirectory(context.getExternalCacheDir());
            }
        }

        /**
         * * 清除自定义路径下的文件，使用需小心，请不要误删。而且只支持目录下的文件删除 * *
         *
         * @param filePath
         */
        public static void cleanCustomCache(String filePath) {
            deleteFilesByDirectory(new File(filePath));
        }

        /**
         * * 清除本应用所有的数据 * *
         *
         * @param context
         * @param filepath
         */
        public static void cleanApplicationData(Context context, String... filepath) {
            cleanInternalCache(context);
            cleanExternalCache(context);
            cleanDatabases(context);
            cleanSharedPreference(context);
            cleanFiles(context);
            if (filepath == null) {
                return;
            }
            for (String filePath : filepath) {
                cleanCustomCache(filePath);
            }
        }

        /**
         * * 删除方法 这里只会删除某个文件夹下的文件，如果传入的directory是个文件，将不做处理 * *
         *
         * @param directory
         */
        private static void deleteFilesByDirectory(File directory) {
            if (directory != null && directory.exists() && directory.isDirectory()) {
                for (File item : directory.listFiles()) {
                    item.delete();
                }
            }
        }

        // 获取文件
        //Context.getExternalFilesDir() --> SDCard/Android/data/你的应用的包名/files/ 目录，一般放一些长时间保存的数据
        //Context.getExternalCacheDir() --> SDCard/Android/data/你的应用包名/cache/目录，一般存放临时缓存数据
        public static long getFolderSize(File file) throws Exception {
            long size = 0;
            try {
                File[] fileList = file.listFiles();
                for (int i = 0; i < fileList.length; i++) {
                    // 如果下面还有文件
                    if (fileList[i].isDirectory()) {
                        size = size + getFolderSize(fileList[i]);
                    } else {
                        size = size + fileList[i].length();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return size;
        }

        /**
         * 删除指定目录下文件及目录
         *
         * @param deleteThisPath
         * @param filePath
         * @return
         */
        public static void deleteFolderFile(String filePath, boolean deleteThisPath) {
            if (!TextUtils.isEmpty(filePath)) {
                try {
                    File file = new File(filePath);
                    if (file.isDirectory()) {// 如果下面还有文件
                        File files[] = file.listFiles();
                        for (int i = 0; i < files.length; i++) {
                            deleteFolderFile(files[i].getAbsolutePath(), true);
                        }
                    }
                    if (deleteThisPath) {
                        if (!file.isDirectory()) {// 如果是文件，删除
                            file.delete();
                        } else {// 目录
                            if (file.listFiles().length == 0) {// 目录下没有文件或者目录，删除
                                file.delete();
                            }
                        }
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        /**
         * 格式化单位
         *
         * @param size
         * @return
         */
        public static String getFormatSize(double size) {
            double kiloByte = size / 1024;
//        if (kiloByte < 1) {
//            return size + "Byte";
//        }

            double megaByte = kiloByte / 1024;
            if (megaByte < 1) {
                BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
                return result1.setScale(2, BigDecimal.ROUND_HALF_UP)
                        .toPlainString() + "K";
            }

            double gigaByte = megaByte / 1024;
            if (gigaByte < 1) {
                BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
                return result2.setScale(2, BigDecimal.ROUND_HALF_UP)
                        .toPlainString() + "M";
            }

            double teraBytes = gigaByte / 1024;
            if (teraBytes < 1) {
                BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
                return result3.setScale(2, BigDecimal.ROUND_HALF_UP)
                        .toPlainString() + "G";
            }
            BigDecimal result4 = new BigDecimal(teraBytes);
            return result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString()
                    + "T";
        }

        public static String getCacheSize(File file) throws Exception {
            return getFormatSize(getFolderSize(file));
        }

    }


    //=========================================== 网络类 =========================================

    /**
     * network 网络类
     */
    public static class Network {

        /**
         * 监听网络状态 true 网络正常  false 网络异常
         *
         * @param context 上下文
         * @return boolean  true 为当前网络正常    false 则反之
         */
        @SuppressLint("MissingPermission")
        public static boolean netWorkStatus(Context context) {
            ConnectivityManager cwjManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cwjManager.getActiveNetworkInfo() != null) {
                return cwjManager.getActiveNetworkInfo().isAvailable();
            }
            return false;
        }

        /**
         * 获取手机 IP 地址
         *
         * @param context 上下文
         * @return String   返回当前 ip 地址
         */
        public static String getIPAddress(Context context) {
            @SuppressLint("MissingPermission") NetworkInfo info = ((ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                if (info.getType() == ConnectivityManager.TYPE_MOBILE) {//当前使用2G/3G/4G网络
                    try {
                        //Enumeration<NetworkInterface> en=NetworkInterface.getNetworkInterfaces();
                        for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                            NetworkInterface intf = en.nextElement();
                            for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                                InetAddress inetAddress = enumIpAddr.nextElement();
                                if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                                    return inetAddress.getHostAddress();
                                }
                            }
                        }
                    } catch (SocketException e) {
                        e.printStackTrace();
                    }


                } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {//当前使用无线网络
                    WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                    @SuppressLint("MissingPermission") WifiInfo wifiInfo = wifiManager.getConnectionInfo();

                    int ipAddress1 = wifiInfo.getIpAddress();
                    String ipAddress = (ipAddress1 & 0xFF) + "." +
                            ((ipAddress1 >> 8) & 0xFF) + "." +
                            ((ipAddress1 >> 16) & 0xFF) + "." +
                            (ipAddress1 >> 24 & 0xFF);
                    return ipAddress;
                }
            } else {
                //当前无网络连接,请在设置中打开网络
                GT.toast_s("当前无网络");
            }
            return null;
        }

        //检测当前手机是否可上网
        public static boolean isInternet(Context context) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
            @SuppressLint("MissingPermission") NetworkInfo info = manager.getActiveNetworkInfo();// 检查网络连接，如果无网络可用，就不需要进行连网操作等
            if (info == null || !manager.getBackgroundDataSetting()) {
                return false;
            }
            return true;
        }

    }

    /**
     * JSON 接口解析
     */
    public static class JSON {

        private String string;

        /**
         * 初始化 json 数据
         *
         * @param string 服务器请求下来的 String 数据
         */
        public JSON(String string) {
            this.string = string;
            try {
                JSONObject jsonObject = new JSONObject(string);
            } catch (JSONException e) {
                if (GT_LOG_TF)
                    log_v("当前 JSON 数据中有些节点并不存在,请谨慎使用!  【" + getGT().getLineInfo() + "】");
//                e.printStackTrace();
            }
        }

        /*********************************  根据 Bean 获取数据*************************************/
        /**
         * 根据 bean 类获取 bean 对象
         *
         * @param aClass 指定 解析后的 bean 可续
         * @return 返回 实体类
         */
        public Object getBean(Class<?> aClass) {
            Object o = null;
            try {
                o = new Gson().fromJson(string, aClass);
            } catch (JsonSyntaxException exception) {
                log_e(getGT().getLineInfo(), "你的 JSON 解析类型不匹配，请检查  " + aClass + "  是否与请求的Json数据一致！");
            }
            return o;
        }


        /*********************************  没有 Bean 获取数据*************************************/
        /**
         * 用法:
         * 第一步：将请求的数据放入   GT.JSON json = new GT.JSON(“请求的数据”);
         * 第二步：初始化 JSON 数据  json.initBeanData(json.getData());
         * 第三步：获取 list 集合    JSONArray list = json.getJSONArray("list");     //获取 list 节点
         * 第四步：获取 list 内数据  Object author = json.getJSONObject(list, “节点名”, “集合list的索引”);
         * <p>
         * 注意:
         * 如果请求的数据是 "data":{}  就用 get()方法 获取 data 再就进行初始化后 获取里面的值
         * 如果请求的数据是 "list": [] 就用 getJSONObject() 获取 List<?>
         */
        private JSONObject jsonObject;
        private JSONArray jsonArray;

        /**
         * 初始化 实体类数据
         *
         * @param data
         * @return 返回JSON 操作对象
         */
        public JSON initBeanData(String data) {
            try {
                jsonObject = new JSONObject(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return this;
        } //初始化 JSON 数据

        /**
         * 获取普通的值 返回数据前会进行 忽略掉转义符
         *
         * @param key
         * @return
         */
        public Object get(String key) {
            Object o = null;
            if (jsonObject != null) {
                try {
                    o = jsonObject.get(key);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                log_e(getGT().getLineInfo(), "没有初始化 JSON 数据，无法进行 无 bean 数据解析");
            }

//            GT.log_e("在转 data 数据之前:" + data);
            o = rplStr(o.toString(), "\\", "");//忽略掉转义符
//            GT.log_e("转 data 数据之后:" + data);

            return o;
        }   //获取普通的值 返回数据前会进行 忽略掉转义符

        /**
         * 去掉转义符
         *
         * @param str1
         * @param str2
         * @param str3
         * @return
         */
        public String rplStr(String str1, String str2, String str3) {
            String strtmp = "";
            int i = 0, f;
            for (i = 0; ; i += str2.length()) {
                f = str1.indexOf(str2, i);
                if (f == -1) {
                    strtmp += str1.substring(i);
                    break;
                } else {
                    strtmp += str1.substring(i, f);
                    strtmp += str3;
                    i = f;
                }
            }
            return strtmp;
        }//去掉转义符

        /**
         * 获取 对象数组
         *
         * @param string
         * @return
         */
        public JSONArray getJSONArray(String string) {
            try {
                jsonArray = new JSONArray(string);
            } catch (JSONException e) {
                log_e(getGT().getLineInfo(), "没有初始化 JSON 数据，无法进行 无 bean 数据解析");
            }

            return jsonArray;
        }   //获取 对象数组

        /**
         * 获取 JSON 对象
         *
         * @param list
         * @param key
         * @param index
         * @return
         */
        public Object getJSONObject(JSONArray list, String key, int index) {
            JSONObject jsonObject = null;
            Object o = null;
            try {
                jsonObject = (JSONObject) list.get(index);  //获取当前索引下
                o = jsonObject.get(key);        //key 值 的对象
            } catch (JSONException e) {
                log_e(getGT().getLineInfo(), "JSON 数据解析异常，无法通过 没有初始化的 JSON 数据进行解析节点");
            }
            return o;
        }   //获取 JSON 对象

        /**
         * 添加新的 json 数据
         *
         * @param jsonArray
         * @param new_jsonArray
         * @return
         */
        public static JSONArray addJSONArray(JSONArray jsonArray, JSONArray new_jsonArray) {

            for (int i = 0; i < new_jsonArray.length(); i++) {
                try {
                    Object o = jsonArray.get(i);
                    jsonArray.put(o);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return jsonArray;
        }//添加新的 json 数据

        /**
         * 清除所有的 key
         *
         * @param jsonArray
         * @return
         */
        public static JSONArray clear(JSONArray jsonArray) {
            for (int i = 0, len = jsonArray.length(); i < len; i++) {
                JSONObject obj = null;
                try {
                    obj = jsonArray.getJSONObject(i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                obj.remove("key");
            }
            return jsonArray;
        }


    }

    /**
     * OkGo 网络请求框架
     */
    public static class OkGo {

        private Map<String, String> map;
        private String url;


        /**
         * 初始化 map 并进行添加参数
         *
         * @param key
         * @param value
         * @return
         */
        public OkGo addParameter(String key, String value) {
            if (map == null) {
                map = new HashMap<>();//初始化 map
            } else {
                if (!map.containsKey(key)) {//如果当前 map 中没有此key
                    map.put(key, value);
                }
            }
            return this;
        }

        /**
         * 实例化  post 请求
         *
         * @param url
         * @param map
         */
        public OkGo(String url, Map<String, String> map) {
            this.url = url;
            this.map = map;
        }

        /**
         * 实例化 get 请求
         *
         * @param url
         */
        public OkGo(String url) {
            this.url = url;
        }

        /**
         * 请求网络数据 Post
         *
         * @param stringCallback new 一个 StringCallback 内部类接口
         */
        public void loadDataPost(StringCallback stringCallback) {
            if (map == null) {
                com.lzy.okgo.OkGo
                        .<String>post(url)
                        .execute(stringCallback);

            } else {
                com.lzy.okgo.OkGo
                        .<String>post(url)
                        .params(map)
                        .execute(stringCallback);
            }
        }

        /**
         * 请求网络数据 Get
         *
         * @param stringCallback new 一个 StringCallback 内部类接口
         */
        public void loadDataGet(StringCallback stringCallback) {
            if (map == null) {
                com.lzy.okgo.OkGo
                        .<String>get(url)
                        .execute(stringCallback);

            } else {
                com.lzy.okgo.OkGo
                        .<String>get(url)
                        .params(map)
                        .execute(stringCallback);
            }
        }

    }

    /**
     * okHttp 网络请求框架
     */
    public static class OkHttp {

        private OkHttpClient mOkHttpClient = null;
        private Call call = null;
        private String url = null;
        private Map<String, String> map = null;

        /**
         * 初始化 参数 post
         *
         * @param url
         * @param map
         */
        public OkHttp(String url, Map<String, String> map) {
            mOkHttpClient = new OkHttpClient();
            this.url = url;
            this.map = map;
        }

        /**
         * 初始化 参数 get
         *
         * @param url
         */
        public OkHttp(String url) {
            mOkHttpClient = new OkHttpClient();
            this.url = url;
        }

        /**
         * 请求数据
         *
         * @param callback new 一个 Callback 类的内部类
         */
        public void loadDAta(Callback callback) {
            if (url != null) {
                Request request = null;
                if (map != null && map.size() > 0) {
                    FormBody.Builder builder = new FormBody.Builder();
                    for (String key : map.keySet()) {
                        builder.add(key, map.get(key));
                    }
                    RequestBody formBody = builder.build();
                    request = new Request.Builder()
                            .url(url)
                            .post(formBody)
                            .build();
                } else {
                    request = new Request.Builder()
                            .url(url)
                            .build();
                }
                call = mOkHttpClient.newCall(request);
                call.enqueue(callback);

            }
        }

    }

    /**
     * 将网页图片 利用照腾讯X5 自定适应屏幕大小
     */
    public static class HtmlFormat {
        /**
         * 获取新的 上下文
         *
         * @param htmltext
         * @return
         */
        public static String getNewContent(String htmltext) {
            Document doc = Jsoup.parse(htmltext);
            Elements elements = doc.getElementsByTag("img");
            for (Element element : elements) {
                element.attr("width", "100%").attr("height", "auto");
            }
            return doc.toString();
        }
    }

    /**
     * 将网页上的 JSON 数据取下来
     * 如果在取数据的时候报错，请将 getHtmlData(urlApi) 方法放在 子线程中运行
     * 网络请求需要放在 子线程中，主线程会直接报错。
     */
    public static class WebApi {
        /**
         * @param urlApi 请求 Api 接口的网址
         * @return 返回纯 JSON 字符串
         */
        public static String getHtmlData(String urlApi) throws Exception {
            URL url = new URL(urlApi);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();//通过输入流获取html数据
            byte[] data = readInputStream(inStream);//得到html的二进制数据
            String html = new String(data, "UTF-8");
            return html;
        }

        private static byte[] readInputStream(InputStream inStream) throws Exception {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            inStream.close();
            return outStream.toByteArray();
        }
    }

    /**
     * 加载 PC 版的网页
     */
    public static class loadPCHtml {

        /**
         * @param webView 网页对象
         * @param url     要加载的网页
         */
        public static void setWebViewLoadPC(WebView webView, String url) {

            if (webView != null) {
                webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
                //支持js
                webView.getSettings().setJavaScriptEnabled(true);

                webView.getSettings().setUserAgentString("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.134 Safari/537.36");
                //自适应屏幕
                webView.getSettings().setUseWideViewPort(true);
                webView.getSettings().setLoadWithOverviewMode(true);
                //自动缩放
                webView.getSettings().setBuiltInZoomControls(true);
                webView.getSettings().setSupportZoom(true);
                //支持获取手势焦点
                webView.requestFocusFromTouch();
                webView.setWebViewClient(new MyWeb());
                webView.loadUrl(url);//加载网页
            }

        }

        private static class MyWeb extends WebViewClient {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);//在这里设置对应的操作
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
            }

        }

    }


    //============================================= 小工具类 =======================================

    /**
     * data 日期类
     */
    public static class GT_Date {

        private String time;        //定义返回的 时间整体字符串
        private String[] times;     //定义分割后产生的 年月日 / 时分秒 数组
        private String[] ymd;       //定义分割后产生的 年月日 数组
        private String[] hms;       //定义分割后产生的 时分秒 数组

        /**
         * 初始化时间 数据
         */
        public GT_Date() {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            time = df.format(new Date());   //获取当时间
            times = time.split(" ");    //分割时间 年月日 / 时分秒 数组
            ymd = times[0].split("-");  //分割年月日 数组
            hms = times[1].split(":");  //分割时分秒 数组
        }

        /**
         * 获取当前星期
         *
         * @return
         */
        public String getWeekOfDate() {
            String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
            if (w < 0)
                w = 0;
            return weekDays[w];
        }

        /**
         * 获取当前时间
         *
         * @return
         */
        public String getTime() {
            return time;
        }

        /**
         * 获取当前 年月日
         *
         * @return
         */
        public String getYearMonthDay() {
            return times[0];
        }

        /**
         * 获取年
         *
         * @return
         */
        public String getYear() {
            return ymd[0];
        }

        /**
         * 获取月
         *
         * @return
         */
        public String getMonth() {
            return ymd[1];
        }

        /**
         * 获取日
         *
         * @return
         */
        public String getDay() {
            return ymd[2];
        }

        /**
         * /获取当前 时分秒
         *
         * @return
         */
        public String getHourMinuteSecond() {
            return times[1];
        }

        /**
         * 获取时
         *
         * @return
         */
        public String getHour() {
            return hms[0];
        }

        /**
         * 获取分
         *
         * @return
         */
        public String getMinute() {
            return hms[1];
        }

        /**
         * 获取秒
         *
         * @return
         */
        public String getSecond() {
            return hms[2];
        }

        /**
         * 时间戳转 时间
         *
         * @param dataTime
         * @return
         */
        public String toTime(String dataTime) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            long myTime = Long.parseLong(dataTime);
            long lt = new Long(myTime * 1000);//返回来的时间戳1476929029是毫秒，这里要乘1000才是正确的北京时间
            Date date = new Date(lt);
            String time = formatter.format(date);
            return time;
        }

        /**
         * 时分秒
         *
         * @param dataTime
         * @return
         */
        public String toTime_hms(String dataTime) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            long myTime = Long.parseLong(dataTime);
            long lt = new Long(myTime * 1000);//返回来的时间戳1476929029是毫秒，这里要乘1000才是正确的北京时间
            Date date = new Date(lt);
            String time = formatter.format(date);
            time = time.substring(time.length() - 8, time.length());
            return time;
        }

        /**
         * 离现在过去几小时
         *
         * @param dataTime
         * @return
         */
        public String toPastTime(String dataTime) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            long myTime = Long.parseLong(dataTime);
            long lt = new Long(myTime * 1000);//返回来的时间戳1476929029是毫秒，这里要乘1000才是正确的北京时间
            Date date = new Date(lt);
            String time = formatter.format(date);
            time = time.substring(time.length() - 8, time.length());
            time = time.substring(0, 2);
            String hour = getHour();
            int timeInt = Integer.parseInt(time);
            int hourInt = Integer.parseInt(hour);
            int showTime;

            if (hourInt < timeInt) {
                timeInt = 24 - timeInt; //一天减去 当时发送的时间
                showTime = hourInt + timeInt;
            } else {
                showTime = hourInt - timeInt;
            }

            //判断当前过去的时间是否大于0 最小为 1小时前
            if (showTime > 0) {
                time = showTime + "小时前";
            } else {//否则 进行分钟判断

                time = formatter.format(date);
                time = time.substring(time.length() - 8, time.length());
                time = time.substring(3, 5);

                timeInt = Integer.parseInt(time);
                hourInt = Integer.parseInt(getMinute());
                showTime = hourInt - timeInt;

                if (showTime > 0) {
                    time = showTime + "分钟前";
                } else {
                    time = "刚刚";
                }
            }

            return time;
        }

        /**
         * 时间戳转 年月日
         *
         * @param dataTime
         * @return
         */
        public String toYearMonthDay(String dataTime) {
            SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd", Locale.getDefault());
            long myTime = Long.parseLong(dataTime);
            long lt = new Long(myTime * 1000);//返回来的时间戳1476929029是毫秒，这里要乘1000才是正确的北京时间
            Date date = new Date(lt);
            String time = formatter.format(date);
            return time;
        }

        /**
         * 时间戳转 北京时间
         *
         * @param dataTime
         * @return
         */
        public String toBeijingTime(String dataTime) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            long myTime = Long.parseLong(dataTime);
            long lt = new Long(myTime * 1000);//返回来的时间戳1476929029是毫秒，这里要乘1000才是正确的北京时间
            Date date = new Date(lt);
            String time = formatter.format(date);
            return time;
        }

    }

    /**
     * 分享功能
     */
    public static class GT_Share {

        private Activity activity;

        /**
         * 初始化 上下文
         *
         * @param activity
         */
        public GT_Share(Activity activity) {
            this.activity = activity;
        }

        /**
         * 发送文字
         *
         * @param title
         * @param content
         */
        public void senText(String title, String content) {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, content);
            shareIntent = Intent.createChooser(shareIntent, title);
            activity.startActivity(shareIntent);
        }


    }

    /**
     * 图片优化类
     */
    public static class ImageOptimize {

        private Activity activity;

        public ImageOptimize() {
        }

        /**
         * 初始化
         *
         * @param activity
         */
        public ImageOptimize(Activity activity) {
            this.activity = activity;
        }

        /**
         * 加载图片
         *
         * @param context        上下文
         * @param ImageResources 要加载的图片资源
         * @param imageView      加载到那个组件上
         */
        public static void loadImage(Context context, Object ImageResources, ImageView imageView) {
            Glide.with(context).asDrawable().load(ImageResources).into(imageView);
        }

    }


    //============================================= UI类 ===========================================

    /**
     * Window 窗体类
     */
    public static abstract class Window {

        /**
         * 屏幕常亮
         *
         * @param activity
         */
        public static void light(Activity activity) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//屏幕常亮
        }

        /**
         * 设置全屏模式
         *
         * @param activity
         */
        public static void fullScreen(Activity activity) {
            activity.requestWindowFeature(android.view.Window.FEATURE_NO_TITLE);
            activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        /**
         * 关闭虚拟按钮
         *
         * @param activity
         */
        public static void Close_virtualButton(Activity activity) {
            if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
                View v = activity.getWindow().getDecorView();
                v.setSystemUiVisibility(View.GONE);
            } else {
                View decorView = activity.getWindow().getDecorView();
                int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
                decorView.setSystemUiVisibility(uiOptions);
            }
        }

        /**
         * 关闭虚拟按钮2
         *
         * @param window
         */
        public static void setHideVirtualKey(android.view.Window window) {
            //保持布局状态
            int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                    //布局位于状态栏下方
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                    //全屏
                    View.SYSTEM_UI_FLAG_FULLSCREEN |
                    //隐藏导航栏
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            if (Build.VERSION.SDK_INT >= 19) {
                uiOptions |= 0x00001000;
            } else {
                uiOptions |= View.SYSTEM_UI_FLAG_LOW_PROFILE;
            }
            window.getDecorView().setSystemUiVisibility(uiOptions);
        }

        /**
         * 获取屏幕 宽度
         *
         * @param appCompatActivity
         * @return
         */
        public static int getWindowWidth(AppCompatActivity appCompatActivity) {
            int width = appCompatActivity.getWindowManager().getDefaultDisplay().getWidth();
            return width;
        }

        /**
         * 获取屏幕 高度
         *
         * @param appCompatActivity
         * @return
         */
        public static int getWindowHeight(AppCompatActivity appCompatActivity) {
            int height = appCompatActivity.getWindowManager().getDefaultDisplay().getHeight();
            return height;
        }

        /**
         * 隐藏状态栏
         *
         * @param activity
         */
        public static void hideStatusBar(AppCompatActivity activity) {
            View decorView = activity.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
        }

        /**
         * 隐藏ActionBar
         *
         * @param activity
         */
        public static void hideActionBar(AppCompatActivity activity) {
            ActionBar actionBar = activity.getSupportActionBar();
            GT.log_e("测试:" + actionBar);
            if (activity != null) {
                actionBar.hide();
            }
        }

        /**
         * 隐藏导航栏
         *
         * @param activity
         */
        public static void hideNavigationBar(Activity activity) {
            if (Build.VERSION.SDK_INT >= 19) {
                View decorView = activity.getWindow().getDecorView();
                decorView.setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
            }
        }

        /**
         * 透明状态栏
         *
         * @param activity
         */
        public static void lucencyStatusBar(Activity activity) {
            if (Build.VERSION.SDK_INT >= 21) {
                View decorView = activity.getWindow().getDecorView();
                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                decorView.setSystemUiVisibility(option);
                activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
            }
        }

        /**
         * 透明导航栏
         *
         * @param activity
         */
        public static void lucencyNavigationBar(Activity activity) {
            if (Build.VERSION.SDK_INT >= 21) {
                View decorView = activity.getWindow().getDecorView();
                int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
                decorView.setSystemUiVisibility(option);
                activity.getWindow().setNavigationBarColor(Color.TRANSPARENT);
                activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
            }
        }


        /**
         * 沉浸式模式 (隐藏状态栏，去掉ActionBar，隐藏导航栏)
         *
         * @param activity
         */
        public static void immersionMode(Activity activity) {
            if (Build.VERSION.SDK_INT >= 19) {
                View decorView = activity.getWindow().getDecorView();
                decorView.setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
            }
        }

        /**
         * 返回当前是 横屏 还是 竖屏
         *
         * @param activity
         * @return 横屏返回 true 竖屏返回 false
         */
        public static boolean isLandscapeAndPortrait(Activity activity) {
            Configuration mConfiguration = activity.getResources().getConfiguration(); //获取设置的配置信息
            if (mConfiguration.orientation == mConfiguration.ORIENTATION_LANDSCAPE) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * one_three:   0-6 的 值来进行强制的 横竖屏、自适应等
         * 执行强制的 横屏 或 竖屏
         *
         * @param activity
         */
        public static void AutoLandscapeAndPortrait(Activity activity, int one_three) {
            switch (one_three) {
                case 0:
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制为正横屏
                    break;
                case 1:
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);//强制为反横屏
                    break;
                case 2:
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//强制为正竖屏
                    break;
                case 3:
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);//强制为反竖屏
                    break;
                case 4:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_USER);//为虚拟按键提供旋转屏幕提示
                    }
                    break;
                case 5:
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);//自动适宜 正横屏、反横屏、正竖屏
                    break;
                case 6:
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);//自动适宜 正横屏、反横屏
                    break;
            }


        }


    }


    /**
     * Game 游戏类
     */
    public static class Game {

        /**
         * 开启游戏窗体模式
         *
         * @param activity
         */
        public static void startGameWindow(Activity activity) {
            try {
                Window.light(activity);//屏幕常亮
                Window.immersionMode(activity);//沉浸式模式
                Window.Close_virtualButton(activity);//关闭虚拟按钮
                GT.Window.hideActionBar((AppCompatActivity) activity);//隐藏 ActionBar
            } catch (Exception e) {
                GT.log_e(getGT().getLineInfo(), "请去掉调用该方法前面所有关于 沉浸式 关闭虚拟按钮 隐藏 ActionBar 等类似的代码");
            }
        }

        /**
         * 开启永久的游戏窗口模式
         * 开启线程去一直开启全屏模式
         * 除非必要，否则勿用该方法
         *
         * @param activity
         */
        public static void startGameWindows(final Activity activity) {
            GT.Thread.runJava(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        GT.Thread.sleep(1000);
                        GT.Thread.runAndroid(new Runnable() {
                            @Override
                            public void run() {
                                GT.Game.startGameWindow(activity);//开启游戏窗口
                            }
                        });
                    }
                }
            });
        }


    }

    /**
     * 设置触摸放大
     */
    public static class ViewTouchMagnify {
        private int viewWidth;        //保存按钮宽度
        private int viewHeight;        //保存按钮高度

        /**
         * 为按钮设置触摸事件
         *
         * @param view
         */
        public void touchZoomInView(final View view) {
            //设置按钮触摸事件
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View arg0, MotionEvent arg1) {
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (arg1.getAction() == MotionEvent.ACTION_DOWN) {//如果用户手指触摸屏幕
                        viewWidth = view.getWidth();        //保存按钮的宽度
                        viewHeight = view.getHeight();        //保存按钮的高度
//                        view.setTextSize(18);								//设置按钮放大时字体大小
                        layoutParams.width = viewWidth + 20;                //设置按钮放大时的宽度
                        layoutParams.height = viewHeight + 10;            //设置按钮放大时的高度
                    } else if (arg1.getAction() == MotionEvent.ACTION_UP) {//如果用户手指离开屏幕
//                        button.setTextSize(15);							//设置按钮为原来字体大小
                        layoutParams.width = viewWidth;                //设置按钮为原来的宽度
                        layoutParams.height = viewHeight;                //设置按钮为原来的高度
                    }
                    view.setLayoutParams(layoutParams);    //提交事务
                    return false; //设置为未完成消耗掉的时间   如果将此返回为     true  那么按钮的  单击事件将会被屏蔽掉
                }
            });

        }

    }

    /**
     * 封装 Fragment 管理器
     */
    public static class GT_Fragment {

        private GT_Fragment() {
        }//单例

        private static GT_Fragment gt_fragment;

        //实例化 GT_Fragment
        public static GT_Fragment getGT_fragment() {
            synchronized (GT_Fragment.class) {
                if (gt_fragment == null) {
                    gt_fragment = new GT_Fragment();
                }
            }
            return gt_fragment;
        }

        /**
         * 构建 GT 工具包
         * @param object
         * @param view
         */
        protected void build(Object object,View view){
            GT.getGT().build(object,view);
        }

        /**
         * 普通日志
         * @param object
         */
        protected void log(Object object){
            GT.log_i(object);
        }

        /**
         * 带 TAG 的普通日志
         * @param tag
         * @param object
         */
        protected void log(Object tag,Object object){
            GT.log_i(tag,object);
        }

        /**
         * 错误日志
         * @param object
         */
        protected void err(Object object){
            GT.log_e(object);
        }

        /**
         * 带 TAG 的错误日志
         * @param tag
         * @param object
         */
        protected void err(Object tag,Object object){
            GT.log_e(tag,object);
        }

        /**
         * 普通的 Toast
         * @param object
         */
        protected void toast(Object object){
            GT.toast_s(object);
        }

        /**
         * 带 Context 的 Toast
         * @param context
         * @param object
         */
        protected void toast(Context context, Object object){
            GT.toast_s(context,object);
        }

        /**
         * 带 延时的 的 Toast
         * @param time
         * @param object
         */
        protected void toast(long time, Object object){
            GT.toast_time(object,time);
        }

        /**
         * 用于辅助 Fragment
         */
        public abstract static class BaseFragments extends Fragment {

            //定义 Activity
            protected Activity activity;

            // 获取 GT 实例
            public GT getGT() {
                return getGT();
            }


            //如果重写该方法了的话就需要自己写 接收 Activity
            @Override
            public void onAttach(Context context) {
                super.onAttach(context);
                activity = (Activity) context;//接收 Activity
            }

            /**
             * 返回要加载的布局
             *
             * @return
             */
            protected abstract int loadLayout();

            /**
             * 初始化 View 数据
             *
             * @param view
             * @param savedInstanceState
             */
            protected abstract void initView(@NonNull View view, @Nullable Bundle savedInstanceState);

            /**
             * 用户在初始化布局前设置必要的参数 当前方法可不重写
             *
             * @param view
             */
            public void createView(View view) {
            }

            /**
             * 获取一个 Fragment 管理器实例
             *
             * @return
             */
            public GT_Fragment getGT_Fragment() {
                return gt_fragment;
            }

            /**
             * 退出当前 Fragment
             */
            public void finish() {
                if (gt_fragment != null) {
                    gt_fragment.finish();
                }
            }

            /**
             * 开启新的 Fragment
             *
             * @param newFragment
             */
            public void startFragment(Fragment newFragment) {
                if (gt_fragment != null) {
                    gt_fragment.startFragment(newFragment);
                }
            }

            /**
             * 初始化 当前 Fragment 必要的属性
             *
             * @param view
             */
            public void initBaseFragment(View view) {
                if (getGT_fragment() != null) {
                    getGT_fragment().initBaseFragment(view);
                }
            }

            @Nullable
            @Override
            public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                View view = inflater.inflate(loadLayout(), container, false);
                createView(view);
                return view;
            }

            /**
             * 主要实现的功能
             */
            protected void function() {
            }

            @Override
            public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
                super.onViewCreated(view, savedInstanceState);
                initBaseFragment(view);
                initView(view, savedInstanceState);//主要方法
                function();
            }

        }


        /**
         * 用于辅助 DialogFragment
         */

        public abstract static class BaseDialogFragments extends DialogFragment {

            /**
             * 返回要加载的布局
             *
             * @return
             */
            protected abstract int loadLayout();

            /**
             * 初始化 View 数据
             *
             * @param view
             * @param savedInstanceState
             */
            protected abstract void initView(@NonNull View view, @Nullable Bundle savedInstanceState);

            /**
             * 主要实现的功能
             */
            protected void function() {
            }

            /**
             * 是否去掉 背景弹窗
             *
             * @return
             */
            protected boolean isShow() {
                return false;
            }

            /**
             * 用户在初始化布局前设置必要的参数 当前方法可不重写
             *
             * @param view
             */
            public void createView(View view) {
            }

            /**
             * 关闭当前 对话框 Fragment
             */
            public void finish() {
                dismiss();
            }

            protected void build(Object object,View view){
                GT.getGT().build(object,view);
            }

            public void startDialogFragment(DialogFragment dialogFragment) {
                dialogFragment.show(getFragmentManager(), dialogFragment.getClass().toString());//弹出退出提示
            }

            @Nullable
            @Override
            public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                View view = inflater.inflate(loadLayout(), container, false);
                createView(view);
                return view;
            }

            @Override
            public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
                super.onViewCreated(view, savedInstanceState);
                if (isShow())
                    getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                initView(view, savedInstanceState);//主要方法
                function();
            }


        }


        /**
         *  事务的方法
         * add(Fragment fragment, String tag) //  调用add(int, Fragment, String),填入为0的containerViewId.
         * add(int containerViewId, Fragment fragment) // 调用add(int, Fragment, String),填入为null的tag.
         * add(int containerViewId, Fragment fragment, String tag) // 向Activity中添加一个Fragment.
         * addSharedElement(View sharedElement, String name) // 添加共享元素
         * addToBackStack(String name) // 将事务添加到回退栈
         * attach(Fragment fragment) // 重新关联Fragment（当Fragment被detach时）
         * commit() // 提交事务
         * commitAllowingStateLoss() // 类似commit()，但允许在Activity状态保存之后提交（即允许状态丢失）。
         * commitNow() // 同步提交事务
         * commitNowAllowingStateLoss() // 类似commitNow()，但允许在Activity状态保存之后提交（即允许状态丢失）。
         * detach(Fragment fragment) // 将fragment保存的界面从UI中移除
         * disallowAddToBackStack() // 不允许调用addToBackStack(String)操作
         * hide(Fragment fragment) // 隐藏已存在的Fragment
         * isAddToBackStackAllowed() // 是否允许添加到回退栈
         * isEmpty() // 事务是否未包含的任何操作
         * remove(Fragment fragment) // 移除一个已存在的Fragment
         * replace(int containerViewId, Fragment fragment) // 调用replace(int, Fragment, String)填入为null的tag.
         * replace(int containerViewId, Fragment fragment, String tag) // 替换已存在的Fragment
         * setBreadCrumbShortTitle(int res) // 为事务设置一个BreadCrumb短标题
         * setBreadCrumbShortTitle(CharSequence text) // 为事务设置一个BreadCrumb短标题，将会被FragmentBreadCrumbs使用
         * setBreadCrumbTitle(int res) // 为事务设置一个BreadCrumb全标题，将会被FragmentBreadCrumbs使用
         * setBreadCrumbTitle(CharSequence text) // 为事务设置一个BreadCrumb全标题
         * setCustomAnimations(int enter, int exit, int popEnter, int popExit) // 自定义事务进入/退出以及入栈/出栈的动画效果
         * setCustomAnimations(int enter, int exit) // 自定义事务进入/退出的动画效果
         * setTransition(int transit) // 为事务设置一个标准动画
         * setTransitionStyle(int styleRes) // 为事务标准动画设置自定义样式
         * show(Fragment fragment) // 显示一个被隐藏的Fragment
         *
         */

        /**
         * 注意事项：
         * 1.初始化与构造方法 建议只调用一次
         * 2.在初始化与添加新Fragment的时候，传入的 map key 中请不要有相同的如下：
         * <p>
         * 错误的实例：
         * map.put("f1",new Fragment_1());
         * map.put("f1",new Fragment_2());
         * <p>
         * 正确的实例：
         * map.put("f1",new Fragment_1());
         * map.put("f2",new Fragment_2());
         */

        //属性
        private Activity activity;                      //获取 Activity
        private FragmentManager fm;                     //Fragment 管理器
        private FragmentTransaction transaction;        //Fragment 事务
        private int fragmentLayoutId;                   //Fragment 显示的容器 id
        private Object topFragment;                     //记录当前未加入退回栈的最顶层
        private List<String> topList;                   //记录当前 加入回退栈最顶层的 Fragment
        private Bundle savedInstanceState;              //用于鉴别当前 Activity 是否为初次创建
        private static Map<String, Object> mapSQL;       //用于存储 Fragment 之间数据传递的 Map

        /**
         * 提供给外部的访问接口
         *
         * @return
         */
        public FragmentManager getFm() {
            return fm;
        }

        /**
         * 获取当前最顶层 Fragment
         *
         * @return
         */
        public Object getTopFragment() {
            return topFragment;
        }

        /**
         * 获取 Activity
         *
         * @return
         */
        public Activity getActivity() {
            return activity;
        }

        /**
         * 构造方法 初始化 Activity、Bundle、fragmentMap 对象
         *
         * @param savedInstanceState Activity 的 savedInstanceState
         * @param activity           Activity 上下文
         * @param fm                 输入 get 第一个提示参数就是的了
         */
        public GT_Fragment initFragment(Bundle savedInstanceState, Activity activity, FragmentManager fm) {
            if (activity != null && fm != null) {
                this.activity = activity;
                this.fm = fm;
                this.savedInstanceState = savedInstanceState;
                mapSQL = new HashMap<>();
            } else {
                if (GT_LOG_TF) {
                    GT.log_v(getGT().getLineInfo(), "实例化 GT_Fragment 时， activity 或 FragmentManager 为 null");
                }
            }
            return this;
        }

        /**
         * 添加多个 Fragment   初始化
         *
         * @param fragmentLayoutId      帧布局的 id
         * @param map                   存储 Fragment 的 map
         * @param initFragmentLayoutKey 默认加载首页的页面 指定首页的 key 值
         * @return
         */
        public GT_Fragment loadFragment(int fragmentLayoutId, Map<Object, Fragment> map, Object initFragmentLayoutKey) {

            if (savedInstanceState == null) {     //如果当前 Activity 是第一次创建
                if (map != null && map.size() >= 1) {     //判断 map 非空 且 有新的 Fragment 数据
                    transaction = getTransaction();//开启事务
                    for (Object key : map.keySet()) { //遍历 所有 Fragment
                        transaction.add(fragmentLayoutId, map.get(key), key.toString());//添加 新的 Fragment
                        if (!key.equals(initFragmentLayoutKey)) { //判断当前循环的 Fragment 是否为 要显示的最顶层 Fragment 如果不是就 隐藏
                            transaction.hide(map.get(key));//隐藏 当前添加的 Fragment
                        }
                    }
                    transaction.commit();//提交事务
                    topFragment = initFragmentLayoutKey;//记录为 显示层 Fragment
                    this.fragmentLayoutId = fragmentLayoutId;//初始化 Fragment 显示的容器 id
                } else {
                    if (GT_LOG_TF) {
                        GT.log_v(getGT().getLineInfo(), "初始化 GT_Fragment 时， map 或 FragmentManager 为 null 或 map.size < 1");
                    }
                }
            }
            return this;
        }

        /**
         * 初始化 单个 Fragment
         *
         * @param fragmentLayoutId 帧布局的 id
         * @param fragment         存储 Fragment
         * @return
         */
        public GT_Fragment loadFragment(int fragmentLayoutId, Fragment fragment) {

            if (savedInstanceState == null) {     //如果当前 Activity 是第一次创建
                //判断 map 非空 且 有新的 Fragment 数据、且当前指定的首页不能大于 List 索引最大值
                if (fragment != null && fragmentLayoutId != 0) {
                    transaction = getTransaction();//开启事务
                    String key = null;//定义 key
                    key = fragment.getClass().toString();   //解析 Fragment 唯一标识
                    transaction.add(fragmentLayoutId, fragment, key);//添加 新的 Fragment
                    transaction.commit();//提交事务
                    topFragment = key;//记录为 显示层 Fragment
                    this.fragmentLayoutId = fragmentLayoutId;//初始化 Fragment 显示的容器 id
                } else {
                    if (GT_LOG_TF) {
                        GT.log_v(getGT().getLineInfo(), "初始化 GT_Fragment 时， fragment 为 null 或 fragmentLayoutId = 0");
                    }
                }
            }
            return this;
        }

        /**
         * 添加多个 Fragment   初始化
         *
         * @param fragmentLayoutId      帧布局的 id
         * @param list                  存储 Fragment 的 list
         * @param initFragmentLayoutKey 默认加载首页的页面 一般设置为 0 就如 list.get(0);
         * @return
         */
        public GT_Fragment loadFragment(int fragmentLayoutId, List<Fragment> list, int initFragmentLayoutKey) {

            if (savedInstanceState == null) {     //如果当前 Activity 是第一次创建
                //判断 map 非空 且 有新的 Fragment 数据、且当前指定的首页不能大于 List 索引最大值
                if (list != null && list.size() >= 1 && initFragmentLayoutKey <= (list.size() - 1)) {
                    transaction = getTransaction();//开启事务
                    String key = null;//定义 key
                    for (int i = 0; i < list.size(); i++) {       //遍历 List
                        Fragment fragment = list.get(i);        //获取 Fragment
                        key = fragment.getClass().toString();   //解析 Fragment 唯一标识
                        transaction.add(fragmentLayoutId, fragment, key);//添加 新的 Fragment
                        if (i == initFragmentLayoutKey) continue;//默认设置 第一号元素为 首页
                        transaction.hide(fragment);//隐藏 除第一号元素以外添加的 Fragment
                    }
                    transaction.commit();//提交事务
                    topFragment = key;//记录为 显示层 Fragment
                    this.fragmentLayoutId = fragmentLayoutId;//初始化 Fragment 显示的容器 id
                } else {
                    if (GT_LOG_TF) {
                        GT.log_v(getGT().getLineInfo(), "初始化 GT_Fragment 时， map 或 FragmentManager 为 null 或 map.size < 1");
                    }
                }
            }
            return this;
        }

        /**
         * 单个的添加 长期的 Fragment
         *
         * @param key         指定当前 Fragment 的 key 值
         * @param newFragment 开启一个新的 Fragment
         * @return
         */
        public GT_Fragment addFragment(Object key, Fragment newFragment) {
            if (key != null && newFragment != null) {    //当前 key值、newFragment值 不为空
                if (fm.findFragmentByTag(key.toString()) == null) {    //如果当前新添加的 Fragment 的 key 在容器中为重复 就进行添加
                    transaction = getTransaction();//开启事务
                    transaction.add(fragmentLayoutId, newFragment, key.toString());//将新的 Fragment 添加到 FragmentMap 中
                    transaction.hide(newFragment);//隐藏新添加的 Fragment
                    transaction.commit();//提交事务
                } else {
                    if (GT_LOG_TF) {
                        GT.log_v(getGT().getLineInfo(), "添加 addFragment 时， key 在 fragmentMap 中存在相同的 Key");
                    }
                }
            } else {
                if (GT_LOG_TF) {
                    GT.log_v(getGT().getLineInfo(), "添加 addFragment 时， key 或 FragmentManager 或 NewFragment 为 null");
                }
            }
            return this;
        }

        /**
         * 单个的添加 长期的 Fragment
         *
         * @param newFragment 添加新的 Fragment key值设置为默认的
         * @return
         */
        public GT_Fragment addFragment(Fragment newFragment) {
            if (newFragment != null) {    //当前 newFragment值 不为空
                if (fm.findFragmentByTag(newFragment.getClass().toString()) == null) {    //如果当前新添加的 Fragment 的 key 在容器中为重复 就进行添加
                    transaction = getTransaction();//开启事务
                    transaction.add(fragmentLayoutId, newFragment, newFragment.getClass().toString());//将新的 Fragment 添加到 FragmentMap 中
                    transaction.hide(newFragment);//隐藏新添加的 Fragment
                    transaction.commit();//提交事务
                } else {
                    if (GT_LOG_TF) {
                        GT.log_v(getGT().getLineInfo(), "添加 addFragment 时， key 在 fragmentMap 中存在相同的 Key");
                    }
                }
            } else {
                if (GT_LOG_TF) {
                    GT.log_v(getGT().getLineInfo(), "添加 addFragment 时， key 或 FragmentManager 或 NewFragment 为 null");
                }
            }
            return this;
        }

        /**
         * 跳转 Fragment
         *
         * @param key 跳转的 key 值
         * @return
         */
        public GT_Fragment startFragment(Object key) {
            if (!key.equals(topFragment)) {//判断 当前 要显示的 Fragment 是否为最顶层的 Fragment
                if (fm.findFragmentByTag(key.toString()) != null) {    //如果当前要切换的 Fragment 存在 Fragment 容器中
                    transaction = getTransaction();//开启事务
                    transaction.hide(fm.findFragmentByTag(topFragment.toString()));//隐藏最顶层的 Fragment
                    transaction.show(fm.findFragmentByTag(key.toString()));//显示当前指定的 fragment
                    topFragment = key;  //切换当前最顶层 Fragment
                    transaction.commit();//提交事务
                } else {
                    if (GT_LOG_TF) {
                        GT.log_v(getGT().getLineInfo(), "切换 Fragment 时， 当前要切换的 Fragment:【" + key + "】 不在容器中。");
                    }
                }
            } else {
                if (GT_LOG_TF) {
                    GT.log_v(getGT().getLineInfo(), "切换 Fragment 时， fm 为 null 获取 当前切换的 Fragment 已在最顶层无需切换");
                }
            }
            return this;
        }

        /**
         * 开启一个短期的 Fragment
         *
         * @param newFragment 直接创建一个新的 Fragment 并跳转当此 Fragment 页面
         * @return
         */
        public GT_Fragment startFragment(Fragment newFragment) {

            //实例化 记录 加入回退栈的 最顶层 Fragment
            if (topList == null) {
                topList = new ArrayList<>();
            }
            if (newFragment != null && fm != null) {
                transaction = getTransaction(); //获取事务
                String HXM = newFragment.toString();//获取 哈希码
                transaction.add(fragmentLayoutId, newFragment, HXM);//添加当前最顶层的 Fragment 且将该 Fragment 的哈希码 作为区别 Fragment 的唯一标识
                transaction.addToBackStack(HXM);//将当前的加入到退回栈
                transaction.commit();//提交事务
                topList.add(HXM);//添加当退回栈记录中
            } else {
                if (GT_LOG_TF) {
                    GT.log_v(getGT().getLineInfo(), "切换新的 Fragment 时 NewFragment 为 null");
                }
            }
            return this;
        }

        /**
         * 销毁当前退回栈中最顶层的 Fragment
         *
         * @return 执行手机的物理返回按键 ：
         * .onBackPressed();
         */
        public GT_Fragment finish() {
            if (fm != null && topList != null && topList.size() >= 1) {
                String HXM = topList.get(topList.size() - 1);
                fm.popBackStack(HXM, FragmentManager.POP_BACK_STACK_INCLUSIVE);//将加入退回栈的最顶层 Fragment 进行退栈操作
                topList.remove(HXM);//移除当前已经退出栈 Fragment 的 哈希码
            } else {
                if (GT_LOG_TF) {
                    GT.log_v(getGT().getLineInfo(), "退回栈bug：fm、topList为 null 或 topListSize == 0");
                }
            }
            return this;
        }

        /**
         * 获取事务
         *
         * @return
         */
        public FragmentTransaction getTransaction() {
            if (fm != null) {
                transaction = fm.beginTransaction();
            } else {
                if (GT_LOG_TF) {
                    GT.log_v(getGT().getLineInfo(), "fm 管理器为 null");
                }
            }
            return transaction;
        }

        /**
         * 为基类初始化必要的属性（推荐使用）
         *
         * @param view
         */
        @SuppressLint("NewApi")
        public void initBaseFragment(View view) {

            ColorDrawable colorDrawable = (ColorDrawable) view.getBackground();//获取 View 背景颜色

            if (colorDrawable != null) {
                view.setBackground(colorDrawable);//设置 用户指定的颜色
            } else {
                view.setBackgroundColor(Color.WHITE);// 设置为 默认的 白色
            }

            //解决 Fragment 点击事件穿透问题
            view.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return true;
                }
            });


        }

        /**
         * 监听 Fragment 返回键
         *
         * @param view          Fragment 的 View
         * @param onKeyListener new  一个内部类
         *                      注意使用正确实例：
         *                      <p>
         *                      private long exitTime = 0;
         *                      //按两下返回键 弹出退出提示
         *                      private void onKeyDown(){
         *                      gt_fragment.onKeyDown(getView(), new View.OnKeyListener() {
         * @Override public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
         * if(keyCode == 4 && keyEvent.getAction() == KeyEvent.ACTION_DOWN){
         * if((System.currentTimeMillis()-exitTime) > 2000){
         * exitTime = System.currentTimeMillis();
         * }else{
         * GT.toast_s("退出");
         * }
         * return true;//只将 返回按键进行监听
         * }
         * return false;//其余的如 音量小 音量大什么的，交给 Activity 管理
         * }
         * });
         * }
         */
        public void onKeyDown(View view, View.OnKeyListener onKeyListener) {

            /**
             * 判断用例：如   if(keyCode == 4 && keyEvent.getAction() == KeyEvent.ACTION_DOWN)
             *  返回键：
             *  【keyCode:4，KEYCODE_ENTER:66==getAction:0，ACTION_DOWN:0
             *  【keyCode:4，KEYCODE_ENTER:66==getAction:1，ACTION_DOWN:0
             *
             *  音量小：
             *  【keyCode:25，KEYCODE_ENTER:66==getAction:0，ACTION_DOWN:0
             *  【keyCode:25，KEYCODE_ENTER:66==getAction:1，ACTION_DOWN:0
             *
             *  音量大：
             *  【keyCode:24，KEYCODE_ENTER:66==getAction:0，ACTION_DOWN:0
             *  【keyCode:24，KEYCODE_ENTER:66==getAction:1，ACTION_DOWN:0
             */

            view.setFocusableInTouchMode(true);
            view.requestFocus();
            view.setOnKeyListener(onKeyListener);
        }


        /**
         * 屏蔽掉 Fragment 的 物理返回键
         *
         * @param view
         */
        public void shieldKey(View view) {

            /**
             * 判断用例： 如 if(keyCode == 4 && keyEvent.getAction() == KeyEvent.ACTION_DOWN)
             *  返回键：
             *  【keyCode:4，KEYCODE_ENTER:66==getAction:0，ACTION_DOWN:0
             *  【keyCode:4，KEYCODE_ENTER:66==getAction:1，ACTION_DOWN:0
             *
             *  音量小：
             *  【keyCode:25，KEYCODE_ENTER:66==getAction:0，ACTION_DOWN:0
             *  【keyCode:25，KEYCODE_ENTER:66==getAction:1，ACTION_DOWN:0
             *
             *  音量大：
             *  【keyCode:24，KEYCODE_ENTER:66==getAction:0，ACTION_DOWN:0
             *  【keyCode:24，KEYCODE_ENTER:66==getAction:1，ACTION_DOWN:0
             */

            view.setFocusableInTouchMode(true);
            view.requestFocus();
            view.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                    if (keyCode == 4 && keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                        return true;//只将 返回按键进行监听
                    }
                    return false;//其余的如 音量小 音量大什么的，交给 Activity 管理
                }
            });
        }


        /**
         * 释放 Fragment 管理器的所有资源
         */
        public void close() {

            //遍历将 栈中的 Fragment 给踢出
            for (String HXM : topList) {
                fm.popBackStack(HXM, FragmentManager.POP_BACK_STACK_INCLUSIVE);//将加入退回栈的最顶层 Fragment 进行退栈操作
            }

            if (topList != null) {
                topList.clear();//清除 list 中树
                topList = null;//置空
            }

            if (transaction != null) {
                transaction = null;
            }

            if (fm != null) {
                fm = null;
            }

            if (activity != null) {
                activity = null;
            }

            if (mapSQL != null) {
                mapSQL.clear();
                mapSQL = null;
            }

        }


        /**
         * 用作于 Fragment 之间传递数据的 中间存储的方法
         * 好处可以将 Fragment 进一步解耦
         */

        //增加数据
        public GT_Fragment setData(Object key, Object data) {
            if (mapSQL != null) {
                if (!mapSQL.containsKey(key.toString())) {
                    mapSQL.put(key.toString(), data);
                } else {
                    log_e(getGT().getLineInfo(), "FragmentSQL 报错：添加 数据时 已存在当前 key 建议调用 update 方法进行修改");
                }
            }
            return this;
        }

        //删除数据
        public GT_Fragment deData(Object key) {
            if (mapSQL != null) {
                if (mapSQL.containsKey(key.toString())) {
                    mapSQL.remove(key.toString());
                } else {
                    log_e(getGT().getLineInfo(), "FragmentSQL 报错：删除 数据时 当前 key 不存在，无法进行删除");
                }
            }
            return this;
        }

        //查询数据
        public Object getData(Object key) {
            if (mapSQL != null) {
                if (mapSQL.containsKey(key.toString())) {
                    return mapSQL.get(key.toString());
                } else {
                    log_e(getGT().getLineInfo(), "FragmentSQL 报错：查询 数据时 当前 key 不存在，无法进行查询");
                }
            }
            return null;
        }

        //修改数据
        public GT_Fragment upData(Object key, Object data) {
            if (mapSQL != null) {
                if (mapSQL.containsKey(key.toString())) {
                    mapSQL.put(key.toString(), data);
                } else {
                    log_e(getGT().getLineInfo(), "FragmentSQL 报错：修改 数据时 当前 key 不存在，无法进行修改");
                }
            }
            return this;
        }

        //清空数据
        public GT_Fragment clearData() {
            if (mapSQL != null) {
                mapSQL.clear();
            }
            return this;
        }


    }

    /**
     * 封装普通的 Activity 管理器
     */
    public abstract static class BaseActivity extends AppCompatActivity{

        /** 初始化 加载布局 */
        protected abstract int initLayout(Bundle savedInstanceState);

        /** 在绘制完 View 之前设置数据 */
        protected void initDrawView(){}

        /** 初始化 UI */
        protected abstract void initView();

        /** 功能方法 */
        protected void function(){}

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            initDrawView();//设置绘制前的数据
            setContentView(initLayout(savedInstanceState));//加载布局
            initView();//初始化 UI
            function();//功能方法
        }

        /**
         * 构建 GT 工具包
         * @param context
         */
        protected void build(Context context){
            GT.getGT().build(context);
        }

        /**
         * 跳转 Activity
         * @param activityClass
         */
        protected void startActivity(Class activityClass){
            GT.startAct(activityClass);
        }

        /**
         * 普通日志
         * @param object
         */
        protected void log(Object object){
            GT.log_i(object);
        }

        /**
         * 带 TAG 的普通日志
         * @param tag
         * @param object
         */
        protected void log(Object tag,Object object){
            GT.log_i(tag,object);
        }

        /**
         * 错误日志
         * @param object
         */
        protected void err(Object object){
            GT.log_e(object);
        }

        /**
         * 带 TAG 的错误日志
         * @param tag
         * @param object
         */
        protected void err(Object tag,Object object){
            GT.log_e(tag,object);
        }

        /**
         * 普通的 Toast
         * @param object
         */
        protected void toast(Object object){
            GT.toast_s(object);
        }

        /**
         * 带 Context 的 Toast
         * @param context
         * @param object
         */
        protected void toast(Context context, Object object){
            GT.toast_s(context,object);
        }

        /**
         * 带 延时的 的 Toast
         * @param time
         * @param object
         */
        protected void toast(long time, Object object){
            GT.toast_time(object,time);
        }


    }

    /**
     * 封装注解的 Activity 管理器
     */
    public abstract static class AnnotationActivity extends AppCompatActivity{

        /** 在绘制完 View 之前设置数据 */
        protected void initDrawView(){}

        /** 初始化 UI */
        protected abstract void initView();

        /** 功能方法 */
        protected void function(){}

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            initDrawView();//设置绘制前的数据
            initView();//初始化 UI
            function();//功能方法
        }

        /**
         * 构建 GT 工具包
         * @param context
         */
        protected void build(Context context){
            GT.getGT().build(context);
        }

        /**
         * 跳转 Activity
         * @param activityClass
         */
        protected void startActivity(Class activityClass){
            GT.startAct(activityClass);
        }

        /**
         * 普通日志
         * @param object
         */
        protected void log(Object object){
            GT.log_i(object);
        }

        /**
         * 带 TAG 的普通日志
         * @param tag
         * @param object
         */
        protected void log(Object tag,Object object){
            GT.log_i(tag,object);
        }

        /**
         * 错误日志
         * @param object
         */
        protected void err(Object object){
            GT.log_e(object);
        }

        /**
         * 带 TAG 的错误日志
         * @param tag
         * @param object
         */
        protected void err(Object tag,Object object){
            GT.log_e(tag,object);
        }

        /**
         * 普通的 Toast
         * @param object
         */
        protected void toast(Object object){
            GT.toast_s(object);
        }

        /**
         * 带 Context 的 Toast
         * @param context
         * @param object
         */
        protected void toast(Context context, Object object){
            GT.toast_s(context,object);
        }

        /**
         * 带 延时的 的 Toast
         * @param time
         * @param object
         */
        protected void toast(long time, Object object){
            GT.toast_time(object,time);
        }

    }

    //============================================= 设备监听类 ======================================

    public static class DeviceListening {

        //获取当前手机信息
        public static class MobilePhoneAttribute {

            /**
             * 获取手机型号
             *
             * @return
             */
            public String getModel() {
                return Build.MODEL;
            }

            /**
             * 获取手机SDK版本号
             *
             * @return
             */
            public String getSDK() {
                return Build.VERSION.SDK;
            }

            /**
             * 获取手机系统版本号
             *
             * @return
             */
            public String getRELEASE() {
                return Build.VERSION.RELEASE;
            }

        }

        //AudioManager 安卓手机音量类
        public static class GT_AudioManager {
            /**
             * 提示：再设置音量大小时，请先搞清楚，该音量的最大值
             */
            private AudioManager mAudioManager;//定义 AudioManager
            private Activity activity;//定义 Activity
            private int max;//最大值
            private int current;//当前值

            /**
             * 初始化
             *
             * @param activity
             */
            public GT_AudioManager(Activity activity) {
                this.activity = activity;
                mAudioManager = (AudioManager) activity.getSystemService(activity.AUDIO_SERVICE);
            }//初始化

            /**
             * 获取 通话声音 最大值 与 当前通过的声音值
             *
             * @return
             */
            public int getVoiceCall() {
                current = mAudioManager.getStreamVolume(AudioManager.STREAM_VOICE_CALL);
                return current;
            }

            /**
             * 获取 音量操作类对象
             *
             * @return
             */
            public int getVoiceCallMax() {
                max = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL);
                return max;
            }

            /**
             * 设置音量大小
             *
             * @param value
             */
            public void setVoiceCallValue(int value) {
                mAudioManager.setStreamVolume(AudioManager.STREAM_VOICE_CALL, value, AudioManager.FLAG_PLAY_SOUND);//设置 通话声音 音量大小为 0 静音
            }//设置 通话声音 的音量

            /**
             * 获取当前手机的声音值
             *
             * @return
             */
            public int getVoiceSystem() {
                max = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_SYSTEM);
                current = mAudioManager.getStreamVolume(AudioManager.STREAM_SYSTEM);
                return current;
            }

            /**
             * 获取 系统音量 最大值
             *
             * @return
             */
            public int getVoiceSystemMax() {
                max = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_SYSTEM);
                return max;
            }

            /**
             * 设置系统音量值
             *
             * @param value
             */
            public void setVoiceSystemValue(int value) {
                mAudioManager.setStreamVolume(AudioManager.STREAM_SYSTEM, value, AudioManager.FLAG_PLAY_SOUND);//设置 通话声音 音量大小为 0 静音
            }//设置 系统音量 的音量

            /**
             * 获取 当前通过的声音值
             *
             * @return
             */
            public int getVoiceRing() {
                current = mAudioManager.getStreamVolume(AudioManager.STREAM_RING);
                return current;
            }

            /**
             * 铃声音量 最大值
             *
             * @return
             */
            public int getVoiceRingMax() {
                max = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_RING);
                return max;
            }

            /**
             * 设置 铃声音量 的音量
             *
             * @param value
             */
            public void setVoiceRingValue(int value) {
                mAudioManager.setStreamVolume(AudioManager.STREAM_RING, value, AudioManager.FLAG_PLAY_SOUND);//设置 铃声音量 音量大小为 0 静音
            }//设置 铃声音量 的音量

            /**
             * 获取 当前通过的声音值
             *
             * @return
             */
            public int getVoiceMusic() {
                current = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                return current;
            }

            /**
             * 获取 音乐音量(多媒体) 最大值
             *
             * @return
             */
            public int getVoiceMusicMax() {
                max = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                return max;
            }

            /**
             * 设置 多媒体 的音量
             *
             * @param value
             */
            public void setMusicValue(int value) {
                mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, value, AudioManager.FLAG_PLAY_SOUND);//设置多媒体音量大小为 0 静音
            }//设置 多媒体 的音量

            /**
             * 获取  当前通过的声音值
             *
             * @return
             */
            public int getVoiceAlarm() {
                current = mAudioManager.getStreamVolume(AudioManager.STREAM_ALARM);
                return current;
            }

            /**
             * 获取 提示声音 音量 最大值
             *
             * @return
             */
            public int getVoiceAlarmMax() {
                max = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_ALARM);
                return max;
            }

            /**
             * 设置 提示声音 的音量
             *
             * @param value
             */
            public void setVoiceAlarmValue(int value) {
                mAudioManager.setStreamVolume(AudioManager.STREAM_ALARM, value, AudioManager.FLAG_PLAY_SOUND);//设置 铃声音量 音量大小为 0 静音
            }//设置 提示声音 的音量

            /**
             * 游戏过程中只允许调整多媒体音量，而不允许调整通话音量。
             */
            public void gemgMusiceNoSet() {
                activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
            }//游戏过程中只允许调整多媒体音量，而不允许调整通话音量。

        }

        //ScreenListener 监听屏幕状态类
        public static class ScreenListener {
            /**
             * 监听
             * 手机屏幕点亮
             * 手机屏幕锁屏
             * 手机屏幕解锁
             * <p>
             * 使用实例:
             * GT.ScreenListener screenListener  = new GT.ScreenListener(this); //初始化 ScreenListener
             * screenListener.begin(new GT.ScreenListener.ScreenStateListener(){....} //new 一个匿名内部类 即可
             * 在销毁该 Activity 时一定要 调用该方法来注销广播
             * unregisterListener(); 方法来注销该广播
             */

            private Context context2;                                //联系上下文
            private ScreenBroadcastReceiver mScreenReceiver;        //定义一个广播
            private ScreenStateListener mScreenStateListener;       //定义个内部接口

            /**
             * 初始化
             */
            public ScreenListener(Context context) {
                this.context2 = context;
                mScreenReceiver = new ScreenBroadcastReceiver();//初始化广播
            }

            /**
             * 自定义接口
             */
            public interface ScreenStateListener {
                void onScreenOn();            //手机屏幕点亮

                void onScreenOff();            //手机屏幕锁屏

                void onUserPresent();        //手机屏幕解锁
            }

            /**
             * 获取screen的状态
             */
            private void getScreenState() {
                //初始化powerManager
                PowerManager manager = (PowerManager) context2.getSystemService(Context.POWER_SERVICE);
                if (manager.isScreenOn()) {   //如果监听已经开启
                    if (mScreenStateListener != null) {
                        mScreenStateListener.onScreenOn();
                    }
                } else {                      //如果监听没开启
                    if (mScreenStateListener != null) {
                        mScreenStateListener.onScreenOff();
                    }
                }
            }

            /**
             * 写一个内部的广播
             */
            private class ScreenBroadcastReceiver extends BroadcastReceiver {
                private String action = null;

                @Override
                public void onReceive(Context context, Intent intent) {
                    action = intent.getAction();
                    if (Intent.ACTION_SCREEN_ON.equals(action)) {        //屏幕亮时操作
                        mScreenStateListener.onScreenOn();
                    } else if (Intent.ACTION_SCREEN_OFF.equals(action)) {   //屏幕关闭时操作
                        mScreenStateListener.onScreenOff();
                    } else if (Intent.ACTION_USER_PRESENT.equals(action)) {//解锁时操作
                        mScreenStateListener.onUserPresent();
                    }
                }
            }

            /**
             * 开始监听广播状态
             */
            public void begin(ScreenStateListener listener) {
                mScreenStateListener = listener;
                registerListener();                                //注册监听
                getScreenState();                                //获取监听
            }

            /**
             * 启动广播接收器
             */
            private void registerListener() {
                IntentFilter filter = new IntentFilter();
                filter.addAction(Intent.ACTION_SCREEN_ON);            //屏幕亮起时开启的广播
                filter.addAction(Intent.ACTION_SCREEN_OFF);            //屏幕关闭时开启的广播
                filter.addAction(Intent.ACTION_USER_PRESENT);        //屏幕解锁时开启的广播
                context2.registerReceiver(mScreenReceiver, filter);    //发送广播

            }

            /**
             * 解除广播
             */
            public void unregisterListener() {
                context2.unregisterReceiver(mScreenReceiver); //注销广播
            }
        }

        //HeadsetPlugReceiver 监听耳机是否插入
        public static class GT_HeadsetPlugReceiver {

            /**
             * 监听 耳机
             * <p>
             * 使用实例:
             * GT.GT_HeadsetPlugReceiver gt_headsetPlugReceiver = new GT.GT_HeadsetPlugReceiver(this); //初始化 GT_HeadsetPlugReceiver
             * gt_headsetPlugReceiver.isHeadset_TF();    //获取当前耳机的状态  插入则返回 true 否则返回 false
             * 在销毁该 Activity 时一定要 调用该方法来注销广播
             * unregisterListener(); 方法来注销该广播
             */

            private Activity activity;
            private static boolean headset_TF;//定义耳机是否插入
            private HeadsetPlugReceiver headsetPlugReceiver;//监听手机是否有耳机插入广播

            /**
             * 检测是否插入耳机
             *
             * @return true则插入 false则未插入
             */
            public boolean isHeadset_TF() {
                registerHeadsetPlugReceiver();
                return headset_TF;
            }

            /**
             * 实例化 耳机监听
             *
             * @param activity
             */
            public GT_HeadsetPlugReceiver(Activity activity) {
                this.activity = activity;
            }

            /**
             * /注销广播
             */
            public void unregisterListener() {
                activity.unregisterReceiver(headsetPlugReceiver); //注销广播
            }

            /**
             * 注册 广播
             */
            public void registerHeadsetPlugReceiver() {
                headsetPlugReceiver = new HeadsetPlugReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.HEADSET_PLUG");
                activity.registerReceiver(headsetPlugReceiver, intentFilter);
            }

            /**
             * 内部类
             */
            private static class HeadsetPlugReceiver extends BroadcastReceiver {
                @Override
                public void onReceive(Context context, Intent intent) {
                    if (intent.hasExtra("state")) {
                        if (intent.getIntExtra("state", 0) == 0) {
                            if (GT_LOG_TF)
                                log_v("耳机测试: 没插入耳机");
                            headset_TF = false;
                        } else if (intent.getIntExtra("state", 0) == 1) {
                            if (GT_LOG_TF)
                                log_v("耳机测试: 插入耳机");
                            headset_TF = true;
                        }
                    }
                }
            }

        }

        //Spiritleve 屏幕旋转监听
        public abstract static class Spiritleve implements SensorEventListener {
            /**
             * * 用法如下：
             * * //屏幕旋转监听 内部类
             * *     class SV extends SpiritleveView{
             * *
             * *         public SV(Context context) {
             * *             super(context);
             * *         }
             * *
             * *         @Override
             * *         protected void getPosition(float xAngle, float yAngle) {
             * *             super.getPosition(xAngle, yAngle);
             * *             GT.log_i("X:" + (int)xAngle + "," + "Y:" + (int)yAngle);
             * *         }
             * *     }
             * *
             * *     最后再在方法中初始化
             * *      new SV(activity);
             * *
             */
            float[] acceleromterValues = new float[3];//加速度传感器的值
            float[] magneticValues = new float[3];//磁场传感器的值

            //动作定义 常量
            public static final int LIE_LOW = 0;         //平躺
            public static final int SLEEPER = 1;         //卧铺
            public static final int STAND_RIGHT = 2;     //右立;
            public static final int LEFT_STANDING = 3;   //左立
            public static final int STAND = 4;           //站立
            public static final int HANDSTAND = 5;       //倒立

            public static final int ZHP = 1;            //正横屏
            public static final int FHP = -1;           //反横屏
            public static final int ZSP = 2;            //正竖屏
            public static final int FSP = -2;           //反竖屏

            private SensorManager sensorManager;       //定义取消屏幕监听

            public Spiritleve(Context context) {
                sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);//获取传感器管理器
                //为磁场传感器注册监听器
                sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), SensorManager.SENSOR_DELAY_GAME);
                //为加速度传感器注册监听器
                sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_GAME);
            }

            @Override
            public void onSensorChanged(SensorEvent event) {    //值改变触发

                if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                    acceleromterValues = event.values.clone();//获取加速度传感器的值
                } else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
                    magneticValues = event.values.clone();//获取磁场传感器的值
                }

                float[] R = new float[9];//保存旋转数据的数组
                float[] values = new float[3];//保存方向数据的数组

                SensorManager.getRotationMatrix(R, null, acceleromterValues, magneticValues);//获得一个包含旋转矩阵的数组
                SensorManager.getOrientation(R, values);//获取方向值

                float xAngle = (float) Math.toDegrees(values[1]);//x轴旋转角度
                float yAngle = (float) Math.toDegrees(values[2]);//y轴旋转角度

                getPosition(xAngle, yAngle);//获取小球的位置坐标

            }

            //根据X轴和Y轴的旋转角度确定小篮球的位置
            protected void getPosition(float xAngle, float yAngle) {
                /*
                    这里会返回具体的手机位置信息
                    使用 getMobilePosition 或 getScreenPosition 方法判定 当前手机的位置
                 */
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                //精度改变触发
            }

            /**
             * 获取当前手机位置
             * 手机仰天躺(LIE_LOW)、手机卧铺躺(SLEEPER)、手机右立(STAND_RIGHT)、
             * 手机左立(LEFT_STANDING)、手机站起(STAND)、手机倒立(HANDSTAND)
             */
            public int getMobilePosition(float xAngle, float yAngle) {
                int X = (int) xAngle;
                int Y = (int) yAngle;
                if ((X >= -10 && X <= 10) && (Y >= -10 && Y <= 10)) {//手机仰天躺
                    return LIE_LOW;
                } else if ((X >= -10 && X <= 10) && (Y >= 170 && Y <= 179)) {//手机卧铺躺
                    return SLEEPER;
                } else if ((X >= 0 && X <= 2) && (Y >= 11 && Y <= 90)) {//手机右立
                    return STAND_RIGHT;
                } else if ((X >= 0 && X <= 2) && (Y <= -1 && Y >= -90)) {//手机左立
                    return LEFT_STANDING;
                } else if (X <= -50 && X >= -90) {//手机站起
                    return STAND;
                } else if ((X >= 50 && X <= 90)) {//手机倒立
                    return HANDSTAND;
                }
                return SLEEPER;//默认仰天躺
            }

            /**
             * 获取当前手机屏幕位置
             * 正横屏(ZHP.1)、反横屏(FHP.-1)、竖屏(SP.0)
             */
            public int getScreenPosition(float xAngle, float yAngle) {
                int X = (int) xAngle;
                int Y = (int) yAngle;

                if ((X >= -30 && X <= 0) && (Y <= -40 && Y >= -179)) {
                    return ZHP;
                } else if ((X >= -30 && X <= 0) && (Y >= 40 && Y <= 179)) {
                    return FHP;
                } else if ((X >= -90 && X <= -10) && (Y >= -39 && Y <= 179)) {
                    return ZSP;
                } else if ((X <= 90 && X >= 10) && (Y <= 39 && Y >= -179)) {
                    return FSP;
                }
                return -181;//默认正横屏
            }

            public void close() {
                sensorManager.unregisterListener(this);//取消注册的屏幕监听
            }

        }


    }


    //============================================= 多媒体类 ========================================

    /**
     * 播放音乐 长音频
     */
    public static class GT_MediaPlayer {

        /**
         * 本类使用案列：
         * GT.GT_MediaPlayer mediaPlayer = new GT.GT_MediaPlayer(this);//实例化对象
         * mediaPlayer.loadMusic(R.raw.bg_music);  //加载 或 更新 将要播放的 音频， 此方法可用于 更新接下来要播放的音频
         * mediaPlayer.play_pause();//暂停 或 播放
         * mediaPlayer.stop();//停止播放
         * mediaPlayer.close();//释放资源
         * <p>
         * 相关属性设置
         * int getDuration()：获取流媒体的总播放时长，单位是毫秒。
         * int getCurrentPosition()：获取当前流媒体的播放的位置，单位是毫秒。
         * void seekTo(int msec)：设置当前MediaPlayer的播放位置，单位是毫秒。
         * void setLooping(boolean looping)：设置是否循环播放。
         * boolean isLooping()：判断是否循环播放。
         * boolean  isPlaying()：判断是否正在播放。
         * void prepare()：同步的方式装载流媒体文件。
         * void prepareAsync()：异步的方式装载流媒体文件。
         * void release ()：回收流媒体资源。
         * void setAudioStreamType(int streamtype)：设置播放流媒体类型。
         * void setWakeMode(Context context, int mode)：设置CPU唤醒的状态。
         * setNextMediaPlayer(MediaPlayer next)：设置当前流媒体播放完毕，下一个播放的MediaPlayer。
         */
        private boolean isPlay = true;    //定义是否为可播放状态
        private Activity activity;
        private MediaPlayer mediaPlayer;
        private int resid = 0;
        private String url = null;


        /**
         * 获取 mediaPlayer 组件
         *
         * @return
         */
        public MediaPlayer getMediaPlayer() {
            return mediaPlayer;
        }

        /**
         * 初始化音频播放的上下文
         *
         * @param activity
         */
        public GT_MediaPlayer(Activity activity) {
            this.activity = activity;
        }//初始化 上下文

        /**
         * 加载 res 目录下的资源文件
         *
         * @param resid
         * @return
         */
        public GT_MediaPlayer loadMusic(int resid) {
            this.resid = resid;
            if (!isPlay) {       //停止过播放
                if (mediaPlayer.isPlaying()) {//如果属于播放状态
                    mediaPlayer.stop();//停止播放
                    mediaPlayer.release();//释放资源
                }
            }
            mediaPlayer = null;//清空内存中对象
            mediaPlayer = MediaPlayer.create(activity, resid);    //初始化 MediaPlayer 对象
            isPlay = true;//恢复可播放状态
            return this;
        }//加载 res 目录下的资源文件

        /**
         * 获取 网络 或 SD 上的的音频资源
         *
         * @param url
         * @return
         */
        public GT_MediaPlayer loadMusic(String url) {
            this.url = url;
            if (!isPlay) {       //停止过播放
                if (mediaPlayer.isPlaying()) {//如果属于播放状态
                    mediaPlayer.stop();//停止播放
                }
                mediaPlayer.release();//释放资源
            }
            mediaPlayer = null;//清空内存中对象
            mediaPlayer = new MediaPlayer();
            try {
                mediaPlayer.setDataSource(url);
                mediaPlayer.prepare();//预加载音频
            } catch (IOException e) {
//                e.printStackTrace();
                GT.log_e(getGT().getLineInfo(), "你的音频资源可能 需要添加 网络或访问SD卡的读取权限，否则无法进行有效的获取资源 url:" + url);
            }
            isPlay = true;//恢复可播放状态
            return this;
        }//获取 网络 或 SD 上的的音频资源

        /**
         * 播放音频
         *
         * @return
         */
        public GT_MediaPlayer play() {
            if (mediaPlayer != null) {
                recover_play();//如果音频被停止了就恢复音频可播放，在进行 start
                mediaPlayer.start();
            }
            return this;
        }//播放

        /**
         * 暂停播放
         *
         * @return
         */
        public GT_MediaPlayer pause() {
            if (mediaPlayer != null) {
                mediaPlayer.pause();
            }
            return this;
        }//暂停

        /**
         * 播放 与 暂停
         *
         * @return
         */
        public GT_MediaPlayer play_pause() {
            recover_play();//如果音频被停止了就恢复音频可播放，在进行 start
            if (!mediaPlayer.isPlaying()) {        //如果当前的 mediaPlayer 处于暂停状态  且 播放状态为 false 没有在播放
                mediaPlayer.start();//继续播放
            } else {  //当前处于音乐暂停状态
                mediaPlayer.pause();//暂停音乐
            }
            return this;
        }//播放 与 暂停

        /**
         * 停止音乐
         *
         * @return
         */
        public GT_MediaPlayer stop() {
            isPlay = false;//设置为暂停状态
            mediaPlayer.stop();
            return this;
        }//停止音乐

        /**
         * 恢复可播放
         *
         * @return
         */
        private GT_MediaPlayer recover_play() {
            if (!isPlay) {       //停止过播放
                if (mediaPlayer.isPlaying()) {//如果属于播放状态
                    mediaPlayer.stop();//停止播放
                }
                mediaPlayer.release();//释放资源
                mediaPlayer = null;//清空内存中对象
                if (resid != 0) {
                    mediaPlayer = MediaPlayer.create(activity, resid);    //初始化 MediaPlayer 对象
                } else if (url != null) {
                    mediaPlayer = new MediaPlayer();
                    try {
                        mediaPlayer.setDataSource(url);
                        mediaPlayer.prepare();//预加载音频
                    } catch (IOException e) {
                        GT.log_e(getGT().getLineInfo(), "你的音频资源可能 需要添加 网络或访问SD卡的读取权限，否则无法进行有效的获取资源 url:" + url);
                    }
                }
                isPlay = true;//恢复可播放状态
            }
            return this;
        }//恢复可播放

        /**
         * 释放资源
         */
        public void close() {
            if (mediaPlayer.isPlaying()) {//如果属于播放状态
                mediaPlayer.stop();//停止播放
            }
            mediaPlayer.release();//释放资源
            mediaPlayer = null;
        }//释放资源


    }

    /**
     * 播放音频 短音频
     */
    public static class GT_SoundPool {

        private Context context;
        private static SoundPool soundPool;
        private AudioAttributes attr = null;
        private static Map<String, Integer> map = new HashMap<>();      //初始化 map  用于存放 音频 key 与 值
        private static Map<String, Integer> mapMusic = new HashMap<>(); //初始化 mapMusic 用于存放待播放的音频

        /**
         * 初始化 Content
         *
         * @param context
         */
        public GT_SoundPool(Context context) {
            this.context = context;
        }

        /**
         * 设置音频属性
         *
         * @param attr
         * @return
         */
        public GT_SoundPool setAudioAttributes(AudioAttributes attr) {
            this.attr = attr;
            return this;
        }//设置音频属性


        /**
         * 加载音频
         *
         * @param map
         * @return
         */
        @SuppressLint("NewApi")
        public GT_SoundPool initMusic(Map<String, Integer> map) {
            if (map != null) {
                this.map = map;
                if (attr == null) {
                    //设置音效属性 如果为空,就设置默认的音频属性
                    attr = new AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_GAME)//设置音效的使用场景 为游戏
                            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)//设置音效类型
                            .build();
                }

                //初始化
                soundPool = new SoundPool.Builder()
                        .setAudioAttributes(attr)//设置音效池的属性
                        .setMaxStreams(map.size())//最大容纳 动态添加最大值 个音频
                        .build();

                loadMusic();//初始化 音频流
            }
            return this;
        }

        /**
         * 添加音频
         *
         * @param key
         * @param rawId
         * @return
         */
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public GT_SoundPool addMusic(String key, int rawId) {
            if (map != null) {
                if (!map.containsKey(key)) { //如果当前 map 中没有此 key
                    map.put(key, rawId); //将值保存到 map 中

                    if (attr == null) {
                        //设置音效属性 如果为空,就设置默认的音频属性
                        attr = new AudioAttributes.Builder()
                                .setUsage(AudioAttributes.USAGE_GAME)//设置音效的使用场景 为游戏
                                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)//设置音效类型
                                .build();
                    }

                    //初始化
                    soundPool = new SoundPool.Builder()
                            .setAudioAttributes(attr)//设置音效池的属性
                            .setMaxStreams(map.size())//最大容纳 动态添加最大值 个音频
                            .build();

                    loadMusic();//初始化 音频流

                } else {
                    GT.log_v(getGT().getLineInfo(), "添加音频无效，当前已经包含相同的 key，无法再进行装载相同的 key");//提示无效的添加
                }
            }
            return this;
        } //添加音频

        /**
         * 初始化音频
         */
        private void loadMusic() {
            if (map != null) {
                for (String key : map.keySet()) {
                    mapMusic.put(key, soundPool.load(context, map.get(key), 1));//初始化 待播放的音频
                }
            }
        }//初始化音频

        /**
         * 移除音频
         *
         * @param key
         * @return
         */
        public GT_SoundPool removalMusic(Integer key) {
            if (map != null) {
                if (map.containsKey(key)) {
                    map.remove(key);
                    mapMusic.remove(key);
                    loadMusic();//初始化音频
                } else {
                    log_v(getGT().getLineInfo(), "移除音频失败，当前并不存在此 key:" + key);
                }
            }
            return this;
        }//移除音频

        /**
         * 清空音频
         *
         * @return
         */
        public GT_SoundPool clear() {
            if (map != null) {
                map.clear();
                mapMusic.clear();
            }
            return this;
        }//清空音频

        /**
         * 修改音频
         *
         * @param key
         * @param rawId
         * @return
         */
        public GT_SoundPool updateMusic(String key, Integer rawId) {
            if (map != null) {
                if (map.containsKey(key)) {
                    map.put(key, rawId);
                    mapMusic.put(key, rawId);
                    loadMusic();//初始化音频
                } else {
                    GT.log_v(getGT().getLineInfo(), "修改音频无效，当前并不存在当前 key，无法进行更新操作");//提示无效的更新
                }
            }
            return this;
        }//修改音频

        /**
         * 播放音频
         *
         * @param key  指定播放的音频key
         * @param loop 是否循环 false为不循环, true 为循环
         * @param rate 速率 为正常速率 1  最低为 0.5，最高为 2
         * @return
         */
        public GT_SoundPool play(String key, boolean loop, float rate) {
            //播放所选音频
            soundPool.play(
                    mapMusic.get(key),           //指定播放的音频 key
                    1,              //左声道 为0.0 到 1.0
                    1,             //右声道 为0.0 到 1.0
                    0,                 //优先级 0
                    (loop == true ? -1 : 0),    //是否循环 0为不循环, -1 为循环
                    rate                        //速率 为正常速率 1  最低为 0.5，最高为 2
            );

            return this;
        }
    }

    /**
     * 播放视频
     */
    public static class GT_Video implements SurfaceHolder.Callback {

        /**
         * 使用说明：
         * 第一步：在 xml 中 定义好 SurfaceView 组件
         * 第二步：video = new GT.GT_Video(this,R.raw.lmh,surfaceView);//初始化 GT_Video 视频播放器
         * 第三步：播放 video.play();、暂停 video.pause();、 停止 video.stop();、释放资源 video.close();
         */

        private MediaPlayer mediaPlayer = null;
        private SurfaceView surfaceView;
        private SurfaceHolder surfaceHolder;
        private Context context;
        private int resId;
        private static boolean isPlay = true;   //定义是否被停止播放过视频

        /**
         * 初始化视频 ()注意，需要单击才有效果 一个坑
         *
         * @param context     上下文
         * @param resId       资源id
         * @param surfaceView surfaceView
         */
        public GT_Video(Context context, int resId, SurfaceView surfaceView) {
            this.context = context;
            this.surfaceView = surfaceView;
            this.resId = resId;
            surfaceHolder = this.surfaceView.getHolder();
            surfaceHolder.addCallback(this);
        }

        /**
         * 播放 视频
         *
         * @return
         */
        public GT_Video play() {
            GT.log_e("mediaPlayer:" + mediaPlayer);
            if (mediaPlayer != null) {
                recover_play();
                GT.log_e("播放");
                mediaPlayer.start();
            }
            return this;
        }

        /**
         * 暂停视频
         *
         * @return
         */
        public GT_Video pause() {
            if (mediaPlayer != null) {
                recover_play();
                mediaPlayer.pause();
            }
            return this;
        }

        /**
         * 释放资源
         *
         * @return
         */
        public GT_Video stop() {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                isPlay = false;
            }
            return this;
        }

        /**
         * 恢复可播放
         *
         * @return
         */
        private MediaPlayer recover_play() {
            if (!isPlay) {       //停止过播放
                close();
                mediaPlayer = null;//清空内存中对象
                if (resId != 0) {
                    mediaPlayer = MediaPlayer.create(context, resId);//设置加载的视频资源
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mediaPlayer.setDisplay(surfaceHolder);    //设置显示视频显示在SurfaceView上
                }
                isPlay = true;//恢复可播放状态
            }
            return mediaPlayer;
        }//恢复可播放


        /**
         * 释放资源
         */
        public void close() {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
        }//释放资源


        /**
         * 初始化 视频 数据
         *
         * @param holder
         */
        public void surfaceCreated(SurfaceHolder holder) {
            mediaPlayer = MediaPlayer.create(context, resId);//设置加载的视频资源
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDisplay(surfaceHolder);    //设置显示视频显示在SurfaceView上
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {

        }
    }

    //======================================= Run GT 的内部注解 =====================================

    /**
     * 注解类
     */
    public static class Annotations {


        /**
         * 为给 Activity 类 标的注解
         * 用法如下：
         *
         * @Activity(R.layout.activity_main) public class MainActivity extends AppCompatActivity {....}
         */
        @Target(ElementType.TYPE)
        @Retention(RetentionPolicy.RUNTIME)
        public @interface GT_Activity {
            int value();
        }


        /**
         * 为给 View 组件标的注解
         * 用法如下：
         *
         * @GT_View(R.id.ioc_tv) private TextView tv;
         */
        @Target(ElementType.FIELD)
        @Retention(RetentionPolicy.RUNTIME)
        public @interface GT_View {
            int value();
        }


        /**
         * 为给 单击方法 标的注解
         * 用法如下：切记 单击方法一定要是 public 的修饰符
         *
         * @Click({R.id.ioc_btn01,R.id.ioc_btn02,R.id.ioc_btn03}) public void setButtonOnClickListener(View view){
         * switch (view.getId()){
         * case R.id.ioc_btn01:
         * Log.e(TAG, "单击 1 号" );
         * break;
         * case R.id.ioc_btn02:
         * Log.e(TAG, "单击 2 号" );
         * break;
         * case R.id.ioc_btn03:
         * Log.e(TAG, "单击 3 号" );
         * break;
         * }
         * }
         */
        @Target(ElementType.METHOD)
        @Retention(RetentionPolicy.RUNTIME)
        @OnClickEvent(listenerType = android.view.View.OnClickListener.class, listenerSetter = "setOnClickListener", methodName = "onClick")
        public @interface GT_Click {
            int[] value();
        }


        /**
         * 用于协助 单击方法的注解
         */
        @Target(ElementType.ANNOTATION_TYPE)
        @Retention(RetentionPolicy.RUNTIME)
        private @interface OnClickEvent {
            Class<?> listenerType();//接口类型

            String listenerSetter();//设置的方法

            String methodName();//接口里面要实现的方法
        }


        /**
         * 用于注解 普通成员变量的注解 可携带 参数
         * 注意：如果是 对象 那么 构造函数一定不能设置为 单例（构造函数修饰符不能为 private 私有的）否则会注解注入失败！
         */
        @Target(ElementType.FIELD)
        @Retention(RetentionPolicy.RUNTIME)
        public @interface GT_Object {

            /**
             * 定义当前注解 支持的参数类型
             */
            interface TYPE {
                String BYTE = "byte";
                String SHORT = "short";
                String INT = "int";
                String LONG = "long";
                String FLOAT = "float";
                String DOUBLE = "double";
                String BOOLEAN = "boolean";
                String CHAR = "char";
                String STRING = "String";

                String BYTES = "bytes";
                String SHORTS = "shorts";
                String INTS = "ints";
                String LONGS = "longs";
                String FLOATS = "floats";
                String DOUBLES = "doubles";
                String BOOLEANS = "booleans";
                String CHARS = "chars";
                String STRINGS = "Strings";
            }

            /**
             * 单参数的传递
             **/
            byte valueByte() default 0;

            short valueShort() default 0;

            int valueInt() default 0;

            long valueLong() default 0L;

            float valueFloat() default 0.0f;

            double valueDouble() default 0.0d;

            boolean valueBoolean() default false;

            char valueChar() default 0;

            String valueString() default "";

            /**
             * 多参数的传递
             **/
            byte[] valueBytes() default {};

            short[] valueShorts() default {};

            int[] valueInts() default {};

            long[] valueLongs() default {};

            float[] valueFloats() default {};

            double[] valueDoubles() default {};

            boolean[] valueBooleans() default {};

            char[] valueChars() default {};

            String[] valueStrings() default {};

            /**
             * 修改参数的类型
             **/
            String type() default "";

            String[] types() default {};

            /**
             * 要赋值的方法
             **/
            String function() default "";

            String[] functions() default {};

        }


        /**
         * 资源注解
         */
        public @interface GT_Res {

            /**
             * 字符串 注解
             */
            @Target(ElementType.FIELD)
            @Retention(RetentionPolicy.RUNTIME)
            @interface GT_String {
                int value();
            }

            /**
             * 颜色 注解
             */
            @Target(ElementType.FIELD)
            @Retention(RetentionPolicy.RUNTIME)
            @interface GT_Color {
                int value();
            }

            /**
             * 尺寸 注解
             */
            @Target(ElementType.FIELD)
            @Retention(RetentionPolicy.RUNTIME)
            @interface GT_Dimen {
                int value();
            }

            /**
             * 图片 注解
             */
            @Target(ElementType.FIELD)
            @Retention(RetentionPolicy.RUNTIME)
            @interface GT_Drawable {
                int value();
            }

            /**
             * 动画 注解
             */
            @Target(ElementType.FIELD)
            @Retention(RetentionPolicy.RUNTIME)
            @interface GT_Animation {
                int value();
            }

            /**
             * 字符串数组 注解
             */
            @Target(ElementType.FIELD)
            @Retention(RetentionPolicy.RUNTIME)
            @interface GT_StringArray {
                int value();
            }

            /**
             * 整数数组 注解
             */
            @Target(ElementType.FIELD)
            @Retention(RetentionPolicy.RUNTIME)
            @interface GT_IntArray {
                int value();
            }

            /**
             * 将 xml 文件解析成 View 注解
             */
            @Target(ElementType.FIELD)
            @Retention(RetentionPolicy.RUNTIME)
            @interface GT_Layout {
                int value();
            }

        }

        /**
         * 集合注解
         */
        public @interface GT_Collection {

            /**
             * List 注解
             */
            @Target(ElementType.FIELD)
            @Retention(RetentionPolicy.RUNTIME)
            @interface GT_List {
                Class[] value();
            }


            /**
             * Map 注解
             */
            @Target(ElementType.FIELD)
            @Retention(RetentionPolicy.RUNTIME)
            @interface GT_Map {
                Class[] value();
            }


            /**
             * Set 注解
             */
            @Target(ElementType.FIELD)
            @Retention(RetentionPolicy.RUNTIME)
            @interface GT_Set {
                Class[] value();
            }

        }


        /**
         * 注解初始化 GT 库
         */
        @Target(ElementType.METHOD)
        @Retention(RetentionPolicy.RUNTIME)
        public @interface Build {
        }


    }

    /**
     * 注解工具类
     */
    public static class AnnotationAssist {

        //================================   下面是 初始化 注解内容   ==============================

        //主要用于注解 非 Activity 以外的
        public static void initAll(Object object, View view) {

            Class<? extends Object> mClass = object.getClass();

            // Java 注解部分
            initObject(object, mClass);                    //为加载 Object 成员变量初始化
            initList(object, mClass);                      //为加载 List 成员变量初始化
            initMap(object, mClass);                       //为加载 Map 成员变量初始化
            initSet(object, mClass);                       //为加载 Set 成员变量初始化

            // 组件、事件 注解
            initView(object, mClass, view);                 //为加载 组件 初始化
            initClick(object, mClass, view);                //为加载 组件单击 初始化

            //资源 注解
            initAnimation(object, mClass, view);            //为加载 Animation 资源初始化
            initDimen(object, mClass, view);                //为加载 Dimen 资源初始化
            initDrawable(object, mClass, view);             //为加载 Style 资源初始化
            initColor(object, mClass, view);                //为加载 Color 资源初始化
            initString(object, mClass, view);               //为加载 String 资源初始化
            initIntArray(object, mClass, view);             //为加载 IntArray 资源初始化
            initStringArray(object, mClass, view);          //为加载 StringArray 资源初始化
            initLayout(object, mClass, view);               //为加载 Layout 资源初始化

        }

        //主要用于注解 Activity
        private static void initAll(Activity activity) {

            Class<? extends Activity> mClass = activity.getClass();

            // Java 注解
            initObject(activity, mClass);               //为加载 Object 成员变量初始化
            initList(activity, mClass);                 //为加载 List 成员变量初始化
            initMap(activity, mClass);                  //为加载 Map 成员变量初始化
            initSet(activity, mClass);                  //为加载 Set 成员变量初始化

            // Activity、组件、事件 注解
            initActivity(activity, mClass);             //为加载 Activity 布局初始化
            initView(activity, mClass);                 //为加载 组件 初始化
            initClick(activity, mClass);                //为加载 组件单击 初始化

            //资源 注解
            initAnimation(activity, mClass);            //为加载 Animation 资源初始化
            initDimen(activity, mClass);                //为加载 Dimen 资源初始化
            initDrawable(activity, mClass);             //为加载 Style 资源初始化
            initColor(activity, mClass);                //为加载 Color 资源初始化
            initString(activity, mClass);               //为加载 String 资源初始化
            initIntArray(activity, mClass);             //为加载 IntArray 资源初始化
            initStringArray(activity, mClass);          //为加载 StringArray 资源初始化
            initLayout(activity, mClass);               //为加载 Layout 资源初始化

        }


        //================================   下面是 Java 的注解内容   ==============================

        /**
         * 参数版
         *
         * @param object
         */
        private static void initObject(Object object, Class<? extends Object> mClass) {
            Field[] fields = mClass.getDeclaredFields();//获致所有成员变更
            for (Field field : fields) {
                Annotations.GT_Object initView = field.getAnnotation(Annotations.GT_Object.class);

                if (initView != null) {

                    //获取 完整的类路径
                    String classPage = field.toString();
                    String[] s = classPage.split(" ");
                    classPage = s[1];

                    //实例化一个对象
                    Object object2 = null;
                    try {
                        object2 = Class.forName(classPage).newInstance();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                    //获取参数的值类型
                    String type = initView.type();
                    String[] types = initView.types();


                    //创建保存 参数类型的容器
                    List<Object> valueList = new ArrayList<>();
                    if (type.length() != 0) {
                        valueType(type, valueList, initView, 0);//将当前的单个数据赋值到 listView 中
                    } else if (types.length != 0) {
                        for (int i = 0; i < types.length; i++) {
                            valueType(types[i], valueList, initView, i);//将当前的多个数据赋值到 listView 中
                        }
                    }

                    /** 获取注解传递过来的参数 **/
                    String function = initView.function();
                    String[] functions = initView.functions();

                    /**
                     * 获取当前方法所有方法
                     */
                    if (function.length() != 0 && valueList.size() != 0) {
                        functionValue(field, object2, function, valueList, 0);//对相应的方法进行赋值
                    } else if (functions.length != 0 && valueList.size() != 0) {
                        for (int i = 0; i < functions.length; i++) {
                            functionValue(field, object2, functions[i], valueList, i);//对相应的方法进行赋值
                        }
                    }


                    //给注解下面的 成员变量注入值
                    try {
                        field.setAccessible(true);
                        field.set(object, object2);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /**
         * 注入 List 资源字符串
         **/
        private static void initList(Object object, Class<? extends Object> mClass) {

            Field[] fields = mClass.getDeclaredFields();//获致所有成员变更
            for (Field field : fields) {
                Annotations.GT_Collection.GT_List initView = field.getAnnotation(Annotations.GT_Collection.GT_List.class);
                if (initView != null) {
                    Class[] classes = initView.value();
                    List<Object> objectList = new ArrayList<>();//创建一个 ListView
                    for (Class cla : classes) {

                        String classPage = cla.toString();
                        String[] s = classPage.split(" ");
                        classPage = s[1];

                        //实例化一个对象
                        Object object2 = null;
                        try {
                            object2 = Class.forName(classPage).newInstance();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        objectList.add(object2);//添加每一个经过反射得到的 对象
                    }
                    try {
                        field.setAccessible(true);
                        field.set(object, objectList);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        /**
         * 注入 Map 资源字符串
         **/
        private static void initMap(Object object, Class<? extends Object> mClass) {

            Field[] fields = mClass.getDeclaredFields();//获致所有成员变更
            for (Field field : fields) {
                Annotations.GT_Collection.GT_Map initView = field.getAnnotation(Annotations.GT_Collection.GT_Map.class);
                if (initView != null) {
                    Class[] classes = initView.value();
                    Map<Object, Object> objectMap = new HashMap<>();//创建一个 Map
                    for (Class cla : classes) {

                        String classPage = cla.toString();
                        String[] s = classPage.split(" ");
                        classPage = s[1];

                        //实例化一个对象
                        Object object2 = null;
                        try {
                            object2 = Class.forName(classPage).newInstance();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        objectMap.put(cla, object2);//保存每个创建出来的 对象 key 为 每个对象的 class
                    }
                    try {
                        field.setAccessible(true);
                        field.set(object, objectMap);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        /**
         * 注入 Set 资源字符串
         **/
        private static void initSet(Object object, Class<? extends Object> mClass) {

            Field[] fields = mClass.getDeclaredFields();//获致所有成员变更
            for (Field field : fields) {
                Annotations.GT_Collection.GT_Set initView = field.getAnnotation(Annotations.GT_Collection.GT_Set.class);
                if (initView != null) {
                    Class[] classes = initView.value();
                    Set<Object> objectSet = new HashSet<>();//创建一个 Set
                    for (Class cla : classes) {

                        String classPage = cla.toString();
                        String[] s = classPage.split(" ");
                        classPage = s[1];

                        //实例化一个对象
                        Object object2 = null;
                        try {
                            object2 = Class.forName(classPage).newInstance();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        objectSet.add(object2);//保存每个创建出来的 对象
                    }
                    try {
                        field.setAccessible(true);
                        field.set(object, objectSet);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }


        //================================   下面是 Fragment 的注解内容   ==========================


        /**
         * 注入控件
         *
         * @param object
         * @param mClass
         * @param view
         */
        private static void initView(Object object, Class<? extends Object> mClass, View view) {
            Field[] fields = mClass.getDeclaredFields();//获致所有成员变更
            for (Field field : fields) {
                Annotations.GT_View initView = field.getAnnotation(Annotations.GT_View.class);
                if (initView != null) {
                    int viewId = initView.value();
                    try {
                        View viewById = view.findViewById(viewId);
                        field.setAccessible(true);
                        field.set(object, viewById);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /**
         * 注入点击事件
         */
        private static void initClick(Object object, Class<? extends Object> mClass, View view) {
            Method[] methods = mClass.getMethods();//获取所有声明为公有的方法
            for (Method method : methods) {//遍历所有公有方法
                Annotation[] annotations = method.getAnnotations();//获取该公有方法的所有注解
                for (Annotation annotation : annotations) {//遍历所有注解
                    Class<? extends Annotation> annotationType = annotation.annotationType();//获取具体的注解类
                    Annotations.OnClickEvent onClickEvent = annotationType.getAnnotation(Annotations.OnClickEvent.class);//取出注解的onClickEvent注解
                    if (onClickEvent != null) {//如果不为空
                        try {
                            Method valueMethod = annotationType.getDeclaredMethod("value");//获取注解InjectOnClick的value方法
                            int[] viewIds = (int[]) valueMethod.invoke(annotation, (Object[]) null);//获取控件值
                            Class<?> listenerType = onClickEvent.listenerType();//获取接口类型
                            String listenerSetter = onClickEvent.listenerSetter();//获取set方法
                            String methodName = onClickEvent.methodName();//获取接口需要实现的方法
                            MyInvocationHandler handler = new MyInvocationHandler(object);//自己实现的代码，负责调用
                            handler.setMethodMap(methodName, method);//设置方法及设置方法
                            Object object2 = Proxy.newProxyInstance(listenerType.getClassLoader(), new Class<?>[]{listenerType}, handler);//创建动态代理对象类
                            for (int viewId : viewIds) {//遍历要设置监听的控件
                                View view2 = view.findViewById(viewId);//获取该控件
                                Method m = view2.getClass().getMethod(listenerSetter, listenerType);//获取方法
                                m.invoke(view2, object2);//调用方法
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        /**
         * 注入 Animation 资源字符串
         **/
        private static void initAnimation(Object object, Class<? extends Object> mClass, View view) {
            Field[] fields = mClass.getDeclaredFields();//获致所有成员变更
            for (Field field : fields) {
                Annotations.GT_Res.GT_Animation initView = field.getAnnotation(Annotations.GT_Res.GT_Animation.class);
                if (initView != null) {
                    int viewRes = initView.value();
                    try {
                        Context context = view.getContext();
                        if (context != null) {
                            Animation animation = AnimationUtils.loadAnimation(context, viewRes);
                            field.setAccessible(true);
                            field.set(object, animation);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /**
         * 注入 Dimen 资源字符串
         **/
        private static void initDimen(Object object, Class<? extends Object> mClass, View view) {
            Field[] fields = mClass.getDeclaredFields();//获致所有成员变更
            for (Field field : fields) {
                Annotations.GT_Res.GT_Dimen initView = field.getAnnotation(Annotations.GT_Res.GT_Dimen.class);
                if (initView != null) {
                    int viewRes = initView.value();
                    try {
                        float dimension = view.getResources().getDimension(viewRes);
                        field.setAccessible(true);
                        field.set(object, dimension);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /**
         * 注入 Drawable 资源字符串
         **/
        private static void initDrawable(Object object, Class<? extends Object> mClass, View view) {
            Field[] fields = mClass.getDeclaredFields();//获致所有成员变更
            for (Field field : fields) {
                Annotations.GT_Res.GT_Drawable initView = field.getAnnotation(Annotations.GT_Res.GT_Drawable.class);
                if (initView != null) {
                    int viewRes = initView.value();
                    try {
                        Drawable drawable = view.getResources().getDrawable(viewRes);
                        field.setAccessible(true);
                        field.set(object, drawable);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /**
         * 注入 Color 资源字符串
         **/
        private static void initColor(Object object, Class<? extends Object> mClass, View view) {
            Field[] fields = mClass.getDeclaredFields();//获致所有成员变更
            for (Field field : fields) {
                Annotations.GT_Res.GT_Color initView = field.getAnnotation(Annotations.GT_Res.GT_Color.class);
                if (initView != null) {
                    int viewRes = initView.value();
                    try {
                        int color = view.getResources().getColor(viewRes);
                        field.setAccessible(true);
                        field.set(object, color);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /**
         * 注入 String 资源字符串
         **/
        private static void initString(Object object, Class<? extends Object> mClass, View view) {

            Field[] fields = mClass.getDeclaredFields();//获致所有成员变更
            for (Field field : fields) {
                Annotations.GT_Res.GT_String initView = field.getAnnotation(Annotations.GT_Res.GT_String.class);
                if (initView != null) {
                    int viewRes = initView.value();
                    try {
                        String string = view.getResources().getString(viewRes);
                        field.setAccessible(true);
                        field.set(object, string);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        /**
         * 注入 Int 资源字符串数组
         **/
        private static void initIntArray(Object object, Class<? extends Object> mClass, View view) {

            Field[] fields = mClass.getDeclaredFields();//获致所有成员变更
            for (Field field : fields) {
                Annotations.GT_Res.GT_IntArray initView = field.getAnnotation(Annotations.GT_Res.GT_IntArray.class);
                if (initView != null) {
                    int viewRes = initView.value();
                    try {
                        int[] intArray = view.getResources().getIntArray(viewRes);
                        field.setAccessible(true);
                        field.set(object, intArray);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        /**
         * 注入 String 资源字符串数组
         **/
        private static void initStringArray(Object object, Class<? extends Object> mClass, View view) {

            Field[] fields = mClass.getDeclaredFields();//获致所有成员变更
            for (Field field : fields) {
                Annotations.GT_Res.GT_StringArray initView = field.getAnnotation(Annotations.GT_Res.GT_StringArray.class);
                if (initView != null) {
                    int viewRes = initView.value();
                    try {
                        String[] stringArray = view.getResources().getStringArray(viewRes);
                        field.setAccessible(true);
                        field.set(object, stringArray);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        /**
         * 解析 Layout 资源文件成 View
         **/
        private static void initLayout(Object object, Class<? extends Object> mClass, View view) {

            Field[] fields = mClass.getDeclaredFields();//获致所有成员变更
            for (Field field : fields) {
                Annotations.GT_Res.GT_Layout initView = field.getAnnotation(Annotations.GT_Res.GT_Layout.class);
                if (initView != null) {
                    int viewRes = initView.value();
                    try {
                        Context context = view.getContext();
                        if (context != null) {
                            View viewLayout = LayoutInflater.from(context).inflate(viewRes, null);
                            field.setAccessible(true);
                            field.set(object, viewLayout);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }


        //================================   下面是 Activity 的注解内容   ==========================


        /**
         * 解析 Layout 资源文件成 View
         **/
        private static void initLayout(Activity activity, Class<? extends Activity> clazz) {

            Field[] fields = clazz.getDeclaredFields();//获致所有成员变更
            for (Field field : fields) {
                Annotations.GT_Res.GT_Layout initView = field.getAnnotation(Annotations.GT_Res.GT_Layout.class);
                if (initView != null) {
                    int viewRes = initView.value();
                    try {
                        View view = LayoutInflater.from(activity).inflate(viewRes, null);
                        field.setAccessible(true);
                        field.set(activity, view);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        /**
         * 注入 Int 资源字符串数组
         **/
        private static void initIntArray(Activity activity, Class<? extends Activity> clazz) {

            Field[] fields = clazz.getDeclaredFields();//获致所有成员变更
            for (Field field : fields) {
                Annotations.GT_Res.GT_IntArray initView = field.getAnnotation(Annotations.GT_Res.GT_IntArray.class);
                if (initView != null) {
                    int viewRes = initView.value();
                    try {
                        int[] intArray = activity.getResources().getIntArray(viewRes);
                        field.setAccessible(true);
                        field.set(activity, intArray);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        /**
         * 注入 String 资源字符串数组
         **/
        private static void initStringArray(Activity activity, Class<? extends Activity> clazz) {

            Field[] fields = clazz.getDeclaredFields();//获致所有成员变更
            for (Field field : fields) {
                Annotations.GT_Res.GT_StringArray initView = field.getAnnotation(Annotations.GT_Res.GT_StringArray.class);
                if (initView != null) {
                    int viewRes = initView.value();
                    try {
                        String[] stringArray = activity.getResources().getStringArray(viewRes);
                        field.setAccessible(true);
                        field.set(activity, stringArray);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        /**
         * 注入 Animation 资源字符串
         **/
        private static void initAnimation(Activity activity, Class<? extends Activity> clazz) {
            Field[] fields = clazz.getDeclaredFields();//获致所有成员变更
            for (Field field : fields) {
                Annotations.GT_Res.GT_Animation initView = field.getAnnotation(Annotations.GT_Res.GT_Animation.class);
                if (initView != null) {
                    int viewRes = initView.value();
                    try {
                        Animation animation = AnimationUtils.loadAnimation(activity, viewRes);
                        field.setAccessible(true);
                        field.set(activity, animation);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /**
         * 注入 Dimen 资源字符串
         **/
        private static void initDimen(Activity activity, Class<? extends Activity> clazz) {
            Field[] fields = clazz.getDeclaredFields();//获致所有成员变更
            for (Field field : fields) {
                Annotations.GT_Res.GT_Dimen initView = field.getAnnotation(Annotations.GT_Res.GT_Dimen.class);
                if (initView != null) {
                    int viewRes = initView.value();
                    try {
                        float dimension = activity.getResources().getDimension(viewRes);
                        field.setAccessible(true);
                        field.set(activity, dimension);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /**
         * 注入 Drawable 资源字符串
         **/
        private static void initDrawable(Activity activity, Class<? extends Activity> clazz) {
            Field[] fields = clazz.getDeclaredFields();//获致所有成员变更
            for (Field field : fields) {
                Annotations.GT_Res.GT_Drawable initView = field.getAnnotation(Annotations.GT_Res.GT_Drawable.class);
                if (initView != null) {
                    int viewRes = initView.value();
                    try {
                        Drawable drawable = activity.getResources().getDrawable(viewRes);
                        field.setAccessible(true);
                        field.set(activity, drawable);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /**
         * 注入 Color 资源字符串
         **/
        private static void initColor(Activity activity, Class<? extends Activity> clazz) {
            Field[] fields = clazz.getDeclaredFields();//获致所有成员变更
            for (Field field : fields) {
                Annotations.GT_Res.GT_Color initView = field.getAnnotation(Annotations.GT_Res.GT_Color.class);
                if (initView != null) {
                    int viewRes = initView.value();
                    try {
                        int color = activity.getResources().getColor(viewRes);
                        field.setAccessible(true);
                        field.set(activity, color);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /**
         * 注入 String 资源字符串
         **/
        private static void initString(Activity activity, Class<? extends Activity> clazz) {
            Field[] fields = clazz.getDeclaredFields();//获致所有成员变更
            for (Field field : fields) {
                Annotations.GT_Res.GT_String initView = field.getAnnotation(Annotations.GT_Res.GT_String.class);
                if (initView != null) {
                    int viewRes = initView.value();
                    try {
                        String string = activity.getResources().getString(viewRes);
                        field.setAccessible(true);
                        field.set(activity, string);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }


        /**
         * 单击注解 帮助方法
         *
         * @param field
         * @param object
         * @param functionName
         * @param valueList
         * @param index
         */
        private static void functionValue(Field field, Object object, String functionName, List<Object> valueList, int index) {

            if (functionName.length() != 0 && valueList.size() != 0) {

                Class<?> aClass = object.getClass();
                Method[] methods = aClass.getMethods();

                //获取当前类中所有方法
                for (int i = methods.length - 1; i >= 0; i--) {
                    String name = methods[i].getName();
                    if (name.equals(functionName)) {
                        try {
                            Method method = getAllValueTypeMethod(valueList.get(index), functionName, aClass);
                            method.setAccessible(true);
                            field.setAccessible(true);
                            method.invoke(object, valueList.get(index));
                        } catch (Exception e) {
                            if (getGT().getGtLogTf()) {
                                GT.log_e(getGT().getLineInfo(), "注解注入失败 ！");
                            }
//                            e.printStackTrace();
                        }
                    }
                }
            }

        }


        /**
         * 自获取当前传入数据的类型
         *
         * @param data
         * @param functionName
         * @param aClass
         * @return
         */
        private static Method getAllValueTypeMethod(Object data, String functionName, Class<?> aClass) {

            Method method = null;

            Class<?> aClass1 = data.getClass();
            switch (aClass1.toString()) {
                case "class java.lang.Byte":
                    try {
                        method = aClass.getMethod(functionName, byte.class);
                    } catch (NoSuchMethodException e) {
//                    e.printStackTrace();
                        if (getGT().getGtLogTf()) {
                            GT.log_e(getGT().getLineInfo(), "注解 赋值 byte 类型数据 报错");
                        }
                    }
                    break;
                case "class java.lang.Short":
                    try {
                        method = aClass.getMethod(functionName, short.class);
                    } catch (NoSuchMethodException e) {
//                    e.printStackTrace();
                        if (getGT().getGtLogTf()) {
                            GT.log_e(getGT().getLineInfo(), "注解 赋值 Short 类型数据 报错");
                        }
                    }
                    break;
                case "class java.lang.Integer":
                    try {
                        method = aClass.getMethod(functionName, int.class);
                    } catch (NoSuchMethodException e) {
//                    e.printStackTrace();
                        if (getGT().getGtLogTf()) {
                            GT.log_e(getGT().getLineInfo(), "注解 赋值 int 类型数据 报错");
                        }
                    }
                    break;
                case "class java.lang.Long":
                    try {
                        method = aClass.getMethod(functionName, long.class);
                    } catch (NoSuchMethodException e) {
//                    e.printStackTrace();
                        if (getGT().getGtLogTf()) {
                            GT.log_e(getGT().getLineInfo(), "注解 赋值 Long 类型数据 报错");
                        }
                    }
                    break;
                case "class java.lang.Float":
                    try {
                        method = aClass.getMethod(functionName, float.class);
                    } catch (NoSuchMethodException e) {
//                    e.printStackTrace();
                        if (getGT().getGtLogTf()) {
                            GT.log_e(getGT().getLineInfo(), "注解 赋值 Float 类型数据 报错");
                        }
                    }
                    break;
                case "class java.lang.Double":
                    try {
                        method = aClass.getMethod(functionName, double.class);
                    } catch (NoSuchMethodException e) {
//                    e.printStackTrace();
                        if (getGT().getGtLogTf()) {
                            GT.log_e(getGT().getLineInfo(), "注解 赋值 Double 类型数据 报错");
                        }
                    }
                    break;
                case "class java.lang.Boolean":
                    try {
                        method = aClass.getMethod(functionName, boolean.class);
                    } catch (NoSuchMethodException e) {
//                    e.printStackTrace();
                        if (getGT().getGtLogTf()) {
                            GT.log_e(getGT().getLineInfo(), "注解 赋值 Boolean 类型数据 报错");
                        }
                    }
                    break;
                case "class java.lang.Character":
                    try {
                        method = aClass.getMethod(functionName, char.class);
                    } catch (NoSuchMethodException e) {
//                    e.printStackTrace();
                        if (getGT().getGtLogTf()) {
                            GT.log_e(getGT().getLineInfo(), "注解 赋值 Character 类型数据 报错");
                        }
                    }
                    break;
                case "class java.lang.String":
                    try {
                        method = aClass.getMethod(functionName, String.class);
                    } catch (NoSuchMethodException e) {
//                    e.printStackTrace();
                        if (getGT().getGtLogTf()) {
                            GT.log_e(getGT().getLineInfo(), "注解 赋值 String 类型数据 报错");
                        }
                    }
                    break;
            }
            return method;
        }


        /**
         * 给 listView 赋值
         *
         * @param type
         * @param list
         * @param values
         */
        private static void valueType(String type, List<Object> list, Annotations.GT_Object values, int index) {

            switch (type) {

                /** 单个参数的赋值 **/
                case "byte":
                    list.add(values.valueByte());
                    break;
                case "short":
                    list.add(values.valueShort());
                    break;
                case "int":
                    list.add(values.valueInt());
                    break;
                case "long":
                    list.add(values.valueLong());
                    break;
                case "float":
                    list.add(values.valueFloat());
                    break;
                case "double":
                    list.add(values.valueDouble());
                    break;
                case "boolean":
                    list.add(values.valueBoolean());
                    break;
                case "char":
                    list.add(values.valueChar());
                    break;
                case "String":
                    list.add(values.valueString());
                    break;

                /** 多个参数的赋值 **/
                case "bytes":
                    byte[] bytes = values.valueBytes();
                    for (byte value : bytes) {
                        list.add(value);
                    }
                    break;
                case "shorts":
                    short[] shorts = values.valueShorts();
                    list.add(shorts[index]);
                    break;
                case "ints":
                    int[] ints = values.valueInts();
                    list.add(ints[index]);
                    break;
                case "longs":
                    long[] longs = values.valueLongs();
                    list.add(longs[index]);
                    break;
                case "floats":
                    float[] floats = values.valueFloats();
                    list.add(floats[index]);
                    break;
                case "doubles":
                    double[] doubles = values.valueDoubles();
                    list.add(doubles[index]);
                    break;
                case "booleans":
                    boolean[] booleans = values.valueBooleans();
                    list.add(booleans[index]);
                    break;
                case "chars":
                    char[] chars = values.valueChars();
                    list.add(chars[index]);
                    break;
                case "Strings":
                    String[] strings = values.valueStrings();
                    list.add(strings[index]);
                    break;
            }

        }


        /**
         * 注入 ContextView
         *
         * @param activity
         */
        private static void initActivity(Activity activity, Class<? extends Activity> mClass) {
            Annotations.GT_Activity contentView = mClass.getAnnotation(Annotations.GT_Activity.class);//获取该类 ContextView 的注解类
            //如果有注解
            if (contentView != null) {
                int viewId = contentView.value();//获取注解类参数
                try {
                    Method method = mClass.getMethod("setContentView", int.class);//获取该方法的信息
                    method.setAccessible(true);//获取该方法的访问权限
                    method.invoke(activity, viewId);//调用该方法的，并设置该方法参数
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }


        /**
         * 注入控件
         *
         * @param activity
         */
        private static void initView(Activity activity, Class<? extends Activity> mClass) {
            Class<? extends Activity> clazz = activity.getClass();//获取该类信息
            Field[] fields = clazz.getDeclaredFields();//获致所有成员变更
            for (Field field : fields) {
                Annotations.GT_View initView = field.getAnnotation(Annotations.GT_View.class);
                if (initView != null) {
                    int viewId = initView.value();
                    try {
                        Method method = clazz.getMethod("findViewById", int.class);
                        method.setAccessible(true);
                        field.setAccessible(true);
                        Object object = method.invoke(activity, viewId);
                        field.set(activity, object);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }


        /**
         * 注入点击事件
         *
         * @param activity
         */
        private static void initClick(Activity activity, Class<? extends Activity> mClass) {
            Method[] methods = mClass.getMethods();//获取所有声明为公有的方法
            for (Method method : methods) {//遍历所有公有方法
                Annotation[] annotations = method.getAnnotations();//获取该公有方法的所有注解
                for (Annotation annotation : annotations) {//遍历所有注解
                    Class<? extends Annotation> annotationType = annotation.annotationType();//获取具体的注解类
                    Annotations.OnClickEvent onClickEvent = annotationType.getAnnotation(Annotations.OnClickEvent.class);//取出注解的onClickEvent注解
                    if (onClickEvent != null) {//如果不为空
                        try {
                            Method valueMethod = annotationType.getDeclaredMethod("value");//获取注解InjectOnClick的value方法
                            int[] viewIds = (int[]) valueMethod.invoke(annotation, (Object[]) null);//获取控件值
                            Class<?> listenerType = onClickEvent.listenerType();//获取接口类型
                            String listenerSetter = onClickEvent.listenerSetter();//获取set方法
                            String methodName = onClickEvent.methodName();//获取接口需要实现的方法
                            MyInvocationHandler handler = new MyInvocationHandler(activity);//自己实现的代码，负责调用
                            handler.setMethodMap(methodName, method);//设置方法及设置方法
                            Object object = Proxy.newProxyInstance(listenerType.getClassLoader(), new Class<?>[]{listenerType}, handler);//创建动态代理对象类
                            for (int viewId : viewIds) {//遍历要设置监听的控件
                                View view = activity.findViewById(viewId);//获取该控件
                                Method m = view.getClass().getMethod(listenerSetter, listenerType);//获取方法
                                m.invoke(view, object);//调用方法
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        /**
         * 初始化注解帮助类
         */
        private static class MyInvocationHandler implements InvocationHandler {

            private Object object;
            private Map<String, Method> methodMap = new HashMap<>(1);

            public MyInvocationHandler(Object object) {
                this.object = object;
            }

            public void setMethodMap(String name, Method method) {
                this.methodMap.put(name, method);
            }

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (object != null) {
                    String name = method.getName();
                    method = this.methodMap.get(name);
                    if (method != null) {
                        return method.invoke(object, args);
                    }
                }
                return null;
            }

        }

        /**
         * 目的：用于判断 当前类是否被 当前的注解注解过
         * 用例：new GT.AnnotationAssist(LogActivity.class, GT.Annotations.Toast.class);
         * 第一个参数：任意对象
         * 第二个参数：被注解的类
         * 再打开 GT 内部的 Log 日志
         */
        public AnnotationAssist(Object obj, Object annotation) {

            if (GT_LOG_TF) {
                log_i("obj:" + obj);
                log_i("annotation:" + annotation);
            }

            /**
             * 获取所有注解
             */
            obj = classToObject(obj);
            Annotation[] annotations = obj.getClass().getAnnotations();
            if (GT_LOG_TF) log_i("---------------该类有所的注解---------------------");
            for (Annotation annotation1 : annotations) if (GT_LOG_TF) log_i(annotation1);
            if (GT_LOG_TF) log_i("-------------------close--------------------------");


            /**
             * 获取声明注解	[Ljava.lang.annotation.Annotation;@28c97a5
             */
            Annotation[] deAnnos = obj.getClass().getDeclaredAnnotations();
            if (GT_LOG_TF) log_i("被声明式注解标识过:" + deAnnos);


            if (annotation != null) {
                //获取被 SubAnnotation 注解过的类
                Annotation subAnnotation = obj.getClass().getAnnotation((Class<Annotation>) annotation);
                if (GT_LOG_TF) log_i("该类被 [" + subAnnotation + "] 注解过");
            }

        }

        /**
         * 解析文件 反射 Object
         *
         * @param obj
         * @return
         */
        private Object classToObject(Object obj) {
            String[] strs = obj.toString().split(" ");
            String str = strs[1];
            Class<?> clazz = getClass();
            try {
                clazz = Class.forName(str);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
            try {
                obj = clazz.newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            return obj;
        }

    }


    //========================================== 线程 ==============================================

    //Thread 更新UI线程
    public static class Thread {

        /**
         * 更新 主线程 UI
         *
         * @param runnable
         */
        public static void runAndroid(Runnable runnable) {
            //该方法属于 OkGo 中的，该方法只用于更新 UI 界面，
            // 不要把耗时操作放在这里面，因为这是在主线程上操作的
            //如果在该方法中用耗时操作会引起 ANR
            runOnUiThread(runnable);

        }

        /**
         * 更新 主线程 UI
         *
         * @param runnable
         */
        public static void runAndroid(View view, Runnable runnable) {
            view.post(runnable);
        }

        /**
         * 更新 主线程 UI
         *
         * @param runnable
         */
        public static void runAndroid(Activity activity, Runnable runnable) {
            activity.runOnUiThread(runnable);
        }

        /**
         * 开启 Java 子线程
         *
         * @param runnable
         */
        public static void runJava(Runnable runnable) {
            //注意：如果你在引用这个线程里引用了主线程的 对象 请在 run 方法中 加入 Looper.prepare(); 否则会在开始或结束Activity活动时 报异常
            new java.lang.Thread(runnable).start();
        }

        /**
         * 睡眠
         *
         * @param millis
         */
        public static void sleep(long millis) {
            try {
                java.lang.Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        /**
         * 循环 计时器
         *
         * @param delay     多少秒过后进行 开始计时器
         * @param period    每隔多少毫秒进行一次计时
         * @param timerTask 匿名类 new TimerTask 即可 然后在 run 方法中写耗时操作
         * @return
         */
        public static Timer Timer(long delay, long period, TimerTask timerTask) {
            /**
             * 参数 delay : 待多少秒过后进行 开始计时器
             * 参数 period : 每隔多少毫秒进行一次计时
             * 参数 timerTask : 匿名类 new TimerTask 即可 然后在 run 方法中写耗时操作
             */
            Timer timer = new Timer();
            timer.schedule(timerTask, delay, period);
            return timer;
        }

        /**
         * 简易 循环计时器
         *
         * @param timerTask
         * @return
         */
        public static Timer Timer(TimerTask timerTask) {
            /**
             * 参数 timerTask : 匿名类 new TimerTask 即可 然后在 run 方法中写耗时操作
             */
            Timer timer = new Timer();
            timer.schedule(timerTask, 0, 1);
            return timer;
        }

        /**
         * Timer 整体封装
         */
        public static class GT_Timer {

            private Timer timer;
            private TimerTask timerTask;

            /**
             * 初始化
             *
             * @param timerTask
             */
            public GT_Timer(TimerTask timerTask) {
                this.timerTask = timerTask;
                timer = new Timer();
            }

            /**
             * 开启循环计时
             *
             * @param delay
             * @param period
             * @return
             */
            public GT_Timer start(long delay, long period) {
                if (timer != null && timerTask != null) {
                    timer.schedule(timerTask, delay, period);
                }
                return this;
            }

            /**
             * 启动
             *
             * @return
             */
            public GT_Timer start() {
                if (timer != null && timerTask != null) {
                    timer.schedule(timerTask, 0, 1);
                }
                return this;
            }

            /**
             * 结束循环计时
             */
            public void close() {
                if (timer != null) {
                    timer.cancel();//停止计时
                    timer = null;
                    timerTask = null;
                }
            }


        }


        /**
         * AsyncTask 封装
         *
         * @param gtAsyncTask
         * @return
         */
        public static GTAsyncTask asyncTask(GTAsyncTask gtAsyncTask) {
            return gtAsyncTask;
        }

        /**
         * 自动开启的 AsyncTask 封装
         *
         * @param start
         * @param gtAsyncTask
         * @return
         */
        public static GTAsyncTask asyncTask(boolean start, GTAsyncTask gtAsyncTask) {
            if (start) gtAsyncTask.execute();//如果设置为
            return gtAsyncTask;
        }

        /**
         * AsyncTask 整体封装
         */
        public static class AsyncTask {
            /**
             * 使用实列:    GT.Thread.AsyncTask asyncTask = new GT.Thread.AsyncTask(new GT.Thread.GTAsyncTask(){....}
             */
            private GTAsyncTask gtAsyncTask;    //定义 GTAsyncTask

            /**
             * 获取 GTAsyncTask 对象
             *
             * @return
             */
            public GTAsyncTask getGtAsyncTask() {
                return gtAsyncTask;
            }

            /**
             * 初始化 GTAsyncTask
             *
             * @param gtAsyncTask
             */
            public AsyncTask(GTAsyncTask gtAsyncTask) {
                this.gtAsyncTask = gtAsyncTask;
            }

            //启动 GTAsyncTask
            public void start() {
                if (gtAsyncTask != null) {
                    try {
                        gtAsyncTask.execute();
                    } catch (IllegalStateException e) {
                        if (GT.GT_LOG_TF) {
                            GT.log_v(getGT().getLineInfo(), "无法执行任务:任务已在运行。");
                        }
                    }
                }
            }

            /**
             * 关闭 GTAsyncTask 并释放内存
             */
            public void close() {
                if (gtAsyncTask != null) {
                    gtAsyncTask.cancel(true);//强制关闭
                    gtAsyncTask = null;//置空
                }
            }

        }

        /**
         * 定义继承后要实现的类
         */
        public abstract static class GTAsyncTask extends android.os.AsyncTask<Object, Object, Object> {

            /**
             * 用法：继承该类并重写，或者利用 AsyncTask 封装类进行便捷操作
             * onPreExecute 用于初始化
             * onProgressUpdate 用于更新 UI 界面
             * doInBackground 用于进行耗时操作如网络请求、、
             * onPostExecute 用于反馈耗时完成、或者进行资源释放
             */

            @Override
            protected void onPreExecute() {
                //初始化
                super.onPreExecute();
            }

            @Override
            protected void onProgressUpdate(Object... values) {
                //更新 UI
                super.onProgressUpdate(values);
            }

            @Override
            protected Object doInBackground(Object... objects) {
                //阻塞操作 该方法并不在 主线程中调用，不能用于更新 UI 操作
                return null;
            }

            @Override
            protected void onPostExecute(Object object) {
                //在主线程中调用该方法，可以对 UI 进行修改
                super.onPostExecute(object);
            }
        }


    }


//============================================ 随机类 ===============================================

    /**
     * 随机类
     */
    public static class GT_Random {
        private Random random;

        /**
         * 实例化 随机类 类
         */
        public GT_Random() {
            random = new Random();
        }

        /**
         * 获取一个未知整数
         *
         * @return int
         */
        public int getInt() {
            int min = -2147483648;
            int max = 2147483647;
            return random.nextInt(max) % (max - min + 1) + min;
        }

        /**
         * 获取随机范围的数
         *
         * @param min
         * @param max
         * @return
         */
        public int getInt(int min, int max) {
            return random.nextInt(max) % (max - min + 1) + min;
        }

    }

}



