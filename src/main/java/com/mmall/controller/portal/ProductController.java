package com.mmall.controller.portal;

import com.github.pagehelper.PageInfo;
import com.mmall.service.IProductService;
import com.mmall.common.ServerResponse;
import com.mmall.service.IUserService;
import com.mmall.vo.ProductDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by kexi955 on 5/7/2024.
 */
@Controller
@RequestMapping("/product/")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @RequestMapping(value = "detail.do")
    @ResponseBody
    public ServerResponse<ProductDetailVo> detail(Integer productId){
        return iProductService.getProductDetail(productId);

    }

    @RequestMapping(value = "list.do")
    @ResponseBody
    public ServerResponse<PageInfo> list(@RequestParam(value = "keyword", required = false) String keyword,
                                         @RequestParam(value = "categoryId", required = false) Integer categoryId,
                                         @RequestParam(value = "pageNum", defaultValue = "1") int PageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "10")  int pageSize,
                                         @RequestParam(value = "orderBy", defaultValue = "")  String orderBy){
        return iProductService.getProductByKeywordCategory(keyword, categoryId, PageNum, pageSize, orderBy);

    }

}
