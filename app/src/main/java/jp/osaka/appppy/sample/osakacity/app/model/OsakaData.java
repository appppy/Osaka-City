package jp.osaka.appppy.sample.osakacity.app.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 大阪データ
 *
 * @author APPPPY
 */
public class OsakaData implements Parcelable {
    /**
     * @serial 種類
     */
    public int type = 0;

    /**
     * @serial 区分
     */
    public String category = "";

    /**
     * @serial 距離
     */
    public double distance = 0;

    /**
     * @serial 名
     */
    public String name = "";

    /**
     * @serial 住所
     */
    public String address = "";

    /**
     * @serial 詳細
     */
    public String detail = "";

    /**
     * @serial 緯度
     */
    public double latitude = 0;

    /**
     * @serial 経度
     */
    public double longitude = 0;

    /**
     * @serial URL
     */
    public String url = "";

    /**
     * @serial 電話
     */
    public String call = "";

    /**
     * @serial 背景色
     */
    public int backgroundcolor = 0;

    /**
     * @serial 背景色
     */
    public int backgroundcolor2 = 0;

    /**
     * @serial バリアフリー
     */
    public String free_url = "";

    /**
     * @serial 駐輪場
     */
    public String parking_url = "";

    /**
     * @serial キー
     */
    public String key;

    /**
     * コンストラクタ
     */
    public OsakaData() {
    }

    /**
     * コンストラクタ
     *
     * @param parcel パーシャル
     */
    public OsakaData(Parcel parcel) {
        type = parcel.readInt();
        category = parcel.readString();
        distance = parcel.readDouble();
        name = parcel.readString();
        address = parcel.readString();
        detail = parcel.readString();
        latitude = parcel.readDouble();
        longitude = parcel.readDouble();
        url = parcel.readString();
        free_url = parcel.readString();
        call = parcel.readString();
        backgroundcolor = parcel.readInt();
        backgroundcolor2 = parcel.readInt();
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable's
     * marshalled representation.
     *
     * @return a bitmask indicating the set of special object types marshalled
     * by the Parcelable.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(type);
        dest.writeString(category);
        dest.writeDouble(distance);
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(detail);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
        dest.writeString(url);
        dest.writeString(free_url);
        dest.writeString(call);
        dest.writeInt(backgroundcolor);
        dest.writeInt(backgroundcolor2);
    }

    /**
     * @serial 作成
     */
    public static final Creator<OsakaData> CREATOR =
            new Parcelable.Creator<OsakaData>() {

                /**
                 * Parcelableクラス作成
                 * @see android.os.Parcelable.Creator#createFromParcel(android.os.Parcel)
                 */
                @Override
                public OsakaData createFromParcel(Parcel source) {
                    return new OsakaData(source);
                }

                /**
                 * 配列生成
                 * @see android.os.Parcelable.Creator#newArray(int)
                 */
                @Override
                public OsakaData[] newArray(int size) {
                    return new OsakaData[size];
                }
            };
}
