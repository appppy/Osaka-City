package jp.osaka.appppy.sample.osakacity.app.helper;

import android.annotation.SuppressLint;

import java.util.ArrayList;

import jp.osaka.appppy.sample.osakacity.R;
import jp.osaka.appppy.sample.osakacity.app.contents.CardAttractionsAndHistoricSitesActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.CardCultureAndTouristActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.CardDisasterForHeliportActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.CardEnvironmentAndRcyclingActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.CardFireDisasterPreventionSpeakerActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.CardFireProtectionWaterTankActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.CardHallAcitivity;
import jp.osaka.appppy.sample.osakacity.app.contents.CardHousingShelterActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.CardMainActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.CardMedicalCareAndWelfareActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.CardOtherActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.CardParkAndSportsActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.CardParkingAndBycycleParkingActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.CardPoliceAndFireActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.CardPublicOfficeActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.CardPublicToiletActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.CardSchoolAndNurseryActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.CardStationsAndBusStopActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.CardTsunamiEvacuationBuilingActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.LinearAttractionsAndHistoricSitesActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.LinearCultureAndTouristActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.LinearDisasterForHeliportActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.LinearEnvironmentAndRcyclingActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.LinearFireDisasterPreventionSpeakerActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.LinearFireProtectionWaterTankActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.LinearHallAcitivity;
import jp.osaka.appppy.sample.osakacity.app.contents.LinearHousingShelterActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.LinearMainActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.LinearMedicalCareAndWelfareActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.LinearOtherActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.LinearParkAndSportsActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.LinearParkingAndBycycleParkingActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.LinearPoliceAndFireActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.LinearPublicOfficeActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.LinearPublicToiletActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.LinearSchoolAndNurseryActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.LinearStationsAndBusStopActivity;
import jp.osaka.appppy.sample.osakacity.app.contents.LinearTsunamiEvacuationBuilingActivity;
import jp.osaka.appppy.sample.osakacity.app.model.IOsakaProperty;
import jp.osaka.appppy.sample.osakacity.app.model.category.ATTRACTIONS_AND_HISTORIC_SITES;
import jp.osaka.appppy.sample.osakacity.app.model.category.CULTURE_AND_TOURIST;
import jp.osaka.appppy.sample.osakacity.app.model.category.DISASTER_FOR_HELIPORT;
import jp.osaka.appppy.sample.osakacity.app.model.category.ENVIRONMENT_AND_RCYCLING;
import jp.osaka.appppy.sample.osakacity.app.model.category.FIRE_DISASTER_PREVENTION_SPEAKER;
import jp.osaka.appppy.sample.osakacity.app.model.category.FIRE_PROTECTION_WATER_TANK;
import jp.osaka.appppy.sample.osakacity.app.model.category.HALL;
import jp.osaka.appppy.sample.osakacity.app.model.category.HOUSING_SHELTER;
import jp.osaka.appppy.sample.osakacity.app.model.category.MEDICAL_CARE_AND_WELFARE;
import jp.osaka.appppy.sample.osakacity.app.model.category.OTHER;
import jp.osaka.appppy.sample.osakacity.app.model.category.PARKING_AND_BYCYCLE_PARKING;
import jp.osaka.appppy.sample.osakacity.app.model.category.PARK_AND_SPORTS;
import jp.osaka.appppy.sample.osakacity.app.model.category.POLICE_AND_FIRE;
import jp.osaka.appppy.sample.osakacity.app.model.category.PUBLIC_OFFICE;
import jp.osaka.appppy.sample.osakacity.app.model.category.PUBLIC_TOILET;
import jp.osaka.appppy.sample.osakacity.app.model.category.SCHOOL_AND_NURSERY;
import jp.osaka.appppy.sample.osakacity.app.model.category.STATIONS_AND_BUS_STOP;
import jp.osaka.appppy.sample.osakacity.app.model.category.TSUNAMI_EVACUATION_BUILDING;
import jp.osaka.appppy.sample.osakacity.constants.LAYOUT;

