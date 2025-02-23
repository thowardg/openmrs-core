/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.util;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openmrs.User;

public class OpnenmrsUtilAid {
	
	/**
	 * Gets an out File object. If date is not provided, the current timestamp is used. If user is
	 * not provided, the user id is not put into the filename. Assumes dir is already created
	 * 
	 * @param dir directory to make the random filename in
	 * @param date optional Date object used for the name
	 * @param user optional User creating this file object
	 * @return file new file that is able to be written to
	 */
	public static File getOutFile(File dir, Date date, User user) {
		Random gen = new Random();
		File outFile;
		do {
			// format to print date in filename
			DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd-HHmm-ssSSS");
			
			// use current date if none provided
			if (date == null) {
				date = new Date();
			}
			
			StringBuilder filename = new StringBuilder();
			
			// the start of the filename is the time so we can do some sorting
			filename.append(dateFormat.format(date));
			
			// insert the user id if they provided it
			if (user != null) {
				filename.append("-");
				filename.append(user.getUserId());
				filename.append("-");
			}
			
			// the end of the filename is a randome number between 0 and 10000
			filename.append(gen.nextInt() * 10000);
			filename.append(".xml");
			
			outFile = new File(dir, filename.toString());
			
			// set to null to avoid very minimal possiblity of an infinite loop
			date = null;
			
		} while (outFile.exists());
		
		return outFile;
	}
	
}
