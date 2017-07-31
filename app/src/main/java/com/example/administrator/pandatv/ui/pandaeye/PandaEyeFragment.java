package com.example.administrator.pandatv.ui.pandaeye;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseFragment;
import com.example.administrator.pandatv.entity.PandaEyeBean;
import com.example.administrator.pandatv.entity.PandaEyeListurlBean;
import com.example.administrator.pandatv.net.HttpFactroy;
import com.example.administrator.pandatv.ui.pandaeye.PandaEyeAdapter.PandaEyeAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/28.
 */

public class PandaEyeFragment extends BaseFragment implements PandaEyeContract.View {
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

    @Override
    protected int getLayoutId() {
        return R.layout.pandaeyefragment;
    }

    @Override
    protected void init(View view) {
        new PandaEyePresenter(this);
        datas = new ArrayList<>();
        getHeadLayout();
        adapter = new PandaEyeAdapter(datas,getActivity());
        pandaeyeXRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        pandaeyeXRecyclerview.setAdapter(adapter);
    }
    public void getHeadLayout(){
        head = View.inflate(getContext(), R.layout.pandaeye_item, null);
        pandaye_imgs = (ImageView) head.findViewById(R.id.pandaye_imgs);
        pandaeye_title = (TextView) head.findViewById(R.id.pandaeye_title);
        pandaeyeXRecyclerview.addHeaderView(head);
    }
    @Override
    protected void loadData() {
        presenter.start();
    }


    @Override
    public void showPandaBean(PandaEyeBean pandaEyeBean) {
        List<PandaEyeBean.DataBean.BigImgBean> bigImg = pandaEyeBean.getData().getBigImg();
        pandaeye_title.setText(bigImg.get(position).getTitle());
        presenter.getrurl(pandaEyeBean.getData().getListurl());
        HttpFactroy.create().loadImage(bigImg.get(position).getImage(),pandaye_imgs);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void showUrl(PandaEyeListurlBean pandaEyeListurlBean) {
        list = pandaEyeListurlBean.getList();
        datas.clear();
        datas.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void closeProgress() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(PandaEyeContract.Presenter presenter) {
        this.presenter = presenter;
    }


}
