/**
 * 
 */
package com.promineotech.library.entity;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bryce Cash
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book_Genre {
	private String book_title;
	
	@Pattern(regexp= "^[a-zA-Z0-9.\\-\\/+=@_ ]*$")
	private String genre_name;
}
