package accountbook.test;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import accountbook.dao.UserinfoDAO;
import accountbook.vo.UserinfoVO;

class UserinfoTests {
	
	UserinfoDAO dao = new UserinfoDAO();

	@Test
	void test() {
		
		System.out.println("테스트");
		boolean a = dao.get("aaa111", "aaa111");
		
		if(a == false) {
			System.out.println("안녕");
		}
		assertNotNull(dao);
	}
	
	@Test
	public void signInTests() {
		UserinfoVO vo = dao.getSignIn("aaa111", "aaa111");
		
		assertNotNull(vo);
		
		String name = vo.getName();
		String id = vo.getId();
		String password = vo.getPassword();
		
		System.out.println("name : " + name );
		System.out.println("id : " + id);
		System.out.println("password : " + password);
		
	}
}
