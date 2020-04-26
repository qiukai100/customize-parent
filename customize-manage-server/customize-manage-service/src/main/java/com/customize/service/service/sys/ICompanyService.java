package com.customize.service.service.sys;

import com.customize.domain.dto.sys.CompanyDto;
import com.customize.domain.entity.sys.Company;
import com.customize.domain.vo.sys.CompanyVo;
import com.customize.service.core.BaseService;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * 业务层接口
 * 公司表 sys_company
 *
 * @author qiukai
 * @date 2020-04-25
 */
public interface ICompanyService extends BaseService<Company, String> {

    /**
     * 分页条件查询公司
     */
    Page<CompanyDto> queryCompanyPage(CompanyVo companyVo);

    /**
     * 条件查询公司
     */
    List<CompanyDto> queryCompanyList(CompanyVo companyVo);

    /**
     * 查询所有公司
     */
    List<CompanyDto> selectCompanyList();

    /**
     * 根据ID查询公司
     */
	CompanyDto findById(String pkCompanyId);

    /**
     * 根据ID移除公司（逻辑删除）
     */
    int removeByPrimaryKey(String pkCompanyId);

    /**
     * 批量移除公司（逻辑删除）
     */
    int removeCompanyBatch(String[] pkCompanyIds);

    /**
     * 批量删除公司（物理删除）
     */
    int deleteCompanyBatch(String[] pkCompanyIds);
}
