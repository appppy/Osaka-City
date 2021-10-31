
package jp.osaka.appppy.sample.osakacity.app.view;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;

import java.util.ArrayList;

import jp.osaka.appppy.sample.osakacity.R;
import jp.osaka.appppy.sample.osakacity.app.MainActivity;
import jp.osaka.appppy.sample.osakacity.app.model.OsakaData;

import static jp.osaka.appppy.sample.osakacity.Config.LOG_D;

/**
 * 大阪表現者
 */
public class OsakaPresenter extends HandlerThread {
    /**
     * @serial カード表示開始メッセージ定義
     */
    public static final int WHAT_START_CARD = 0;

    /**
     * @serial リスト表示開始メッセージ定義
     */
    public static final int WHAT_START_LINEAR = 1;

    /**
     * @serial アクションバー更新メッセージ定義
     */
    public static final int WHAT_UPDATE_ACTION_BAR = 2;

    /**
     * @serial カード更新メッセージ定義
     */
    public static final int WHAT_UPDATE_CARD = 3;

    /**
     * @serial リスト更新メッセージ定義
     */
    public static final int WHAT_UPDATE_LINEAR = 4;

    /**
     * @serial ハンドラ
     */
    private Handler mHandler;

    /**
     * @serial アクティビティ
     */
    private final MainActivity mParent;

    /**
     * @serial データ
     */
    private static final SparseArray<String> mArray;

    /**
     * @serial 動作状態
     */
    public boolean isActive = false;

    /**
     * @serial カードフラグメント
     */
    public CardFragment cardFragment;

    /**
     * @serial リストフラグメント
     */
    public LineFragment lineFragment;

    static {
        mArray = new SparseArray<>();
        mArray.put(WHAT_START_CARD, "カード開始");
        mArray.put(WHAT_START_LINEAR, "リスト開始");
        mArray.put(WHAT_UPDATE_ACTION_BAR, "アクションバー更新");
        mArray.put(WHAT_UPDATE_CARD, "カード更新");
        mArray.put(WHAT_UPDATE_LINEAR, "リスト更新");
    }

    /**
     * コンストラクタ
     *
     * @param parent アクティビティ
     */
    public OsakaPresenter(MainActivity parent) {
        super(OsakaPresenter.class.getSimpleName());
        mParent = parent;
    }

    /**
     * ハンドラを取得
     */
    public Handler getHandler() {
        return mHandler;
    }

    /**
     * 開始
     */
    @SuppressWarnings("unchecked")
    @SuppressLint("HandlerLeak")
    @Override
    public void start() {
        super.start();
        isActive = true;
        mHandler = new Handler() {
            /**
             * {@inheritDoc}
             */
            @SuppressLint("NewApi")
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what) {
                    case WHAT_START_CARD: {
                        if(LOG_D) {
                            Log.d("OsakaCity","OsakaPresenter/handleMessage WHAT_START_CARD");
                        }
                        cardFragment = CardFragment.newInstance(new ArrayList<>());
                        mParent.getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment_container,
                                        cardFragment,
                                        "CardFragment")
                                .commit();
                        break;
                    }
                    case WHAT_START_LINEAR: {
                        if(LOG_D) {
                            Log.d("OsakaCity","OsakaPresenter/handleMessage WHAT_START_LINEAR");
                        }
                        lineFragment = LineFragment.newInstance(new ArrayList<>());
                        mParent.getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment_container,
                                        lineFragment,
                                        "LinerFragment")
                                .commit();
                        break;
                    }
                    case WHAT_UPDATE_ACTION_BAR: {
                        if(LOG_D) {
                            Log.d("OsakaCity","OsakaPresenter/handleMessage WHAT_UPDATE_ACTION_BAR");
                        }
                        ActionBar bar = mParent.getSupportActionBar();
                        if (null != bar) {
                            bar.setTitle(mParent.getSupportActionBar().getTitle() + " " + msg.obj);
                        }
                        break;
                    }
                    case WHAT_UPDATE_CARD: {
                        if(LOG_D) {
                            Log.d("OsakaCity","OsakaPresenter/handleMessage WHAT_UPDATE_CARD");
                        }
                        ArrayList<OsakaData> list = (ArrayList<OsakaData>) msg.obj;
                        if(LOG_D) {
                            Log.d("OsakaCity","size:" + list.size());
                        }
                        cardFragment.changeAll(list);
                        ProgressBar bar = mParent.findViewById(R.id.product_image_loading);
                        if (bar != null) {
                            bar.setVisibility(View.GONE);
                        }
                        ImageView emptyView = mParent.findViewById(R.id.empty_view);
                        if(emptyView != null) {
                            if (list.isEmpty()) {
                                emptyView.setVisibility(View.VISIBLE);
                            } else {
                                emptyView.setVisibility(View.GONE);
                            }
                        }
                        break;
                    }
                    case WHAT_UPDATE_LINEAR: {
                        if(LOG_D) {
                            Log.d("OsakaCity","OsakaPresenter/handleMessage WHAT_UPDATE_LINEAR");
                        }
                        ArrayList<OsakaData> list = (ArrayList<OsakaData>) msg.obj;
                        if(LOG_D) {
                            Log.d("OsakaCity","size:" + list.size());
                        }
                        lineFragment.changeAll(list);
                        ProgressBar bar = mParent.findViewById(R.id.product_image_loading);
                        if (bar != null) {
                            bar.setVisibility(View.GONE);
                        }
                        ImageView emptyView = mParent.findViewById(R.id.empty_view);
                        if(emptyView != null) {
                            if (list.isEmpty()) {
                                emptyView.setVisibility(View.VISIBLE);
                            } else {
                                emptyView.setVisibility(View.GONE);
                            }
                        }
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        };
    }
}
