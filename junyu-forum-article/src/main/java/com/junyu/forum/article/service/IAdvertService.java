package com.junyu.forum.article.service;

import com.junyu.forum.article.req.AdvertREQ;
import com.junyu.forum.entities.Advert;
import com.baomidou.mybatisplus.extension.service.IService;
import com.junyu.forum.util.base.Result;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 广告信息表 服务类
 * </p>
 *
 * @author 梦学谷-www.mengxuegu.com
 */
public interface IAdvertService extends IService<Advert> {

    /**
     * 条件分页查询广告列表
     * @param req
     * @return
     */
    Result queryPage(AdvertREQ req);

    /**
     * 删除广告及图片
     * @param id 广告id
     * @return
     */
    Result deleteById(String id);

    /**
     * 查询指定广告查询的所有广告信息（状态为正常的）
     * @param position
     * @return
     */
    Result findByPosition(int position);
}