import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_ALL;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_ATTRACTIONS_AND_HISTORIC_SITES;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_CULTURE_AND_TOURIST;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_DISASTER_FOR_HELIPORT;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_ENVIRONMENT_AND_RCYCLING;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_FIRE_DISASTER_PREVENTION_SPEAKER;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_FIRE_PROTECTION_WATER_TANK;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_HALL;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_HOUSING_SHELTER;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_MEDICAL_CARE_AND_WELFARE;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_OTHER;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_PARKING_AND_BYCYCLE_PARKING;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_PARK_AND_SPORTS;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_POLICE_AND_FIRE;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_PUBLIC_OFFICE;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_PUBLIC_TOILET;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_SCHOOL_AND_NURSERY;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_STATIONS_AND_BUS_STOP;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_TSUNAMI_EVACUATION_BUILDING;

/**
 * 大阪ヘルパ
 *
 * @author APPPPY
 */
public class OsakaHelper {

    /**
     * IDをキーに変換
     *
     * @param id　ID
     * @return キー
     */
    @SuppressLint("NonConstantResourceId")
    public static String toOsakaKey(int id) {
        String key;

        switch (id) {
            case R.id.public_office: {
                key = KEY_PUBLIC_OFFICE;
                break;
            }
            case R.id.school_and_nursery: {
                key = KEY_SCHOOL_AND_NURSERY;
                break;
            }
            case R.id.park_and_sports: {
                key = KEY_PARK_AND_SPORTS;
                break;
            }
            case R.id.hall: {
                key = KEY_HALL;
                break;
            }
            case R.id.culture_and_tourist: {
                key = KEY_CULTURE_AND_TOURIST;
                break;
            }
            case R.id.police_and_fire: {
                key = KEY_POLICE_AND_FIRE;
                break;
            }
            case R.id.medical_care_and_welfare: {
                key = KEY_MEDICAL_CARE_AND_WELFARE;
                break;
            }
            case R.id.attractions_and_historic_sites: {
                key = KEY_ATTRACTIONS_AND_HISTORIC_SITES;
                break;
            }
            case R.id.stations_and_bus_stop: {
                key = KEY_STATIONS_AND_BUS_STOP;
                break;
            }
            case R.id.parking_and_bycycle_parking: {
                key = KEY_PARKING_AND_BYCYCLE_PARKING;
                break;
            }
            case R.id.public_toilet: {
                key = KEY_PUBLIC_TOILET;
                break;
            }
            case R.id.environment_and_rcycling: {
                key = KEY_ENVIRONMENT_AND_RCYCLING;
                break;
            }
            case R.id.other: {
                key = KEY_OTHER;
                break;
            }
            case R.id.housing_shelter: {
                key = KEY_HOUSING_SHELTER;
                break;
            }
            case R.id.disaster_for_heliport: {
                key = KEY_DISASTER_FOR_HELIPORT;
                break;
            }
            case R.id.fire_protection_water_tank: {
                key = KEY_FIRE_PROTECTION_WATER_TANK;
                break;
            }
            case R.id.fire_disaster_prevention_speaker: {
                key = KEY_FIRE_DISASTER_PREVENTION_SPEAKER;
                break;
            }
            case R.id.tsunami_evacuation_building: {
                key = KEY_TSUNAMI_EVACUATION_BUILDING;
                break;
            }
            default:
                key = KEY_ALL;
                break;

        }
        return key;
    }

