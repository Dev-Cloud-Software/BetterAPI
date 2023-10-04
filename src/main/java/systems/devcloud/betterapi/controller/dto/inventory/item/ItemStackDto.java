/*******************************************************************************
 * Copyright (c) 2023 DevCloud Software. All Rights reserved.
 ******************************************************************************/

package systems.devcloud.betterapi.controller.dto.inventory.item;

import com.google.gson.JsonObject;
import java.util.Map;
import lombok.Data;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

@Data
public class ItemStackDto {
    private int amount;
    private Map<String, Integer> enchantments;
    private ItemMetaDto itemMetaDto;
    private String itemRarity;
    private String material;

    public ItemStackDto(ItemStack itemStack) {
        this.amount = itemStack.getAmount();
        convertEnchantments(itemStack.getEnchantments());
        this.itemMetaDto = new ItemMetaDto(itemStack.getItemMeta());
        this.itemRarity = itemStack.getRarity().toString();
        this.material = itemStack.getType().toString();
    }

    private void convertEnchantments(Map<Enchantment, Integer> enchantmentMap) {
        enchantmentMap.forEach(
                (enchantment, integer) -> enchantments.put(enchantment.getKey().getKey(), integer));
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("amount", amount);
        JsonObject enchantmentsObject = new JsonObject();
        enchantments.forEach(enchantmentsObject::addProperty);
        jsonObject.add("itemMetaDto", itemMetaDto.toJson());
        jsonObject.addProperty("itemRarity", itemRarity);
        jsonObject.addProperty("material", material);
        return jsonObject;
    }
}
