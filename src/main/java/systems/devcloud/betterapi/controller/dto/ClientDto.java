/*******************************************************************************
 * Copyright (c) 2023 DevCloud Software. All Rights reserved.
 ******************************************************************************/

package systems.devcloud.betterapi.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bukkit.entity.Player;

@Data
@AllArgsConstructor
public class ClientDto {
    private String clientBrandName;
    private int viewDistance;
    private ClientOptionDto clientOptions;

    public ClientDto(Player player) {
        this.clientBrandName = player.getClientBrandName();
        this.viewDistance = player.getViewDistance();
        this.clientOptions = new ClientOptionDto(player);
    }
}
