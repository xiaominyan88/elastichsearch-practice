package es.spring.test;

import es.spring.dao.ProductDao;
import es.spring.vo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataESSearchTest {

    @Autowired
    ProductDao productDao;

    @Test
    public void save() throws Exception {
        Product product = new Product(1l,"hua wei","cellphone",4000.00,"http://www.images.com/huawei");
        Product save = productDao.save(product);
        if(save != null){
            System.out.println("doc info :" + "id = " + save.getId() + ", title = " + save.getTitle());
        }else{
            throw new Exception("save operation do not succeed!");
        }

    }

    @Test
    public void update() throws Exception{
        Product product = new Product(1l,"xiao mi","cellphone",2000.00,"http://www.images.com/xiaomi");
        Product save = productDao.save(product);
        if(save != null){
            System.out.println("doc info :" + "id = " + save.getId() + ", title = " + save.getTitle());
        }else{
            throw new Exception("update operation do not succeed!");
        }

    }

    @Test
    public void findById() throws Exception{
        Product product = productDao.findById(1l).get();
        if(product != null){
            System.out.println("doc info :" + "id = " + product.getId() + ", title = " + product.getTitle());
        }else{
            throw new Exception("query operation do not succeed!");
        }
    }

    @Test
    public void findAll() throws Exception{
        Iterator<Product> iterator = productDao.findAll().iterator();
        while(iterator.hasNext()){
            Product product = iterator.next();

            if(product != null){
                System.out.println("doc info :" + "id = " + product.getId() + ", title = " + product.getTitle());
            }else{
                throw new Exception("query operation do not succeed!");
            }

        }

    }

    @Test
    public void delete() throws Exception{
        productDao.deleteById(1l);
    }

    @Test
    public void saveAll() throws Exception{
        List<Product> list = new ArrayList<Product>();
        for(long i = 1l; i < 20l; i++){
            Product product = new Product(i,"xiao mi","cellphone",1234+i,"http://www.image.com/xiaomi");
            list.add(product);
        }
        Iterable<Product> products = productDao.saveAll(list);
        Iterator<Product> productIterator = products.iterator();
        while(productIterator.hasNext()){

            Product product = productIterator.next();

            System.out.println("doc info :" + "id = " + product.getId() + ", title = " + product.getTitle());

        }

    }


    @Test
    public void findByPagable(){
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        int currentPage = 0;
        int size = 2;
        PageRequest request = PageRequest.of(currentPage,size,sort);
        Page<Product> products = productDao.findAll(request);
        for(Product product : products.getContent()){
            System.out.println(product);
        }
    }
}
