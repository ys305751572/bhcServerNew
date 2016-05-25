package com.leoman.cp.controller;

import com.leoman.common.controller.common.GenericEntityController;
import com.leoman.common.factory.DataTableFactory;
import com.leoman.cp.entity.Cq;
import com.leoman.cp.service.CqService;
import com.leoman.cp.service.impl.CqServiceImpl;
import com.leoman.utils.JsonUtil;
import com.leoman.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Administrator on 2016/5/25.
 */
@Controller
@RequestMapping(value = "/admin/cq")
public class CqController extends GenericEntityController<Cq,Cq,CqServiceImpl>{

    @Autowired
    private CqService service;

    @RequestMapping(value = "/index")
    public String index() {
        return "cq/list";
    }

    @RequestMapping(value = "/add")
    public String add(Long id, Model model) {
        if(id != null) {
            model.addAttribute("cq",service.queryByPK(id));
        }
        return "cq/add";
    }

    @RequestMapping(value = "/detail")
    public String detail(Long id, Model model) {
        model.addAttribute("cq",service.queryByPK(id));
        return "cq/detail";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Map<String,Object> list(Cq cq,Integer draw,Integer start,Integer length) {
        Page<Cq> cqPage = null;
        try {
            int pagenum = getPageNum(start,length);
            cqPage = service.findPage(cq,pagenum,length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DataTableFactory.fitting(draw,cqPage);
    }

    @RequestMapping(value = "/save")
    public String save(Cq cq) {
        service.save(cq);
        return "cq/list";
    }

    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteBatch(String ids) {
        Long[] arrayId = JsonUtil.json2Obj(ids, Long[].class);
        for (Long id : arrayId) {
            service.delete(service.queryByPK(id));
        }
        return Result.success();
    }
}
