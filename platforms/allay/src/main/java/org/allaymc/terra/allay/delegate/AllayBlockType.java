package org.allaymc.terra.allay.delegate;

import org.allaymc.api.block.type.BlockType;
import org.allaymc.api.block.type.BlockTypes;
import org.allaymc.terra.allay.Mapping;

import com.dfsek.terra.api.block.state.BlockState;


/**
 * Terra Project 2024/6/16
 *
 * @author daoge_cmd
 */
public record AllayBlockType(BlockType<?> allayBlockType) implements com.dfsek.terra.api.block.BlockType {
    @Override
    public BlockState getDefaultState() {
        return new AllayBlockState(allayBlockType.getDefaultState(), Mapping.blockStateBeToJe(allayBlockType.getDefaultState()));
    }

    @Override
    public boolean isSolid() {
        return allayBlockType.getMaterial().isSolid();
    }

    @Override
    public boolean isWater() {
        return allayBlockType == BlockTypes.WATER || allayBlockType == BlockTypes.FLOWING_WATER;
    }

    @Override
    public BlockType<?> getHandle() {
        return allayBlockType;
    }
}
