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
 * Created by Administrator on 2017/7/30.
 */

public class PandaLiveAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<HomePageBean.DataBean.PandaliveBean.ListBean> listBeen;
    public PandaLiveAdapter(Context context, List<HomePageBean.DataBean.PandaliveBean.ListBean> listBeen) {
        this.context = context;
        this.listBeen = listBeen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.pandalive_item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        HttpFactroy.create().loadImage(listBeen.get(position).getImage(),viewHolder.pandalive_img);
        viewHolder.pandalive_title.setText(listBeen.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return listBeen.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView pandalive_title;
        ImageView pandalive_img;
        public ViewHolder(View itemView) {
            super(itemView);
            pandalive_title = (TextView) itemView.findViewById(R.id.pandalive_title);
            pandalive_img = (ImageView) itemView.findViewById(R.id.pandalive_img);
        }
    }
}
