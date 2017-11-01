package user.fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import base.BaseFragment;

/**
 * Created by gsh on 2017/10/29.
 */

public class UserFragment extends BaseFragment {
    private TextView mTextView;
    @Override
    public View initView() {
        mTextView=new TextView(mContext);

        mTextView.setGravity(Gravity.CENTER);
        return mTextView;
    }

    @Override
    public void initDatas() {

        super.initDatas();
        mTextView.setText("user");
    }
}
