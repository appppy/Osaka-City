package jp.osaka.appppy.sample.osakacity.app.helper;

/**
 * タイマリスナ
 *
 *  @author APPPPY
 */
public interface TimerListener {

    /**
     * タイマ発火
     *
     * @param timer タイマ
     * @param count タイムアウト回数
     * @param inProgress 進行中
     */
    void onTimer(final Object timer, final int count, final boolean inProgress);
}
