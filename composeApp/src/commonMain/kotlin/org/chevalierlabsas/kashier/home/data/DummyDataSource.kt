package org.chevalierlabsas.kashier.home.data

import org.chevalierlabsas.kashier.home.domain.Item

class DummyDataSource {

    fun getData(): List<Item> = listOf(
        Item(
            id = 1,
            userId = 1,
            name = "Telur 0.5 KG",
            price = 12000.0
        ),
        Item(
            id = 2,
            userId = 1,
            name = "Jeruk Mandarin 1 KG",
            price = 30000.0
        ),
        Item(
            id = 3,
            userId = 1,
            name = "Alpukat 250 GR",
            price = 50000.0
        ),
        Item(
            id = 4,
            userId = 1,
            name = "Teh Celup 25 PCS",
            price = 15500.0
        ),
        Item(
            id = 5,
            userId = 1,
            name = "Kepiting Laut 2 KG",
            price = 120000.0
        ),
        Item(
            id = 6,
            userId = 1,
            name = "Kerang 1 KG",
            price = 70000.0
        ),
        Item(
            id = 8,
            userId = 1,
            name = "Cumi-Cumi 1 KG",
            price = 100000.0
        ),
        Item(
            id = 9,
            userId = 1,
            name = "Udang 100 GR",
            price = 9000.0
        ),
        Item(
            id = 10,
            userId = 1,
            name = "Nasi Putih 1 Porsi",
            price = 5000.0
        ),
        Item(
            id = 11,
            userId = 1,
            name = "Es Kopi",
            price = 10000.0
        ),
        Item(
            id = 12,
            userId = 1,
            name = "Kelapa Muda",
            price = 12000.0
        ),
    )

}