/*******************************************************************************
 * Copyright (c) 2023 DevCloud Software. All Rights reserved.
 ******************************************************************************/

package systems.devcloud.betterapi.controller.dto.client;

import com.google.gson.JsonObject;
import lombok.Data;
import org.bukkit.entity.Player;

@Data
public class ClientDto {
    private String clientBrandName;
    private int viewDistance;
    private ClientOptionDto clientOptions;

    public ClientDto(Player player) {
        this.clientBrandName = player.getClientBrandName();
        this.viewDistance = player.getViewDistance();
        this.clientOptions = new ClientOptionDto(player);
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("clientBrandName", this.clientBrandName);
        jsonObject.addProperty("viewDistance", this.viewDistance);
        jsonObject.add("clientOptions", this.clientOptions.toJson());
        return jsonObject;
    }
}
