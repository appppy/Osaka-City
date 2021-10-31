
package jp.osaka.appppy.sample.osakacity.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.databinding.DataBindingUtil;

import java.util.Objects;

import jp.osaka.appppy.sample.osakacity.R;
import jp.osaka.appppy.sample.osakacity.app.model.OsakaData;
import jp.osaka.appppy.sample.osakacity.app.view.BaseActivity;

import static jp.osaka.appppy.sample.osakacity.constants.EXTRA.EXTRA_OSAKA_CITY;

/**
 * メインアクティビティ
 *
 * @author APPPPY
 */
public class DetailActivity extends BaseActivity {

    /**
     * {@inheritDoc}
     */
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // レイアウト設定
        jp.osaka.appppy.sample.osakacity.databinding.ActivityDetailBinding mBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        Intent intent = getIntent();
        OsakaData card = intent.getParcelableExtra(EXTRA_OSAKA_CITY);

        // ツールバーの設定
        setSupportActionBar(mBinding.toolbar);
        ActionBar bar = getSupportActionBar();
        Objects.requireNonNull(bar).setDisplayHomeAsUpEnabled(true);
        bar.setTitle(Objects.requireNonNull(card).name);

        TextView textView;
        ImageView imageView;
        // カテゴリ
        textView = findViewById(R.id.category);
        if (textView != null) {
            textView.setText(card.category);
        }
        // 名前
        textView = findViewById(R.id.label);
        if (textView != null) {
            textView.setText(card.name);
        }
        // 住所
        textView = findViewById(R.id.location_text);
        if (textView != null && card.address != null) {
            textView.setText(card.address);
        }

        if (card.url.isEmpty()) {
            LinearLayout view = findViewById(R.id.layout_url);
            view.setVisibility(View.GONE);
        } else {
            imageView = findViewById(R.id.url_icon);
            if (imageView != null) {
                imageView.setVisibility(View.VISIBLE);
            }
            textView = findViewById(R.id.url_text);
            if (textView != null) {
                textView.setText(card.url);
            }
        }

        if (card.call.isEmpty()) {
            LinearLayout view = findViewById(R.id.layout_call);
            view.setVisibility(View.GONE);
        } else {
            textView = findViewById(R.id.call_text);
            if (textView != null) {
                textView.setText(card.call);
            }
        }

        if (card.free_url.isEmpty()) {
            LinearLayout view = findViewById(R.id.layout_free);
            view.setVisibility(View.GONE);
        } else {
            textView = findViewById(R.id.free_text);
            if (textView != null) {
                textView.setText(card.free_url);
            }
        }

        if (card.parking_url.isEmpty()) {
            LinearLayout view = findViewById(R.id.layout_parking);
            view.setVisibility(View.GONE);
        } else {
            textView = findViewById(R.id.parking_text);
            if (textView != null) {
                textView.setText(card.parking_url);
            }
        }
        if (card.detail.isEmpty()) {
            LinearLayout view = findViewById(R.id.layout_detail);
            view.setVisibility(View.GONE);
        } else {
            textView = findViewById(R.id.detail);
            if (textView != null) {
                textView.setText(card.detail);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
