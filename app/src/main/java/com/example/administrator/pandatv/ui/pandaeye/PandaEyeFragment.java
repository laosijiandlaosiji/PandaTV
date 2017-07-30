package com.example.administrator.pandatv.ui.pandaeye;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseFragment;
import com.example.administrator.pandatv.entity.PandaEyeBean;
import com.example.administrator.pandatv.net.HttpFactroy;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/28.
 */

public class PandaEyeFragment extends BaseFragment implements PandaEyeContract.View {
    @BindView(R.id.pandaeye_xRecyclerview)
    XRecyclerView pandaeyeXRecyclerview;
    private ImageView pandaeye_img;
    private TextView pandaeye_title;


    @Override
    protected int getLayoutId() {
        return R.layout.pandaeyefragment;
    }

    @Override
    protected void init(View view) {
        View head = View.inflate(getContext(), R.layout.pandaeye_item, null);
        pandaeye_img = (ImageView) head.findViewById(R.id.pandaeye_img);
        pandaeye_title = (TextView) head.findViewById(R.id.pandaeye_title);
        pandaeyeXRecyclerview.addHeaderView(head);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void showPandaBean(PandaEyeBean pandaEyeBean) {
        List<PandaEyeBean.DataBean.BigImgBean> bigImg = pandaEyeBean.getData().getBigImg();
        HttpFactroy.create().loadImage(bigImg.get(0).getImage(),pandaeye_img);
        pandaeye_title.setText(bigImg.get(0).getTitle());
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

    }


}
