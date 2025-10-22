package de.scholle.instaLeafDecay;

import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Leaves;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.LeavesDecayEvent;

import java.util.ArrayList;
import java.util.List;

public class BlockBreakListener implements Listener {

    private final ArrayList<BlockFace> neighbors = new ArrayList<>(List.of(BlockFace.values()));

    public BlockBreakListener() {
        neighbors.remove(BlockFace.SELF);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();

        if (Tag.LEAVES.isTagged(block.getType())) {
            breakLeaf(block, isValidLeaf(block), block);
        }

        if (Tag.LOGS.isTagged(block.getType())) {
            breakLeaf(block, false, block);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onLeavesDecay(LeavesDecayEvent event) {
        breakLeaf(event.getBlock(), isValidLeaf(event.getBlock(), event.getBlock()), event.getBlock());
    }

    private void breakLeaf(Block block, boolean breakFirstBlock, Block originalBlock) {
        if (breakFirstBlock) block.breakNaturally();

        for (BlockFace neighbor : neighbors) {
            Block neighborBlock = block.getRelative(neighbor);
            if (!isValidLeaf(neighborBlock, originalBlock)) continue;
            breakLeaf(neighborBlock, true, block);
        }
    }

    private boolean isValidLeaf(Block block, Block originalBlock) {
        if (!(block.getBlockData() instanceof Leaves leafBlock)) return false;
        if (leafBlock.getDistance() < 7) return false;
        if (leafBlock.isPersistent()) return false;

        return TaxicabDistanceService.distance(block, originalBlock) < 35;
    }

    private boolean isValidLeaf(Block block) {
        return isValidLeaf(block, block);
    }
}
