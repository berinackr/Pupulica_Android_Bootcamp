package com.example.homeworks.Hw_1

// hw2.kt

fun main() {
    println("Fahrenheit: ${celsiusToFahrenheit(25.0)}")
    println("Dikdörtgen Çevresi: ${dikdortgenCevresi(5, 10)}")
    println("Faktöriyel: ${faktoriyel(5)}")
    println("'a' harfi sayısı: ${aHarfiniSay("Ankara")}")
    println("İç açılar toplamı: ${icAcilarToplami(5)}")
    println("Maaş Hesabı: ${maasHesapla(22)}") // 22 gün çalışmış örneğin
    println("İnternet Ücreti: ${internetUcreti(60)}") // 60 GB kullanmış örneğin
}

// 1. Celsius'ı Fahrenheit'a çeviren metod
fun celsiusToFahrenheit(celsius: Double): Double {
    return celsius * 1.8 + 32
}

// 2. Dikdörtgen çevresi hesaplayan metod
fun dikdortgenCevresi(kisaKenar: Int, uzunKenar: Int): Int {
    return 2 * (kisaKenar + uzunKenar)
}

// 3. Faktoriyel hesaplayan metod
fun faktoriyel(sayi: Int): Int {
    var sonuc = 1
    for (i in 1..sayi) {
        sonuc *= i
    }
    return sonuc
}

// 4. Kelime içindeki 'a' harfini sayan metod
fun aHarfiniSay(kelime: String): Int {
    var sayac = 0
    for (harf in kelime) {
        if (harf.lowercaseChar() == 'a') {
            sayac++
        }
    }
    return sayac
}

// 5. Çokgenin iç açılar toplamını hesaplayan metod
fun icAcilarToplami(kenarSayisi: Int): Int {
    return (kenarSayisi - 2) * 180
}

// 6. Gün sayısına göre maaş hesabı yapan metod
fun maasHesapla(gunSayisi: Int): Int {
    val calismaSaati = gunSayisi * 8
    return if (calismaSaati <= 160) {
        calismaSaati * 10
    } else {
        val mesaiSaati = calismaSaati - 160
        (160 * 10) + (mesaiSaati * 20)
    }
}

// 7. Kota miktarına göre internet ücreti hesaplayan metod
fun internetUcreti(kota: Int): Int {
    return if (kota <= 50) {
        100
    } else {
        100 + (kota - 50) * 4
    }
}
