/**  
 * All rights Reserved, Designed By www.mycat.io
 * @Title:  Md5Util.java   
 * @Package io.mycat.eye.web.util   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年3月22日 下午4:44:00   
 * @version V1.0 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
package io.mycat.eye.web.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName: Md5Util
 * @Description:MD5工具类
 * @author: 李平(360841519@qq.com)
 * @date: 2017年3月22日 下午4:44:00
 * 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved.
 */
public class Md5Util {
	// 静态方法，便于作为工具类
	public static String getMd5(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			// 32位加密
			return buf.toString();
			// 16位的加密
			// return buf.toString().substring(8, 24);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static void main(String[] args) {
		// 测试
		System.out.println(new Md5Util().getMd5("admin"));
	}
}
