package com.happycode.eduservice.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * è®²å¸ˆ
 * </p>
 *
 * @author ljl
 * @since 2020-10-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EduTeacher对象", description="è®²å¸ˆ")
public class EduTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "è®²å¸ˆID")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private String id;

    @ApiModelProperty(value = "è®²å¸ˆå§“å")
    private String name;

    @ApiModelProperty(value = "è®²å¸ˆç®€ä»‹")
    private String intro;

    @ApiModelProperty(value = "è®²å¸ˆèµ„åŽ†,ä¸€å¥è¯è¯´æ˜Žè®²å¸ˆ")
    private String career;

    @ApiModelProperty(value = "å¤´è¡” 1é«˜çº§è®²å¸ˆ 2é¦–å¸­è®²å¸ˆ")
    private Integer level;

    @ApiModelProperty(value = "è®²å¸ˆå¤´åƒ")
    private String avatar;

    @ApiModelProperty(value = "æŽ’åº")
    private Integer sort;

    @ApiModelProperty(value = "é€»è¾‘åˆ é™¤ 1ï¼ˆtrueï¼‰å·²åˆ é™¤ï¼Œ 0ï¼ˆfalseï¼‰æœªåˆ é™¤")
    @TableLogic
    private Boolean isDeleted;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "åˆ›å»ºæ—¶é—´")
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "æ›´æ–°æ—¶é—´")
    private Date gmtModified;


}
