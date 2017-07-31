package com.example.administrator.pandatv.ui.homepage.homepageadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.entity.HomePageBean;

import java.util.List;


/**
 * Created by Administrator on 2017/7/29.
 */

public class PandaEyeUpAdapter extends RecyclerView.Adapter{
    private Context context;
    private List<HomePageBean.DataBean.PandaeyeBean.ItemsBean> itemsBeen;
    public PandaEyeUpAdapter(Context context, List<HomePageBean.DataBean.PandaeyeBean.ItemsBean> itemsBeen) {
        this.context = context;
        this.itemsBeen = itemsBeen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.pandaeye_up_item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.pandaeye_up_text.setText(itemsBeen.get(position).getBrief());
        viewHolder.jcts_title.setText(itemsBeen.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return itemsBeen.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView jcts_title;
        TextView pandaeye_up_text;
        public ViewHolder(View itemView) {
            super(itemView);
            jcts_title = (TextView) itemView.findViewById(R.id.pandaeye_up_title);
            pandaeye_up_text = (TextView) itemView.findViewById(R.id.pandaeye_up_text);
        }
    }
}
