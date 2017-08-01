package com.example.administrator.pandatv.ui.pandalive.fragment.WatchAndChatFragment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.entity.WatchandChatBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by li on 2017/7/30.
 */
//
public class WatchAndChatFragmentListAdapter extends BaseAdapter {

    private Context context;
    private List<WatchandChatBean.DataBean.ContentBean> list;
    private WatchAndChatFragmentListAdapter.Holder holder;
    private String total;
    private int time;
    public WatchAndChatFragmentListAdapter(Context context, List<WatchandChatBean.DataBean.ContentBean> list,String total,int time) {
        this.context = context;
        this.list = list;
        this.total = total;
        this.time = time;
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
            holder = new WatchAndChatFragmentListAdapter.Holder();

            convertView = LayoutInflater.from(context).inflate(R.layout.watchandchat_list_item,null);
            holder.watchChat_author = (TextView) convertView.findViewById(R.id.watchChat_author);
            holder.watchChat_total = (TextView) convertView.findViewById(R.id.watchChat_total);
            holder.watchChat_message = (TextView) convertView.findViewById(R.id.watchChat_message);
            holder.watchChat_date = (TextView) convertView.findViewById(R.id.watchChat_date);
            convertView.setTag(holder);
        }else {
            holder = (WatchAndChatFragmentListAdapter.Holder) convertView.getTag();
        }
        holder.watchChat_author.setText(list.get(position).getAuthor());
        holder.watchChat_message.setText(list.get(position).getMessage());
        holder.watchChat_total.setText(total);
        Date date = new Date(time);
        long time1 = date.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(time1);
        Log.d("WatchAndChatFragmentLis","fdfdfdf"+ format);
        holder.watchChat_date.setText(format);
        return convertView;
    }

    class Holder{
        TextView watchChat_author;
        TextView watchChat_total;
        TextView watchChat_message;
        TextView watchChat_date;
    }
}
