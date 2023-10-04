/*******************************************************************************
 * Copyright (c) 2023 DevCloud Software. All Rights reserved.
 ******************************************************************************/

package systems.devcloud.betterapi.utils;

import io.vertx.core.http.HttpServerResponse;

public class HttpUtils {
    private HttpUtils() {/*Hide Constructor*/}
    public static HttpServerResponse addResponseHeaders(HttpServerResponse response, ResponseTypes type) {
        response.putHeader("Content-Type", type.toString());
        response.putHeader("Server", "BetterAPI");
        return response;
    }
}
