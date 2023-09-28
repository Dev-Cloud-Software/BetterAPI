/*******************************************************************************
 * Copyright (c) 2023 DevCloud Software. All Rights reserved.
 ******************************************************************************/

package systems.devcloud.betterapi.controller.dto.client;

import com.destroystokyo.paper.ClientOption;
import com.google.gson.JsonObject;
import lombok.Data;
import org.bukkit.entity.Player;

@Data
public class ClientOptionDto {
    private String language;
    private String chatVisibility;
    private boolean charColorsEnabled;
    private boolean enabledChatFilter;

    public ClientOptionDto(Player player) {
        this.language = player.getClientOption(ClientOption.LOCALE);
        this.chatVisibility =
                player.getClientOption(ClientOption.CHAT_VISIBILITY).toString();
        this.charColorsEnabled = player.getClientOption(ClientOption.CHAT_COLORS_ENABLED);
        this.enabledChatFilter = player.getClientOption(ClientOption.TEXT_FILTERING_ENABLED);
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("language", this.language);
        jsonObject.addProperty("chatVisibility", this.chatVisibility);
        jsonObject.addProperty("charColorsEnabled", this.charColorsEnabled);
        jsonObject.addProperty("enabledChatFilter", this.enabledChatFilter);
        return jsonObject;
    }
}
