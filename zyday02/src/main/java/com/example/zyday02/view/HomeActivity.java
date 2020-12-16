package com.example.zyday02.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zyday02.R;
import com.example.zyday02.adapter.HomeVpAdapter;
import com.example.zyday02.fragment.NewsFragment;
import com.example.zyday02.fragment.StudentFragment;
import com.example.zyday02.model.bean.BannerBean;
import com.example.zyday02.presenter.HomePresenterImllp;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements IVHomeView{
    private Banner home_banner;
    private TabLayout home_tab;
    private ViewPager home_vp;
    private HomePresenterImllp presenter;
    private ArrayList<BannerBean.BannerlistDTO> mBannerlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initBannerDate();
        initTab();
    }

    private void initView() {
        home_banner=findViewById(R.id.home_banner);
        home_tab=findViewById(R.id.home_tab);
        home_vp=findViewById(R.id.home_vp);

       // mBannerlist = new ArrayList<>();
    }

    private void initBannerDate() {
        presenter = new HomePresenterImllp(this);
        presenter.starBanner();
    }

    @Override
    public void onShowScuess(Object object) {
        if(object instanceof BannerBean){
            BannerBean bean= (BannerBean) object;
            List<BannerBean.BannerlistDTO> bannerlist = bean.getBannerlist();
            home_banner.setImages(bannerlist).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    BannerBean.BannerlistDTO image= (BannerBean.BannerlistDTO) path;
                   Glide.with(HomeActivity.this).load(image.getImageurl()).into(imageView);
                }
            }).start();
        }
    }

    @Override
    public void onShowFail(String errorMsg) {

        Log.e("TAG","Banner网络数据请求错误"+errorMsg);

    }

    private void initTab() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new NewsFragment());
        fragments.add(new StudentFragment());

        HomeVpAdapter vpAdapter = new HomeVpAdapter(getSupportFragmentManager(), fragments);
        home_vp.setAdapter(vpAdapter);

        home_tab.setupWithViewPager(home_vp);

        home_tab.getTabAt(0).setText("学校新闻");
        home_tab.getTabAt(1).setText("班级成绩查询");

    }
}