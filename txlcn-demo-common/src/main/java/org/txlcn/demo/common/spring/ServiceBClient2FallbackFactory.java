package org.txlcn.demo.common.spring;

import com.codingapi.txlcn.tc.support.DTXUserControls;
import com.codingapi.txlcn.tracing.TracingContext;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author wangwei
 * @since 2019/6/11 16:48
 */
@Component
public class ServiceBClient2FallbackFactory implements FallbackFactory<ServiceBClient> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceBClient2FallbackFactory.class);

    @Override
    public ServiceBClient create(Throwable cause) {
        ServiceBClient2FallbackFactory.LOGGER.info("fallback; reason was: {}", cause.getMessage());
        cause.printStackTrace();
//        DTXUserControls.rollbackGroup(TracingContext.tracing().groupId());

//        return (Long userId) -> new BasicResponse<>(0);
        return (s) -> "fallback";
    }
}
