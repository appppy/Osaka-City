
package jp.osaka.appppy.sample.osakacity.app.view;



import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collection;
import java.util.List;

/**
 * ArrayAdapterのようなRecycerView.Adapter
 *  @author APPPPY
 */
public abstract class RecyclerArrayAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /**
     * @serial ロック
     */
    private final Object lock = new Object();

    /**
     * @serial オブジェクト
     */
    private final List<T> objects;

    /**
     * コンストラクタ
     *
     * @param objects オブジェクト
     */
    public RecyclerArrayAdapter(List<T> objects) {
        this.objects = objects;
    }

    /**
     * 追加
     *
     * @param object オブジェクト
     */
    public void add(@NonNull T object) {
        final int position;
        synchronized (lock) {
            position = objects.size();
            objects.add(object);
        }
        notifyItemInserted(position);
    }

    /**
     * すべて追加
     *
     * @param collection コレクション
     */
    public void setAll(@NonNull Collection<? extends T> collection) {
        synchronized (lock) {
            objects.clear();
            objects.addAll(collection);
        }
        notifyDataSetChanged();
    }

    /**
     * コレクション取得
     *
     * @return コレクション
     */
    public List<T> getCollection() {
        return objects;
    }
}