package com.cydeo;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
/*
Bir Student sınıfını karşılaştırmak için bir AgeComparator sınıfı oluşturduk.
AgeComparator, Comparator arabirimini uygular,
böylece Student sınıfı nesnelerini yaşlarına göre karşılaştırabilir.

Comparator arabirimi, sıralama işlemi için kullanılabilen bir karşılaştırma yöntemi
tanımlar. Bu, veri koleksiyonlarını (örneğin, List, Set vb.) veya özel veri
yapılarını sıralarken kullanışlıdır.

AgeComparator sınıfı, Comparator<Student> arayüzünü uyguladığı için,
Student sınıfının nesnelerini karşılaştırmak için compare() yöntemini uygulamalıdır.
 Bu yöntem, iki Student nesnesini alır ve onların yaşlarına göre karşılaştırma yapar.
 Bu yöntem, sıralama işlemi için kullanılacak karşılaştırma mantığını belirtir.

public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        // Karşılaştırma mantığı burada gerçekleştirilir.
        // Eğer student1 daha genç ise, negatif bir değer döndürülür.
        // Eğer student1 ve student2 aynı yaşta ise, 0 döndürülür.
        // Eğer student1 daha yaşlı ise, pozitif bir değer döndürülür.
    }
}

Bu yöntemi, öğrencilerin yaşlarına göre sıralamak için çeşitli yöntemler kullanabilirsiniz,
örneğin, yaşları doğrudan karşılaştırabilir veya yaşlarına göre artan veya azalan sıralama
yapmak için farklı hesaplamalar yapabilirsiniz. Önemli olan, compare() yönteminin doğru
sonuçları üretmesi ve sıralama işlemi sırasında öğrencilerin doğru bir şekilde düzenlenmesidir

 */