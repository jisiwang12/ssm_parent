package cn.gsq.controller;

import cn.gsq.domain.Product;
import cn.gsq.service.impl.ProductServiceImpl;
import cn.gsq.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author mechrevo
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    /**
     * 查询所有商品信息
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        System.out.println("product的findAll执行了");
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.findAll();
        modelAndView.addObject("productList", products);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    /**
     * 产品添加
     */
    @RequestMapping("/save")
    public String save(Product product) throws IOException {
        System.out.println("product的save执行了");
        productService.save(product);
        return "redirect:findAll";
    }
}
