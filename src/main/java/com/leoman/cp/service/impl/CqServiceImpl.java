package com.leoman.cp.service.impl;

import com.leoman.common.service.impl.GenericManagerImpl;
import com.leoman.cp.dao.CqDao;
import com.leoman.cp.entity.Cq;
import com.leoman.cp.service.CqService;
import com.leoman.question.entity.vo.Question;
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
public class CqServiceImpl extends GenericManagerImpl<Cq,CqDao> implements CqService{

    @Autowired
    private CqDao dao;

    @Override
    public Page<Cq> findPage(final Cq cq, int pagenum, int pagesize) {
        Specification<Cq> spec = new Specification<Cq>() {
            @Override
            public Predicate toPredicate(Root<Cq> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();
                if(StringUtils.isNotBlank(cq.getQuestion())) {
                    list.add(criteriaBuilder.like(root.get("question").as(String.class),"%" + cq.getQuestion() + "%"));
                }
                if(StringUtils.isNotBlank(cq.getAnswer())) {
                    list.add(criteriaBuilder.like(root.get("answer").as(String.class),"%" + cq.getAnswer() + "%"));
                }
                return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
            }
        };
        return dao.findAll(spec,new PageRequest(pagenum - 1,pagesize, Sort.Direction.DESC,"id"));
    }
}
