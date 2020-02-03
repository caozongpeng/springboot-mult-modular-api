package com.tz.core.model;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


/**
 * 分页封装
 * @author KyrieCao
 * @date 2020/2/3 22:27
 */
@Data
@ToString
public class Page<T> {

    //总数
    private Integer total = 0;

    //目标页
    private Integer pageIndex;

    //一页多少行
    private Integer pageSize = 10;

    //当前的数据
    private List<T> result = new ArrayList<>();

    // 总页码
    public Integer getPageCount(){
        if(this.getTotal() % this.getPageSize() == 0){
            int pc = this.getTotal()/this.getPageSize();
            return pc == 0 ? 1 : pc;
        }
        return this.getTotal()/this.getPageSize() + 1;
    }

    // 获取数据开始索引
    public Integer getStartIndex(){
        if(this.getPageIndex() != null){
            return (this.getPageIndex() - 1) * pageSize;
        }
        return 0;
    }

}
