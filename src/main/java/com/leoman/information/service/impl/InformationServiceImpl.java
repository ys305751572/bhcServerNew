package com.leoman.information.service.impl;

import com.leoman.common.service.impl.GenericManagerImpl;
import com.leoman.information.dao.InformationDao;
import com.leoman.information.entity.Information;
import com.leoman.information.service.InformationService;
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
 * Created by Administrator on 2016/5/25.
 */
@Service
public class InformationServiceImpl extends GenericManagerImpl<Information, InformationDao> implements InformationService {

    @Autowired
    private InformationDao dao;

    @Override
    public Page<Information> findPage(final Information info, int pagenum,int pagesize) {

        Specification<Information> spec = new Specification<Information>() {
            @Override
            public Predicate toPredicate(Root<Information> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();
                if (StringUtils.isNotBlank(info.getTitle())) {
                    list.add(criteriaBuilder.like(root.get("title").as(String.class), "%" + info.getTitle() + "%"));
                }
                if (StringUtils.isNotBlank(info.getContent())) {
                    list.add(criteriaBuilder.like(root.get("content").as(String.class),"%" + info.getContent() + "%"));
                }
                return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
            }
        };
        return dao.findAll(spec,new PageRequest(pagenum - 1,pagesize, Sort.Direction.DESC,"id"));
    }
}
