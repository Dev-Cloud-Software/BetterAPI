/*******************************************************************************
 * Copyright (c) 2023 DevCloud Software. All Rights reserved.
 ******************************************************************************/

package systems.devcloud.betterapi.controller.dto.inventory;

import com.google.gson.JsonObject;
import lombok.Data;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import systems.devcloud.betterapi.controller.dto.item.ItemStackDto;

@Data
public class InventoryDto {
    private int size;
    private boolean hasLocation;
    private ItemStackDto[] contents;
    private TypeDto type;

    public InventoryDto(Inventory inventory) {
        this.size = inventory.getSize();
        this.contents = convertContents(inventory.getContents());
        this.type = new TypeDto(inventory.getType());
    }

    private ItemStackDto[] convertContents(ItemStack[] itemStacks) {
        ItemStackDto[] itemStackDtos = new ItemStackDto[itemStacks.length];
        for (int i = 0; i < itemStacks.length; i++) {
            itemStackDtos[i] = new ItemStackDto(itemStacks[i]);
        }
        return itemStackDtos;
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("size", size);
        jsonObject.addProperty("hasLocation", hasLocation);
        JsonObject contentsObject = new JsonObject();
        for (int i = 0; i < contents.length; i++) {
            contentsObject.add(String.valueOf(i), contents[i].toJson());
        }
        jsonObject.add("type", type.toJson());
        return jsonObject;
    }
}
