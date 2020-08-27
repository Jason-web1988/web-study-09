package web_study_09.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import web_study_09.dto.Member;
import web_study_09.impl.MemberDaoImpl;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberDaoTest {
	private MemberDao dao = MemberDaoImpl.getInstance();
	
	@Test
	public void testSelectMemberByAll() {
		System.out.println("testSelectMemberByAll()");
		List<Member> list = MemberDaoImpl.getInstance().selectMemberByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void testSelectMemberByUserId() {
		System.out.println("testSelectMemberByUserId");
		Member selectmember = dao.selectMemberByUserId(new Member("somi"));
		Assert.assertNotNull(selectmember);
		System.out.println(selectmember);
	}

	@Test
	public void test1InsertMember() {
		System.out.println("test1InsertMember()");
		Date day = new Date(2002, 12, 1);
		Member insertmember = new Member("이현석","zzanu1988","ggg","dlgu4@naver.com", "010-3356-0922", 1, day );
		int res = dao.insertMember(insertmember);
		System.out.println(res);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test2UpdateMember() {
		Date day = new Date(2002, 11, 1);
		System.out.println("test2UpdateMember()");
		Member updatemember = dao.selectMemberByUserId(new Member("zzanu1988"));
		updatemember.setName("최수동");
		updatemember.setPwd("007");
		updatemember.setEmail("abcd@gmail.net");
		updatemember.setPhone("012-3456-6789");
		updatemember.setAdmin(0);
		updatemember.setJoinDate(day);
//		Calendar cal = Calendar.getInstance();
//		cal.clear();
//		cal.isSet(2020, 10, 1);
//		modfiy
		int res = dao.updateMember(updatemember);
		Assert.assertEquals(1,res);
		
		List<Member> list = dao.selectMemberByAll();
		list.parallelStream().forEach(System.out::println);
	}

	@Test
	public void test3DeleteMember() {
		System.out.println("test3DeleteMember");
		Member deletemember = new Member("zzanu1988");
		int res = dao.deleteMember(deletemember);
		Assert.assertEquals(1, res);		
		List<Member> list = dao.selectMemberByAll();
		list.stream().forEach(System.out::println);
	}

}
