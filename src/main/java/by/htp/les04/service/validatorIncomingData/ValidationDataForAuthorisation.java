package by.htp.les04.service.validatorIncomingData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationDataForAuthorisation {

	private static Pattern patternL = Pattern.compile("[A-Za-z]{3,16}+");

	private static Pattern patternP = Pattern.compile("[A-Za-z0-9]{3,16}+");

	public static boolean validateDataForAuthorisation(String login, String password) {

		boolean result = true;

		if (login==null || "".equals(login)) {
			result = false;
		}
		if (login.trim().isEmpty()) {
			result = false;
		}

		Matcher matcherL = patternL.matcher(login);
		if (!matcherL.matches()) {
			result = false;
		}

		if (password==null || "".equals(password)) {
			result = false;
		}
		if (password.trim().isEmpty() || "".equals(password)) {
			result = false;
		}

		Matcher matcherP = patternP.matcher(password);
		if (!matcherP.matches()) {
			result = false;
		}
		return result;
	}
}


