/*******************************************************************************
 * Copyright (c) 2023 DevCloud Software. All Rights reserved.
 ******************************************************************************/

package systems.devcloud.betterapi.controller;

import io.vertx.ext.web.Router;

public interface IController {
    void createRoutes(Router router);
}
