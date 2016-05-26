package com.leoman.complaint.service.impl;

import com.leoman.common.service.impl.GenericManagerImpl;
import com.leoman.complaint.dao.ComplaintDao;
import com.leoman.complaint.entity.Complaint;
import com.leoman.complaint.service.ComplaintService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/26.
 */
@Service
public class ComplaintServiceImpl extends GenericManagerImpl<Complaint, ComplaintDao> implements ComplaintService {

    @Autowired
    private ComplaintDao dao;

    @Override
    public Page<Complaint> findPage(final String aolname, final String doctorname, int pagenum, int pagesize) {
        Specification<Complaint> spec = new Specification<Complaint>() {
            @Override
            public Predicate toPredicate(Root<Complaint> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();
                if(StringUtils.isNotBlank(aolname)) {
                    list.add(criteriaBuilder.like(root.get("user").get("name").as(String.class),"%" + aolname + "%"));
                }
                if(StringUtils.isNotBlank(doctorname)) {
                    list.add(criteriaBuilder.like(root.get("doctor").get("name").as(String.class),"%" + doctorname + "%"));
                }
                return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
            }
        };
        return dao.findAll(spec,new PageRequest(pagenum - 1,pagesize, Sort.Direction.DESC,"id"));
    }
}
