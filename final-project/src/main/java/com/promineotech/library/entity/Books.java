/**
 * 
 */
package com.promineotech.library.entity;

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
public class Books {
	private String book_isbn;
	private String book_title;
	private String book_status;
	private Integer author_id;
}
