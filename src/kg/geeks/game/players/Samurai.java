package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Samurai extends Hero{
    private int virus = 20;
    private int vaccine = 40;

    public Samurai(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.SHURIKEN);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (this.getHealth() > 0 ) {
            boolean isVirus = RPG_Game.random.nextBoolean();
            if (isVirus) {
                boss.setHealth((boss.getHealth() - virus));
                System.out.println("Samurai " + this.getName()
                + " dropped the VIRUS and inflicted " + virus);
            }else {
                boss.setHealth((boss.getHealth() + vaccine));
                System.out.println("Samurai " + this.getName()
                        + " dropped the VACCINE and cured " + vaccine);
            }
        }
    }
}
