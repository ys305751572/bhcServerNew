package com.leoman.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/5/10.
 */
@Controller
@RequestMapping
public class TestController {

    @RequestMapping(value = "tablesIndex")
    public String tablesIndex() {
        return "test/tables";
    }
}
