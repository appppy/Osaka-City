package jp.osaka.appppy.sample.osakacity.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import jp.osaka.appppy.sample.osakacity.R;
import jp.osaka.appppy.sample.osakacity.app.helper.SettingsHelper;
import jp.osaka.appppy.sample.osakacity.app.model.OsakaReport;
import jp.osaka.appppy.sample.osakacity.app.model.IOsakaProperty;
import jp.osaka.appppy.sample.osakacity.app.model.OsakaData;
import jp.osaka.appppy.sample.osakacity.app.model.OsakaState;
import jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst;
import jp.osaka.appppy.sample.osakacity.app.view.BaseActivity;
import jp.osaka.appppy.sample.osakacity.app.view.ICollectionView;
import jp.osaka.appppy.sample.osakacity.app.view.OsakaPresenter;
import jp.osaka.appppy.sample.osakacity.constants.LAYOUT;
import jp.osaka.appppy.sample.osakacity.databinding.ActivityMainBinding;

import static jp.osaka.appppy.sample.osakacity.Config.LOG_D;
import static jp.osaka.appppy.sample.osakacity.app.helper.OsakaHelper.getOsakaPropeties;
import static jp.osaka.appppy.sample.osakacity.app.helper.OsakaHelper.getOsakaTheme;
import static jp.osaka.appppy.sample.osakacity.app.helper.OsakaHelper.getStartActivity;
import static jp.osaka.appppy.sample.osakacity.app.helper.OsakaHelper.toOsakaId;
import static jp.osaka.appppy.sample.osakacity.app.helper.OsakaHelper.toOsakaIndex;
import static jp.osaka.appppy.sample.osakacity.app.helper.OsakaHelper.toOsakaKey;
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
import static jp.osaka.appppy.sample.osakacity.constants.EXTRA.EXTRA_CONTENT;
import static jp.osaka.appppy.sample.osakacity.constants.EXTRA.EXTRA_LAYOUT;
import static jp.osaka.appppy.sample.osakacity.constants.LAYOUT.CARD;
import static jp.osaka.appppy.sample.osakacity.constants.LAYOUT.LINEAR;

/**
 * メインアクティビティ
 *
 * @author APPPPY
 */
