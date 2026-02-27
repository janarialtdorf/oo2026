package ee.jaltdorf.veebipood.controller;

import ee.jaltdorf.veebipood.entity.Product;
import ee.jaltdorf.veebipood.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    //localhost:8080/products
    //application.properties server.port=5050

    /*    @GetMapping("products")
    public String Helloworld(){
        return "Hello world";
    }*/

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("products")
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @GetMapping("products/{id}")
    public Product getOneProducts(@PathVariable Long id){
        return productRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("products/{id}")
    public List<Product> deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id); //kustutab
        return productRepository.findAll(); //siin on uuenenud seis
    }

    @PostMapping("products")
    public List<Product> addProduct(@RequestBody Product product){
        if (product.getId() != null){
            throw new RuntimeException("Cannot add with ID");
        }
        productRepository.save(product); //siin salvestab
        return productRepository.findAll(); //siin on uuenenud seis
    }

    @PutMapping("products")
    public List<Product> editProduct(@RequestBody Product product){
        //file settings -> plugins -> lombok -> install
        if (product.getId() == null){
            throw new RuntimeException("Cannot edit without ID");
        }
        if (!productRepository.existsById(product.getId())){
            throw new RuntimeException("Product ID doesn't exist");
        }
        productRepository.save(product); //siin salvestab
        return productRepository.findAll(); //siin on uuenenud seis
    }

}
