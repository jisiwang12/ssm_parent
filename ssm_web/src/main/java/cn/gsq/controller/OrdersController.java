package cn.gsq.controller;

import cn.gsq.domain.Orders;
import cn.gsq.service.IOrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;
    //未分页
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue =
            "1") Integer page, @RequestParam(name = "pageSize", required = true, defaultValue = "3")
                                        Integer pageSize) throws Exception {
        System.out.println("orders的findAll方法执行了");
        List<Orders> ordersList = ordersService.findAllByPage(page, pageSize);
        ModelAndView mv = new ModelAndView();
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.setViewName("orders-list");
        mv.addObject("pageInfo", pageInfo);
        System.out.println(ordersList);
        return mv;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String id) {
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(id);
        mv.addObject("orders", orders);
        mv.setViewName("orders-show");

        return mv;

    }
}
