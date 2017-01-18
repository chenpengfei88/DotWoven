package com.weimob.dotwoven;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenpengfei on 2017/1/18.
 */
public class DotWoven {

    private static DotWoven mInstance;

    private DotWovenConfiguration mDotWovenConfiguration;
    private Map<String, Object> mParamMap;
    private OnDotListener mOnDotListener;


    public static DotWoven getInstance() {
        if (mInstance == null) {
            synchronized (DotWoven.class) {
                if (mInstance == null) {
                    mInstance = new DotWoven();
                }
            }
        }
        return mInstance;
    }

    public DotWoven() {
        mParamMap = new HashMap();
    }

    public void setOnDotListener(OnDotListener onDotListener) {
        mOnDotListener = onDotListener;
    }

    public void init(DotWovenConfiguration dotWovenConfiguration) {
        if(dotWovenConfiguration == null) {
            throw new NullPointerException("DotWovenConfiguration isNot NUll");
        }
        mDotWovenConfiguration = dotWovenConfiguration;

        setCommonParams();
    }

    private void setCommonParams() {
        mParamMap.put("platform", mDotWovenConfiguration.platform);
        mParamMap.put("appVersion", mDotWovenConfiguration.appVersion);
        mParamMap.put("deviceid", mDotWovenConfiguration.deviceId);
        mParamMap.put("model", mDotWovenConfiguration.model);
        mParamMap.put("platformVersion", mDotWovenConfiguration.platformVersion);
        mParamMap.put("appmarket", mDotWovenConfiguration.appMarket);
    }

    public void addParams(String key, String value) {
        if(mParamMap == null) return;
        mParamMap.put(key, value);
    }

    public void dot() {
        if(mOnDotListener != null) {
            mOnDotListener.onDot(mParamMap);
        }
    }
}
