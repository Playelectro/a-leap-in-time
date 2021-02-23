package net.a.leap.in.time;

import net.a.leap.in.time.blocks.ModBlocks;
import net.a.leap.in.time.items.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.LootConditionTypes;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.entry.LootPoolEntryTypes;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ALeapinTime implements ModInitializer {
	private static final Identifier DIAMOND_ORE_LOOT_TABLE_ID = new Identifier("minecraft", "blocks/diamond_ore");
	public static final String MOD_ID = "a_leap_in_time";

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "general"),
			() -> new ItemStack(ModItems.RESONATING_SHARD));

	@Override
	public void onInitialize() {


		Registry.register(Registry.BLOCK, new Identifier(MOD_ID,"resonating_crystal"), ModBlocks.RESONATING_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "resonating_shard"), ModItems.RESONATING_SHARD);

		registerEvents();
	}

	private void registerEvents(){
		LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
			if (DIAMOND_ORE_LOOT_TABLE_ID.equals(id)) {
				FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
						.rolls(ConstantLootTableRange.create(1))
						.withEntry(ItemEntry.builder(ModItems.RESONATING_SHARD).build())
						.withCondition(RandomChanceLootCondition.builder(0.3f).build());

				supplier.withPool(poolBuilder.build());
			}
		});
	}
}
