package com.evaluacion.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que provee un conjunto de métodos genéricos que son usados
 * recurrentemente en el desarrollo.
 */

public class Utilidades {
	
	public static Boolean validaExpRegularEmail(String emailRegex, String email) {
		Pattern pattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public static Boolean validaExpRegularPassword(String passRegex, String password) {		
		Pattern pattern = Pattern.compile(passRegex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}

}
