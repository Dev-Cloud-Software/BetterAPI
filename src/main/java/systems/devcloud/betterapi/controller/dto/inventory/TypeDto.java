/*******************************************************************************
 * Copyright (c) 2023 DevCloud Software. All Rights reserved.
 ******************************************************************************/

package systems.devcloud.betterapi.controller.dto.inventory;

import com.google.gson.JsonObject;
import lombok.Data;
import org.bukkit.event.inventory.InventoryType;

@Data
public class TypeDto {
    private String name;
    private int defaultSize;
    private boolean isCreatable;

    public TypeDto(InventoryType inventoryType) {
        this.defaultSize = inventoryType.getDefaultSize();
        this.name = inventoryType.name();
        this.isCreatable = inventoryType.isCreatable();
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", name);
        jsonObject.addProperty("defaultSize", defaultSize);
        jsonObject.addProperty("isCreatable", isCreatable);
        return jsonObject;
    }
}
