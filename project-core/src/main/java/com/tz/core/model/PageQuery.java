package com.tz.core.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 分页通用查询条件
 * @author KyrieCao
 * @date 2020/2/3 22:28
 */
@Data
public class PageQuery implements Serializable {

    /* 当前页码 */
    private Integer pageIndex = null;

    /* 页码容量 */
    private Integer pageSize = 10;

    // 排序
    private String orderBy;

    public String getOrderBy() {
        if (StringUtils.isBlank(orderBy))
            return null;
        if (this.orderBy.startsWith("#")) {
            return this.orderBy.substring(1);
        }
        return "ORDER BY " + this.orderBy;
    }

    /* 分页语句 */
    public String getPageSql(){
        if(this.getPageIndex() == null) return null;
        return String.format("LIMIT %d, %d", (pageIndex - 1) * pageSize, this.getPageSize());
    }

}
