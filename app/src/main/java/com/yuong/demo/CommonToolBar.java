package com.yuong.demo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuong.demo.utils.DisplayUtil;
import com.yuong.demo.utils.StatusBarUtil;

/**
 * 沉浸式ToolBar
 */
public class CommonToolBar extends Toolbar {

    private ImageView ivBack;
    private TextView tvTitle;

    public CommonToolBar(Context context) {
        this(context, null);
    }

    public CommonToolBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommonToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    private void init() {
        removeAllViews();
        setContentInsetsRelative(0, 0);
        View view = View.inflate(getContext(), R.layout.layout_toolbar, null);
        ivBack = view.findViewById(R.id.iv_back);
        tvTitle = view.findViewById(R.id.tv_title);
        Toolbar.LayoutParams lps = new Toolbar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        addView(view, lps);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height = DisplayUtil.dip2px(getContext(), 20) + StatusBarUtil.getActionBarHeight(getContext());
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), height);
    }

    public ImageView getBackView() {
        return ivBack;
    }

    public TextView getTitleView() {
        return tvTitle;
    }
}
