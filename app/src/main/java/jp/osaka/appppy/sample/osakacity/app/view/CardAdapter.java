package jp.osaka.appppy.sample.osakacity.app.view;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import jp.osaka.appppy.sample.osakacity.R;
import jp.osaka.appppy.sample.osakacity.app.DetailActivity;
import jp.osaka.appppy.sample.osakacity.app.model.OsakaData;
import jp.osaka.appppy.sample.osakacity.constants.PARTS;

import static jp.osaka.appppy.sample.osakacity.constants.EXTRA.EXTRA_OSAKA_CITY;
import static jp.osaka.appppy.sample.osakacity.constants.PARTS.CALL;
import static jp.osaka.appppy.sample.osakacity.constants.PARTS.FREE;
import static jp.osaka.appppy.sample.osakacity.constants.PARTS.INFO;
import static jp.osaka.appppy.sample.osakacity.constants.PARTS.LOCATION;
import static jp.osaka.appppy.sample.osakacity.constants.PARTS.PARKING;
import static jp.osaka.appppy.sample.osakacity.constants.PARTS.URL;

/**
 * カードアダプタ
 *
 *  @author APPPPY
 */
public class CardAdapter extends RecyclerArrayAdapter<OsakaData, CardAdapter.ViewHolder> {
    /**
     * @serial コンテキスト
     */
    private final Context mContext;

    /**
     * @serial リスナ
     */
    private final Callbacks mListener;

    /**
     * @serial アニメーションの位置
     */
    private int mAnimatedPosition = RecyclerView.NO_POSITION;

