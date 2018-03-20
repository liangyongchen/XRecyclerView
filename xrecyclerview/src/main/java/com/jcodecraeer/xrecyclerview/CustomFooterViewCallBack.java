package com.jcodecraeer.xrecyclerview;

import android.view.View;

/**
 * 作者：林冠宏
 * <p>
 * My GitHub : https://github.com/af913337456/
 * <p>
 * My Blog   : http://www.cnblogs.com/linguanh/
 * <p>
 * on 2017/11/8.
 */
// 自定义页脚试图回调
public interface CustomFooterViewCallBack {

    void onLoadingMore(View yourFooterView);              // 加载更多
    void onLoadMoreComplete(View yourFooterView);         // 加载更多完成
    void onSetNoMore(View yourFooterView,boolean noMore); // 设置没有更多

}
