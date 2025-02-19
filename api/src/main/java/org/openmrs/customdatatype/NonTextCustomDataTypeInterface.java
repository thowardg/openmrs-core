

/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.customdatatype;


/**
 * Abstract class for serializing custom datatypes
 * @param <T> The type this datatype handles
 */
public abstract class NonTextCustomDataTypeInterface<T> extends SerializingCustomDatatype<T> {

    /**
     * Serializes the given value to a String representation
     * @param typedValue The value to serialize
     * @return String representation of the value
     */
    @Override
    public abstract String serialize(T typedValue);

    /**
     * Deserializes the given String to reconstruct the value
     * @param serializedValue The String representation
     * @return The reconstructed value
     */
    @Override
    public abstract T deserialize(String serializedValue);
}
