package com.bwie.test.liuhaifeng201711111.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.bwie.test.liuhaifeng201711111.R;
import com.bwie.test.liuhaifeng201711111.bean.News;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 刘海峰.9:59
 */

public class Myadapter extends RecyclerView.Adapter {

    List<News.DataBean> list;
    private MyViewHolder myViewHolder;
    private OnItemClickListener  mClickListener;

    public Myadapter(List<News.DataBean> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(inflate,mClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        myViewHolder = (MyViewHolder) holder;
        myViewHolder.textView.setText(list.get(position).getTitle());
        Uri uri = Uri.parse(list.get(position).getImg());
        myViewHolder.simpleDraweeView.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.mClickListener=listener;
    }
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private OnItemClickListener mListener;
        public final SimpleDraweeView simpleDraweeView;
        private final TextView textView;

        public MyViewHolder(View itemView,OnItemClickListener  listener) {
            super(itemView);
            mListener=listener;
            //给item设置点击事件
            itemView.setOnClickListener(this);

            //给item设置点击事件

            simpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.sdv_image);
            textView = (TextView) itemView.findViewById(R.id.text);
        }
        @Override
        public void onClick(View v) {
            // getpostion()为Viewholder自带的一个方法，用来获取RecyclerView当前的位置，将此作为参数，传出去
            mListener.onItemClick(v,getPosition());

        }
    }
    public interface OnItemClickListener {
        public void onItemClick(View view, int postion);
    }

}


