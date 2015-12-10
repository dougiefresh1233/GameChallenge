package com.monochromatic.god_of_fire.utility.encryption;
import javax.xml.bind.DatatypeConverter;

public class Build {
	public String hexByteToString(byte[] hexAsBytes) {
		String output = DatatypeConverter.printHexBinary(hexAsBytes);
		return output;
	}

	public String hexStringToString(String hex) {
		byte[] by = DatatypeConverter.parseHexBinary(hex);
		String s = new String(by);
		return s;
	}
}
