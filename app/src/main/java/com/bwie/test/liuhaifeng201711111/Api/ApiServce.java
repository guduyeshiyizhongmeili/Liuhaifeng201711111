package com.bwie.test.liuhaifeng201711111.Api;

import com.bwie.test.liuhaifeng201711111.bean.News;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 刘海峰.9:17
 */

public interface ApiServce {
    @GET("wap/data/news/txs/page_{pages}.json")
    Observable<List<News>> getdatas(@Path("pages") int pages) ;


}
