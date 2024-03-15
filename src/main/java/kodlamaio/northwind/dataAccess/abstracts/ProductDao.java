package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

//JpaReposoitory<Hangi class için çalıştığımız,Primary key'in türü>
public interface ProductDao extends JpaRepository<Product,Integer> {

	Product getByProductName(String productName);
	
	Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);//And operatoru
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName,int categoryId);//or operatoru

	List<Product> getByCategoryIn(List<Integer> categories);//çoklı seçim yapmamızı sağlar

	List<Product> getByProductNameContains(String productName);//içeriyorsa

	List<Product> getByProductNameStartsWith(String productName);//Girilen değerle başalayan ürünler gelir

	// From entitideki class adı where kolon adı=:Değişken olarak alınan değer adı,,kolon adı olan kısım Product sınıfındaki değişkenler olmak zorunda,veritabanındaki değil
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> getByNameAndCategory(String productName , int categoryId);
	
	@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id , p.productName, c.categoryName) From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails(); 
}
