package com.evaluacion.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que provee un conjunto de métodos genéricos que son usados
 * recurrentemente en el desarrollo.
 */

public class Utilidades {	
	
	private static final String EMAIL_REGEX = "[A-Za-z0-9+_.-]+@(.+)$";
    private static final String COMPLEX_PASSWORD_REGEX =
            "^(?:(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])|" +
            "(?=.*\\d)(?=.*[^A-Za-z0-9])(?=.*[a-z])|" +
            "(?=.*[^A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z])|" +
            "(?=.*\\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))(?!.*(.)\\1{2,})" +
            "[A-Za-z0-9!~<>,;:_=?*+#.\"&§%°()\\|\\[\\]\\-\\$\\^\\@\\/]" +
            "{8,32}$";
	
	public static Boolean validaExpRegularEmail(String email) {
		Pattern pattern = Pattern.compile(EMAIL_REGEX);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public static Boolean validaExpRegularPassword(String password) {		
		Pattern pattern = Pattern.compile(COMPLEX_PASSWORD_REGEX);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}

}
