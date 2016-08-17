package ykse.TestAutomation.Interface.OWN.Common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sign {

	public static String getMd5Code(String encodedString) {
		System.out.println(encodedString);
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("md5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.reset();
		md.update(encodedString.getBytes());
		byte[] encodedPassword = md.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < encodedPassword.length; i++) {
			if ((encodedPassword[i] & 0xff) < 0x10) {
				sb.append("0");
			}
			sb.append(Long.toString(encodedPassword[i] & 0xff, 16));
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

}
