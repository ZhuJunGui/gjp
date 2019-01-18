package com.cn.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cn.entity.ZhangWu;
import com.cn.tools.JDBCUtils;

/**
 * 
 * 作者：朱俊贵 时间：2019年1月17日下午2:20:10 描述：实现对数据的增删改查
 */
public class ZhangWudao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	public void addzhangWu(ZhangWu zu) {
		try {
			String sql = "INSERT INTO gjp_zhangwu (flname,money,zhanghu,createtime,description) VALUES(?,?,?,?,?)";
			Object[] objects = { zu.getFlname(), zu.getMoney(), zu.getZhanghu(), zu.getCreatetime(),
					zu.getDescription() };
			qr.update(sql, objects);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatezhangWu(ZhangWu zWu) {
		try {
			String sql = "update gjp_zhangwu set flname=?,money=?,zhanghu=?,createtime=?,description=? where zwid=?";
			Object[] objects = { zWu.getFlname(), zWu.getMoney(), zWu.getZhanghu(), zWu.getCreatetime(),
					zWu.getDescription(), zWu.getZwid() };
			qr.update(sql, objects);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletezhangWu(int zwid) {
		try {
			String sql = "delete  from gjp_zhangwu where zwid=? ";
			qr.update(sql, zwid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<ZhangWu> selectAll() {
		List<ZhangWu> list = null;
		try {
			String sql = "select * from gjp_zhangwu";
			list = qr.query(sql, new BeanListHandler<>(ZhangWu.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	public List<ZhangWu> select(String startDate, String endDate) {
		List<ZhangWu> list = null;
		try {
			String sql = "select * from gjp_zhangwu where createtime between ?and?";
			Object[] objects = { startDate, endDate };
			qr.query(sql, new BeanListHandler<>(ZhangWu.class), objects);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
