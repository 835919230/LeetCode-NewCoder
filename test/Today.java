import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hexi on 16-10-15.
 */
public class Today {
    static class Animal{}
    static class EatMeatAnimal extends Animal {}
    static class EatGrassAnimal extends Animal {
        public void cry() {
            System.out.println(".....");
        }
    }
    static class Sheep extends EatGrassAnimal{public Sheep() {
        say();
    }

        public void say() {
            System.out.println("mee~~~~~~~~~");
        }
        @Override
        public String toString() {
            return "He He";
        }
    }

    public static class People {
        private String name = null;
        public People(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("java.util.ArrayList");
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            Class<?> declaringClass = method.getDeclaringClass();
            System.out.println(declaringClass);
        }
        ArrayList arrayList = (ArrayList) aClass.newInstance();
        arrayList.add(1);
        System.out.println(arrayList.size());

        Class<People> personClass = Today.People.class;
        People people = personClass.newInstance();
        System.out.println(people);

    }

    static void test1() {
        List<? super EatGrassAnimal> list = new ArrayList<>();
        list.add(new Sheep());
//        list.add(new Animal()); Compiler error
        System.out.println(list.get(0));


        List<? extends EatGrassAnimal> animals = new ArrayList<>();
//        animals.add(new Sheep()); Compiler error

        MyObj<Sheep> sheepMyObj = new MyObj<>(new Sheep());
        sheepMyObj.outPrint();

        Class<Animal> animalClass = Animal.class;
        Animal cast = animalClass.cast(new Sheep());
        System.out.println(cast);
    }

    static class MyObj<T extends Animal> {
        T obj;

        public MyObj(T t) {
            obj = t;
        }

        public void outPrint() {
            System.out.println(obj.toString());
        }
    }
}
