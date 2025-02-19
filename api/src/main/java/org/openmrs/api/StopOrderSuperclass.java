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
