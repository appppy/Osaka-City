
package jp.osaka.appppy.sample.osakacity.app.model.category;

import java.util.ArrayList;
import java.util.List;

import jp.osaka.appppy.sample.osakacity.R;
import jp.osaka.appppy.sample.osakacity.app.model.IOsakaProperty;

import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_MEDICAL_CARE_AND_WELFARE;

/**
 * 病院
 *
 *  @author APPPPY
 */
public class MEDICAL_CARE_AND_WELFARE implements IOsakaProperty {
    /**
     * @serial 色
     */
    private final List<Integer> mColorList = new ArrayList<>();
    
    /**
     * コンストラクタ
     */
    public MEDICAL_CARE_AND_WELFARE() {
        mColorList.add(0xff03a9f4);
        mColorList.add(0xffe1f5fe);
    }
    
    /* (non-Javadoc)
     * @see jp.osaka.appppy.sample.osakacity.model.IOsakaModel#getKey()
     */
    @Override
    public String getKey() {
        return KEY_MEDICAL_CARE_AND_WELFARE;
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
        return "http://www.city.osaka.lg.jp/contents/wdu090/opendata/mapnavoskdat_csv/mapnavoskdat_iryou.csv";
    }

    /* (non-Javadoc)
     * @see jp.osaka.appppy.sample.osakacity.model.IOsakaModel#getId()
     */
    @Override
    public int getId() {
        return R.string.medical_care_and_welfare;
    }
    
}