    /**
     * キーをIDに変換
     * @param key キー
     * @return ID
     */
    public static int toOsakaId(String key) {
        int id;

        switch (key) {
            case KEY_PUBLIC_OFFICE: {
                id = R.id.public_office;
                break;
            }
            case KEY_SCHOOL_AND_NURSERY: {
                id = R.id.school_and_nursery;
                break;
            }
            case KEY_PARK_AND_SPORTS: {
                id = R.id.park_and_sports;
                break;
            }
            case KEY_HALL: {
                id = R.id.hall;
                break;
            }
            case KEY_CULTURE_AND_TOURIST: {
                id = R.id.culture_and_tourist;
                break;
            }
            case KEY_POLICE_AND_FIRE: {
                id = R.id.police_and_fire;
                break;
            }
            case KEY_MEDICAL_CARE_AND_WELFARE: {
                id = R.id.medical_care_and_welfare;
                break;
            }
            case KEY_ATTRACTIONS_AND_HISTORIC_SITES: {
                id = R.id.attractions_and_historic_sites;
                break;
            }
            case KEY_STATIONS_AND_BUS_STOP: {
                id = R.id.stations_and_bus_stop;
                break;
            }
            case KEY_PARKING_AND_BYCYCLE_PARKING: {
                id = R.id.parking_and_bycycle_parking;
                break;
            }
            case KEY_PUBLIC_TOILET: {
                id = R.id.public_toilet;
                break;
            }
            case KEY_ENVIRONMENT_AND_RCYCLING: {
                id = R.id.environment_and_rcycling;
                break;
            }
            case KEY_OTHER: {
                id = R.id.other;
                break;
            }
            case KEY_HOUSING_SHELTER: {
                id = R.id.housing_shelter;
                break;
            }
            case KEY_DISASTER_FOR_HELIPORT: {
                id = R.id.disaster_for_heliport;
                break;
            }
            case KEY_FIRE_PROTECTION_WATER_TANK: {
                id = R.id.fire_protection_water_tank;
                break;
            }
            case KEY_FIRE_DISASTER_PREVENTION_SPEAKER: {
                id = R.id.fire_disaster_prevention_speaker;
                break;
            }
            case KEY_TSUNAMI_EVACUATION_BUILDING: {
                id = R.id.tsunami_evacuation_building;
                break;
            }
            default:
                id = R.id.all;
                break;

        }
        return id;
    }

    /**
     * キーから番号に変換
     *
     * @param key キー
     * @return 番号
     */
    public static int toOsakaIndex(String key) {
        int index;

        switch (key) {
            case KEY_PUBLIC_OFFICE: {
                index = 1;
                break;
            }
            case KEY_SCHOOL_AND_NURSERY: {
                index = 2;
                break;
            }
            case KEY_PARK_AND_SPORTS: {
                index = 3;
                break;
            }
            case KEY_HALL: {
                index = 4;
                break;
            }
            case KEY_CULTURE_AND_TOURIST: {
                index = 5;
                break;
            }
            case KEY_POLICE_AND_FIRE: {
                index = 6;
                break;
            }
            case KEY_MEDICAL_CARE_AND_WELFARE: {
                index = 7;
                break;
            }
            case KEY_ATTRACTIONS_AND_HISTORIC_SITES: {
                index = 8;
                break;
            }
            case KEY_STATIONS_AND_BUS_STOP: {
                index = 9;
                break;
            }
            case KEY_PARKING_AND_BYCYCLE_PARKING: {
                index = 10;
                break;
            }
            case KEY_PUBLIC_TOILET: {
                index = 11;
                break;
            }
            case KEY_ENVIRONMENT_AND_RCYCLING: {
                index = 12;
                break;
            }
            case KEY_OTHER: {
                index = 13;
                break;
            }
            case KEY_HOUSING_SHELTER: {
                index = 14;
                break;
            }
            case KEY_DISASTER_FOR_HELIPORT: {
                index = 15;
                break;
            }
            case KEY_FIRE_PROTECTION_WATER_TANK: {
                index = 16;
                break;
            }
            case KEY_FIRE_DISASTER_PREVENTION_SPEAKER: {
                index = 17;
                break;
            }
            case KEY_TSUNAMI_EVACUATION_BUILDING: {
                index = 18;
                break;
            }
            default:
                index = 0;
                break;

        }
        return index;
    }

