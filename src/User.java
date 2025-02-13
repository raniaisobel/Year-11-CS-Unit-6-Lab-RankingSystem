public class User {
    private int rank;
    private int progress;
    private int[] ranks = {-8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8};

    public User(){
        this.rank = -8;
        this.progress = 0;
    }
    public int getRank(){
        return this.rank;
    }

    public int getProgress(){
        return this.progress;
    }

    private int getRankIndex(int r) {
        for (int i = 0; i < ranks.length; i++) {
            if (ranks[i] == r) return i;
        }
        return -1;
    }

    public void incProgress(int activityRank) {
        if (getRankIndex(activityRank) == -1) {
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        }
        if (this.rank == 8) {
            this.progress = 0;
            return;
        }

        int d = getRankIndex(activityRank) - getRankIndex(this.rank);

        if (d <= -2) {
            return;
        }

        if (d == 0) {
            this.progress += 3;
        }
        else if(d == -1){
            this.progress += 1;
        }
        else {
            this.progress += 10 * d * d;
        }

        while (this.progress >= 100 && this.rank < 8) {
            this.progress -= 100;
            this.rank = ranks[getRankIndex(this.rank) + 1];
        }

        if (this.rank==8){
            this.progress=0;
        }
    }

    public String toString(){
        return "User{rank="+this.rank+", progress="+this.progress+"}";
    }
}
