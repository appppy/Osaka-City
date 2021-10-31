
package jp.osaka.appppy.sample.osakacity.app.model.category;

import java.util.ArrayList;
import java.util.List;

import jp.osaka.appppy.sample.osakacity.R;
import jp.osaka.appppy.sample.osakacity.app.model.IOsakaProperty;

import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_ATTRACTIONS_AND_HISTORIC_SITES;

/**
 * 文化
 *
 *  @author APPPPY
 */
public class ATTRACTIONS_AND_HISTORIC_SITES implements IOsakaProperty {
    /**
     * @serial 色
     */
    private final List<Integer> mColorList = new ArrayList<>();
    
    /**
     * コンストラクタ
     */
    public ATTRACTIONS_AND_HISTORIC_SITES() {
        mColorList.add(0xff00bcd4);
        mColorList.add(0xffe0f7fa);
    }
    
    /* (non-Javadoc)
     * @see jp.osaka.appppy.sample.osakacity.model.IOsakaModel#getKey()
     */
    @Override
    public String getKey() {
        return KEY_ATTRACTIONS_AND_HISTORIC_SITES;
    }

    /* (non-Javadoc)
     * @see jp.osaka.appppy.sample.osakacity.model.IOsakaModel#getColor(int)
     */
    @Override
    public int getColor(int number) {
        return mColorList.get(number);
    }

    /* (non-Javadoc)
     * @see jp.osaka.appppy.sample.osakacity.model.IOsakaModel#getUrl()
     */
    @Override
    public String getUrl() {
        return "http://www.city.osaka.lg.jp/contents/wdu090/opendata/mapnavoskdat_csv/mapnavoskdat_meisyo.csv";
    }

    /* (non-Javadoc)
     * @see jp.osaka.appppy.sample.osakacity.model.IOsakaModel#getId()
     */
    @Override
    public int getId() {
        return R.string.attractions_and_historic_sites;
    }
    
}