    /**
     * 開始アクティビティ取得
     *
     * @param layout レイアウト種類
     * @param id ID
     * @return アクティビティ
     */
    public static Class<?> getStartActivity(LAYOUT layout, int id) {
        Class<?> c;
        if (layout == LAYOUT.LINEAR) {
            c = getStartCardActivity(id);
        } else {
            c = getStartLinearActivity(id);
        }
        return c;
    }

    /**
     * 開始アクティビティの取得
     *
     * @return 開始アクティビティ
     */
    @SuppressLint("NonConstantResourceId")
    private static Class<?> getStartLinearActivity(int id) {
        Class<?> c = LinearMainActivity.class;

        switch (id) {
            case R.id.public_office: {
                c = LinearPublicOfficeActivity.class;
                break;
            }
            case R.id.school_and_nursery: {
                c = LinearSchoolAndNurseryActivity.class;
                break;
            }
            case R.id.park_and_sports: {
                c = LinearParkAndSportsActivity.class;
                break;
            }
            case R.id.hall: {
                c = LinearHallAcitivity.class;
                break;
            }
            case R.id.culture_and_tourist: {
                c = LinearCultureAndTouristActivity.class;
                break;
            }
            case R.id.police_and_fire: {
                c = LinearPoliceAndFireActivity.class;
                break;
            }
            case R.id.medical_care_and_welfare: {
                c = LinearMedicalCareAndWelfareActivity.class;
                break;
            }
            case R.id.attractions_and_historic_sites: {
                c = LinearAttractionsAndHistoricSitesActivity.class;
                break;
            }
            case R.id.stations_and_bus_stop: {
                c = LinearStationsAndBusStopActivity.class;
                break;
            }
            case R.id.parking_and_bycycle_parking: {
                c = LinearParkingAndBycycleParkingActivity.class;
                break;
            }
            case R.id.public_toilet: {
                c = LinearPublicToiletActivity.class;
                break;
            }
            case R.id.environment_and_rcycling: {
                c = LinearEnvironmentAndRcyclingActivity.class;
                break;
            }
            case R.id.other: {
                c = LinearOtherActivity.class;
                break;
            }
            case R.id.housing_shelter: {
                c = LinearHousingShelterActivity.class;
                break;
            }
            case R.id.disaster_for_heliport: {
                c = LinearDisasterForHeliportActivity.class;
                break;
            }
            case R.id.fire_protection_water_tank: {
                c = LinearFireProtectionWaterTankActivity.class;
                break;
            }
            case R.id.fire_disaster_prevention_speaker: {
                c = LinearFireDisasterPreventionSpeakerActivity.class;
                break;
            }
            case R.id.tsunami_evacuation_building: {
                c = LinearTsunamiEvacuationBuilingActivity.class;
                break;
            }
            default:
                break;
        }
        return c;
    }

