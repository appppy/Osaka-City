package jp.osaka.appppy.sample.osakacity.app.model;

/**
 * モデルインタフェース
 *
 * @author APPPPY
 */
public interface IOsakaProperty {
    /**
     * キーの取得
     *
     * @return キー
     */
    String getKey();

    /**
     * IDの取得
     *
     * @return ID
     */
    int getId();

    /**
     * URLの取得
     *
     * @return URL
     */
    String getUrl();

    /**
     * 色の取得
     *
     * @param number 番号
     * @return 色
     */
    int getColor(int number);

}
