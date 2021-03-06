package com.leoman.common.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IBaseJpaRepository<T> extends JpaRepository<T,Serializable>,JpaSpecificationExecutor<T>{

}
