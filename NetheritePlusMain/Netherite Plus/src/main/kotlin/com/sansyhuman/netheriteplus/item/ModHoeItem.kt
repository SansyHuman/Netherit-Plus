package com.sansyhuman.netheriteplus.item

import net.minecraft.item.HoeItem
import net.minecraft.item.Item
import net.minecraft.item.ToolMaterial

/**
 * Hoe item for mod because for some reason the constructor of hoe item is protected.
 */
class ModHoeItem(
    material: ToolMaterial,
    attackDamage: Int,
    attackSpeed: Float,
    settings: Item.Settings
) : HoeItem(material, attackDamage, attackSpeed, settings) {

}
