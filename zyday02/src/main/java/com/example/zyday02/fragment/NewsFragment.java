package com.example.zyday02.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zyday02.R;
import com.example.zyday02.adapter.HomeNewsRlvAdapter;
import com.example.zyday02.model.bean.NewsBean;
import com.example.zyday02.presenter.HomeNewsPresenterImllp;
import com.example.zyday02.view.IHomeNewsView;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment implements IHomeNewsView {
    private RecyclerView news_rlv;
    private HomeNewsPresenterImllp presenter;
    private ArrayList<NewsBean.NewsDTO> mList;
    private HomeNewsRlvAdapter rlvAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        initView(view);
        initDate();
        return view;
    }

    private void initView(View view) {
        news_rlv=view.findViewById(R.id.news_rlv);
        news_rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        news_rlv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        mList = new ArrayList<>();

        rlvAdapter = new HomeNewsRlvAdapter(getActivity(), mList);
        news_rlv.setAdapter(rlvAdapter);

    }

    private void initDate() {
        presenter = new HomeNewsPresenterImllp(this);
        presenter.start();

    }

    @Override
    public void onShowScuess(Object object) {
        if(object instanceof NewsBean){
            NewsBean bean= (NewsBean) object;
            List<NewsBean.NewsDTO> news = bean.getNews();
            mList.addAll(news);
            rlvAdapter.notifyDataSetChanged();

        }
    }

    @Override
    public void onShowFail(String errorMsg) {
        Log.e("TAG","网络数据错误"+errorMsg);
    }
}