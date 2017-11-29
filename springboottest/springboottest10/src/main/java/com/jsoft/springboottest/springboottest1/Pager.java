package com.jsoft.springboottest.springboottest1;

import java.util.List;

/**
 * Pager Class
 *
 * @author jim
 * @date 2017/11/29
 */
public class Pager<T> {
    private Integer totalCount;
    private Integer currentPage;
    private List<T> datas;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}
