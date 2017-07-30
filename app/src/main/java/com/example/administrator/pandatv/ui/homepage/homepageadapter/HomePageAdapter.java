package com.example.administrator.pandatv.ui.homepage.homepageadapter;


import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.pandatv.R;import com.example.administrator.pandatv.entity.HomePageBean;
import com.example.administrator.pandatv.net.HttpFactroy;
import com.example.administrator.pandatv.widget.view.BannerImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/29.
 */

public class HomePageAdapter extends RecyclerView.Adapter {

    private List<Object> datas;
    private LayoutInflater inflater;
    public static final int BIGIMG = 0;//代表轮播图
    public static final int AREA = 1;//代表轮播图
    public static final int PANDAEYE = 2;//代表轮播图
    public static final int PANDALIVE = 3;
    public static final int WALLLIVE = 4;//代表轮播图
    public static final int CHINALIVE = 5;//代表轮播图
    public static final int INTERACTIVE = 6;//代表轮播图
    public static final int CCTV = 7;//代表轮播图
    public static final int LIST = 8;//代表轮播图
    private Context context;

    public HomePageAdapter(Context context, List<Object> datas) {
        this.context = context;
        this.datas = datas;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        Object obj = datas.get(position);
        if (position == 0) {
            return BIGIMG;
        } else if (obj instanceof HomePageBean.DataBean.AreaBean) {
            return AREA;
        } else if (obj instanceof HomePageBean.DataBean.PandaeyeBean) {
            return PANDAEYE;
        } else if (obj instanceof HomePageBean.DataBean.PandaliveBean) {
            return PANDALIVE;
        } else if (obj instanceof HomePageBean.DataBean.InteractiveBean) {
            return INTERACTIVE;
        } else if (position==8) {
            return LIST;
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case BIGIMG:
                View bigImg = inflater.inflate(R.layout.home_head_item, null);
                return new BigImgHolder(bigImg);
            case AREA:
                View areaView = inflater.inflate(R.layout.home_jcts_item, null);
                return new AreaHolder(areaView);
            case PANDAEYE:
                View pandaeyeView = inflater.inflate(R.layout.home_pandaeye_item, null);
                return new PandaEyeHolder(pandaeyeView);
            case PANDALIVE:
                View pandalive = inflater.inflate(R.layout.home_pandalive_item, null);
                return new PandaLiveHolder(pandalive);
            case INTERACTIVE:
                View interactiveview = inflater.inflate(R.layout.home_interactive_item, null);
                return new InteractiveHolder(interactiveview);
            case LIST:
                View list = inflater.inflate(R.layout.home_pandalive_item, null);
                return new ListHolder(list);
        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case BIGIMG:
                BigImgHolder bigImgHolder = (BigImgHolder) holder;
//                List<HomePageBean.DataBean.BigImgBean> bigImgs = (List<HomePageBean.DataBean.BigImgBean>) datas.get(position);
//                loadBigImg(bigImgHolder,bigImgs);
                break;
            case AREA:
                AreaHolder areaHolder = (AreaHolder) holder;
                HomePageBean.DataBean.AreaBean areaBean = (HomePageBean.DataBean.AreaBean) datas.get(position);
                loadArea(areaHolder, areaBean);
                break;
            case PANDAEYE:
                PandaEyeHolder pandaEyeHolder = (PandaEyeHolder) holder;
                HomePageBean.DataBean.PandaeyeBean pandaeyeBean = (HomePageBean.DataBean.PandaeyeBean) datas.get(position);
                loadPandaEye(pandaEyeHolder, pandaeyeBean);
                break;
            case PANDALIVE:
                PandaLiveHolder pandaLiveHolder = (PandaLiveHolder) holder;
                HomePageBean.DataBean.PandaliveBean pandaliveBean  = (HomePageBean.DataBean.PandaliveBean) datas.get(position);
                loadPandaLive(pandaLiveHolder,pandaliveBean);
                break;
            case INTERACTIVE:
                InteractiveHolder interactiveHolder = (InteractiveHolder) holder;
                HomePageBean.DataBean.InteractiveBean interactiveBean = (HomePageBean.DataBean.InteractiveBean) datas.get(position);
                loadInteractive(interactiveHolder, interactiveBean);
                break;
            case LIST:
                ListHolder listHolder = (ListHolder) holder;
                HomePageBean.DataBean.ListBeanXXX listBeanXXX = (HomePageBean.DataBean.ListBeanXXX) datas.get(position);
                LoadList(listHolder,listBeanXXX);
                break;
        }
    }

    private void loadPandaLive(PandaLiveHolder pandaliveholder,HomePageBean.DataBean.PandaliveBean pandalivebean){
        pandaliveholder.livepanda_title.setText(pandalivebean.getTitle());
        GridLayoutManager manager   = new GridLayoutManager(context,3);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerView livepanda_recyclerview = pandaliveholder.livepanda_recyclerview;
        List<HomePageBean.DataBean.PandaliveBean.ListBean> list = pandalivebean.getList();
        livepanda_recyclerview.setLayoutManager(manager);
        livepanda_recyclerview.setAdapter(new PandaLiveAdapter(context,list));
    }

    private void loadInteractive(InteractiveHolder interactiveHolder, HomePageBean.DataBean.InteractiveBean interactiveBean) {
        interactiveHolder.interactive_title.setText(interactiveBean.getTitle());
        List<HomePageBean.DataBean.InteractiveBean.InteractiveoneBean> interactiveone = interactiveBean.getInteractiveone();
        for (int i = 0; i < interactiveone.size(); i++) {
            HttpFactroy.create().loadImage(interactiveone.get(i).getImage(), interactiveHolder.interactive_img);
            interactiveHolder.interactive_img_title.setText(interactiveone.get(i).getTitle());
        }

    }


