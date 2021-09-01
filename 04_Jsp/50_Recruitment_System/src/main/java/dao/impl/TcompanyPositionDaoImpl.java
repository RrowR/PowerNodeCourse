package dao.impl;

import dao.BaseDao;
import dao.TcompanyPositionDao;
import entity.TcompanyPosition;
import java.util.List;

public class TcompanyPositionDaoImpl extends BaseDao implements TcompanyPositionDao {

    @Override
    public List<TcompanyPosition> queryAll() {
        String sql = "SELECT * FROM (SELECT pname, cname,minsal,maxsal,loc,releasedate FROM t_company,t_position WHERE t_company.cid = t_position.cid) t WHERE t.pname LIKE %?%";
        Object[] params = {};
        return super.selectList(sql,TcompanyPosition.class,params);
    }
}
