package SpringBootJPA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringBootJPA.Model.Category;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

}
