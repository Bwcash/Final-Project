/**
 * 
 */
package com.promineotech.library.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author Bryce Cash
 *
 */
@Data
@Builder
public class ReviewInput {
	private String review_text;
	private String book_isbn;

public boolean isValid() {
	return getReview_text() != null &&(! getReview_text().isEmpty()) &&
			getBook_isbn() != null && (! getBook_isbn().isEmpty());
}
}
