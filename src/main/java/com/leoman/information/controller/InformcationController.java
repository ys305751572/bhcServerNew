package com.leoman.information.controller;

import com.leoman.common.controller.common.GenericEntityController;
import com.leoman.common.factory.DataTableFactory;
import com.leoman.cp.entity.Cq;
import com.leoman.image.entity.FileBo;
import com.leoman.information.entity.Information;
import com.leoman.information.service.InformationService;
import com.leoman.information.service.impl.InformationServiceImpl;
import com.leoman.utils.ConfigUtil;
import com.leoman.utils.FileUtil;
import com.leoman.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/25.
 */
@Controller
@RequestMapping(value = "/admin/info")
public class InformcationController extends GenericEntityController<Information, Information, InformationServiceImpl> {

    @Autowired
    private InformationService service;

    @RequestMapping(value = "/index")
    public String index() {
        return "info/list";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Map<String, Object> list(Information info, Integer draw, Integer start, Integer length) {
        Page<Information> infoPage = null;
        try {
            int pagenum = getPageNum(start, length);
            infoPage = service.findPage(info, pagenum, length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DataTableFactory.fitting(draw, infoPage);
    }

    @RequestMapping(value = "/add")
    public String add(Long id, Model model) {
        if(id != null) {
            Information info = service.queryByPK(id);
            if (StringUtils.isNotBlank(info.getPath())) {
                info.setPath(ConfigUtil.getString("upload.url") + info.getPath());
            }
            model.addAttribute("info", info);
        }
        return "info/add";
    }

    @RequestMapping(value = "/detail")
    public String detail(Long id, Model model) {
        Information info = service.queryByPK(id);
        if (StringUtils.isNotBlank(info.getPath())) {
            info.setPath(ConfigUtil.getString("upload.url") + info.getPath());
        }
        model.addAttribute("info", info);
        return "info/detail";
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public Result save(Information information, @RequestParam(value = "imageFile", required = false) MultipartFile imageFile) {

        if (imageFile != null && imageFile.getSize() > 0) {
            try {
                FileBo file = FileUtil.save(imageFile);
                if (file != null && StringUtils.isNotBlank(file.getPath()))
                    information.setPath(file.getPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        service.save(information);
        return Result.success();
    }
}
