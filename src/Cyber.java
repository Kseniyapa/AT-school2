public class Cyber {
    public static void main(String[] args) {
        /*
        С использованием построенного класса создайте два отрезка: один от точки (1;1) до точки (2;2)
        и второй отрезок от точки (-3;0) до точки (1;1).
        */
        Section section1 = new Section(1, 1, 2, 2);
//        Section section2 = new Section(1, 2, 2, 3);       // для проверки - будут равны
        Section section2 = new Section(-3, 0, 1, 1);

        System.out.printf("Длина отрезка %s равна %.2f\n", section1, section1.distance());
        System.out.printf("Длина отрезка %s равна %.2f\n", section2, section2.distance());

        /*
        Проверьте с помощью созданного метода равна ли их длина и если равна,то выведите соответсвующее сообщение на экран.
        */
        System.out.println("Длины отрезков " + (section1.compareLength(section2) ? "" : "не ") + "равны");
    }
}


/*
Создайте класс отрезков на координатной плоскости, описав в нём все необходимые свойства,
подобрав им понятные имена и правильные типы данных.
*/
class Section {
    private double x1, y1, x2, y2;

    /* Опишите в классе конструктор, позволяющий при создании нового объекта явно задать все его свойства.*/
    /* Если это необходимо, то проверьте допустимость их значений в конструкторе...*/
    // Нет никакой надобности
    public Section(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    // длина отрезка
    public double distance() {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    /* Создайте в классе метод, проверяющий равна ли длина двух отрезков. */
    public boolean compareLength(Section other) {
        double eps = .001;      // точность
        return Math.abs(distance() - other.distance()) < eps;
    }

    @Override
    public String toString() {
        return String.format("[%.2f, %.2f][%.2f, %.2f]", x1, y1, x2, y2);
    }
}

