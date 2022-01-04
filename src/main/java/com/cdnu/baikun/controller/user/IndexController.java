package com.cdnu.baikun.controller.user;

import com.cdnu.baikun.domain.Category;
import com.cdnu.baikun.domain.User;
import com.cdnu.baikun.utils.GetIpaddress;
import com.cdnu.baikun.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @author 白坤
 * @description 首页控制器
 */
@Controller
public class IndexController {
    @Autowired
    private UserService userService;
    @Autowired
    private ResourcesService resourcesService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private CoverService coverService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ResourceCategoryRefService refService;

    @RequestMapping("/")
    public String index(Model model, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            if (cookies!=null) {
                for (Cookie c : cookies
                ) {
                    if (c.getName().equals("username")) {
                        user = userService.login(c.getValue());
                    }
                    if (user != null) {
                        user.setUserLastIpaddress(GetIpaddress.getIpAddress(request));
                        userService.updateById(user);
                        request.getSession().setAttribute("user", user);
                    }
                }
            }
            }

        //获取分类列表
        List<Category> categories = categoryService.categoryList();
        model.addAttribute("categories",categories);
        return "index";
    }
}
