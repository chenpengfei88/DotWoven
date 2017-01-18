package fe.dotwoven;

import android.app.Application;

import com.weimob.dotwoven.DotWoven;
import com.weimob.dotwoven.DotWovenConfiguration;
import com.weimob.dotwoven.OnDotListener;
import java.util.Map;

/**
 * Created by chenpengfei on 2017/1/18.
 */
public class DotWovenApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        DotWoven.getInstance().init(new DotWovenConfiguration.Builder(this).url("").build());
        DotWoven.getInstance().setOnDotListener(new OnDotListener() {
            @Override
            public void onDot(Map<String, Object> paramsMap) {
                System.out.println("=========dot=================" + paramsMap.toString());
            }
        });
    }
}
