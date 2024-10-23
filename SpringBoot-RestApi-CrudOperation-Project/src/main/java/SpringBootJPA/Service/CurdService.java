package SpringBootJPA.Service;

import java.util.Optional;

import org.hibernate.FetchNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import SpringBootJPA.Model.Category;
import SpringBootJPA.Model.Product;
import SpringBootJPA.Repository.ICategoryRepository;
import SpringBootJPA.Repository.IProductRepository;

@Service("service")
public class CurdService implements ICrudService {
	
	@Autowired
	private ICategoryRepository cateRepo;
	
	@Autowired
	private IProductRepository prodRepo;
	
	@Override
	public String registerCategory(Category category) {
		int val = cateRepo.save(category).getCid();
		return "Category data add successfully!! " + val;
	}

	@Override
	public Category fetchCategoryById(Integer cid) throws FetchNotFoundException{
		return cateRepo.findById(cid)
				.orElseThrow(()-> new FetchNotFoundException("Category not found!! ", cid));
	}

	@Override
	public Category updateCategory(Category categ){
		Category op = cateRepo.findById(categ.getCid()).get();
		op.setCname(categ.getCname());
		op.setProduct(categ.getProduct());
		return cateRepo.save(op);
	}

	@Override
	public String removeCategoryById(Integer id) {	
		Optional<Category> op = cateRepo.findById(id);
		if(op.isPresent()) {
			cateRepo.deleteById(id);
			return id + "Category is delete Successfully!!";
		} else {
			return "Category is not found and Not delete!!";
		}
	}

	@Override
	public Page<Category> getCategoryByPage(Integer pageno, Integer pagesize) {		
		Pageable pageable = PageRequest.of(pageno, pagesize);
		return cateRepo.findAll(pageable);
	}
	
	//-----------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------

	@Override
	public String registerProduct(Product product) {
		Integer result = prodRepo.save(product).getPid();
		return "Product Create Successfully!! " + result;
	}

	@Override
	public Product fetchProductById(Integer pid){
		return prodRepo.findById(pid).orElseThrow(()-> new FetchNotFoundException("Product Id not Found", pid));
	}

	@Override
	public String updateProduct(Integer pid,Product product) {
		Optional<Product> op = prodRepo.findById(pid);
		if(op.isPresent()) {
			prodRepo.save(product);
			return "Product Update Successfully " + op.get();
		} else {
		   return "Product Not Found";
		}
	}

	@Override
	public String removeProduct(Integer pid) {
		Optional<Product> op = prodRepo.findById(pid);
		if(op.isPresent()) {
			prodRepo.deleteById(pid);
			return "Product Delete successfully!! " + pid;
		} else {
		    return "Product Not Found and Delete!!";
		}
	}

	@Override
	public Page<Product> getPagination(Integer pageno, Integer pagesize) {
		Pageable pageable = PageRequest.of(pageno,pagesize);
		return prodRepo.findAll(pageable);
	}
}













