/**
 * 
 */
package com.promineotech.library.entity;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

/**
 * @author Bryce Cash
 *
 */
@Data
@Builder
public class Review {
	private Integer review_id;
	private String review_text;
	
	@Length(min = 17, max = 17)
	@Pattern(regexp= "[0-9_]*")
	private String book_isbn;
}
