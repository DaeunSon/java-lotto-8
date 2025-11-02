package lotto.domain.rank;

public enum Rank {
    FIRST(6, 2_000_000_000){
        @Override
        public boolean matches(int matchCount, boolean isBonusMatched) {
            return matchCount == 6;
        }
    },
    SECOND(5, 30_000_000){
        @Override
        public boolean matches(int matchCount, boolean isBonusMatched) {
            return matchCount == 5 && isBonusMatched;
        }
    },
    THIRD(5, 1_500_000){
        @Override
        public boolean matches(int matchCount, boolean isBonusMatched) {
            return matchCount == 5 && !isBonusMatched;
        }
    },
    FOURTH(4, 50_000){
        @Override
        public boolean matches(int matchCount, boolean isBonusMatched) {
            return matchCount == 4;
        }
    },
    FIFTH(3, 5_000){
        @Override
        public boolean matches(int matchCount, boolean isBonusMatched) {
            return matchCount == 3;
        }
    },
    MISS(0, 0){
        @Override
        public boolean matches(int matchCount, boolean isBonusMatched) {
            return matchCount < 3;
        }
    };

    private final int matchCount;
    private final int prize;

    abstract public boolean matches(int matchCount, boolean isBonusMatched);

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank fromMatchCount(int matchCount, boolean isBonusMatched) {
        for (Rank rank : values()) {
            if (rank.matches(matchCount, isBonusMatched)) {
                return rank;
            }
        }
        return MISS;
    }

    public int getPrize() {
        return prize;
    }
}
