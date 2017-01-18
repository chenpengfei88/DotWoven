package com.weimob.dotwoven;

import android.content.Context;
import android.os.Build;
import com.weimob.dotwoven.util.Util;

/**
 * Created by chenpengfei on 2017/1/18.
 */
public class DotWovenConfiguration {

    final String appVersion;
    final String platform;
    final String deviceId;
    final String model;
    final int platformVersion;
    final String appMarket;
    final long timeStamp;
    final String url;

    private DotWovenConfiguration(Builder builder) {
        appVersion = builder.appVersion;
        platform = builder.platform;
        deviceId = builder.deviceId;
        model = builder.model;
        platformVersion = builder.platformVersion;
        appMarket = builder.appMarket;
        timeStamp = builder.timeStamp;
        url = builder.url;
    }

    public static final class Builder {

        private Context context;
        private String appVersion;
        private String platform;
        private String deviceId;
        private String model;
        private int platformVersion;
        private String appMarket;
        private long timeStamp;
        private String url;

        public Builder(Context context) {
            this.context = context;
            appVersion = Util.getAppVersion(this.context);
            platform = "android";
            deviceId = Util.getDeviceId(this.context);
            model = Build.MODEL;
            platformVersion = Util.getSDKVersion();
            timeStamp = System.currentTimeMillis();
        }

        public Builder appVersion(String appVersion) {
            this.appVersion = appVersion;
            return this;
        }

        public Builder platform(String platform) {
            this.platform = platform;
            return this;
        }

        public Builder deviceId(String deviceId) {
            this.deviceId = deviceId;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder platformVersion(int platformVersion) {
            this.platformVersion = platformVersion;
            return this;
        }

        public Builder appMarket(String appMarket) {
            this.appMarket = appMarket;
            return this;
        }

        public Builder timeStamp(long timeStamp) {
            this.timeStamp = timeStamp;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public DotWovenConfiguration build() {
            return new DotWovenConfiguration(this);
        }
    }
}
