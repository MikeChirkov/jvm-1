package ru.example;

// Загрузчик классов подгружает JvmComprehension и кладет в metaspace
public class JvmComprehension {

    public static void main(String[] args) { // создается фрейм в стеке под метод
        int i = 1;                      // int i кладется в стек
        Object o = new Object();        // Загрузчик классов подгружает Object, new Object - в кучу, ссылка o - в стек
        Integer ii = 2;                 // Загрузчик классов подгружает Integer, 2 - в кучу, ссылка ii - в стек
        printAll(o, i, ii);             // Создается фрейм в стеке  под метод
        System.out.println("finished"); // Создается фрейм в стеке  под метод, куда передается значение "finished"
        // сборщик мусора вычищает объекты из кучи
    }

    private static void printAll(Object o, int i, Integer ii) { // в стек кладутся ссылки o, ii и значение i
        Integer uselessVar = 700;                   // 700 - в кучу, ссылка uselessVar - в стек
        System.out.println(o.toString() + i + ii);  // создается фрейм в стеке  под метод, куда передается значение o.toString(), i и ссылка ii
        // сборщик мусора вычищает uselessVar из кучи
    }
}
