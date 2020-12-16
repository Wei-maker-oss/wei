package com.example.zyday02;

import com.example.zyday02.model.bean.BannerBean;
import com.example.zyday02.model.bean.NewsBean;
import com.example.zyday02.model.bean.StudentBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {
//    http://cdwan.cn:7000/exam2003/abannerlist.json
//    http://cdwan.cn:7000/exam2003/anewslist.json
//    http://cdwan.cn:7000/exam2003/astudent.json

    String BASE_URL="http://cdwan.cn:7000/exam2003/";

    @GET("abannerlist.json")
    Observable<BannerBean> getBannerDate();

    @GET("anewslist.json")
    Observable<NewsBean> getNewsDate();

    @GET("astudent.json")
    Observable<StudentBean> getStudentDate();


}
