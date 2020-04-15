package com.xblog.modules.category.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author xsy
 * @since 2020-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("me_category")
public class Category implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty("分类ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 图片
     */
    @ApiModelProperty("分类配图地址")
    private String avatar;

    /**
     * 分类名
     */
    @ApiModelProperty("分类名")
    private String categoryName;

    /**
     * 描述
     */
    @ApiModelProperty("分类描述")
    private String description;

    @ApiModelProperty("创建时间")
    private Date createdDate;

    @ApiModelProperty("删除标记")
    private Boolean deleted;


}
