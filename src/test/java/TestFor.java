import cn.kgc.demo.pojo.Sale;
import cn.kgc.demo.service.imp.ProductServiceImpl;
import cn.kgc.demo.service.imp.SaleServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath:spring-config.xml"})
@RunWith(value = SpringJUnit4ClassRunner.class)
public class TestFor {

    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private SaleServiceImpl saleService;
    @Test
        public void cc(){
        Sale sale=new Sale();

        System.out.println(saleService.selectAllBy(1,2,sale));
    }


    }


