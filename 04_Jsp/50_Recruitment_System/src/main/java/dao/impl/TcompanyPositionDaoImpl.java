package dao.impl;

import dao.BaseDao;
import dao.TcompanyPositionDao;
import entity.TcompanyPosition;
import java.util.List;

public class TcompanyPositionDaoImpl extends BaseDao implements TcompanyPositionDao {

    @Override
    public List<TcompanyPosition> queryAll(String input) {
        // 这里的?需要使用mysql里的concat进行拼接，否则会出现"%""%"的情况
        String sql = "SELECT * FROM (SELECT pname, cname,minsal,maxsal,loc,releasedate FROM t_company,t_position WHERE t_company.cid = t_position.cid) t WHERE t.pname LIKE concat('%',?,'%')";
        Object[] params = {input};
        return super.selectList(sql,TcompanyPosition.class,params);
    }
}
