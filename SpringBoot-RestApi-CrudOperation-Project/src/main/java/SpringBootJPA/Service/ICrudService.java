package SpringBootJPA.Service;

import org.hibernate.FetchNotFoundException;
import org.springframework.data.domain.Page;

import SpringBootJPA.Model.Category;
import SpringBootJPA.Model.Product;

public interface ICrudService {

	//Save
	public String registerCategory(Category category);
	
	//getById
	public Category fetchCategoryById(Integer cid) throws FetchNotFoundException;
	
	//update
	public Category updateCategory(Category categ);
	
	//remove
	public String removeCategoryById(Integer id);
	
	//pageable
	public Page<Category> getCategoryByPage(Integer pageno, Integer pagesize);
	
	//--------------------------------------------------------------------------------------------
	//Product
	//save 
	public String registerProduct(Product product);
	
	//getbyid
	public Product fetchProductById(Integer pid);
	
	//update
	public String updateProduct(Integer pid ,Product product);
	
	//remove
	public String removeProduct(Integer pid);
	
	//pagination
	public Page<Product> getPagination(Integer pageno, Integer pagesize);
}


