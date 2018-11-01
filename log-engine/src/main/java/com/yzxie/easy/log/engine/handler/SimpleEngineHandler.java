package com.yzxie.easy.log.engine.handler;

import com.yzxie.easy.log.storage.LogStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xieyizun
 * @date 29/10/2018 00:11
 * @description:
 */
public class SimpleEngineHandler extends AbstractEngineHandler {
    private static final Logger LOG = LoggerFactory.getLogger(SimpleEngineHandler.class);

    public SimpleEngineHandler(String topicName) {
        super(topicName);
    }

    /**
     * analyze log content
     * @param content
     */
    @Override
    public void process(String content) {

        /**
         * 将处理结果存储到Redis
         */
        LogStorageService.dispatch(getTopicName(), content);
        LOG.info("simple analyze: {} successfully.", content);
    }
}