package org.allaymc.terra.allay.handle;

import org.allaymc.api.registry.Registries;
import org.allaymc.api.utils.Identifier;
import org.allaymc.terra.allay.Mapping;
import org.allaymc.terra.allay.delegate.AllayEnchantment;
import org.allaymc.terra.allay.delegate.AllayItemType;

import java.util.Set;
import java.util.stream.Collectors;

import com.dfsek.terra.api.handle.ItemHandle;
import com.dfsek.terra.api.inventory.Item;
import com.dfsek.terra.api.inventory.item.Enchantment;


/**
 * Terra Project 2024/6/16
 *
 * @author daoge_cmd
 */
public class AllayItemHandle implements ItemHandle {
    @Override
    public Item createItem(String data) {
        return new AllayItemType(Registries.ITEMS.get(new Identifier(Mapping.itemIdJeToBe(data))), Mapping.jeItemIdToBeItemMeta(data));
    }

    @Override
    public Enchantment getEnchantment(String id) {
        return new AllayEnchantment(Registries.ENCHANTMENTS.getByK2(new Identifier(Mapping.enchantmentIdJeToBe(id))));
    }

    @Override
    public Set<Enchantment> getEnchantments() {
        return Registries.ENCHANTMENTS.getContent().m1().values().stream()
            .map(AllayEnchantment::new)
            .collect(Collectors.toSet());
    }
}
