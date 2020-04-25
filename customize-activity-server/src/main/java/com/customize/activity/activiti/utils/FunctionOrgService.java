package com.customize.activity.activiti.utils;

import com.customize.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  自定义流程图函数
 * @author gyy
 *
 */
public class FunctionOrgService {
	
	private static final Logger log = LoggerFactory.getLogger(FunctionOrgService.class);
	
	/**
	 * 参数str1是否包含字符str2
	 * @param str1
	 * @param str2
	 * @return
	 */
	public Boolean contains(String str1, String str2) {
		log.info("----contains-----"+str1+":"+str2);
		return str1.contains(str2);
	}
	
	/**
	 * 参数str1不包含字符str2
	 * @param str1
	 * @param str2
	 * @return
	 */
	public Boolean notContains(String str1, String str2) {
		log.info("----contains-----"+str1+":"+str2);
		return !str1.contains(str2);
	}
	
	/**
	 * 参数str1是否是以字符str2开头
	 * @param str1
	 * @param str2
	 * @return
	 */
	public Boolean startsWith(String str1, String str2) {
		log.info("----contains-----"+str1+":"+str2);
		return str1.startsWith(str2);
	}
	
	/**
	 * 参数str1不是以字符str2开头
	 * @param str1
	 * @param str2
	 * @return
	 */
	public Boolean notStartsWith(String str1, String str2) {
		log.info("----contains-----"+str1+":"+str2);
		return !str1.startsWith(str2);
	}
	
	/**
	 * 参数str1是否是以字符str2结尾
	 * @param str1
	 * @param str2
	 * @return
	 */
	public Boolean endWith(String str1, String str2) {
		log.info("----contains-----"+str1+":"+str2);
		return str1.endsWith(str2);
	}
	
	/**
	 * 参数str1不是以字符str2结尾
	 * @param str1
	 * @param str2
	 * @return
	 */
	public Boolean notendsWith(String str1, String str2) {
		log.info("----contains-----"+str1+":"+str2);
		return !str1.endsWith(str2);
	}

	/**
	 * 截取字符串
	 * @param str1
	 * @param start
	 * @param end
	 * @return
	 */
	public String substring(String str1, int start, int end) {
		log.info("----substring-----" + str1 + ":" + start + ":" + end);
		if (StringUtils.isEmpty(str1) || str1.length() < end) {
			return "";
		} else {
			return str1.substring(start, end);
		}
	}
	
	/**
	 * 获取字符串长度
	 * @param str
	 * @return
	 */
	public int length(String str) {
		log.info("----length-----" + str);
		return str.length();
	}

	/**
	 * 过滤字符
	 * @param str1
	 * @return
	 */
	public static Boolean filterStr(String str1, String filterStr) {
		log.info("----substring-----" + str1 + ":" + filterStr);
		if(StringUtils.isEmpty(str1) || StringUtils.isEmpty(filterStr))
			return true;
		
//		String regEx="[\n`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]";
		String regEx = filterStr;
		//可以在中括号内加上任何想要替换的字符
		String str = "";//这里是将特殊字符换为aa字符串,""代表直接去掉
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(regEx);
		java.util.regex.Matcher m = p.matcher(str1);//这里把想要替换的字符串传进来
		
		String newString = m.replaceAll(str).trim();
		if("".equals(newString)) 
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
//		System.out.println(!"qwes".contains("we1"));
//		
//		String str = "admin";
//		boolean b = str.endsWith("min");//true
//		System.out.println(b);
//		
//		File file = new File("C:/java.txt");
//	    System.out.println(file.exists());
	    System.out.println(filterStr("&1&","[\\n`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]"));
		
	}
	
//	==
//	>
//	>=
//	<
//	<=
//	!=
//	contains
//	does not contain
//	starts with
//	does not start with
//	ends with
//	does not end with
//	exists
//	does not exist
			
			
}