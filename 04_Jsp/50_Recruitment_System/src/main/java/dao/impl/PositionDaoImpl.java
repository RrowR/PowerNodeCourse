package dao.impl;

import dao.BaseDao;
import dao.PositionDao;
import entity.Position;

import java.util.List;

public class PositionDaoImpl extends BaseDao implements PositionDao {
    @Override
    public List<Position> queryAllPosition(String input) {
        String sql = "select * FROM (SELECT pid, pname, cname,minsal,maxsal,loc,releasedate FROM t_company,t_position WHERE t_company.cid = t_position.cid) t WHERE t.pname LIKE concat('%',?,'%')";
        Object[] params = {input};
        return selectList(sql,Position.class,params);
    }

    @Override
    public int addPosition(Position position) {
        String sql = "INSERT INTO t_position(pname,minsal,maxsal,releasedate,cid) values (?,?,?,?,?)";
        Object[] params = {position.getPname(),position.getMinsal(),position.getMaxsal(),position.getReleasedate(),position.getCid()};
        return super.executeUpdate(sql,params);
    }

    @Override
    public int deletePosition(Integer pid) {
        String sql = "DELETE FROM t_position WHERE pid = ?";
        Object[] params = {pid};
        return super.executeUpdate(sql,params);
    }
}
