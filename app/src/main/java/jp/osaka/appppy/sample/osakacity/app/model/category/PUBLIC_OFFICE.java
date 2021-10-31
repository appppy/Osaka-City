
package jp.osaka.appppy.sample.osakacity.app.model.category;

import java.util.ArrayList;
import java.util.List;

import jp.osaka.appppy.sample.osakacity.R;
import jp.osaka.appppy.sample.osakacity.app.model.IOsakaProperty;

import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_PUBLIC_OFFICE;

/**
 * 官公庁
 *
 *  @author APPPPY
 */
public class PUBLIC_OFFICE implements IOsakaProperty {
    /**
     * @serial 色
     */
    private final List<Integer> mColorList = new ArrayList<>();
    
    /**
     * コンストラクタ
     */
    public PUBLIC_OFFICE() {
        mColorList.add(0xffe51c23);
        mColorList.add(0xfffde0dc);
    }
    
    /* (non-Javadoc)
     * @see jp.osaka.appppy.sample.osakacity.model.IOsakaModel#getKey()
     */
    @Override
    public String getKey() {
        return KEY_PUBLIC_OFFICE;
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
        return "http://www.city.osaka.lg.jp/contents/wdu090/opendata/mapnavoskdat_csv/mapnavoskdat_kankouchou.csv";
    }

    /* (non-Javadoc)
     * @see jp.osaka.appppy.sample.osakacity.model.IOsakaModel#getId()
     */
    @Override
    public int getId() {
        return R.string.public_office;
    }
    
}
