/*******************************************************************************
 * Copyright (c) 2023 DevCloud Software. All Rights reserved.
 ******************************************************************************/

package systems.devcloud.betterapi.controller.dto;

import com.destroystokyo.paper.ClientOption;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.bukkit.entity.Player;

@Data
@AllArgsConstructor
public class ClientOptionDto {
    private String locale;
    private String chatVisibility;
    private boolean charColorsEnabled;
    private boolean enabledChatFilter;

    public ClientOptionDto(Player player) {
        this.locale = player.getClientOption(ClientOption.LOCALE).toString();
        this.chatVisibility =
                player.getClientOption(ClientOption.CHAT_VISIBILITY).toString();
        this.charColorsEnabled = player.getClientOption(ClientOption.CHAT_COLORS_ENABLED);
        this.enabledChatFilter = player.getClientOption(ClientOption.TEXT_FILTERING_ENABLED);
    }
}
