/**
 * Copyright (c) SpaceToad, 2011
 * http://www.mod-buildcraft.com
 *
 * BuildCraft is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 */

package buildcraft.transport.pipes;

import buildcraft.transport.TileGenericPipe;
import buildcraft.transport.pipes.PipeLogic;
import net.minecraft.tileentity.TileEntity;

public class PipeLogicSandstone extends PipeLogic{
	@Override
	public boolean isPipeConnected(TileEntity tile) {
		 return (tile instanceof TileGenericPipe);
	}
}
