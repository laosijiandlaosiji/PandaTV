package com.example.administrator.pandatv.ui.pandaeye.PandaEyeAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.entity.PandaEyeListurlBean;
import com.example.administrator.pandatv.net.HttpFactroy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Administrator on 2017/7/30.
 */

public class PandaEyeAdapter extends RecyclerView.Adapter {

    private ArrayList<PandaEyeListurlBean> datas;
    private Context context;

    public PandaEyeAdapter(ArrayList<PandaEyeListurlBean> datas, Context context) {
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
        PandaEyeListurlBean pandaEyeListurlBean = datas.get(position);
        List<PandaEyeListurlBean.ListBean> list = pandaEyeListurlBean.getList();
        viewHolder.pandaeye__time.setText(list.get(position).getTitle());
        viewHolder.pandaeye__newstime.setText(list.get(position).getVideolength());
        HttpFactroy.create().loadImage(list.get(position).getPicurl(),viewHolder.pandaeye_iamge);
        long focus_date = list.get(position).getFocus_date();
        Date dat = new Date(focus_date);
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dat);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = format.format(gc.getTime());
        viewHolder.pandaeye__time.setText(time);
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
