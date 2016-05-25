package com.leoman.cp.service;

import com.leoman.common.service.GenericManager;
import com.leoman.cp.entity.Cq;
import org.springframework.data.domain.Page;

/**
 * Created by Administrator on 2016/5/25.
 */
public interface CqService extends GenericManager<Cq>{

    public Page<Cq> findPage(Cq cq,int pagenum,int pagesize);
}
