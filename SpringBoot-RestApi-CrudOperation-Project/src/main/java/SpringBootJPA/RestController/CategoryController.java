package SpringBootJPA.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import SpringBootJPA.Model.Category;
import SpringBootJPA.Service.ICrudService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private ICrudService service;

	@PostMapping("/register")
	public ResponseEntity<String> showRegister(@RequestBody Category cate){
		try {
			String cc = service.registerCategory(cate);
			return new ResponseEntity<String>(cc,HttpStatus.OK);		
		} catch (Exception e) {
			return new ResponseEntity<String>("problem in category",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/find/{cid}")
	public ResponseEntity<?> displayById(@PathVariable("cid") Integer cid){
		try {
			Category category = service.fetchCategoryById(cid);
			return new ResponseEntity<Category>(category,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/modify/{id}")
	public ResponseEntity<Category> modifyCategory(@PathVariable("id") Integer cid, @RequestBody Category categ){
		try {
			categ.setCid(cid);
			Category result = service.updateCategory(categ);
			return new ResponseEntity<Category>(result,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Category>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{cid}")
	public ResponseEntity<?> deleteById(@PathVariable ("cid") Integer cid){
		try {
			String result = service.removeCategoryById(cid);
			return new ResponseEntity<String>(result,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String >(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/ppage")
	public ResponseEntity<Page<Category>> findPageNumber(@RequestParam ("pageno") Integer pageno,
			                                       @RequestParam ("pagesize") Integer pagesize){
		try {
			Page<Category> result = service.getCategoryByPage(pageno, pagesize);
			return new ResponseEntity<Page<Category>>(result,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Page<Category>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
















