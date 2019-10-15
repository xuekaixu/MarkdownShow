package com.manage.controller;

import com.manage.service.HiveTableDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@Configurable
@RequestMapping("/user")
public class HiveTableDescController {
    @Autowired
    private HiveTableDescService hiveTableDescService;

    @RequestMapping(value = "/DescriptionContentShow")
    @ResponseBody
    public Map DescriptionContentShow(@RequestParam("dbTable") String dbTable) {
//        String dbTable = request.getParameter("dbTable");
        Map<String,Object> resultMap = hiveTableDescService.searchDescContent(dbTable);
//        request.setAttribute("resultMap", resultMap);
//        ModelAndView modelAndView = new ModelAndView("");
//        return modelAndView;
        return resultMap;

    }

    @RequestMapping(value = "/DescriptionContentUpdate")
    @ResponseBody
    public Map DescriptionContentUpdate(@RequestParam("dbTable") String dbTable,
                                        @RequestParam("content") String content,
                                        @RequestParam("userName") String userName) {
        return hiveTableDescService.updateDescContent(dbTable,content,userName);
    }

    @RequestMapping(value = "/DescriptionContentCreate")
    @ResponseBody
    public Map DescriptionContentCreate(@RequestParam("dbTable") String dbTable,
                                        @RequestParam("content") String content,
                                        @RequestParam("userName") String userName) {

        return hiveTableDescService.createDescContent(dbTable,content,userName);
    }

    @RequestMapping(value = "/DescriptionContentSearchAll")
    @ResponseBody
    public ModelAndView DescriptionContentSearchAll(HttpServletRequest request) {
        Map<String,Object> resultMap =  hiveTableDescService.searchAll();

//        System.out.println(resultMap.get("data"));
//        if (resultMap == null) {
//            ModelAndView modelAndView = new ModelAndView("loginError");
//            return modelAndView;
//        }
        request.setAttribute("resultMap", resultMap);
        ModelAndView modelAndView = new ModelAndView("listDBTable");
        return modelAndView;
    }

}