    /**
     * コンストラクタ
     *
     * @param context コンテキスト
     * @param listener リスナ
     * @param cards カード
     */
    public CardAdapter(Context context, Callbacks listener, List<OsakaData> cards) {
        super(cards);
        mContext = context;
        mListener = listener;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     * <p/>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use {@link ViewHolder#getAdapterPosition()} which will
     * have the updated adapter position.
     * <p/>
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Object item = getItem(position);

        TextView textView;
        ImageView imageView;
        OsakaData card = (OsakaData) item;
        if (holder.view != null) {
            holder.view.setOnClickListener(new View.OnClickListener() {
                /**
                 * Called when a view has been clicked.
                 *
                 * @param v The view that was clicked.
                 */
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(item, LOCATION, position);
                }
            });
        }
        textView = holder.itemView.findViewById(R.id.category);
        if (textView != null) {
            textView.setText(card.category);
        }
        textView = holder.itemView.findViewById(R.id.subtitle);
        if (textView != null) {
            textView.setText(card.address);
        }
        textView = holder.itemView.findViewById(R.id.label);
        if (textView != null) {
            textView.setText(card.name);
        }
        textView = holder.itemView.findViewById(R.id.detail);
        if (textView != null) {
            textView.setText(card.detail);
        }
        imageView = holder.itemView.findViewById(R.id.location_icon);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                /**
                 * Called when a view has been clicked.
                 *
                 * @param v The view that was clicked.
                 */
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(item, LOCATION, position);
                }
            });
        }
        textView = holder.itemView.findViewById(R.id.location_text);
        if (textView != null && card.address != null) {
            textView.setText(card.address);
            textView.setOnClickListener(new View.OnClickListener() {
                /**
                 * Called when a view has been clicked.
                 *
                 * @param v The view that was clicked.
                 */
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(item, LOCATION, position);
                }
            });
        }
        imageView = holder.itemView.findViewById(R.id.url_icon);
        if (imageView != null) {
            if (card.url.isEmpty()) {
                imageView.setVisibility(View.GONE);
            } else {
                imageView.setVisibility(View.VISIBLE);
                imageView.setOnClickListener(new View.OnClickListener() {
                    /**
                     * Called when a view has been clicked.
                     *
                     * @param v The view that was clicked.
                     */
                    @Override
                    public void onClick(View v) {
                        mListener.onItemClick(item, URL, position);
                    }
                });
            }
        }
        textView = holder.itemView.findViewById(R.id.url_text);
        if (textView != null) {
            textView.setText(card.url);
            textView.setOnClickListener(new View.OnClickListener() {
                /**
                 * Called when a view has been clicked.
                 *
                 * @param v The view that was clicked.
                 */
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(item, URL, position);
                }
            });
        }
        imageView = holder.itemView.findViewById(R.id.call_icon);
        if (imageView != null) {
            if (card.call.isEmpty()) {
                imageView.setVisibility(View.GONE);
            } else {
                imageView.setVisibility(View.VISIBLE);
                imageView.setOnClickListener(new View.OnClickListener() {
                    /**
                     * Called when a view has been clicked.
                     *
                     * @param v The view that was clicked.
                     */
                    @Override
                    public void onClick(View v) {
                        mListener.onItemClick(item, CALL, position);
                    }
                });
            }
        }
        textView = holder.itemView.findViewById(R.id.call_text);
        if (textView != null) {
            textView.setText(card.call);
            textView.setOnClickListener(new View.OnClickListener() {
                /**
                 * Called when a view has been clicked.
                 *
                 * @param v The view that was clicked.
                 */
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(item, CALL, position);
                }
            });
        }
        imageView = holder.itemView.findViewById(R.id.free_icon);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                /**
                 * Called when a view has been clicked.
                 *
                 * @param v The view that was clicked.
                 */
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(item, FREE, position);
                }
            });
        }
        textView = holder.itemView.findViewById(R.id.free_text);
        if (textView != null) {
            textView.setText(card.free_url);
            textView.setOnClickListener(new View.OnClickListener() {
                /**
                 * Called when a view has been clicked.
                 *
                 * @param v The view that was clicked.
                 */
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(item, FREE, position);
                }
            });
        }
        imageView = holder.itemView.findViewById(R.id.parking_icon);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                /**
                 * Called when a view has been clicked.
                 *
                 * @param v The view that was clicked.
                 */
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(item, PARKING, position);
                }
            });
        }
        textView = holder.itemView.findViewById(R.id.parking_text);
        if (textView != null) {
            textView.setText(card.parking_url);
            textView.setOnClickListener(new View.OnClickListener() {
                /**
                 * Called when a view has been clicked.
                 *
                 * @param v The view that was clicked.
                 */
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(item, PARKING, position);
                }
            });
        }
        imageView = holder.itemView.findViewById(R.id.info_icon);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                /**
                 * Called when a view has been clicked.
                 *
                 * @param v The view that was clicked.
                 */
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(item, INFO, position);
                    Intent intent = new Intent(mContext, DetailActivity.class);
                    OsakaData card = (OsakaData) item;
                    intent.putExtra(EXTRA_OSAKA_CITY, card);
                    mContext.startActivity(intent);
                }
            });
        }
        holder.setCard(card);

        if (mAnimatedPosition < position) {
            Animator animator = AnimatorInflater.loadAnimator(mContext, R.animator.card_slide_in);
            animator.setTarget(holder.view);
            animator.start();
            mAnimatedPosition = position;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getItemCount() {
        return getCollection().size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getItemViewType(int position) {
        OsakaData item = (OsakaData) getItem(position);
        return item.type;
    }

    /**
     * アイテムの取得
     *
     * @param position 位置
     * @return アイテム
     */
    private Object getItem(int position) {
        return getCollection().get(position);
    }

    /**
     * @serial コールバック
     */
    public interface Callbacks {
        void onItemClick(Object obj, PARTS type, int position);
    }

    /**
     * ビューホルダー
     *
     * @author APPY
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        /**
         * @serial ビュー
         */
        public CardView view;

        /**
         * @serial カード
         */
        public OsakaData card;

        /**
         * コンストラクタ
         *
         * @param itemView
         */
        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.card_view);
        }

        public void setCard(OsakaData card) {
            this.card = card;
        }
    }

}
