package com.example.asus.thelistshows.pice.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.asus.thelistshows.MainActivity;
import com.example.asus.thelistshows.R;
import com.example.asus.thelistshows.bean.UserBean;
import com.example.asus.thelistshows.pice.PiceActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import io.reactivex.annotations.NonNull;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<UserBean.DataBean> list;
    private LayoutInflater inflater;
    private static final int NORMAL = 0;
    private static final int IMAGES = 1;

    public MyAdapter(Context context, List<UserBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        if(viewType == NORMAL){
            View view = inflater.inflate(R.layout.item_layout, parent, false);
            holder = new RvAdapter1(view);
        }else if(viewType == IMAGES){
            View view = inflater.inflate(R.layout.item_layout1, parent, false);
            holder = new RvAdapter2(view);
        }else {
            holder =  null;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        UserBean.DataBean dataBean = list.get(position);
        if("41".equals(dataBean.getType())){
            RvAdapter1 rvAdapter1 = (RvAdapter1) holder;
            rvAdapter1.sdv.setImageURI(Uri.parse(dataBean.getBimageuri()));
            rvAdapter1.t1.setText(dataBean.getText());
            rvAdapter1.t2.setText(dataBean.getPasstime());
            rvAdapter1.vv.setVideoURI(Uri.parse(dataBean.getVideouri()));
            rvAdapter1.vv.start();
        }else{
            RvAdapter2 rvAdapter2 = (RvAdapter2) holder;
            rvAdapter2.sdv1.setImageURI(dataBean.getProfile_image());
            rvAdapter2.t01.setText(dataBean.getText());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        UserBean.DataBean dataBean = list.get(position);
        String type = dataBean.getType();

        if("41".equals(type)){
            return NORMAL;
        }else{
            return IMAGES;
        }
    }

    class RvAdapter1 extends RecyclerView.ViewHolder{

        private final VideoView vv;
        private final SimpleDraweeView sdv;
        private final TextView t1,t2;

        public RvAdapter1(View itemView) {
            super(itemView);
            vv = itemView.findViewById(R.id.vv);
            sdv = itemView.findViewById(R.id.sdv);
            t1 = itemView.findViewById(R.id.text1);
            t2 = itemView.findViewById(R.id.text2);
        }
    }

    class RvAdapter2 extends RecyclerView.ViewHolder{


        private final SimpleDraweeView sdv1;
        private final TextView t01;

        public RvAdapter2(View itemView) {
            super(itemView);
            sdv1 = itemView.findViewById(R.id.sdv1);
            t01 = itemView.findViewById(R.id.text01);
        }
    }
}
