package com.bwie.test.liuhaifeng201711111;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bwie.test.liuhaifeng201711111.adapter.Myadapter;
import com.bwie.test.liuhaifeng201711111.bean.News;
import com.bwie.test.liuhaifeng201711111.presenter.NewsPresenter;
import com.bwie.test.liuhaifeng201711111.view.Iview;

import java.util.List;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity implements Iview{

    private RecyclerView mRecyc1;
    private SwipeRefreshLayout mSwitf;
    private Myadapter myAdapter;
    private LinearLayoutManager linearLayoutManager;
private int  page=1;
    private List<News.DataBean> list1;
    private NewsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        presenter = new NewsPresenter(this);
        presenter.getOk(page);

    }

    @Override
    public void showSuccess(final List<News> list) {
        linearLayoutManager = new LinearLayoutManager(this);
        mRecyc1.setLayoutManager(linearLayoutManager);

            list1 = list.get(0).getData();


        myAdapter = new Myadapter(list1);
        mRecyc1.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(new Myadapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                Toast.makeText(MainActivity.this, list1.get(postion).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        mRecyc1.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                if (lastVisibleItemPosition == list1.size() - 1) {
                    page++;
                    showSuccess(list);
                    myAdapter.notifyDataSetChanged();
                }


            }
        });

        mSwitf.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                page++;
                presenter.getOk(page);
                myAdapter.notifyDataSetChanged();
                mSwitf.setRefreshing(false);

            }
        });




    }

    private void initView() {
        mRecyc1 = (RecyclerView) findViewById(R.id.recyc1);
        mSwitf = (SwipeRefreshLayout) findViewById(R.id.switf);
    }
}
