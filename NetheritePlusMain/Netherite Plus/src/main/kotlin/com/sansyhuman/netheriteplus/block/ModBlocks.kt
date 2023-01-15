package com.sansyhuman.netheriteplus.block

import com.sansyhuman.netheriteplus.LOGGER
import com.sansyhuman.netheriteplus.MOD_ID
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.ExperienceDroppingBlock
import net.minecraft.block.MapColor
import net.minecraft.block.Material
import net.minecraft.item.Items
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import net.minecraft.util.math.intprovider.UniformIntProvider

val NETHER_NETHERITE_ORE = registerBlock("nether_netherite_ore",
    ExperienceDroppingBlock(
        FabricBlockSettings.of(Material.STONE, MapColor.DARK_RED)
            .strength(20f, 1200f).requiresTool()
            .sounds(BlockSoundGroup.NETHER_ORE),
        UniformIntProvider.create(8, 16)
    ))
val PURE_NETHERITE_BLOCK = registerBlock("pure_netherite_block", Block(FabricBlockSettings
    .of(Material.METAL, MapColor.DEEPSLATE_GRAY)
    .requiresTool().strength(60.0f, 2400.0f).sounds(BlockSoundGroup.NETHERITE)))

/**
 * Register a block
 *
 * @param name Name of the block
 * @param block Block to register
 *
 * @return Registered block
 */
private fun registerBlock(name: String, block: Block) : Block {
    return Registry.register(Registries.BLOCK, Identifier(MOD_ID, name), block)
}

internal fun initModBlocks() {
    LOGGER.info("Initialize blocks")
}