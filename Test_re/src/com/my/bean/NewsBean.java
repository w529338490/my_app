package com.my.bean;

import java.util.List;

public class NewsBean {

	String msg ;
	String status;
	Result res;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public  static  class Result{
		 String channel;
		
		 String num;
		
		
		public String getChannel() {
			return channel;
		}
		public void setChannel(String channel) {
			this.channel = channel;
		}
		
		public String getNum() {
			return num;
		}
		public void setNum(String num) {
			this.num = num;
		}
	}
	public Result getRes() {
		return res;
	}
	public void setRes(Result res) {
		this.res = res;
	}
	 
}
