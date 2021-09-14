package com.study.demo10.common;


import java.util.ArrayList;
import java.util.List;

/*
    PageInfo需要保存如下信息

    pageNum:    当前页数
    pageSize:   每页个数
    totalCount: 总个数
    totalPage:  总页数
    data:       当前页保存的数据
 */
public class PageInfo<T> {
    private Long pageNum;
    private Long pageSize;
    private Long totalCount;
    private Long totalPage;
    // 这个集合仪器室就先new出来，否则没有对象会报空指针异常
    private List<T> data = new ArrayList<>();

    public PageInfo() {
    }

    // 在构建PageInfo的时候只需要传入页码数和每页显示数量即可
    public PageInfo(Long pageNum, Long pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public Long getPageNum() {
        return pageNum;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setPageNum(Long pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalCount(Long totalCount) {
        // 传入获取到的总个数
        this.totalCount = totalCount;
        // 执行这个方法执行总页数
        this.totalPage = ((long) Math.ceil((totalCount * 1.0 / pageSize)));
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalPage() {
        // 这里查询总页数需要向上取整，取整还需要做处理才行
        return totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
