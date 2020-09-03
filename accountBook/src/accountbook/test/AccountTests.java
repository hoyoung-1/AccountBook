package accountbook.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import accountbook.dao.AccountDAO;
import accountbook.vo.AccountVO;

class AccountTests {

	private AccountDAO dao = new AccountDAO();

	@Test
	public void testList() {
		
		List<AccountVO> list =  dao.getList("김철수");
		
	
		assertNotNull(list);
		
		for(AccountVO vo : list) {
			System.out.println(vo.toString());
		}
		
		
	}
	
	@Test
	public void testTotal () {
		int total = dao.totalSum("김철수");
		
		System.out.println("total : " + total);
		
	}
	
	@Test
	public void testInsert () { 
		int total = dao.totalSum("김철수"); // 100
		int income = 500;
		int expenses = 400;
		
		total += (income-expenses);
		
		System.out.println(total); 
		
		assertEquals(total, 0);
		
		boolean flag = dao.insert("김철수","테스트1", income, expenses, total);
		
		if(flag) {
			System.out.println("insert 입력완료");
		} else {
			System.out.println("insert 입력 실패");
		}
	}
}
