package com.example.administrator.pandatv.ui.pandaculture;

import com.example.administrator.pandatv.base.BasePresenter;
import com.example.administrator.pandatv.base.BaseView;
import com.example.administrator.pandatv.entity.PandacultureDetailsBean;
import com.example.administrator.pandatv.entity.PandacultureDetailsSPBean;
import com.example.administrator.pandatv.entity.PandacultureListViewBean;

/**
 * Created by li on 2017/7/29.
 */

public interface PandacultureContract {
//
    interface View extends BaseView<Presenter>{
        void getListData(PandacultureListViewBean bean);
        void getPandacultureDetails(PandacultureDetailsBean bean);
        void getPandacultureDetailsSP(PandacultureDetailsSPBean bean);

    }
    interface Presenter extends BasePresenter{
        void getPandacultureDetails(String n, String vsid, String p , String serviceId,String em);
        void getPandacultureDetailsSP(String pid);
    }

}
