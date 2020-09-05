package com.RobotLucca.moltenzinc;

import com.RobotLucca.moltenzinc.blocks.MZBlocks;
import com.RobotLucca.moltenzinc.fluids.MZFluids;
import com.RobotLucca.moltenzinc.items.MZItems;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MoltenZinc.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MoltenZinc
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "moltenzinc";

    public MoltenZinc() {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> e){
        IForgeRegistry<Block> registry = e.getRegistry();
        MZFluids.init();
        for(Block block : MZBlocks.toRegister){
            registry.register(block);
            LOGGER.debug("Added block " + block.getRegistryName());
        }
        MZBlocks.toRegister.clear();
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> e){
        IForgeRegistry<Item> registry = e.getRegistry();
        for(Item item : MZItems.toRegister){
            registry.register(item);
            LOGGER.debug("Added item " + item.getRegistryName());
        }
        MZItems.toRegister.clear();
    }

    @SubscribeEvent
    public static void registerFluids(RegistryEvent.Register<Fluid> e){
        IForgeRegistry<Fluid> registry = e.getRegistry();
        for(Fluid f : MZFluids.toRegister){
            registry.register(f);
            LOGGER.debug("Added fluid " + f.getRegistryName());
        }
        MZFluids.toRegister.clear();
    }
}
