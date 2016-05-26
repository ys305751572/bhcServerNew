package com.leoman.complaint.service;

import com.leoman.common.service.GenericManager;
import com.leoman.complaint.entity.Complaint;
import org.springframework.data.domain.Page;

/**
 * Created by Administrator on 2016/5/26.
 */
public interface ComplaintService extends GenericManager<Complaint>{

    public Page<Complaint> findPage(String aolname,String doctorname,int pagenum,int pagesize);
}
