package dao.impl;

import dao.BaseDao;
import dao.CompanyDao;
import entity.Company;

import java.util.List;

public class CompanyDaoImpl extends BaseDao implements CompanyDao {

    /*
        查询所有公司
     */
    @Override
    public List<Company> queryAllCompany() {
        String sql = "select * FROM t_company";
        return super.selectList(sql,Company.class,null);
    }
}
