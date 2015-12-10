package com.monochromatic.god_of_fire.utility.encryption;
import javax.xml.bind.DatatypeConverter;

public class Breakdown {
	public String stringToHexString(String s) {
		char[] ch;
		ch = s.toCharArray();
		String hex = "";
		for (int i = 0; i < s.length(); i++) {
			hex += String.format("%02x", (int) ch[i]);
		}
		hex = hex.toUpperCase();
		return hex;
	}

	public byte[] hexStringToByte(String hex) {
		byte[] b = DatatypeConverter.parseHexBinary(hex);
		return b;
	}
}
