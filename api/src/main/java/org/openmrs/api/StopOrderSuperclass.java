/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.api;

/**
 * Abstract class that serves as an intermediate for order entry exceptions related to 
 * discontinuation processes. This class is not intended to be instantiated directly.
 * 
 * @since 2.1
 */
public abstract class StopOrderSuperclass extends OrderEntryException {
	
	public StopOrderSuperclass(String message) {
		super(message);
	}
	
	public StopOrderSuperclass(String message, Throwable cause) {
		super(message, cause);
	}
	
	public StopOrderSuperclass(String messageKey, Object[] parameters) {
		super(messageKey, parameters);
	}
}
