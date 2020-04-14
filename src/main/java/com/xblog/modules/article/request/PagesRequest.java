package com.xblog.modules.article.request;


import java.io.Serializable;

public class PagesRequest  implements Serializable {



    private String name;

    private String sort;

    /**
     * 每页显示大小
     */
    private long  pageSize;

    /**
     * 当前页码
     */
    private  long pageNumber;

    /**
     * 最大页数
     */
    private  long maxCurrent;

    /**
     * 数据总条数
     */
    private  long total;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public long getMaxCurrent() {
        return maxCurrent;
    }

    public void setMaxCurrent(long maxCurrent) {
        this.maxCurrent = maxCurrent;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        if(pageSize != 0){
            if(total % pageSize != 0){
                maxCurrent = total / pageSize + 1;
            }else {
                maxCurrent = total / pageSize;
            }
        }
    }

    public PagesRequest() {

    }

    public PagesRequest(long size, long pageNumber, long total) {
        this.pageSize = size;
        this.pageNumber = pageNumber;
        this.total = total;
        setTotal(total);
    }
}