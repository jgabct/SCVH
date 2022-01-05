package br.edu.ifs.academico.model.services;

import org.mindrot.jbcrypt.BCrypt;

public class CryptoManager {

	public static String encryptPswd(String password) {

		String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

		return hashedPassword;

	}

	public static boolean descryptPswd(String password, String hash) {

		if (BCrypt.checkpw(password, hash)) {

			return true;

		} else {

			return false;

		}
	}

}