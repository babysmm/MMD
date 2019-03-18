package com.mmd.mmdshop.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * QQ邮箱工具类
 * 
 * @author MM
 * 
 */
@Service
public class QQMail {

	private static final String EMAIL = "3342064066@qq.com";

	/**
	 * 发送邮件
	 * 
	 * @param email
	 *            邮箱地址
	 * @param title
	 *            标题
	 * @param content
	 *            内容
	 * @return 是否成功
	 */
	public boolean sendTextMail(String email, String title, String content,JavaMailSender javaMailSender) {
		return send(email, title, content, 1, javaMailSender);
	}

	/**
	 * 发送HTML邮件
	 * 
	 * @param email
	 *            邮箱地址
	 * @param title
	 *            标题
	 * @param content
	 *            HTML内容
	 * @return 是否成功
	 */
	public boolean sendHTMLMail(String email, String title, String htmlContent,JavaMailSender javaMailSender) {
		return send(email, title, htmlContent, 2,javaMailSender);
	}

	/**
	 * 发送邮件
	 * 
	 * @param email
	 *            邮箱地址
	 * @param title
	 *            标题
	 * @param content
	 *            内容
	 * @param contentType
	 *            类型
	 * @return 是否成功
	 */
	public boolean send(String email, String title, String content, int contentType,JavaMailSender javaMailSender) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom(EMAIL);
			helper.setTo(email);
			helper.setSubject(title);

			if (contentType == 1) {
				helper.setText(content);
			} else if (contentType == 2) {
				helper.setText(content, true);
			} else {
				return false;
			}

			javaMailSender.send(mimeMessage);
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
