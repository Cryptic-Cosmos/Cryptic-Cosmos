package com.crypticcosmos.crypticcosmos.register;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.sign.CustomSignTileEntity;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.block.StandingSignBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodType;

import static com.crypticcosmos.crypticcosmos.CrypticCosmos.getRegistrate;
import static com.crypticcosmos.crypticcosmos.register.GrombleRegistries.GROMBLE_PLANKS;
import static net.minecraft.data.RecipeProvider.woodenSign;

public class SignRegistry {
    public static final WoodType GROMBLE_WOOD_TYPE = WoodType.register(WoodType.create("gromble"));

    public static final BlockEntry<StandingSignBlock> GROMBLE_STANDING_SIGN = getRegistrate().object("gromble_standing_sign")
            .block(p -> new StandingSignBlock(p, GROMBLE_WOOD_TYPE))
            .recipe((context, provider) -> woodenSign(provider, context.get(), GROMBLE_PLANKS.get()))

            .tileEntity(tileEntityType -> new CustomSignTileEntity())
            .validBlocks()
            .build()

            .register();

    public static final BlockEntry<WallSignBlock> GROMBLE_WALL_SIGN = getRegistrate().object("gromble_standing_sign")
            .block(p -> new WallSignBlock(p, GROMBLE_WOOD_TYPE))

            .tileEntity(tileEntityType -> new CustomSignTileEntity())
            .validBlocks()
            .build()

            .register();

    // public static final TileEntityEntry<CustomSignTileEntity> GROMBLE_SIGN = getRegistrate().object("gromble_sign")
    //         .tileEntity(type -> new CustomSignTileEntity())
    //         .validBlocks(GROMBLE_WALL_SIGN, GROMBLE_STANDING_SIGN)
    //         .register();

    public static void init() {
        CrypticCosmos.LOGGER.info("SignRegistries initialized");
    }
}
