package com.example.administrator.pandatv.base;


import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.pandatv.net.HttpFactroy;

public class BaseViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;
    private Context context;

    public BaseViewHolder(View itemView) {
        super(itemView);
        mViews = new SparseArray<>();
    }

    public BaseViewHolder(View itemView, Context context){
        super(itemView);
        this.context = context;
    }

//    获取view
    public static BaseViewHolder get(Context context, @LayoutRes int LayoutRes, ViewGroup parent){
        View view = LayoutInflater.from(context).inflate(LayoutRes,parent,false);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);
        return new BaseViewHolder(view);
    }

    public <T extends View> T getView(@IdRes int viewId){
        View view = mViews.get(viewId);

        if(view == null) {
            view = itemView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T) view;
    }

    public View getItemView(){
        return itemView;
    }

    public BaseViewHolder setText(@IdRes int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    public BaseViewHolder setImg(@IdRes int imgId,String url){
        ImageView view = getView(imgId);
        HttpFactroy.create().loadImage(url,view);
        return this;
    }

    public BaseViewHolder setTextColor(@IdRes int viewId, @ColorInt int color) {
        TextView view = getView(viewId);
        view.setTextColor(color);
        return this;
    }

    public BaseViewHolder setOnItemClickListener(View.OnClickListener listener) {
        itemView.setOnClickListener(listener);
        return this;
    }
}
