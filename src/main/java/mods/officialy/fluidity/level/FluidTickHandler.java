package mods.officialy.fluidity.level;

import mods.officialy.fluidity.Fluidity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.TickEvent;

@Mod.EventBusSubscriber(modid = Fluidity.ID)
public class FluidTickHandler {


    // Assuming ChunkFluids and updateFluidsInChunk() are defined elsewhere as before
    @SubscribeEvent
    public static void tick(TickEvent.LevelTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
//            Fluidity.LOGGER.debug("FluidTickHandler: Level tick event");
            Level world = event.level;

            // Iterate over all players in the world to update nearby chunks
            for (Player player : world.players()) {
                updateFluidsAroundPlayer(world, player);
            }
        }
    }

    private static void updateFluidsAroundPlayer(Level level, Player player) {
        // Define the radius around the player within which to update fluids
        final int radius = 5; // Chunk radius around the player

        BlockPos playerPos = player.blockPosition();
        ChunkPos playerChunkPos = new ChunkPos(playerPos);

        // Calculate the range of chunks around the player
        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {
                ChunkPos chunkPos = new ChunkPos(playerChunkPos.x + dx, playerChunkPos.z + dz);

                // Here, we need to get or create a ChunkFluids instance for this chunk
                // Since we can't iterate all chunks directly, manage your ChunkFluids instances accordingly
                // This could involve checking if the chunk is loaded, and if so, updating its fluid dynamics
                // For simplicity, let's assume a method getOrCreateChunkFluids(ChunkPos) exists
                ChunkFluids chunkFluids = getOrCreateChunkFluids(chunkPos);

                // Update fluid dynamics for this chunk
                updateFluidsInChunk(level, chunkFluids);

                // Remember to correctly manage chunk fluid data, especially when chunks unload
            }
        }
    }

    private static ChunkFluids getOrCreateChunkFluids(ChunkPos chunkPos) {
        // Your method to get or create a ChunkFluids instance for the chunk
        return Fluidity.chunkFluidsInstance; // Placeholder return
    }

    private static void updateFluidsInChunk(Level level, ChunkFluids chunkFluids) {
        // Your fluid dynamics update logic here
        ChunkFluids.updateFluidsInChunk(level, chunkFluids);
    }

}
