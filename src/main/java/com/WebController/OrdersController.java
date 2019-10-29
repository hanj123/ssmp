package com.WebController;


import com.Domain.Orders;
import com.Service.OrdersService;
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
    private OrdersService ordersService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(value = "pageNum", required = true,defaultValue = "1") int pageNum,
                                @RequestParam(value = "pageSize",required = true,defaultValue = "4") int pageSize){
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(Integer id){

        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(id);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(orders);
        System.out.println("------------------------------------------------------------------------------");
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }

}
