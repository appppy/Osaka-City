
package jp.osaka.appppy.sample.osakacity.app.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.Objects;

import jp.osaka.appppy.sample.osakacity.R;
import jp.osaka.appppy.sample.osakacity.app.helper.SimpleTimer;
import jp.osaka.appppy.sample.osakacity.app.helper.TimerListener;
import jp.osaka.appppy.sample.osakacity.app.model.OsakaData;
import jp.osaka.appppy.sample.osakacity.constants.PARTS;
import jp.osaka.appppy.sample.osakacity.databinding.FragmentBinding;

import static jp.osaka.appppy.sample.osakacity.app.helper.TimerHelper.createTimer;
import static jp.osaka.appppy.sample.osakacity.app.helper.TimerHelper.startTimer;
import static jp.osaka.appppy.sample.osakacity.app.helper.TimerHelper.stopTimer;
import static jp.osaka.appppy.sample.osakacity.constants.EXTRA.EXTRA_LIST;
import static jp.osaka.appppy.sample.osakacity.constants.TIMEOUT.TIMEOUT_FLOATING_ACTION_BUTTON_HIDE;

/**
 * カードフラグメント
 */
public class CardFragment extends Fragment implements
        ICollectionView,
        CardAdapter.Callbacks,
        TimerListener{

    /**
     * @serial 自身
     */
    private final CardFragment mSelf;

    /**
     * @serial アダプタ
     */
    private CardAdapter mAdapter;

    /**
     * @serial リスナ
     */
    private Listener mListener;

    /**
     * @serial フローティングアクションボタン表示タイマー
     */
    private SimpleTimer mTimer;

    /**
     * @serial ハンドラ
     */
    private final Handler mHandler = new Handler();

    /**
     * インスタンス取得
     *
     * @param collection カード
     * @return
     */
    public static CardFragment newInstance(ArrayList<OsakaData> collection) {
        // フラグメントの生成
        CardFragment fragment = new CardFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(EXTRA_LIST, collection);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * コンストラクタ
     */
    public CardFragment() {
        mSelf = this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (Listener) getActivity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // タイマ生成
        mTimer = createTimer(mTimer, TIMEOUT_FLOATING_ACTION_BUTTON_HIDE, this);
        // 再生成を抑止
        setRetainInstance(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDestroy() {
        // タイマ停止
        stopTimer(mTimer);
        super.onDestroy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment, container, false);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressLint({"SwitchIntDef", "NewApi"})
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentBinding mBinding = DataBindingUtil.bind(requireView());

        ArrayList<OsakaData> objects = requireArguments().getParcelableArrayList(EXTRA_LIST);

        // アダプタの設定
        mAdapter = new CardAdapter(getActivity(), this, objects);

        // レイアウトの設定
        StaggeredGridLayoutManager layoutManager;
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        switch(config.orientation) {
            case Configuration.ORIENTATION_PORTRAIT:
            default:
                // 縦方向
                if(isHoneycombTablet(getActivity())) {
                    layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                } else {
                    layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
                }
                break;
            case Configuration.ORIENTATION_LANDSCAPE:
                // 縦方向
                if(isHoneycombTablet(getActivity())) {
                    layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
                } else {
                    layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                }
                break;
        }
        Objects.requireNonNull(mBinding).collection.setLayoutManager(layoutManager);
        mBinding.collection.setAdapter(mAdapter);
        mBinding.collection.setItemAnimator(new DefaultItemAnimator());
        mBinding.collection.setVerticalScrollBarEnabled(false);
        mBinding.collection.setHasFixedSize(true); // RecyclerViewのサイズを維持し続ける
        mBinding.collection.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /**
             * {@inheritDoc}
             */
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                // タイマ開始
                startTimer(mTimer);
                if (mListener != null) {
                    mListener.onScroll(mSelf);
                }
            }
        });
        mBinding.collection.invalidate();
    }

    /**
     * ハニーコンボの有無
     *
     * @return  ハニーコンボの有無
     */
    @SuppressLint("ObsoleteSdkInt")
    public static boolean isHoneycomb() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    }

    /**
     * ハニーコンボタブレットの有無
     *
     * @param   context コンテキスト
     * @return  ハニーコンボタブレットの有無
     */
    public static boolean isHoneycombTablet(Context context) {
        return isHoneycomb() && (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                == Configuration.SCREENLAYOUT_SIZE_XLARGE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onItemClick(Object obj, PARTS type, int position) {
        OsakaData card = (OsakaData) obj;
        switch(type) {
            case LOCATION: {
                mListener.onCardFragmentInteraction(card.name ,card.latitude,
                        card.longitude);
                break;
            }
            case URL:
            case FREE: {
                mListener.onCardFragmentInteraction(card.url);
                break;
            }
            case CALL: {
                card.call = card.call.replaceAll("-","");
                mListener.onCardFragmentInteraction("tel:" + card.call);
                break;
            }
            case PARKING: {
                mListener.onCardFragmentInteraction(card.parking_url);
                break;
            }
            default: {
                break;
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void changeAll(ArrayList<OsakaData> collection) {
        if (mAdapter != null) {
            mAdapter.setAll(collection);
        }
    }

    /**
     * タイマー発火
     *
     * @param timer      タイマー
     * @param count      タイムアウト回数
     * @param inProgress 進行中
     */
    @Override
    public void onTimer(Object timer, int count, boolean inProgress) {
        mHandler.post(() -> {
            if (null != mListener) {
                mListener.onScrollFinished(mSelf);
            }
        });
    }
}
