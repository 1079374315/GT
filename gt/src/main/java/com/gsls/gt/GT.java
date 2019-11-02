
import android.Manifest;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
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
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
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
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
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
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.gsls.gt.R;
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
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
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
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
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
 * //GT全部功能 需要添加的包
 * implementation 'com.google.code.gson:gson:2.8.5'  //JSON 数据解析
 * implementation 'com.lzy.net:okgo:3.0.4' //OkGo 网络框架
 * implementation 'com.squareup.okhttp3:okhttp:3.12.0'//OkHttp 网络框架
 * implementation 'com.github.bumptech.glide:glide:4.9.0'//加载图片的 glide
 * implementation 'org.jsoup:jsoup:1.10.3'//Jsoup格式化html数据
 * implementation 'com.blankj:utilcodex:1.25.9'//集成 AndroidUtilCode 工具包
 * implementation 'org.jetbrains.kotlin:kotlin-reflect:1.3.50'//Kotlin 反射依赖
 * <p>
 * <p>
 * <p>
 * <p>
 * 更新时间:2019.11.2
 * * <p>
 * * <p>
 * * 更新内容：（1.1.4 版本）
 * * 1.去掉多余的 日志打印方法，目前仅保留 log(普通) 和 err(错误) 日志打印方法
 * * 2.增加 权限管理类 AppAuthorityManagement
 * * 3.增加 App存储池类 AppDataPool (App内部存储池、App外部存储池)
 * * 数据池 使用场景：
 *  (1)内部池使用场景： Activity 之间，Fragment 之间、 Activity 与 Fragment 之间数据的传递
 *  (2)外部池使用场景：APP 之间数据的 传递
 * <p>
 * <p>
 * <p>
 * 小提示：(用于 AndroidStudio )
 * 收起所有的 方法: Ctrl + Shift +  - (减号)
 * 展开所有的 方法: Ctrl + Shift +  + (加号)
 * 代码格式化快捷键是 Ctrl + Alt + L
 */

@SuppressWarnings("ALL")
public class GT {

    //================================== 所有属于 GT 类的属性 =======================================

