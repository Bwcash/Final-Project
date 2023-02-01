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
public class Genre {
	private Integer genre_id;
	private String genre_name;
}