    private void loadBigImg(BigImgHolder bigImgHolder, List<HomePageBean.DataBean.BigImgBean> bigImgs) {
        List<String> listBig = new ArrayList<>();
        List<String> listTitle = new ArrayList<>();
        for (int i = 0; i < bigImgs.size(); i++) {
            HomePageBean.DataBean.BigImgBean bigImgBean = bigImgs.get(i);
            listBig.add(bigImgBean.getImage());
            listTitle.add(bigImgBean.getTitle());
        }
        bigImgHolder.banner.setImageLoader(new BannerImageLoader());
        bigImgHolder.banner.isAutoPlay(true);
        bigImgHolder.banner.setDelayTime(2000);
        bigImgHolder.banner.setImages(listBig);
        bigImgHolder.banner.setBannerTitles(listTitle);
        bigImgHolder.banner.start();
    }


    @Override
    public int getItemCount() {
        return datas.size();
    }

    private void loadArea(AreaHolder areaHolder, HomePageBean.DataBean.AreaBean areaBean) {
        List<HomePageBean.DataBean.AreaBean.ListscrollBean> listscroll = areaBean.getListscroll();
        HttpFactroy.create().loadImage(areaBean.getImage(), areaHolder.jcts_img);
        RecyclerView jcts_recyclerview = areaHolder.jcts_recyclerview;
        TextView jcts_title = areaHolder.jcts_title;
        jcts_title.setText(areaBean.getTitle());
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        jcts_recyclerview.setLayoutManager(manager);
        jcts_recyclerview.setAdapter(new AreaAdapter(context, listscroll));

    }
    private void LoadList(ListHolder listHolder,HomePageBean.DataBean.ListBeanXXX listBeanXXX){
        listHolder.livepanda_title.setText(listBeanXXX.getTitle());
        RecyclerView livepanda_recyclerview = listHolder.livepanda_recyclerview;

    }

    private void loadPandaEye(PandaEyeHolder pandaEyeHolder, HomePageBean.DataBean.PandaeyeBean pandaeyeBean) {
        HttpFactroy.create().loadImage(pandaeyeBean.getPandaeyelogo(), pandaEyeHolder.pandaeye_img);
        pandaEyeHolder.pandaeye_title.setText(pandaeyeBean.getTitle());
        List<HomePageBean.DataBean.PandaeyeBean.ItemsBean> items = pandaeyeBean.getItems();
        RecyclerView pandaeye_up_recyclerview = pandaEyeHolder.pandaeye_up_recyclerview;
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        pandaeye_up_recyclerview.setLayoutManager(manager);
        pandaeye_up_recyclerview.setAdapter(new PandaEyeUpAdapter(context, items));

    }

    class BigImgHolder extends RecyclerView.ViewHolder {
        private Banner banner;
        private TextView homepage_title;

        public BigImgHolder(View itemView) {
            super(itemView);
            banner = (Banner) itemView.findViewById(R.id.homepage_banner);
//            homepage_title = (TextView) itemView.findViewById(R.id.homepage_banner);
        }
    }

    class AreaHolder extends RecyclerView.ViewHolder {
        private ImageView jcts_img;
        private TextView jcts_title;
        private RecyclerView jcts_recyclerview;

        public AreaHolder(View itemView) {
            super(itemView);
            jcts_img = (ImageView) itemView.findViewById(R.id.jcts_img);
            jcts_recyclerview = (RecyclerView) itemView.findViewById(R.id.jsts_recyclerview);
            jcts_title = (TextView) itemView.findViewById(R.id.jcts_title);
        }
    }

    class PandaEyeHolder extends RecyclerView.ViewHolder {
        private TextView pandaeye_title;
        private ImageView pandaeye_img;
        private RecyclerView pandaeye_up_recyclerview;

        public PandaEyeHolder(View itemView) {
            super(itemView);
            pandaeye_title = (TextView) itemView.findViewById(R.id.pandaeye_title);
            pandaeye_img = (ImageView) itemView.findViewById(R.id.pandaeye_img);
            pandaeye_up_recyclerview = (RecyclerView) itemView.findViewById(R.id.pandaeye_up_recyclerview);
        }
    }

    class InteractiveHolder extends RecyclerView.ViewHolder {
        private TextView interactive_title;
        private TextView interactive_img_title;
        private ImageView interactive_img;

        public InteractiveHolder(View itemView) {
            super(itemView);
            interactive_title = (TextView) itemView.findViewById(R.id.interactive_title);
            interactive_img = (ImageView) itemView.findViewById(R.id.interactive_img);
            interactive_img_title = (TextView) itemView.findViewById(R.id.interactive_img_title);
        }


    }
    class PandaLiveHolder extends RecyclerView.ViewHolder {
        TextView  livepanda_title;
        RecyclerView livepanda_recyclerview;
        public PandaLiveHolder(View itemView) {
            super(itemView);
            livepanda_title= (TextView) itemView.findViewById(R.id.livepanda_title);
            livepanda_recyclerview  = (RecyclerView) itemView.findViewById(R.id.livepanda_recyclerview);
        }

    }
    class ListHolder extends RecyclerView.ViewHolder{
        TextView  livepanda_title;
        RecyclerView livepanda_recyclerview;
        public ListHolder(View itemView) {
            super(itemView);
            livepanda_title= (TextView) itemView.findViewById(R.id.livepanda_title);
            livepanda_recyclerview  = (RecyclerView) itemView.findViewById(R.id.livepanda_recyclerview);
        }
    }
}
