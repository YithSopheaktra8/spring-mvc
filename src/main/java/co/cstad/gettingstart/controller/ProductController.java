package co.cstad.gettingstart.controller;

import co.cstad.gettingstart.model.Product;
import co.cstad.gettingstart.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public List<Product> getAllProduct(){
        return productService.loadProduct();
    }

    @PostMapping()
    public Product createProduct(){
        Product product = Product.builder()
                .id(5)
                .name("Gaming Chair")
                .price(120.00)
                .inStock(true)
                .build();
        return productService.addProduct(product);
    }

    @PutMapping
    public Product updateProduct(){

        Product product = Product.builder()
                .id(4)
                .name("Magic mouse 3")
                .price(150.00)
                .inStock(true)
                .build();

        return productService.updateProduct(4,product);
    }

    @PatchMapping
    public String udpateOneProduct(){
        return "Update one Product";
    }


    @DeleteMapping
    public String deleteProduct(){
        return "delete Product";
    }

    @GetMapping("/{id}/{slug}")
    public Product getProductById(@PathVariable Integer id, @PathVariable String slug){
        return productService.loadProductById(id);
    }


    @GetMapping("/search")
    public List<Product> searchProduct(@RequestParam(required = false , defaultValue = "") String name,
                                       @RequestParam(required = false, defaultValue = "true") Boolean status){

        return null;
    }

}
