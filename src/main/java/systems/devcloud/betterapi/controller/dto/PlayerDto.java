/*******************************************************************************
 * Copyright (c) 2023 DevCloud Software. All Rights reserved.
 ******************************************************************************/

package systems.devcloud.betterapi.controller.dto;

import com.google.gson.JsonObject;
import lombok.Data;
import org.bukkit.entity.Player;
import systems.devcloud.betterapi.controller.dto.client.ClientDto;
import systems.devcloud.betterapi.controller.dto.inventory.InventoryDto;

@Data
public class PlayerDto {
    private String name;
    private String uuid;
    private boolean isOnline;
    private int ping;
    private String address;
    private float saturation;
    private int foodLevel;
    private float experience;
    private int level;
    private boolean allowFlight;
    private float walkSpeed;
    private float flySpeed;
    private String gamemode;
    private long firstPlayed;
    private long lastLogin;
    private long lastSeen;
    private ClientDto client;
    private LocationDto location;
    private LocationDto bedSpawnLocation;
    private LocationDto compassTargetLocation;
    private InventoryDto inventory;
    private InventoryDto enderChest;

    public PlayerDto(Player player) {
        this.name = player.getName();
        this.uuid = player.getUniqueId().toString();
        this.isOnline = player.isOnline();
        this.ping = player.getPing();
        if (player.getAddress() != null)
            this.address = player.getAddress().getAddress().toString();
        this.saturation = player.getSaturation();
        this.foodLevel = player.getFoodLevel();
        this.experience = player.getExp();
        this.level = player.getLevel();
        this.allowFlight = player.getAllowFlight();
        this.walkSpeed = player.getWalkSpeed();
        this.flySpeed = player.getFlySpeed();
        this.gamemode = player.getGameMode().toString();
        this.firstPlayed = player.getFirstPlayed();
        this.lastLogin = player.getLastLogin();
        this.lastSeen = player.getLastSeen();
        this.client = new ClientDto(player);
        this.location = new LocationDto(player.getLocation());
        if (player.getBedSpawnLocation() != null) this.bedSpawnLocation = new LocationDto(player.getBedSpawnLocation());
        this.compassTargetLocation = new LocationDto(player.getCompassTarget());
        this.inventory = new InventoryDto(player.getInventory());
        this.enderChest = new InventoryDto(player.getEnderChest());
    }

    public JsonObject toJson() {
        JsonObject playerObject = new JsonObject();
        playerObject.addProperty("name", this.name);
        playerObject.addProperty("uuid", this.uuid);
        playerObject.addProperty("isOnline", this.isOnline);
        playerObject.addProperty("ping", this.ping);
        playerObject.addProperty("address", this.address);
        playerObject.addProperty("saturation", this.saturation);
        playerObject.addProperty("foodLevel", this.foodLevel);
        playerObject.addProperty("experience", this.experience);
        playerObject.addProperty("level", this.level);
        playerObject.addProperty("allowFlight", this.allowFlight);
        playerObject.addProperty("walkSpeed", this.walkSpeed);
        playerObject.addProperty("flySpeed", this.flySpeed);
        playerObject.addProperty("gamemode", this.gamemode);
        playerObject.addProperty("firstPlayed", this.firstPlayed);
        playerObject.addProperty("lastLogin", this.lastLogin);
        playerObject.addProperty("lastSeen", this.lastSeen);
        playerObject.add("client", this.client.toJson());
        playerObject.add("location", this.location.toJson());
        if (this.bedSpawnLocation != null) playerObject.add("bedSpawnLocation", this.bedSpawnLocation.toJson());
        playerObject.add("compassTargetLocation", this.compassTargetLocation.toJson());
        playerObject.add("inventory", this.inventory.toJson());
        playerObject.add("enderChest", this.enderChest.toJson());
        return playerObject;
    }
}
