/**
 * 
 */
package com.promineotech.library.entity;

import javax.validation.constraints.Pattern;

import lombok.Builder;
import lombok.Data;

/**
 * @author Bryce Cash
 *
 */
/**
 * 
 * used for inner join in database to return book title and author name.
 *
 */
@Data
@Builder
public class Author_Books {
@Pattern(regexp= "^[a-zA-Z0-9.\\-\\/+=@_ ]*$")	
private String author_name;

private String book_title;
}
