/**
 * 
 */
package com.promineotech.library.entity;

import org.w3c.dom.Text;

import lombok.Builder;
import lombok.Data;

/**
 * @author Bryce Cash
 *
 */
@Data
@Builder
public class Review_Books {
	private Integer review_id;
	private String review_text;
	private String book_isbn;
	private String book_title;
}
