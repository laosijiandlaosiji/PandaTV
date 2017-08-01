package com.example.administrator.pandatv.ui.pandaculture;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.entity.PandacultureListViewBean;

import java.util.List;

/**
 * Created by li on 2017/7/29.
 */

public class PandacultureXrecyClerAdapter extends BaseAdapter{

    private Context context;
    private List<PandacultureListViewBean.ListBean> list;
    private Holder holder;

    public PandacultureXrecyClerAdapter(Context context, List<PandacultureListViewBean.ListBean> list) {
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
            holder = new Holder();

            convertView = LayoutInflater.from(context).inflate(R.layout.panda_culture_xrecycler_item,null);
            holder.panda_culturetime = (TextView) convertView.findViewById(R.id.panda_culture_item_time);
            holder.panda_culturetitle = (TextView) convertView.findViewById(R.id.panda_culture_item_title);
            holder.panda_oculturesptime = (TextView) convertView.findViewById(R.id.panda_oculture_item_sp_time);
            holder.panda_cultureimage = (ImageView) convertView.findViewById(R.id.panda_culture_item_image);
            holder.panda_culture_item_intent = (RelativeLayout) convertView.findViewById(R.id.panda_culture_item_intent);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }//
            holder.panda_culturetime.setText(list.get(position).getBrief());
            holder.panda_culturetitle.setText(list.get(position).getTitle());
            holder.panda_oculturesptime.setText(list.get(position).getVideoLength());
            Glide.with(context).load(list.get(position).getImage()).into(holder.panda_cultureimage);
        return convertView;
    }

    class Holder{
        TextView panda_oculturesptime;
        TextView panda_culturetitle;
        TextView panda_culturetime;
        ImageView panda_cultureimage;
        RelativeLayout panda_culture_item_intent;
    }


}
