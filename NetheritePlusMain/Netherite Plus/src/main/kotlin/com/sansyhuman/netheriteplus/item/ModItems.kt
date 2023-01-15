package com.sansyhuman.netheriteplus.item

import com.sansyhuman.netheriteplus.LOGGER
import com.sansyhuman.netheriteplus.MOD_ID
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.Block
import net.minecraft.item.AxeItem
import net.minecraft.item.BlockItem
import net.minecraft.item.HoeItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemGroups
import net.minecraft.item.Items
import net.minecraft.item.PickaxeItem
import net.minecraft.item.ShovelItem
import net.minecraft.item.SwordItem
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import net.minecraft.util.Rarity

val NETHER_NETHERITE_ORE = registerBlockItem(BlockItem(
        com.sansyhuman.netheriteplus.block.NETHER_NETHERITE_ORE,
        FabricItemSettings().fireproof().rarity(Rarity.RARE)), NETHERITEPLUS_GROUP, ItemGroups.NATURAL
)
val RAW_NETHERITE = registerItem("raw_netherite", Item(FabricItemSettings()
    .fireproof().rarity(Rarity.RARE)), NETHERITEPLUS_GROUP, ItemGroups.INGREDIENTS)
val DIAMOND_STICK = registerItem("diamond_stick", Item(FabricItemSettings()
    .rarity(Rarity.UNCOMMON)), NETHERITEPLUS_GROUP, ItemGroups.INGREDIENTS)
val NETHERITE_CHUNK = registerItem("netherite_chunk", Item(FabricItemSettings()
    .fireproof().rarity(Rarity.RARE)), NETHERITEPLUS_GROUP, ItemGroups.INGREDIENTS)
val PURE_NETHERITE_INGOT = registerItem("pure_netherite_ingot", Item(FabricItemSettings()
    .fireproof().rarity(Rarity.RARE)), NETHERITEPLUS_GROUP, ItemGroups.INGREDIENTS)
val PURE_NETHERITE_SWORD = registerItem("pure_netherite_sword", SwordItem(
    ModToolMaterial.PURE_NETHERITE, 3, -2.4f, FabricItemSettings().fireproof().rarity(Rarity.EPIC)
), NETHERITEPLUS_GROUP, ItemGroups.COMBAT)
val PURE_NETHERITE_SHOVEL = registerItem("pure_netherite_shovel", ShovelItem(
    ModToolMaterial.PURE_NETHERITE, 1.5f, -3.0f, FabricItemSettings().fireproof().rarity(Rarity.EPIC)
), NETHERITEPLUS_GROUP, ItemGroups.TOOLS)
val PURE_NETHERITE_PICKAXE = registerItem("pure_netherite_pickaxe", PickaxeItem(
    ModToolMaterial.PURE_NETHERITE, 1, -2.8f, FabricItemSettings().fireproof().rarity(Rarity.EPIC)
), NETHERITEPLUS_GROUP, ItemGroups.TOOLS)
val PURE_NETHERITE_AXE = registerItem("pure_netherite_axe", AxeItem(
    ModToolMaterial.PURE_NETHERITE, 5.0f, -3.0f, FabricItemSettings().fireproof().rarity(Rarity.EPIC)
), NETHERITEPLUS_GROUP, ItemGroups.TOOLS)
val PURE_NETHERITE_HOE = registerItem("pure_netherite_hoe", ModHoeItem(
    ModToolMaterial.PURE_NETHERITE, -6, 0.0f, FabricItemSettings().fireproof().rarity(Rarity.EPIC)
), NETHERITEPLUS_GROUP, ItemGroups.TOOLS)
val PURE_NETHERITE_BLOCK = registerBlockItem(BlockItem(
    com.sansyhuman.netheriteplus.block.PURE_NETHERITE_BLOCK,
    FabricItemSettings().fireproof().rarity(Rarity.RARE)), NETHERITEPLUS_GROUP, ItemGroups.BUILDING_BLOCKS
)

/**
 * Register an item
 *
 * @param id Identifier of the item
 * @param item Item to register
 * @param tabs Item groups the item belongs
 *
 * @return Registered item
 */
private fun registerItem(id: Identifier, item: Item, vararg tabs: ItemGroup): Item {
    for (tab in tabs) {
        ItemGroupEvents.modifyEntriesEvent(tab).register { content ->
            content.add(item)
        }
    }

    return Registry.register(Registries.ITEM, id, item)
}

/**
 * Register an item
 *
 * @param name Name of the item
 * @param item Item to register
 * @param tabs Item groups the item belongs
 *
 * @return Registered item
 */
private fun registerItem(name: String, item: Item, vararg tabs: ItemGroup): Item {
    return registerItem(Identifier(MOD_ID, name), item, *tabs)
}

/**
 * Register an item of the block.
 *
 * @param blockItem Item of the block to register
 * @param tabs Item groups the item belongs
 *
 * @return Registered item
 */
private fun registerBlockItem(blockItem: BlockItem, vararg tabs: ItemGroup): Item {
    val block = blockItem.block
    return registerItem(Registries.BLOCK.getId(block), blockItem, *tabs)
}

internal fun initModItems() {
    LOGGER.info("Initialize items")
}