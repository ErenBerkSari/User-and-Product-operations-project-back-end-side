package kodlamaio.northwind.business.abstracts;

import java.util.List;


import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	DataResult<List<Product>> getAll();
	
	DataResult<List<Product>> getAll(int pageNo,int pageSize);
	
	DataResult<List<Product>> getAllSorted();
	
	Result add(Product product);
	
	DataResult<Product> getByProductName(String productName);
	
	DataResult<Product> getByProductNameAndCategoryId(String productName,int categoryId);//And operatoru
	
	DataResult<List<Product>> getByProductNameOrCategoryId(String productName,int categoryId);//or operatoru

	DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);//çoklı seçim yapmamızı sağlar

	DataResult<List<Product>> getByProductNameContains(String productName);//içeriyorsa

	DataResult<List<Product>> getByProductNameStartsWith(String productName);//Girilen değerle başalayan ürünler gelir

	DataResult<List<Product>> getByNameAndCategory(String productName , int categoryId);
	
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(); 

	
}
