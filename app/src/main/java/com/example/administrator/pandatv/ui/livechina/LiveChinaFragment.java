package com.example.administrator.pandatv.ui.livechina;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseFragment;
import com.example.administrator.pandatv.entity.LiveChinaBean;
import com.example.administrator.pandatv.entity.SceneryBean;
import com.example.administrator.pandatv.ui.livechina.adapter.DragAdapter;
import com.example.administrator.pandatv.ui.livechina.adapter.GridViewAdapter;
import com.example.administrator.pandatv.ui.livechina.adapter.LoadFragmentAdapter;
import com.example.administrator.pandatv.widget.manager.ToastManager;
import com.example.administrator.pandatv.widget.view.CustomDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/28.
 */

public class LiveChinaFragment extends BaseFragment implements View.OnClickListener,LiveChinaContract.View {

    @BindView(R.id.liveChina_tablayout)
    TabLayout liveChinaTablayout;
    @BindView(R.id.sure)
    ImageButton sure;
    @BindView(R.id.liveChina_viewpager)
    ViewPager liveChinaViewpager;
    @BindView(R.id.livechina_probar)
    ProgressBar livechinaProbar;
    @BindView(R.id.livechina_relalayout)
    RelativeLayout livechinaRelalayout;

    private ArrayList<BaseFragment> list;
    private ArrayList<String> strings;
    private PopupWindow popupWindow;
    private View view1;
    private ArrayList<SceneryBean.AlllistBean> list1;
    private GridViewAdapter gridViewAdapter;
    private GridView gridview;
    private DragAdapter dragAdapter;
    private ArrayList<String> strings1;
    private ArrayList<String> urls;
    private boolean flag = false;
    private Button but;
    private DragGridView dragGridView;
    private List<SceneryBean.AlllistBean> alllist;
    private LoadFragmentAdapter loadFragmentAdapter;
    private LiveChinaContract.Presenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.main_livechina;
    }

    @Override
    protected void init(View view) {
        list = new ArrayList<BaseFragment>();
        sure.setOnClickListener(this);
        strings = new ArrayList<String>();
        new LiveChinaPresenter(this);
        loadFragmentAdapter = new LoadFragmentAdapter(getActivity().getSupportFragmentManager(), list, strings);
        liveChinaViewpager.setAdapter(loadFragmentAdapter);
        liveChinaTablayout.setupWithViewPager(liveChinaViewpager);
        liveChinaTablayout.setTabMode(TabLayout.MODE_FIXED);
        liveChinaTablayout.setMinimumWidth(200);

        view1 = View.inflate(getActivity(), R.layout.live_china_popupwindow, null);
        popupWindow = new PopupWindow(view1);

        popupWindow.setWidth(ViewPager.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewPager.LayoutParams.MATCH_PARENT);
        ImageButton popupwindowButton = (ImageButton) view1.findViewById(R.id.live_china_pwindow_button);
        but = (Button) view1.findViewById(R.id.but);
        setDragGridView();
        but.setOnClickListener(this);
        popupwindowButton.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        urls = new ArrayList<>();
        presenter.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.live_china_pwindow_button:
                setTablayout();
                popupWindow.dismiss();
                break;
            case R.id.but:
                if (but.getText().toString().equals("编辑")) {
                    but.setText("完成");
                    dragAdapter.flag = true;
                    dragGridView.setEnabled(true);
                    gridview.setEnabled(true);
                    flag = true;
                    dragAdapter.notifyDataSetChanged();
                } else {
                    dragAdapter.flag = false;
                    but.setText("编辑");
                    dragGridView.setEnabled(false);
                    gridview.setEnabled(false);
                    flag = false;
                    dragAdapter.notifyDataSetChanged();
                }
                break;
            case R.id.sure:
                popupWindow.showAtLocation(view1, Gravity.CENTER, 0, 0);
                break;
        }
    }

    private void setDragGridView() {

        dragGridView = (DragGridView) view1.findViewById(R.id.live_china_pwindow_DragGridview);
        dragGridView.setEnabled(false);
        strings1 = new ArrayList<String>();
        dragAdapter = new DragAdapter(getActivity(), strings1);
        dragGridView.setAdapter(dragAdapter);


        list1 = new ArrayList<SceneryBean.AlllistBean>();
        gridview = (GridView) view1.findViewById(R.id.live_china_gridview);
        gridViewAdapter = new GridViewAdapter(list1, getActivity());
        gridview.setEnabled(false);
        gridview.setAdapter(gridViewAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (flag) {
                    strings1.add(list1.get(position).getTitle());
                    urls.add(list1.get(position).getUrl());
                    list1.remove(position);
                    gridViewAdapter.notifyDataSetChanged();
                    dragAdapter.notifyDataSetChanged();
                }
            }
        });

        dragGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (flag) {
                    if (strings1.size() <= 5) {
                        ToastManager.show("栏目区，不能少于五个频道");
                    } else {
                        strings1.remove(position-1);
                        urls.remove(position-1);
                        dragAdapter.notifyDataSetChanged();

                        for (int i = 0; i < alllist.size(); i++) {
                            if (strings1.get(position-1).equals(alllist.get(i).getTitle())) {
                                list1.add(alllist.get(i));
                                gridViewAdapter.notifyDataSetChanged();
                            }
                        }
                    }
                }

            }
        });
    }

    private void setTablayout() {
        list.clear();
        strings.clear();
        for (int i = 0; i < strings1.size(); i++) {
            LiveFragment pageFragment = new LiveFragment();
            pageFragment.s = urls.get(i);
            list.add(pageFragment);
            new LiveChinaPresenter(pageFragment);
            strings.add(strings1.get(i));
            loadFragmentAdapter.notifyDataSetChanged();
        }
        liveChinaViewpager.setOffscreenPageLimit(strings.size());
    }

    @Override
    public void showProgress() {
        CustomDialog.show(getContext());
    }

    @Override
    public void closeProgress() {
        CustomDialog.dimiss();
    }

    @Override
    public void showMessage(String msg) {
        ToastManager.show(msg);
    }

    @Override
    public void setPresenter(LiveChinaContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setLiveChina(LiveChinaBean netBean) {

    }

    @Override
    public void setScenery(SceneryBean netBean) {
        alllist = netBean.getAlllist();
        list1.addAll(alllist);
        gridViewAdapter.notifyDataSetChanged();
        setGridViewHeightBasedOnChildren(gridview);

        List<SceneryBean.TablistBean> tablist = netBean.getTablist();
        for (int i = 0; i < tablist.size(); i++) {
            String title = tablist.get(i).getTitle();
            urls.add(tablist.get(i).getUrl());
            strings1.add(title);
            dragAdapter.notifyDataSetChanged();
        }
        for (int i = 0; i < list1.size(); i++) {
            for (int i1 = 0; i1 < strings1.size(); i1++) {
                if (list1.get(i).getTitle().equals(strings1.get(i1))) {
                    list1.remove(list1.get(i));
                    gridViewAdapter.notifyDataSetChanged();
                }
            }
        }
        setTablayout();
    }

    /**
     * 动态设置GridView的高度
     */
    public static void setGridViewHeightBasedOnChildren(GridView gridView) {
        if (gridView == null) return;

        ListAdapter listAdapter = gridView.getAdapter();

        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, gridView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = gridView.getLayoutParams();
        params.height = (totalHeight + (gridView.getMeasuredHeight() * (listAdapter.getCount() - 1))) / 3;
        gridView.setLayoutParams(params);
    }
}
