package net.xdclass.mapper;

import net.xdclass.model.TrafficDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 二当家小D
 * @since 2021-11-09
 */
public interface TrafficMapper extends BaseMapper<TrafficDO> {


    /**
     * 给某个流量包增加天使用次数
     * @param accountNo
     * @param trafficId
     * @param usedTimes
     * @return
     */
    int addDayUsedTimes(@Param("accountNo") Long accountNo,@Param("trafficId") Long trafficId,
                        @Param("usedTimes") Integer usedTimes);

    /**
     * 恢复某个流量包使用次数
     * @param accountNo
     * @param trafficId
     * @param usedTimes
     * @return
     */
    int releaseUsedTimes(@Param("accountNo") Long accountNo, @Param("trafficId") Long trafficId,
                         @Param("usedTimes") Integer usedTimes,@Param("useDateStr")String useDateStr);
}
