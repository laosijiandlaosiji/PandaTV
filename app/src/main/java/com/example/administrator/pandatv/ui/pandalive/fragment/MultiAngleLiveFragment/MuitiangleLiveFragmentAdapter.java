package com.example.administrator.pandatv.ui.pandalive.fragment.MultiAngleLiveFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.entity.PandaLiveFragmentMultiAngleBean;

import java.util.List;

/**
 * Created by li on 2017/7/30.
 */

public class MuitiangleLiveFragmentAdapter extends BaseAdapter {

    private Context context;
    private List<PandaLiveFragmentMultiAngleBean.ListBean> list;
    private MuitiangleLiveFragmentAdapter.Holder holder;

    public MuitiangleLiveFragmentAdapter(Context context, List<PandaLiveFragmentMultiAngleBean.ListBean> list) {
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
            holder = new MuitiangleLiveFragmentAdapter.Holder();

            convertView = LayoutInflater.from(context).inflate(R.layout.muitianglelivefragmentadapter_item,null);
            holder.panda_culturetitle = (TextView) convertView.findViewById(R.id.muitianglelivefragmentadapter_item_title);
            holder.panda_cultureimage = (ImageView) convertView.findViewById(R.id.muitianglelivefragmentadapter_itemiamge);
            convertView.setTag(holder);
        }else {
            holder = (MuitiangleLiveFragmentAdapter.Holder) convertView.getTag();
        }
        holder.panda_culturetitle.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImage()).into(holder.panda_cultureimage);
        return convertView;
    }

    class Holder{
        TextView panda_culturetitle;
        ImageView panda_cultureimage;
    }
}
