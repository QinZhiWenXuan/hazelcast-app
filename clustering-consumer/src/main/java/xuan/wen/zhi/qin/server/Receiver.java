package xuan.wen.zhi.qin.server;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;

public class Receiver extends AbstractVerticle {
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
        bus.consumer("news-feed", message -> System.out.println("Received news on consumer 1: " + message.body()));
        bus.consumer("news-feed", message -> System.out.println("Received news on consumer 2: " + message.body()));
        bus.consumer("news-feed", message -> System.out.println("Received news on consumer 3: " + message.body()));
        System.out.println("Ready!");
    }
}
