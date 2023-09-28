/*******************************************************************************
 * Copyright (c) 2023 DevCloud Software. All Rights reserved.
 ******************************************************************************/

package systems.devcloud.betterapi.controller.dto.item;

import com.google.gson.JsonObject;
import java.util.Set;
import lombok.Data;
import org.bukkit.inventory.ItemFlag;

@Data
public class ItemFlagsDto {
    private boolean hideItemSpecifics;
    private boolean hideDestroys;
    private boolean hideArmorTrims;
    private boolean hideDye;
    private boolean hideEnchants;
    private boolean hidePlacedOn;
    private boolean hideUnbreakable;

    public ItemFlagsDto(Set<ItemFlag> flags) {
        this.hideItemSpecifics = flags.contains(ItemFlag.HIDE_ATTRIBUTES);
        this.hideDestroys = flags.contains(ItemFlag.HIDE_DESTROYS);
        this.hideArmorTrims = flags.contains(ItemFlag.HIDE_PLACED_ON);
        this.hideDye = flags.contains(ItemFlag.HIDE_DYE);
        this.hideEnchants = flags.contains(ItemFlag.HIDE_ENCHANTS);
        this.hidePlacedOn = flags.contains(ItemFlag.HIDE_PLACED_ON);
        this.hideUnbreakable = flags.contains(ItemFlag.HIDE_UNBREAKABLE);
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("hideItemSpecifics", hideItemSpecifics);
        jsonObject.addProperty("hideDestroys", hideDestroys);
        jsonObject.addProperty("hideArmorTrims", hideArmorTrims);
        jsonObject.addProperty("hideDye", hideDye);
        jsonObject.addProperty("hideEnchants", hideEnchants);
        jsonObject.addProperty("hidePlacedOn", hidePlacedOn);
        jsonObject.addProperty("hideUnbreakable", hideUnbreakable);
        return jsonObject;
    }
}
