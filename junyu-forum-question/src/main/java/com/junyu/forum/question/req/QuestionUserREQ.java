package com.junyu.forum.question.req;

import com.junyu.forum.util.base.BaseRequest;
import com.junyu.forum.entities.Question;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 关于查询个人问题的请求类
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "QuestionUserREQ对象", description = "获取指定用户问题的查询条件")
public class QuestionUserREQ extends BaseRequest<Question> {

    @ApiModelProperty(value = "用户ID")
    private String userId;

}
