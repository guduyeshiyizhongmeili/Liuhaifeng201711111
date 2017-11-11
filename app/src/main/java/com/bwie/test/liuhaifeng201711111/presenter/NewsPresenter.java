package com.bwie.test.liuhaifeng201711111.presenter;


import com.bwie.test.liuhaifeng201711111.MainActivity;
import com.bwie.test.liuhaifeng201711111.bean.News;
import com.bwie.test.liuhaifeng201711111.model.NewsModel;
import com.bwie.test.liuhaifeng201711111.view.Iview;

import java.util.List;

/**
 * 刘海峰.9:45
 */

public class NewsPresenter implements NewsModel.Shopping{
    Iview iview;
    NewsModel imodel;

    public NewsPresenter(Iview iview) {
        this.iview = iview;
        imodel = new NewsModel();
        imodel.setShop(this);
    }

    public void getOk(int url) {
imodel.getHasParams( url);


    }

    @Override
    public void result(List<News> t) {
        iview.showSuccess(t);
    }
}
