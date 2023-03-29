package com.bookMall.pojo;

import java.util.List;

public class Page<T> {
    public static final int PAGE_SIZE=4;
    //当前页码数
    private Integer pageNo;
    //总页数
    private Integer pageTotal;
    //总条数
    private Integer dataTotal;
    //当前页数
    private Integer dataSize=PAGE_SIZE;
    //当前页数据集合
    private List<T> dataList;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //分页请求地址
    private String url;

    public Page() {
    }

    public Page(Integer pageNo, Integer pageTotal, Integer dataTotal, Integer dataSize, List<T> dataList, String url) {
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.dataTotal = dataTotal;
        this.dataSize = dataSize;
        this.dataList = dataList;
        this.url = url;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if(pageNo<0){
            pageNo=0;
        }
        if(pageNo>pageTotal){
            pageNo=pageNo;
        }
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getDataTotal() {
        return dataTotal;
    }

    public void setDataTotal(Integer dataTotal) {
        this.dataTotal = dataTotal;
    }

    public Integer getDataSize() {
        return dataSize;
    }

    public void setDataSize(Integer dataNow) {
        this.dataSize = dataNow;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", dataTotal=" + dataTotal +
                ", dataSize=" + dataSize +
                ", dataList=" + dataList +
                ", url='" + url + '\'' +
                '}';
    }
}
