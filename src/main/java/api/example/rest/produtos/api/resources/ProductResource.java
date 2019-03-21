package api.example.rest.produtos.api.resources;

import api.example.rest.produtos.api.models.Product;
import api.example.rest.produtos.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class ProductResource {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> listProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable(value="id") long id){
        return productRepository.findById(id);
    }

    @PostMapping("/product")
    public Product saveProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

}
