
package jp.osaka.appppy.sample.osakacity.app.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_ATTRACTIONS_AND_HISTORIC_SITES;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_DISASTER_FOR_HELIPORT;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_ENVIRONMENT_AND_RCYCLING;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_FIRE_DISASTER_PREVENTION_SPEAKER;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_FIRE_PROTECTION_WATER_TANK;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_HALL;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_HOUSING_SHELTER;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_OTHER;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_PARK_AND_SPORTS;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_PUBLIC_OFFICE;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_SCHOOL_AND_NURSERY;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_TSUNAMI_EVACUATION_BUILDING;

/**
 * 設定ヘルパ
 *
 *  @author APPPPY
 */
public class SettingsHelper {

    /**
     * @serial コンテキスト
     */
    @SuppressLint("StaticFieldLeak")
    private static Context sContext = null;

    /**
     * @serial 自身
     */
    @SuppressLint("StaticFieldLeak")
    static private SettingsHelper sSelf;

    /**
     * インスタンス取得
     *
     * @param context コンテキスト
     * @return インスタンス
     */
    public static SettingsHelper getInstance(Context context) {
        if (sSelf == null) {
            sSelf = new SettingsHelper(context);
        }
        return sSelf;
    }

    /**
     * コンストラクタ
     *
     * @param context コンテキスト
     */
    private SettingsHelper(Context context) {
        sContext = context;
    }
    
    /**
     * 設定の取得
     *
     * @param key キー
     * @return 設定値
     */
    public boolean read(String key) {
        boolean defvalue = true;
        if (       key.equals(KEY_PUBLIC_OFFICE)
                || key.equals(KEY_SCHOOL_AND_NURSERY)
                || key.equals(KEY_PARK_AND_SPORTS)
                || key.equals(KEY_HALL)
                || key.equals(KEY_ATTRACTIONS_AND_HISTORIC_SITES)
                || key.equals(KEY_ENVIRONMENT_AND_RCYCLING)
                || key.equals(KEY_OTHER)
                || key.equals(KEY_HOUSING_SHELTER)
                || key.equals(KEY_DISASTER_FOR_HELIPORT)
                || key.equals(KEY_FIRE_PROTECTION_WATER_TANK)
                || key.equals(KEY_FIRE_DISASTER_PREVENTION_SPEAKER)
                || key.equals(KEY_TSUNAMI_EVACUATION_BUILDING)
                ) {
            defvalue = false;
        }
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(sContext);
        return sharedPreferences.getBoolean(key, defvalue);
    }
}