    /**
     * 開始アクティビティの取得
     *
     * @return 開始アクティビティ
     */
    @SuppressLint("NonConstantResourceId")
    private static Class<?> getStartCardActivity(int id) {
        Class<?> c = CardMainActivity.class;

        switch (id) {
            case R.id.public_office: {
                c = CardPublicOfficeActivity.class;
                break;
            }
            case R.id.school_and_nursery: {
                c = CardSchoolAndNurseryActivity.class;
                break;
            }
            case R.id.park_and_sports: {
                c = CardParkAndSportsActivity.class;
                break;
            }
            case R.id.hall: {
                c = CardHallAcitivity.class;
                break;
            }
            case R.id.culture_and_tourist: {
                c = CardCultureAndTouristActivity.class;
                break;
            }
            case R.id.police_and_fire: {
                c = CardPoliceAndFireActivity.class;
                break;
            }
            case R.id.medical_care_and_welfare: {
                c = CardMedicalCareAndWelfareActivity.class;
                break;
            }
            case R.id.attractions_and_historic_sites: {
                c = CardAttractionsAndHistoricSitesActivity.class;
                break;
            }
            case R.id.stations_and_bus_stop: {
                c = CardStationsAndBusStopActivity.class;
                break;
            }
            case R.id.parking_and_bycycle_parking: {
                c = CardParkingAndBycycleParkingActivity.class;
                break;
            }
            case R.id.public_toilet: {
                c = CardPublicToiletActivity.class;
                break;
            }
            case R.id.environment_and_rcycling: {
                c = CardEnvironmentAndRcyclingActivity.class;
                break;
            }
            case R.id.other: {
                c = CardOtherActivity.class;
                break;
            }
            case R.id.housing_shelter: {
                c = CardHousingShelterActivity.class;
                break;
            }
            case R.id.disaster_for_heliport: {
                c = CardDisasterForHeliportActivity.class;
                break;
            }
            case R.id.fire_protection_water_tank: {
                c = CardFireProtectionWaterTankActivity.class;
                break;
            }
            case R.id.fire_disaster_prevention_speaker: {
                c = CardFireDisasterPreventionSpeakerActivity.class;
                break;
            }
            case R.id.tsunami_evacuation_building: {
                c = CardTsunamiEvacuationBuilingActivity.class;
                break;
            }
            default:
                break;
        }
        return c;
    }

    public static int getOsakaTheme(LAYOUT layout, String key) {
        int id;
        if (layout == LAYOUT.LINEAR) {
            id = getLinearOsakaTheme(key);
        } else {
            id = getCardOsakaTheme(key);
        }
        return id;
    }

    /**
     * 開始アクティビティの取得
     *
     * @param key キー
     * @return テーマ
     */
    private static int getCardOsakaTheme(String key) {
        int id = R.style.AppTheme_CARD;

        switch (key) {
            case KEY_PUBLIC_OFFICE: {
                id = R.style.AppTheme_Red;
                break;
            }
            case KEY_SCHOOL_AND_NURSERY: {
                id = R.style.AppTheme_Pink;
                break;
            }
            case KEY_PARK_AND_SPORTS: {
                id = R.style.AppTheme_Purple;
                break;
            }
            case KEY_HALL: {
                id = R.style.AppTheme_Indigo;
                break;
            }
            case KEY_CULTURE_AND_TOURIST: {
                id = R.style.AppTheme_Blue;
                break;
            }
            case KEY_POLICE_AND_FIRE: {
                id = R.style.AppTheme_LightBlue;
                break;
            }
            case KEY_MEDICAL_CARE_AND_WELFARE: {
                id = R.style.AppTheme_Cyan;
                break;
            }
            case KEY_ATTRACTIONS_AND_HISTORIC_SITES: {
                id = R.style.AppTheme_Teal;
                break;
            }
            case KEY_STATIONS_AND_BUS_STOP: {
                id = R.style.AppTheme_Green;
                break;
            }
            case KEY_PARKING_AND_BYCYCLE_PARKING: {
                id = R.style.AppTheme_LightGreen;
                break;
            }
            case KEY_PUBLIC_TOILET: {
                id = R.style.AppTheme_Lime;
                break;
            }
            case KEY_ENVIRONMENT_AND_RCYCLING: {
                id = R.style.AppTheme_Yellow;
                break;
            }
            case KEY_OTHER: {
                id = R.style.AppTheme_Amber;
                break;
            }
            case KEY_HOUSING_SHELTER: {
                id = R.style.AppTheme_Orange;
                break;
            }
            case KEY_DISASTER_FOR_HELIPORT: {
                id = R.style.AppTheme_DeepOrange;
                break;
            }
            case KEY_FIRE_PROTECTION_WATER_TANK: {
                id = R.style.AppTheme_Brown;
                break;
            }
            case KEY_FIRE_DISASTER_PREVENTION_SPEAKER: {
                id = R.style.AppTheme_BlueGrey;
                break;
            }
            case KEY_TSUNAMI_EVACUATION_BUILDING: {
                id = R.style.AppTheme_Grey;
                break;
            }
            default:
                break;

        }
        return id;
    }

