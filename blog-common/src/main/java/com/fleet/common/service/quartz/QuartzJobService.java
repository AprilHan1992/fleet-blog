package com.fleet.common.service.quartz;

import com.fleet.common.entity.quartz.QuartzJob;
import com.fleet.common.service.BaseService;

/**
 * @author April Han
 */
public interface QuartzJobService extends BaseService<QuartzJob> {

    void run(Long id);

    void pause(Long id);

    void resume(Long id);
}
