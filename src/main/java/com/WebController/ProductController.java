package com.WebController;

import com.Domain.Product;
import com.Domain.UserInfo;
import com.Service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAllProduct(@RequestParam(value = "pageNum",required = true,defaultValue = "1") int pageNum,
                                       @RequestParam(value = "pageSize",required = true,defaultValue = "4") int pageSize) {

        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.findAll(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(products);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-list");
        return mv;
    }



    @RequestMapping("/add.do")
    public ModelAndView add(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("product-add");
        return mv;
    }

    @RequestMapping("/save.do")
    public String saveProduct(Product product){

        productService.save(product);

//        return "redirect:/product/findAll.do";
        return "redirect:findAll.do";
    }
}
