/*******************************************************************************
 * Copyright (c) 2023 DevCloud Software. All Rights reserved.
 ******************************************************************************/

package systems.devcloud.betterapi.controller;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.Router;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.java.Log;

import static systems.devcloud.betterapi.BetterAPI.localizer;

@Log(topic = "BetterAPI")
public class RestController {
    public RestController() {
        controllers = new ArrayList<>();
        vertx = Vertx.vertx();
        router = Router.router(vertx);
    }

    private final List<IController> controllers;
    private final Vertx vertx;
    private final Router router;

    private void registerControllers() {
        controllers.add(new PlayerController());
        controllers.add(new WorldController());
        controllers.add(new ServerController());
    }

    private void createRoutes() {
        registerControllers();
        for (IController controller : controllers) {
            controller.createRoutes(router);
            log.info(String.format(localizer.get("plugin.load.controller"),controller.getClass().getName()));
        }
    }

    public void startServer(int port) {
        createRoutes();
        log.info(String.format(localizer.get("plugin.start.api"), port)); // todo implement localisation
        HttpServer server =
                vertx.createHttpServer(new HttpServerOptions().setPort(port)).requestHandler(router);
        server.listen();
        log.info(localizer.get("plugin.started.api.successfully"));
    }
}
