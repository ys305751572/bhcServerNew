package com.leoman.feekback.controller;

import com.leoman.common.controller.common.GenericEntityController;
import com.leoman.common.factory.DataTableFactory;
import com.leoman.feekback.entity.FeedBack;
import com.leoman.feekback.service.FeedbackService;
import com.leoman.feekback.service.impl.FeedbackServiceImpl;
import com.leoman.image.entity.FileBo;
import com.leoman.information.entity.Information;
import com.leoman.utils.ConfigUtil;
import com.leoman.utils.FileUtil;
import com.leoman.utils.JsonUtil;
import com.leoman.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/25.
 */
@Controller
@RequestMapping(value = "/admin/feedback")
public class FeedbackController extends GenericEntityController<FeedBack,FeedBack,FeedbackServiceImpl>{

    @Autowired
    private FeedbackService service;

    @RequestMapping(value = "/index")
    public String index() {
        return "info/list";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Map<String, Object> list(String content,String title, Integer draw, Integer start, Integer length) {
        Page<FeedBack> page = null;
        try {
            int pagenum = getPageNum(start, length);
            page = service.findPage(content,title, pagenum, length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DataTableFactory.fitting(draw, page);
    }

    @RequestMapping(value = "/add")
    public String add(Long id, Model model) {
        if(id != null) {
            FeedBack feedBack = service.queryByPK(id);
            model.addAttribute("info", feedBack);
        }
        return "info/add";
    }

    @RequestMapping(value = "/detail")
    public String detail(Long id, Model model) {
        FeedBack feedBack = service.queryByPK(id);
        model.addAttribute("info", feedBack);
        return "info/detail";
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public Result save(FeedBack feedBack) {
        service.save(feedBack);
        return Result.success();
    }

    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteBatch(String ids) {
        Long[] arrayId = JsonUtil.json2Obj(ids, Long[].class);
        for (Long id : arrayId) {
            service.deleteByPK(service.queryByPK(id));
        }
        return Result.success();
    }
}
