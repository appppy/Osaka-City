
package jp.osaka.appppy.sample.osakacity.app.model.category;

import java.util.ArrayList;
import java.util.List;

import jp.osaka.appppy.sample.osakacity.R;
import jp.osaka.appppy.sample.osakacity.app.model.IOsakaProperty;

import static jp.osaka.appppy.sample.osakacity.app.model.util.OsakaConst.KEY_PARK_AND_SPORTS;

/**
 * 公園
 *
 *  @author APPPPY
 */
public class PARK_AND_SPORTS implements IOsakaProperty {
    /**
     * @serial 色
     */
    private final List<Integer> mColorList = new ArrayList<>();

    /**
     * コンストラクタ
     */
    public PARK_AND_SPORTS() {
        mColorList.add(0xff9c27b0);
        mColorList.add(0xfff3e5f5);
    }
    
    @Override
    public String getKey() {
        return KEY_PARK_AND_SPORTS;
    }

    @Override
    public int getColor(int number) {
        return mColorList.get(number);
    }

    @Override
    public String getUrl() {
        return "http://www.city.osaka.lg.jp/contents/wdu090/opendata/mapnavoskdat_csv/mapnavoskdat_kouen.csv";
    }

    @Override
    public int getId() {
        return R.string.park_and_sports;
    }
    
}
