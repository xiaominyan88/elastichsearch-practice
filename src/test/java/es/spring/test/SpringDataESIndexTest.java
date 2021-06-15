package es.spring.test;

import es.spring.vo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataESIndexTest {

    @Resource
    private ElasticsearchRestTemplate restTemplate;

    @Test
    public void createIndex(){
        System.out.println("create index successfully!!!");
    }


    @Test
    public void deleteIndex(){
        boolean b = restTemplate.deleteIndex(Product.class);
        System.out.println("delete index successfully?" + b);

    }
}
