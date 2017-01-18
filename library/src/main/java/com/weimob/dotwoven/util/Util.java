package com.weimob.dotwoven.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;

/**
 * Created by chenpengfei on 2017/1/18.
 */
public class Util {

    /**
     * 得到App版本号
     */
    public static String getAppVersion(Context context) {
        String versionName = "";
        if(context == null) return versionName;
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            versionName = info.versionName;
        } catch (Exception e){
            e.printStackTrace();
            return versionName;
        }
        return versionName;
    }

    /**
     *  得到设备ID
     */
    public static String getDeviceId(Context context) {
        if (context == null) return "";
        TelephonyManager tManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tManager.getDeviceId();
    }

    /**
     *  得到SDK 版本号
     */
    public static int getSDKVersion() {
        int version = 0;
        try {
            version = Build.VERSION.SDK_INT;
        } catch (NumberFormatException e) {
            return version;
        }
        return version;
    }



}
