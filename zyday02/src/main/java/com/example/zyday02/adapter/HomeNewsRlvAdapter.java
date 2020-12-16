package com.example.zyday02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.zyday02.R;
import com.example.zyday02.model.bean.NewsBean;

import java.util.ArrayList;

public class HomeNewsRlvAdapter extends RecyclerView.Adapter<HomeNewsRlvAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<NewsBean.NewsDTO> mList;

    public HomeNewsRlvAdapter(Context mContext, ArrayList<NewsBean.NewsDTO> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsBean.NewsDTO dto = mList.get(position);
        Glide.with(mContext).load(dto.getImageUrl()).into(holder.img);
        holder.title.setText(dto.getTile());
        holder.content.setText(dto.getContent());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView title;
        private TextView content;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.item_news_img);
            title=itemView.findViewById(R.id.item_news_tv_title);
            content=itemView.findViewById(R.id.item_news_tv_content);
        }
    }
}
