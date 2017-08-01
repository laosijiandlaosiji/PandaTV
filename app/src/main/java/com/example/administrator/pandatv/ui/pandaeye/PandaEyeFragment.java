package com.example.administrator.pandatv.ui.pandaeye;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseFragment;
import com.example.administrator.pandatv.entity.PandaEyeBean;
import com.example.administrator.pandatv.entity.PandaEyeListurlBean;
import com.example.administrator.pandatv.entity.PandaEyeVideoBean;
import com.example.administrator.pandatv.net.HttpFactroy;
import com.example.administrator.pandatv.ui.pandaeye.PandaEyeAdapter.PandaEyeAdapter;
import com.example.administrator.pandatv.widget.manager.ToastManager;
import com.example.administrator.pandatv.widget.view.CustomDialog;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/28.
 */

public class PandaEyeFragment extends BaseFragment implements PandaEyeContract.View ,PandaEyeAdapter.onclicklistener{
    @BindView(R.id.pandaeye_xRecyclerview)
    XRecyclerView pandaeyeXRecyclerview;
    private ImageView pandaye_imgs;
    private TextView pandaeye_title;
    private ArrayList<PandaEyeListurlBean.ListBean> datas;
    private int position = 0;
    PandaEyeContract.Presenter presenter;
    private PandaEyeAdapter adapter;
    private View head;
    private List<PandaEyeListurlBean.ListBean> list;
    private int a = 1;
    private List<PandaEyeBean.DataBean.BigImgBean> bigImg;
    private String listurl;



    @Override
    protected int getLayoutId() {
        return R.layout.pandaeyefragment;
    }

    @Override
    protected void init(View view) {
        new PandaEyePresenter(this);
        datas = new ArrayList<>();
        adapter = new PandaEyeAdapter(datas,getActivity());
        adapter.setOnclicklistener(this);
        pandaeyeXRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        pandaeyeXRecyclerview.setAdapter(adapter);

    }

    @Override
    public void setrefreash() {
        pandaeyeXRecyclerview.setPullRefreshEnabled(true);
        pandaeyeXRecyclerview.setLoadingMoreEnabled(true);
        pandaeyeXRecyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                presenter.start();
                pandaeyeXRecyclerview.refreshComplete();

            }

            @Override
            public void onLoadMore() {
                a++;
                presenter.geturl(listurl,a);
                datas.addAll(list);
            }
        });
    }
    @Override
    public void getHeadLayout(){
        head = View.inflate(getContext(), R.layout.pandaeye_item, null);
        pandaye_imgs = (ImageView) head.findViewById(R.id.pandaye_imgs);
        pandaeye_title = (TextView) head.findViewById(R.id.pandaeye_title);
        pandaeyeXRecyclerview.addHeaderView(head);

    }

    @Override
    public void setOnClicktHeadLayout() {
        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = bigImg.get(0).getUrl();
                ToastManager.show(url);
            }
        });

    }

    @Override
    protected void loadData() {
        presenter.start();
        getHeadLayout();
        setrefreash();
        setOnClicktHeadLayout();
    }


    @Override
    public void showPandaBean(PandaEyeBean pandaEyeBean) {
        listurl = pandaEyeBean.getData().getListurl();
        bigImg = pandaEyeBean.getData().getBigImg();
        pandaeye_title.setText(bigImg.get(position).getTitle());
        presenter.geturl(listurl,a);
        HttpFactroy.create().loadImage(bigImg.get(position).getImage(),pandaye_imgs);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void showUrl(PandaEyeListurlBean pandaEyeListurlBean) {

        list = pandaEyeListurlBean.getList();
        datas.addAll(list);
        pandaeyeXRecyclerview.loadMoreComplete();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showVideo(PandaEyeVideoBean pandaEyeVideoBean) {
        ToastManager.show(pandaEyeVideoBean.getTitle());
    }

    @Override
    public void showProgress() {
        CustomDialog.show(getActivity());
    }

    @Override
    public void closeProgress() {
        CustomDialog.dimiss();
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(PandaEyeContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void onclicklistener(int position) {
        String guid = datas.get(position).getGuid();
        presenter.getVodio(guid);
    }
}
