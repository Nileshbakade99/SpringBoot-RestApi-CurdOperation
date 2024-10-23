package SpringBootJPA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringBootJPA.Model.Product;

public interface IProductRepository extends JpaRepository<Product, Integer>{

}
