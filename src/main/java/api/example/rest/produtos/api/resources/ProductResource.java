package api.example.rest.produtos.api.resources;

import api.example.rest.produtos.api.models.Product;
import api.example.rest.produtos.api.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value ="API REST Products")
@CrossOrigin(origins="*")
public class ProductResource {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    @ApiOperation(value = "Return a list of products")
    public List<Product> listProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    @ApiOperation(value = "Return a product by id")
    public Product getProduct(@PathVariable(value="id") long id){
        return productRepository.findById(id);
    }

    @PostMapping("/product")
    @ApiOperation(value = "Create a product")
    public Product saveProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @DeleteMapping("/product")
    @ApiOperation(value = "Delete a product")
    public void deleteProduct(@RequestBody Product product){
        productRepository.delete(product);
    }

    @PutMapping("/product")
    @ApiOperation(value = "Update a product")
    public Product updateProduct(@RequestBody Product product){
        return productRepository.save(product);
    }
}
