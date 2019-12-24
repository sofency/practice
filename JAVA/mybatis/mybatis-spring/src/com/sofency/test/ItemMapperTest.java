package com.sofency.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sofency.mapper.ItemMapper;
import com.sofency.po.Item;
import com.sofency.po.ItemExample;

public class ItemMapperTest {
	
	private ApplicationContext application;
	private ItemMapper itemmapper;
	@Before
	public void setUp() throws Exception {
		application = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		itemmapper = (ItemMapper) application.getBean("itemMapper");
	}

	@Test
	public void testCountByExample() {
		ItemExample itemExample = new ItemExample();
		//ͨ��criteria�����ѯ����
		ItemExample.Criteria criteria = itemExample.createCriteria();
		criteria.andItempriceNotEqualTo(9);
		int list = itemmapper.countByExample(itemExample);
		System.out.println(list);
		
	}

	@Test
	public void testInsert() {
		Item item = new Item();
		item.setItemname("ƻ��");
		item.setItemprice(12);
		itemmapper.insert(item);
	}

	@Test
	public void testInsertSelective() {
	//�����ض����ֶ�ֵ
	}

	@Test
	public void testSelectByExample() {
		ItemExample itemExample = new ItemExample();
		//ͨ��criteria�����ѯ����
		ItemExample.Criteria criteria = itemExample.createCriteria();
		criteria.andItemidBetween(1, 3);//������Ʒ��id����2
		List<Item> num = itemmapper.selectByExample(itemExample);
	}

	@Test
	public void testSelectByPrimaryKey() {
		Item item = itemmapper.selectByPrimaryKey(2);
		System.out.println(item);
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKey() {
		Item item = itemmapper.selectByPrimaryKey(1);
		item.setItemprice(20);
		
	}

}
