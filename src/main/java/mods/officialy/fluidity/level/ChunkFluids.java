package mods.officialy.fluidity.level;

import mods.officialy.fluidity.Fluidity;
import mods.officialy.fluidity.util.FluidBlockInfo;
import mods.officialy.fluidity.util.FluidMovementHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ChunkFluids {

    private static Logger LOGGER = Fluidity.LOGGER;
    public Map<BlockPos, FluidBlockInfo> fluidPositions = new HashMap<>();

    public void addFluidBlock(BlockPos position, FluidBlockInfo blockInfo) {
        Fluidity.LOGGER.debug("Adding fluid block {},", blockInfo + " at " + position);
        fluidPositions.put(position, blockInfo);
    }

    public boolean hasFluidAt(BlockPos position) {
        return fluidPositions.containsKey(position);
    }


    public static void updateFluidsInChunk(Level level, ChunkFluids chunkFluids) {
        LOGGER.debug("Updating fluids in chunk with {} fluid blocks", chunkFluids.fluidPositions.size());

        if (chunkFluids.fluidPositions.isEmpty() || chunkFluids == null) {
            return;
        }

        long currentTime = level.getGameTime();
        Map<BlockPos, FluidBlockInfo> newFluidPositions = new HashMap<>();

        for (Map.Entry<BlockPos, FluidBlockInfo> entry : new HashMap<>(chunkFluids.fluidPositions).entrySet()) {
            BlockPos currentPos = entry.getKey();
            FluidBlockInfo fluidInfo = entry.getValue();

            // Check if enough time has passed since the last move
            if (currentTime - fluidInfo.lastMoveTime < 1000) { // Wait for 1 second before moving again
                newFluidPositions.put(currentPos, fluidInfo);
            }

            BlockPos newPos = currentPos.below();
            if (newPos.getY() < -63 || !level.isEmptyBlock(newPos) || chunkFluids.hasFluidAt(newPos)) {
                newFluidPositions.put(currentPos, fluidInfo);
                continue;
            }

            // Move the fluid block in the world
            level.setBlock(newPos, fluidInfo.block.defaultBlockState(), 3);
            level.setBlock(currentPos, Blocks.STONE.defaultBlockState(), 3);

            // Update the last move time and store in new position
            fluidInfo.lastMoveTime = currentTime;
            newFluidPositions.put(newPos, fluidInfo);
        }

        // Update the positions map
        chunkFluids.fluidPositions.clear();
        chunkFluids.fluidPositions.putAll(newFluidPositions);
    }
}