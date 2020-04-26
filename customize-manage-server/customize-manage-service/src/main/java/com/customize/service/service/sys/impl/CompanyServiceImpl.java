package com.customize.service.service.sys.impl;

import com.customize.common.constants.OptionEnum;
import com.customize.domain.dto.sys.CompanyDto;
import com.customize.domain.entity.sys.Company;
import com.customize.domain.vo.sys.CompanyVo;
import com.customize.mybatis.mapper.sys.CompanyMapper;
import com.customize.service.core.BaseServiceImpl;
import com.customize.service.service.sys.ICompanyService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层实现
 * 公司表 sys_company
 *
 * @author qiukai
 * @date 2020-04-25
 */
@Slf4j
@Service
public class CompanyServiceImpl extends BaseServiceImpl<Company, String> implements ICompanyService {

    private final CompanyMapper companyMapper;

    @Autowired
    public CompanyServiceImpl(CompanyMapper companyMapper) {
        super(companyMapper);
        this.companyMapper = companyMapper;
    }

    @Override
    public Page<CompanyDto> queryCompanyPage(CompanyVo companyVo) {
        return PageHelper.startPage(companyVo.getPageNum(), companyVo.getPageSize()).doSelectPage(() -> companyMapper.queryCompanyList(companyVo));
    }

    @Override
    public List<CompanyDto> queryCompanyList(CompanyVo companyVo) {
        return companyMapper.queryCompanyList(companyVo);
    }

    @Override
    public List<CompanyDto> selectCompanyList() {
        return companyMapper.selectCompanyList(OptionEnum.YES.getVal());
    }

    @Override
    public CompanyDto findById(String pkCompanyId) {
        return companyMapper.findById(pkCompanyId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeByPrimaryKey(String pkCompanyId) {
        return companyMapper.removeByPrimaryKey(pkCompanyId, OptionEnum.YES.getVal());
    }

    @Override
    public int removeCompanyBatch(String[] pkCompanyIds) {
        return companyMapper.removeCompanyBatch(pkCompanyIds, OptionEnum.YES.getVal());
    }

    @Override
    public int deleteCompanyBatch(String[] pkCompanyIds) {
        return companyMapper.deleteCompanyBatch(pkCompanyIds);
    }
}
