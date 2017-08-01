package com.example.administrator.pandatv.ui.pandalive.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.entity.PandaLiveOtherFragentBean;

import java.util.List;

/**
 * Created by li on 2017/7/30.
 */

public class PandaLiveOtherFragmentListAdapter extends BaseAdapter {

    private Context context;
    private List<PandaLiveOtherFragentBean.VideoBean> list;
    private PandaLiveOtherFragmentListAdapter.Holder holder;

    public PandaLiveOtherFragmentListAdapter(Context context, List<PandaLiveOtherFragentBean.VideoBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            holder = new PandaLiveOtherFragmentListAdapter.Holder();

            convertView = LayoutInflater.from(context).inflate(R.layout.pandlive_otherfragment_recycler_item,null);
            holder.panda_culturetime = (TextView) convertView.findViewById(R.id.pandaLive_otherfragment_itemTime);
            holder.panda_culturetitle = (TextView) convertView.findViewById(R.id.pandaLive_otherfragment_itemTitle);
            holder.panda_oculturesptime = (TextView) convertView.findViewById(R.id.pandaLive_otherfragment_itemspTime);
            holder.panda_cultureimage = (ImageView) convertView.findViewById(R.id.pandaLive_otherfragment_itemImg);
            convertView.setTag(holder);
        }else {
            holder = (PandaLiveOtherFragmentListAdapter.Holder) convertView.getTag();
        }
        holder.panda_culturetime.setText(list.get(position).getPtime());
        holder.panda_culturetitle.setText(list.get(position).getT());
        holder.panda_oculturesptime.setText(list.get(position).getLen());
        Glide.with(context).load(list.get(position).getImg()).into(holder.panda_cultureimage);
        return convertView;
    }

    class Holder{
        TextView panda_oculturesptime;
        TextView panda_culturetitle;
        TextView panda_culturetime;
        ImageView panda_cultureimage;
    }
}
