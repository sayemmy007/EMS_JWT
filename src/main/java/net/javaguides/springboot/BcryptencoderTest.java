package net.javaguides.springboot;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptencoderTest {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		for(int i =1;i<=10; i++)
		{
			String encodedString = encoder.encode("imran");
			System.out.println(encodedString);
			System.out.println(encodedString);
		}
	}

}
