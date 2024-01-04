package co.cstad.gettingstart.service;

import co.cstad.gettingstart.model.Product;
import co.cstad.gettingstart.util.SlugUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {

    private final List<Product> products;


    public ProductService(){
        products = new ArrayList<>();
        products.add(Product.builder()
                .id(1)
                .name("Dell Desktop")
                .slug(SlugUtil.toSlug("Dell Desktop"))
                .price(950.00)
                .inStock(true)
                .build());

        products.add(Product.builder()
                .id(2)
                .name("MacBook M1 Pro")
                .slug(SlugUtil.toSlug("MacBook M1 Pro"))
                .price(1200.00)
                .inStock(true)
                .build());

        products.add(Product.builder()
                .id(3)
                .name("Magic Mouse")
                .slug(SlugUtil.toSlug("Magic Mouse"))
                .price(50.00)
                .inStock(false)
                .build());

        products.add(Product.builder()
                .id(4)
                .name("Asus Desktop")
                .slug(SlugUtil.toSlug("Asus Desktop"))
                .price(800.00)
                .inStock(true)
                .build());
    }


    public List<Product> loadProduct(){
        return products;
    }

    public Product loadProductById(Integer id){
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Product not found"));
    }

    public Product addProduct(Product product){
        if(product != null){
            product.setSlug(SlugUtil.toSlug(product.getName()));
            products.add(product);
            return product;
        }
        throw new RuntimeException("Product cannot not added");
    }


    public Product updateProduct(Integer id, Product newProduct){
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .peek(product -> {
                    product.setName(newProduct.getName());
                    product.setSlug(SlugUtil.toSlug(product.getName()));
                    product.setPrice(newProduct.getPrice());
                    product.setInStock(newProduct.getInStock());
                })
                .findFirst()
                .orElseThrow();
    }

}
