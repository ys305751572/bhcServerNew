package com.leoman.novice.service;

import com.leoman.common.service.GenericManager;
import com.leoman.novice.entity.Novice;
import org.springframework.data.domain.Page;

/**
 * Created by Administrator on 2016/5/25.
 */
public interface NoviceService extends GenericManager<Novice>{

    public Page<Novice> findPage(String content,int pagenum,int pagesize);
}
