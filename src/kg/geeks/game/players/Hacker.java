package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Hacker extends Hero{

    public Hacker(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.HACKING);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

        Hero hero1 = null;
        Hero hero2= null;

        while (true){
            Hero randomHero1 = heroes[RPG_Game.random.nextInt(heroes.length)];
            Hero randomHero2 = heroes[RPG_Game.random.nextInt(heroes.length)];

            if (randomHero1 != this && randomHero2 != this &&
                    randomHero1.getHealth() >0 && randomHero2.getHealth() > 0 &&
                    randomHero1 != randomHero2) {
                hero1 = randomHero1;
                hero2 = randomHero2;
                break;
            }
        }
        if (RPG_Game.roundNumber % 2 == 0 && this.getHealth() > 0 && boss.getHealth() >= 5) {
            int randomNum = RPG_Game.random.nextInt(5,11);
            boss.setHealth(boss.getHealth() - randomNum);
            System.out.println("Hacker " + this.getName() +
                    " Hacked the boss and took it away from him " + randomNum + " HP");
            if (randomNum % 2 == 0) {
                if (hero1 != null && hero2 == null) {
                    hero1.setHealth(hero1.getHealth() + randomNum);
                }else {
                    hero1.setHealth(hero1.getHealth() + (randomNum / 2));
                    hero2.setHealth(hero2.getHealth() + (randomNum / 2));
                    System.out.println("Hero " + hero1.getName() + " get: " + (randomNum / 2) + " HP");
                    System.out.println("Hero " + hero2.getName() + " get: " + (randomNum / 2) + " HP");
                }
            }
            else {
                if (hero1 != null && hero2 == null) {
                    hero1.setHealth(hero1.getHealth() + randomNum);
                }else {
                    hero1.setHealth(hero1.getHealth() + (randomNum / 2 + 1));
                    hero2.setHealth(hero2.getHealth() + (randomNum / 2));
                    System.out.println("Hero " + hero1.getName() + " get: " + (randomNum / 2 + 1) + " HP");
                    System.out.println("Hero " + hero2.getName() + " get: " + (randomNum / 2) + " HP");
                }
            }
        }
    }
}
