package SpringBootJPA.Model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "PRODUCT_TAB")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Product implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer pid;
	
	@NonNull
	@Column(length = 200)
	private String pname;
	
	@NonNull
	@Column(length = 500)
	private String description;
	
	@NonNull
	private Float price;
	
	@ManyToOne(targetEntity = Category.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "Category_ID",referencedColumnName = "CID")
	private Category category;
}
