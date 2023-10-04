/*******************************************************************************
 * Copyright (c) 2023 DevCloud Software. All Rights reserved.
 ******************************************************************************/

package systems.devcloud.betterapi.controller;

import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import systems.devcloud.betterapi.controller.dto.PlayerDto;
import systems.devcloud.betterapi.utils.HttpUtils;
import systems.devcloud.betterapi.utils.ResponseTypes;

public class PlayerController implements IController {
    @Override
    public void createRoutes(Router router) {
        router.get("/player/list").handler(this::listPlayers);
        router.get("/player/:uuid").handler(this::getPlayer);
    }

    private void listPlayers(RoutingContext routingContext) {
        HttpServerResponse response = HttpUtils.addResponseHeaders(routingContext.response(), ResponseTypes.JSON);
        JsonArray players = new JsonArray();
        for (OfflinePlayer player : Bukkit.getOfflinePlayers()) {
            JsonObject playerObject = new JsonObject();
            playerObject.put("name", player.getName());
            playerObject.put("uuid", player.getUniqueId().toString());
            playerObject.put("isOnline", player.isOnline());
            players.add(playerObject);
        }
        response.end(players.encodePrettily());
    }

    private void getPlayer(RoutingContext routingContext) {
        HttpServerResponse response = HttpUtils.addResponseHeaders(routingContext.response(), ResponseTypes.JSON);
        String uuid = routingContext.request().getParam("uuid");
        UUID uuidObj = UUID.fromString(uuid);
        Player player = Bukkit.getPlayer(uuidObj);
        if (player == null) {
            response.setStatusCode(404).end();
            return;
        }
        PlayerDto playerDto = new PlayerDto(player);
        response.end(playerDto.toJson().toString());
    }
}
