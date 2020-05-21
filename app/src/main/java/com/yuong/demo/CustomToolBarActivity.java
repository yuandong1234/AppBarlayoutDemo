package com.yuong.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomToolBarActivity extends AppCompatActivity {
    private AppBarLayout appBarLayout;
    //    private Toolbar toolbar;
    private CommonToolBar toolbar;
    private ImageView ivBack;
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        getWindow().getDecorView().setSystemUiVisibility(option);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_custom_toolbar);
        initView();
    }

//    private void initView() {
//        toolbar = findViewById(R.id.toolbar);
//        appBarLayout = findViewById(R.id.appBarLayout);
//        toolbar.removeAllViews();
//        Toolbar.LayoutParams lps = new Toolbar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        View view = getLayoutInflater().inflate(R.layout.layout_toolbar, null);
//        ivBack = view.findViewById(R.id.iv_back);
//        tvTitle = view.findViewById(R.id.tv_title);
//        toolbar.addView(view, lps);
//
//        CollapsingToolbarLayout.LayoutParams layoutParams = (CollapsingToolbarLayout.LayoutParams) toolbar.getLayoutParams();
//        layoutParams.topMargin = StatusBarUtil.getStatusBarHeight(CustomToolBarActivity.this);
//        toolbar.setLayoutParams(layoutParams);
//
//        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                //设置toolbar渐变的效果，主要是监听appbarlayout滑动的距离,getTotalScrollRange:是appbarLayout可滑动的最大距离
//                float alpha = Math.abs(verticalOffset * 1.0f) / appBarLayout.getTotalScrollRange();
//                toolbar.setAlpha(alpha);
//                ivBack.setAlpha(alpha);
//                tvTitle.setAlpha(alpha);
//                StatusBarUtil.setStatusBarColor(CustomToolBarActivity.this,
//                        ColorUtil.changeAlpha(getResources().getColor(R.color.color_ffffff), alpha));
//            }
//        });
//    }

    /**
     * 沉浸式ToolBar
     */
    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        appBarLayout = findViewById(R.id.appBarLayout);
        ivBack = toolbar.getBackView();
        tvTitle = toolbar.getTitleView();


        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                //设置toolbar渐变的效果，主要是监听appbarlayout滑动的距离,getTotalScrollRange:是appbarLayout可滑动的最大距离
                float alpha = Math.abs(verticalOffset * 1.0f) / appBarLayout.getTotalScrollRange();
                toolbar.setAlpha(alpha);
                ivBack.setAlpha(alpha);
                tvTitle.setAlpha(alpha);
            }
        });
    }


}
