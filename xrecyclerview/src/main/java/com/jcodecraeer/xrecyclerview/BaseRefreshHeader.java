package com.jcodecraeer.xrecyclerview;

/**
 * Created by jianghejie on 15/11/22.
 */
interface BaseRefreshHeader {

	int STATE_NORMAL = 0;             // 正常状态
	int STATE_RELEASE_TO_REFRESH = 1; // 释放刷新状态
	int STATE_REFRESHING = 2;         // 更新状态
	int STATE_DONE = 3;               // 按下状态

	void onMove(float delta);// 移动

	boolean releaseAction(); // 释放动作

	void refreshComplete();  // 释放完成

}