package com.tz.core.model;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value = "当前页码", required = true)
    private Integer pageIndex = null;

    /* 页码容量 */
    @ApiModelProperty(value = "页码容量", required = true)
    private Integer pageSize = 10;

    // 排序
    @ApiModelProperty(hidden = true)
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
    @ApiModelProperty(hidden = true)
    public String getPageSql(){
        if(this.getPageIndex() == null) return null;
        return String.format("LIMIT %d, %d", (pageIndex - 1) * pageSize, this.getPageSize());
    }

}
