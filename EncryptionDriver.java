package ics254;

public class EncryptionDriver {
	private static String key;
	private int KeyLen;
	public static String dic = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789,.?! ";
	public static int p;
	public static int k;


	static int getK(char str) {
	
		int counter = 0;
		for (int i = 0; i < 66; i++)
			if (dic.charAt(i) == str)
				counter = i;
			else if (str == ' ')
				counter = 66;

		return counter;
	}

	public static String encryption(String key, int Len, String encrypt, int i, String word) {
		if (encrypt.length() == word.length()) {
			return encrypt;
		} else if ((Len < key.length())) {
			p = getK(word.charAt(i));
			k = getK(key.charAt(Len));
			encrypt = encrypt + dic.charAt((p + k) % 67);
			return encryption(key, Len + 1, encrypt, i + 1, word);
		} else
			return encryption(key, 0, encrypt, i, word);
	}

	public static String decryption(String key, int Len, String decrypt, int i, String word) {
		if (decrypt.length() == word.length()) {
			return decrypt;
		} else if ((Len < key.length())) {
			k = getK(key.charAt(Len));
			p = getK(word.charAt(i));
			if (p-k < 0) {
				decrypt = decrypt + dic.charAt(((p-k) +67) % 67);
				return decryption(key, Len + 1, decrypt, i + 1, word);
			} else {
				decrypt = decrypt + dic.charAt((p-k) % 67);
				return decryption(key, Len + 1, decrypt, i + 1, word);
			}

		} else
			return decryption(key, 0, decrypt, i, word);
	}

}





		
		
	

