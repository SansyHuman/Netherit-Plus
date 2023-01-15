package com.sansyhuman.netheriteplus.item

import com.sansyhuman.netheriteplus.LOGGER
import com.sansyhuman.netheriteplus.MOD_ID
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.Identifier

val NETHERITEPLUS_GROUP = FabricItemGroup.builder(Identifier(MOD_ID, "netheriteplus"))
    .icon { ItemStack(Items.NETHERITE_INGOT) }
    .build()

internal fun initModItemGroups() {
    LOGGER.info("Initialize item groups")
}