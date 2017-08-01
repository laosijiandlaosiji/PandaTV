package com.example.administrator.pandatv.ui.pandaculture;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.entity.PandacultureDetailsBean;

import java.util.List;

/**
 * Created by li on 2017/7/29.
 */

public class PandacultureDetailsAdapter extends BaseAdapter{

    private Context context;
    private List<PandacultureDetailsBean.VideoBean> list;
    private Holder holder;
//
    public PandacultureDetailsAdapter(Context context, List<PandacultureDetailsBean.VideoBean> list) {
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

            convertView = LayoutInflater.from(context).inflate(R.layout.detils_item,null);
            holder.panda_culturetitle = (TextView) convertView.findViewById(R.id.panda_culture_detial_item_title);
            holder.panda_oculturesptime = (TextView) convertView.findViewById(R.id.panda_culture_detial_item_sp_time);
            holder.panda_cultureimage = (ImageView) convertView.findViewById(R.id.panda_culture_detial_item_image);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }
            holder.panda_culturetitle.setText(list.get(position).getT());
            holder.panda_oculturesptime.setText(list.get(position).getLen());
            Glide.with(context).load(list.get(position).getImg()).into(holder.panda_cultureimage);
        return convertView;
    }

    class Holder{
        TextView panda_oculturesptime;
        TextView panda_culturetitle;
        ImageView panda_cultureimage;
    }


}
