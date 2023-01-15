package com.sansyhuman.netheriteplus

import com.sansyhuman.netheriteplus.block.initModBlocks
import com.sansyhuman.netheriteplus.item.initModItemGroups
import com.sansyhuman.netheriteplus.item.initModItems
import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

const val MOD_ID: String = "netheriteplus"
internal val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)

class NetheritePlus : ModInitializer {
    override fun onInitialize() {
        LOGGER.info("Initializing $MOD_ID")

        initModBlocks()
        initModItemGroups()
        initModItems()
    }
}