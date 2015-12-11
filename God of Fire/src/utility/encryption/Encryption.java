package utility.encryption;
public class Encryption {
	Build b = new Build();
	Breakdown br = new Breakdown();

	public String encode(String s) {
		s = br.stringToHexString(s);
		s = encrypt(s);
		return s;
	}

	public String decode(String s) {
		try {
			s = decrypt(s);
		} catch (StringIndexOutOfBoundsException e) {
		}
		if (isValidHexString(s)) {
			s = b.hexStringToString(s);
			return s;
		} else {
			System.out.println("Please insert a valid code.");
			return "Please insert a valid code";
		}
	}

	public boolean isValidHexString(String s) {
		String temp = "";
		if (s.length() % 2 == 1) {
			return false;
		} else {
			for (int i = 0; i < s.length(); i += 2) {
				temp = s.substring(i, i + 2);
				try {
					if (b.hexStringToString(temp).equals(
							b.hexStringToString("80"))) {
						return false;
					}
				} catch (IllegalArgumentException e) {
					return false;
				}
			}
		}
		return true;
	}

	private String encrypt(String s) {
		String temp = incrementNums(s);
		temp = reverseString(temp);
		temp = changeLocs(temp);
		return temp;
	}

	private String decrypt(String s) {
		String temp = decrementNums(s);
		temp = revertLocs(temp);
		temp = reverseString(temp);
		return temp;
	}

	private boolean isNumber(String s) {
		if (s.length() == 1) {
			if (!(s.equals("1") || s.equals("2") || s.equals("3")
					|| s.equals("4") || s.equals("5") || s.equals("6")
					|| s.equals("7") || s.equals("8") || s.equals("9") || s
						.equals("0"))) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	public String incrementNums(String s) {
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			temp += incrementChar(s.substring(i, i + 1));
		}
		return temp;
	}

	public String decrementNums(String s) {
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			temp += decrementChar(s.substring(i, i + 1));
		}
		return temp;
	}

	private String incrementChar(String s) {
		if (isNumber(s)) {
			if (s.equals("0")) {
				return "1";
			} else if (s.equals("1")) {
				return "2";
			} else if (s.equals("2")) {
				return "3";
			} else if (s.equals("3")) {
				return "4";
			} else if (s.equals("4")) {
				return "5";
			} else if (s.equals("5")) {
				return "6";
			} else if (s.equals("6")) {
				return "7";
			} else if (s.equals("7")) {
				return "8";
			} else if (s.equals("8")) {
				return "9";
			} else if (s.equals("9")) {
				return "0";
			}
		}
		return s;
	}

	private String decrementChar(String s) {
		if (isNumber(s)) {
			if (s.equals("0")) {
				return "9";
			} else if (s.equals("1")) {
				return "0";
			} else if (s.equals("2")) {
				return "1";
			} else if (s.equals("3")) {
				return "2";
			} else if (s.equals("4")) {
				return "3";
			} else if (s.equals("5")) {
				return "4";
			} else if (s.equals("6")) {
				return "5";
			} else if (s.equals("7")) {
				return "6";
			} else if (s.equals("8")) {
				return "7";
			} else if (s.equals("9")) {
				return "8";
			}
		}
		return s;
	}

	private String changeLocs(String s) {

		String temp = "";
		for (int i = 0; i < s.length(); i += 2) {
			temp += s.substring(i, i + 2);
		}
		return temp;
	}

	private String revertLocs(String s) {
		String temp = "";
		for (int i = 0; i < s.length(); i += 2) {
			temp += s.substring(i, i + 2);
		}
		return temp;
	}

	private String reverseString(String s) {
		String temp = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			temp += s.substring(i, i + 1);
		}
		return temp;
	}
}
