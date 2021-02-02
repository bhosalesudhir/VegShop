package com.app.tester;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.app.utils.AESAlgorithm;

public class AESalogorithmtester {

	public static void main(String[] args) {
		String en;
		try {
			en = AESAlgorithm.en("aaaaaa@4008");
			System.out.println("Encrypted password:-"+en+" length-"+en.length());
			System.out.println("Decrypted password:-"+AESAlgorithm.dt(en));
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
