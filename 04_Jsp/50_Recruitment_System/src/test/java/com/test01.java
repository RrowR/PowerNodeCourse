package com;

import dao.TcompanyPositionDao;
import dao.impl.TcompanyPositionDaoImpl;
import entity.TcompanyPosition;

import java.util.List;

public class test01 {
    public static void main(String[] args) {
        TcompanyPositionDao tcompanyPositionDao = new TcompanyPositionDaoImpl();
        List<TcompanyPosition> tcompanyPositions = tcompanyPositionDao.queryAll("j");
        System.out.println(tcompanyPositions);
    }
}
