package jp.osaka.appppy.sample.osakacity.app.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

import jp.osaka.appppy.sample.osakacity.R;
import jp.osaka.appppy.sample.osakacity.app.DetailActivity;
import jp.osaka.appppy.sample.osakacity.app.model.OsakaData;
import jp.osaka.appppy.sample.osakacity.constants.PARTS;
import jp.osaka.appppy.sample.osakacity.databinding.ItemLineBinding;

import static androidx.appcompat.content.res.AppCompatResources.getDrawable;
import static jp.osaka.appppy.sample.osakacity.app.helper.OsakaHelper.getOsakaColor;
import static jp.osaka.appppy.sample.osakacity.app.helper.OsakaHelper.getOsakaIcon;
import static jp.osaka.appppy.sample.osakacity.constants.EXTRA.EXTRA_OSAKA_CITY;
import static jp.osaka.appppy.sample.osakacity.constants.PARTS.INFO;
import static jp.osaka.appppy.sample.osakacity.constants.PARTS.LOCATION;


/**
 * リストアダプタ
 *
 *  @author APPPPY
 */
class LinetAdapter extends RecyclerArrayAdapter<OsakaData, LinetAdapter.BindingHolder> {

    /**
     * @serial コンテキスト
     */
    private final Context mContext;

    /**
     * @serial レイアウトインフレータ
     */
    private final LayoutInflater mInflater;

    /**
     * @serial リスナ
     */
    private final Callbacks mListener;

    /**
     * コンストラクタ
     *
     * @param context    コンテキスト
     * @param listener   リスナ
     * @param collection コレクション
     */
    LinetAdapter(Context context, Callbacks listener, ArrayList<OsakaData> collection) {
        super(collection);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mListener = listener;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public BindingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BindingHolder(
                mInflater.inflate(R.layout.item_line, parent, false));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBindViewHolder(final BindingHolder holder, final int position) {
        // アイテム
        final OsakaData item = getCollection().get(position);
        // 短押しの設定
        holder.getBinding().cardView.setOnClickListener(new View.OnClickListener() {
            /**
             * {@inheritDoc}
             */
            @Override
            public void onClick(View v) {
                mListener.onItemClick(item, LOCATION, position);
            }
        });
        // タイトル
        holder.getBinding().title.setText(item.name);
        holder.getBinding().subtitle.setText(item.address);
        Drawable d = getDrawable(mContext, getOsakaIcon(item.key));
        DrawableCompat.setTint(Objects.requireNonNull(d), ContextCompat.getColor(mContext, getOsakaColor(item.key)));
        DrawableCompat.setTintMode(d, PorterDuff.Mode.SRC_IN);
        holder.getBinding().icon2.setImageDrawable(d);
        holder.getBinding().icon2.setColorFilter(ContextCompat.getColor(mContext, getOsakaColor(item.key)));
        holder.getBinding().infoIcon.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                mListener.onItemClick(item, INFO, position);
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra(EXTRA_OSAKA_CITY, item);
                mContext.startActivity(intent);
            }
        });
    }

    /**
     * Returns the total number of items in the data change hold by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return getCollection().size();
    }

    /**
     * @serial コールバック
     */
    public interface Callbacks {
        void onItemClick(Object obj, PARTS type, int position);
    }

    /**
     * ビューホルダ
     */
    static class BindingHolder extends RecyclerView.ViewHolder {
        private final ItemLineBinding mBinding;

        BindingHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }

        public ItemLineBinding getBinding() {
            return mBinding;
        }
    }
}

