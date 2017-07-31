package com.example.administrator.pandatv.ui.homepage.homepageadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.entity.HomeListBean;
import com.example.administrator.pandatv.net.HttpFactroy;

import java.util.List;

/**
 * Created by Administrator on 2017/7/30.
 */

public class ChinaAdapter extends RecyclerView.Adapter {

    private List<HomeListBean.ListBean> datas;
    private Context context;

    public ChinaAdapter(List<HomeListBean.ListBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.pandaeye_down_item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        HomeListBean.ListBean listBean = datas.get(position);
        viewHolder.pandaeye__newstime.setText(listBean.getVideoLength());
        HttpFactroy.create().loadImage(listBean.getImage(),viewHolder.pandaeye_iamge);
        viewHolder.pandaeye__time.setText(listBean.getDaytime());
        viewHolder.pandaeye_title.setText(listBean.getTitle());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView pandaeye_iamge;
        TextView pandaeye__newstime;
        TextView pandaeye_title;
        TextView pandaeye__time;
        public ViewHolder(View itemView) {
            super(itemView);
            pandaeye_iamge= (ImageView) itemView.findViewById(R.id.pandaeye_iamge);
            pandaeye__newstime = (TextView) itemView.findViewById(R.id.pandaeye__newstime);
            pandaeye_title = (TextView) itemView.findViewById(R.id.pandaeye__title);
            pandaeye__time = (TextView) itemView.findViewById(R.id.pandaeye__time);
        }

    }
}
