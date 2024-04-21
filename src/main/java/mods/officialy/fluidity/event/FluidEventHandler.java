package mods.officialy.fluidity.event;

import mods.officialy.fluidity.Fluidity;
import mods.officialy.fluidity.level.ChunkFluids;
import mods.officialy.fluidity.util.FluidBlockInfo;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = Fluidity.ID)
public class FluidEventHandler {

    // Assuming you have a way to store and retrieve ChunkFluids instances by ChunkPos
    private static Map<ChunkPos, ChunkFluids> chunkFluidsMap = new HashMap<>();

    @SubscribeEvent
    public static void onBlockPlaced(BlockEvent.EntityPlaceEvent event) {
        // Check if the placed block is a fluid block. This is a simplification.
        // You might have specific criteria for what constitutes a "fluid block" in your mod.
        if (!(event.getPlacedBlock().getBlock() instanceof Fluidity.CustomFluidBlock)) {
            return;
        }

        BlockPos pos = event.getPos();
        Level world = (Level) event.getLevel();
        ChunkPos chunkPos = new ChunkPos(pos);

        // Retrieve or create the ChunkFluids instance for the chunk where the block was placed
        ChunkFluids chunkFluids = chunkFluidsMap.computeIfAbsent(chunkPos, k -> Fluidity.chunkFluidsInstance);

        // Add the fluid block to the ChunkFluids instance
        chunkFluids.addFluidBlock(pos, new FluidBlockInfo(event.getPlacedBlock().getBlock(), ((Level) event.getLevel()).getGameTime()));

        // Optionally, mark the chunk for update if your fluid simulation affects block states
        world.getChunkAt(pos).setUnsaved(true);
    }

    // Your existing methods for updating fluids, handling chunk loads/unloads, etc.
}