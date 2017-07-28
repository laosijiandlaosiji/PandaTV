package com.example.administrator.pandatv.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.pandatv.app.App;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/27.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private BaseFragment lastFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.context = this;
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        init();
    }

    protected abstract int getLayoutId();

    protected abstract void init();

    public BaseFragment changeFragment(Class<? extends BaseFragment> fragmentClass, int containId, boolean isHidden, Bundle bundle, boolean isBack) {
        //管理类
        FragmentManager manager = getSupportFragmentManager();
        //获取事物
        FragmentTransaction transaction = manager.beginTransaction();
        //获取Fragment名字
        String simpleName = fragmentClass.getSimpleName();
        //获取当前fragment
        BaseFragment currentFragment = (BaseFragment) manager.findFragmentByTag(simpleName);
        if (currentFragment == null) {
            try {
                //通过Java动态代理创建的对象
                currentFragment = fragmentClass.newInstance();
                //添加到FragmentManager中
                transaction.add(containId, currentFragment, simpleName);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (isHidden) {

            if (lastFragment != null)
                //隐藏上一个Fragment
                transaction.hide(lastFragment);
                //显示点击Fragment
            transaction.show(currentFragment);
        } else {
            transaction.replace(containId, currentFragment, simpleName);
        }
        if (bundle != null) {
            currentFragment.setBundle(bundle);
        }

        if (isBack) {
            transaction.addToBackStack(simpleName);
        }

        transaction.commit();

        lastFragment = currentFragment;

        return lastFragment;
    }
}