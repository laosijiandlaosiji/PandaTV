package com.example.administrator.pandatv.base;


import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseViewHolder>{

    protected Context context;
    protected ArrayList<T> arrayList;
    private int mLayoutRes;

    public BaseRecyclerAdapter(Context context, @NonNull ArrayList<T> arrayList, @LayoutRes int mLayoutRes) {
        this.context = context;
        this.arrayList = arrayList;
        this.mLayoutRes = mLayoutRes;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return BaseViewHolder.get(context,mLayoutRes,parent);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        convert(holder,arrayList.get(position));
    }

    protected abstract void convert(BaseViewHolder holder, T t);

    @Override
    public int getItemCount() {
        if(arrayList == null) {
            return  0;
        }
        return arrayList.size();
    }
}
