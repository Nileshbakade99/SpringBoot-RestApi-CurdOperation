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

import SpringBootJPA.Model.Product;
import SpringBootJPA.Service.ICrudService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ICrudService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerAdd(@RequestBody Product product){
		try {
			String result = service.registerProduct(product);
			return new ResponseEntity<String>(result,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/find/{pid}")
	public ResponseEntity<?> fetchProductData(@PathVariable ("pid") Integer pid){
		try {
			Product result = service.fetchProductById(pid);
			return new ResponseEntity<Product>(result,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/modify/{pid}")
	public ResponseEntity<String> updateProduct(@PathVariable("pid") Integer pid, @RequestBody Product product ){
		try {
			String result = service.updateProduct(pid,product);
			return new ResponseEntity<String>(result,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{pid}")
	public ResponseEntity<String> deleteProduct(@PathVariable ("pid") Integer pid){
		try {
			String result = service.removeProduct(pid);
			return new ResponseEntity<String>(result,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/ppage")
	public ResponseEntity<Page<Product>> name(@RequestParam ("pageno") Integer pageno, 
			                                     @RequestParam ("pagesize") Integer pagesize) {
		try {
			Page<Product> result = service.getPagination(pageno, pagesize);
			return new ResponseEntity<Page<Product>>(result,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Page<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}





























