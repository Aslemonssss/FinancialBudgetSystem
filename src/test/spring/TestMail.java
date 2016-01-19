package spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.haust.yfy.service.CommonService;
import cn.edu.haust.yfy.util.JavaMail;


public class TestMail {
	
	private static CommonService		commonService = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext	ac = new ClassPathXmlApplicationContext("application-context.xml");
		//ApplicationContext	ac = new ClassPathXmlApplicationContext("file:D:/eclipse-jee-kepler-SR2-win32-x86_64/workspace/UserCenter/src/main/resources/application-context.xml");
		commonService = (CommonService)ac.getBean("CommonService");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		String sendTo = "desen000@163.com";
		// 邮件的文本内容，可以包含html标记则显示为html页面
		String content = "尊敬的用户：</br>您申请激活CAS账号，如非本人操作，请忽略此邮件。</br>立即激活，<a href='http://sjsky.javaeye.com/'>请点击这里</a></br>"
				+ "如果上面的链接无法点击，您可以复制下面的地址，并粘帖到浏览器的地址栏中访问。</br>" + "";
		//JavaMail test = new JavaMail();
		try {
			JavaMail.sendmail("测试邮件", sendTo, content, "text/html;charset=gb2312");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Test
	public void testStringBuffer(){
		List<String> roleList = new ArrayList<String>();
		roleList.add("58");
		roleList.add("57");
		roleList.add("51");
		StringBuilder roleStringBuffer = new StringBuilder();
		boolean flag=false;
		roleStringBuffer.append("'");
        for (String string : roleList) {
            if (flag) {
            	roleStringBuffer.append(",");
            }else {
                flag=true;
            }
            roleStringBuffer.append(string);
        }
        roleStringBuffer.append("'");
        System.out.println(roleStringBuffer.toString());
	}
	
	@SuppressWarnings({ "rawtypes", "unused" })
	@Test
	public void testPermission(){
		List<String> roleList = new ArrayList<String>();
		roleList.add("58");
		roleList.add("57");
		roleList.add("51");
		String params = "";
		for(int i = 0 ; i < roleList.size(); i++){
			params += "?";
			if(i < roleList.size()-1){
				params +=", ";
			}
		}
		/*StringBuilder roleStringBuffer = new StringBuilder();
		boolean flag=false;
        for (String string : roleList) {
            if (flag) {
            	roleStringBuffer.append(",");
            }else {
                flag=true;
            }
            roleStringBuffer.append(string);
        }*/
		String sql = "SELECT DISTINCT permissions.permission_code FROM roles_permissions"
				+" LEFT JOIN permissions ON roles_permissions.permission_id = permissions.id"
				+" LEFT JOIN modules ON permissions.module_id = modules.id"
				+" WHERE FIND_IN_SET(roles_permissions.role_id, ?) ORDER BY modules.sort_id,roles_permissions.permission_id";
		List<Map> maps = commonService.queryMapList(sql, "58,57,51");
		System.out.println("over");
	}

}
