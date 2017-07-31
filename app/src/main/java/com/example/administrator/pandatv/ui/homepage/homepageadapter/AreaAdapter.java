package com.example.administrator.pandatv.ui.homepage.homepageadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.entity.HomePageBean;
import com.example.administrator.pandatv.net.HttpFactroy;

import java.util.List;

/**
 * Created by Administrator on 2017/7/29.
 */

public class AreaAdapter extends RecyclerView.Adapter{
    private Context context;
    private List<HomePageBean.DataBean.AreaBean.ListscrollBean> listscrollBeen;
    public AreaAdapter(Context context, List<HomePageBean.DataBean.AreaBean.ListscrollBean> listscrollBeen) {
        this.context = context;
        this.listscrollBeen = listscrollBeen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.area_item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        HttpFactroy.create().loadImage(listscrollBeen.get(position).getImage(),viewHolder.area_img);
        viewHolder.jcts_title.setText(listscrollBeen.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return listscrollBeen.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView jcts_title;
        ImageView area_img;
        public ViewHolder(View itemView) {
            super(itemView);
            jcts_title = (TextView) itemView.findViewById(R.id.area_title);
            area_img = (ImageView) itemView.findViewById(R.id.area_img);
        }
    }
}
