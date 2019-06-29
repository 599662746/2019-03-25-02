package com.lenovo.test.util;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class Util {

    public static String urlHttp;
    public static String urlPort ;

    /**
     * 描述：保存数据到SharedPreferences对象中
     * @param ipUrl
     * @param ipPort
     */

    public static void saveSetting(String ipUrl, String ipPort, Context context) {
        SharedPreferences spSettingSave = context.getSharedPreferences("setting", MODE_PRIVATE);// 将需要记录的数据保存在setting.xml文件中
        SharedPreferences.Editor editor = spSettingSave.edit();
        editor.putString("ipUrl", ipUrl);
        editor.putString("ipPort", ipPort);
        editor.commit();
    }

    /**
     * 描述：获取数据到SharedPreferences对象中
     * @return
     */
    public static UrlBean loadSetting(Context context) {
        UrlBean urlBean=new UrlBean();

        SharedPreferences loadSettingLoad = context.getSharedPreferences("setting", MODE_PRIVATE);
        //这里是将setting.xml 中的数据读出来
        urlBean.setUrl( loadSettingLoad.getString("ipUrl", "") );
        urlBean.setPort( loadSettingLoad.getString("ipPort", "") );

//        String urlSetting = "http://" + urlHttp+ ":" + urlPort + "/";
        return urlBean;
    }
}
