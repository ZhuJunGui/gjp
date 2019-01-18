package com.cn.test;

import java.util.List;
import java.util.Scanner;

import com.cn.controller.Controller;
import com.cn.entity.ZhangWu;

/**
 * 
 * 作者：朱俊贵 时间：2019年1月17日下午1:50:37 描述：用户看到的界面，数据传递给控制层
 */
public class Test {
	private Controller controller = new Controller();

	/**
	 * 实现用户界面的，提示用户进行每一步的操作 然后根据用户输入的实现每一步的功能
	 */
	public void run() {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("***********管家婆家庭记账软件***********");
			System.out.println("1.添加记账    2.编辑账务  3.删除账务  4.查询账务  5.退出系统");
			// 用户进行以下操作
			System.out.print("请输入你选择的功能[1-5]:");
			int choose = input.nextInt();
			// 对选择的用户进行条件判断
			switch (choose) {
			case 1:
				// 用户添加记账的方法
				addzhangWu();
				break;
			case 2:
				// 用户编辑账务的方法
				updatezhangWu();
				break;
			case 3:
				// 用户删除账务的方法
				deletezhangWu();
				break;
			case 4:
				// 用户查询账务的方法
				selectzhangWu();
				break;
			case 5:
				System.exit(0);
				break;

			}

		}
	}

	public void selectzhangWu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 查询所有    2. 条件查询");
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			// 查询所有账务
			selectAll();
			break;

		case 2:
			// 条件查询
			select();
			break;
		}

	}
    
	/*
	 * 查询的所有方法
	 */
	public void select() {
		System.out.println("选择条件查询,输入日期格式XXXX-XX-XX");
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入开始日期:");
		String startDate = sc.nextLine();
		System.out.print("请输入结果日期:");
		String endDate = sc.nextLine();
		// 调用controller层的方法,传递日期,获取查询结果集
		List<ZhangWu> list = controller.select(startDate, endDate);
		if (list.size() != 0) {
			System.out.println("ID\t\t类别\t\t账户\t\t金额\t\t时间\t\t说明");
			// 遍历集合,结果输出控制台
			for (ZhangWu zw : list) {
				System.out.println(zw.getZwid() + "\t\t" + zw.getFlname() + "\t\t" + zw.getZhanghu() + "\t\t"
						+ zw.getMoney() + "\t\t" + zw.getCreatetime() + "\t" + zw.getDescription());

			}
		} else {
			System.out.println("没有查到数据！");
		}

	}

	/*
	 * 删除账务的方法
	 */
	public void deletezhangWu() {
		Scanner sc = new Scanner(System.in);
		selectAll();
		System.out.println("请选择你要删除的序号：");
		int zwid = sc.nextInt();
		controller.deletezhangWu(zwid);
		System.out.println("删除成功！");
	}

	/***
	 * 编辑账务的方法
	 */
	public void updatezhangWu() {
		Scanner sc = new Scanner(System.in);
		selectAll();
		System.out.println("请输入要编辑的编号ID：");
		int zwid = sc.nextInt();
		System.out.println("输入分类名称");
		String flname = sc.next();
		System.out.println("输入金额");
		double money = sc.nextDouble();
		System.out.println("输入账户");
		String zhanghu = sc.next();
		System.out.println("输入日期：格式XXXX-XX-xx");
		String createtime = sc.next();
		System.out.println("输入具体描述");
		String description = sc.next();
		ZhangWu zWu = new ZhangWu(zwid, flname, money, zhanghu, createtime, description);
		controller.updatezhangWu(zWu);
		System.out.println("编辑成功！");
	}

	/*
	 * 查询所有账务数据
	 */
	public void selectAll() {
		List<ZhangWu> list = controller.selectAll();
		if (list.size() != 0) {
			System.out.println("ID\t\t类别\t\t账户\t\t金额\t\t时间\t\t说明");
			// 遍历集合,结果输出控制台
			for (ZhangWu zw : list) {
				System.out.println(zw.getZwid() + "\t\t" + zw.getFlname() + "\t\t" + zw.getZhanghu() + "\t\t"
						+ zw.getMoney() + "\t\t" + zw.getCreatetime() + "\t" + zw.getDescription());
			}
		} else {
			System.out.println("编辑账务失败！");
		}

	}

	/**
	 * 添加账务的方法
	 */
	public void addzhangWu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("选择的添加账务功能，请输入以下内容");
		System.out.println("输入分类名称:");
		String flname = sc.next();
		System.out.println("输入金额:");
		double money = sc.nextDouble();
		System.out.println("输入账户:");
		String zhangwu = sc.next();
		System.out.println("输入日期：格式XXXX-XX-xx:");
		String createtime = sc.next();
		System.out.println("输入具体描述:");
		String description = sc.next();
		ZhangWu zu = new ZhangWu(0, flname, money, zhangwu, createtime, description);
		controller.addzhangWu(zu);
		System.out.println("账户添加成功！");

	}

}
