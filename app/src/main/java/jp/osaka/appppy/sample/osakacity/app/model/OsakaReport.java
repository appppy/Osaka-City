
package jp.osaka.appppy.sample.osakacity.app.model;

/**
 * 大阪レポート
 *
 * @author APPPPY
 */
public class OsakaReport {

    /**
     * @serial モデル
     */
    private IOsakaProperty mModel = null;

    /**
     * @serial タイトル
     */
    private String[] mTitleArray = null;

    /**
     * @serial データ
     */
    private String[] mDataArray = null;

    /**
     * 経度取得
     *
     * @return 経度
     */
    public String getLongitude() {
        if (mDataArray != null) {
            return mDataArray[0];
        } else {
            return "";
        }
    }

    /**
     * 緯度取得
     *
     * @return 緯度
     */
    public String getLatitude() {
        if (mDataArray != null) {
            return mDataArray[1];
        } else {
            return "";
        }
    }

    /**
     * 概要取得
     *
     * @return 概要
     */
    public String getSummary() {
        StringBuilder sb = new StringBuilder();
        String[] string;
        string = mDataArray;
        sb.append(string[2]);
        return sb.toString();
    }

    /**
     * 詳細取得
     *
     * @return 詳細
     */
    public String getDetail() {
        StringBuilder sb = new StringBuilder();
        int i;
        String[] string;
        string = mDataArray;
        String[] title = mTitleArray;
        for (i = 2; i < title.length; i++) {
            if (!string[i].equals("")
                    && !title[i].equals("施設名")
                    && !title[i].equals("施設名かな")
                    && !title[i].equals("施設名（施設名かな）")
                    && !title[i].equals("所在地")
                    && !title[i].equals("地区名")
                    && !title[i].equals("大分類")
                    && !title[i].equals("小分類")
                    && !title[i].equals("カテゴリ")
                    && !title[i].equals("アイコン番号")
                    && !title[i].equals("アイコン番")
                    && !title[i].equals("名称")
                    && !title[i].equals("TEL")
                    && !title[i].equals("FAX")
                    && !title[i].equals("URL")
                    && !title[i].equals("区名")
                    && !title[i].equals("バリアフリー情報")
                    && !title[i].equals("駐輪場 PC")
                    && !title[i].equals("駐輪場 携")
                    && !title[i].equals("施設ID")) {
                sb.append(title[i]);
                sb.append(" : ");
                sb.append(string[i]);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /**
     * モデル設定
     *
     * @param model モデル
     */
    public void setModel(IOsakaProperty model) {
        mModel = model;
    }

    /**
     * タイトル設定
     *
     * @param title タイトル
     */
    public void setTitle(String[] title) {
        mTitleArray = title;
    }

    /**
     * データ設定
     *
     * @param dataArray データ
     */
    public void setDataArray(String[] dataArray) {
        mDataArray = dataArray;
    }

    /**
     * キー取得
     *
     * @return キー
     */
    public Object getKey() {
        return mModel.getKey();
    }

    /**
     * ID取得
     *
     * @return ID
     */
    public int getId() {
        return mModel.getId();
    }

    /**
     * 色取得
     *
     * @param i 番号
     * @return カラー
     */
    public int getColor(int i) {
        return mModel.getColor(i);
    }

    /**
     * 駐車場取得
     *
     * @return 駐車場
     */
    public String getParking() {
        String result = "";
        int i = 0;
        for (String title : mTitleArray) {
            if(title.equals("駐輪場 携")) {
                result = mDataArray[i];
            }
            i++;
        }
        return result;
    }

    /**
     * URL取得
     *
     * @return URL
     */
    public String getUrl() {
        String result = "";
        int i = 0;
        for (String title : mTitleArray) {
            if(title.equals("URL")) {
                result = mDataArray[i];
            }
            i++;
        }
        return result;
    }

    /**
     * アドレス取得
     *
     * @return アドレス
     */
    public String getAddress() {
        String result = "";
        int i = 0;
        for (String title : mTitleArray) {
            if(title.equals("所在地")) {
                result = mDataArray[i];
            }
            i++;
        }
        return result;
    }

    /**
     * バリアフリー取得
     *
     * @return バリアフリー
     */
    public String getBarrierFree() {
        String result = "";
        int i = 0;
        for (String title : mTitleArray) {
            if(title.equals("バリアフリー情報")) {
                result = mDataArray[i];
            }
            i++;
        }
        return result;
    }

    /**
     * 電話取得
     *
     * @return 電話
     */
    public String getCall() {
        String result = "";
        int i = 0;
        for (String title : mTitleArray) {
            if(title.equals("TEL")) {
                result = mDataArray[i];
            }
            i++;
        }
        return result;
    }
}
