package com.customize.mybatis.mapper.sys;

import com.customize.domain.dto.sys.CompanyDto;
import com.customize.domain.entity.sys.Company;
import com.customize.domain.vo.sys.CompanyVo;
import com.customize.mybatis.core.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据层接口
 * 公司表 sys_company
 *
 * @author qiukai
 * @date 2020-04-25
 */
public interface CompanyMapper extends BaseMapper<Company> {

    /**
     * 条件查询公司
     */
    List<CompanyDto> queryCompanyList(@Param("companyVo") CompanyVo companyVo);

    /**
     * 查询所有公司
     */
    List<CompanyDto> selectCompanyList(@Param("isDelete") Integer isDelete);

    /**
     * 根据ID查询公司
     */
    CompanyDto findById(@Param("pkCompanyId") String pkCompanyId, Integer isDelete);

    /**
     * 根据ID移除公司（逻辑删除）
     */
    int removeByPrimaryKey(@Param("pkCompanyId") String pkCompanyId, @Param("isDelete") Integer isDelete);

    /**
     * 批量移除公司（逻辑删除）
     */
    int removeCompanyBatch(@Param("pkCompanyIds") String[] pkCompanyIds, @Param("isDelete") Integer isDelete);

    /**
     * 批量删除公司（物理删除）
     */
    int deleteCompanyBatch(@Param("pkCompanyIds") String[] pkCompanyIds);
}
