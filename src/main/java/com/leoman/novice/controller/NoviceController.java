package com.leoman.novice.controller;

import com.leoman.common.controller.common.GenericEntityController;
import com.leoman.common.factory.DataTableFactory;
import com.leoman.cp.entity.Cq;
import com.leoman.image.entity.FileBo;
import com.leoman.novice.entity.Novice;
import com.leoman.novice.service.NoviceService;
import com.leoman.novice.service.impl.NoviceServiceImpl;
import com.leoman.question.entity.vo.QuestionContainer;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/25.
 */
@Controller
@RequestMapping(value = "/admin/novice")
public class NoviceController extends GenericEntityController<Novice, Novice, NoviceServiceImpl> {

    @Autowired
    private NoviceService service;

    @RequestMapping(value = "/index")
    public String index() {
        return "novice/list";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Map<String, Object> list(String content, Integer draw, Integer start, Integer length) {
        Page<Novice> novicePage = null;
        try {
            int pagenum = getPageNum(start, length);
            novicePage = service.findPage(content, pagenum, length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DataTableFactory.fitting(draw, novicePage);
    }

    @RequestMapping(value = "/add")
    public String add(Long id, Model model) {
        if(id != null) {
            model.addAttribute("novice", service.queryByPK(id));
        }
        return "novice/add";
    }

    @RequestMapping(value = "/detail")
    public String detail(Long id, Model model) {
        model.addAttribute("novice", service.queryByPK(id));
        return "novice/detail";
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

    /**
     * 新增题库
     *
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Result save(Novice novice, MultipartFile imageFile, HttpServletRequest request) {

        if (imageFile != null && imageFile.getSize() > 0) {
            try {
                FileBo file = FileUtil.save(imageFile);
                if (file != null && StringUtils.isNotBlank(file.getPath()))
                    novice.setPath(file.getPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        service.save(novice);
        return Result.success();
    }
}
