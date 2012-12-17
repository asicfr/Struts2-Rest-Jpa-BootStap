package org.telosys.starterkits.strutsjpa;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author slabbe
 *
 */
public class CoreUtils {

	/**
	 * Check if not blank
	 * @param value
	 * @return
	 */
	public static boolean isNotBlank(final String value) {
		return ((value != null) && (value.trim().equals("") == false));
	}

	/**
	 * Check if not blank
	 * @param value
	 * @return
	 */
	public static boolean isNotBlank(final Integer value) {
		return value != null;
	}
	
	/**
	 * Check if not blank
	 * @param value
	 * @return
	 */
	public static boolean isNotBlank(final Long value) {
		return value != null;
	}

	/**
	 * Check if not blank
	 * @param value
	 * @return
	 */
	public static boolean isNotBlank(final Double value) {
		return value != null;
	}

	/**
	 * Check if not blank
	 * @param value
	 * @return
	 */
	public static boolean isNotBlank(final Short value) {
		return value != null;
	}

	/**
	 * Check if not blank
	 * @param value
	 * @return
	 */
	public static boolean isNotBlank(final Date value) {
		return value != null;
	}

	/**
	 * Check if not blank
	 * @param value
	 * @return
	 */
	public static boolean isNotBlank(final Boolean value) {
		return value != null;
	}

	/**
	 * Check if not blank
	 * @param value
	 * @return
	 */
	public static boolean isNotBlank(final BigDecimal value) {
		return value != null;
	}

}
