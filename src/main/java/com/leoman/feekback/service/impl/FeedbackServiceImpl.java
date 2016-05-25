package com.leoman.feekback.service.impl;

import com.leoman.common.service.impl.GenericManagerImpl;
import com.leoman.feekback.dao.FeedbackDao;
import com.leoman.feekback.entity.FeedBack;
import com.leoman.feekback.service.FeedbackService;
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
public class FeedbackServiceImpl extends GenericManagerImpl<FeedBack, FeedbackDao> implements FeedbackService {

    @Autowired
    private FeedbackDao dao;

    @Override
    public Page<FeedBack> findPage(final String content,final String title, int pagenum, int pagesize) {
        Specification<FeedBack> spec = new Specification<FeedBack>() {
            @Override
            public Predicate toPredicate(Root<FeedBack> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();
                if (StringUtils.isNotBlank(content)) {
                    list.add(criteriaBuilder.like(root.get("content").as(String.class), content));
                }
                if(StringUtils.isNotBlank(title)) {
                    list.add(criteriaBuilder.like(root.get("title").as(String.class),title));
                }
                return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
            }
        };
        return dao.findAll(spec, new PageRequest(pagenum - 1, pagesize, Sort.Direction.DESC, "id"));
    }
}
