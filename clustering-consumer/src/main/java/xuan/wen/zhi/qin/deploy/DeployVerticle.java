package xuan.wen.zhi.qin.deploy;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.spi.cluster.hazelcast.HazelcastClusterManager;

public class DeployVerticle {
    public static void main(String[] args) {
        VertxOptions options = new VertxOptions().setClusterManager(new HazelcastClusterManager()).setClustered(true);
        Vertx.clusteredVertx(options, fn -> {
            if (fn.succeeded()) {
                fn.result().deployVerticle("xuan.wen.zhi.qin.server.Receiver", event -> {
                    if (event.succeeded()) {
                        System.out.println("deploy succeeded");
                    } else {
                        event.cause().printStackTrace();
                    }
                });
            } else {
                fn.cause().printStackTrace();
            }
        });
    }
}
