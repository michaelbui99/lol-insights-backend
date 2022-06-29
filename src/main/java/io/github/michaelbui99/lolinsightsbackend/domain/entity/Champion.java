package io.github.michaelbui99.lolinsightsbackend.domain.entity;

public class Champion {
    private com.merakianalytics.orianna.types.core.staticdata.Champion champion;
    private float winRate;
    private float pickRate;
    private float banRate;

    private Champion(ChampionsBuilder builder) {
        this.champion = builder.champion;
        this.winRate = builder.winRate;
        this.pickRate = builder.pickRate;
        this.banRate = builder.banRate;
    }

    public com.merakianalytics.orianna.types.core.staticdata.Champion getChampion() {
        return champion;
    }

    public void setChampion(com.merakianalytics.orianna.types.core.staticdata.Champion champion) {
        this.champion = champion;
    }

    public float getWinRate() {
        return winRate;
    }

    public void setWinRate(float winRate) {
        this.winRate = winRate;
    }

    public float getPickRate() {
        return pickRate;
    }

    public void setPickRate(float pickRate) {
        this.pickRate = pickRate;
    }

    public float getBanRate() {
        return banRate;
    }

    public void setBanRate(float banRate) {
        this.banRate = banRate;
    }


    public static class ChampionsBuilder {
        private com.merakianalytics.orianna.types.core.staticdata.Champion champion;
        private float winRate;
        private float pickRate;
        private float banRate;

        public ChampionsBuilder(com.merakianalytics.orianna.types.core.staticdata.Champion champion) {
            this.champion = champion;
        }

        public ChampionsBuilder winRate(float winRate) {
            this.winRate = winRate;
            return this;
        }

        public ChampionsBuilder pickRate(float pickRate) {
            this.pickRate = pickRate;
            return this;
        }

        public ChampionsBuilder banRate(float banRate) {
            this.banRate = banRate;
            return this;
        }

        public Champion build() {
            return new Champion(this);
        }
    }
}
