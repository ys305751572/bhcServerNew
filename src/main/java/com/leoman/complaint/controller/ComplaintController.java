package com.leoman.complaint.controller;

import com.leoman.common.controller.common.GenericEntityController;
import com.leoman.common.factory.DataTableFactory;
import com.leoman.complaint.entity.Complaint;
import com.leoman.complaint.service.ComplaintService;
import com.leoman.complaint.service.impl.ComplaintServiceImpl;
import com.leoman.cp.entity.Cq;
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
 * Created by Administrator on 2016/5/26.
 */
@Controller
@RequestMapping(value = "/admin/comp")
public class ComplaintController extends GenericEntityController<Complaint, Complaint, ComplaintServiceImpl> {

    @Autowired
    private ComplaintService service;


    @RequestMapping(value = "/index")
    public String index() {
        return "comp/list";
    }

    @RequestMapping(value = "/add")
    public String add(Long id, Model model) {
        if (id != null) {
            model.addAttribute("comp", service.queryByPK(id));
        }
        return "comp/add";
    }

    @RequestMapping(value = "/detail")
    public String detail(Long id, Model model) {
        model.addAttribute("comp", service.queryByPK(id));
        return "comp/detail";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Map<String, Object> list(String aolname, String doctorname, Integer draw, Integer start, Integer length) {
        Page<Complaint> page = null;
        try {
            int pagenum = getPageNum(start, length);
            page = service.findPage(aolname, doctorname, pagenum, length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DataTableFactory.fitting(draw, page);
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
