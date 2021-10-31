package jp.osaka.appppy.sample.osakacity.app.view;

import android.net.Uri;

import java.util.ArrayList;

import jp.osaka.appppy.sample.osakacity.app.model.OsakaData;

/**
 * コレクションビューのインタフェース
 *
 *  @author APPPPY
 */
public interface ICollectionView {

    /**
     * データセット変更通知
     *
     * @param arrayList コレクション
     */
    void changeAll(ArrayList<OsakaData> arrayList);

    /**
     * リスナ
     */
    interface Listener {
        /**
         * スクロール開始
         *
         * @param view コレクションビュー
         */
        void onScroll(ICollectionView view);

        /**
         * スクロール終了
         *
         * @param view コレクションビュー
         */
        void onScrollFinished(ICollectionView view);

        /**
         * 相互作用
         *
         * @param name 名前
         * @param lat 緯度
         * @param lng 経度
         */
        void onCardFragmentInteraction(String name, Double lat, Double lng);

        /**
         * 相互作用
         *
         * @param url URL
         */
        void onCardFragmentInteraction(String url);
    }
}