public class MainActivity extends BaseActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        View.OnClickListener,
        DrawerLayout.DrawerListener,
        ICollectionView.Listener {

    /**
     * @serial 自身
     */
    private MainActivity mSelf;

    /**
     * @serial バインディング
     */
    private ActivityMainBinding mBinding;

    /**
     * @serial プレゼンタ
     */
    private OsakaPresenter mPresenter;

    /**
     * @serial タスク
     */
    private AsyncAppTask mTask;

    /**
     * @serial プリファレンス
     */
    private SharedPreferences mPref;

    /**
     * @serial トグル
     */
    private ActionBarDrawerToggle mToggle;

    /**
     * @serial 状態
     */
    private final OsakaState mState = new OsakaState();

    /**
     * @serial データ
     */
    private final ArrayList<OsakaReport> mList = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 自身の取得
        mSelf = this;

        // プリファレンスの設定
        mPref = PreferenceManager.getDefaultSharedPreferences(this);

        // 状態の取得
        mState.setKey(mPref.getString(EXTRA_CONTENT, KEY_ALL));
        mState.setLayout(LAYOUT.valueOf(mPref.getString(EXTRA_LAYOUT, LINEAR.name())));

        // テーマ設定
        setTheme(getOsakaTheme(mState.getLayout(), mState.getKey()));

        // レイアウト設定
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // ツールバーの設定
        setSupportActionBar(mBinding.toolbar);

        // フローティングアクションボタンの設定
        setupFloatingActionButton();

        // ナビゲーションドロワーの生成
        enableNavigationDrawer();

        // 空ビューの設定
        setupEmptyView();

        // 表示制御の生成
        mPresenter = new OsakaPresenter(this);
    }

    /**
     * 空ビュー設定
     */
    private void setupEmptyView() {
        if (mState.getLayout() == LINEAR) {
            mBinding.emptyView.setImageResource(R.drawable.ic_view_list_black_100dp);
        } else {
            mBinding.emptyView.setImageResource(R.drawable.ic_view_module_black_100dp);
        }
    }

    /**
     * 編集アクティビティの開始
     *
     * @param v ビュー
     */
    @SuppressLint("NewApi")
    public void restartActivity(Activity activity, View v) {
        if (Build.VERSION.SDK_INT >= 21) {
            ActivityOptionsCompat opts = ActivityOptionsCompat.makeScaleUpAnimation(
                    v, 0, 0, v.getWidth(), v.getHeight());
            Intent intent = getIntent();
            String key = mPref.getString(EXTRA_CONTENT, KEY_ALL);
            intent.setClass(getApplicationContext(), getStartActivity(LAYOUT.valueOf(mPref.getString(EXTRA_LAYOUT, CARD.name())), toOsakaId(Objects.requireNonNull(key))));
            ActivityCompat.startActivity(activity, intent, opts.toBundle());
        } else {
            String key = mPref.getString(EXTRA_CONTENT, KEY_ALL);
            Intent intent = getIntent();
            intent.setClass(getApplicationContext(), getStartActivity(LAYOUT.valueOf(mPref.getString(EXTRA_LAYOUT, CARD.name())), toOsakaId(Objects.requireNonNull(key))));
            activity.startActivity(intent);
        }
        overridePendingTransition(R.animator.fade_out, R.animator.fade_in);
        finish();
    }

    /**
     * フローティングアクションボタンの設定
     */
    private void setupFloatingActionButton() {
        if (mState.getLayout() == LINEAR) {
            mBinding.fab.setImageResource(R.drawable.ic_view_module_white_36dp);
            mBinding.fab.setOnClickListener(v -> {
                mPref.edit().putString(EXTRA_LAYOUT, CARD.name()).apply();
                restartActivity(mSelf, v);
            });
        } else {
            mBinding.fab.setImageResource(R.drawable.ic_view_list_white_36dp);
            mBinding.fab.setOnClickListener(v -> {
                mPref.edit().putString(EXTRA_LAYOUT, LINEAR.name()).apply();
                restartActivity(mSelf, v);
            });
        }
    }

    /**
     * ナビゲーションドローワ―の有効化
     */
    private void enableNavigationDrawer() {
        // ナビゲーションドローワ―の生成
        if (mToggle == null) {
            mToggle = new ActionBarDrawerToggle(
                    this,
                    mBinding.drawerLayout,
                    mBinding.toolbar,
                    R.string.navigation_drawer_open,
                    R.string.navigation_drawer_close);
        }
        // ナビゲーションドローワ―の設定
        mToggle.setDrawerIndicatorEnabled(true);
        mToggle.setToolbarNavigationClickListener(this);
        mToggle.syncState();
        mBinding.drawerLayout.addDrawerListener(mToggle);
        mBinding.drawerLayout.addDrawerListener(this);
        mBinding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        mBinding.navView.setNavigationItemSelectedListener(this);
        SettingsHelper model = SettingsHelper.getInstance(this);
        if (!model.read(KEY_PUBLIC_OFFICE)) {
            mBinding.navView.getMenu().getItem(toOsakaIndex(KEY_PUBLIC_OFFICE)).setVisible(false);
        }
        if (!model.read(KEY_SCHOOL_AND_NURSERY)) {
            mBinding.navView.getMenu().getItem(toOsakaIndex(KEY_SCHOOL_AND_NURSERY)).setVisible(false);
        }
        if (!model.read(KEY_PARK_AND_SPORTS)) {
            mBinding.navView.getMenu().getItem(toOsakaIndex(KEY_PARK_AND_SPORTS)).setVisible(false);
        }
        if (!model.read(KEY_HALL)) {
            mBinding.navView.getMenu().getItem(toOsakaIndex(KEY_HALL)).setVisible(false);
        }
        if (!model.read(KEY_CULTURE_AND_TOURIST)) {
            mBinding.navView.getMenu().getItem(toOsakaIndex(KEY_CULTURE_AND_TOURIST)).setVisible(false);
        }
        if (!model.read(KEY_POLICE_AND_FIRE)) {
            mBinding.navView.getMenu().getItem(toOsakaIndex(KEY_POLICE_AND_FIRE)).setVisible(false);
        }
        if (!model.read(KEY_MEDICAL_CARE_AND_WELFARE)) {
            mBinding.navView.getMenu().getItem(toOsakaIndex(KEY_MEDICAL_CARE_AND_WELFARE)).setVisible(false);
        }
        if (!model.read(KEY_ATTRACTIONS_AND_HISTORIC_SITES)) {
            mBinding.navView.getMenu().getItem(toOsakaIndex(KEY_ATTRACTIONS_AND_HISTORIC_SITES)).setVisible(false);
        }
        if (!model.read(KEY_STATIONS_AND_BUS_STOP)) {
            mBinding.navView.getMenu().getItem(toOsakaIndex(KEY_STATIONS_AND_BUS_STOP)).setVisible(false);
        }
        if (!model.read(KEY_PARKING_AND_BYCYCLE_PARKING)) {
            mBinding.navView.getMenu().getItem(toOsakaIndex(KEY_PARKING_AND_BYCYCLE_PARKING)).setVisible(false);
        }
        if (!model.read(KEY_PUBLIC_TOILET)) {
            mBinding.navView.getMenu().getItem(toOsakaIndex(KEY_PUBLIC_TOILET)).setVisible(false);
        }
        if (!model.read(KEY_ENVIRONMENT_AND_RCYCLING)) {
            mBinding.navView.getMenu().getItem(toOsakaIndex(KEY_ENVIRONMENT_AND_RCYCLING)).setVisible(false);
        }
        if (!model.read(KEY_OTHER)) {
            mBinding.navView.getMenu().getItem(toOsakaIndex(KEY_OTHER)).setVisible(false);
        }
        if (!model.read(KEY_HOUSING_SHELTER)) {
            mBinding.navView.getMenu().getItem(toOsakaIndex(KEY_HOUSING_SHELTER)).setVisible(false);
        }
        if (!model.read(KEY_DISASTER_FOR_HELIPORT)) {
            mBinding.navView.getMenu().getItem(toOsakaIndex(KEY_DISASTER_FOR_HELIPORT)).setVisible(false);
        }
        if (!model.read(KEY_FIRE_PROTECTION_WATER_TANK)) {
            mBinding.navView.getMenu().getItem(toOsakaIndex(KEY_FIRE_PROTECTION_WATER_TANK)).setVisible(false);
        }
        if (!model.read(KEY_FIRE_DISASTER_PREVENTION_SPEAKER)) {
            mBinding.navView.getMenu().getItem(toOsakaIndex(KEY_FIRE_DISASTER_PREVENTION_SPEAKER)).setVisible(false);
        }
        if (!model.read(KEY_TSUNAMI_EVACUATION_BUILDING)) {
            mBinding.navView.getMenu().getItem(toOsakaIndex(KEY_TSUNAMI_EVACUATION_BUILDING)).setVisible(false);
        }
        mBinding.navView.setCheckedItem(toOsakaId(mState.getKey()));
    }

    /**
     * Dispatch onStart() to all fragments.  Ensure any created loaders are
     * now started.
     */
    @Override
    protected void onStart() {
        super.onStart();
        if (!mPresenter.isActive) {
            mPresenter.start();
            Message msg;
            if (mState.getLayout() == LINEAR) {
                msg = mPresenter.getHandler().obtainMessage(OsakaPresenter.WHAT_START_LINEAR);
            } else {
                msg = mPresenter.getHandler().obtainMessage(OsakaPresenter.WHAT_START_CARD);
            }
            mPresenter.getHandler().sendMessage(msg);
        }
        // スレッド起動
        mTask = new AsyncAppTask(this, getOsakaPropeties(mState.getKey()));
        mTask.execute();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onPause() {
        if (mTask.isActive()) {
            mTask.cancel(true);
        }
        mPresenter.getHandler().removeMessages(OsakaPresenter.WHAT_START_CARD);
        mPresenter.getHandler().removeMessages(OsakaPresenter.WHAT_START_LINEAR);
        mPresenter.getHandler().removeMessages(OsakaPresenter.WHAT_UPDATE_ACTION_BAR);
        mPresenter.getHandler().removeMessages(OsakaPresenter.WHAT_UPDATE_CARD);
        mPresenter.getHandler().removeMessages(OsakaPresenter.WHAT_UPDATE_LINEAR);
        super.onPause();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    /**
     * メニューアイテム選択
     *
     * @param item 選択したアイテム
     * @return 実行の有無
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_action_settings) {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
            finish();
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCardFragmentInteraction(String name, Double lat, Double lng) {
    }

    /**
     * データ変換
     *
     * @param key キー
     * @param list リポート
     * @return データ
     */
    private Collection<? extends OsakaData> toOsakaData(String key, List<OsakaReport> list) {
        List<OsakaData> objects = new ArrayList<>();
        boolean isFound;
        if (LOG_D) {
            Log.d("OsakaCity", "MainAct/toCard list size:" + list.size());
        }
        for (OsakaReport report : list) {
            isFound = false;

            SettingsHelper model = SettingsHelper.getInstance(this);

            if (report.getKey().equals(KEY_PUBLIC_OFFICE)) {
                if (key.equals(KEY_ALL) || key.equals(KEY_PUBLIC_OFFICE)) {
                    if (model.read(KEY_PUBLIC_OFFICE)) {
                        isFound = true;
                    }
                }
            } else if (report.getKey().equals(KEY_SCHOOL_AND_NURSERY)) {
                if (key.equals(KEY_ALL) || key.equals(KEY_SCHOOL_AND_NURSERY)) {
                    if (model.read(KEY_SCHOOL_AND_NURSERY)) {
                        isFound = true;
                    }
                }
            } else if (report.getKey().equals(KEY_PARK_AND_SPORTS)) {
                if (key.equals(KEY_ALL) || key.equals(KEY_PARK_AND_SPORTS)) {
                    if (model.read(KEY_PARK_AND_SPORTS)) {
                        isFound = true;
                    }
                }
            } else if (report.getKey().equals(KEY_HALL)) {
                if (key.equals(KEY_ALL) || key.equals(KEY_HALL)) {
                    if (model.read(KEY_HALL)) {
                        isFound = true;
                    }
                }
            } else if (report.getKey().equals(KEY_CULTURE_AND_TOURIST)) {
                if (key.equals(KEY_ALL) || key.equals(KEY_CULTURE_AND_TOURIST)) {
                    if (model.read(KEY_CULTURE_AND_TOURIST)) {
                        isFound = true;
                    }
                }
            } else if (report.getKey().equals(KEY_POLICE_AND_FIRE)) {
                if (key.equals(KEY_ALL) || key.equals(KEY_POLICE_AND_FIRE)) {
                    if (model.read(KEY_POLICE_AND_FIRE)) {
                        isFound = true;
                    }
                }
            } else if (report.getKey().equals(KEY_MEDICAL_CARE_AND_WELFARE)) {
                if (key.equals(KEY_ALL) || key.equals(KEY_MEDICAL_CARE_AND_WELFARE)) {
                    if (model.read(KEY_MEDICAL_CARE_AND_WELFARE)) {
                        isFound = true;
                    }
                }
            } else if (report.getKey().equals(KEY_ATTRACTIONS_AND_HISTORIC_SITES)) {
                if (key.equals(KEY_ALL) || key.equals(KEY_ATTRACTIONS_AND_HISTORIC_SITES)) {
                    if (model.read(KEY_ATTRACTIONS_AND_HISTORIC_SITES)) {
                        isFound = true;
                    }
                }
            } else if (report.getKey().equals(KEY_STATIONS_AND_BUS_STOP)) {
                if (key.equals(KEY_ALL) || key.equals(KEY_STATIONS_AND_BUS_STOP)) {
                    if (model.read(KEY_STATIONS_AND_BUS_STOP)) {
                        isFound = true;
                    }
                }
            } else if (report.getKey().equals(KEY_PARKING_AND_BYCYCLE_PARKING)) {
                if (key.equals(KEY_ALL) || key.equals(KEY_PARKING_AND_BYCYCLE_PARKING)) {
                    if (model.read(KEY_PARKING_AND_BYCYCLE_PARKING)) {
                        isFound = true;
                    }
                }
            } else if (report.getKey().equals(KEY_PUBLIC_TOILET)) {
                if (key.equals(KEY_ALL) || key.equals(KEY_PUBLIC_TOILET)) {
                    if (model.read(KEY_PUBLIC_TOILET)) {
                        isFound = true;
                    }
                }
            } else if (report.getKey().equals(KEY_ENVIRONMENT_AND_RCYCLING)) {
                if (key.equals(KEY_ALL) || key.equals(KEY_ENVIRONMENT_AND_RCYCLING)) {
                    if (model.read(KEY_ENVIRONMENT_AND_RCYCLING)) {
                        isFound = true;
                    }
                }
            } else if (report.getKey().equals(OsakaConst.KEY_OTHER)) {
                if (key.equals(KEY_ALL) || key.equals(KEY_OTHER)) {
                    if (model.read(OsakaConst.KEY_OTHER)) {
                        isFound = true;
                    }
                }
            } else if (report.getKey().equals(KEY_HOUSING_SHELTER)) {
                if (key.equals(KEY_ALL) || key.equals(KEY_HOUSING_SHELTER)) {
                    if (model.read(KEY_HOUSING_SHELTER)) {
                        isFound = true;
                    }
                }
            } else if (report.getKey().equals(KEY_DISASTER_FOR_HELIPORT)) {
                if (key.equals(KEY_ALL) || key.equals(KEY_DISASTER_FOR_HELIPORT)) {
                    if (model.read(KEY_DISASTER_FOR_HELIPORT)) {
                        isFound = true;
                    }
                }
            } else if (report.getKey().equals(KEY_FIRE_PROTECTION_WATER_TANK)) {
                if (key.equals(KEY_ALL) || key.equals(KEY_FIRE_PROTECTION_WATER_TANK)) {
                    if (model.read(KEY_FIRE_PROTECTION_WATER_TANK)) {
                        isFound = true;
                    }
                }
            } else if (report.getKey().equals(KEY_FIRE_DISASTER_PREVENTION_SPEAKER)) {
                if (key.equals(KEY_ALL) || key.equals(KEY_FIRE_DISASTER_PREVENTION_SPEAKER)) {
                    if (model.read(KEY_FIRE_DISASTER_PREVENTION_SPEAKER)) {
                        isFound = true;
                    }
                }
            } else if (report.getKey().equals(KEY_TSUNAMI_EVACUATION_BUILDING)) {
                if (key.equals(KEY_ALL) || key.equals(KEY_TSUNAMI_EVACUATION_BUILDING)) {
                    if (model.read(KEY_TSUNAMI_EVACUATION_BUILDING)) {
                        isFound = true;
                    }
                }
            }
            if (isFound) {
                OsakaData card = new OsakaData();
                card.category = getString(report.getId());
                card.backgroundcolor = report.getColor(0);
                card.backgroundcolor2 = report.getColor(1);
                card.url = report.getUrl();
                card.name = report.getSummary();
                card.longitude = Double.parseDouble(report.getLongitude());
                card.latitude = Double.parseDouble(report.getLatitude());
                card.address = report.getAddress();
                card.call = report.getCall();
                card.detail = report.getDetail();
                card.free_url = report.getBarrierFree();
                card.parking_url = report.getParking();
                card.type = 0;
                card.key = (String) report.getKey();
                objects.add(card);
            }
        }
        return objects;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCardFragmentInteraction(String url) {
        Uri uri = Uri.parse(url);
        Intent i;
        if (url.startsWith("tel")) {
            i = new Intent(Intent.ACTION_DIAL, uri);
        } else {
            i = new Intent(Intent.ACTION_VIEW, uri);
        }
        try {
            startActivity(i);
        } catch (Exception e) {
            Log.e("MainActivity", Objects.requireNonNull(e.getMessage()));
        }
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

    }

    /**
     * Called when a drawer's position changes.
     *
     * @param drawerView  The child view that was moved
     * @param slideOffset The new offset of this drawer within its range, from 0-1
     */
    @Override
    public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

    }

    /**
     * Called when a drawer has settled in a completely open state.
     * The drawer is interactive at this point.
     *
     * @param drawerView Drawer view that is now open
     */
    @Override
    public void onDrawerOpened(@NonNull View drawerView) {

    }

    /**
     * Called when a drawer has settled in a completely closed state.
     *
     * @param drawerView Drawer view that is now closed
     */
    @SuppressLint("NewApi")
    @Override
    public void onDrawerClosed(@NonNull View drawerView) {
        if (!mState.getKey().equals(mPref.getString(EXTRA_CONTENT, KEY_ALL))) {
            Intent intent = getIntent();
            String key = mPref.getString(EXTRA_CONTENT, KEY_ALL);
            intent.setClass(getApplicationContext(), getStartActivity(mState.getLayout(), toOsakaId(Objects.requireNonNull(key))));
            startActivity(intent);
            overridePendingTransition(R.animator.fade_out, R.animator.fade_in);
            finish();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDrawerStateChanged(int newState) {
    }

    /**
     * スクロール開始
     *
     * @param view コレクションビュー
     */
    @Override
    public void onScroll(ICollectionView view) {
        mBinding.fab.hide();
    }

    /**
     * スクロール終了
     *
     * @param view コレクションビュー
     */
    @Override
    public void onScrollFinished(ICollectionView view) {
        mBinding.fab.show();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mPref.edit().putString(EXTRA_CONTENT, toOsakaKey(item.getItemId())).apply();
        mBinding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressLint("StaticFieldLeak")
    class AsyncAppTask extends AsyncTask<Void, Void, ArrayList<OsakaReport>> {

        /**
         * @serial 動作状態
         */
        boolean isActive = false;

        /**
         * @serial アクティビティ
         */
        Activity mActivity;

        /**
         * @serial プロパティ
         */
        ArrayList<IOsakaProperty> mProperties;

        /**
         * コンストラクタ
         *
         * @param activity アクティビティ
         * @param properties プロパティ
         */
        public AsyncAppTask(Activity activity, ArrayList<IOsakaProperty> properties) {
            // 呼び出し元のアクティビティを変数へセット
            mActivity = activity;
            mProperties = properties;
        }

        /**
         * 動作状態取得
         *
         * @return 動作状態
         */
        private boolean isActive() {
            return isActive;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void onPreExecute() {
            mBinding.productImageLoading.setVisibility(View.VISIBLE);
            isActive = true;
        }

        /**
         * {@inheritDoc}
         */
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected ArrayList<OsakaReport> doInBackground(Void... arg0) {
            ArrayList<OsakaReport> reports = new ArrayList<>();

            for (IOsakaProperty property : mProperties) {
                // キャンセルされたら抜ける
                if (this.isCancelled()) {
                    return null;
                }

                ArrayList<OsakaReport> list = new ArrayList<>();
                try {
                    String[] title = null;
                    String[] array;
                    int i = 0;
                    boolean isRedirect = false;
                    /* データ取得 */
                    URL url = new URL(property.getUrl());
                    HttpURLConnection http = (HttpURLConnection) url.openConnection();
                    http.setRequestMethod("GET");
                    http.connect();
                    int status = http.getResponseCode();
                    if (status != HttpURLConnection.HTTP_OK) {
                        if (status == HttpURLConnection.HTTP_MOVED_TEMP
                                || status == HttpURLConnection.HTTP_MOVED_PERM
                                || status == HttpURLConnection.HTTP_SEE_OTHER)
                            isRedirect = true;
                    }
                    if(isRedirect) {
                        //get redirect url from "location" header field
                        String newUrl = http.getHeaderField("Location");
                        //get the cookie if need, for login
                        String cookies = http.getHeaderField("Set-Cookie");
                        //open the new connnection again
                        http = (HttpURLConnection) new URL(newUrl).openConnection();
                        http.setRequestMethod("GET");
                        http.setRequestProperty("Cookie", cookies);
                        http.connect();
                    }
                    BufferedReader reader = new BufferedReader(new InputStreamReader(
                            http.getInputStream(), StandardCharsets.UTF_8));

                    while (true) {
                        // キャンセルされたら抜ける
                        if (this.isCancelled()) {
                            break;
                        }

                        String line = reader.readLine();
                        if (line == null)
                            break;
                        if (line.contains(",")) {
                            array = line.split(",");
                            if (i == 0) {
                                title = array.clone();
                            } else {
                                OsakaReport data = new OsakaReport();
                                data.setModel(property);
                                data.setTitle(title.clone());
                                data.setDataArray(array.clone());
                                list.add(data);
                            }
                            i++;
                        }
                    }
                    /* 接続終了 */
                    http.disconnect();
                    reader.close();
                    /* エラー処理 */
                } catch (Exception ignored) {
                }
                reports.addAll(list);
            }
            return reports;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void onPostExecute(ArrayList<OsakaReport> result) {
            mBinding.productImageLoading.setVisibility(View.GONE);
            LAYOUT layout = LAYOUT.valueOf(mPref.getString(EXTRA_LAYOUT, CARD.name()));
            Message msg;
            mList.clear();
            mList.addAll(result);
            if (layout == LINEAR) {
                msg = mPresenter.getHandler().obtainMessage(OsakaPresenter.WHAT_UPDATE_LINEAR, toOsakaData(mState.getKey(), mList));
            } else {
                msg = mPresenter.getHandler().obtainMessage(OsakaPresenter.WHAT_UPDATE_CARD, toOsakaData(mState.getKey(), mList));
            }
            mPresenter.getHandler().sendMessage(msg);
            isActive = false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void onCancelled() {
            mBinding.productImageLoading.setVisibility(View.GONE);
            isActive = false;
        }
    }
}
