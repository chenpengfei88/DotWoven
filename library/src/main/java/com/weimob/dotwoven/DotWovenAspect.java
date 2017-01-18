package com.weimob.dotwoven;

import android.util.Log;
import com.weimob.dotwoven.annotation.WovenPV;
import com.weimob.dotwoven.annotation.WovenTap;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import java.lang.reflect.Method;

/**
 * Created by chenpengfei on 2017/1/18.
 */
@Aspect
public class DotWovenAspect {

    @Pointcut("execution(@com.weimob.dotwoven.annotation.WovenPV * *(..))")
    public void pointcutOnWovenPVMethod() {
    }

    @After("pointcutOnWovenPVMethod()")
    public void adviceOnWovenPVMethod(JoinPoint joinPoint) throws Throwable {
        Log.i("AOP PV", joinPoint.getSignature().toString());

        Method method = getTargetMethod(joinPoint);
        if(method == null) return;

        WovenPV wovenPv = method.getAnnotation(WovenPV.class);
        if(wovenPv == null) return;
        String pageName = wovenPv.pageName();

        addWovenParams(pageName, "pv", "view");
        DotWoven.getInstance().dot();
    }

    @Pointcut("execution(@com.weimob.dotwoven.annotation.WovenTap * *(..))")
    public void pointcutOnWovenTapMethod() {
    }

    @After("pointcutOnWovenTapMethod()")
    public void adviceOnWovenTapMethod(JoinPoint joinPoint) throws Throwable {
        Log.i("AOP TAP", joinPoint.getSignature().toString());

        Method method = getTargetMethod(joinPoint);
        if(method == null) return;

        WovenTap wovenTap = method.getAnnotation(WovenTap.class);
        if(wovenTap == null) return;
        String elementId = wovenTap.elementId();
        String pageName = wovenTap.pageName();

        addWovenParams(pageName, elementId, "tap");
        DotWoven.getInstance().dot();
    }

    public Method getTargetMethod(JoinPoint joinPoint) {
        Object target = joinPoint.getTarget();
        Method method = null;
        try {
            method = target.getClass().getDeclaredMethod(joinPoint.getSignature().getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return method;
        }
        return method;
    }

    public void addWovenParams(String pageName, String elementId, String eventtype) {
        DotWoven dotWoven = DotWoven.getInstance();
        dotWoven.addParams("pageName", pageName);
        dotWoven.addParams("elementId", elementId);
        dotWoven.addParams("eventtype", eventtype);
    }
}
