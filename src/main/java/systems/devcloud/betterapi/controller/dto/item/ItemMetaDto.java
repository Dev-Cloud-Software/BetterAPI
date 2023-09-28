/*******************************************************************************
 * Copyright (c) 2023 DevCloud Software. All Rights reserved.
 ******************************************************************************/

package systems.devcloud.betterapi.controller.dto.item;

import com.google.gson.JsonObject;
import java.util.List;
import java.util.Objects;
import lombok.Data;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.meta.ItemMeta;

@Data
public class ItemMetaDto {
    private ItemFlagsDto itemFlagsDto;
    private boolean hasCustomModelData;
    private int customModelData;
    private boolean hasEnchants;
    private boolean hasLore;
    private List<String> lore;
    private boolean hasDisplayName;
    private String displayName;
    private boolean isUnbreakable;

    public ItemMetaDto(ItemMeta itemMeta) {
        this.itemFlagsDto = new ItemFlagsDto(itemMeta.getItemFlags());
        this.customModelData = itemMeta.getCustomModelData();
        this.hasEnchants = itemMeta.hasEnchants();
        this.hasLore = itemMeta.hasLore();
        this.hasCustomModelData = itemMeta.hasCustomModelData();
        if (hasLore) {
            for (Component component : Objects.requireNonNull(itemMeta.lore())) {
                this.lore.add(component.toString());
            }
        }
        this.hasDisplayName = itemMeta.hasDisplayName();
        if (hasDisplayName) {
            this.displayName = Objects.requireNonNull(itemMeta.displayName()).toString();
        }
        this.isUnbreakable = itemMeta.isUnbreakable();
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("itemFlagsDto", itemFlagsDto.toJson());
        jsonObject.addProperty("hasCustomModelData", hasCustomModelData);
        jsonObject.addProperty("customModelData", customModelData);
        jsonObject.addProperty("hasEnchants", hasEnchants);
        jsonObject.addProperty("hasLore", hasLore);
        JsonObject loreObject = new JsonObject();
        for (int i = 0; i < lore.size(); i++) {
            loreObject.addProperty(String.valueOf(i), lore.get(i));
        }
        jsonObject.add("lore", loreObject);
        jsonObject.addProperty("hasDisplayName", hasDisplayName);
        jsonObject.addProperty("displayName", displayName);
        jsonObject.addProperty("isUnbreakable", isUnbreakable);
        return jsonObject;
    }
}
