package ProductRestWS.EndPoint;

import ProductRestWS.model.Product;
import ProductRestWS.service.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")// specifier un path pour le web service
public class ProductRestController {
    //instance of service Interface
    @Autowired
    private ProductServiceImp productService;
    //Get Endpoint return all the product
    @GetMapping(path = "/product")
    public List<Product> produitList() {
        return productService.productList();
    }
    //Get Endpoint return product By price
    @GetMapping(path = "/product/ByPrice/{price}")
    public List<Product> findByPrice(@PathVariable double price) {
        return productService.findByPrice(price);
    }
    //Get EndPoint return one product by id
    @GetMapping(path = "/products/{id}")
    public Product getOne(@PathVariable Long id) {
        return productService.getOne(id);
    }

    //get endpoint retun all product format json or xml
    @GetMapping(path = "/productsMediaType", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//mettre deux formats possibles peut generer erreur dans navigateur car il a besoin de header accept
// produire soit Jsom soit xml
    public List<Product> produitListMediaType() {

        return productService.productList();
    }



    //Endpoint add Product
    @PostMapping(path = "/product")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping(path = "/product/{id}")
    public Product update(@RequestBody Product product, @PathVariable Long id) {
        return productService.update(product,id);
    }
    //delete endpoint
    @DeleteMapping(path = "/product/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}

