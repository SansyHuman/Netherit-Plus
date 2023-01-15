package com.sansyhuman.netheriteplus.item

import com.google.common.base.Supplier
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ArmorMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import com.sansyhuman.netheriteplus.item.PURE_NETHERITE_INGOT

enum class ModArmorMaterials(
    private val matName: String,
    private val durabilityMultiplier: Int,
    private val protectionAmounts: IntArray,
    private val enchantability: Int,
    private val equipSound: SoundEvent,
    private val toughness: Float,
    private val knockbackResistance: Float,
    private val repairIngredientSupplier: Supplier<Ingredient>
) : ArmorMaterial {
    PURE_NETHERITE(
        "pure_netherite", 56,
        intArrayOf(4, 9, 12, 4), 25,
        SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
        4.5f, 0.2f,
        { Ingredient.ofItems(PURE_NETHERITE_INGOT) });

    companion object {
        val BASE_DURABILITY: IntArray = intArrayOf(13, 15, 16, 11)
    }

    override fun getDurability(slot: EquipmentSlot?): Int {
        return BASE_DURABILITY[slot!!.entitySlotId] * durabilityMultiplier
    }

    override fun getProtectionAmount(slot: EquipmentSlot?): Int {
        return protectionAmounts[slot!!.entitySlotId]
    }

    override fun getEnchantability(): Int {
        return enchantability
    }

    override fun getEquipSound(): SoundEvent {
        return equipSound
    }

    override fun getRepairIngredient(): Ingredient {
        return repairIngredientSupplier.get()
    }

    override fun getName(): String {
        return matName
    }

    override fun getToughness(): Float {
        return toughness
    }

    override fun getKnockbackResistance(): Float {
        return knockbackResistance
    }
}