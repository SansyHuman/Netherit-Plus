package com.sansyhuman.netheriteplus.item

import net.fabricmc.yarn.constants.MiningLevels
import net.minecraft.item.Items
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient
import java.util.function.Supplier
import com.sansyhuman.netheriteplus.item.PURE_NETHERITE_INGOT

/**
 * Tool materials of the mod
 */
enum class ModToolMaterial(
    private val miningLevel: Int,
    private val itemDurability: Int,
    private val miningSpeed: Float,
    private val attackDamage: Float,
    private val enchantability: Int,
    private val repairIngredient: Supplier<Ingredient>
) : ToolMaterial {
    /**
     * Pure netherite tools
     */
    PURE_NETHERITE(
        5, 5078, 12.0f, 6.0f, 25,
        { Ingredient.ofItems(PURE_NETHERITE_INGOT) }
    );

    override fun getDurability(): Int {
        return itemDurability
    }

    override fun getMiningSpeedMultiplier(): Float {
        return miningSpeed
    }

    override fun getAttackDamage(): Float {
        return attackDamage
    }

    override fun getMiningLevel(): Int {
        return miningLevel
    }

    override fun getEnchantability(): Int {
        return enchantability
    }

    override fun getRepairIngredient(): Ingredient {
        return repairIngredient.get()
    }

}