package mods.officialy.fluidity.util;

import net.minecraft.world.level.block.Block;

public class FluidBlockInfo {
    public Block block;
    public long lastMoveTime; // Timestamp of the last move

    public FluidBlockInfo(Block block, long lastMoveTime) {
        this.block = block;
        this.lastMoveTime = lastMoveTime;
    }
}
