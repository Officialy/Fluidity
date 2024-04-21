package mods.officialy.fluidity;

import com.mojang.logging.LogUtils;
import mods.officialy.fluidity.level.ChunkFluids;
import mods.officialy.fluidity.level.FluidTickHandler;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.HitResult;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.Properties;

@Mod(Fluidity.ID)
public class Fluidity {
    public static final String ID = "fluidity";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.createBlocks(ID);

    public static final ChunkFluids chunkFluidsInstance = new ChunkFluids();

    public static final DeferredHolder<Item, ItemTest> TEST_ITEM = ITEMS.register("test_item", () -> new ItemTest(new Item.Properties()));
    public static final DeferredHolder<Block, Block> TEST_BLOCK = BLOCKS.register("test_block", () -> new CustomFluidBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)));
    public static final DeferredHolder<Item, BlockItem> TEST_BLOCK_ITEM = ITEMS.register("test_block", () -> new BlockItem(TEST_BLOCK.get(), new Item.Properties()));

    public Fluidity(IEventBus eventBus) {
        eventBus.addListener(this::commonSetup);
        ITEMS.register(eventBus);
        BLOCKS.register(eventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    public static class ItemTest extends Item {

        public ItemTest(Properties p_41383_) {
            super(p_41383_);
        }

        @Override
        public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
            if (player.isShiftKeyDown()) {

            }
            else {
                level.setBlock(player.blockPosition(), Fluidity.TEST_BLOCK.get().defaultBlockState(), 3);
            }

            return InteractionResultHolder.pass(this.getDefaultInstance());
        }
    }

    public static class CustomFluidBlock extends Block {
        public static final IntegerProperty LEVEL = IntegerProperty.create("level", 1, 8);

        public CustomFluidBlock(Properties properties) {
            super(properties);
//            this.registerDefaultState(this.stateDefinition.any().setValue(LEVEL, 1));
        }

//        @Nullable
//        @Override
//        public BlockState getStateForPlacement(BlockPlaceContext p_49820_) {
//            return this.defaultBlockState().setValue(LEVEL, 8);
//        }
    }
}
