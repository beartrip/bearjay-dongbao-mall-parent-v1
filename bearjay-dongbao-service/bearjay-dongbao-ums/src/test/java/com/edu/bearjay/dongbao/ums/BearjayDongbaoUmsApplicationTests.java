package com.edu.bearjay.dongbao.ums;


import com.edu.bearjay.dongbao.ums.api.entity.UmsMember;
import com.edu.bearjay.dongbao.ums.mapper.UmsMemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BearjayDongbaoUmsApplicationTests {
	@Autowired
	UmsMemberMapper mapper;

	@Test
	void contextLoads() {

	}

	@Test
	public void testInsert() {
		UmsMember member = new UmsMember();
		member.setUsername("zard");
		mapper.insert(member);
	}

	@Test
	public void testUpdate() {
		UmsMember member = new UmsMember();
		member.setId(93L);
		mapper.updateById(member);
	}

	@Test
	public void testSelect() {
		UmsMember result = mapper.selectByName("zard2");
		System.out.println(result);
	}

}
