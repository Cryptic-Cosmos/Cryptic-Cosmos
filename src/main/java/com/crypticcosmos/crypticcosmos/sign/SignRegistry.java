package com.crypticcosmos.crypticcosmos.sign;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.WoodType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SignItem;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SignRegistry {
    //Create all the registers
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,CrypticCosmos.MOD_ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,CrypticCosmos.MOD_ID);
    private static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, CrypticCosmos.MOD_ID);

    //Register the woodtype
    public static final WoodType GROMBLE = WoodType.create(new ResourceLocation(CrypticCosmos.MOD_ID, "gromble").toString());

    //Register the sign (Wall & Standing)
    public static final RegistryObject<CustomStandingSignBlock> STANDING_GROMBLE_SIGN = BLOCKS.register("gromble_sign",() -> new CustomStandingSignBlock(Block.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD),GROMBLE));
    public static final RegistryObject<CustomWallSignBlock> GROMBLE_WALL_SIGN = BLOCKS.register("gromble_wall_sign", () -> new CustomWallSignBlock(Block.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), GROMBLE));

    //Register the Tile Entity(Block Entity)
    public static final RegistryObject<TileEntityType<CustomSignTileEntity>> GROMBLE_SIGN = TILES.register("gromble_sign", () -> TileEntityType.Builder.of(CustomSignTileEntity::new, GROMBLE_WALL_SIGN.get(), STANDING_GROMBLE_SIGN.get()).build(null));

    //Register all the items for the signs
    public static final RegistryObject<SignItem> GROMBLE_SIGN_ITEM = ITEMS.register("gromble_sign", () -> new SignItem((new Item.Properties()).stacksTo(16).tab(ItemGroup.TAB_DECORATIONS), STANDING_GROMBLE_SIGN.get(), GROMBLE_WALL_SIGN.get()));
}
