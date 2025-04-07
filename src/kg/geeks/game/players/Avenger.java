package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Avenger extends Hero {
    private int[] percent = {1, 2, 3, 4, 5}; // 20% шанс
    private boolean shieldActive = false;
    private int originalBossDamage = 0;

    public Avenger(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.SHIELD);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (shieldActive) {
            boss.setDamage(originalBossDamage);
            shieldActive = false;
        }

        int randomChance = RPG_Game.random.nextInt(percent.length);
        int chance = percent[randomChance];
        if (chance == 1 && boss.getHealth() > 0) {
            originalBossDamage = boss.getDamage();
            boss.setDamage(0);
            shieldActive = true;
            System.out.println("Avenger " + this.getName() + " activated team shield!");
        }
    }
}
