package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Ludoman extends Hero{
    private int[] dise = {1,2,3,4,5,6};

    public Ludoman(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.DISE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int randomIndex1 = RPG_Game.random.nextInt(dise.length);
        int randomIndex2 = RPG_Game.random.nextInt(dise.length);
        int luckyDise1 = dise[randomIndex1];
        int luckyDise2 = dise[randomIndex2];

        if (luckyDise1 == luckyDise2) {
            boss.setHealth(boss.getHealth() - (luckyDise1 * luckyDise2));
            System.out.println("Ludoman " + this.getName() + " rolled the dise: " +
                    " First dise: " + luckyDise1 + ", Second dise: "+ luckyDise2
                        + "\nBoss get: " + (luckyDise1 * luckyDise2));
        } else {
            for (int i = 0; i < heroes.length; i++) {
                Hero randomHero = heroes[RPG_Game.random.nextInt(heroes.length)];
                if (randomHero.getHealth() > 0) {
                    randomHero.setHealth(randomHero.getHealth() - (luckyDise1 + luckyDise2));
                    System.out.println("Ludoman " + this.getName() + " rolled the dise: " +
                            " First dise: " + luckyDise1 + ", Second dise: "+ luckyDise2
                            + "\nHero " + randomHero.getName() + " get: " + (luckyDise1 + luckyDise2));
                    break;
                }
            }
        }

    }
}
