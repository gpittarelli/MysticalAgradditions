package com.blakebr0.mysticalagradditions.blocks;

import java.util.Random;

import com.blakebr0.cucumber.util.Utils;
import com.blakebr0.mysticalagradditions.items.ModItems;
import com.blakebr0.mysticalagradditions.lib.MAHelper;
import com.blakebr0.mysticalagriculture.blocks.crop.BlockMysticalCrop;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockTier6InferiumCrop extends BlockMysticalCrop {

	public BlockTier6InferiumCrop(String name) {
		super(name);
	}

	@Override
	public Item getSeed() {
		return ModItems.itemTier6InferiumSeeds;
	}

	@Override
	public Item getCrop() {
		return MAHelper.items.itemCrafting;
	}

	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		int age = state.getValue(AGE);
		Random rand = Utils.rand;

		int essence = 0;
		int seeds = 1;

		if (age == 7) {
			if (MAHelper.config.confSeedChance > 0) {
				if (rand.nextInt(100 / MAHelper.config.confSeedChance) > 0) {
					seeds = 1;
				} else {
					seeds = 2;
				}
			} else {
				seeds = 1;
			}
		}

		if (age == 7) {
			if (MAHelper.config.confEssenceChance > 0) {
				if (rand.nextInt(100 / MAHelper.config.confEssenceChance) > 0) {
					essence = 6;
				} else {
					essence = 7;
				}
			} else {
				essence = 6;
			}
		}

		drops.add(new ItemStack(this.getSeed(), seeds, 0));
		if (essence > 0) {
			drops.add(new ItemStack(this.getCrop(), essence, 0));
		}
	}
}