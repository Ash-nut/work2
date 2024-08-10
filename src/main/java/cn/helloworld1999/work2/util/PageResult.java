package cn.helloworld1999.work2.util;

import java.util.List;

public class PageResult {
    private Integer pageSize;
    private Long total;
    private Integer pageNum;
    private List list;

    @Override
    public String toString() {
        return "PageResult{" +
                "pageSize=" + pageSize +
                ", total=" + total +
                ", pageNum=" + pageNum +
                ", list=" + list +
                '}';
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public PageResult() {
    }

    public PageResult(Integer pageSize, Long total, Integer pageNum, List list) {
        this.pageSize = pageSize;
        this.total = total;
        this.pageNum = pageNum;
        this.list = list;
    }
}
