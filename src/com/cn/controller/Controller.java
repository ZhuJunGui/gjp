package com.cn.controller;

import java.util.List;

import com.cn.entity.ZhangWu;
import com.cn.service.ZhangWuService;

public class Controller {
	private ZhangWuService aService=new ZhangWuService();
    //添加数据的方式
	public void addzhangWu(ZhangWu zu) {
		aService.addzhangWu(zu);
		
	}
	public List<ZhangWu> selectAll() {
		return aService.selectAll();
	}
	public void updatezhangWu(ZhangWu zWu) {
		aService.updatezhangWu(zWu);
		
	}
	public void deletezhangWu(int zwid) {
		aService.deletezhangWu(zwid);
		
	}
	public List<ZhangWu> select(String startDate, String endDate) {
		return aService.select(startDate,endDate);
	}

}
