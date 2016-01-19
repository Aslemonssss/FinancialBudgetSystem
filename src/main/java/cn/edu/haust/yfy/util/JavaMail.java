package cn.edu.haust.yfy.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

/*
 * @author : WangDesen
 * 发送邮件类
 * */
public class JavaMail {
	private static final String SERVER_NAME = "cas@wanxue.cn";// 邮箱账号名
	private static final String SERVER_PWD = "wanxue.cn";// 邮箱密码
	private static final String SMTP = "mail.wanxue.cn"; // 设置发送邮件所用到的smtp
	//private static final String title = "来自CAS系统的注册激活邮件";// 所发送邮件的标题

	public static boolean sendmail(String title, String to, String text, String mimeType) {
		boolean status = false;
		try {
			Properties props = new Properties();

			javax.mail.Session mailSession = null; // 邮件会话对象
			javax.mail.internet.MimeMessage mimeMsg = null; // MIME 邮件对象

			props = java.lang.System.getProperties(); // 获得系统属性对象
			props.put("mail.smtp.host", SMTP); // 设置SMTP主机
			props.put("mail.smtp.auth", "true"); // 是否到服务器用户名和密码验证
			// 到服务器验证发送的用户名和密码是否正确
			SmtpAuthenticator myEmailAuther = new SmtpAuthenticator(
					SERVER_NAME, SERVER_PWD);
			// 设置邮件会话 注意这里将认证信息放进了Session的创建参数里
			mailSession = javax.mail.Session.getInstance(props,
					(Authenticator) myEmailAuther);
			// 设置传输协议
			javax.mail.Transport transport = mailSession.getTransport("smtp");
			// 设置from、to等信息
			mimeMsg = new javax.mail.internet.MimeMessage(mailSession);
			if (null != SERVER_NAME && !"".equals(SERVER_NAME)) {
				InternetAddress sentFrom = new InternetAddress(SERVER_NAME);
				mimeMsg.setFrom(sentFrom); // 设置发送人地址
			}

			InternetAddress sendTo = new InternetAddress(to);

			mimeMsg.setRecipient(
					javax.mail.internet.MimeMessage.RecipientType.TO, sendTo);
			mimeMsg.setSubject(title, "gb2312");

			MimeBodyPart messageBodyPart1 = new MimeBodyPart();
			// messageBodyPart.setText(UnicodeToChinese(text));
			messageBodyPart1.setContent(text, mimeType);

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart1);

			mimeMsg.setContent(multipart);
			// 设置信件头的发送日期
			mimeMsg.setSentDate(new Date());
			mimeMsg.saveChanges();
			// 发送邮件
			transport.send(mimeMsg);
			transport.close();
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static void main(String[] args) throws Exception {
		
		// String sendTo="desen000@163.com";
		//String sendTo = "desen000@163.com";
		String [] SendTo = {"desen000@163.com","672547536@qq.com","desen000@gmail.com","wangdesen@wanxue.cn"};
		// 邮件的文本内容，可以包含html标记则显示为html页面
		String content = "尊敬的用户：</br>您申请激活CAS账号，如非本人操作，请忽略此邮件。</br>立即激活，<a href='http://sjsky.javaeye.com/'>请点击这里</a></br>"
				+ "如果上面的链接无法点击，您可以复制下面的地址，并粘帖到浏览器的地址栏中访问。</br>" + "";
		//JavaMail test = new JavaMail();
		try {
			for(String str : SendTo){
				sendmail("测试邮件", str, content, "text/html;charset=gb2312");
				System.out.println(str + "  ----  发送成功");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	static class SmtpAuthenticator extends Authenticator {
		String username = null;
		String password = null;

		public SmtpAuthenticator(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}

		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(this.username, this.password);
		}
	}
}
