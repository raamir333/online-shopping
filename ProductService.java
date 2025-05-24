package com.java.backend.service;
import com.java.backend.entity.Product;
import com.java.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;


@Service
public class ProductService{

    @Autowired
    private ProductRepository repo;

    //getAllProducts
    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    //getProductById
    public Product getProductById(int id){
        return repo.findById(id).orElse(null);
    }

    //addProduct
    public Product addProduct(Product product, MultipartFile imageFile) throws IOException{
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImage(imageFile.getBytes());
        return repo.save(product);
    }

    //updateProduct
    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException{
        //product.setName(product.getName());
        //product.setBrand(product.getBrand());
        //product.setCategory(product.getCategory());
        //product.setPrice(product.getPrice());
        //product.setReleaseDate(product.getReleaseDate());
        //product.setDescription(product.getDescription());

        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImage(imageFile.getBytes());
        return repo.save(product);
    }

    //deleteProductById
    public void deleteProductById(int id){
        repo.deleteById(id);
    }

    //searchProducts
    public List<Product> searchProducts(String keyword){
        return repo.searchProducts(keyword);
    }

}