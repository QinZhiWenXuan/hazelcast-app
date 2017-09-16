package xuan.wen.zhi.qin.server;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;

public class Sender extends AbstractVerticle {
    /**
     * If your verticle does a simple, synchronous start-up then override this method and put your start-up
     * code in there.
     *
     * @throws Exception
     */
    @Override
    public void start() throws Exception {
        super.start();
        EventBus bus = vertx.eventBus();
        vertx.setPeriodic(1000, v -> {
            bus.publish("news-feed", "Some news!time \t" + System.currentTimeMillis());
        });

    }
}
