package type.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import base.BaseFragment;

/**
 * Created by gsh on 2017/10/29.
 */

public class TypeFragment extends BaseFragment {
    private TextView textView;
    @Override
    public View initView() {
        textView = new TextView(mContext);
        textView.setGravity(Gravity. CENTER);
        textView.setTextSize(25);
        textView.setTextColor(Color. RED);
        return textView;

    }

    @Override
    public void initDatas() {
        Log.i("typeFragment","typeinitdata");
        super.initDatas();
        textView.setText("type");
    }
}
