public interface Recruiter {
    public int getNumRecruits();
    public void setNumRecruits(int numRecruits);
    //RR = Recruiter, RD = Recruited
    public boolean validRecruitPath(int RRrow, int RRcol, int RDrow, int RDcol);


}
