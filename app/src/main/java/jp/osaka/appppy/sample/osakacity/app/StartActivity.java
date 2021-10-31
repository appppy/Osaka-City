package jp.osaka.appppy.sample.osakacity.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import java.util.Objects;

import jp.osaka.appppy.sample.osakacity.R;
import jp.osaka.appppy.sample.osakacity.app.view.BaseActivity;
import jp.osaka.appppy.sample.osakacity.constants.LAYOUT;

import static jp.osaka.appppy.sample.osakacity.app.helper.OsakaHelper.getStartActivity;
import static jp.osaka.appppy.sample.osakacity.app.helper.OsakaHelper.toOsakaId;
import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_ALL;
import static jp.osaka.appppy.sample.osakacity.constants.EXTRA.EXTRA_CONTENT;
import static jp.osaka.appppy.sample.osakacity.constants.EXTRA.EXTRA_LAYOUT;
import static jp.osaka.appppy.sample.osakacity.constants.LAYOUT.CARD;

/**
 * メインアクティビティ
 *
 *  @author APPPPY
 */
public class StartActivity extends BaseActivity {
    /**
     * @serial プリファレンス
     */
    private SharedPreferences mPref;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // プリファレンス生成
        mPref = PreferenceManager.getDefaultSharedPreferences(this);

        // テーマ設定
        setTheme(R.style.AppTheme);

        // アクティビティの開始
        startActivity();
    }

    /**
     * アクティビティの開始
     */
    @SuppressLint("NewApi")
    public void startActivity() {
        LAYOUT layout = LAYOUT.valueOf(mPref.getString(EXTRA_LAYOUT, CARD.name()));
        String key = mPref.getString(EXTRA_CONTENT, KEY_ALL);
        Intent intent = getIntent();
        intent.setClass(getApplicationContext(), getStartActivity(layout, toOsakaId(Objects.requireNonNull(key))));
        startActivity(intent);
        overridePendingTransition(R.animator.fade_out, R.animator.fade_in);
        finish();
    }
}
