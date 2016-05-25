package com.leoman.information.service;

import com.leoman.common.service.GenericManager;
import com.leoman.information.entity.Information;
import org.springframework.data.domain.Page;

/**
 * Created by Administrator on 2016/5/25.
 */
public interface InformationService extends GenericManager<Information>{

    public Page<Information> findPage(Information info,int pagenum,int pagesize);
}
