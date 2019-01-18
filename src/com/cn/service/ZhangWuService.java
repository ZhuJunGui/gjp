package com.cn.service;

import java.util.List;

import com.cn.dao.ZhangWudao;
import com.cn.entity.ZhangWu;

/**
 * 
 * 作者：朱俊贵 时间：2019年1月17日下午2:21:44 描述：业务层（业务层不会做去找数据访问层）
 */
public class ZhangWuService {
	private ZhangWudao zhWudao = new ZhangWudao();

	public void addzhangWu(ZhangWu zu) {
		zhWudao.addzhangWu(zu);
	}

	public List<ZhangWu> selectAll() {
		return zhWudao.selectAll();
	}

	public void updatezhangWu(ZhangWu zWu) {
		zhWudao.updatezhangWu(zWu);
	}

	public void deletezhangWu(int zwid) {
		zhWudao.deletezhangWu(zwid);
	}

	public List<ZhangWu> select(String startDate, String endDate) {
		return zhWudao.select(startDate, endDate);
	}

}
