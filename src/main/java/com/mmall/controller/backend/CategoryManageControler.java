package com.mmall.controller.backend;

import com.mmall.common.ResponseCode;
import com.mmall.pojo.User;
import com.mmall.common.Const;
import com.mmall.common.ServerResponse;
import com.mmall.service.ICategoryService;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by kexi955 on 5/3/2024.
 */

@Controller
@RequestMapping("/manage/category")
public class CategoryManageControler {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private ICategoryService iCategoryService;

    @RequestMapping(value = "add_category.do")
    @ResponseBody
    public ServerResponse addCategory(HttpSession session, String categoryName, @RequestParam(value = "parentId", defaultValue = "0") int parentId){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.GetCode(), "User not login, please login");
        }
        if(iUserService.checkAdminRole(user).isSuccess()){
            //add admin role process logic below
            return iCategoryService.addCategory(categoryName, parentId);

        }else{
            return ServerResponse.createByErrorMessage("normal user without admin privilage");
        }

    }

    @RequestMapping(value = "set_category_name.do")
    @ResponseBody
    public ServerResponse setCategoryName(HttpSession session, Integer categoryId, String categoryName) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.GetCode(), "User not login, please login");
        }
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //update category name
            return iCategoryService.updateCategoryName(categoryId, categoryName);

        } else {
            return ServerResponse.createByErrorMessage("normal user without admin privilage");
        }

    }

    @RequestMapping(value = "get_category.do")
    @ResponseBody
    public ServerResponse getChildrenParallelCategory(HttpSession session,  @RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.GetCode(), "User not login, please login");
        }
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //get children category id
            return iCategoryService.getChildrenParallelCategory(categoryId);

        } else {
            return ServerResponse.createByErrorMessage("normal user without admin privilage");
        }

    }

    @RequestMapping(value = "get_deep_category.do")
    @ResponseBody
    public ServerResponse getCategoryAndDeepChildrenCategory(HttpSession session,  @RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.GetCode(), "User not login, please login");
        }
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //get children category id and children node category id
            return iCategoryService.selectCategoryAndDeepChildrenCategory(categoryId);

        } else {
            return ServerResponse.createByErrorMessage("normal user without admin privilage");
        }

    }



}
