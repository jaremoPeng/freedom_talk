package com.jaremo.freedom_talk.customer.service;

import com.jaremo.freedom_talk.customer.domain.Collect;

import java.util.List;

/**
 * @描述: 收藏类的service层
 * @Author: pyj
 * @DateTime: 2018/11/8 0008--下午 1:21
 */
public interface CollectService {

    /**
     * 功能描述 添加收藏
     * @author pyj
     * @date 2018/11/8 0008
     * @param collect
     * @return int 1 成功添加 , -1 已经收藏过 , -2 其他错误
     */
    int insertCollect(Collect collect);

    /**
     * 功能描述 删除收藏
     * @author pyj
     * @date 2018/11/8 0008
     * @param collect
     * @return boolean
     */
    boolean deleteCollect(Collect collect);

    /**
     * 功能描述 根据条件查询收藏类
     * @author pyj
     * @date 2018/11/8 0008
     * @param collect
     * @return java.util.List<com.jaremo.freedom_talk.customer.domain.Collect>
     */
    List<Collect> selectAllByCondition(Collect collect);
}
