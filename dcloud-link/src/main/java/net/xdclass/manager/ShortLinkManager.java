package net.xdclass.manager;

import net.xdclass.model.ShortLinkDO;

public interface ShortLinkManager {

    /**
     * 新增
     * @param shortLinkDO
     * @return
     */
    int addShortLink(ShortLinkDO shortLinkDO);


    /**
     * 根据短链码找短链
     * @param shortLinkCode
     * @return
     */
    ShortLinkDO findByShortLinCode(String shortLinkCode);


    /**
     * 删除
     * @param shortLinkDO
     * @return
     */
    int del(ShortLinkDO shortLinkDO);

    /**
     * 更新
     * @param shortLinkDO
     * @return
     */
    int update(ShortLinkDO shortLinkDO);
}
