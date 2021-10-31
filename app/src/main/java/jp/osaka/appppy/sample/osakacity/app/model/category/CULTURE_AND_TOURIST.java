
package jp.osaka.appppy.sample.osakacity.app.model.category;

import java.util.ArrayList;
import java.util.List;

import jp.osaka.appppy.sample.osakacity.R;
import jp.osaka.appppy.sample.osakacity.app.model.IOsakaProperty;

import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_CULTURE_AND_TOURIST;

/**
 * 文化
 *
 *  @author APPPPY
 */
public class CULTURE_AND_TOURIST implements IOsakaProperty {
    /**
     * @serial 色
     */
    private final List<Integer> mColorList = new ArrayList<>();
    
    /**
     * コンストラクタ
     */
    public CULTURE_AND_TOURIST() {
        mColorList.add(0xff3f51b5);
        mColorList.add(0xffe8eaf6);
    }
    
    /* (non-Javadoc)
     * @see jp.osaka.appppy.sample.osakacity.model.IOsakaModel#getKey()
     */
    @Override
    public String getKey() {
        return KEY_CULTURE_AND_TOURIST;
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
        return "http://www.city.osaka.lg.jp/contents/wdu090/opendata/mapnavoskdat_csv/mapnavoskdat_bunka.csv";
    }

    /* (non-Javadoc)
     * @see jp.osaka.appppy.sample.osakacity.model.IOsakaModel#getId()
     */
    @Override
    public int getId() {
        return R.string.culture_and_tourist;
    }
    
}
