package com.xblog.modules.comment.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@TableName("me_comment")
public class Comment implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 文章id
     */
    private Integer articleId;

    /**
     * 作者id
     */
    private Long authorId;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 发送对象id
     */
    private Long toUid;

    /**
     * ？
     */
    private String level;

    /**
     * 创建时间
     */
    private LocalDateTime createdDate;

    /**
     * 删除标记
     */
    private String deleted;


}
