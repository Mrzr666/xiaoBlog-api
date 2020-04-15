package com.xblog.modules.line.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 
 * </p>
 *
 * @author xsy
 * @since 2020-04-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("me_line")
public class Line implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "时间线ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 内容
     */
    @ApiModelProperty(value = "具体内容")
    @NotNull
    private String context;

    /**
     * 记录时间
     */
    @ApiModelProperty(value = "记录时间")
    @NotNull
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date markTime;

    @ApiModelProperty(value = "创建时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;

    @ApiModelProperty(value = "是否删除")
    private Boolean deleted;


}
