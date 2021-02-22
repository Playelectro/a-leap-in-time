package net.a.leap.in.time;

import net.a.leap.in.time.blocks.ModBlocks;
import net.a.leap.in.time.items.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ALeapinTime implements ModInitializer {
	public static final String MOD_ID = "a_leap_in_time";

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "general"),
			() -> new ItemStack(ModItems.RESONATING_SHARD));
	@Override
	public void onInitialize() {

		//Make this rotatable
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID,"resonating_crystal"), ModBlocks.RESONATING_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "resonating_shard"), ModItems.RESONATING_SHARD);
	}
}
