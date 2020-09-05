package com.RobotLucca.moltenzinc.fluids;

import net.minecraft.fluid.Fluid;
import java.util.ArrayList;

public final class MZFluids {
    public static GenericFluid.FluidData moltenZinc;

    public static ArrayList<Fluid> toRegister = new ArrayList<>();

    public static void init(){
        moltenZinc = GenericFluid.create("molten_zinc", true, false);
    }
}