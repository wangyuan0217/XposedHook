package com.example.xposedhook;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * @author DX
 * 注意：该类不要自己写构造方法，否者可能会hook不成功
 * 开发Xposed模块完成以后，建议修改xposed_init文件，并将起指向这个类,以提升性能
 * 所以这个类需要implements IXposedHookLoadPackage,以防修改xposed_init文件后忘记
 * Created by DX on 2017/10/4.
 */

public class HookLogic implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if ("xxx.xxx.xxx".equals(loadPackageParam.packageName)){
            XposedHelpers.findAndHookMethod("xxx.xxx.xxx.xxxClass", loadPackageParam.classLoader, "xxxMethod", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult("Hook succeed");
                }
            });
        }
    }
}