    /**
     * 色の取得
     *
     * @param key キー
     * @return 色
     */
    public static int getOsakaColor(String key) {
        int id = R.color.grey_500;

        switch (key) {
            case KEY_PUBLIC_OFFICE: {
                id = R.color.teal_500;
                break;
            }
            case KEY_SCHOOL_AND_NURSERY: {
                id = R.color.lime_500;
                break;
            }
            case KEY_PARK_AND_SPORTS: {
                id = R.color.light_green_500;
                break;
            }
            case KEY_HALL: {
                id = R.color.amber_500;
                break;
            }
            case KEY_CULTURE_AND_TOURIST: {
                id = R.color.orange_500;
                break;
            }
            case KEY_POLICE_AND_FIRE: {
                id = R.color.blue_grey_500;
                break;
            }
            case KEY_MEDICAL_CARE_AND_WELFARE: {
                id = R.color.deep_orange_500;
                break;
            }
            case KEY_ATTRACTIONS_AND_HISTORIC_SITES: {
                id = R.color.red_500;
                break;
            }
            case KEY_STATIONS_AND_BUS_STOP: {
                id = R.color.brown_500;
                break;
            }
            case KEY_PARKING_AND_BYCYCLE_PARKING: {
                id = R.color.purple_500;
                break;
            }
            case KEY_PUBLIC_TOILET: {
                id = R.color.pink_500;
                break;
            }
            case KEY_ENVIRONMENT_AND_RCYCLING: {
                id = R.color.indigo_500;
                break;
            }
            case KEY_OTHER: {
                id = R.color.deep_purple_500;
                break;
            }
            case KEY_HOUSING_SHELTER: {
                id = R.color.blue_500;
                break;
            }
            case KEY_DISASTER_FOR_HELIPORT: {
                id = R.color.cyan_500;
                break;
            }
            case KEY_FIRE_PROTECTION_WATER_TANK: {
                id = R.color.green_500;
                break;
            }
            case KEY_FIRE_DISASTER_PREVENTION_SPEAKER: {
                id = R.color.light_blue_500;
                break;
            }
            case KEY_TSUNAMI_EVACUATION_BUILDING: {
                id = R.color.grey_500;
                break;
            }
            default:
                break;

        }
        return id;
    }


    /**
     * 開始アクティビティの取得
     *
     * @param key キー
     * @return テーマ
     */
    private static int getLinearOsakaTheme(String key) {
        int id = R.style.AppTheme_LINEAR;

        switch (key) {
            case KEY_PUBLIC_OFFICE: {
                id = R.style.AppTheme_Teal;
                break;
            }
            case KEY_SCHOOL_AND_NURSERY: {
                id = R.style.AppTheme_Lime;
                break;
            }
            case KEY_PARK_AND_SPORTS: {
                id = R.style.AppTheme_LightGreen;
                break;
            }
            case KEY_HALL: {
                id = R.style.AppTheme_Amber;
                break;
            }
            case KEY_CULTURE_AND_TOURIST: {
                id = R.style.AppTheme_Orange;
                break;
            }
            case KEY_POLICE_AND_FIRE: {
                id = R.style.AppTheme_BlueGrey;
                break;
            }
            case KEY_MEDICAL_CARE_AND_WELFARE: {
                id = R.style.AppTheme_DeepOrange;
                break;
            }
            case KEY_ATTRACTIONS_AND_HISTORIC_SITES: {
                id = R.style.AppTheme_Red;
                break;
            }
            case KEY_STATIONS_AND_BUS_STOP: {
                id = R.style.AppTheme_Brown;
                break;
            }
            case KEY_PARKING_AND_BYCYCLE_PARKING: {
                id = R.style.AppTheme_Purple;
                break;
            }
            case KEY_PUBLIC_TOILET: {
                id = R.style.AppTheme_Pink;
                break;
            }
            case KEY_ENVIRONMENT_AND_RCYCLING: {
                id = R.style.AppTheme_Indigo;
                break;
            }
            case KEY_OTHER: {
                id = R.style.AppTheme_DeepPurple;
                break;
            }
            case KEY_HOUSING_SHELTER: {
                id = R.style.AppTheme_Blue;
                break;
            }
            case KEY_DISASTER_FOR_HELIPORT: {
                id = R.style.AppTheme_Cyan;
                break;
            }
            case KEY_FIRE_PROTECTION_WATER_TANK: {
                id = R.style.AppTheme_Green;
                break;
            }
            case KEY_FIRE_DISASTER_PREVENTION_SPEAKER: {
                id = R.style.AppTheme_LightBlue;
                break;
            }
            case KEY_TSUNAMI_EVACUATION_BUILDING: {
                id = R.style.AppTheme_Grey;
                break;
            }
            default:
                break;

        }
        return id;
    }