    private static GT gtAndroid = null;                 //定义 GT 对象
    private static boolean LOG_TF = true;        //控制外部所有的 Log 显示
    private static boolean GT_LOG_TF = false;    //控制内部所有的 Log 显示
    private static boolean TOAST_TF = true;      //控制外部所有的 toast 显示
    private static boolean GT_TOAST_TF = false;  //控制内部所有的 toast 显示
    private static boolean isGTUtil = true;             //默认加载注解
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
        if (gtAndroid == null) {
            synchronized (GT.class) {
                if (gtAndroid == null) {
                    gtAndroid = new GT();
                }
            }
        }
        return gtAndroid;
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
    public void build(Context context) {
        this.CONTEXT = context;
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
     * 为外部提供访问 GT Context 接口
     *
     * @param object
     * @param view
     */
    public void build(Context context, Object object, View view) {
        this.CONTEXT = context;
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
        return isGTUtil;
    }

    /**
     * 设置是否初始化 GT 必要初始化的工具包
     *
     * @param isGTUtil
     */
    public static void setIsGTUtil(boolean isGTUtil) {
        GT.isGTUtil = isGTUtil;
    }

    //============================================= 加载 GT 必要的工具 =============================

    //初始化 GT 必要的工具 主要用于  Activity 的页面
    private void initGTUtilActivity() {

        //GT 包内部默认加载的工具包
        AnnotationAssist.initAll((Activity) CONTEXT); //初始化 IOC 注解

        //是否加载注解
        if (isGTUtil) {//默认是加载的
            Utils.init(CONTEXT);//初始化强大的 Utiles 工具
        }


    }

    //初始化 GT 必要的工具  主要用于 非 Activity 的页面 如：Fragment、DialogFragment 等页面
    private void initGTUtilFragment(Object object, View view) {

        //GT 包内部默认加载的工具包
        AnnotationAssist.initAll(object, view); //初始化 IOC 注解

        //是否加载注解
        if (isGTUtil) {//默认是加载的
            Utils.init(CONTEXT);//初始化强大的 Utiles 工具
        }

    }

    //============================================= 提示类 =========================================

    /**
     * 提示消息 Log
     *
     * @param msg object 类型的消息
     */
    public static void log(Object msg) {
        if (LOG_TF) {
            Log.i("GT_i", "------- " + msg);
        }
    }

    /**
     * 提示消息 Log
     *
     * @param msg object 类型的消息
     */
    public static void err(Object msg) {
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
    public static void log(Object title, Object msg) {
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
    public static void err(Object title, Object msg) {
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
    public static String getLineInfo() {
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
                    err("GT_bug", "消息框错误日志：你没有为 Context 进行赋值 ，却引用了 Toast 导致该功能无法实现。解决措施 在调用 toast 代码之前添加：GT.getGT().setCONTEXT(activity);");
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
                    err("GT_bug", "消息框错误日志：你没有为 Context 进行赋值 ，却引用了 Toast 导致该功能无法实现。解决措施 在调用 toast 代码之前添加：GT.getGT().setCONTEXT(activity);");
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

    private static Toast toast;

    /**
     * @param content
     * @标准Toast
     */
    public static void toast(Object content) {
        if (getGT().getCONTEXT() != null) {
            if (toast == null) {
                toast = Toast.makeText(getGT().getCONTEXT(), content.toString(), Toast.LENGTH_SHORT);
            } else {
                toast.setText(content.toString());
            }
            toast.show();
        } else {
            log(getLineInfo(), "当前没有赋值 Context 无法显示 Toast ");
        }

    }

    public static void toast(Context context, Object content) {
        if (toast == null) {
            toast = Toast.makeText(context, content.toString(), Toast.LENGTH_SHORT);
        } else {
            toast.setText(content.toString());
        }
        toast.show();
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
                        err("GT_bug", "消息框错误日志：你没有为 Context 进行赋值 ，却引用了 Toast 导致该功能无法实现。解决措施 在调用 toast 代码之前添加：GT.getGT().setCONTEXT(activity);");
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
                        err("GT_bug", "消息框错误日志：你没有为 Context 进行赋值 ，却引用了 Toast 导致该功能无法实现。解决措施 在调用 toast 代码之前添加：GT.getGT().setCONTEXT(activity);");
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
                        err("GT_bug", "消息框错误日志：你没有为 Context 进行赋值 ，却引用了 Toast 导致该功能无法实现。解决措施 在调用 toast 代码之前添加：GT.getGT().setCONTEXT(activity);");
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
                        err("GT_bug", "消息框错误日志：你没有为 Context 进行赋值 ，却引用了 Toast 导致该功能无法实现。解决措施 在调用 toast 代码之前添加：GT.getGT().setCONTEXT(activity);");
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
        private static String CHANEL_DESCRIPTION = "GT 描述";
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
                assert notificationManager != null;
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
            GT.err(getLineInfo(), "跳转 Activity 失败，CONTEXT 为 null 无法进行相应的 Activity 跳转");
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
            GT.err(getLineInfo(), "跳转 Activity 失败，CONTEXT 或 Intent为 null 无法进行相应的 Activity 跳转");
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
        private Gson gson = new Gson();             //是 Gson 对象

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
                if (GT_LOG_TF) log(context, "进行对象保存");
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
                if (GT_LOG_TF) log("删除失败  当前 sp 中无此 key");
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
                    log(context, "进入到 updata 查询的数据不为null");
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
                    log(context, "Int 数据装换异常");
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
                        log(context, "String 数据装换异常");
                    try {
                        obj = sp.getLong(key, 0);
                    } catch (ClassCastException e3) {
                        if (GT_LOG_TF)
                            log(context, "Long 数据装换异常");
                        try {
                            obj = sp.getFloat(key, 0f);
                        } catch (ClassCastException e4) {
                            if (GT_LOG_TF)
                                log(context, "Float 数据装换异常");
                            try {
                                obj = sp.getBoolean(key, false);
                            } catch (ClassCastException e5) {
                                if (GT_LOG_TF)
                                    log(context, "Boolean 数据装换异常");
                                try {
                                    obj = sp.getStringSet(key, null);
                                } catch (ClassCastException e6) {
                                    if (GT_LOG_TF)
                                        log(context, "StringSet 数据装换异常");
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
            err("创建数据库的 json 数据", db);

            //            db = password;

            err("加密后的数据库 json 数据", db);
            sp_e.putString(databaseName, db);
            sp_e.apply();
        }

        //修改数据库
        public void alterDatabase(String formerName, String newName, Object password) {
            formerName = sp.getString("formerName", null);
            if (formerName != null) {

            } else {
                if (GT_LOG_TF) err("修改数据库 失败！ 原由：暂未找到需要修改的数据库名称");
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

        /**
         * 获取当前网络属于 无网络(返回0)、WF(返回1)、2G(返回2)、3G(返回3)、4G(返回4) 网络
         *
         * @param context
         * @return
         */
        public static int getNetworkState(Context context) {
            return IntenetUtil.getNetworkState(context);
        }

        /**
         * 获取当前网络属于 无网络、WF、2G、3G、4G网络
         * //没有网络连接
         * public static final int NETWORN_NONE = 0;
         * //wifi连接
         * public static final int NETWORN_WIFI = 1;
         * //手机网络数据连接类型
         * public static final int NETWORN_2G = 2;
         * public static final int NETWORN_3G = 3;
         * public static final int NETWORN_4G = 4;
         * public static final int NETWORN_MOBILE = 5;
         */
        private static class IntenetUtil {

            //没有网络连接
            public static final int NETWORN_NONE = 0;
            //wifi连接
            public static final int NETWORN_WIFI = 1;
            //手机网络数据连接类型
            public static final int NETWORN_2G = 2;
            public static final int NETWORN_3G = 3;
            public static final int NETWORN_4G = 4;
            public static final int NETWORN_MOBILE = 5;

            /**
             * 获取当前网络连接类型
             *
             * @param context
             * @return
             */
            public static int getNetworkState(Context context) {
                //获取系统的网络服务
                ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                //如果当前没有网络
                if (null == connManager)
                    return NETWORN_NONE;
                //获取当前网络类型，如果为空，返回无网络
                @SuppressLint("MissingPermission") NetworkInfo activeNetInfo = connManager.getActiveNetworkInfo();
                if (activeNetInfo == null || !activeNetInfo.isAvailable()) {
                    return NETWORN_NONE;
                }
                // 判断是不是连接的是不是wifi
                @SuppressLint("MissingPermission") NetworkInfo wifiInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                if (null != wifiInfo) {
                    NetworkInfo.State state = wifiInfo.getState();
                    if (null != state)
                        if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
                            return NETWORN_WIFI;
                        }
                }
                // 如果不是wifi，则判断当前连接的是运营商的哪种网络2g、3g、4g等
                @SuppressLint("MissingPermission") NetworkInfo networkInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
                if (null != networkInfo) {
                    NetworkInfo.State state = networkInfo.getState();
                    String strSubTypeName = networkInfo.getSubtypeName();
                    if (null != state)
                        if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
                            switch (activeNetInfo.getSubtype()) {
                                //如果是2g类型
                                case TelephonyManager.NETWORK_TYPE_GPRS: // 联通2g
                                case TelephonyManager.NETWORK_TYPE_CDMA: // 电信2g
                                case TelephonyManager.NETWORK_TYPE_EDGE: // 移动2g
                                case TelephonyManager.NETWORK_TYPE_1xRTT:
                                case TelephonyManager.NETWORK_TYPE_IDEN:
                                    return NETWORN_2G;
                                //如果是3g类型
                                case TelephonyManager.NETWORK_TYPE_EVDO_A: // 电信3g
                                case TelephonyManager.NETWORK_TYPE_UMTS:
                                case TelephonyManager.NETWORK_TYPE_EVDO_0:
                                case TelephonyManager.NETWORK_TYPE_HSDPA:
                                case TelephonyManager.NETWORK_TYPE_HSUPA:
                                case TelephonyManager.NETWORK_TYPE_HSPA:
                                case TelephonyManager.NETWORK_TYPE_EVDO_B:
                                case TelephonyManager.NETWORK_TYPE_EHRPD:
                                case TelephonyManager.NETWORK_TYPE_HSPAP:
                                    return NETWORN_3G;
                                //如果是4g类型
                                case TelephonyManager.NETWORK_TYPE_LTE:
                                    return NETWORN_4G;
                                default:
                                    //中国移动 联通 电信 三种3G制式
                                    if (strSubTypeName.equalsIgnoreCase("TD-SCDMA") || strSubTypeName.equalsIgnoreCase("WCDMA") || strSubTypeName.equalsIgnoreCase("CDMA2000")) {
                                        return NETWORN_3G;
                                    } else {
                                        return NETWORN_MOBILE;
                                    }
                            }
                        }
                }
                return NETWORN_NONE;
            }
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
                    log("当前 JSON 数据中有些节点并不存在,请谨慎使用!  【" + getLineInfo() + "】");
                //                e.printStackTrace();
            }
        }

        public JSON() {
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
            } catch (Exception exception) {
                err(getLineInfo(), "你的 JSON 解析类型不匹配，请检查  " + aClass + "  是否与请求的Json数据一致！");
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
                err(getLineInfo(), "没有初始化 JSON 数据，无法进行 无 bean 数据解析");
            }

            //            GT.err("在转 data 数据之前:" + data);
            o = rplStr(o.toString(), "\\", "");//忽略掉转义符
            //            GT.err("转 data 数据之后:" + data);

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
                err(getLineInfo(), "没有初始化 JSON 数据，无法进行 无 bean 数据解析");
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
                err(getLineInfo(), "JSON 数据解析异常，无法通过 没有初始化的 JSON 数据进行解析节点");
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
        public void loadData(Callback callback) {
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
     * HttpUtil 原始网络请求类
     */
    public static class HttpUtil {

        static final String ENCODE = "utf-8";
        static final String GET = "GET";
        static final String POST = "POST";


        /**
         * get请求封装
         */
        public static void getRequest(final String url, final Map<String, String> params, final String encode, final OnLoadData listener) {
            Thread.runJava(new Runnable() { //为请求网络数据开启子线程
                @Override
                public void run() {
                    StringBuffer sb = new StringBuffer(url);
                    sb.append("?");
                    if (params != null && !params.isEmpty()) {
                        for (Map.Entry<String, String> entry : params.entrySet()) {    //增强for遍历循环添加拼接请求内容
                            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
                        }
                        sb.deleteCharAt(sb.length() - 1);
                        if (listener != null) {
                            try {
                                URL path = new URL(sb.toString());
                                HttpURLConnection con = (HttpURLConnection) path.openConnection();
                                con.setRequestMethod(GET);    //设置请求方式
                                con.setConnectTimeout(3000);    //链接超时3秒
                                con.setDoOutput(true);
                                con.setDoInput(true);
                                OutputStream os = con.getOutputStream();
                                os.write(sb.toString().getBytes(encode));
                                os.close();
                                if (con.getResponseCode() == 200) {    //应答码200表示请求成功
                                    onSuccess(encode, listener, con);
                                }
                            } catch (Exception error) {
                                error.printStackTrace();
                                onError(listener, error);
                            }
                        }
                    }
                }
            });
        }

        /**
         * get请求封装
         */
        public static void getRequest(final String url, final OnLoadData listener) {
            Thread.runJava(new Runnable() { //为请求网络数据开启子线程
                @Override
                public void run() {
                    if (listener != null) {
                        try {
                            URL path = new URL(url);
                            HttpURLConnection con = (HttpURLConnection) path.openConnection();
                            con.setRequestMethod(GET);    //设置请求方式
                            con.setConnectTimeout(3000);    //链接超时3秒
                            con.setDoOutput(true);
                            con.setDoInput(true);
                            OutputStream os = con.getOutputStream();
                            os.write(url.getBytes(ENCODE));
                            os.close();
                            if (con.getResponseCode() == 200) {    //应答码200表示请求成功
                                onSuccess(ENCODE, listener, con);
                            }
                        } catch (Exception error) {
                            error.printStackTrace();
                            onError(listener, error);
                        }
                    }
                }
            });
        }

        /**
         * POST请求
         */
        public static void postRequest(final String url, final Map<String, String> params, final String encode, final OnLoadData listener) {
            Thread.runJava(new Runnable() {// 为网络请求开启子线程
                @Override
                public void run() {
                    StringBuffer sb = new StringBuffer();
                    if (params != null && !params.isEmpty()) {
                        for (Map.Entry<String, String> entry : params.entrySet()) {
                            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
                        }
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    if (listener != null) {
                        try {
                            URL path = new URL(url);
                            HttpURLConnection con = (HttpURLConnection) path.openConnection();
                            con.setRequestMethod(POST);   //设置请求方法POST
                            con.setConnectTimeout(3000);
                            con.setDoOutput(true);
                            con.setDoInput(true);
                            byte[] bytes = sb.toString().getBytes();
                            OutputStream outputStream = con.getOutputStream();
                            outputStream.write(bytes);
                            outputStream.close();
                            if (con.getResponseCode() == 200) {
                                onSuccess(encode, listener, con);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            onError(listener, e);
                        }
                    }
                }
            });
        }

        /**
         * POST请求
         */
        public static void postRequest(final String url, final OnLoadData listener) {
            Thread.runJava(new Runnable() {// 为网络请求开启子线程
                @Override
                public void run() {
                    if (listener != null) {
                        try {
                            URL path = new URL(url);
                            HttpURLConnection con = (HttpURLConnection) path.openConnection();
                            con.setRequestMethod(POST);   //设置请求方法POST
                            con.setConnectTimeout(3000);
                            con.setDoOutput(true);
                            con.setDoInput(true);
                            byte[] bytes = url.getBytes();
                            OutputStream outputStream = con.getOutputStream();
                            outputStream.write(bytes);
                            outputStream.close();
                            if (con.getResponseCode() == 200) {
                                onSuccess(ENCODE, listener, con);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            onError(listener, e);
                        }
                    }
                }
            });

        }

        private static void onError(final OnLoadData listener, final Exception onError) {
            Thread.runAndroid(new Runnable() {//为 请求失败 开启 UI 线程
                @Override
                public void run() {
                    listener.onError(onError.toString());
                }
            });
        }

        private static void onSuccess(String encode, final OnLoadData listener, HttpURLConnection con) throws IOException {
            InputStream inputStream = con.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();//创建内存输出流
            int len;
            byte[] bytes = new byte[1024];
            if (inputStream != null) {
                while ((len = inputStream.read(bytes)) != -1) {
                    baos.write(bytes, 0, len);
                }
                final String str = new String(baos.toByteArray(), encode);
                Thread.runAndroid(new Runnable() {//为 请求成功 开启 UI 线程
                    @Override
                    public void run() {
                        listener.onSuccess(str);
                    }
                });
            }
        }

        //请求接口
        public interface OnLoadData {
            void onSuccess(String response);

            void onError(String error);
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

        /**
         * 使用案例
         * long currentTimeMillis = System.currentTimeMillis();
         * <p>
         * 输出：输入的时间：1567233280386
         * System.out.println("输入的时间：" + currentTimeMillis);
         * <p>
         * currentTimeMillis = 1538364324000L;
         * <p>
         * Lunar lunar = new Lunar(currentTimeMillis);//初始化高级功能
         * 节气: 如果指定的日期有节气则返回当天节气，如果没有则返回 "" 空字符串 不是 null
         * System.out.println("节气:" + lunar.getTermString());
         * <p>
         * 生肖:狗
         * System.out.println("生肖:" + lunar.getAnimalString());
         * <p>
         * 星期：2
         * System.out.println("星期：" + lunar.getDayOfWeek());//星期几(星期日为:1, 星期六为:7)
         * <p>
         * 干支历:戊戌年辛酉月丙寅日
         * System.out.println("干支历:" + lunar.getCyclicalDateString());
         * <p>
         * 农历:戊戌年八月廿二日
         * System.out.println("农历:" + lunar.getLunarDateString());
         * <p>
         * 当前是否为 农历节日:true
         * boolean lFestival = lunar.isLFestival();
         * System.out.println("当前是否为 农历节日:" + lFestival);
         * <p>
         * 农历节日:燃灯佛诞
         * if(lFestival){
         * System.out.println("农历节日:" + lunar.getLFestivalName());
         * }
         * <p>
         * 当前是否为公历节日:true
         * boolean sFestival = lunar.isSFestival();
         * System.out.println("当前是否为公历节日:" + lFestival);
         * if(sFestival){
         * 公历节日:国庆节
         * System.out.println("公历节日:" + lunar.getSFestivalName());
         * }
         * <p>
         * 当前是否为节日:true
         * boolean festival = lunar.isFestival();
         * System.out.println("当前是否为节日:" + festival);
         * <p>
         * 当前是否放假:true
         * boolean holiday = lunar.isHoliday();
         * System.out.println("当前是否放假:" + holiday);
         * <p>
         * <p>
         * Date[] jieqi = Lunar.jieqilist(2019);
         * for (int i = 0; i < Lunar.solarTerm.length; i++) {
         * System.out.print(Lunar.solarTerm[i]);
         *
         * @SuppressWarnings("deprecation") int month = jieqi[i].getMonth();
         * month += 1;
         * System.out.print(month + "月");
         * System.out.println(jieqi[i].getDate());
         * }
         * //对应结果
         * 小寒1月6
         * 大寒1月20
         * 立春2月4
         * 雨水2月19
         * 惊蛰3月6
         * 春分3月21
         * 清明4月5
         * 谷雨4月21
         * 立夏5月6
         * 小满5月22
         * 芒种6月6
         * 夏至6月22
         * 小暑7月8
         * 大暑7月23
         * 立秋8月8
         * 处暑8月24
         * 白露9月8
         * 秋分9月24
         * 寒露10月9
         * 霜降10月24
         * 立冬11月8
         * 小雪11月23
         * 大雪12月8
         * 冬至12月22
         */

        private Lunar lunar = null;

        /**
         * @return the lunar
         */
        public Lunar getLunar() {
            return lunar;
        }

        /**
         * @param lunar the lunar to set
         */
        public void setLunar(Lunar lunar) {
            this.lunar = lunar;
        }

        /**
         * 初始化时间 基础功能
         */
        public GT_Date() {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            time = df.format(new Date());   //获取当时间
            times = time.split(" ");        //分割时间 年月日  时分秒 数组
            ymd = times[0].split("-");    //分割年月日 数组
            hms = times[1].split(":");    //分割时分秒 数组
        }

        /**
         * 初始化时间 高级功能
         */
        public GT_Date(long timestamp) {

            //初始化基本的时间
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            time = df.format(new Date());   //获取当时间
            times = time.split(" ");        //分割时间 年月日  时分秒 数组
            ymd = times[0].split("-");    //分割年月日 数组
            hms = times[1].split(":");    //分割时分秒 数组

            //初始化高级功能
            lunar = new Lunar(timestamp);

        }


        /**
         * ***************日历工具的基础功能*******************
         */

        private String time;        //定义返回的 时间整体字符串
        private String[] times;     //定义分割后产生的 年月日 / 时分秒 数组
        private String[] ymd;       //定义分割后产生的 年月日 数组
        private String[] hms;       //定义分割后产生的 时分秒 数组

        /**
         * 获取当前星期
         *
         * @return
         */
        public String getWeekOfDateString() {
            String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
            if (w < 0)
                w = 0;
            return weekDays[w];
        }


        /**
         * 获取当前星期
         *
         * @return
         */
        public int getWeekOfDateInt() {
            int[] weekDays = {0, 1, 2, 3, 4, 5, 6};
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


        /**
         * ***********************日历的高级功能***********************
         */

        public static class Lunar {

            /**
             * 获得某天前个节气日期差
             *
             * @return 日期数
             */
            public static long getbeforesolarTerm(int year, Date date) {
                List<Date> jieqi = Alljieqi(year);
                int[] jieqibeforeafter = getnearsolarTerm(year, date);
                return MyDate.DateDays(date, jieqi.get(jieqibeforeafter[0]));
            }

            /**
             * 获得某天后个节气日期差
             *
             * @return 日期数
             */
            public static long getaftersolarTerm(int year, Date date) {
                List<Date> jieqi = Alljieqi(year);
                int[] jieqibeforeafter = getnearsolarTerm(year, date);
                return MyDate.DateDays(date, jieqi.get(jieqibeforeafter[1]));

            }

            public static List<Date> Alljieqi(int year) {

                List<Date> jieqi = new ArrayList<Date>();
                Date[] temp;
                temp = jieqilist(year - 1);
                jieqi.addAll(Arrays.asList(temp));
                temp = jieqilist(year);
                jieqi.addAll(Arrays.asList(temp));
                temp = jieqilist(year + 1);
                jieqi.addAll(Arrays.asList(temp));
                return jieqi;
            }


            /**
             * 获得某天前后两个节气序号
             *
             * @return
             */
            public static int[] getnearsolarTerm(int year, Date date) {
                List<Date> jieqi = Alljieqi(year);

                int[] returnValue = new int[2];
                for (int i = 0; i < jieqi.size(); i++) {
                    if (date.getTime() > jieqi.get(i).getTime()) {
                        continue;
                    }
                    if (i % 2 == 0) {//只管气
                        returnValue[0] = i - 2;
                        returnValue[1] = i;
                    } else {
                        returnValue[0] = i - 1;
                        returnValue[1] = i + 1;

                    }
                    break;
                }

                return returnValue;
            }


            /**
             * 获得某年中所有节气Date
             *
             * @return
             */
            public static Date[] jieqilist(int year) {
                Date[] returnvalue = new Date[solarTerm.length];

                for (int i = 0; i < solarTerm.length; i++) {

                    Date t = getSolarTermCalendar(year, i);
                    returnvalue[i] = t;

                }
                return returnvalue;
            }


            private final static int[] lunarInfo = {
                    0x4bd8, 0x4ae0, 0xa570, 0x54d5, 0xd260, 0xd950, 0x5554, 0x56af,
                    0x9ad0, 0x55d2, 0x4ae0, 0xa5b6, 0xa4d0, 0xd250, 0xd295, 0xb54f,
                    0xd6a0, 0xada2, 0x95b0, 0x4977, 0x497f, 0xa4b0, 0xb4b5, 0x6a50,
                    0x6d40, 0xab54, 0x2b6f, 0x9570, 0x52f2, 0x4970, 0x6566, 0xd4a0,
                    0xea50, 0x6a95, 0x5adf, 0x2b60, 0x86e3, 0x92ef, 0xc8d7, 0xc95f,
                    0xd4a0, 0xd8a6, 0xb55f, 0x56a0, 0xa5b4, 0x25df, 0x92d0, 0xd2b2,
                    0xa950, 0xb557, 0x6ca0, 0xb550, 0x5355, 0x4daf, 0xa5b0, 0x4573,
                    0x52bf, 0xa9a8, 0xe950, 0x6aa0, 0xaea6, 0xab50, 0x4b60, 0xaae4,
                    0xa570, 0x5260, 0xf263, 0xd950, 0x5b57, 0x56a0, 0x96d0, 0x4dd5,
                    0x4ad0, 0xa4d0, 0xd4d4, 0xd250, 0xd558, 0xb540, 0xb6a0, 0x95a6,
                    0x95bf, 0x49b0, 0xa974, 0xa4b0, 0xb27a, 0x6a50, 0x6d40, 0xaf46,
                    0xab60, 0x9570, 0x4af5, 0x4970, 0x64b0, 0x74a3, 0xea50, 0x6b58,
                    0x5ac0, 0xab60, 0x96d5, 0x92e0, 0xc960, 0xd954, 0xd4a0, 0xda50,
                    0x7552, 0x56a0, 0xabb7, 0x25d0, 0x92d0, 0xcab5, 0xa950, 0xb4a0,
                    0xbaa4, 0xad50, 0x55d9, 0x4ba0, 0xa5b0, 0x5176, 0x52bf, 0xa930,
                    0x7954, 0x6aa0, 0xad50, 0x5b52, 0x4b60, 0xa6e6, 0xa4e0, 0xd260,
                    0xea65, 0xd530, 0x5aa0, 0x76a3, 0x96d0, 0x4afb, 0x4ad0, 0xa4d0,
                    0xd0b6, 0xd25f, 0xd520, 0xdd45, 0xb5a0, 0x56d0, 0x55b2, 0x49b0,
                    0xa577, 0xa4b0, 0xaa50, 0xb255, 0x6d2f, 0xada0, 0x4b63, 0x937f,
                    0x49f8, 0x4970, 0x64b0, 0x68a6, 0xea5f, 0x6b20, 0xa6c4, 0xaaef,
                    0x92e0, 0xd2e3, 0xc960, 0xd557, 0xd4a0, 0xda50, 0x5d55, 0x56a0,
                    0xa6d0, 0x55d4, 0x52d0, 0xa9b8, 0xa950, 0xb4a0, 0xb6a6, 0xad50,
                    0x55a0, 0xaba4, 0xa5b0, 0x52b0, 0xb273, 0x6930, 0x7337, 0x6aa0,
                    0xad50, 0x4b55, 0x4b6f, 0xa570, 0x54e4, 0xd260, 0xe968, 0xd520,
                    0xdaa0, 0x6aa6, 0x56df, 0x4ae0, 0xa9d4, 0xa4d0, 0xd150, 0xf252, 0xd520
            };


            private final static int[] solarTermInfo = {
                    0, 21208, 42467, 63836, 85337, 107014, 128867, 150921,
                    173149, 195551, 218072, 240693, 263343, 285989, 308563, 331033,
                    353350, 375494, 397447, 419210, 440795, 462224, 483532, 504758
            };
            public final static String[] Tianan = {
                    "甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"
            };
            public final static String[] Deqi = {
                    "子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"
            };
            public final static String[] Animals = {
                    "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪"
            };
            public final static String[] solarTerm = {
                    "小寒", "大寒", "立春", "雨水", "惊蛰", "春分",
                    "清明", "谷雨", "立夏", "小满", "芒种", "夏至",
                    "小暑", "大暑", "立秋", "处暑", "白露", "秋分",
                    "寒露", "霜降", "立冬", "小雪", "大雪", "冬至"
            };
            public final static String[] lunarString1 = {
                    "零", "一", "二", "三", "四", "五", "六", "七", "八", "九"
            };
            public final static String[] lunarString2 = {
                    "初", "十", "廿", "卅", "正", "腊", "冬", "闰"
            };
            /**
             * 国历节日 *表示放假日
             */
            private final static String[] sFtv = {
                    "0101*元旦", "0214 情人节", "0308 妇女节", "0312 植树节",
                    "0315 消费者权益日", "0401 愚人节", "0501*劳动节", "0504 青年节",
                    "0509 郝维节", "0512 护士节", "0601 儿童节", "0701 建党节 香港回归纪念",
                    "0801 建军节", "0808 父亲节", "0816 燕衔泥节", "0909 毛泽东逝世纪念",
                    "0910 教师节", "0928 孔子诞辰", "1001*国庆节", "1006 老人节",
                    "1024 联合国日", "1111 光棍节", "1112 孙中山诞辰纪念", "1220 澳门回归纪念",
                    "1225 圣诞节", "1226 毛泽东诞辰纪念"
            };
            /**
             * 农历节日 *表示放假日
             */
            private final static String[] lFtv = {
                    "0101*春节、弥勒佛诞", "0106 定光佛诞", "0115 元宵节",
                    "0208 释迦牟尼佛出家", "0215 释迦牟尼佛涅槃", "0209 海空上师诞",
                    "0219 观世音菩萨诞", "0221 普贤菩萨诞", "0316 准提菩萨诞",
                    "0404 文殊菩萨诞", "0408 释迦牟尼佛诞", "0415 佛吉祥日——释迦牟尼佛诞生、成道、涅槃三期同一庆(即南传佛教国家的卫塞节)",
                    "0505 端午节", "0513 伽蓝菩萨诞", "0603 护法韦驮尊天菩萨诞",
                    "0619 观世音菩萨成道——此日放生、念佛，功德殊胜",
                    "0707 七夕情人节", "0713 大势至菩萨诞", "0715 中元节",
                    "0724 龙树菩萨诞", "0730 地藏菩萨诞", "0815 中秋节",
                    "0822 燃灯佛诞", "0909 重阳节", "0919 观世音菩萨出家纪念日",
                    "0930 药师琉璃光如来诞", "1005 达摩祖师诞", "1107 阿弥陀佛诞",
                    "1208 释迦如来成道日，腊八节", "1224 小年",
                    "1229 华严菩萨诞", "0100*除夕"
            };
            /**
             * 某月的第几个星期几
             */
            private static String[] wFtv = {
                    "0520 母亲节", "0716 合作节", "0730 被奴役国家周"
            };

            private static int toInt(String str) {
                try {
                    return Integer.parseInt(str);
                } catch (Exception e) {
                    return -1;
                }
            }

            private final static Pattern sFreg = Pattern.compile("^(\\d{2})(\\d{2})([\\s\\*])(.+)$");
            private final static Pattern wFreg = Pattern.compile("^(\\d{2})(\\d)(\\d)([\\s\\*])(.+)$");

            private synchronized void findFestival() {
                System.out.println("进入节日获取");
                int sM = this.getSolarMonth();
                int sD = this.getSolarDay();
                int lM = this.getLunarMonth();
                int lD = this.getLunarDay();
                int sy = this.getSolarYear();
                Matcher m;
                for (int i = 0; i < Lunar.sFtv.length; i++) {
                    m = Lunar.sFreg.matcher(Lunar.sFtv[i]);

                    if (m.find()) {
                        if (sM == Lunar.toInt(m.group(1)) && sD == Lunar.toInt(m.group(2))) {
                            this.isSFestival = true;
                            this.sFestivalName = m.group(4);
                            if ("*".equals(m.group(3))) {
                                this.isHoliday = true;
                            }
                            break;
                        }
                    }
                }
                for (int i = 0; i < Lunar.lFtv.length; i++) {
                    m = Lunar.sFreg.matcher(Lunar.lFtv[i]);
                    if (m.find()) {
                        if (lM == Lunar.toInt(m.group(1)) && lD == Lunar.toInt(m.group(2))) {
                            this.isLFestival = true;
                            this.lFestivalName = m.group(4);
                            if ("*".equals(m.group(3))) {
                                this.isHoliday = true;
                            }
                            break;
                        }
                    }
                }
                // 月周节日
                int w, d;
                for (int i = 0; i < Lunar.wFtv.length; i++) {
                    m = Lunar.wFreg.matcher(Lunar.wFtv[i]);
                    if (m.find()) {
                        if (this.getSolarMonth() == Lunar.toInt(m.group(1))) {
                            w = Lunar.toInt(m.group(2));
                            d = Lunar.toInt(m.group(3));
                            if (this.solar.get(Calendar.WEEK_OF_MONTH) == w
                                    && this.solar.get(Calendar.DAY_OF_WEEK) == d) {
                                this.isSFestival = true;
                                this.sFestivalName += "|" + m.group(5);
                                if ("*".equals(m.group(4))) {
                                    this.isHoliday = true;
                                }
                            }
                        }
                    }
                }
                if (sy > 1874 && sy < 1909) {
                    this.description = "光绪" + (((sy - 1874) == 1) ? "元" : "" + (sy - 1874));
                }
                if (sy > 1908 && sy < 1912) {
                    this.description = "宣统" + (((sy - 1908) == 1) ? "元" : String.valueOf(sy - 1908));
                }
                if (sy > 1911 && sy < 1950) {
                    this.description = "民国" + (((sy - 1911) == 1) ? "元" : String.valueOf(sy - 1911));
                }
                if (sy > 1949) {
                    this.description = "共和国" + (((sy - 1949) == 1) ? "元" : String.valueOf(sy - 1949));
                }
                this.description += "年";
                this.sFestivalName = this.sFestivalName.replaceFirst("^\\|", "");
                this.isFinded = true;
            }

            private boolean isFinded = false;
            private boolean isSFestival = false;
            private boolean isLFestival = false;
            private String sFestivalName = "";
            private String lFestivalName = "";
            private String description = "";
            private boolean isHoliday = false;

            /**
             * 返回农历年闰月月份
             *
             * @param lunarYear 指定农历年份(数字)
             * @return 该农历年闰月的月份(数字, 没闰返回0)
             */
            private static int getLunarLeapMonth(int lunarYear) {
                // 数据表中,每个农历年用16bit来表示,
                // 前12bit分别表示12个月份的大小月,最后4bit表示闰月
                // 若4bit全为1或全为0,表示没闰, 否则4bit的值为闰月月份
                int leapMonth = Lunar.lunarInfo[lunarYear - 1900] & 0xf;
                leapMonth = (leapMonth == 0xf ? 0 : leapMonth);
                return leapMonth;
            }


            /**
             * 返回农历年闰月的天数
             *
             * @param lunarYear 指定农历年份(数字)
             * @return 该农历年闰月的天数(数字)
             */
            private static int getLunarLeapDays(int lunarYear) {
                // 下一年最后4bit为1111,返回30(大月)
                // 下一年最后4bit不为1111,返回29(小月)
                // 若该年没有闰月,返回0
                return Lunar.getLunarLeapMonth(lunarYear) > 0 ? ((Lunar.lunarInfo[lunarYear - 1899] & 0xf) == 0xf ? 30
                        : 29)
                        : 0;
            }

            /**
             * 返回农历年的总天数
             *
             * @param lunarYear 指定农历年份(数字)
             * @return 该农历年的总天数(数字)
             */
            private static int getLunarYearDays(int lunarYear) {
                // 按小月计算,农历年最少有12 * 29 = 348天
                int daysInLunarYear = 348;
                // 数据表中,每个农历年用16bit来表示,
                // 前12bit分别表示12个月份的大小月,最后4bit表示闰月
                // 每个大月累加一天
                for (int i = 0x8000; i > 0x8; i >>= 1) {
                    daysInLunarYear += ((Lunar.lunarInfo[lunarYear - 1900] & i) != 0) ? 1
                            : 0;
                }
                // 加上闰月天数
                daysInLunarYear += Lunar.getLunarLeapDays(lunarYear);

                return daysInLunarYear;
            }

            /**
             * 返回农历年正常月份的总天数
             *
             * @param lunarYear  指定农历年份(数字)
             * @param lunarMonth 指定农历月份(数字)
             * @return 该农历年闰月的月份(数字, 没闰返回0)
             */
            private static int getLunarMonthDays(int lunarYear, int lunarMonth) {
                // 数据表中,每个农历年用16bit来表示,
                // 前12bit分别表示12个月份的大小月,最后4bit表示闰月
                int daysInLunarMonth = ((Lunar.lunarInfo[lunarYear - 1900] & (0x10000 >> lunarMonth)) != 0) ? 30
                        : 29;
                return daysInLunarMonth;
            }


            /**
             * 取 Date 对象中用全球标准时间 (UTC) 表示的日期
             *
             * @param date 指定日期
             * @return UTC 全球标准时间 (UTC) 表示的日期
             */
            public static synchronized int getUTCDay(Date date) {
                Lunar.makeUTCCalendar();
                synchronized (utcCal) {
                    utcCal.clear();
                    utcCal.setTimeInMillis(date.getTime());
                    return utcCal.get(Calendar.DAY_OF_MONTH);
                }
            }

            private static GregorianCalendar utcCal = null;

            private static synchronized void makeUTCCalendar() {
                if (Lunar.utcCal == null) {
                    Lunar.utcCal = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
                }
            }

            /**
             * 返回全球标准时间 (UTC) (或 GMT) 的 1970 年 1 月 1 日到所指定日期之间所间隔的毫秒数。
             *
             * @param y   指定年份
             * @param m   指定月份
             * @param d   指定日期
             * @param h   指定小时
             * @param min 指定分钟
             * @param sec 指定秒数
             * @return 全球标准时间 (UTC) (或 GMT) 的 1970 年 1 月 1 日到所指定日期之间所间隔的毫秒数
             */
            public static synchronized long UTC(int y, int m, int d, int h, int min, int sec) {
                Lunar.makeUTCCalendar();
                synchronized (utcCal) {
                    utcCal.clear();
                    utcCal.set(y, m, d, h, min, sec);
                    return utcCal.getTimeInMillis();
                }
            }

            /**
             * 返回公历年节气的日期
             *
             * @param solarYear 指定公历年份(数字)
             * @param index     指定节气序号(数字,0从小寒算起)
             * @return 日期(数字, 所在月份的第几天)
             */
            private static int getSolarTermDay(int solarYear, int index) {

                return Lunar.getUTCDay(getSolarTermCalendar(solarYear, index));
            }

            /**
             * 返回公历年节气的日期
             *
             * @param solarYear 指定公历年份(数字)
             * @param index     指定节气序号(数字,0从小寒算起)
             * @return 日期(数字, 所在月份的第几天)
             */
            public static Date getSolarTermCalendar(int solarYear, int index) {
                long l = (long) 31556925974.7 * (solarYear - 1900)
                        + solarTermInfo[index] * 60000L;
                l = l + Lunar.UTC(1900, 0, 6, 2, 5, 0);
                return new Date(l);
            }

            private Calendar solar;
            private int lunarYear;
            private int lunarMonth;
            private int lunarDay;
            private boolean isLeap;
            private boolean isLeapYear;
            private int solarYear;
            private int solarMonth;
            private int solarDay;
            private int cyclicalYear = 0;
            private int cyclicalMonth = 0;
            private int cyclicalDay = 0;
            private int maxDayInMonth = 29;

            /**
             * 通过 Date 对象构建农历信息
             *
             * @param date 指定日期对象
             */
            public Lunar(Date date) {
                if (date == null) {
                    date = new Date();
                }
                this.init(date.getTime());
            }

            /**
             * 通过 TimeInMillis 构建农历信息
             *
             * @param TimeInMillis
             */
            public Lunar(long TimeInMillis) {
                this.init(TimeInMillis);
            }

            private void init(long TimeInMillis) {
                this.solar = Calendar.getInstance();
                this.solar.setTimeInMillis(TimeInMillis);
                Calendar baseDate = new GregorianCalendar(1900, 0, 31);
                long offset = (TimeInMillis - baseDate.getTimeInMillis()) / 86400000;
                // 按农历年递减每年的农历天数，确定农历年份
                this.lunarYear = 1900;
                int daysInLunarYear = Lunar.getLunarYearDays(this.lunarYear);
                while (this.lunarYear < 2100 && offset >= daysInLunarYear) {
                    offset -= daysInLunarYear;
                    daysInLunarYear = Lunar.getLunarYearDays(++this.lunarYear);
                }
                // 农历年数字

                // 按农历月递减每月的农历天数，确定农历月份
                int lunarMonth = 1;
                // 所在农历年闰哪个月,若没有返回0
                int leapMonth = Lunar.getLunarLeapMonth(this.lunarYear);
                // 是否闰年
                this.isLeapYear = leapMonth > 0;
                // 闰月是否递减
                boolean leapDec = false;
                boolean isLeap = false;
                int daysInLunarMonth = 0;
                while (lunarMonth < 13 && offset > 0) {
                    if (isLeap && leapDec) { // 如果是闰年,并且是闰月
                        // 所在农历年闰月的天数
                        daysInLunarMonth = Lunar.getLunarLeapDays(this.lunarYear);
                        leapDec = false;
                    } else {
                        // 所在农历年指定月的天数
                        daysInLunarMonth = Lunar.getLunarMonthDays(this.lunarYear, lunarMonth);
                    }
                    if (offset < daysInLunarMonth) {
                        break;
                    }
                    offset -= daysInLunarMonth;

                    if (leapMonth == lunarMonth && isLeap == false) {
                        // 下个月是闰月
                        leapDec = true;
                        isLeap = true;
                    } else {
                        // 月份递增
                        lunarMonth++;
                    }
                }
                this.maxDayInMonth = daysInLunarMonth;
                // 农历月数字
                this.lunarMonth = lunarMonth;
                // 是否闰月
                this.isLeap = (lunarMonth == leapMonth && isLeap);
                // 农历日数字
                this.lunarDay = (int) offset + 1;
                // 取得干支历
                this.getCyclicalData();
            }

            /**
             * 取干支历 不是历年，历月干支，而是中国的从立春节气开始的节月，是中国的太阳十二宫，阳历的。
             */
            private void getCyclicalData() {
                this.solarYear = this.solar.get(Calendar.YEAR);
                this.solarMonth = this.solar.get(Calendar.MONTH);
                this.solarDay = this.solar.get(Calendar.DAY_OF_MONTH);
                // 干支历
                int cyclicalYear = 0;
                int cyclicalMonth = 0;
                int cyclicalDay = 0;

                // 干支年 1900年立春後为庚子年(60进制36)
                int term2 = Lunar.getSolarTermDay(solarYear, 2); // 立春日期
                // 依节气调整二月分的年柱, 以立春为界
                if (solarMonth < 1 || (solarMonth == 1 && solarDay < term2)) {
                    cyclicalYear = (solarYear - 1900 + 36 - 1) % 60;
                } else {
                    cyclicalYear = (solarYear - 1900 + 36) % 60;
                }

                // 干支月 1900年1月小寒以前为 丙子月(60进制12)
                int firstNode = Lunar.getSolarTermDay(solarYear, solarMonth * 2); // 传回当月「节」为几日开始
                // 依节气月柱, 以「节」为界
                if (solarDay < firstNode) {
                    cyclicalMonth = ((solarYear - 1900) * 12 + solarMonth + 12) % 60;
                } else {
                    cyclicalMonth = ((solarYear - 1900) * 12 + solarMonth + 13) % 60;
                }

                // 当月一日与 1900/1/1 相差天数
                // 1900/1/1与 1970/1/1 相差25567日, 1900/1/1 日柱为甲戌日(60进制10)
                cyclicalDay = (int) (Lunar.UTC(solarYear, solarMonth, solarDay, 0, 0, 0) / 86400000 + 25567 + 10) % 60;
                this.cyclicalYear = cyclicalYear;
                this.cyclicalMonth = cyclicalMonth;
                this.cyclicalDay = cyclicalDay;
            }

            /**
             * 取农历年生肖
             *
             * @return 农历年生肖(例 : 龙)
             */
            public String getAnimalString() {
                return Lunar.Animals[(this.lunarYear - 4) % 12];
            }

            /**
             * 返回公历日期的节气字符串
             *
             * @return 二十四节气字符串, 若不是节气日, 返回空串(例 : 冬至)
             */
            public String getTermString() {
                // 二十四节气
                String termString = "";
                if (Lunar.getSolarTermDay(solarYear, solarMonth * 2) == solarDay) {
                    termString = Lunar.solarTerm[solarMonth * 2];
                } else if (Lunar.getSolarTermDay(solarYear, solarMonth * 2 + 1) == solarDay) {
                    termString = Lunar.solarTerm[solarMonth * 2 + 1];
                }
                return termString;
            }

            /**
             * 取得干支历字符串
             *
             * @return 干支历字符串(例 : 甲子年甲子月甲子日)
             */
            public String getCyclicalDateString() {
                return this.getCyclicaYear() + "年" + this.getCyclicaMonth() + "月"
                        + this.getCyclicaDay() + "日";
            }

            /**
             * 年份天干
             *
             * @return 年份天干
             */
            public int getTiananY() {
                return Lunar.getTianan(this.cyclicalYear);
            }

            /**
             * 月份天干
             *
             * @return 月份天干
             */
            public int getTiananM() {
                return Lunar.getTianan(this.cyclicalMonth);
            }

            /**
             * 日期天干
             *
             * @return 日期天干
             */
            public int getTiananD() {
                return Lunar.getTianan(this.cyclicalDay);
            }

            /**
             * 年份地支
             *
             * @return 年分地支
             */
            public int getDeqiY() {
                return Lunar.getDeqi(this.cyclicalYear);
            }

            /**
             * 月份地支
             *
             * @return 月份地支
             */
            public int getDeqiM() {
                return Lunar.getDeqi(this.cyclicalMonth);
            }

            /**
             * 日期地支
             *
             * @return 日期地支
             */
            public int getDeqiD() {
                return Lunar.getDeqi(this.cyclicalDay);
            }

            /**
             * 取得干支年字符串
             *
             * @return 干支年字符串
             */
            public String getCyclicaYear() {
                return Lunar.getCyclicalString(this.cyclicalYear);
            }

            /**
             * 取得干支月字符串
             *
             * @return 干支月字符串
             */
            public String getCyclicaMonth() {
                return Lunar.getCyclicalString(this.cyclicalMonth);
            }

            /**
             * 取得干支日字符串
             *
             * @return 干支日字符串
             */
            public String getCyclicaDay() {
                return Lunar.getCyclicalString(this.cyclicalDay);
            }

            /**
             * 返回农历日期字符串
             *
             * @return 农历日期字符串
             */
            public String getLunarDayString() {
                return Lunar.getLunarDayString(this.lunarDay);
            }

            /**
             * 返回农历日期字符串
             *
             * @return 农历日期字符串
             */
            public String getLunarMonthString() {
                return (this.isLeap() ? "闰" : "") + Lunar.getLunarMonthString(this.lunarMonth);
            }

            /**
             * 返回农历日期字符串
             *
             * @return 农历日期字符串
             */
            public String getLunarYearString() {
                return Lunar.getLunarYearString(this.lunarYear);
            }

            /**
             * 返回农历表示字符串
             *
             * @return 农历字符串(例 : 甲子年正月初三)
             */
            public String getLunarDateString() {
                return this.getLunarYearString() + "年"
                        + this.getLunarMonthString() + "月"
                        + this.getLunarDayString() + "日";
            }

            /**
             * 农历年是否是闰月
             *
             * @return 农历年是否是闰月
             */
            public boolean isLeap() {
                return isLeap;
            }

            /**
             * 农历年是否是闰年
             *
             * @return 农历年是否是闰年
             */
            public boolean isLeapYear() {
                return isLeapYear;
            }

            /**
             * 当前农历月是否是大月
             *
             * @return 当前农历月是大月
             */
            public boolean isBigMonth() {
                return this.getMaxDayInMonth() > 29;
            }

            /**
             * 当前农历月有多少天
             *
             * @return 当前农历月有多少天
             */
            public int getMaxDayInMonth() {
                return this.maxDayInMonth;
            }

            /**
             * 农历日期
             *
             * @return 农历日期
             */
            public int getLunarDay() {
                return lunarDay;
            }

            /**
             * 农历月份
             *
             * @return 农历月份
             */
            public int getLunarMonth() {
                return lunarMonth;
            }

            /**
             * 农历年份
             *
             * @return 农历年份
             */
            public int getLunarYear() {
                return lunarYear;
            }

            /**
             * 公历日期
             *
             * @return 公历日期
             */
            public int getSolarDay() {
                return solarDay;
            }

            /**
             * 公历月份
             *
             * @return 公历月份 (不是从0算起)
             */
            public int getSolarMonth() {
                return solarMonth + 1;
            }

            /**
             * 公历年份
             *
             * @return 公历年份
             */
            public int getSolarYear() {
                return solarYear;
            }

            /**
             * 星期几
             *
             * @return 星期几(星期日为 : 1, 星期六为 : 7)
             */
            public int getDayOfWeek() {
                return this.solar.get(Calendar.DAY_OF_WEEK);
            }

            /**
             * 黑色星期五
             *
             * @return 是否黑色星期五
             */
            public boolean isBlackFriday() {
                return (this.getSolarDay() == 13 && this.solar.get(Calendar.DAY_OF_WEEK) == 6);
            }

            /**
             * 是否是今日
             *
             * @return 是否是今日
             */
            public boolean isToday() {
                Calendar clr = Calendar.getInstance();
                return clr.get(Calendar.YEAR) == this.solarYear
                        && clr.get(Calendar.MONTH) == this.solarMonth
                        && clr.get(Calendar.DAY_OF_MONTH) == this.solarDay;
            }

            /**
             * 取得公历节日名称
             *
             * @return 公历节日名称, 如果不是节日返回空串
             */
            public String getSFestivalName() {
                return this.sFestivalName;
            }

            /**
             * 取得农历节日名称
             *
             * @return 农历节日名称, 如果不是节日返回空串
             */
            public String getLFestivalName() {
                return this.lFestivalName;
            }

            /**
             * 是否是农历节日
             *
             * @return 是否是农历节日
             */
            public boolean isLFestival() {
                if (!this.isFinded) {
                    this.findFestival();
                }
                return this.isLFestival;
            }

            /**
             * 是否是公历节日
             *
             * @return 是否是公历节日
             */
            public boolean isSFestival() {
                if (!this.isFinded) {
                    this.findFestival();
                }
                return this.isSFestival;
            }

            /**
             * 是否是节日
             *
             * @return 是否是节日
             */
            public boolean isFestival() {
                return this.isSFestival() || this.isLFestival();
            }

            /**
             * 是否是放假日
             *
             * @return 是否是放假日
             */
            public boolean isHoliday() {
                if (!this.isFinded) {
                    this.findFestival();
                }
                return this.isHoliday;
            }

            /**
             * 其它日期说明
             *
             * @return 日期说明(如 : 民国2年)
             */
            public String getDescription() {
                if (!this.isFinded) {
                    this.findFestival();
                }
                return this.description;
            }

            /**
             * 干支字符串
             *
             * @param cyclicalNumber 指定干支位置(数字,0为甲子)
             * @return 干支字符串
             */
            private static String getCyclicalString(int cyclicalNumber) {
                return Lunar.Tianan[Lunar.getTianan(cyclicalNumber)] + Lunar.Deqi[Lunar.getDeqi(cyclicalNumber)];
            }

            /**
             * 获得地支
             *
             * @param cyclicalNumber
             * @return 地支 (数字)
             */
            private static int getDeqi(int cyclicalNumber) {
                return cyclicalNumber % 12;
            }

            /**
             * 获得天干
             *
             * @param cyclicalNumber
             * @return 天干 (数字)
             */
            private static int getTianan(int cyclicalNumber) {
                return cyclicalNumber % 10;
            }

            /**
             * 返回指定数字的农历年份表示字符串
             *
             * @param lunarYear 农历年份(数字,0为甲子)
             * @return 农历年份字符串
             */
            private static String getLunarYearString(int lunarYear) {
                return Lunar.getCyclicalString(lunarYear - 1900 + 36);
            }

            /**
             * 返回指定数字的农历月份表示字符串
             *
             * @param lunarMonth 农历月份(数字)
             * @return 农历月份字符串 (例:正)
             */
            private static String getLunarMonthString(int lunarMonth) {
                String lunarMonthString = "";
                if (lunarMonth == 1) {
                    lunarMonthString = Lunar.lunarString2[4];
                } else {
                    if (lunarMonth > 9) {
                        lunarMonthString += Lunar.lunarString2[1];
                    }
                    if (lunarMonth % 10 > 0) {
                        lunarMonthString += Lunar.lunarString1[lunarMonth % 10];
                    }
                }
                return lunarMonthString;
            }

            /**
             * 返回指定数字的农历日表示字符串
             *
             * @param lunarDay 农历日(数字)
             * @return 农历日字符串 (例: 廿一)
             */
            private static String getLunarDayString(int lunarDay) {
                if (lunarDay < 1 || lunarDay > 30) {
                    return "";
                }
                int i1 = lunarDay / 10;
                int i2 = lunarDay % 10;
                String c1 = Lunar.lunarString2[i1];
                String c2 = Lunar.lunarString1[i2];
                if (lunarDay < 11) {
                    c1 = Lunar.lunarString2[0];
                }
                if (i2 == 0) {
                    c2 = Lunar.lunarString2[1];
                }
                return c1 + c2;
            }


            //日期工具辅助类
            private static class MyDate {

                private static final int[] dayMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                public int day;
                @SuppressWarnings("unused")
                public int dayCyl;
                @SuppressWarnings("unused")
                public boolean isLeap;
                @SuppressWarnings("unused")
                public int monCyl;
                public int month;
                public int year;
                @SuppressWarnings("unused")
                public int yearCyl;

                @SuppressWarnings("unused")
                public MyDate() {
                }

                @SuppressWarnings("unused")
                public MyDate(int paramInt1, int paramInt2, int paramInt3) {
                    this.year = paramInt1;
                    this.month = paramInt2;
                    this.day = paramInt3;
                }

                @SuppressWarnings("unused")
                public static int GetNumDayOfMonth(int paramInt1, int paramInt2) {
                    int i = dayMonth[(paramInt2 - 1)];
                    if ((IsBigYear(paramInt1)) && (paramInt2 == 2)) {
                        i++;
                    }
                    return i;
                }

                public static boolean IsBigYear(int paramInt) {
                    if (paramInt % 400 == 0) {
                        return true;
                    }
                    return (paramInt % 4 == 0) && (paramInt % 100 != 0);
                }

                public static long DateDays(Date aDate, Date aDate2) {
                    long myTime;
                    long myTime2;
                    long days = 0;
                    myTime = (aDate.getTime() / 1000);
                    // SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd");
                    myTime2 = (aDate2.getTime() / 1000);
                    if (myTime > myTime2) {
                        days = (myTime - myTime2) / (1 * 60 * 60 * 24);
                    } else {
                        days = (myTime2 - myTime) / (1 * 60 * 60 * 24);
                    }
                    return days;

                }
                // 求2个日期的天数

                @SuppressWarnings("unused")
                public static long DateDays(String date1, String date2) throws ParseException {

                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    long myTime;
                    Date aDate2;
                    Date aDate;
                    long myTime2;
                    long days = 0;

                    aDate = formatter.parse(date1);// 任意日期，包括当前日期
                    myTime = (aDate.getTime() / 1000);

                    // SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd");
                    aDate2 = formatter.parse(date2);// 任意日期，包括当前日期
                    myTime2 = (aDate2.getTime() / 1000);

                    if (myTime > myTime2) {
                        days = (myTime - myTime2) / (1 * 60 * 60 * 24);
                    } else {
                        days = (myTime2 - myTime) / (1 * 60 * 60 * 24);
                    }


                    return days;

                }

                // 求2个日期的天数
                public static long DateDays2(int year1, int month1, int day1, int year2,
                                             int month2, int day2) throws ParseException, ParseException {

                    String date1;
                    String date2;
                    date1 = year1 + "-" + month1 + "-" + day1;
                    date2 = year2 + "-" + month2 + "-" + day2;
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    long myTime;
                    Date aDate;
                    Date aDate2;
                    long myTime2;
                    long days = 0;

                    aDate = formatter.parse(date1);// 任意日期，包括当前日期
                    myTime = (aDate.getTime() / 1000);

                    // SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd");
                    aDate2 = formatter.parse(date2);// 任意日期，包括当前日期
                    myTime2 = (aDate2.getTime() / 1000);

                    if (myTime > myTime2) {
                        days = (myTime - myTime2) / (1 * 60 * 60 * 24);
                    } else {
                        days = (myTime2 - myTime) / (1 * 60 * 60 * 24);
                    }


                    return days;

                }

                public int GetNumDayFrom19000101() {
                    int day = 0;
                    try {
                        day = (int) DateDays2(this.year, this.month, this.day, 1900, 1, 1);
                    } catch (ParseException ex) {
                        System.out.println(ex.getMessage());
                    }
                    return day;
                }

                @SuppressWarnings("unused")
                public long GetSFrom19000101() {
                    return 86400L * (1L + GetNumDayFrom19000101());
                }

            }


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

    /**
     * 手机屏幕操作
     */
    public static class ScreenOperation {

        /**
         * 点击屏幕 可根据 屏幕的比例 与 具体的 X,Y 坐标点击
         */
        public static class AutoTouch {
            private static int width = 0;
            private static int height = 0;

            /**
             * 传入在屏幕中的比例位置，坐标左上角为基准
             *
             * @param act    传入Activity对象
             * @param ratioX 需要点击的x坐标在屏幕中的比例位置
             * @param ratioY 需要点击的y坐标在屏幕中的比例位置
             */
            public static void autoClickRatio(Activity act, final double ratioX, final double ratioY) {
                width = act.getWindowManager().getDefaultDisplay().getWidth();
                height = act.getWindowManager().getDefaultDisplay().getHeight();
                Thread.runJava(new Runnable() {
                    @Override
                    public void run() {
                        // 线程睡眠0.3s
                        Thread.sleep(300);
                        // 生成点击坐标
                        int x = (int) (width * ratioX);
                        int y = (int) (height * ratioY);

                        // 利用ProcessBuilder执行shell命令
                        String[] order = {"input", "tap", "" + x, "" + y};
                        try {
                            new ProcessBuilder(order).start();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

            /**
             * 传入在屏幕中的坐标，坐标左上角为基准
             *
             * @param act 传入Activity对象
             * @param x   需要点击的x坐标
             * @param y   需要点击的x坐标
             */
            public static void autoClickPos(Activity act, final double x, final double y) {
                width = act.getWindowManager().getDefaultDisplay().getWidth();
                height = act.getWindowManager().getDefaultDisplay().getHeight();
                // 利用ProcessBuilder执行shell命令
                String[] order = {"input", "tap", "" + x, "" + y};
                try {
                    new ProcessBuilder(order).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    /**
     * @ApplicationUtils 应用程序的小工具集合
     */
    public static class ApplicationUtils {

        /**
         * 分享文字
         *
         * @param activity
         * @param title
         * @param content
         */
        public void senText(Activity activity, String title, String content) {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, content);
            shareIntent = Intent.createChooser(shareIntent, title);
            activity.startActivity(shareIntent);
        }

        /**
         * @param activity
         * @param sharTitle
         * @param filePath
         * @分享文件
         */
        public void shareFile(Activity activity, String sharTitle, String filePath) {
            Intent intent = new Intent(Intent.ACTION_SEND);// 发送多个文件
            intent.setType("*/*");
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(filePath)));
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            activity.startActivity(Intent.createChooser(intent, sharTitle));

        }

        /**
         * @param editText
         * @param activity
         * @弹出软件盘
         */
        public static void editKeyboard(EditText editText, Activity activity) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(editText, InputMethodManager.RESULT_SHOWN);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
            editText.requestFocus();// 为搜索框 获取光标
        }

        /**
         * @param editText
         * @param activity
         * @收起软键盘
         */
        public static void editKeyShrink(EditText editText, Activity activity) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }

        /**
         * @param context
         * @param text
         * @将字符串复制到粘贴板上
         */
        public static void copyToClipboard(Context context, String text) {
            ClipboardManager systemService = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            systemService.setPrimaryClip(ClipData.newPlainText("text", text));
        }

        /**
         * @param context  上下文
         * @param view     保存图片的组件
         * @param fileName 文件名
         * @保存图片
         */
        public static void saveImage(Context context, View view, String fileName) {
            Bitmap bm = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bm);
            view.draw(canvas);
            String sd = "sdcard/";
            String fliename = sd + fileName + ".png";
            File file = new File(fliename);
            try {
                FileOutputStream out = new FileOutputStream(fliename);
                bm.compress(Bitmap.CompressFormat.PNG, 90, out);
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 通知系统更新图库
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            intent.setData(Uri.fromFile(file));
            context.sendBroadcast(intent);
        }

        /**
         * @param activity
         * @return
         * @获取App名字
         */
        public static String getAppName(Activity activity) {
            return activity.getResources().getString(R.string.app_name);
        }

        /**
         * @param mContext
         * @return
         * @获取软件版本号
         */
        public static int getVersionCode(Context mContext) {
            int versionCode = 0;
            try {
                // 获取软件版本号，对应AndroidManifest.xml下android:versionCode
                versionCode = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            return versionCode;
        }

        /**
         * @param context
         * @return
         * @获取版本号名称
         */
        public static String getVerName(Context context) {
            String verName = "";
            try {
                verName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            return verName;
        }

        /**
         * @param zipPtath        解压文件的路径
         * @param outputDirectory 解压后的输出路径
         * @param isDeleteZipPage 是否保留压缩文件
         * @throws IOException
         * @解压文件
         */
        public static void unzipFile(String zipPtath, String outputDirectory, boolean isDeleteZipPage)
                throws IOException {
            /**
             * 解压assets的zip压缩文件到指定目录
             *
             * @param context上下文对象
             * @param assetName压缩文件名
             * @param outputDirectory输出目录
             * @param isReWrite是否覆盖
             * @throws IOException
             */

//	        Log.i(TAG,"开始解压的文件： "  + zipPtath + "\n" + "解压的目标路径：" + outputDirectory );
            // 创建解压目标目录
            File file = new File(outputDirectory);
            // 如果目标目录不存在，则创建
            if (!file.exists()) {
                file.mkdirs();
            }
            // 打开压缩文件
            InputStream inputStream = new FileInputStream(zipPtath);
            ZipInputStream zipInputStream = new ZipInputStream(inputStream);

            // 读取一个进入点
            ZipEntry zipEntry = zipInputStream.getNextEntry();
            // 使用1Mbuffer
            byte[] buffer = new byte[1024 * 1024];
            // 解压时字节计数
            int count = 0;
            // 如果进入点为空说明已经遍历完所有压缩包中文件和目录
            while (zipEntry != null) {
                if (!zipEntry.isDirectory()) { // 如果是一个文件
                    // 如果是文件
                    String fileName = zipEntry.getName();
                    fileName = fileName.substring(fileName.lastIndexOf("/") + 1); // 截取文件的名字 去掉原文件夹名字
                    file = new File(outputDirectory + File.separator + fileName); // 放到新的解压的文件路径

                    file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    while ((count = zipInputStream.read(buffer)) > 0) {
                        fileOutputStream.write(buffer, 0, count);
                    }
                    fileOutputStream.close();

                }

                // 定位到下一个文件入口
                zipEntry = zipInputStream.getNextEntry();
            }
            zipInputStream.close();
//	            log(TAG,"解压完成");
            if (isDeleteZipPage) {
                new File(zipPtath).delete();// 删除当前补丁压缩包
            }

        }

        /**
         * @param path
         * @return
         * @获取文件夹中所有文件名
         */
        public static List<String> getFilesAllName(String path) {
            File file = new File(path);
            File[] files = file.listFiles();
            if (files == null) {
                Log.e("error", "空目录");
                return null;
            }
            List<String> s = new ArrayList<String>();
            for (int i = 0; i < files.length; i++) {
                s.add(files[i].getAbsolutePath());
            }
            return s;
        }

        /**
         * @param file         清空的文件路径
         * @param isSaveFolder 是否保存当前文件夹 true：b
         * @清空文件夹中所有文件
         */
        public static void deleteAllFile(File file, boolean isSaveFolder) {

            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    File f = files[i];
                    deleteAllFile(f, isSaveFolder);
                }
                if (!isSaveFolder) {// 是否保留本文件夹
                    file.delete();// 如要保留文件夹，只删除文件，请注释这行
                }
            } else if (file.exists()) {
                file.delete();
            }
        }

        /**
         * @return
         * @获取手机根目录
         */
        public static String getAppDirectory() {
            return Environment.getExternalStorageDirectory().toString();
        }

        /**
         * @param context
         * @return
         * @获取当前apk包名
         */
        public static String getPackageName(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                return packageInfo.packageName;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

    }


    //=========================================== APP迭代类（更新、热修复bug） =========================================

    /**
     * APP 迭代类
     */
    public static class AppIteration {

        //更新 APP 版本
        public static class UpdateApp {

            /**
             * 内置 更新 APP 版本 注意
             *
             * 详细教程：https://blog.csdn.net/qq_39799899/article/details/102470084
             *
             * 1.在清单文件添加数据共享
             * <application>
             * ...
             <!--数据共享-->
             <provider
             android:name="androidx.core.content.FileProvider"
             android:authorities="自己包名.fileprovider"
             android:grantUriPermissions="true"
             android:exported="false">
             <meta-data
             android:name="android.support.FILE_PROVIDER_PATHS"
             android:resource="@xml/file_paths" />
             </provider>
             * ...
             * </<application>
             *
             * 2.添加 file_paths.xml 文件
             * <paths>
             *     <external-path path="." name="external_storage_root" />
             * </paths>
             *
             * 3.记得添加权限
             *  <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" /> <!-- 写入手机权限 -->
             *  <uses-permission android:name="android.permission.INTERNET" />  <!-- 网络权限 -->
             *  <uses-permission android:name="android.permission.READ_PHONE_STATE" />  <!-- 读取手机权限 -->
             *
             */

            /**
             * @param downloadUrl
             * @param savePath
             * @在网络下载文件到本地
             * @下载服务器的APK
             */
            public static void downloadFile(final String downloadUrl, final String savePath) {

                Thread.runJava(new Runnable() {
                    @Override
                    public void run() {
                        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + savePath);//记得加扩展名
                        file.getParentFile().mkdir();
                        try {
                            file.createNewFile();
                            URL url2 = new URL(downloadUrl);
                            HttpURLConnection conn = (HttpURLConnection) url2.openConnection();
                            conn.connect();
                            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                                InputStream ips = conn.getInputStream();
                                FileOutputStream fops = new FileOutputStream(file);

                                byte[] buf = new byte[1024];
                                int read = ips.read(buf);
                                while (read != -1) {
                                    fops.write(buf, 0, read);
                                    fops.flush();
                                    read = ips.read(buf);
                                }
                                fops.close();
                                ips.close();
                                conn.disconnect();
                            }
                        } catch (Exception e) {
                            if (getGT().getGtLogTf()) {
                                err(getLineInfo(), "网络下载文件报错： " + e);
                            }
                        }
                    }
                });

            }

            /**
             * @param apkPath
             * @安装APK
             * @安装新版本
             */
            public static void installNewApk(Activity activity, String apkPath) {
                String url = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + apkPath;
                Uri uri;
                Intent intent = new Intent(Intent.ACTION_VIEW);

                //支持7.0
                if (Build.VERSION.SDK_INT >= 24) {
                    uri = FileProvider.getUriForFile(activity, activity.getPackageName() + ".fileprovider", new File(url));
                } else {
                    uri = Uri.fromFile(new File(url));
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                }

                intent.setDataAndType(uri, "application/vnd.android.package-archive"); // 对应apk类型

                activity.getApplication().startActivity(intent);
            }


        }


        // 热修复 APP
        public static class RepairAPP {

            // 这下面两个属性可自己修改
            private static String repairFileName = null; // 修复文件名 默认补丁包文件名为 当前APP版本号 开头
            private static String repairFilePath = null; // 修复文件路径 默认补丁包的路径为 当前App包名 下的 thermalRemediation文件夹下
            private static String repairFileFolderName = "thermalRemediation"; // 默认存储热修复默认的文件夹名称
            private static String repairBugFilePath = null;// 热修复 bug 文件路径

            public static String getRepairFileName() {
                return repairFileName;
            }

            public static String getRepairFilePath() {
                return repairFilePath;
            }

            public static void setRepairFileName(String repairFileName) {
                RepairAPP.repairFileName = repairFileName;
            }

            public static void setRepairFilePath(String repairFilePath) {
                RepairAPP.repairFilePath = repairFilePath;
            }

            public static String getRepairFileFolderName() {
                return repairFileFolderName;
            }

            public static void setRepairFileFolderName(String repairFileFolderName) {
                RepairAPP.repairFileFolderName = repairFileFolderName;
            }

            private static final String DEX_SUFFIX = ".dex";
            private static final String APK_SUFFIX = ".apk";
            private static final String JAR_SUFFIX = ".jar";
            private static final String ZIP_SUFFIX = ".zip";
            private static final String DEX_DIR = "odex";
            private static final String OPTIMIZE_DEX_DIR = "optimize_dex";
            private static HashSet<File> loadedDex = new HashSet<File>();

            static {
                loadedDex.clear();
            }

            /**
             * @param context
             * @初始化 热修复路径与文件格式
             */
            public static void init(Context context) {
                // 如果 补丁包文件夹名为 null
                if (repairFilePath == null) {
                    repairFilePath = ApplicationUtils.getPackageName(context) + "/" + repairFileFolderName;// 设置补丁包目录为当前
                }

                // 如果 补丁包文件名为 null
                if (repairFileName == null) {
                    repairFileName = ApplicationUtils.getVerName(context);// 默认补丁包文件名为 当前APP版本号 开头
                }

            }

            /**
             * 开启修复
             *
             * @param context
             */
            public static void startRepair(final Context context) {
                init(context);
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                // 遍历所有的修复dex , 因为可能是多个dex修复包
                File fileDir = externalStorageDirectory != null
                        ? new File(externalStorageDirectory, RepairAPP.repairFilePath)
                        : new File(context.getFilesDir(), RepairAPP.DEX_DIR);// data/user/0/包名/files/odex（这个可以任意位置）
                if (!fileDir.exists()) {// 如果目录不存在就创建所有目录，这里需要添加权限
                    fileDir.mkdirs();
                }

                repairBugFilePath = getRepairAppDirectory(context);// 赋值热修复 Bug 文件路径

                if (RepairAPP.isGoingToFix(context)) {// 是否需要热修复
                    RepairAPP.loadFixedDex(context, Environment.getExternalStorageDirectory());// 加载补丁包
//                    log("正在修复");

//                    log("bug文件目录:" + repairBugFilePath);

                    // 解决 oat 文件的 bug
                    for (String path : ApplicationUtils.getFilesAllName(repairBugFilePath)) {
                        if (path.indexOf("oat") != -1) {
                            repairBugFilePath += "/oat";
//                            log("【进入删除 oat 文件 bug】");
                            GT.ApplicationUtils.deleteAllFile(new File(repairBugFilePath), false);
                        }

                    }

                }
            }

            /**
             * @return
             * @获取手机热修复根目录
             */
            public static String getRepairAppDirectory(Context context) {
                if (GT.AppIteration.RepairAPP.getRepairFilePath() == null) {
                    init(context);
                }
                return Environment.getExternalStorageDirectory() + "/" + GT.AppIteration.RepairAPP.getRepairFilePath()
                        + "/";

            }

            /**
             * 加载补丁，使用默认目录：data/data/包名/files/odex
             *
             * @param context
             */
            public static void loadFixedDex(Context context) {
                loadFixedDex(context, null);
            }

            /**
             * 加载补丁
             *
             * @param context       上下文
             * @param patchFilesDir 补丁所在目录
             */
            public static void loadFixedDex(Context context, File patchFilesDir) {
                // dex合并之前的dex
                doDexInject(context, loadedDex);
            }

            /**
             * @验证是否需要热修复
             * @author bthvi
             * @time 2019/10/10 11:42
             * @desc 验证是否需要热修复
             */
            public static boolean isGoingToFix(Context context) {
                boolean canFix = false;
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                // 遍历所有的修复dex , 因为可能是多个dex修复包
                File fileDir = externalStorageDirectory != null ? new File(externalStorageDirectory, repairFilePath)
                        : new File(context.getFilesDir(), DEX_DIR);// data/data/包名/files/odex（这个可以任意位置）
                File[] listFiles = fileDir.listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        if (file.getName().startsWith(repairFileName) && (file.getName().endsWith(DEX_SUFFIX)
                                || file.getName().endsWith(APK_SUFFIX) || file.getName().endsWith(JAR_SUFFIX)
                                || file.getName().endsWith(ZIP_SUFFIX))) {

                            loadedDex.add(file);// 存入集合
                            // 有目标dex文件, 需要修复
                            canFix = true;
                        }
                    }
                }
                return canFix;
            }

            /**
             * @param context
             * @param downloadUrl
             * @下载Zip补丁包并加载
             */
            public static void downloadZipServicePack(final Context context, final String downloadUrl) {
                final String savePath = GT.AppIteration.RepairAPP.getRepairAppDirectory(context)
                        + "thermalRemediation.zip";

                File file = new File(GT.AppIteration.RepairAPP.getRepairAppDirectory(context));
                if (!file.exists()) {
                    file.mkdirs();
                }

                Thread.runJava(new Runnable() {
                    @Override
                    public void run() {
                        File file = new File(savePath);// 记得加扩展名
                        file.getParentFile().mkdir();
                        try {
                            file.createNewFile();
                            URL url2 = new URL(downloadUrl);
                            HttpURLConnection conn = (HttpURLConnection) url2.openConnection();
                            conn.connect();
                            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                                InputStream ips = conn.getInputStream();
                                FileOutputStream fops = new FileOutputStream(file);

                                byte[] buf = new byte[1024];
                                int read = ips.read(buf);
                                while (read != -1) {
                                    fops.write(buf, 0, read);
                                    fops.flush();
                                    read = ips.read(buf);
                                }
                                fops.close();
                                ips.close();
                                conn.disconnect();
                            }
                        } catch (Exception e) {
                            if (GT.getGT().getGtLogTf()) {
                                GT.log(getLineInfo(), "网络下载app报错： " + e);
                            }
                        }
                        try {
                            ApplicationUtils.unzipFile(savePath,
                                    GT.AppIteration.RepairAPP.getRepairAppDirectory(context), true);
                        } catch (IOException e) {
                            if (GT.getGT().getGtLogTf()) {
                                log(getLineInfo(), "解压失败： " + e);
                            }
                            e.printStackTrace();
                        }

                        GT.AppIteration.RepairAPP.startRepair(context);// 开始热修复

                    }
                });
            }

            private static void doDexInject(Context context, HashSet<File> loadedDex) {

                String optimizeDir = context.getFilesDir().getAbsolutePath() + File.separator + OPTIMIZE_DEX_DIR;
                File fopt = new File(optimizeDir);
                if (!fopt.exists()) {
                    fopt.mkdirs();
                }

                try {
                    // 1.加载应用程序dex的Loader
                    PathClassLoader pathLoader = (PathClassLoader) context.getClassLoader();
                    for (File dex : loadedDex) {
                        // 2.加载指定的修复的dex文件的Loader
                        DexClassLoader dexLoader = new DexClassLoader(dex.getAbsolutePath(), // 修复好的dex（补丁）所在目录
                                fopt.getAbsolutePath(), // 存放dex的解压目录（用于jar、zip、apk格式的补丁）
                                null, // 加载dex时需要的库
                                pathLoader// 父类加载器
                        );
                        // 3.开始合并
                        // 合并的目标是Element[],重新赋值它的值即可

                        /**
                         * BaseDexClassLoader中有 变量: DexPathList pathList DexPathList中有 变量 Element[]
                         * dexElements 依次反射即可
                         */

                        // 3.1 准备好pathList的引用
                        Object dexPathList = getPathList(dexLoader);
                        Object pathPathList = getPathList(pathLoader);
                        // 3.2 从pathList中反射出element集合
                        Object leftDexElements = getDexElements(dexPathList);
                        Object rightDexElements = getDexElements(pathPathList);
                        // 3.3 合并两个dex数组
                        Object dexElements = combineArray(leftDexElements, rightDexElements);
                        // 重写给PathList里面的Element[] dexElements;赋值
                        Object pathList = getPathList(pathLoader);// 一定要重新获取，不要用pathPathList，会报错
                        setField(pathList, pathList.getClass(), "dexElements", dexElements);
                    }
//                   Toast.makeText(appContext, "修复完成", Toast.LENGTH_SHORT).show();
//                    log("修复完成");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            /**
             * 反射给对象中的属性重新赋值
             */
            private static void setField(Object obj, Class<?> cl, String field, Object value)
                    throws NoSuchFieldException, IllegalAccessException {
                Field declaredField = cl.getDeclaredField(field);
                declaredField.setAccessible(true);
                declaredField.set(obj, value);
            }

            /**
             * 反射得到对象中的属性值
             */
            private static Object getField(Object obj, Class<?> cl, String field)
                    throws NoSuchFieldException, IllegalAccessException {
                Field localField = cl.getDeclaredField(field);
                localField.setAccessible(true);
                return localField.get(obj);
            }

            /**
             * 反射得到类加载器中的pathList对象
             */
            private static Object getPathList(Object baseDexClassLoader)
                    throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
                // TODO 当前这行代码在有些机型上会产生oat文件，我已经做了处理
                return getField(baseDexClassLoader, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
            }

            /**
             * 反射得到pathList中的dexElements
             */
            private static Object getDexElements(Object pathList) throws NoSuchFieldException, IllegalAccessException {
                return getField(pathList, pathList.getClass(), "dexElements");
            }

            /**
             * 数组合并
             */
            private static Object combineArray(Object arrayLhs, Object arrayRhs) {
                Class<?> clazz = arrayLhs.getClass().getComponentType();
                int i = Array.getLength(arrayLhs);// 得到左数组长度（补丁数组）
                int j = Array.getLength(arrayRhs);// 得到原dex数组长度
                int k = i + j;// 得到总数组长度（补丁数组+原dex数组）
                Object result = Array.newInstance(clazz, k);// 创建一个类型为clazz，长度为k的新数组
                System.arraycopy(arrayLhs, 0, result, 0, i);
                System.arraycopy(arrayRhs, 0, result, i, j);
                return result;
            }

        }


    }


    //=========================================== APP 存储池 =========================================

    /**
     * @App存储池
     */
    public static class AppDataPool {

        /**
         * @App内部存储池
         * @临时数据
         */
        public static class Interior {

            /**
             * @内部存储池
             * @存储数据的临时容器
             */
            private final static Map<Object, Object> interiorDataPool = new HashMap<>();

            /**
             * @param classs
             * @param key
             * @param data
             * @return 操作成功 返回 true
             * @保存数据
             */
            public static boolean saveDataPool(Object classs, Object key, Object data) {
                Object idKey = getIdKey(classs, key);//形成唯一的 IdKey
                if (!interiorDataPool.containsKey(idKey)) {
                    interiorDataPool.put(idKey, data);//存储数据
                    return true;
                } else {
                    if (getGT().getGtLogTf()) {
                        log(getLineInfo(), "App内部存储池，保存数据失败！当前数据池中存在该值");
                    }
                    return false;
                }
            }

            /**
             * @param classs
             * @param key
             * @return 操作成功 返回 true
             * @删除数据
             */
            public static boolean deleteDataPool(Object classs, Object key) {
                Object idKey = getIdKey(classs, key);//形成唯一的 IdKey
                if (interiorDataPool.containsKey(idKey)) {
                    interiorDataPool.remove(idKey);//删除数据
                    return true;
                } else {
                    if (getGT().getGtLogTf()) {
                        log(getLineInfo(), "App内部存储池，删除数据失败！当前数据池中不存在该值");
                    }
                    return false;
                }
            }

            /**
             * @param classs
             * @param key
             * @return 成功返回 查询的值 否则返回 null
             * @查询数据
             */
            public static Object queryDataPool(Object classs, Object key) {
                Object idKey = getIdKey(classs, key);//形成唯一的 IdKey
                if (interiorDataPool.containsKey(idKey)) {
                    return interiorDataPool.get(idKey);//获取数据
                } else {
                    if (getGT().getGtLogTf()) {
                        log(getLineInfo(), "App内部存储池，查询数据失败！当前数据池中不存在该值");
                    }
                    return null;
                }
            }

            /**
             * @param classs
             * @param key
             * @return 成功返回 true
             * @修改数据
             */
            public static boolean updateDataPool(Object classs, Object key, Object toData) {
                Object idKey = getIdKey(classs, key);//形成唯一的 IdKey
                if (interiorDataPool.containsKey(idKey)) {
                    interiorDataPool.put(idKey, toData);//修改数据
                    return true;
                } else {
                    if (getGT().getGtLogTf()) {
                        log(getLineInfo(), "App内部存储池，修改数据失败！当前数据池中不存在该值");
                    }
                    return false;
                }
            }

            /**
             * @return
             * @清空
             */
            public static boolean clearData() {
                if (interiorDataPool != null) {
                    try {
                        interiorDataPool.clear();
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }
                return false;
            }

            /**
             * @param classs
             * @param key
             * @return
             * @APP存储池中返回IdKey
             */
            private static String getIdKey(Object classs, Object key) {
                return classs.getClass().getName().replace(".", "/") + ".java 【" + key + "】";// 获取文件包名与Java文件名
            }

        }

        /**
         * @APP外部存储池
         * @持久性数据（需要在清单文件中添加以下文件读取与写入权限）
         * @<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
         * @<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
         */
        public static class External {

            /**
             * @外部存储池
             * @存储数据的永久容器
             */
            private static Map<Object, Object> externalDataPool = null;    //当前App所有数据的容器
            private static Object passWord = null;             //当前文件的密码
            private static GT_File gt_file = null;             //GT_File 工具包
            private static String fileSaveDataPath = null;     //文件保存数据的路径
            private static String fileName = null;             //保存数据的文件名
            private static String filePath = null;             //当前文件的全部路径
            private static Gson gson = null;

            /**
             * @param activity
             * @param passWord
             * @初始化
             */
            public static void init(Activity activity, Object passWord) {
                AppAuthorityManagement.readWritePermission(activity);//申请文件读写的6.0以上权限
                External.passWord = Encryption.MD5.encryptMD5(AppUtils.getAppPackageName() + passWord);//将 密码 进行 MD5 加密
                gt_file = new GT_File();//创建 File 对象
                gson = new Gson();

                fileSaveDataPath = "/Android/data/com.gsls.gtlibrary/AppDataPool/";//GT APP 公共池数据源
                fileName = ApplicationUtils.getAppName(activity) + ".GT";//文件名与扩展名

//                log("读取数据池的路径:" + ApplicationUtils.getAppDirectory() + fileSaveDataPath + AppUtils.getAppPackageName() + "/" + fileName);
                File file = new File(ApplicationUtils.getAppDirectory() + fileSaveDataPath + AppUtils.getAppPackageName() + "/" + fileName);

                if (!file.exists()) {//如果当前文件不存在
//                    log("当前文件不存在 创建 Map");
                    externalDataPool = new HashMap<>();//创建 Map
                } else {
//                    log("当前文件存在");
                    List<String> filesAllName = ApplicationUtils.getFilesAllName(ApplicationUtils.getAppDirectory() + fileSaveDataPath + AppUtils.getAppPackageName());
                    if (filesAllName != null && filesAllName.size() > 0) {
                        String fileName = filesAllName.get(0);
                        fileName = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length());
                        String queryData = gt_file.query(fileSaveDataPath + AppUtils.getAppPackageName(), fileName);//读取文件内的数据
                        String encryptData = Encryption.DES.decryptPassword(queryData, External.passWord);//将加密的数据解密
                        externalDataPool = gson.fromJson(encryptData, HashMap.class);
                    }

                }

            }


            /**
             * @param packName
             * @param key
             * @param data
             * @return 返回为 true 则表示 保存成功
             * @保存数据(保存只能保存自己app池下的数据)
             */
            public static boolean saveDataPool(Object key, Object data) {

                if (externalDataPool != null && !externalDataPool.containsKey(key)) {
                    //保存操作
                    externalDataPool.put(key, data);//将数据保存到map中
                    String encryptData = Encryption.DES.encryptPassword(externalDataPool, passWord);
//                    log("存入的数据:" + encryptData);
                    gt_file.save(encryptData, fileSaveDataPath + AppUtils.getAppPackageName(), fileName);
//                    log("保存成功");
                    return true;
                } else {
                    if (getGT().getGtLogTf()) {
                        log(getLineInfo(), "当前保存 外部数据池出错，数据池 中已存在该 Key 保存失败");
                    }
                    return false;
                }

            }

            /**
             * @param packageName
             * @param passWord
             * @param key
             * @param toData
             * @return
             * @查询数据(查询自己app池下的数据)
             */
            public static Object queryDataPool(Object key) {

                File file = new File(ApplicationUtils.getAppDirectory() + fileSaveDataPath + AppUtils.getAppPackageName() + "/" + fileName);

                if (!file.exists()) {//如果当前文件不存在
//                    log("当前文件不存在 创建 Map");
                    externalDataPool = new HashMap<>();//创建 Map
                } else {
//                    log("当前文件存在");
                    List<String> filesAllName = ApplicationUtils.getFilesAllName(ApplicationUtils.getAppDirectory() + fileSaveDataPath + AppUtils.getAppPackageName());
                    if (filesAllName != null && filesAllName.size() > 0) {
                        String fileName = filesAllName.get(0);
                        fileName = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length());
                        String queryData = gt_file.query(fileSaveDataPath + AppUtils.getAppPackageName(), fileName);//读取文件内的数据
                        String encryptData = Encryption.DES.decryptPassword(queryData, External.passWord);//将加密的数据解密
                        externalDataPool = gson.fromJson(encryptData, HashMap.class);
                        if (externalDataPool != null && externalDataPool.containsKey(key)) {
                            return externalDataPool.get(key);//获取数据
                        } else {
                            if (getGT().getGtLogTf()) {
                                log(getLineInfo(), "当前查询 内部数据池出错，数据池 中已存在该 Key 查询失败");
                            }
                            return null;
                        }
                    }

                }
                return null;
            }


            /**
             * @param packName
             * @param key
             * @param data
             * @return 返回为 true 则表示 保存成功
             * @查询数据(查询需要输入指定查询App的包名)
             */
            public static Object queryDataPool(Object packageName, Object passWord, Object key) {

                File file = new File(ApplicationUtils.getAppDirectory() + fileSaveDataPath + packageName + "/" + fileName);
                if (file.exists()) {   //如果当前文件不存在
//                    log("当前文件存在");
                    String queryData = gt_file.query(fileSaveDataPath + packageName, fileName);//读取文件内的数据
//                    log("读取出来加密的数据:" + queryData);
                    passWord = Encryption.MD5.encryptMD5(packageName.toString() + passWord);//将 密码 进行 MD5 加密
                    String encryptData = Encryption.DES.decryptPassword(queryData, passWord);//将加密的数据解密
//                    log("解密出来的数据:" + encryptData);
                    Map<Object, Object> map = new HashMap<>();
                    map = gson.fromJson(encryptData, HashMap.class);
//                    log("初始化时 读取出来的map:" + map);
                    if (map.containsKey(key)) {
                        return map.get(key);
                    } else {
                        if (getGT().getGtLogTf()) {
                            log(getLineInfo(), "当前查询 外部数据池出错，数据池 中不存在该 Key 查询失败");
                        }
                        return null;
                    }
                } else {
                    if (getGT().getGtLogTf()) {
                        log(getLineInfo(), "当前查询 外部数据池出错，数据池 中不存在该 app包名 的数据池 查询失败");
                    }
                    return null;
                }

            }


            /**
             * @param packageName
             * @param passWord
             * @param key
             * @param toData
             * @return
             * @修改数据(修改只能修改自己app池下的数据)
             */
            public static boolean updateDataPool(Object key, Object toData) {

                if (externalDataPool != null && externalDataPool.containsKey(key)) {
                    //保存操作
                    externalDataPool.put(key, toData);//将数据保存到map中
                    String encryptData = Encryption.DES.encryptPassword(externalDataPool, passWord);
//                    log("修改存入的数据:" + encryptData);
                    gt_file.save(encryptData, fileSaveDataPath + AppUtils.getAppPackageName(), fileName);
//                    log("修改成功");
                    return true;
                } else {
                    if (getGT().getGtLogTf()) {
                        log(getLineInfo(), "当前修改 外部数据池出错，数据池 中不已存在该 Key 修改失败");
                    }
                    return false;
                }

            }


            /**
             * @param packageName
             * @param passWord
             * @param key
             * @param toData
             * @return
             * @删除数据(删除只能删除自己app池下的数据)
             */
            public static boolean deleteDataPool(Object key) {

                if (externalDataPool != null && externalDataPool.containsKey(key)) {
                    //保存操作
                    externalDataPool.remove(key);//将数据删除到map中
                    String encryptData = Encryption.DES.encryptPassword(externalDataPool, passWord);
//                    log("删除存入的数据:" + encryptData);
                    gt_file.save(encryptData, fileSaveDataPath + AppUtils.getAppPackageName(), fileName);
//                    log("删除成功");
                    return true;
                } else {
                    if (getGT().getGtLogTf()) {
                        log(getLineInfo(), "当前删除 外部数据池出错，数据池 中不已存在该 Key 删除失败");
                    }
                    return false;
                }
            }


            /**
             * @param packName
             * @param key
             * @param data
             * @return 返回为 true 则表示 保存成功
             * @清空数据(清空只能保存自己app池下的数据)
             */
            public static boolean clearDataPool(Object key, Object data) {

                if (externalDataPool != null && !externalDataPool.containsKey(key)) {
                    externalDataPool.clear();
                    String encryptData = Encryption.DES.encryptPassword(externalDataPool, passWord);
                    gt_file.save(encryptData, fileSaveDataPath + AppUtils.getAppPackageName(), fileName);
                    return true;
                } else {
                    if (getGT().getGtLogTf()) {
                        log(getLineInfo(), "当前清空 外部数据池出错，数据池 中不已存在该 Key 清空失败");
                    }
                    return false;
                }

            }


        }


    }

    //=========================================== 字符串加密类 =========================================

    /**
     * @加密类
     */
    public static class Encryption {

        /**
         * @MD5 加密算法
         */
        public static class MD5 {

            private static final String hexDigIts[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
                    "e", "f"};

            /**
             * MD5加密
             *
             * @param origin      字符
             * @param charsetname 编码
             * @return
             */
            public static String encryptMD5(String origin) {
                String resultString = null;
                try {
                    resultString = new String(origin);
                    MessageDigest md = MessageDigest.getInstance("MD5");
                    if (null == "UTF-8" || "".equals("UTF-8")) {
                        resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
                    } else {
                        resultString = byteArrayToHexString(md.digest(resultString.getBytes("UTF-8")));
                    }
                } catch (Exception e) {
                }
                return resultString;
            }

            public static String byteArrayToHexString(byte b[]) {
                StringBuffer resultSb = new StringBuffer();
                for (int i = 0; i < b.length; i++) {
                    resultSb.append(byteToHexString(b[i]));
                }
                return resultSb.toString();
            }

            public static String byteToHexString(byte b) {
                int n = b;
                if (n < 0) {
                    n += 256;
                }
                int d1 = n / 16;
                int d2 = n % 16;
                return hexDigIts[d1] + hexDigIts[d2];
            }

        }

        /**
         * @DES 加密算法
         */
        public static class DES {
            /**
             * 加密
             *
             * @param clearText
             * @return
             */
            public static String encryptPassword(Object clearText, Object password) {
                try {
                    DESKeySpec keySpec = null;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        keySpec = new DESKeySpec(String.valueOf(password).getBytes(StandardCharsets.UTF_8));
                    }
                    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
                    SecretKey key = keyFactory.generateSecret(keySpec);

                    Cipher cipher = Cipher.getInstance("DES");
                    cipher.init(Cipher.ENCRYPT_MODE, key);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        return Base64.encodeToString(cipher.doFinal(String.valueOf(clearText).getBytes(StandardCharsets.UTF_8)), Base64.DEFAULT);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return String.valueOf(clearText);
            }

            /**
             * 解密
             *
             * @param encryptedPwd
             * @return
             */
            public static String decryptPassword(Object encryptedPwd, Object password) {
                try {
                    DESKeySpec keySpec = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                        keySpec = new DESKeySpec(String.valueOf(password).getBytes(StandardCharsets.UTF_8));
                    }
                    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
                    SecretKey key = keyFactory.generateSecret(keySpec);

                    byte[] encryptedWithoutB64 = Base64.decode(String.valueOf(encryptedPwd), Base64.DEFAULT);
                    Cipher cipher = Cipher.getInstance("DES");
                    cipher.init(Cipher.DECRYPT_MODE, key);
                    byte[] plainTextPwdBytes = cipher.doFinal(encryptedWithoutB64);
                    return new String(plainTextPwdBytes);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return String.valueOf(encryptedPwd);
            }
        }


    }


    //=========================================== APP权限类 =========================================

    /**
     * APP 权限管理 类
     */
    public static class AppAuthorityManagement {

        //android6.0之后要动态获取权限
        public static void readWritePermission(Activity activity) {
            final int REQUEST_EXTERNAL_STORAGE = 1;
            String[] PERMISSIONS_STORAGE = {
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE};

            try {
                //检测是否有写的权限
                int permission = ActivityCompat.checkSelfPermission(activity,
                        "android.permission.WRITE_EXTERNAL_STORAGE");
                if (permission != PackageManager.PERMISSION_GRANTED) {
                    if (getGT().getLogTf()) {
                        err(getLineInfo(), "读写获取权限失败");
                    }
                    // 没有写的权限，去申请写的权限，会弹出对话框
                    ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
                }
            } catch (Exception e) {
                if (getGT().getLogTf()) {
                    err(getLineInfo(), "读写获取权限报错");
                }
                e.printStackTrace();
            }
        }

    }


    //============================================= UI类 ===========================================

    /**
     * Android GT 动画
     * 动画后面加 F 的则表示 该动画 是假的动画 后面为 T 的则表示为 真动画
     */
    public static class GT_Animation {

        public GT_Animation() {
        }

        /**
         * @param x           初始 X 位置
         * @param toX         最终 X 位置
         * @param y           初始 Y 位置
         * @param toY         最终 Y 位置
         * @param time        动画持续时间
         * @param isSaveClose 是否保持动画结束时的最终状态
         * @param runCount    播放动画的次数 -1 表示无限循环
         * @param toAndFro    是否来回播放
         * @param view        给 View 添加动画
         * @return
         * @移动动画（假）
         */
        public GT_Animation translate_F(float x, float toX, float y, float toY, long time, boolean isSaveClose, int runCount, boolean toAndFro, View view) {
            Animation translateAnimation = new TranslateAnimation(x, toX, y, toY);
            translateAnimation.setDuration(time);                   //设置动画持续周期
            translateAnimation.setFillAfter(isSaveClose);           //设置动画结束之后的状态是否是动画的最终状态，true，表示是保持动画结束时的最终状态
            translateAnimation.setFillBefore(!isSaveClose);         //动画播放完后，视图是否会停留在动画开始的状态，默认为true
            if (runCount == -1) {
                translateAnimation.setRepeatCount(Animation.INFINITE);  //播放无限次数
            } else {
                translateAnimation.setRepeatCount(runCount);            //播放的次数
            }
            if (toAndFro) translateAnimation.setRepeatMode(Animation.RESTART);       //是否来回的播放
            view.startAnimation(translateAnimation);                //开始播放
            return this;
        }

        /**
         * @param x           初始 X 位置
         * @param toX         最终 X 位置
         * @param y           初始 Y 位置
         * @param toY         最终 Y 位置
         * @param time        动画持续时间
         * @param isSaveClose 是否保持动画结束时的最终状态
         * @param runCount    播放动画的次数 -1 表示为无限次数
         * @param toAndFro    是否来回播放
         * @return
         * @移动item动画（假）
         */
        public Animation translat_Item_F(float x, float toX, float y, float toY, long time, boolean isSaveClose, int runCount, boolean toAndFro) {
            Animation translateAnimation = new TranslateAnimation(x, toX, y, toY);
            translateAnimation.setDuration(time);               //设置动画持续周期
            translateAnimation.setFillAfter(isSaveClose);       //设置动画结束之后的状态是否是动画的最终状态，true，表示是保持动画结束时的最终状态
            translateAnimation.setFillBefore(!isSaveClose);     // 动画播放完后，视图是否会停留在动画开始的状态，默认为true
            if (runCount == -1) {
                translateAnimation.setRepeatCount(Animation.INFINITE);  //播放无限次数
            } else {
                translateAnimation.setRepeatCount(runCount);            //播放的次数
            }
            if (toAndFro) translateAnimation.setRepeatMode(Animation.RESTART);   //是否来回的播放
            return translateAnimation;
        }

        /**
         * @param x        初始 X 位置
         * @param toX      最终 X 位置
         * @param time     执行动画时间
         * @param runCount 执行动画次数
         * @param toAndFro 是否来回播放
         * @param view     给View加入动画
         * @return
         * @左右动画（真）
         */
        public GT_Animation translateX_T(float x, float toX, long time, int runCount, boolean toAndFro, View view) {
            ObjectAnimator translateX = ObjectAnimator.ofFloat(view, "translationX", x, toX);
            translateX.setDuration(time);      //动画执行时间
            if (runCount == -1) {
                translateX.setRepeatCount(ValueAnimator.INFINITE);//无限循环
            } else {
                translateX.setRepeatCount(runCount);//循环多少次
            }
            if (toAndFro) translateX.setRepeatMode(ValueAnimator.REVERSE);//是否来回播放
            translateX.start();//执行动画
            return this;
        }

        /**
         * @param x        初始 X 位置
         * @param toX      最终 X 位置
         * @param time     执行动画时间
         * @param runCount 执行动画次数
         * @param toAndFro 是否来回播放
         * @param view     给View加入动画
         * @return
         * @左右item动画（真）
         */
        public ObjectAnimator translateX_Item_T(float x, float toX, long time, int runCount, boolean toAndFro, View view) {
            ObjectAnimator translateX = ObjectAnimator.ofFloat(view, "translationX", x, toX);
            translateX.setDuration(time);      //动画执行时间
            if (runCount == -1) {
                translateX.setRepeatCount(ValueAnimator.INFINITE);//无限循环
            } else {
                translateX.setRepeatCount(runCount);//循环多少次
            }
            if (toAndFro) translateX.setRepeatMode(ValueAnimator.REVERSE);//是否来回播放
            return translateX;
        }

        /**
         * @param y        初始 Y 位置
         * @param toY      最终 Y 位置
         * @param time     执行动画时间
         * @param runCount 执行动画次数
         * @param toAndFro 是否来回播放
         * @param view     给View加入动画
         * @return
         * @上下动画（真）
         */
        public GT_Animation translateY_T(float y, float toY, long time, int runCount, boolean toAndFro, View view) {
            ObjectAnimator translateY = ObjectAnimator.ofFloat(view, "translationY", y, toY);
            translateY.setDuration(time);      //动画执行时间
            if (runCount == -1) {
                translateY.setRepeatCount(ValueAnimator.INFINITE);//无限循环
            } else {
                translateY.setRepeatCount(runCount);//循环多少次
            }
            if (toAndFro) translateY.setRepeatMode(ValueAnimator.REVERSE);//是否来回播放
            translateY.start();//执行动画
            return this;
        }

        /**
         * @param y        初始 Y 位置
         * @param toY      最终 Y 位置
         * @param time     执行动画时间
         * @param runCount 执行动画次数
         * @param toAndFro 是否来回播放
         * @param view     给View加入动画
         * @return
         * @上下item动画（真）
         */
        public ObjectAnimator translateY_Item_T(float y, float toY, long time, int runCount, boolean toAndFro, View view) {
            ObjectAnimator translateY = ObjectAnimator.ofFloat(view, "translationY", y, toY);
            translateY.setDuration(time);      //动画执行时间
            if (runCount == -1) {
                translateY.setRepeatCount(ValueAnimator.INFINITE);//无限循环
            } else {
                translateY.setRepeatCount(runCount);//循环多少次
            }
            if (toAndFro) translateY.setRepeatMode(ValueAnimator.REVERSE);//是否来回播放
            return translateY;
        }

        /**
         * @param x        初始 X 坐标
         * @param toX      最终 X 坐标
         * @param y        初始 Y 坐标
         * @param toY      最终 Y 坐标
         * @param time     消耗时间
         * @param runCount 执行次数
         * @param toAndFro 是否来回播放
         * @param view     动画的View
         * @return
         * @平移动画（真）
         */
        public GT_Animation translate_T(float x, float toX, float y, float toY, long time, int runCount, boolean toAndFro, View view) {

            AnimatorSet animatorSet = new AnimatorSet();

            ObjectAnimator translationX = ObjectAnimator.ofFloat(view, "translationX", x, toX);
            ObjectAnimator translationY = ObjectAnimator.ofFloat(view, "translationY", y, toY);

            //设置动画时间
            translationX.setDuration(time);
            translationY.setDuration(time);

            if (runCount == -1) {
                translationX.setRepeatCount(ValueAnimator.INFINITE);//无限循环
                translationY.setRepeatCount(ValueAnimator.INFINITE);//无限循环
            } else {
                translationX.setRepeatCount(runCount);//循环多少次
                translationY.setRepeatCount(runCount);//循环多少次
            }

            //设置动画是否来回播放
            if (toAndFro) {
                translationX.setRepeatMode(ObjectAnimator.REVERSE);
                translationY.setRepeatMode(ObjectAnimator.REVERSE);
            }

            animatorSet.play(translationX).with(translationY);
            animatorSet.start();

            return this;
        }

        /**
         * @param x        初始 X 坐标
         * @param toX      最终 X 坐标
         * @param y        初始 Y 坐标
         * @param toY      最终 Y 坐标
         * @param time     消耗时间
         * @param runCount 执行次数
         * @param toAndFro 是否来回播放
         * @param view     动画的View
         * @return
         * @平移item动画（真）
         */
        public AnimatorSet translate_Item_T(float x, float toX, float y, float toY, long time, int runCount, boolean toAndFro, View view) {

            AnimatorSet animatorSet = new AnimatorSet();

            ObjectAnimator translationX = ObjectAnimator.ofFloat(view, "translationX", x, toX);
            ObjectAnimator translationY = ObjectAnimator.ofFloat(view, "translationY", y, toY).setDuration(time);

            //设置动画时间
            translationX.setDuration(time);
            translationY.setDuration(time);

            if (runCount == -1) {
                translationX.setRepeatCount(ValueAnimator.INFINITE);//无限循环
                translationY.setRepeatCount(ValueAnimator.INFINITE);//无限循环
            } else {
                translationX.setRepeatCount(runCount);//循环多少次
                translationY.setRepeatCount(runCount);//循环多少次
            }

            //设置动画是否来回播放
            if (toAndFro) {
                translationX.setRepeatMode(ObjectAnimator.REVERSE);
                translationY.setRepeatMode(ObjectAnimator.REVERSE);
            }

            animatorSet.play(translationX).with(translationY);

            return animatorSet;
        }


        /**
         * @param x           原始 X 尺寸
         * @param toX         结束 X 尺寸
         * @param y           原始 Y 尺寸
         * @param toY         结束 Y 尺寸
         * @param time        动画持续时间
         * @param isSaveClose 是否保持动画结束时的最终状态
         * @param runCount    播放动画的次数 -1 表示无限次数
         * @param toAndFro    是否来回播放
         * @param view        给 View 添加动画
         * @return
         * @缩放动画（假）
         */
        public GT_Animation scale_F(float x, float toX, float y, float toY, long time, boolean isSaveClose, int runCount, boolean toAndFro, View view) {
            Animation scaleAnimation = new ScaleAnimation(x, toX, y, toY, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            scaleAnimation.setDuration(time);                   //动画时间
            scaleAnimation.setFillAfter(isSaveClose);           //设置动画结束之后的状态是否是动画的最终状态，true，表示是保持动画结束时的最终状态
            scaleAnimation.setFillBefore(!isSaveClose);         //动画播放完后，视图是否会停留在动画开始的状态，默认为true
            if (runCount == -1) {
                scaleAnimation.setRepeatCount(Animation.INFINITE);  //播放无限次数
            } else {
                scaleAnimation.setRepeatCount(runCount);            //播放的次数
            }
            if (toAndFro) scaleAnimation.setRepeatMode(Animation.RESTART);       //是否来回的播放
            view.startAnimation(scaleAnimation);                //开始播放
            return this;
        }

        /**
         * @param x           原始 X 尺寸
         * @param toX         结束 X 尺寸
         * @param y           原始 Y 尺寸
         * @param toY         结束 Y 尺寸
         * @param time        动画持续时间
         * @param isSaveClose 是否保持动画结束时的最终状态
         * @param runCount    播放动画的次数 -1 表示无限次数
         * @param toAndFro    是否来回播放
         * @return
         * @缩放item动画（假）
         */
        public Animation scales_F(float x, float toX, float y, float toY, long time, boolean isSaveClose, int runCount, boolean toAndFro) {
            Animation scaleAnimation = new ScaleAnimation(x, toX, y, toY, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            scaleAnimation.setDuration(time);                   //动画时间
            scaleAnimation.setFillAfter(isSaveClose);           //设置动画结束之后的状态是否是动画的最终状态，true，表示是保持动画结束时的最终状态
            scaleAnimation.setFillBefore(!isSaveClose);         //动画播放完后，视图是否会停留在动画开始的状态，默认为true
            if (runCount == -1) {
                scaleAnimation.setRepeatCount(Animation.INFINITE);  //播放无限次数
            } else {
                scaleAnimation.setRepeatCount(runCount);            //播放的次数
            }
            if (toAndFro) scaleAnimation.setRepeatMode(Animation.RESTART);       //是否来回的播放
            return scaleAnimation;
        }

        /**
         * @param x           原始 X 尺寸
         * @param toX         结束 X 尺寸
         * @param time        动画持续时间
         * @param isSaveClose 是否保持动画结束时的最终状态
         * @param runCount    播放动画的次数 -1 表示无限次数
         * @param toAndFro    是否来回播放
         * @param view        给 View 添加动画
         * @return
         * @缩放动画（真）
         */
        public GT_Animation scaleX_T(float x, float toX, long time, boolean isSaveClose, int runCount, boolean toAndFro, View view) {
            ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", x, toX);
            scaleX.setDuration(time);      //动画执行时间
            if (runCount == -1) {
                scaleX.setRepeatCount(ValueAnimator.INFINITE);//无限循环
            } else {
                scaleX.setRepeatCount(runCount);//循环多少次
            }
            if (toAndFro) scaleX.setRepeatMode(ValueAnimator.REVERSE);//是否来回播放
            scaleX.start();//执行动画
            return this;
        }

        /**
         * @param x           原始 X 尺寸
         * @param toX         结束 X 尺寸
         * @param time        动画持续时间
         * @param isSaveClose 是否保持动画结束时的最终状态
         * @param runCount    播放动画的次数 -1 表示无限次数
         * @param toAndFro    是否来回播放
         * @param view        给 View 添加动画
         * @return
         * @缩放item动画（真）
         */
        public ObjectAnimator scaleX_item_T(float x, float toX, long time, boolean isSaveClose, int runCount, boolean toAndFro, View view) {
            ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", x, toX);
            scaleX.setDuration(time);      //动画执行时间
            if (runCount == -1) {
                scaleX.setRepeatCount(ValueAnimator.INFINITE);//无限循环
            } else {
                scaleX.setRepeatCount(runCount);//循环多少次
            }
            if (toAndFro) scaleX.setRepeatMode(ValueAnimator.REVERSE);//是否来回播放
            return scaleX;
        }

        /**
         * @param y           原始 Y 尺寸
         * @param toY         结束 Y 尺寸
         * @param time        动画持续时间
         * @param isSaveClose 是否保持动画结束时的最终状态
         * @param runCount    播放动画的次数 -1 表示无限次数
         * @param toAndFro    是否来回播放
         * @param view        给 View 添加动画
         * @return
         * @缩放动画（真）
         */
        public GT_Animation scaleY_T(float y, float toY, long time, boolean isSaveClose, int runCount, boolean toAndFro, View view) {
            ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", y, toY);
            scaleY.setDuration(time);      //动画执行时间
            if (runCount == -1) {
                scaleY.setRepeatCount(ValueAnimator.INFINITE);//无限循环
            } else {
                scaleY.setRepeatCount(runCount);//循环多少次
            }
            if (toAndFro) scaleY.setRepeatMode(ValueAnimator.REVERSE);//是否来回播放
            scaleY.start();//执行动画
            return this;
        }

        /**
         * @param y           原始 Y 尺寸
         * @param toY         结束 Y 尺寸
         * @param time        动画持续时间
         * @param isSaveClose 是否保持动画结束时的最终状态
         * @param runCount    播放动画的次数 -1 表示无限次数
         * @param toAndFro    是否来回播放
         * @param view        给 View 添加动画
         * @return
         * @缩放item动画（真）
         */
        public ObjectAnimator scaleY_item_T(float y, float toY, long time, boolean isSaveClose, int runCount, boolean toAndFro, View view) {
            ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", y, toY);
            scaleY.setDuration(time);      //动画执行时间
            if (runCount == -1) {
                scaleY.setRepeatCount(ValueAnimator.INFINITE);//无限循环
            } else {
                scaleY.setRepeatCount(runCount);//循环多少次
            }
            if (toAndFro) scaleY.setRepeatMode(ValueAnimator.REVERSE);//是否来回播放
            return scaleY;
        }

        /**
         * @param x        初始 X 坐标
         * @param toX      最终 X 坐标
         * @param y        初始 Y 坐标
         * @param toY      最终 Y 坐标
         * @param time     消耗时间
         * @param runCount 执行次数
         * @param toAndFro 是否来回播放
         * @param view     动画的View
         * @return
         * @缩放动画（真）
         */
        public GT_Animation scale_T(float x, float toX, float y, float toY, long time, int runCount, boolean toAndFro, View view) {

            AnimatorSet animatorSet = new AnimatorSet();

            ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", x, toX);
            ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", y, toY);

            //设置动画时间
            scaleX.setDuration(time);
            scaleY.setDuration(time);

            if (runCount == -1) {
                scaleX.setRepeatCount(ValueAnimator.INFINITE);//无限循环
                scaleY.setRepeatCount(ValueAnimator.INFINITE);//无限循环
            } else {
                scaleX.setRepeatCount(runCount);//循环多少次
                scaleY.setRepeatCount(runCount);//循环多少次
            }

            //设置动画是否来回播放
            if (toAndFro) {
                scaleX.setRepeatMode(ObjectAnimator.REVERSE);
                scaleY.setRepeatMode(ObjectAnimator.REVERSE);
            }

            animatorSet.play(scaleX).with(scaleY);
            animatorSet.start();

            return this;
        }

        /**
         * @param x        初始 X 坐标
         * @param toX      最终 X 坐标
         * @param y        初始 Y 坐标
         * @param toY      最终 Y 坐标
         * @param time     消耗时间
         * @param runCount 执行次数
         * @param toAndFro 是否来回播放
         * @param view     动画的View
         * @return
         * @缩放item动画（真）
         */
        public AnimatorSet scale_item_T(float x, float toX, float y, float toY, long time, int runCount, boolean toAndFro, View view) {

            AnimatorSet animatorSet = new AnimatorSet();

            ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", x, toX);
            ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", y, toY);

            //设置动画时间
            scaleX.setDuration(time);
            scaleY.setDuration(time);

            if (runCount == -1) {
                scaleX.setRepeatCount(ValueAnimator.INFINITE);//无限循环
                scaleY.setRepeatCount(ValueAnimator.INFINITE);//无限循环
            } else {
                scaleX.setRepeatCount(runCount);//循环多少次
                scaleY.setRepeatCount(runCount);//循环多少次
            }

            //设置动画是否来回播放
            if (toAndFro) {
                scaleX.setRepeatMode(ObjectAnimator.REVERSE);
                scaleY.setRepeatMode(ObjectAnimator.REVERSE);
            }

            animatorSet.play(scaleX).with(scaleY);

            return animatorSet;
        }


        /**
         * @param degrees     View初始角度
         * @param toDegrees   View旋转角度
         * @param time        动画执行时间
         * @param time        动画持续时间
         * @param isSaveClose 是否保持动画结束时的最终状态
         * @param runCount    播放动画的次数 -1 表示无限次数
         * @param toAndFro    是否来回播放
         * @param view        执行View动画
         * @return
         * @平面旋转动画（假）
         */
        public GT_Animation rotate_F(float degrees, float toDegrees, long time, boolean isSaveClose, int runCount, boolean toAndFro, View view) {
            Animation rotateAnimation = new RotateAnimation(degrees, toDegrees, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            rotateAnimation.setDuration(time);                   //动画时间
            rotateAnimation.setFillAfter(isSaveClose);           //设置动画结束之后的状态是否是动画的最终状态，true，表示是保持动画结束时的最终状态
            rotateAnimation.setFillBefore(!isSaveClose);         //动画播放完后，视图是否会停留在动画开始的状态，默认为true
            if (runCount == -1) {
                rotateAnimation.setRepeatCount(Animation.INFINITE);  //播放无限次数
            } else {
                rotateAnimation.setRepeatCount(runCount);            //播放的次数
            }
            if (toAndFro) rotateAnimation.setRepeatMode(Animation.RESTART);       //是否来回的播放
            view.startAnimation(rotateAnimation);                //开始播放
            return this;
        }

        /**
         * @param degrees     View初始角度
         * @param toDegrees   View旋转角度
         * @param time        动画执行时间
         * @param time        动画持续时间
         * @param isSaveClose 是否保持动画结束时的最终状态
         * @param runCount    播放动画的次数 -1 表示无限次数
         * @param toAndFro    是否来回播放
         * @return
         * @平面旋转item动画（假）
         */
        public Animation rotates_F(float degrees, float toDegrees, long time, boolean isSaveClose, int runCount, boolean toAndFro) {
            Animation rotateAnimation = new RotateAnimation(degrees, toDegrees, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            rotateAnimation.setDuration(time);                   //动画时间
            rotateAnimation.setFillAfter(isSaveClose);           //设置动画结束之后的状态是否是动画的最终状态，true，表示是保持动画结束时的最终状态
            rotateAnimation.setFillBefore(!isSaveClose);         //动画播放完后，视图是否会停留在动画开始的状态，默认为true
            if (runCount == -1) {
                rotateAnimation.setRepeatCount(Animation.INFINITE);  //播放无限次数
            } else {
                rotateAnimation.setRepeatCount(runCount);            //播放的次数
            }
            if (toAndFro) rotateAnimation.setRepeatMode(Animation.RESTART);       //是否来回的播放
            return rotateAnimation;
        }

        /**
         * @param x        初始化 X 坐标
         * @param toX      最终的 X 坐标
         * @param time     动画耗时
         * @param runCount 动画播放次数
         * @param toAndFro 是否来回播放
         * @param view     要使用动画的View
         * @return
         * @旋转动画X（真）
         */
        public GT_Animation rotatesX_T(float x, float toX, long time, int runCount, boolean toAndFro, View view) {
            ObjectAnimator rotationX = ObjectAnimator.ofFloat(view, "rotationX", x, toX);

            rotationX.setDuration(time);//设置时间

            if (runCount == -1) {
                rotationX.setRepeatCount(ValueAnimator.INFINITE);//无限循环
            } else {
                rotationX.setRepeatCount(runCount);//循环多少次
            }

            //设置动画是否来回播放
            if (toAndFro) {
                rotationX.setRepeatMode(ObjectAnimator.REVERSE);
            }

            rotationX.start();//开启动画
            return this;
        }

        /**
         * @param x        初始化 X 坐标
         * @param toX      最终的 X 坐标
         * @param time     动画耗时
         * @param runCount 动画播放次数
         * @param toAndFro 是否来回播放
         * @param view     要使用动画的View
         * @return
         * @旋转item动画X（真）
         */
        public ObjectAnimator rotatesX_Item_T(float x, float toX, long time, int runCount, boolean toAndFro, View view) {
            ObjectAnimator rotationX = ObjectAnimator.ofFloat(view, "rotationX", x, toX);

            rotationX.setDuration(time);//设置时间

            if (runCount == -1) {
                rotationX.setRepeatCount(ValueAnimator.INFINITE);//无限循环
            } else {
                rotationX.setRepeatCount(runCount);//循环多少次
            }

            //设置动画是否来回播放
            if (toAndFro) {
                rotationX.setRepeatMode(ObjectAnimator.REVERSE);
            }

            rotationX.start();//开启动画
            return rotationX;
        }

        /**
         * @param y        初始化 Y 坐标
         * @param toY      最终的 Y 坐标
         * @param time     动画耗时
         * @param runCount 动画播放次数
         * @param toAndFro 是否来回播放
         * @param view     要使用动画的View
         * @return
         * @旋转动画Y（真）
         */
        public GT_Animation rotatesY_T(float y, float toY, long time, int runCount, boolean toAndFro, View view) {
            ObjectAnimator rotationY = ObjectAnimator.ofFloat(view, "rotationY", y, toY);

            rotationY.setDuration(time);//设置时间

            if (runCount == -1) {
                rotationY.setRepeatCount(ValueAnimator.INFINITE);//无限循环
            } else {
                rotationY.setRepeatCount(runCount);//循环多少次
            }

            //设置动画是否来回播放
            if (toAndFro) {
                rotationY.setRepeatMode(ObjectAnimator.REVERSE);
            }

            rotationY.start();//开启动画
            return this;
        }

        /**
         * @param y        初始化 Y 坐标
         * @param toY      最终的 Y 坐标
         * @param time     动画耗时
         * @param runCount 动画播放次数
         * @param toAndFro 是否来回播放
         * @param view     要使用动画的View
         * @return
         * @旋转item动画Y（真）
         */
        public ObjectAnimator rotatesY_Item_T(float y, float toY, long time, int runCount, boolean toAndFro, View view) {
            ObjectAnimator rotationY = ObjectAnimator.ofFloat(view, "rotationY", y, toY);

            rotationY.setDuration(time);//设置时间

            if (runCount == -1) {
                rotationY.setRepeatCount(ValueAnimator.INFINITE);//无限循环
            } else {
                rotationY.setRepeatCount(runCount);//循环多少次
            }

            //设置动画是否来回播放
            if (toAndFro) {
                rotationY.setRepeatMode(ObjectAnimator.REVERSE);
            }

            return rotationY;
        }

        /**
         * @param z        初始化 Z 坐标
         * @param toZ      最终的 Z 坐标
         * @param time     动画耗时
         * @param runCount 动画播放次数
         * @param toAndFro 是否来回播放
         * @param view     要使用动画的View
         * @return
         * @旋转动画Z（真）
         */
        public GT_Animation rotatesZ_T(float z, float toZ, long time, int runCount, boolean toAndFro, View view) {
            ObjectAnimator rotationZ = ObjectAnimator.ofFloat(view, "rotation", z, toZ);

            rotationZ.setDuration(time);//设置时间

            if (runCount == -1) {
                rotationZ.setRepeatCount(ValueAnimator.INFINITE);//无限循环
            } else {
                rotationZ.setRepeatCount(runCount);//循环多少次
            }

            //设置动画是否来回播放
            if (toAndFro) {
                rotationZ.setRepeatMode(ObjectAnimator.REVERSE);
            }

            rotationZ.start();//开启动画
            return this;
        }

        /**
         * @param z        初始化 Z 坐标
         * @param toZ      最终的 Z 坐标
         * @param time     动画耗时
         * @param runCount 动画播放次数
         * @param toAndFro 是否来回播放
         * @param view     要使用动画的View
         * @return
         * @旋转item动画Z（真）
         */
        public ObjectAnimator rotatesZ_item_T(float z, float toZ, long time, int runCount, boolean toAndFro, View view) {
            ObjectAnimator rotationZ = ObjectAnimator.ofFloat(view, "rotation", z, toZ);

            rotationZ.setDuration(time);//设置时间

            if (runCount == -1) {
                rotationZ.setRepeatCount(ValueAnimator.INFINITE);//无限循环
            } else {
                rotationZ.setRepeatCount(runCount);//循环多少次
            }

            //设置动画是否来回播放
            if (toAndFro) {
                rotationZ.setRepeatMode(ObjectAnimator.REVERSE);
            }
            return rotationZ;
        }


        /**
         * @param alpha       初始透明度
         * @param toAlpha     最终透明度
         * @param time        动画执行时间
         * @param isSaveClose 是否保持动画结束时的最终状态
         * @param runCount    播放动画的次数 -1 表示无限次数
         * @param toAndFro    是否来回播放
         * @param view        执行View动画
         * @return
         * @透明动画（假）
         */
        public GT_Animation alpha_F(float alpha, float toAlpha, long time, boolean isSaveClose, int runCount, boolean toAndFro, View view) {
            Animation alphaAnimation = new AlphaAnimation(alpha, toAlpha);
            alphaAnimation.setDuration(time);                   //动画时间
            alphaAnimation.setFillAfter(isSaveClose);           //设置动画结束之后的状态是否是动画的最终状态，true，表示是保持动画结束时的最终状态
            alphaAnimation.setFillBefore(!isSaveClose);         //动画播放完后，视图是否会停留在动画开始的状态，默认为true
            if (runCount == -1) {
                alphaAnimation.setRepeatCount(Animation.INFINITE);  //播放无限次数
            } else {
                alphaAnimation.setRepeatCount(runCount);            //播放的次数
            }
            if (toAndFro) alphaAnimation.setRepeatMode(Animation.RESTART);       //是否来回的播放
            view.startAnimation(alphaAnimation);                //开启动画
            return this;
        }

        /**
         * @param alpha       初始透明度
         * @param toAlpha     最终透明度
         * @param time        动画执行时间
         * @param isSaveClose 是否保持动画结束时的最终状态
         * @param runCount    播放动画的次数 -1 表示无限次数
         * @param toAndFro    是否来回播放
         * @return
         * @透明item动画（假）
         */
        public Animation alphas_F(float alpha, float toAlpha, long time, boolean isSaveClose, int runCount, boolean toAndFro) {
            Animation alphaAnimation = new AlphaAnimation(alpha, toAlpha);
            alphaAnimation.setDuration(time);                   //动画时间
            alphaAnimation.setFillAfter(isSaveClose);           //设置动画结束之后的状态是否是动画的最终状态，true，表示是保持动画结束时的最终状态
            alphaAnimation.setFillBefore(!isSaveClose);         //动画播放完后，视图是否会停留在动画开始的状态，默认为true
            if (runCount == -1) {
                alphaAnimation.setRepeatCount(Animation.INFINITE);  //播放无限次数
            } else {
                alphaAnimation.setRepeatCount(runCount);            //播放的次数
            }
            if (toAndFro) alphaAnimation.setRepeatMode(Animation.RESTART);       //是否来回的播放
            return alphaAnimation;
        }

        /**
         * @param alpha    初始透明度
         * @param toAlpha  最终透明度
         * @param time     动画执行时间
         * @param runCount 播放动画的次数 -1 表示无限次数
         * @param toAndFro 是否来回播放
         * @return
         * @透明动画（真）
         */
        public GT_Animation alpha_T(float alpha, float toAlpha, long time, int runCount, boolean toAndFro, View view) {
            ObjectAnimator rotationX = ObjectAnimator.ofFloat(view, "alpha", alpha, toAlpha);

            rotationX.setDuration(time);//设置时间

            if (runCount == -1) {
                rotationX.setRepeatCount(ValueAnimator.INFINITE);//无限循环
            } else {
                rotationX.setRepeatCount(runCount);//循环多少次
            }

            //设置动画是否来回播放
            if (toAndFro) {
                rotationX.setRepeatMode(ObjectAnimator.REVERSE);
            }

            rotationX.start();//开启动画
            return this;
        }

        /**
         * @param alpha    初始透明度
         * @param toAlpha  最终透明度
         * @param time     动画执行时间
         * @param runCount 播放动画的次数 -1 表示无限次数
         * @param toAndFro 是否来回播放
         * @return
         * @透明item动画（真）
         */
        public ObjectAnimator alpha_item_T(float alpha, float toAlpha, long time, int runCount, boolean toAndFro, View view) {
            ObjectAnimator rotationX = ObjectAnimator.ofFloat(view, "alpha", alpha, toAlpha);

            rotationX.setDuration(time);//设置时间

            if (runCount == -1) {
                rotationX.setRepeatCount(ValueAnimator.INFINITE);//无限循环
            } else {
                rotationX.setRepeatCount(runCount);//循环多少次
            }

            //设置动画是否来回播放
            if (toAndFro) {
                rotationX.setRepeatMode(ObjectAnimator.REVERSE);
            }

            return rotationX;
        }


        /**
         * @param annotationList
         * @param view
         * @return
         * @添加组合动画（假）
         */
        public GT_Animation animationSet_F(List<Animation> annotationList, View view) {
            AnimationSet animationSet = new AnimationSet(true);
            if (annotationList != null && annotationList.size() > 1) {
                for (Animation animation : annotationList) {
                    animationSet.addAnimation(animation);
                }
            }
            view.startAnimation(animationSet);//开启组合动画
            return this;
        }

        /**
         * @param annotationList
         * @return
         * @添加组合item动画（假）
         */
        public AnimationSet animationSets_F(List<Animation> annotationList) {
            AnimationSet animationSet = new AnimationSet(true);
            if (annotationList != null && annotationList.size() > 1) {
                for (Animation animation : annotationList) {
                    animationSet.addAnimation(animation);
                }
            }
            return animationSet;
        }

    }

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

            /**
             * 构建 GT 工具包
             *
             * @param object
             * @param view
             */
            protected void build(Object object, View view) {
                GT.getGT().build(object, view);
            }

            /**
             * 跳转 Activity
             *
             * @param activityClass
             */
            protected void startActivity(Class activityClass) {
                GT.startAct(activityClass);
            }

            /**
             * 普通日志
             *
             * @param object
             */
            protected void log(Object object) {
                GT.log(object);
            }

            /**
             * 带 TAG 的普通日志
             *
             * @param tag
             * @param object
             */
            protected void log(Object tag, Object object) {
                GT.log(tag, object);
            }

            /**
             * 错误日志
             *
             * @param object
             */
            protected void err(Object object) {
                GT.err(object);
            }

            /**
             * 带 TAG 的错误日志
             *
             * @param tag
             * @param object
             */
            protected void err(Object tag, Object object) {
                GT.err(tag, object);
            }

            /**
             * 普通的 Toast
             *
             * @param object
             */
            protected void toast(Object object) {
                GT.toast_s(object);
            }

            /**
             * 带 Context 的 Toast
             *
             * @param context
             * @param object
             */
            protected void toast(Context context, Object object) {
                GT.toast_s(context, object);
            }

            /**
             * 带 延时的 的 Toast
             *
             * @param time
             * @param object
             */
            protected void toast(long time, Object object) {
                GT.toast_time(object, time);
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

            /**
             * 构建 GT 工具包
             *
             * @param object
             * @param view
             */
            protected void build(Object object, View view) {
                GT.getGT().build(object, view);
            }

            /**
             * 跳转 Activity
             *
             * @param activityClass
             */
            protected void startActivity(Class activityClass) {
                GT.startAct(activityClass);
            }

            /**
             * 普通日志
             *
             * @param object
             */
            protected void log(Object object) {
                GT.log(object);
            }

            /**
             * 带 TAG 的普通日志
             *
             * @param tag
             * @param object
             */
            protected void log(Object tag, Object object) {
                GT.log(tag, object);
            }

            /**
             * 错误日志
             *
             * @param object
             */
            protected void err(Object object) {
                GT.err(object);
            }

            /**
             * 带 TAG 的错误日志
             *
             * @param tag
             * @param object
             */
            protected void err(Object tag, Object object) {
                GT.err(tag, object);
            }

            /**
             * 普通的 Toast
             *
             * @param object
             */
            protected void toast(Object object) {
                GT.toast_s(object);
            }

            /**
             * 带 Context 的 Toast
             *
             * @param context
             * @param object
             */
            protected void toast(Context context, Object object) {
                GT.toast_s(context, object);
            }

            /**
             * 带 延时的 的 Toast
             *
             * @param time
             * @param object
             */
            protected void toast(long time, Object object) {
                GT.toast_time(object, time);
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
        private static Map<String, Object> mapSQL;      //用于存储 Fragment 之间数据传递的 Map

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
                    GT.log(getLineInfo(), "实例化 GT_Fragment 时， activity 或 FragmentManager 为 null");
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
                        GT.log(getLineInfo(), "初始化 GT_Fragment 时， map 或 FragmentManager 为 null 或 map.size < 1");
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
                        GT.log(getLineInfo(), "初始化 GT_Fragment 时， fragment 为 null 或 fragmentLayoutId = 0");
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
                        GT.log(getLineInfo(), "初始化 GT_Fragment 时， map 或 FragmentManager 为 null 或 map.size < 1");
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
                        GT.log(getLineInfo(), "添加 addFragment 时， key 在 fragmentMap 中存在相同的 Key");
                    }
                }
            } else {
                if (GT_LOG_TF) {
                    GT.log(getLineInfo(), "添加 addFragment 时， key 或 FragmentManager 或 NewFragment 为 null");
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
                        GT.log(getLineInfo(), "添加 addFragment 时， key 在 fragmentMap 中存在相同的 Key");
                    }
                }
            } else {
                if (GT_LOG_TF) {
                    GT.log(getLineInfo(), "添加 addFragment 时， key 或 FragmentManager 或 NewFragment 为 null");
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
                        GT.log(getLineInfo(), "切换 Fragment 时， 当前要切换的 Fragment:【" + key + "】 不在容器中。");
                    }
                }
            } else {
                if (GT_LOG_TF) {
                    GT.log(getLineInfo(), "切换 Fragment 时， fm 为 null 获取 当前切换的 Fragment 已在最顶层无需切换");
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
                    GT.log(getLineInfo(), "切换新的 Fragment 时 NewFragment 为 null");
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
                    GT.log(getLineInfo(), "退回栈bug：fm、topList为 null 或 topListSize == 0");
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
                    GT.log(getLineInfo(), "fm 管理器为 null");
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
                    err(getLineInfo(), "FragmentSQL 报错：添加 数据时 已存在当前 key 建议调用 update 方法进行修改");
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
                    err(getLineInfo(), "FragmentSQL 报错：删除 数据时 当前 key 不存在，无法进行删除");
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
                    err(getLineInfo(), "FragmentSQL 报错：查询 数据时 当前 key 不存在，无法进行查询");
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
                    err(getLineInfo(), "FragmentSQL 报错：修改 数据时 当前 key 不存在，无法进行修改");
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
    public abstract static class BaseActivity extends AppCompatActivity {

        /**
         * 初始化 加载布局
         */
        protected abstract int initLayout(Bundle savedInstanceState);

        /**
         * 在绘制完 View 之前设置数据
         */
        protected void initDrawView() {
        }

        /**
         * 初始化 UI
         */
        protected abstract void initView();

        /**
         * 功能方法
         */
        protected void function() {
        }

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
         *
         * @param context
         */
        protected void build(Context context) {
            GT.getGT().build(context);
        }

        /**
         * 跳转 Activity
         *
         * @param activityClass
         */
        protected void startActivity(Class activityClass) {
            GT.startAct(activityClass);
        }

        /**
         * 普通日志
         *
         * @param object
         */
        protected void log(Object object) {
            GT.log(object);
        }

        /**
         * 带 TAG 的普通日志
         *
         * @param tag
         * @param object
         */
        protected void log(Object tag, Object object) {
            GT.log(tag, object);
        }

        /**
         * 错误日志
         *
         * @param object
         */
        protected void err(Object object) {
            GT.err(object);
        }

        /**
         * 带 TAG 的错误日志
         *
         * @param tag
         * @param object
         */
        protected void err(Object tag, Object object) {
            GT.err(tag, object);
        }

        /**
         * 普通的 Toast
         *
         * @param object
         */
        protected void toast(Object object) {
            GT.toast_s(object);
        }

        /**
         * 带 Context 的 Toast
         *
         * @param context
         * @param object
         */
        protected void toast(Context context, Object object) {
            GT.toast_s(context, object);
        }

        /**
         * 带 延时的 的 Toast
         *
         * @param time
         * @param object
         */
        protected void toast(long time, Object object) {
            GT.toast_time(object, time);
        }


    }

    /**
     * 封装注解的 Activity 管理器
     */
    public abstract static class AnnotationActivity extends AppCompatActivity {

        /**
         * 在绘制完 View 之前设置数据
         */
        protected void initDrawView() {
        }

        /**
         * 初始化 UI
         */
        protected abstract void initView(Bundle savedInstanceState);

        /**
         * 功能方法
         */
        protected void function() {
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            initDrawView();//设置绘制前的数据
            initView(savedInstanceState);//初始化 UI
            function();//功能方法
        }

        /**
         * 构建 GT 工具包
         *
         * @param context
         */
        protected void build(Context context) {
            GT.getGT().build(context);
        }

        /**
         * 跳转 Activity
         *
         * @param activityClass
         */
        protected void startActivity(Class activityClass) {
            GT.startAct(activityClass);
        }

        /**
         * 普通日志
         *
         * @param object
         */
        protected void log(Object object) {
            GT.log(object);
        }

        /**
         * 带 TAG 的普通日志
         *
         * @param tag
         * @param object
         */
        protected void log(Object tag, Object object) {
            GT.log(tag, object);
        }

        /**
         * 错误日志
         *
         * @param object
         */
        protected void err(Object object) {
            GT.err(object);
        }

        /**
         * 带 TAG 的错误日志
         *
         * @param tag
         * @param object
         */
        protected void err(Object tag, Object object) {
            GT.err(tag, object);
        }

        /**
         * 普通的 Toast
         *
         * @param object
         */
        protected void toast(Object object) {
            GT.toast_s(object);
        }

        /**
         * 带 Context 的 Toast
         *
         * @param context
         * @param object
         */
        protected void toast(Context context, Object object) {
            GT.toast_s(context, object);
        }

        /**
         * 带 延时的 的 Toast
         *
         * @param time
         * @param object
         */
        protected void toast(long time, Object object) {
            GT.toast_time(object, time);
        }

    }


    //============================================= 游戏类 ======================================

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
                if (getGT().getGtLogTf())
                    GT.err(getLineInfo(), "请去掉调用该方法前面所有关于 沉浸式 关闭虚拟按钮 隐藏 ActionBar 等类似的代码");
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

        /**
         * 遥感控制
         * 使用教程请查看官网：https://github.com/1079374315/GT
         */
        public static class RockerView extends View {
            private static final int DEFAULT_SIZE = 400;
            private static final int DEFAULT_ROCKER_RADIUS = 50;
            private Paint mAreaBackgroundPaint;
            private Paint mRockerPaint;
            private Point mRockerPosition;
            private Point mCenterPoint;
            private int mAreaRadius;
            private int mRockerRadius;
            private RockerView.CallBackMode mCallBackMode;
            private RockerView.OnAngleChangeListener mOnAngleChangeListener;
            private RockerView.OnShakeListener mOnShakeListener;
            private RockerView.DirectionMode mDirectionMode;
            private RockerView.Direction tempDirection;
            private static final double ANGLE_0 = 0.0D;
            private static final double ANGLE_360 = 360.0D;
            private static final double ANGLE_HORIZONTAL_2D_OF_0P = 90.0D;
            private static final double ANGLE_HORIZONTAL_2D_OF_1P = 270.0D;
            private static final double ANGLE_VERTICAL_2D_OF_0P = 0.0D;
            private static final double ANGLE_VERTICAL_2D_OF_1P = 180.0D;
            private static final double ANGLE_4D_OF_0P = 0.0D;
            private static final double ANGLE_4D_OF_1P = 90.0D;
            private static final double ANGLE_4D_OF_2P = 180.0D;
            private static final double ANGLE_4D_OF_3P = 270.0D;
            private static final double ANGLE_ROTATE45_4D_OF_0P = 45.0D;
            private static final double ANGLE_ROTATE45_4D_OF_1P = 135.0D;
            private static final double ANGLE_ROTATE45_4D_OF_2P = 225.0D;
            private static final double ANGLE_ROTATE45_4D_OF_3P = 315.0D;
            private static final double ANGLE_8D_OF_0P = 22.5D;
            private static final double ANGLE_8D_OF_1P = 67.5D;
            private static final double ANGLE_8D_OF_2P = 112.5D;
            private static final double ANGLE_8D_OF_3P = 157.5D;
            private static final double ANGLE_8D_OF_4P = 202.5D;
            private static final double ANGLE_8D_OF_5P = 247.5D;
            private static final double ANGLE_8D_OF_6P = 292.5D;
            private static final double ANGLE_8D_OF_7P = 337.5D;
            private static final int AREA_BACKGROUND_MODE_PIC = 0;
            private static final int AREA_BACKGROUND_MODE_COLOR = 1;
            private static final int AREA_BACKGROUND_MODE_XML = 2;
            private static final int AREA_BACKGROUND_MODE_DEFAULT = 3;
            private int mAreaBackgroundMode;
            private Bitmap mAreaBitmap;
            private int mAreaColor;
            private static final int ROCKER_BACKGROUND_MODE_PIC = 4;
            private static final int ROCKER_BACKGROUND_MODE_COLOR = 5;
            private static final int ROCKER_BACKGROUND_MODE_XML = 6;
            private static final int ROCKER_BACKGROUND_MODE_DEFAULT = 7;
            private int mRockerBackgroundMode;
            private Bitmap mRockerBitmap;
            private int mRockerColor;

            public RockerView(Context context, AttributeSet attrs) {
                super(context, attrs);
                this.mCallBackMode = RockerView.CallBackMode.CALL_BACK_MODE_MOVE;
                this.tempDirection = RockerView.Direction.DIRECTION_CENTER;
                this.mAreaBackgroundMode = 3;
                this.mRockerBackgroundMode = 7;
                this.initAttribute(context, attrs);
                if (this.isInEditMode()) {
                    //            GT.log("RockerView", "RockerView: isInEditMode");
                }

                this.mAreaBackgroundPaint = new Paint();
                this.mAreaBackgroundPaint.setAntiAlias(true);
                this.mRockerPaint = new Paint();
                this.mRockerPaint.setAntiAlias(true);
                this.mCenterPoint = new Point();
                this.mRockerPosition = new Point();
            }

            private void initAttribute(Context context, AttributeSet attrs) {
                TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RockerView);
                Drawable areaBackground = typedArray.getDrawable(R.styleable.RockerView_areaBackground);
                if (null != areaBackground) {
                    if (areaBackground instanceof BitmapDrawable) {
                        this.mAreaBitmap = ((BitmapDrawable) areaBackground).getBitmap();
                        this.mAreaBackgroundMode = 0;
                    } else if (areaBackground instanceof GradientDrawable) {
                        this.mAreaBitmap = this.drawable2Bitmap(areaBackground);
                        this.mAreaBackgroundMode = 2;
                    } else if (areaBackground instanceof ColorDrawable) {
                        this.mAreaColor = ((ColorDrawable) areaBackground).getColor();
                        this.mAreaBackgroundMode = 1;
                    } else {
                        this.mAreaBackgroundMode = 3;
                    }
                } else {
                    this.mAreaBackgroundMode = 3;
                }

                Drawable rockerBackground = typedArray.getDrawable(R.styleable.RockerView_rockerBackground);
                if (null != rockerBackground) {
                    if (rockerBackground instanceof BitmapDrawable) {
                        this.mRockerBitmap = ((BitmapDrawable) rockerBackground).getBitmap();
                        this.mRockerBackgroundMode = 4;
                    } else if (rockerBackground instanceof GradientDrawable) {
                        this.mRockerBitmap = this.drawable2Bitmap(rockerBackground);
                        this.mRockerBackgroundMode = 6;
                    } else if (rockerBackground instanceof ColorDrawable) {
                        this.mRockerColor = ((ColorDrawable) rockerBackground).getColor();
                        this.mRockerBackgroundMode = 5;
                    } else {
                        this.mRockerBackgroundMode = 7;
                    }
                } else {
                    this.mRockerBackgroundMode = 7;
                }

                this.mRockerRadius = typedArray.getDimensionPixelOffset(R.styleable.RockerView_rockerRadius, 50);
                //        GT.log("RockerView", "initAttribute: mAreaBackground = " + areaBackground + "   mRockerBackground = " + rockerBackground + "  mRockerRadius = " + this.mRockerRadius);
                typedArray.recycle();
            }

            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                int widthMode = MeasureSpec.getMode(widthMeasureSpec);
                int heightMode = MeasureSpec.getMode(heightMeasureSpec);
                int widthSize = MeasureSpec.getSize(widthMeasureSpec);
                int heightSize = MeasureSpec.getSize(heightMeasureSpec);
                int measureWidth;
                if (widthMode == 1073741824) {
                    measureWidth = widthSize;
                } else {
                    measureWidth = 400;
                }

                int measureHeight;
                if (heightMode == 1073741824) {
                    measureHeight = heightSize;
                } else {
                    measureHeight = 400;
                }

            /*GT.log("RockerView", "onMeasure: --------------------------------------");
            GT.log("RockerView", "onMeasure: widthMeasureSpec = " + widthMeasureSpec + " heightMeasureSpec = " + heightMeasureSpec);
            GT.log("RockerView", "onMeasure: widthMode = " + widthMode + "  measureWidth = " + widthSize);
            GT.log("RockerView", "onMeasure: heightMode = " + heightMode + "  measureHeight = " + widthSize);
            GT.log("RockerView", "onMeasure: measureWidth = " + measureWidth + " measureHeight = " + measureHeight);*/
                this.setMeasuredDimension(measureWidth, measureHeight);
            }

            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                int measuredWidth = this.getMeasuredWidth();
                int measuredHeight = this.getMeasuredHeight();
                int cx = measuredWidth / 2;
                int cy = measuredHeight / 2;
                this.mCenterPoint.set(cx, cy);
                this.mAreaRadius = measuredWidth <= measuredHeight ? cx : cy;
                if (0 == this.mRockerPosition.x || 0 == this.mRockerPosition.y) {
                    this.mRockerPosition.set(this.mCenterPoint.x, this.mCenterPoint.y);
                }

                Rect src;
                Rect dst;
                if (0 != this.mAreaBackgroundMode && 2 != this.mAreaBackgroundMode) {
                    if (1 == this.mAreaBackgroundMode) {
                        this.mAreaBackgroundPaint.setColor(this.mAreaColor);
                        canvas.drawCircle((float) this.mCenterPoint.x, (float) this.mCenterPoint.y, (float) this.mAreaRadius, this.mAreaBackgroundPaint);
                    } else {
                        this.mAreaBackgroundPaint.setColor(-7829368);
                        canvas.drawCircle((float) this.mCenterPoint.x, (float) this.mCenterPoint.y, (float) this.mAreaRadius, this.mAreaBackgroundPaint);
                    }
                } else {
                    src = new Rect(0, 0, this.mAreaBitmap.getWidth(), this.mAreaBitmap.getHeight());
                    dst = new Rect(this.mCenterPoint.x - this.mAreaRadius, this.mCenterPoint.y - this.mAreaRadius, this.mCenterPoint.x + this.mAreaRadius, this.mCenterPoint.y + this.mAreaRadius);
                    canvas.drawBitmap(this.mAreaBitmap, src, dst, this.mAreaBackgroundPaint);
                }

                if (4 != this.mRockerBackgroundMode && 6 != this.mRockerBackgroundMode) {
                    if (5 == this.mRockerBackgroundMode) {
                        this.mRockerPaint.setColor(this.mRockerColor);
                        canvas.drawCircle((float) this.mRockerPosition.x, (float) this.mRockerPosition.y, (float) this.mRockerRadius, this.mRockerPaint);
                    } else {
                        this.mRockerPaint.setColor(-65536);
                        canvas.drawCircle((float) this.mRockerPosition.x, (float) this.mRockerPosition.y, (float) this.mRockerRadius, this.mRockerPaint);
                    }
                } else {
                    src = new Rect(0, 0, this.mRockerBitmap.getWidth(), this.mRockerBitmap.getHeight());
                    dst = new Rect(this.mRockerPosition.x - this.mRockerRadius, this.mRockerPosition.y - this.mRockerRadius, this.mRockerPosition.x + this.mRockerRadius, this.mRockerPosition.y + this.mRockerRadius);
                    canvas.drawBitmap(this.mRockerBitmap, src, dst, this.mRockerPaint);
                }

            }

            public boolean onTouchEvent(MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                        this.callBackStart();
                    case 2:
                        float moveX = event.getX();
                        float moveY = event.getY();
                        this.mRockerPosition = this.getRockerPositionPoint(this.mCenterPoint, new Point((int) moveX, (int) moveY), (float) this.mAreaRadius, (float) this.mRockerRadius);
                        this.moveRocker((float) this.mRockerPosition.x, (float) this.mRockerPosition.y);
                        break;
                    case 1:
                    case 3:
                        this.callBackFinish();
                        float upX = event.getX();
                        float upY = event.getY();
                        this.moveRocker((float) this.mCenterPoint.x, (float) this.mCenterPoint.y);
                        //                GT.log("RockerView", "onTouchEvent: 抬起位置 : x = " + upX + " y = " + upY);
                }

                return true;
            }

            private Point getRockerPositionPoint(Point centerPoint, Point touchPoint, float regionRadius, float rockerRadius) {
                float lenX = (float) (touchPoint.x - centerPoint.x);
                float lenY = (float) (touchPoint.y - centerPoint.y);
                float lenXY = (float) Math.sqrt((double) (lenX * lenX + lenY * lenY));
                double radian = Math.acos((double) (lenX / lenXY)) * (double) (touchPoint.y < centerPoint.y ? -1 : 1);
                double angle = this.radian2Angle(radian);
                this.callBack(angle);
                //        GT.log("RockerView", "getRockerPositionPoint: 角度 :" + angle);
                if (lenXY + rockerRadius <= regionRadius) {
                    return touchPoint;
                } else {
                    int showPointX = (int) ((double) centerPoint.x + (double) (regionRadius - rockerRadius) * Math.cos(radian));
                    int showPointY = (int) ((double) centerPoint.y + (double) (regionRadius - rockerRadius) * Math.sin(radian));
                    return new Point(showPointX, showPointY);
                }
            }

            private void moveRocker(float x, float y) {
                this.mRockerPosition.set((int) x, (int) y);
                //        GT.log("RockerView", "onTouchEvent: 移动位置 : x = " + this.mRockerPosition.x + " y = " + this.mRockerPosition.y);
                this.invalidate();
            }

            private double radian2Angle(double radian) {
                double tmp = (double) Math.round(radian / 3.141592653589793D * 180.0D);
                return tmp >= 0.0D ? tmp : 360.0D + tmp;
            }

            private Bitmap drawable2Bitmap(Drawable drawable) {
                int width = drawable.getIntrinsicWidth();
                int height = drawable.getIntrinsicHeight();
                @SuppressLint("WrongConstant") Bitmap.Config config = drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
                Bitmap bitmap = Bitmap.createBitmap(width, height, config);
                Canvas canvas = new Canvas(bitmap);
                drawable.setBounds(0, 0, width, height);
                drawable.draw(canvas);
                return bitmap;
            }

            private void callBackStart() {
                this.tempDirection = RockerView.Direction.DIRECTION_CENTER;
                if (null != this.mOnAngleChangeListener) {
                    this.mOnAngleChangeListener.onStart();
                }

                if (null != this.mOnShakeListener) {
                    this.mOnShakeListener.onStart();
                }

            }

            private void callBack(double angle) {
                if (null != this.mOnAngleChangeListener) {
                    this.mOnAngleChangeListener.angle(angle);
                }

                if (null != this.mOnShakeListener) {
                    if (RockerView.CallBackMode.CALL_BACK_MODE_MOVE == this.mCallBackMode) {
                        switch (this.mDirectionMode) {
                            case DIRECTION_2_HORIZONTAL:
                                if ((0.0D > angle || 90.0D <= angle) && (270.0D > angle || 360.0D <= angle)) {
                                    if (90.0D <= angle && 270.0D > angle) {
                                        this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_LEFT);
                                    }
                                } else {
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_RIGHT);
                                }
                                break;
                            case DIRECTION_2_VERTICAL:
                                if (0.0D <= angle && 180.0D > angle) {
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_DOWN);
                                } else if (180.0D <= angle && 360.0D > angle) {
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_UP);
                                }
                                break;
                            case DIRECTION_4_ROTATE_0:
                                if (0.0D <= angle && 90.0D > angle) {
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_DOWN_RIGHT);
                                } else if (90.0D <= angle && 180.0D > angle) {
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_DOWN_LEFT);
                                } else if (180.0D <= angle && 270.0D > angle) {
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_UP_LEFT);
                                } else if (270.0D <= angle && 360.0D > angle) {
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_UP_RIGHT);
                                }
                                break;
                            case DIRECTION_4_ROTATE_45:
                                if ((0.0D > angle || 45.0D <= angle) && (315.0D > angle || 360.0D <= angle)) {
                                    if (45.0D <= angle && 135.0D > angle) {
                                        this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_DOWN);
                                    } else if (135.0D <= angle && 225.0D > angle) {
                                        this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_LEFT);
                                    } else if (225.0D <= angle && 315.0D > angle) {
                                        this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_UP);
                                    }
                                } else {
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_RIGHT);
                                }
                                break;
                            case DIRECTION_8:
                                if ((0.0D > angle || 22.5D <= angle) && (337.5D > angle || 360.0D <= angle)) {
                                    if (22.5D <= angle && 67.5D > angle) {
                                        this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_DOWN_RIGHT);
                                    } else if (67.5D <= angle && 112.5D > angle) {
                                        this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_DOWN);
                                    } else if (112.5D <= angle && 157.5D > angle) {
                                        this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_DOWN_LEFT);
                                    } else if (157.5D <= angle && 202.5D > angle) {
                                        this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_LEFT);
                                    } else if (202.5D <= angle && 247.5D > angle) {
                                        this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_UP_LEFT);
                                    } else if (247.5D <= angle && 292.5D > angle) {
                                        this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_UP);
                                    } else if (292.5D <= angle && 337.5D > angle) {
                                        this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_UP_RIGHT);
                                    }
                                } else {
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_RIGHT);
                                }
                        }
                    } else if (RockerView.CallBackMode.CALL_BACK_MODE_STATE_CHANGE == this.mCallBackMode) {
                        switch (this.mDirectionMode) {
                            case DIRECTION_2_HORIZONTAL:
                                if ((0.0D <= angle && 90.0D > angle || 270.0D <= angle && 360.0D > angle) && this.tempDirection != RockerView.Direction.DIRECTION_RIGHT) {
                                    this.tempDirection = RockerView.Direction.DIRECTION_RIGHT;
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_RIGHT);
                                } else if (90.0D <= angle && 270.0D > angle && this.tempDirection != RockerView.Direction.DIRECTION_LEFT) {
                                    this.tempDirection = RockerView.Direction.DIRECTION_LEFT;
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_LEFT);
                                }
                                break;
                            case DIRECTION_2_VERTICAL:
                                if (0.0D <= angle && 180.0D > angle && this.tempDirection != RockerView.Direction.DIRECTION_DOWN) {
                                    this.tempDirection = RockerView.Direction.DIRECTION_DOWN;
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_DOWN);
                                } else if (180.0D <= angle && 360.0D > angle && this.tempDirection != RockerView.Direction.DIRECTION_UP) {
                                    this.tempDirection = RockerView.Direction.DIRECTION_UP;
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_UP);
                                }
                                break;
                            case DIRECTION_4_ROTATE_0:
                                if (0.0D <= angle && 90.0D > angle && this.tempDirection != RockerView.Direction.DIRECTION_DOWN_RIGHT) {
                                    this.tempDirection = RockerView.Direction.DIRECTION_DOWN_RIGHT;
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_DOWN_RIGHT);
                                } else if (90.0D <= angle && 180.0D > angle && this.tempDirection != RockerView.Direction.DIRECTION_DOWN_LEFT) {
                                    this.tempDirection = RockerView.Direction.DIRECTION_DOWN_LEFT;
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_DOWN_LEFT);
                                } else if (180.0D <= angle && 270.0D > angle && this.tempDirection != RockerView.Direction.DIRECTION_UP_LEFT) {
                                    this.tempDirection = RockerView.Direction.DIRECTION_UP_LEFT;
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_UP_LEFT);
                                } else if (270.0D <= angle && 360.0D > angle && this.tempDirection != RockerView.Direction.DIRECTION_UP_RIGHT) {
                                    this.tempDirection = RockerView.Direction.DIRECTION_UP_RIGHT;
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_UP_RIGHT);
                                }
                                break;
                            case DIRECTION_4_ROTATE_45:
                                if ((0.0D <= angle && 45.0D > angle || 315.0D <= angle && 360.0D > angle) && this.tempDirection != RockerView.Direction.DIRECTION_RIGHT) {
                                    this.tempDirection = RockerView.Direction.DIRECTION_RIGHT;
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_RIGHT);
                                } else if (45.0D <= angle && 135.0D > angle && this.tempDirection != RockerView.Direction.DIRECTION_DOWN) {
                                    this.tempDirection = RockerView.Direction.DIRECTION_DOWN;
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_DOWN);
                                } else if (135.0D <= angle && 225.0D > angle && this.tempDirection != RockerView.Direction.DIRECTION_LEFT) {
                                    this.tempDirection = RockerView.Direction.DIRECTION_LEFT;
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_LEFT);
                                } else if (225.0D <= angle && 315.0D > angle && this.tempDirection != RockerView.Direction.DIRECTION_UP) {
                                    this.tempDirection = RockerView.Direction.DIRECTION_UP;
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_UP);
                                }
                                break;
                            case DIRECTION_8:
                                if ((0.0D <= angle && 22.5D > angle || 337.5D <= angle && 360.0D > angle) && this.tempDirection != RockerView.Direction.DIRECTION_RIGHT) {
                                    this.tempDirection = RockerView.Direction.DIRECTION_RIGHT;
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_RIGHT);
                                } else if (22.5D <= angle && 67.5D > angle && this.tempDirection != RockerView.Direction.DIRECTION_DOWN_RIGHT) {
                                    this.tempDirection = RockerView.Direction.DIRECTION_DOWN_RIGHT;
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_DOWN_RIGHT);
                                } else if (67.5D <= angle && 112.5D > angle && this.tempDirection != RockerView.Direction.DIRECTION_DOWN) {
                                    this.tempDirection = RockerView.Direction.DIRECTION_DOWN;
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_DOWN);
                                } else if (112.5D <= angle && 157.5D > angle && this.tempDirection != RockerView.Direction.DIRECTION_DOWN_LEFT) {
                                    this.tempDirection = RockerView.Direction.DIRECTION_DOWN_LEFT;
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_DOWN_LEFT);
                                } else if (157.5D <= angle && 202.5D > angle && this.tempDirection != RockerView.Direction.DIRECTION_LEFT) {
                                    this.tempDirection = RockerView.Direction.DIRECTION_LEFT;
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_LEFT);
                                } else if (202.5D <= angle && 247.5D > angle && this.tempDirection != RockerView.Direction.DIRECTION_UP_LEFT) {
                                    this.tempDirection = RockerView.Direction.DIRECTION_UP_LEFT;
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_UP_LEFT);
                                } else if (247.5D <= angle && 292.5D > angle && this.tempDirection != RockerView.Direction.DIRECTION_UP) {
                                    this.tempDirection = RockerView.Direction.DIRECTION_UP;
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_UP);
                                } else if (292.5D <= angle && 337.5D > angle && this.tempDirection != RockerView.Direction.DIRECTION_UP_RIGHT) {
                                    this.tempDirection = RockerView.Direction.DIRECTION_UP_RIGHT;
                                    this.mOnShakeListener.direction(RockerView.Direction.DIRECTION_UP_RIGHT);
                                }
                        }
                    }
                }

            }

            private void callBackFinish() {
                this.tempDirection = RockerView.Direction.DIRECTION_CENTER;
                if (null != this.mOnAngleChangeListener) {
                    this.mOnAngleChangeListener.onFinish();
                }

                if (null != this.mOnShakeListener) {
                    this.mOnShakeListener.onFinish();
                }

            }

            public void setCallBackMode(RockerView.CallBackMode mode) {
                this.mCallBackMode = mode;
            }

            public void setOnAngleChangeListener(RockerView.OnAngleChangeListener listener) {
                this.mOnAngleChangeListener = listener;
            }

            public void setOnShakeListener(RockerView.DirectionMode directionMode, RockerView.OnShakeListener listener) {
                this.mDirectionMode = directionMode;
                this.mOnShakeListener = listener;
            }

            public interface OnAngleChangeListener {
                void onStart();

                void angle(double var1);

                void onFinish();
            }

            public interface OnShakeListener {
                void onStart();

                void direction(RockerView.Direction var1);

                void onFinish();
            }

            public static enum Direction {
                DIRECTION_LEFT,
                DIRECTION_RIGHT,
                DIRECTION_UP,
                DIRECTION_DOWN,
                DIRECTION_UP_LEFT,
                DIRECTION_UP_RIGHT,
                DIRECTION_DOWN_LEFT,
                DIRECTION_DOWN_RIGHT,
                DIRECTION_CENTER;

                private Direction() {
                }
            }

            public static enum DirectionMode {
                DIRECTION_2_HORIZONTAL,
                DIRECTION_2_VERTICAL,
                DIRECTION_4_ROTATE_0,
                DIRECTION_4_ROTATE_45,
                DIRECTION_8;

                private DirectionMode() {
                }
            }

            public static enum CallBackMode {
                CALL_BACK_MODE_MOVE,
                CALL_BACK_MODE_STATE_CHANGE;

                private CallBackMode() {
                }
            }
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
                                log("耳机测试: 没插入耳机");
                            headset_TF = false;
                        } else if (intent.getIntExtra("state", 0) == 1) {
                            if (GT_LOG_TF)
                                log("耳机测试: 插入耳机");
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
             * *             GT.log("X:" + (int)xAngle + "," + "Y:" + (int)yAngle);
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
                GT.err(getLineInfo(), "你的音频资源可能 需要添加 网络或访问SD卡的读取权限，否则无法进行有效的获取资源 url:" + url);
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
            if (mediaPlayer != null) {
                recover_play();//如果音频被停止了就恢复音频可播放，在进行 start
                if (!mediaPlayer.isPlaying()) {        //如果当前的 mediaPlayer 处于暂停状态  且 播放状态为 false 没有在播放
                    mediaPlayer.start();//继续播放
                } else {  //当前处于音乐暂停状态
                    mediaPlayer.pause();//暂停音乐
                }
            }
            return this;
        }//播放 与 暂停

        /**
         * 停止音乐
         *
         * @return
         */
        public GT_MediaPlayer stop() {
            if (mediaPlayer != null && isPlay) {
                isPlay = false;//设置为暂停状态
                mediaPlayer.stop();
            }
            return this;
        }//停止音乐

        /**
         * 恢复可播放
         *
         * @return
         */
        private GT_MediaPlayer recover_play() {
            if (mediaPlayer != null) {
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
                            GT.err(getLineInfo(), "你的音频资源可能 需要添加 网络或访问SD卡的读取权限，否则无法进行有效的获取资源 url:" + url);
                        }
                    }
                    isPlay = true;//恢复可播放状态
                }
            }
            return this;
        }//恢复可播放

        /**
         * 释放资源
         */
        public void close() {
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {//如果属于播放状态
                    mediaPlayer.stop();//停止播放
                }
                mediaPlayer.release();//释放资源
                mediaPlayer = null;
            }
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
                    GT.log(getLineInfo(), "添加音频无效，当前已经包含相同的 key，无法再进行装载相同的 key");//提示无效的添加
                }
            }
            return this;
        } //添加音频

        /**
         * 初始化音频
         */
        private void loadMusic() {
            if (map != null && mapMusic != null) {
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
            if (map != null && mapMusic != null) {
                if (map.containsKey(key)) {
                    map.remove(key);
                    mapMusic.remove(key);
                    loadMusic();//初始化音频
                } else {
                    log(getLineInfo(), "移除音频失败，当前并不存在此 key:" + key);
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
            if (map != null && mapMusic != null) {
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
            if (map != null && mapMusic != null) {
                if (map.containsKey(key)) {
                    map.put(key, rawId);
                    mapMusic.put(key, rawId);
                    loadMusic();//初始化音频
                } else {
                    GT.log(getLineInfo(), "修改音频无效，当前并不存在当前 key，无法进行更新操作");//提示无效的更新
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
            if (soundPool != null) {
                soundPool.play(
                        mapMusic.get(key),           //指定播放的音频 key
                        1,              //左声道 为0.0 到 1.0
                        1,             //右声道 为0.0 到 1.0
                        0,                 //优先级 0
                        (loop == true ? -1 : 0),    //是否循环 0为不循环, -1 为循环
                        rate                        //速率 为正常速率 1  最低为 0.5，最高为 2
                );
            }
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
            GT.err("mediaPlayer:" + mediaPlayer);
            if (mediaPlayer != null) {
                recover_play();
                GT.err("播放");
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
         * @Activity(R.layout.activity_main) public class AndroidActivity extends AppCompatActivity {....}
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

                String[] valueObject() default {};

                Class<?>[] valueClass() default {};

                String[] valueString() default {};

                byte[] valueByte() default {};

                short[] valueShort() default {};

                int[] valueInt() default {};

                long[] valueLong() default {};

                float[] valueFloat() default {};

                double[] valueDouble() default {};

                boolean[] valueBoolean() default {};

                char[] valueChar() default {};

            }


            /**
             * Map 注解
             */
            @Target(ElementType.FIELD)
            @Retention(RetentionPolicy.RUNTIME)
            @interface GT_Map {

                String[] valueKey() default {};

                String[] valueObject() default {};

                Class<?>[] valueClass() default {};

                String[] valueString() default {};

                byte[] valueByte() default {};

                short[] valueShort() default {};

                int[] valueInt() default {};

                long[] valueLong() default {};

                float[] valueFloat() default {};

                double[] valueDouble() default {};

                boolean[] valueBoolean() default {};

                char[] valueChar() default {};
            }


            /**
             * Set 注解
             */
            @Target(ElementType.FIELD)
            @Retention(RetentionPolicy.RUNTIME)
            @interface GT_Set {

                String[] valueObject() default {};

                Class<?>[] valueClass() default {};

                String[] valueString() default {};

                byte[] valueByte() default {};

                short[] valueShort() default {};

                int[] valueInt() default {};

                long[] valueLong() default {};

                float[] valueFloat() default {};

                double[] valueDouble() default {};

                boolean[] valueBoolean() default {};

                char[] valueChar() default {};

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
                    classPage = s[s.length - 2];


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

                    String[] valueObject = initView.valueObject();
                    Class<?>[] valueClass = initView.valueClass();
                    String[] valueString = initView.valueString();

                    byte[] valueByte = initView.valueByte();
                    short[] valueShort = initView.valueShort();
                    int[] valueInt = initView.valueInt();
                    long[] valueLong = initView.valueLong();
                    float[] valueFloat = initView.valueFloat();
                    double[] valueDouble = initView.valueDouble();
                    boolean[] valueBoolean = initView.valueBoolean();
                    char[] valueChar = initView.valueChar();

                    List<Object> objectList = new ArrayList<>();

                    if (valueObject.length != 0) {
                        for (Object value : valueObject) {
                            objectList.add(value);
                        }
                    } else if (valueClass.length != 0) {
                        for (Class cla : valueClass) {
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

                    } else if (valueString.length != 0) {
                        for (Object value : valueString) {
                            objectList.add(value);
                        }
                    } else if (valueByte.length != 0) {
                        for (Object value : valueByte) {
                            objectList.add(value);
                        }
                    } else if (valueShort.length != 0) {
                        for (Object value : valueShort) {
                            objectList.add(value);
                        }
                    } else if (valueInt.length != 0) {
                        for (Object value : valueInt) {
                            objectList.add(value);
                        }
                    } else if (valueLong.length != 0) {
                        for (Object value : valueLong) {
                            objectList.add(value);
                        }
                    } else if (valueFloat.length != 0) {
                        for (Object value : valueFloat) {
                            objectList.add(value);
                        }
                    } else if (valueDouble.length != 0) {
                        for (Object value : valueDouble) {
                            objectList.add(value);
                        }
                    } else if (valueBoolean.length != 0) {
                        for (Object value : valueBoolean) {
                            objectList.add(value);
                        }
                    } else if (valueChar.length != 0) {
                        for (Object value : valueChar) {
                            objectList.add(value);
                        }
                    }

                    //实例注入 List
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

                    Map<Object, Object> objectMap = new HashMap<>();//创建一个 Map
                    String[] valueKey = initView.valueKey();
                    if (valueKey.length != 0) {    //如果不为 0 则创建 map 后并注入值 否则仅创建新的 Map 对象

                        String[] valueObject = initView.valueObject();
                        Class<?>[] valueClass = initView.valueClass();
                        String[] valueString = initView.valueString();

                        byte[] valueByte = initView.valueByte();
                        short[] valueShort = initView.valueShort();
                        int[] valueInt = initView.valueInt();
                        long[] valueLong = initView.valueLong();
                        float[] valueFloat = initView.valueFloat();
                        double[] valueDouble = initView.valueDouble();
                        boolean[] valueBoolean = initView.valueBoolean();
                        char[] valueChar = initView.valueChar();

                        for (String key : valueKey) {
                            log("key:" + key);
                        }

                        if (valueObject.length != 0) {
                            for (int i = 0; i < valueKey.length; i++) {
                                objectMap.put(valueKey[i], valueObject[i]);
                            }
                        } else if (valueClass.length != 0) {
                            for (Class cla : valueClass) {

                                //截取 类的 class 路径属性
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

                                for (int i = 0; i < valueKey.length; i++) {
                                    objectMap.put(valueKey[i], object2);
                                }

                            }

                        } else if (valueString.length != 0) {
                            for (int i = 0; i < valueKey.length; i++) {
                                objectMap.put(valueKey[i], valueString[i]);
                            }
                        } else if (valueByte.length != 0) {
                            for (int i = 0; i < valueKey.length; i++) {
                                objectMap.put(valueKey[i], valueByte[i]);
                            }
                        } else if (valueShort.length != 0) {
                            for (int i = 0; i < valueKey.length; i++) {
                                objectMap.put(valueKey[i], valueShort[i]);
                            }
                        } else if (valueInt.length != 0) {
                            for (int i = 0; i < valueKey.length; i++) {
                                objectMap.put(valueKey[i], valueInt[i]);
                            }
                        } else if (valueLong.length != 0) {
                            for (int i = 0; i < valueKey.length; i++) {
                                objectMap.put(valueKey[i], valueLong[i]);
                            }
                        } else if (valueFloat.length != 0) {
                            for (int i = 0; i < valueKey.length; i++) {
                                objectMap.put(valueKey[i], valueFloat[i]);
                            }
                        } else if (valueDouble.length != 0) {
                            for (int i = 0; i < valueKey.length; i++) {
                                objectMap.put(valueKey[i], valueDouble[i]);
                            }
                        } else if (valueBoolean.length != 0) {
                            for (int i = 0; i < valueKey.length; i++) {
                                objectMap.put(valueKey[i], valueBoolean[i]);
                            }
                        } else if (valueChar.length != 0) {
                            for (int i = 0; i < valueKey.length; i++) {
                                objectMap.put(valueKey[i], valueChar[i]);
                            }
                        }

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

                    String[] valueObject = initView.valueObject();
                    Class<?>[] valueClass = initView.valueClass();
                    String[] valueString = initView.valueString();

                    byte[] valueByte = initView.valueByte();
                    short[] valueShort = initView.valueShort();
                    int[] valueInt = initView.valueInt();
                    long[] valueLong = initView.valueLong();
                    float[] valueFloat = initView.valueFloat();
                    double[] valueDouble = initView.valueDouble();
                    boolean[] valueBoolean = initView.valueBoolean();
                    char[] valueChar = initView.valueChar();

                    Set<Object> objectSet = new HashSet<>();

                    if (valueObject.length != 0) {
                        for (Object value : valueObject) {
                            objectSet.add(value);
                        }
                    } else if (valueClass.length != 0) {
                        for (Class cla : valueClass) {
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
                            objectSet.add(object2);//添加每一个经过反射得到的 对象
                        }

                    } else if (valueString.length != 0) {
                        for (Object value : valueString) {
                            objectSet.add(value);
                        }
                    } else if (valueByte.length != 0) {
                        for (Object value : valueByte) {
                            objectSet.add(value);
                        }
                    } else if (valueShort.length != 0) {
                        for (Object value : valueShort) {
                            objectSet.add(value);
                        }
                    } else if (valueInt.length != 0) {
                        for (Object value : valueInt) {
                            objectSet.add(value);
                        }
                    } else if (valueLong.length != 0) {
                        for (Object value : valueLong) {
                            objectSet.add(value);
                        }
                    } else if (valueFloat.length != 0) {
                        for (Object value : valueFloat) {
                            objectSet.add(value);
                        }
                    } else if (valueDouble.length != 0) {
                        for (Object value : valueDouble) {
                            objectSet.add(value);
                        }
                    } else if (valueBoolean.length != 0) {
                        for (Object value : valueBoolean) {
                            objectSet.add(value);
                        }
                    } else if (valueChar.length != 0) {
                        for (Object value : valueChar) {
                            objectSet.add(value);
                        }
                    }

                    //实例注入 List
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
                                GT.err(getLineInfo(), "注解注入失败 ！");
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
                            GT.err(getLineInfo(), "注解 赋值 byte 类型数据 报错");
                        }
                    }
                    break;
                case "class java.lang.Short":
                    try {
                        method = aClass.getMethod(functionName, short.class);
                    } catch (NoSuchMethodException e) {
                        //                    e.printStackTrace();
                        if (getGT().getGtLogTf()) {
                            GT.err(getLineInfo(), "注解 赋值 Short 类型数据 报错");
                        }
                    }
                    break;
                case "class java.lang.Integer":
                    try {
                        method = aClass.getMethod(functionName, int.class);
                    } catch (NoSuchMethodException e) {
                        //                    e.printStackTrace();
                        if (getGT().getGtLogTf()) {
                            GT.err(getLineInfo(), "注解 赋值 int 类型数据 报错");
                        }
                    }
                    break;
                case "class java.lang.Long":
                    try {
                        method = aClass.getMethod(functionName, long.class);
                    } catch (NoSuchMethodException e) {
                        //                    e.printStackTrace();
                        if (getGT().getGtLogTf()) {
                            GT.err(getLineInfo(), "注解 赋值 Long 类型数据 报错");
                        }
                    }
                    break;
                case "class java.lang.Float":
                    try {
                        method = aClass.getMethod(functionName, float.class);
                    } catch (NoSuchMethodException e) {
                        //                    e.printStackTrace();
                        if (getGT().getGtLogTf()) {
                            GT.err(getLineInfo(), "注解 赋值 Float 类型数据 报错");
                        }
                    }
                    break;
                case "class java.lang.Double":
                    try {
                        method = aClass.getMethod(functionName, double.class);
                    } catch (NoSuchMethodException e) {
                        //                    e.printStackTrace();
                        if (getGT().getGtLogTf()) {
                            GT.err(getLineInfo(), "注解 赋值 Double 类型数据 报错");
                        }
                    }
                    break;
                case "class java.lang.Boolean":
                    try {
                        method = aClass.getMethod(functionName, boolean.class);
                    } catch (NoSuchMethodException e) {
                        //                    e.printStackTrace();
                        if (getGT().getGtLogTf()) {
                            GT.err(getLineInfo(), "注解 赋值 Boolean 类型数据 报错");
                        }
                    }
                    break;
                case "class java.lang.Character":
                    try {
                        method = aClass.getMethod(functionName, char.class);
                    } catch (NoSuchMethodException e) {
                        //                    e.printStackTrace();
                        if (getGT().getGtLogTf()) {
                            GT.err(getLineInfo(), "注解 赋值 Character 类型数据 报错");
                        }
                    }
                    break;
                case "class java.lang.String":
                    try {
                        method = aClass.getMethod(functionName, String.class);
                    } catch (NoSuchMethodException e) {
                        //                    e.printStackTrace();
                        if (getGT().getGtLogTf()) {
                            GT.err(getLineInfo(), "注解 赋值 String 类型数据 报错");
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
                log("obj:" + obj);
                log("annotation:" + annotation);
            }

            /**
             * 获取所有注解
             */
            obj = classToObject(obj);
            Annotation[] annotations = obj.getClass().getAnnotations();
            if (GT_LOG_TF) log("---------------该类有所的注解---------------------");
            for (Annotation annotation1 : annotations) if (GT_LOG_TF) log(annotation1);
            if (GT_LOG_TF) log("-------------------close--------------------------");


            /**
             * 获取声明注解	[Ljava.lang.annotation.Annotation;@28c97a5
             */
            Annotation[] deAnnos = obj.getClass().getDeclaredAnnotations();
            if (GT_LOG_TF) log("被声明式注解标识过:" + deAnnos);


            if (annotation != null) {
                //获取被 SubAnnotation 注解过的类
                Annotation subAnnotation = obj.getClass().getAnnotation((Class<Annotation>) annotation);
                if (GT_LOG_TF) log("该类被 [" + subAnnotation + "] 注解过");
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
                            GT.log(getLineInfo(), "无法执行任务:任务已在运行。");
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

    //GT 包官网：https://github.com/1079374315/GT

    // 定义 GT 包 简易使用教程
    public interface CMD {

        /*
         * 关于 GT 包中的功能使用教程请参考官网详细教程
         * 官网教程：https://blog.csdn.net/qq_39799899/article/details/98891256
         */


                /*
                 * 关于 AndroidUtilCode 工具包的使用教程如下：
                 *
                 * 教程网址：https://www.jianshu.com/p/72494773aace
                 *
                 * ActivityUtils.java -> Demo 使用参考值
                 * isActivityExists               : 判断 Activity 是否存在
                 * startActivity                  : 启动 Activity
                 * startActivities                : 启动多个 Activity
                 * startHomeActivity              : 回到桌面
                 * getActivityList                : 获取 Activity 栈链表
                 * getLauncherActivity            : 获取启动项 Activity
                 * getTopActivity                 : 获取栈顶 Activity
                 * isActivityExistsInStack        : 判断 Activity 是否存在栈中
                 * finishActivity                 : 结束 Activity
                 * finishToActivity               : 结束到指定 Activity
                 * finishOtherActivities          : 结束所有其他类型的 Activity
                 * finishAllActivities            : 结束所有 Activity
                 * finishAllActivitiesExceptNewest: 结束除最新之外的所有 Activity
                 *
                 *
                 *
                 *
                 *
                 *AppUtils.java -> Demo 使用参考值
                 * isInstallApp         : 判断 App 是否安装
                 * installApp           : 安装 App（支持 8.0）
                 * installAppSilent     : 静默安装 App
                 * uninstallApp         : 卸载 App
                 * uninstallAppSilent   : 静默卸载 App
                 * isAppRoot            : 判断 App 是否有 root 权限
                 * launchApp            : 打开 App
                 * exitApp              : 关闭应用
                 * getAppPackageName    : 获取 App 包名
                 * getAppDetailsSettings: 获取 App 具体设置
                 * getAppName           : 获取 App 名称
                 * getAppIcon           : 获取 App 图标
                 * getAppPath           : 获取 App 路径
                 * getAppVersionName    : 获取 App 版本号
                 * getAppVersionCode    : 获取 App 版本码
                 * isSystemApp          : 判断 App 是否是系统应用
                 * isAppDebug           : 判断 App 是否是 Debug 版本
                 * getAppSignature      : 获取 App 签名
                 * getAppSignatureSHA1  : 获取应用签名的的 SHA1 值
                 * isAppForeground      : 判断 App 是否处于前台
                 * getForegroundApp     : 获取前台应用包名
                 * getAppInfo           : 获取 App 信息
                 * getAppsInfo          : 获取所有已安装 App 信息
                 * cleanAppData         : 清除 App 所有数据
                 *
                 *
                 *
                 * BarUtils.java -> Demo 使用参考值
                 * getStatusBarHeight                   : 获取状态栏高度（px）
                 * setStatusBarVisibility               : 设置状态栏是否可见
                 * isStatusBarVisible                   : 判断状态栏是否可见
                 * addMarginTopEqualStatusBarHeight     : 为 view 增加 MarginTop 为状态栏高度
                 * subtractMarginTopEqualStatusBarHeight: 为 view 减少 MarginTop 为状态栏高度
                 * setStatusBarColor                    : 设置状态栏颜色
                 * setStatusBarAlpha                    : 设置状态栏透明度
                 * setStatusBarColor4Drawer             : 为 DrawerLayout 设置状态栏颜色
                 * setStatusBarAlpha4Drawer             : 为 DrawerLayout 设置状态栏透明度
                 * getActionBarHeight                   : 获取 ActionBar 高度
                 * setNotificationBarVisibility         : 设置通知栏是否可见
                 * getNavBarHeight                      : 获取导航栏高度
                 * setNavBarVisibility                  : 设置导航栏是否可见
                 * setNavBarImmersive                   : 设置导航栏沉浸式
                 * isNavBarVisible                      : 判断导航栏是否可见
                 *
                 *
                 *
                 *
                 *缓存相关 -> CacheUtils.java -> Test
                    getInstance    : 获取缓存实例
                    put            : 缓存中写入数据
                    getBytes       : 缓存中读取字节数组
                    getString      : 缓存中读取 String
                    getJSONObject  : 缓存中读取 JSONObject
                    getJSONArray   : 缓存中读取 JSONArray
                    getBitmap      : 缓存中读取 Bitmap
                    getDrawable    : 缓存中读取 Drawable
                    getParcelable  : 缓存中读取 Parcelable
                    getSerializable: 缓存中读取 Serializable
                    getCacheSize   : 获取缓存大小
                    getCacheCount  : 获取缓存个数
                    remove         : 根据键值移除缓存
                    clear          : 清除所有缓存
                 *
                 *
                 *
                 *
                 *
                 * 清除相关 -> CleanUtils.java -> Demo
                    cleanInternalCache   : 清除内部缓存
                    cleanInternalFiles   : 清除内部文件
                    cleanInternalDbs     : 清除内部数据库
                    cleanInternalDbByName: 根据名称清除数据库
                    cleanInternalSP      : 清除内部 SP
                    cleanExternalCache   : 清除外部缓存
                    cleanCustomCache     : 清除自定义目录下的文件
                    * 关闭相关 -> CloseUtils.java
                    closeIO       : 关闭 IO
                    closeIOQuietly: 安静关闭 IO
                 *
                 *
                 *
                 *
                 *
                 *转换相关 -> ConvertUtils.java -> Test
                    bytes2HexString, hexString2Bytes        : byteArr 与 hexString 互转
                    chars2Bytes, bytes2Chars                : charArr 与 byteArr 互转
                    memorySize2Byte, byte2MemorySize        : 以 unit 为单位的内存大小与字节数互转
                    byte2FitMemorySize                      : 字节数转合适内存大小
                    timeSpan2Millis, millis2TimeSpan        : 以 unit 为单位的时间长度与毫秒时间戳互转
                    millis2FitTimeSpan                      : 毫秒时间戳转合适时间长度
                    bytes2Bits, bits2Bytes                  : bytes 与 bits 互转
                    input2OutputStream, output2InputStream  : inputStream 与 outputStream 互转
                    inputStream2Bytes, bytes2InputStream    : inputStream 与 byteArr 互转
                    outputStream2Bytes, bytes2OutputStream  : outputStream 与 byteArr 互转
                    inputStream2String, string2InputStream  : inputStream 与 string 按编码互转
                    outputStream2String, string2OutputStream: outputStream 与 string 按编码互转
                    bitmap2Bytes, bytes2Bitmap              : bitmap 与 byteArr 互转
                    drawable2Bitmap, bitmap2Drawable        : drawable 与 bitmap 互转
                    drawable2Bytes, bytes2Drawable          : drawable 与 byteArr 互转
                    view2Bitmap                             : view 转 Bitmap
                    dp2px, px2dp                            : dp 与 px 互转
                    sp2px, px2sp                            : sp 与 px 互转
                 *
                 *
                 *
                 *
                 *
                 *
                 * 设备相关 -> DeviceUtils.java -> Demo
                    isDeviceRooted   : 判断设备是否 rooted
                    getSDKVersion    : 获取设备系统版本号
                    getAndroidID     : 获取设备 AndroidID
                    getMacAddress    : 获取设备 MAC 地址
                    getManufacturer  : 获取设备厂商
                    getModel         : 获取设备型号
                    shutdown         : 关机
                    reboot           : 重启
                    reboot2Recovery  : 重启到 recovery
                    reboot2Bootloader: 重启到 bootloader
                 *
                 *
                 *
                 *
                 *
                 *
                 *判空相关 -> EmptyUtils.java -> Test
                    isEmpty   : 判断对象是否为空
                    isNotEmpty: 判断对象是否非空
                 *
                 *
                 *
                 *
                 *
                 *编码解码相关 -> EncodeUtils.java -> Test
                    urlEncode          : URL 编码
                    urlDecode          : URL 解码
                    base64Encode       : Base64 编码
                    base64Encode2String: Base64 编码
                    base64Decode       : Base64 解码
                    base64UrlSafeEncode: Base64URL 安全编码
                    htmlEncode         : Html 编码
                    htmlDecode         : Html 解码

                 *
                 *
                 *
                 *
                 *
                 *
                 *
                 *
                 *
                 *
                 *加密解密相关 -> EncryptUtils.java -> Test
                    encryptMD2, encryptMD2ToString                        : MD2 加密
                    encryptMD5, encryptMD5ToString                        : MD5 加密
                    encryptMD5File, encryptMD5File2String                 : MD5 加密文件
                    encryptSHA1, encryptSHA1ToString                      : SHA1 加密
                    encryptSHA224, encryptSHA224ToString                  : SHA224 加密
                    encryptSHA256, encryptSHA256ToString                  : SHA256 加密
                    encryptSHA384, encryptSHA384ToString                  : SHA384 加密
                    encryptSHA512, encryptSHA512ToString                  : SHA512 加密
                    encryptHmacMD5, encryptHmacMD5ToString                : HmacMD5 加密
                    encryptHmacSHA1, encryptHmacSHA1ToString              : HmacSHA1 加密
                    encryptHmacSHA224, encryptHmacSHA224ToString          : HmacSHA224 加密
                    encryptHmacSHA256, encryptHmacSHA256ToString          : HmacSHA256 加密
                    encryptHmacSHA384, encryptHmacSHA384ToString          : HmacSHA384 加密
                    encryptHmacSHA512, encryptHmacSHA512ToString          : HmacSHA512 加密
                    encryptDES, encryptDES2HexString, encryptDES2Base64   : DES 加密
                    decryptDES, decryptHexStringDES, decryptBase64DES     : DES 解密
                    encrypt3DES, encrypt3DES2HexString, encrypt3DES2Base64: 3DES 加密
                    decrypt3DES, decryptHexString3DES, decryptBase64_3DES : 3DES 解密
                    encryptAES, encryptAES2HexString, encryptAES2Base64   : AES 加密
                    decryptAES, decryptHexStringAES, decryptBase64AES     : AES 解密



                    文件相关 -> FileIOUtils.java -> Test
                    writeFileFromIS            : 将输入流写入文件
                    writeFileFromBytesByStream : 将字节数组写入文件
                    writeFileFromBytesByChannel: 将字节数组写入文件
                    writeFileFromBytesByMap    : 将字节数组写入文件
                    writeFileFromString        : 将字符串写入文件
                    readFile2List              : 读取文件到字符串链表中
                    readFile2String            : 读取文件到字符串中
                    readFile2BytesByStream     : 读取文件到字节数组中
                    readFile2BytesByChannel    : 读取文件到字节数组中
                    readFile2BytesByMap        : 读取文件到字节数组中
                    setBufferSize              : 设置缓冲区尺寸



                    文件相关 -> FileUtils.java -> Test
                    getFileByPath             : 根据文件路径获取文件
                    isFileExists              : 判断文件是否存在
                    rename                    : 重命名文件
                    isDir                     : 判断是否是目录
                    isFile                    : 判断是否是文件
                    createOrExistsDir         : 判断目录是否存在，不存在则判断是否创建成功
                    createOrExistsFile        : 判断文件是否存在，不存在则判断是否创建成功
                    createFileByDeleteOldFile : 判断文件是否存在，存在则在创建之前删除
                    copyDir                   : 复制目录
                    copyFile                  : 复制文件
                    moveDir                   : 移动目录
                    moveFile                  : 移动文件
                    deleteDir                 : 删除目录
                    deleteFile                : 删除文件
                    deleteAllInDir            : 删除目录下所有东西
                    deleteFilesInDir          : 删除目录下所有文件
                    deleteFilesInDirWithFilter: 删除目录下所有过滤的文件
                    listFilesInDir            : 获取目录下所有文件
                    listFilesInDirWithFilter  : 获取目录下所有过滤的文件
                    getFileLastModified       : 获取文件最后修改的毫秒时间戳
                    getFileCharsetSimple      : 简单获取文件编码格式
                    getFileLines              : 获取文件行数
                    getDirSize                : 获取目录大小
                    getFileSize               : 获取文件大小
                    getDirLength              : 获取目录长度
                    getFileLength             : 获取文件长度
                    getFileMD5                : 获取文件的 MD5 校验码
                    getFileMD5ToString        : 获取文件的 MD5 校验码
                    getDirName                : 根据全路径获取最长目录
                    getFileName               : 根据全路径获取文件名
                    getFileNameNoExtension    : 根据全路径获取文件名不带拓展名
                    getFileExtension          : 根据全路径获取文件拓展名



                    Fragment 相关 -> FragmentUtils.java -> Demo
                    add                   : 新增 fragment
                    show                  : 显示 fragment
                    hide                  : 隐藏 fragment
                    showHide              : 先显示后隐藏 fragment
                    replace               : 替换 fragment
                    pop                   : 出栈 fragment
                    popTo                 : 出栈到指定 fragment
                    popAll                : 出栈所有 fragment
                    remove                : 移除 fragment
                    removeTo              : 移除到指定 fragment
                    removeAll             : 移除所有 fragment
                    getTop                : 获取顶部 fragment
                    getTopInStack         : 获取栈中顶部 fragment
                    getTopShow            : 获取顶部可见 fragment
                    getTopShowInStack     : 获取栈中顶部可见 fragment
                    getFragments          : 获取同级别的 fragment
                    getFragmentsInStack   : 获取同级别栈中的 fragment
                    getAllFragments       : 获取所有 fragment
                    getAllFragmentsInStack: 获取栈中所有 fragment
                    findFragment          : 查找 fragment
                    dispatchBackPress     : 处理 fragment 回退键
                    setBackgroundColor    : 设置背景色
                    setBackgroundResource : 设置背景资源
                    setBackground         : 设置背景



                    图片相关 -> ImageUtils.java -> Demo
                    bitmap2Bytes, bytes2Bitmap      : bitmap 与 byteArr 互转
                    drawable2Bitmap, bitmap2Drawable: drawable 与 bitmap 互转
                    drawable2Bytes, bytes2Drawable  : drawable 与 byteArr 互转
                    view2Bitmap                     : view 转 bitmap
                    getBitmap                       : 获取 bitmap
                    scale                           : 缩放图片
                    clip                            : 裁剪图片
                    skew                            : 倾斜图片
                    rotate                          : 旋转图片
                    getRotateDegree                 : 获取图片旋转角度
                    toRound                         : 转为圆形图片
                    toRoundCorner                   : 转为圆角图片
                    addCornerBorder                 : 添加圆角边框
                    addCircleBorder                 : 添加圆形边框
                    addReflection                   : 添加倒影
                    addTextWatermark                : 添加文字水印
                    addImageWatermark               : 添加图片水印
                    toAlpha                         : 转为 alpha 位图
                    toGray                          : 转为灰度图片
                    fastBlur                        : 快速模糊
                    renderScriptBlur                : renderScript 模糊图片
                    stackBlur                       : stack 模糊图片
                    save                            : 保存图片
                    isImage                         : 根据文件名判断文件是否为图片
                    getImageType                    : 获取图片类型
                    compressByScale                 : 按缩放压缩
                    compressByQuality               : 按质量压缩
                    compressBySampleSize            : 按采样大小压缩



                    意图相关 -> IntentUtils.java
                    getInstallAppIntent        : 获取安装 App（支持 6.0）的意图
                    getUninstallAppIntent      : 获取卸载 App 的意图
                    getLaunchAppIntent         : 获取打开 App 的意图
                    getAppDetailsSettingsIntent: 获取 App 具体设置的意图
                    getShareTextIntent         : 获取分享文本的意图
                    getShareImageIntent        : 获取分享图片的意图
                    getComponentIntent         : 获取其他应用组件的意图
                    getShutdownIntent          : 获取关机的意图
                    getCaptureIntent           : 获取拍照的意图



                    键盘相关 -> KeyboardUtils.java -> Demo
                    showSoftInput                   : 动态显示软键盘
                    hideSoftInput                   : 动态隐藏软键盘
                    toggleSoftInput                 : 切换键盘显示与否状态
                    isSoftInputVisible              : 判断软键盘是否可见
                    registerSoftInputChangedListener: 注册软键盘改变监听器
                    clickBlankArea2HideSoftInput    : 点击屏幕空白区域隐藏软键盘



                    日志相关 -> LogUtils.java -> Demo
                    getConfig               : 获取 log 配置
                    Config.setLogSwitch     : 设置 log 总开关
                    Config.setConsoleSwitch : 设置 log 控制台开关
                    Config.setGlobalTag     : 设置 log 全局 tag
                    Config.setLogHeadSwitch : 设置 log 头部信息开关
                    Config.setLog2FileSwitch: 设置 log 文件开关
                    Config.setDir           : 设置 log 文件存储目录
                    Config.setFilePrefix    : 设置 log 文件前缀
                    Config.setBorderSwitch  : 设置 log 边框开关
                    Config.setConsoleFilter : 设置 log 控制台过滤器
                    Config.setFileFilter    : 设置 log 文件过滤器
                    Config.setStackDeep     : 设置 log 栈深度
                    v                       : tag 为类名的 Verbose 日志
                    vTag                    : 自定义 tag 的 Verbose 日志
                    d                       : tag 为类名的 Debug 日志
                    dTag                    : 自定义 tag 的 Debug 日志
                    i                       : tag 为类名的 Info 日志
                    iTag                    : 自定义 tag 的 Info 日志
                    w                       : tag 为类名的 Warn 日志
                    wTag                    : 自定义 tag 的 Warn 日志
                    e                       : tag 为类名的 Error 日志
                    eTag                    : 自定义 tag 的 Error 日志
                    a                       : tag 为类名的 Assert 日志
                    aTag                    : 自定义 tag 的 Assert 日志
                    file                    : log 到文件
                    json                    : log 字符串之 json
                    xml                     : log 字符串之 xml



                    网络相关 -> NetworkUtils.java -> Demo
                    openWirelessSettings  : 打开网络设置界面
                    isConnected           : 判断网络是否连接
                    isAvailableByPing     : 判断网络是否可用
                    getMobileDataEnabled  : 判断移动数据是否打开
                    setMobileDataEnabled  : 打开或关闭移动数据
                    isMobileData          : 判断网络是否是移动数据
                    is4G                  : 判断网络是否是 4G
                    getWifiEnabled        : 判断 wifi 是否打开
                    setWifiEnabled        : 打开或关闭 wifi
                    isWifiConnected       : 判断 wifi 是否连接状态
                    isWifiAvailable       : 判断 wifi 数据是否可用
                    getNetworkOperatorName: 获取移动网络运营商名称
                    getNetworkType        : 获取当前网络类型
                    getIPAddress          : 获取 IP 地址
                    getDomainAddress      : 获取域名 ip 地址



                    对象相关 -> ObjectUtils.java -> Test
                    isEmpty   : 判断对象是否为空
                    isNotEmpty: 判断对象是否非空
                    equals    : 判断对象是否相等



                    手机相关 -> PhoneUtils.java -> Demo
                    isPhone            : 判断设备是否是手机
                    getIMEI            : 获取 IMEI 码
                    getIMSI            : 获取 IMSI 码
                    getPhoneType       : 获取移动终端类型
                    isSimCardReady     : 判断 sim 卡是否准备好
                    getSimOperatorName : 获取 Sim 卡运营商名称
                    getSimOperatorByMnc: 获取 Sim 卡运营商名称
                    getPhoneStatus     : 获取手机状态信息
                    dial               : 跳至拨号界面
                    call               : 拨打 phoneNumber
                    sendSms            : 跳至发送短信界面
                    sendSmsSilent      : 发送短信
                    getAllContactInfo  : 获取手机联系人
                    getContactNum      : 打开手机联系人界面点击联系人后便获取该号码
                    getAllSMS          : 获取手机短信并保存到 xml 中



                    进程相关 -> ProcessUtils.java -> Demo
                    getForegroundProcessName  : 获取前台线程包名
                    killAllBackgroundProcesses: 杀死所有的后台服务进程
                    killBackgroundProcesses   : 杀死后台服务进程



                    正则相关 -> RegexUtils.java -> Test
                    isMobileSimple : 验证手机号（简单）
                    isMobileExact  : 验证手机号（精确）
                    isTel          : 验证电话号码
                    isIDCard15     : 验证身份证号码 15 位
                    isIDCard18     : 验证身份证号码 18 位
                    isEmail        : 验证邮箱
                    isURL          : 验证 URL
                    isZh           : 验证汉字
                    isUsername     : 验证用户名
                    isDate         : 验证 yyyy-MM-dd 格式的日期校验，已考虑平闰年
                    isIP           : 验证 IP 地址
                    isMatch        : 判断是否匹配正则
                    getMatches     : 获取正则匹配的部分
                    getSplits      : 获取正则匹配分组
                    getReplaceFirst: 替换正则匹配的第一部分
                    getReplaceAll  : 替换所有正则匹配的部分



                    屏幕相关 -> ScreenUtils.java
                    getScreenWidth     : 获取屏幕的宽度（单位：px）
                    getScreenHeight    : 获取屏幕的高度（单位：px）
                    getScreenDensity   : 获取屏幕密度
                    getScreenDensityDpi: 获取屏幕密度 DPI
                    setFullScreen      : 设置屏幕为全屏
                    setLandscape       : 设置屏幕为横屏
                    setPortrait        : 设置屏幕为竖屏
                    isLandscape        : 判断是否横屏
                    isPortrait         : 判断是否竖屏
                    getScreenRotation  : 获取屏幕旋转角度
                    screenShot         : 截屏
                    isScreenLock       : 判断是否锁屏
                    setSleepDuration   : 设置进入休眠时长
                    getSleepDuration   : 获取进入休眠时长
                    isTablet           : 判断是否是平板



                    SD 卡相关 -> SDCardUtils.java -> Demo
                    isSDCardEnable: 判断 SD 卡是否可用
                    getSDCardPaths: 获取 SD 卡路径



                    服务相关 -> ServiceUtils.java
                    getAllRunningService: 获取所有运行的服务
                    startService        : 启动服务
                    stopService         : 停止服务
                    bindService         : 绑定服务
                    unbindService       : 解绑服务
                    isServiceRunning    : 判断服务是否运行



                    Shell 相关 -> ShellUtils.java
                    execCmd: 是否是在 root 下执行命令



                    尺寸相关 -> SizeUtils.java
                    dp2px, px2dp     : dp 与 px 转换
                    sp2px, px2sp     : sp 与 px 转换
                    applyDimension   : 各种单位转换
                    forceGetViewSize : 在 onCreate 中获取视图的尺寸
                    measureView      : 测量视图尺寸
                    getMeasuredWidth : 获取测量视图宽度
                    getMeasuredHeight: 获取测量视图高度



                    Snackbar 相关 -> SnackbarUtils.java -> Demo
                    with           : 设置 snackbar 依赖 view
                    setMessage     : 设置消息
                    setMessageColor: 设置消息颜色
                    setBgColor     : 设置背景色
                    setBgResource  : 设置背景资源
                    setDuration    : 设置显示时长
                    setAction      : 设置行为
                    setBottomMargin: 设置底边距
                    show           : 显示 snackbar
                    showSuccess    : 显示预设成功的 snackbar
                    showWarning    : 显示预设警告的 snackbar
                    showError      : 显示预设错误的 snackbar
                    dismiss        : 消失 snackbar
                    getView        : 获取 snackbar 视图
                    addView        : 添加 snackbar 视图



                    SpannableString 相关 -> SpanUtils.java -> Demo
                    setFlag           : 设置标识
                    setForegroundColor: 设置前景色
                    setBackgroundColor: 设置背景色
                    setLineHeight     : 设置行高
                    setQuoteColor     : 设置引用线的颜色
                    setLeadingMargin  : 设置缩进
                    setBullet         : 设置列表标记
                    setIconMargin     : 设置图标
                    setFontSize       : 设置字体尺寸
                    setFontProportion : 设置字体比例
                    setFontXProportion: 设置字体横向比例
                    setStrikethrough  : 设置删除线
                    setUnderline      : 设置下划线
                    setSuperscript    : 设置上标
                    setSubscript      : 设置下标
                    setBold           : 设置粗体
                    setItalic         : 设置斜体
                    setBoldItalic     : 设置粗斜体
                    setFontFamily     : 设置字体系列
                    setTypeface       : 设置字体
                    setAlign          : 设置对齐
                    setClickSpan      : 设置点击事件
                    setUrl            : 设置超链接
                    setBlur           : 设置模糊
                    setShader         : 设置着色器
                    setShadow         : 设置阴影
                    setSpans          : 设置样式
                    append            : 追加样式字符串
                    appendLine        : 追加一行样式字符串
                    appendImage       : 追加图片
                    appendSpace       : 追加空白
                    create            : 创建样式字符串



                    SP 相关 -> SPUtils.java -> Test
                    getInstance: 获取 SP 实例
                    put        : SP 中写入数据
                    getString  : SP 中读取 String
                    getInt     : SP 中读取 int
                    getLong    : SP 中读取 long
                    getFloat   : SP 中读取 float
                    getBoolean : SP 中读取 boolean
                    getAll     : SP 中获取所有键值对
                    contains   : SP 中是否存在该 key
                    remove     : SP 中移除该 key
                    clear      : SP 中清除所有数据



                    字符串相关 -> StringUtils.java -> Test
                    isEmpty         : 判断字符串是否为 null 或长度为 0
                    isTrimEmpty     : 判断字符串是否为 null 或全为空格
                    isSpace         : 判断字符串是否为 null 或全为空白字符
                    equals          : 判断两字符串是否相等
                    equalsIgnoreCase: 判断两字符串忽略大小写是否相等
                    null2Length0    : null 转为长度为 0 的字符串
                    length          : 返回字符串长度
                    upperFirstLetter: 首字母大写
                    lowerFirstLetter: 首字母小写
                    reverse         : 反转字符串
                    toDBC           : 转化为半角字符
                    toSBC           : 转化为全角字符



                    时间相关 -> TimeUtils.java -> Test
                    millis2String           : 将时间戳转为时间字符串
                    string2Millis           : 将时间字符串转为时间戳
                    string2Date             : 将时间字符串转为 Date 类型
                    date2String             : 将 Date 类型转为时间字符串
                    date2Millis             : 将 Date 类型转为时间戳
                    millis2Date             : 将时间戳转为 Date 类型
                    getTimeSpan             : 获取两个时间差（单位：unit）
                    getFitTimeSpan          : 获取合适型两个时间差
                    getNowMills             : 获取当前毫秒时间戳
                    getNowString            : 获取当前时间字符串
                    getNowDate              : 获取当前 Date
                    getTimeSpanByNow        : 获取与当前时间的差（单位：unit）
                    getFitTimeSpanByNow     : 获取合适型与当前时间的差
                    getFriendlyTimeSpanByNow: 获取友好型与当前时间的差
                    getMillis               : 获取与给定时间等于时间差的时间戳
                    getString               : 获取与给定时间等于时间差的时间字符串
                    getDate                 : 获取与给定时间等于时间差的 Date
                    getMillisByNow          : 获取与当前时间等于时间差的时间戳
                    getStringByNow          : 获取与当前时间等于时间差的时间字符串
                    getDateByNow            : 获取与当前时间等于时间差的 Date
                    isToday                 : 判断是否今天
                    isLeapYear              : 判断是否闰年
                    getChineseWeek          : 获取中式星期
                    getUSWeek               : 获取美式式星期
                    getWeekIndex            : 获取星期索引
                    getWeekOfMonth          : 获取月份中的第几周
                    getWeekOfYear           : 获取年份中的第几周
                    getChineseZodiac        : 获取生肖
                    getZodiac               : 获取星座



                    吐司相关 -> ToastUtils.java -> Demo
                    setGravity     : 设置吐司位置
                    setBgColor     : 设置背景颜色
                    setBgResource  : 设置背景资源
                    setMessageColor: 设置消息颜色
                    showShort      : 显示短时吐司
                    showLong       : 显示长时吐司
                    showCustomShort: 显示短时自定义吐司
                    showCustomLong : 显示长时自定义吐司
                    cancel         : 取消吐司显示



                    压缩相关 -> ZipUtils.java -> Test
                    zipFile           : 压缩文件
                    unzipFile         : 解压文件
                    unzipFileByKeyword: 解压带有关键字的文件
                    getFilesPath      : 获取压缩文件中的文件路径链表
                    getComments       : 获取压缩文件中的注释链表
                 *
                 *
                 *
                 *
                 *
                 *
                 *
                 *
                 *
                 *
                 *
                 *
                 *
                 *
                 *
                 *
                 *
                 */


    }

}



