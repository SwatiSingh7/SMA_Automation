package com.morrisons.common.utility;

public class NasLocation {

	private String oneOffPendingPath;
	private String intraDayPendingPath;
	private String mppmPendingPath;
	
	public String getOneOffPendingPath() {
		return oneOffPendingPath;
	}
	public void setOneOffPendingPath(String oneOffPendingPath) {
		this.oneOffPendingPath = oneOffPendingPath;
	}
	public String getIntraDayPendingPath() {
		return intraDayPendingPath;
	}
	public void setIntraDayPendingPath(String intraDayPendingPath) {
		this.intraDayPendingPath = intraDayPendingPath;
	}
	public String getMppmPendingPath() {
		return mppmPendingPath;
	}
	public void setMppmPendingPath(String mppmPendingPath) {
		this.mppmPendingPath = mppmPendingPath;
	}
	@Override
	public String toString() {
		return "NasLocation [oneOffPendingPath=" + oneOffPendingPath + ", intraDayPendingPath=" + intraDayPendingPath
				+ ", mppmPendingPath=" + mppmPendingPath + "]";
	}
	
}
