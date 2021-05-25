package cn.kgc.demo.controller;

import cn.kgc.demo.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("product")
public class ProductController extends BaseController<Product> {
}
