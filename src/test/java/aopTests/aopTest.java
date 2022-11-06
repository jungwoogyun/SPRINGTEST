package aopTests;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.aop.MyMath;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class aopTest {

	@Autowired
	ApplicationContext ac;
	
	@Test
	public void func1() {
		log.info("AC : " + ac);
		
		MyMath mm = (MyMath) ac.getBean("myMath");
		mm.add(10,20);
		mm.add(30,40,50);
		mm.mul(10, 30);
		
	}
	
}
