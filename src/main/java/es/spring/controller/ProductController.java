package es.spring.controller;

import es.spring.dao.ProductDao;
import es.spring.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ESController")
public class ProductController {

    @Autowired
    ProductDao productDao;

    @PostMapping("save")
    public Product save(Product product){
        return productDao.save(product);
    }



}
