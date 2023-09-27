/*******************************************************************************
 * Copyright (c) 2023 DevCloud Software. All Rights reserved.
 ******************************************************************************/

package systems.devcloud.betterapi.controller.dto;

import java.net.InetSocketAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.bukkit.entity.Player;

@Data
@AllArgsConstructor
public class PlayerDto {
    private String name;
    private String uuid;
    private boolean isOnline;
    private int ping;
    private InetSocketAddress address;
    private float saturation;
    private int foodLevel;
    private float Experience;
    private int Level;
    private boolean allowFlight;
    private float walkSpeed;
    private float flySpeed;
    private String GameMode;
    private long firstPlayed;
    private long lastLogin;
    private long lastSeen;

    private ClientDto client;
    private LocationDto location;
    // Inventory Dto
    // EnderChest Dto
    private LocationDto compassTargetLocation;
    private LocationDto bedSpawnLocation;

    public PlayerDto(Player player) {
        this.name = player.getName();
        this.uuid = player.getUniqueId().toString();
        this.isOnline = player.isOnline();
        this.ping = player.getPing();
        this.address = player.getAddress();
        this.saturation = player.getSaturation();
        this.foodLevel = player.getFoodLevel();
        this.Experience = player.getExp();
        this.Level = player.getLevel();
        this.allowFlight = player.getAllowFlight();
        this.walkSpeed = player.getWalkSpeed();
        this.flySpeed = player.getFlySpeed();
        this.GameMode = player.getGameMode().toString();
        this.firstPlayed = player.getFirstPlayed();
        this.lastLogin = player.getLastLogin();
        this.lastSeen = player.getLastSeen();
        this.client = new ClientDto(player);
        this.location = new LocationDto(player.getLocation());
        this.compassTargetLocation = new LocationDto(player.getCompassTarget());
        this.bedSpawnLocation = new LocationDto(player.getBedSpawnLocation()); // todo check if null!
    }
}
