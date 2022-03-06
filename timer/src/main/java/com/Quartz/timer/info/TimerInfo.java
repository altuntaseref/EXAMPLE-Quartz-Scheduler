package com.Quartz.timer.info;


public class TimerInfo {
	
	private int totalFireCount;
	private boolean runForever;//sonsuza kadar çalışacağını söyledik
	private long repeatIntervalMs;//hangi ms aralıkalrında çalışacağını söyledik
	private long initialOffsetMs;
	private String callbackData;
	
	public int getTotalFireCount() {
		return totalFireCount;
	}
	public void setTotalFireCount(int totalFireCount) {
		this.totalFireCount = totalFireCount;
	}
	public boolean isRunForever() {
		return runForever;
	}
	public void setRunForever(boolean runForever) {
		this.runForever = runForever;
	}
	public long getRepeatIntervalMs() {
		return repeatIntervalMs;
	}
	public void setRepeatIntervalMs(long repeatIntervalMs) {
		this.repeatIntervalMs = repeatIntervalMs;
	}
	public long getInitialOffsetMs() {
		return initialOffsetMs;
	}
	public void setInitialOffsetMs(long initialOffsetMs) {
		this.initialOffsetMs = initialOffsetMs;
	}
	public String getCallbackData() {
		return callbackData;
	}
	public void setCallbackData(String callbackData) {
		this.callbackData = callbackData;
	}

}
