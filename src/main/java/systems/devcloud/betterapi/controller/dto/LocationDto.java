/*******************************************************************************
 * Copyright (c) 2023 DevCloud Software. All Rights reserved.
 ******************************************************************************/

package systems.devcloud.betterapi.controller.dto;

import lombok.Data;
import org.bukkit.Location;

@Data
public class LocationDto {
    private int coordinateX;
    private int coordinateY;
    private int coordinateZ;
    private String worldName;
    private float yaw;
    private float pitch;

    public LocationDto(Location location) {
        this.coordinateX = location.getBlockX();
        this.coordinateY = location.getBlockY();
        this.coordinateZ = location.getBlockZ();
        this.worldName = location.getWorld().getName();
        this.yaw = location.getYaw();
        this.pitch = location.getPitch();
    }
}
