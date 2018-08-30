package com.clps.oas.util.paging;

/**
 * 
 * @ClassName: PagingVO  
 * @Description: 分页信息 pojo类  
 * @author weigion.wu
 * @date  2018-05-30 09:33:05
 */
public class PagingVO {

    private int currentPage = 1;		//当前页码,默认第一页
    
    private int totalCountPage;			//总页数
    
    private int pageSize=10;			//页面容量
    
    private int upPage;					//上一页
   
    private int nextPage;				//下一页
    
    private int toPage = 0;				//要前往的页码,默认0

    /**
     * 
     * @Title: setToPage  
     * @Description: 设置前往的页码  
     * @param @param toPage  
     * @return void 
     * @throws
     */
    public void setToPage(Integer toPage) {
        //新一页
        this.toPage = (toPage-1) * pageSize ;
        //设置跳转后当前的页码
        setCurrentPage(toPage);
    }

    /**
     * 
     * @Title: getToPage  
     * @Description: 获取前往的页码    
     * @param @return  
     * @return Integer   
     * @throws
     */
    public Integer getToPage() {
        return toPage;
    }

    /**
     * 
     * @Title: getCurrentPage  
     * @Description: 获取当前页  
     * @param @return  
     * @return int 
     * @throws
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * 
     * @Title: setCurrentPage  
     * @Description: 设置当前页码  
     * @param @param currentPage 
     * @return void  
     * @throws
     */
    public void setCurrentPage(int currentPage) {
        if (currentPage != 1) {
            this.upPage = currentPage - 1;
        }
        this.nextPage = currentPage + 1;

        this.currentPage = currentPage;
    }

    /**
     * 
     * @Title: getTotalCountPage  
     * @Description: 获取总页数
     * @param @return  
     * @return int   
     * @throws
     */
    public int getTotalCountPage() {
        return totalCountPage;
    }

    /**
     * 
     * @Title: setTotalCountPage  
     * @Description: 设置总页数  
     * @param @param totalCountPage 
     * @return void  
     * @throws
     */
    public void setTotalCountPage(int totalCountPage) {
        if (totalCountPage%pageSize > 0) {
            this.totalCountPage = (totalCountPage/pageSize)+1;
        } else {
            this.totalCountPage = totalCountPage/pageSize;
        }

    }

    /**
     * 
     * @Title: getPageSize  
     * @Description: 获取页面容量 
     * @param @return 
     * @return int 
     * @throws
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 
     * @Title: setPageSize  
     * @Description: 设置页面容量
     * @param @param pageSize 
     * @return void
     * @throws
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 
     * @Title: getUpPage  
     * @Description: 获取上一页
     * @param @return  
     * @return int  
     * @throws
     */
    public int getUpPage() {
        return upPage;
    }

    /**
     * 
     * @Title: setUpPage  
     * @Description: 设置上一页
     * @param @param upPage
     * @return void 
     * @throws
     */
    public void setUpPage(int upPage) {
        this.upPage = upPage;
    }

    /**
     * 
     * @Title: getNextPage  
     * @Description: 获取下一页  
     * @param @return 
     * @return int  
     * @throws
     */
    public int getNextPage() {
        return nextPage;
    }

    /**
     * 
     * @Title: setNextPage  
     * @Description: 设置下一页 
     * @param @param nextPage 
     * @return void
     * @throws
     */
    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
}
