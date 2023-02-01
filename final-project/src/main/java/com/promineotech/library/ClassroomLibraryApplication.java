/**
 * 
 */
package com.promineotech.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Bryce Cash
 *
 */
@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class ClassroomLibraryApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ClassroomLibraryApplication.class, args);

	}

}
