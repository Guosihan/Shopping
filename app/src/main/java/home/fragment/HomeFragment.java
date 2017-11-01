package home.fragment;

import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.gsh.shopping.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.IOException;
import java.util.List;
import java.util.logging.Handler;

import base.BaseFragment;
import home.fragment.adapter.HomeFragmentAdapter;
import home.fragment.bean.ResultBeanData;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import utils.Constans;

/**
 * Created by gsh on 2017/10/29.
 */

public class HomeFragment extends BaseFragment {

        private static final String TAG =
                HomeFragment. class.getSimpleName();
        private RecyclerView rvHome;
        private ImageView ib_top;
        private TextView tv_search_home;
        private TextView tv_message_home;
        private ResultBeanData.ResultBean result;
        private HomeFragmentAdapter adapter;
        @Override
        public View initView() {
            Log. e(TAG, "主页视图被初始化了");
            View view = View. inflate(mContext, R.layout. fragment_home,
                    null);
            rvHome = (RecyclerView) view.findViewById(R.id. rv_home);
            ib_top = (ImageView) view.findViewById(R.id. ib_top);
            tv_search_home = (TextView) view.findViewById(R. id. tv_search_home);
            tv_message_home = (TextView) view.findViewById(R.id. tv_message_home);
            //设置点击事件
            initListener();
            return view;
        }

        public void initDatas() {
            super.initDatas();
            FromIn();


        }

    private void FromIn() {
        String url = Constans.HOME_URL;
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback()
                {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("Home","失败"+e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {

                        processData(response);
                    }


                });

    }

    private void processData(String response) {
        ResultBeanData resultBeanData = JSON.parseObject(response, ResultBeanData.class);
         result = resultBeanData.getResult();
        if (result !=null){
            adapter=new HomeFragmentAdapter(mContext,result);
            rvHome.setAdapter(adapter);
            GridLayoutManager manager = new GridLayoutManager(mContext, 1);
            manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (position >=3){
                        ib_top.setVisibility(View.VISIBLE);
                    }else{
                        ib_top.setVisibility(View.GONE);
                    }
                    return 1;
                }
            });
            rvHome.setLayoutManager(manager);
        }
    }

    private void initListener() {
            //置顶的监听
            ib_top.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //回到顶部
                    rvHome.scrollToPosition(0);
                }
            });
            //搜素的监听
            tv_search_home.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast. makeText(mContext, "搜索",
                            Toast. LENGTH_SHORT).show();
                }
            });
            //消息的监听
            tv_message_home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast. makeText(mContext, "进入消息中心",
                            Toast. LENGTH_SHORT).show();
                }
            });

        }

    }