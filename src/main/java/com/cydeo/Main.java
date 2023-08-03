package com.cydeo;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();                        //AÇIKLAMA-1 (aşağıda)
        List<Integer> ints = new ArrayList<>(Arrays.asList(2,4,3,1,5));    ////AÇIKLAMA-2 (aşağıda)

        int[] arr = {1,3,4,5,2};

        Student st1 = new Student("Emirhan",24,"Male");
        Student st2 = new Student("Kubra",21,"Female");
        Student st3 = new Student("Necibe",21,"Female");
        Student st4 = new Student("Mehmet",27,"Male");
        Student st5 = new Student("Enis",26,"Male");
        Student st6 = new Student("Samet",25,"Male");
        Student st7 = new Student("Özkan",50,"Male");
        Student st8 = new Student("Cüneyt",23,"Male");

        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
        students.add(st6);
        students.add(st7);
        students.add(st8);

        System.out.println("-----Arrays.sort method:-----");
        Arrays.sort(arr);
        System.out.println("Arrays.toString(Arrays.sort(arr)) = " + Arrays.toString(arr));

        System.out.println("-----Collections.sort method(int):-----");    // AÇIKLAMA-3:
        Collections.sort(ints);
        System.out.println(ints);

        System.out.println("-----Collections.sort- comparator metod ile:-----");  // AÇIKLAMA-4
        System.out.println(students);                        // not sorted
        Collections.sort(students, new AgeComparator());
        System.out.println(students);                       //with sorted

        System.out.println("-----Stream.sort method:-----");
        students.stream().sorted(Comparator.comparing(Student::getAge)).forEach(System.out::println);
        students.stream().sorted(Comparator.comparing(Student::getAge).thenComparing(Student::getName)).forEach(System.out::println);
    }
}
       /* AÇIKLAMA-1
        List<Student> students = new ArrayList<>();   ===> açıklaması:
1- List<Student> students: Bu satır, Student sınıfından nesneler içeren bir liste oluşturulacağını belirtir.
List veri türü, koleksiyon elemanlarının sıralı bir şekilde depolandığı bir arayüzü temsil eder.
Student ise listedeki elemanların türünü belirtir. Bu tanımlama, sınırlayıcı bir rol oynar,
 çünkü listede sadece Student türünden nesnelerin saklanabileceğini gösterir.

2- new ArrayList<>(): Bu kısım, ArrayList sınıfından bir nesne oluşturur. ArrayList,
List arayüzünü uygulayan ve dinamik olarak boyutu ayarlanabilen bir dizi gibi davranan bir koleksiyon sınıfıdır.
 Yani, eleman eklemeye veya çıkarmaya göre otomatik olarak boyutunu ayarlar.

 Student sınıfından oluşturulan nesneleri depolamak için dinamik boyutlu bir liste olan students'ı oluşturur.
  Bu liste, daha sonra öğrenci nesnelerini eklemek, çıkarmak, güncellemek ve diğer liste işlemlerini
  gerçekleştirmek için kullanılabilir.


         AÇIKLAMA-2
        List<Integer> ints = new ArrayList<>(Arrays.asList(2,4,3,1,5)); ===> açıklaması:
1- List<Integer> ints: Bu satır, Integer türünden elemanlar içeren bir liste oluşturulacağını belirtir.
Burada List veri türü, koleksiyon elemanlarının sıralı bir şekilde depolandığı bir arayüzü temsil eder.
Integer ise listedeki elemanların türünü belirtir.

2- new ArrayList<>(Arrays.asList(2,4,3,1,5)): Bu kısım, ArrayList sınıfından bir nesne oluştururken,
 aynı zamanda başlangıç değerleri olarak verilen Integer elemanları ile bu listeyi doldurur.
 Arrays.asList() yöntemi, varargs (değişken argümanlar) şeklinde aldığı elemanları bir liste olarak döndürür.
 Daha sonra bu liste, ArrayList'in constructor'ına geçirilerek, bu elemanlarla doldurulur.

Sonuç olarak, ints adlı liste şu elemanları içerecektir: [2, 4, 3, 1, 5].

            AÇIKLAMA-3
            Collections.sort(ints);  ===> açıklaması:
    Collections sınıfı, Java Collections Framework'de kullanılan bazı kullanışlı yöntemleri içeren
bir yardımcı sınıftır. Bu sınıf, koleksiyonları sıralamak, döndürmek, doldurmak, aramak ve
değiştirmek gibi işlemleri gerçekleştirmek için kullanılır.

    sort() yöntemi, listedeki elemanları doğal sıralama düzenine göre sıralamak için kullanılır.
Bu düzen, elemanların kendi türüne uygun bir sıralama yöntemine sahip olduğu anlamına gelir.
Örneğin, Integer türündeki elemanlar küçükten büyüğe doğru, String türündeki elemanlar
alfabetik olarak sıralanır.

    Collections.sort(ints) ifadesi, ints listesini küçükten büyüğe doğru sıralar. Bu işlem,
ints listesinin elemanlarını doğal sıralama düzenine göre yeniden düzenler ve listeyi değiştirir.
Yani, ints listesi artık küçükten büyüğe doğru sıralanmış olacaktır.

            AÇIKLAMA-4
            Collections.sort(students, new AgeComparator());
    Collections sınıfı, Java Collections Framework'de kullanılan bazı kullanışlı yöntemleri içeren bir
yardımcı sınıftır. sort() yöntemi, belirtilen koleksiyonu küçükten büyüğe doğru sıralamak için kullanılır.

    Ancak, sort() yöntemi elemanları doğal sıralama düzenine göre sıralamaz. Bunun yerine, özel bir
sıralama düzeni belirtmek istediğimizde, bu yöntemi çağırırken ikinci bir parametre olarak Comparator
türünden bir nesne geçiririz. Comparator, koleksiyon elemanlarının karşılaştırılmasını ve sıralama
düzenini belirlemek için kullanılan bir arabirimdir.

    Collections.sort(students, new AgeComparator()) ifadesi, students listesindeki Student nesnelerini
AgeComparator sınıfı tarafından belirtilen yaşa göre sıralar. Bu işlem, AgeComparator sınıfındaki
compare() yöntemi aracılığıyla elemanları karşılaştırarak gerçekleşir. Yani, AgeComparator sınıfı,
Student nesnelerini yaşlarına göre sıralamak için özel bir sıralama mantığı sağlar.

    AgeComparator sınıfı, Comparator<Student> arayüzünü uyguladığı için compare() yöntemini uygulamalıdır.
Bu yöntem, iki Student nesnesini alır ve onların yaşlarına göre karşılaştırma yapar. Sıralama işlemi
sırasında bu yöntem kullanılır ve listeye uygun bir şekilde sıralanmış Student nesneleri döndürülür.


         */