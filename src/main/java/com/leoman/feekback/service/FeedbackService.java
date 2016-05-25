package com.leoman.feekback.service;

import com.leoman.common.service.GenericManager;
import com.leoman.feekback.entity.FeedBack;
import org.springframework.data.domain.Page;

/**
 * Created by Administrator on 2016/5/25.
 */
public interface FeedbackService extends GenericManager<FeedBack>{

    public Page<FeedBack> findPage(String content,String title,int pagenum,int pagesize);
}
