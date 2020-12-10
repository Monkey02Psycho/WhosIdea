package org.yacks.capabilities;
/**
 * Interface that all magic capabilites implement.
 */
public interface IMagic {
    
    public int getMagic();
    public void setMagic(int amount);

    public void consume(int amount);
    public void fill(int amount);
}
