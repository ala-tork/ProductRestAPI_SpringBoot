package ProductRestWS.service;

import ProductRestWS.model.Product;
import ProductRestWS.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService{
    //get instance of ProductRepository
    @Autowired
    private ProductRepository productRepository;
    //get all product
    @Override
    public List<Product> productList(){
    return productRepository.findAll();
    }
    //get products by ther price
    @Override
    public List<Product> findByPrice(double price)
    {
        return productRepository.findByPrice(price);
    }
    //get Product by his id
    @Override
    public Product getOne(Long id){
        return productRepository.findById(id).get();}

    //save new product
    @Override
    public Product save(Product product){
        return productRepository.save(product);
    }

    //update an existen product
    @Override
    public Product update(Product product, Long id){
        product.setId(id);
        return productRepository.save(product);
    }

    //delete Product
    @Override
    public void delete(Long id){
        productRepository.deleteById(id);
    }
}

