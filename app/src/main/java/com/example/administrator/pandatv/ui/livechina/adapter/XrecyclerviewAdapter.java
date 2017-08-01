package com.example.administrator.pandatv.ui.livechina.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.entity.LiveChinaBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class XrecyclerviewAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<LiveChinaBean.LiveBean> list;

    public XrecyclerviewAdapter(Context context, List<LiveChinaBean.LiveBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.live_china_item, null);
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);
        return new ViewHplder(view);

    }

    class ViewHplder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.livechina_adapter_title)
        TextView livechinaAdapterTitle;
        @BindView(R.id.livechina_adapter_conimag)
        CheckBox livechinaAdapterConimag;
        @BindView(R.id.livechina_ada_linear_jianjie)
        LinearLayout livechinaAdaLinearJianjie;
        @BindView(R.id.livechina_adapter_jianjie)
        TextView livechinaAdapterJianjie;
        public ViewHplder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            livechinaAdapterConimag.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.livechina_adapter_conimag:
                    boolean checked = livechinaAdapterConimag.isChecked();
                    if (checked) {
                        livechinaAdapterJianjie.setVisibility(View.VISIBLE);
                    } else {
                        livechinaAdapterJianjie.setVisibility(View.GONE);
                    }
                    break;

            }
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHplder mholder = (ViewHplder) holder;
        mholder.livechinaAdapterConimag.setChecked(false);
        mholder.livechinaAdapterTitle.setText(list.get(position).getTitle());
        mholder.livechinaAdapterJianjie.setText(list.get(position).getBrief());
//        VideoUtils.getUtils().playVideo(mholder.livechinaAdapterJcVideo, "http://video.jiecao.fm/11/23/xin/%E5%81%87%E4%BA%BA.mp4", "", list.get(position).getImage());
//        Glide.with(context).load(list.get(position).getImage()).into(mholder.livechinaAdapterImge);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
