package com.example.gsh.shopping.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.gsh.shopping.R;

import java.util.ArrayList;


import base.BaseFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;
import community.fragment.CommunityFragment;
import home.fragment.HomeFragment;
import shoppingcar.fragment.ShoppingcarFragment;
import type.fragment.TypeFragment;
import user.fragment.UserFragment;

public class MainActivity extends FragmentActivity {

    @InjectView(R.id.frameLayout)
    FrameLayout frameLayout;
    @InjectView(R.id.rg_main)
    RadioGroup rgMain;
    private ArrayList<BaseFragment> fragmentList;
    private int position=0;
    private Fragment tempFragemnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initFragment();
        initListener();
    }

    private void initFragment() {
        fragmentList=new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new TypeFragment());
        fragmentList.add(new CommunityFragment());
        fragmentList.add(new ShoppingcarFragment());
        fragmentList.add(new UserFragment());

    }
    private void initListener() {
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                switch (checkedId) {

                    case R.id. rb_home:

                        position = 0;

                        fragmentTransaction.replace(R.id.frameLayout,fragmentList.get(position));
                        fragmentTransaction.commit();
                        rgMain.check(R.id. rb_home);
                        break;
                    case R.id. rb_type:

                        position = 1;
                        fragmentTransaction.replace(R.id.frameLayout,fragmentList.get(position));
                        fragmentTransaction.commit();
                        rgMain.check(R.id. rb_type);
                        break;
                    case R.id. rb_community:

                        position = 2;
                        fragmentTransaction.replace(R.id.frameLayout,fragmentList.get(position));
                        fragmentTransaction.commit();
                        rgMain.check(R.id. rb_community);
                        break;
                    case R.id. rb_cart:

                        position = 3;
                        fragmentTransaction.replace(R.id.frameLayout,fragmentList.get(position));
                        fragmentTransaction.commit();
                        rgMain.check(R.id. rb_cart);
                        break;
                    case R.id. rb_user:

                        position = 4;
                        fragmentTransaction.replace(R.id.frameLayout,fragmentList.get(position));
                        fragmentTransaction.commit();
                        rgMain.check(R.id. rb_user);
                        break;
                }

            }
        });
        //默认设置首页
        rgMain.check(R.id. rb_home);
    }
/*   private void initListener() {
       rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
               switch (checkedId) {
                   case R.id. rb_home:
                       position = 0;
                       break;
                   case R.id. rb_type:
                       position = 1;
                       break;
                   case R.id. rb_community:
                       position = 2;
                       break;
                   case R.id. rb_cart:
                       position = 3;
                       break;
                   case R.id. rb_user:
                       position = 4;
                       break;
               }
               BaseFragment baseFragment = getFragment(position);
               switchFragment(tempFragemnt, baseFragment);
           }
       });
       //默认设置首页

   }
    private BaseFragment getFragment(int position) {
        if (fragmentList != null && fragmentList.size() > 0) {
            BaseFragment baseFragment = fragmentList.get(position);
            return baseFragment;
        }
        return null;
    }
    private void switchFragment(Fragment fromFragment, BaseFragment
            nextFragment) {
        if (tempFragemnt != nextFragment) {
            tempFragemnt = nextFragment;
            if (nextFragment != null) {
                FragmentTransaction transaction =
                        getSupportFragmentManager().beginTransaction();
                //判断nextFragment 是否添加
                if (!nextFragment.isAdded()) {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.add(R.id. frameLayout, nextFragment).commit();
                } else {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }*/

}
