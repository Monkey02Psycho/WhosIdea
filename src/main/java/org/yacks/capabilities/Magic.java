package org.yacks.capabilities;

import net.minecraft.util.math.MathHelper;

/**
 * Implementation of Imagic. Nothing overly fancy here.
 */
public class Magic implements IMagic{

    private int max = 100;
    private int current = 0;

    /**
     * Sets the max possible amount
     * @param max the max possible amount
     */
    public Magic(int max){
        this.max = max;
    }

    public Magic(){}
    @Override
    public int getMagic() {
        return this.current;
    }

    @Override
    public void setMagic(int amount) {
        this.current = amount;
    }

    @Override
    public void consume(int amount) {
        this.current = MathHelper.clamp(this.current - amount, 0, this.max);
    }

    @Override
    public void fill(int amount) {
        this.current = MathHelper.clamp(this.current + amount, 0, this.max);
    }
    
}
