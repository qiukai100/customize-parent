package com.customize.activity.service.impl;

import com.customize.activity.service.GroupEntityService;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.GroupQuery;
import org.activiti.engine.impl.GroupQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class GroupEntityServiceImpl implements GroupEntityService {

    @Override
    public Group createNewGroup(String s) {
        return null;
    }

    @Override
    public GroupQuery createNewGroupQuery() {
        return null;
    }

    @Override
    public List<Group> findGroupByQueryCriteria(GroupQueryImpl groupQuery, Page page) {
        return null;
    }

    @Override
    public long findGroupCountByQueryCriteria(GroupQueryImpl groupQuery) {
        return 0;
    }

    @Override
    public List<Group> findGroupsByUser(String s) {
        return null;
    }

    @Override
    public List<Group> findGroupsByNativeQuery(Map<String, Object> map, int i, int i1) {
        return null;
    }

    @Override
    public long findGroupCountByNativeQuery(Map<String, Object> map) {
        return 0;
    }

    @Override
    public boolean isNewGroup(Group group) {
        return false;
    }

    @Override
    public GroupEntity create() {
        return null;
    }

    @Override
    public GroupEntity findById(String s) {
        return null;
    }

    @Override
    public void insert(GroupEntity entity) {

    }

    @Override
    public void insert(GroupEntity entity, boolean b) {

    }

    @Override
    public GroupEntity update(GroupEntity entity) {
        return null;
    }

    @Override
    public GroupEntity update(GroupEntity entity, boolean b) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public void delete(GroupEntity entity) {

    }

    @Override
    public void delete(GroupEntity entity, boolean b) {

    }
}
