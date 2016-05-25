package com.leoman.novice.service.impl;

import com.leoman.common.service.impl.GenericManagerImpl;
import com.leoman.novice.dao.NoviceDao;
import com.leoman.novice.entity.Novice;
import com.leoman.novice.service.NoviceService;
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
public class NoviceServiceImpl extends GenericManagerImpl<Novice,NoviceDao> implements NoviceService{

    @Autowired
    private NoviceDao dao;

    @Override
    public Page<Novice> findPage(final String content, final int pagenum, int pagesize) {
        Specification<Novice> spec = new Specification<Novice>() {
            @Override
            public Predicate toPredicate(Root<Novice> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();
                if(StringUtils.isNotBlank(content)) {
                    list.add(criteriaBuilder.like(root.get("content").as(String.class),"%" + content + "%"));
                }
                return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
            }
        };
        return dao.findAll(spec,new PageRequest(pagenum - 1,pagesize, Sort.Direction.DESC,"id"));
    }
}
