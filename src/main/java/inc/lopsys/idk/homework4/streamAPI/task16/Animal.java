package inc.lopsys.idk.homework4.streamAPI.task16;

public record Animal(
    String name,
    Type type,
    Sex sex,
    int age,
    int height,
    int weight,
    boolean bites)
{
    public Animal(String name, Type type, Sex sex, int age, int height, int weight, boolean bites) {
        this.name = name;
        this.type = type;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.bites = bites;
    }

    enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    enum Sex {
        M, F
    }

    public int paws() {
        return switch (type) {
            case CAT, DOG -> 4;
            case BIRD -> 2;
            case FISH -> 0;
            case SPIDER -> 8;
        };
    }
}