    /**
     * 開始アクティビティの取得
     *
     * @param key キー
     * @return テーマ
     */
    public static ArrayList<IOsakaProperty> getOsakaPropeties(String key) {
        ArrayList<IOsakaProperty> properties = new ArrayList<>();

        switch (key) {
            // 1
            case KEY_PUBLIC_OFFICE: {
                properties.add(new PUBLIC_OFFICE());
                break;
            }
            // 2
            case KEY_SCHOOL_AND_NURSERY: {
                properties.add(new SCHOOL_AND_NURSERY());
                break;
            }
            // 3
            case KEY_PARK_AND_SPORTS: {
                properties.add(new PARK_AND_SPORTS());
                break;
            }
            // 4
            case KEY_HALL: {
                properties.add(new HALL());
                break;
            }
            // 5
            case KEY_CULTURE_AND_TOURIST: {
                properties.add(new CULTURE_AND_TOURIST());
                break;
            }
            // 6
            case KEY_POLICE_AND_FIRE: {
                properties.add(new POLICE_AND_FIRE());
                break;
            }
            // 7
            case KEY_MEDICAL_CARE_AND_WELFARE: {
                properties.add(new MEDICAL_CARE_AND_WELFARE());
                break;
            }
            // 8
            case KEY_ATTRACTIONS_AND_HISTORIC_SITES: {
                properties.add(new ATTRACTIONS_AND_HISTORIC_SITES());
                break;
            }
            // 9
            case KEY_STATIONS_AND_BUS_STOP: {
                properties.add(new STATIONS_AND_BUS_STOP());
                break;
            }
            // 10
            case KEY_PARKING_AND_BYCYCLE_PARKING: {
                properties.add(new PARKING_AND_BYCYCLE_PARKING());
                break;
            }
            // 11
            case KEY_PUBLIC_TOILET: {
                properties.add(new PUBLIC_TOILET());
                break;
            }
            // 12
            case KEY_ENVIRONMENT_AND_RCYCLING: {
                properties.add(new ENVIRONMENT_AND_RCYCLING());
                break;
            }
            // 13
            case KEY_OTHER: {
                properties.add(new OTHER());
                break;
            }
            // 14
            case KEY_HOUSING_SHELTER: {
                properties.add(new HOUSING_SHELTER());
                break;
            }
            // 15
            case KEY_DISASTER_FOR_HELIPORT: {
                properties.add(new DISASTER_FOR_HELIPORT());
                break;
            }
            // 16
            case KEY_FIRE_PROTECTION_WATER_TANK: {
                properties.add(new FIRE_PROTECTION_WATER_TANK());
                break;
            }
            // 17
            case KEY_FIRE_DISASTER_PREVENTION_SPEAKER: {
                properties.add(new FIRE_DISASTER_PREVENTION_SPEAKER());

                break;
            }
            // 18
            case KEY_TSUNAMI_EVACUATION_BUILDING: {
                properties.add(new TSUNAMI_EVACUATION_BUILDING());
                break;
            }
            default: {
                properties.add(new PUBLIC_OFFICE());
                properties.add(new SCHOOL_AND_NURSERY());
                properties.add(new PARK_AND_SPORTS());
                properties.add(new HALL());
                properties.add(new CULTURE_AND_TOURIST());
                properties.add(new POLICE_AND_FIRE());
                properties.add(new MEDICAL_CARE_AND_WELFARE());
                properties.add(new ATTRACTIONS_AND_HISTORIC_SITES());
                properties.add(new STATIONS_AND_BUS_STOP());
                properties.add(new PARKING_AND_BYCYCLE_PARKING());
                properties.add(new PUBLIC_TOILET());
                properties.add(new ENVIRONMENT_AND_RCYCLING());
                properties.add(new OTHER());
                properties.add(new HOUSING_SHELTER());
                properties.add(new DISASTER_FOR_HELIPORT());
                properties.add(new FIRE_PROTECTION_WATER_TANK());
                properties.add(new FIRE_DISASTER_PREVENTION_SPEAKER());
                properties.add(new TSUNAMI_EVACUATION_BUILDING());
                break;
            }
        }
        return properties;
    }


