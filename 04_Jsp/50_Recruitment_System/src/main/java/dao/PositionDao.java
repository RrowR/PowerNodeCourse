package dao;

import entity.Position;

import java.util.List;

public interface PositionDao {
    /*
        模糊查询和全查询
     */
    List<Position> queryAllPosition(String input);

    /*
        添加
     */
    int addPosition(Position position);

    /*
        删除
     */
    int deletePosition(Integer pid);
}
