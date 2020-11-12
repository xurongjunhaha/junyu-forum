package com.junyu.forum.article.service;

import com.junyu.forum.article.req.LabelREQ;
import com.junyu.forum.entities.Label;
import com.baomidou.mybatisplus.extension.service.IService;
import com.junyu.forum.util.base.Result;

/**
 * <p>
 * 标签表 服务类
 * </p>
 *
 * @author 梦学谷-www.mengxuegu.com
 */
public interface ILabelService extends IService<Label> {

    /**
     * 条件分页查询标签列表
     * @param req
     * @return
     */
    Result queryPage(LabelREQ req);
}
