package SpringBootJPA.Model;

import lombok.Data;

@Data
public class ProductDTO {

	private Integer pid;
	private String pname;
	private String description;
	private Float price;
	private CategoryDTO categoryDTO;
}
