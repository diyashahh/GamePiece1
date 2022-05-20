public interface Attacker {
    public int getNumAttacks();
    public void setNumAttacks(int numAttacks);
    //AR = Attacker, AD = Attacked
    public boolean validAttackPath(int ARrow, int ARcol, int ADrow, int ADcol);
}