    /**
     * 開始アクティビティの取得
     *
     * @param key キー
     * @return テーマ
     */
    public static int getOsakaIcon(String key) {
        int id = R.drawable.ic_group_work_black_24dp;

        switch (key) {
            case KEY_PUBLIC_OFFICE: {
                id = R.drawable.ic_location_city_black_24dp;
                break;
            }
            case KEY_SCHOOL_AND_NURSERY: {
                id = R.drawable.ic_school_black_24dp;
                break;
            }
            case KEY_PARK_AND_SPORTS: {
                id = R.drawable.ic_local_florist_black_24dp;
                break;
            }
            case KEY_HALL: {
                id = R.drawable.ic_event_seat_black_24dp;
                break;
            }
            case KEY_CULTURE_AND_TOURIST: {
                id = R.drawable.ic_camera_alt_black_24dp;
                break;
            }
            case KEY_POLICE_AND_FIRE: {
                id = R.drawable.ic_star_black_24dp;
                break;
            }
            case KEY_MEDICAL_CARE_AND_WELFARE: {
                id = R.drawable.ic_local_hospital_black_24dp;
                break;
            }
            case KEY_ATTRACTIONS_AND_HISTORIC_SITES: {
                id = R.drawable.ic_account_balance_black_24dp;
                break;
            }
            case KEY_STATIONS_AND_BUS_STOP: {
                id = R.drawable.ic_train_black_24dp;
                break;
            }
            case KEY_PARKING_AND_BYCYCLE_PARKING: {
                id = R.drawable.ic_local_parking_black_24dp;
                break;
            }
            case KEY_PUBLIC_TOILET: {
                id = R.drawable.ic_wc_black_24dp;
                break;
            }
            case KEY_ENVIRONMENT_AND_RCYCLING: {
                id = R.drawable.ic_nature_black_24dp;
                break;
            }
            case KEY_OTHER: {
                id = R.drawable.ic_apps_black_24dp;
                break;
            }
            case KEY_HOUSING_SHELTER: {
                id = R.drawable.ic_directions_run_black_24dp;
                break;
            }
            case KEY_DISASTER_FOR_HELIPORT: {
                id = R.drawable.ic_h_24dp;
                break;
            }
            case KEY_FIRE_PROTECTION_WATER_TANK: {
                id = R.drawable.ic_blur_circular_black_24dp;
                break;
            }
            case KEY_FIRE_DISASTER_PREVENTION_SPEAKER: {
                id = R.drawable.ic_volume_up_black_24dp;
                break;
            }
            case KEY_TSUNAMI_EVACUATION_BUILDING: {
                id = R.drawable.ic_business_black_24dp;
                break;
            }
            default:
                break;

        }
        return id;
    }
}
