package SpringBootJPA.Model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "CATEGORY_TAB")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer cid;
	
	@NonNull
	@Column(length = 200)
	private String cname;
	
	@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="Category_ID",referencedColumnName = "CID")
	private List<Product> product;

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", product=" + product + "]";
	}
}
