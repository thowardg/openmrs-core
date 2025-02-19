package org.openmrs.api.handler;

import org.openmrs.OpenmrsObject;

/**
 * An intermediate interface for handling data operations with additional functionality.
 *
 * @param <R> the type of Retireable object
 */
public interface RetireDataInterface<R extends OpenmrsObject> extends RequiredDataHandler<R> {
    // Additional methods can be defined here as needed.
    // For example:
    // void someCommonMethod();
}
