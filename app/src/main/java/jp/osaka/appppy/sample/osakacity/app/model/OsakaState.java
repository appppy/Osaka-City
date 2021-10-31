package jp.osaka.appppy.sample.osakacity.app.model;

import jp.osaka.appppy.sample.osakacity.constants.LAYOUT;

/**
 * 大阪状態
 *
 *  @author APPPPY
 */
public class OsakaState {

    /**
     * @serial キー
     */
    private String mKey;

    /**
     * @serial レイアウト
     */
    private LAYOUT mLayout;

    /**
     * キー設定
     *
     * @param key キー
     */
    public void setKey(String key) {
        mKey = key;
    }

    /**
     * キー取得
     *
     * @return キー
     */
    public String getKey() {
        return mKey;
    }

    /**
     * レイアウト設定
     *
     * @param layout レイアウト
     */
    public void setLayout(LAYOUT layout) {
        mLayout = layout;
    }

    /**
     * レイアウト取得
     *
     * @return レイアウト
     */
    public LAYOUT getLayout() {
        return mLayout;
    }

}
