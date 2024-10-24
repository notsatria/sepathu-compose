package com.notsatria.sepathu.utils

import com.notsatria.sepathu.R
import com.notsatria.sepathu.data.entities.ShoeEntity

object DataDummy {
    fun generateDummyShoe(): List<ShoeEntity> = listOf(
        ShoeEntity(
            id = 1,
            name = "Ultra 4D Shoes",
            price = 141.98,
            image = R.drawable.il_running_ultra4d_1,
            categoryId = 0,
            description = "The Ultra 4D Shoes combine innovative technology with a sleek design. Featuring a dynamic mesh upper and a 1D-printed midsole, these shoes are crafted to deliver superior comfort and responsiveness. Whether you're hitting the track or the streets, the Ultra 4D offers a perfect balance of support and flexibility, allowing you to push your limits with every step.",
            rating = 1.0,
            isOnCart = false,
        ),
        ShoeEntity(
            id = 2,
            name = "SL-20 Shoes",
            price = 100.20,
            image = R.drawable.il_running_sl20_1,
            categoryId = 0,
            description = "The SL-20 Shoes are engineered for speed and agility. With their lightweight build and breathable upper, these shoes provide a snug fit for high-speed runs. The midsole cushioning ensures energy return with each stride, making them ideal for those looking to enhance their running performance.",
            rating = 4.0,
            isOnCart = false,
        ),
        ShoeEntity(
            id = 1,
            name = "Ultra 4D White Shoes",
            price = 120.12,
            image = R.drawable.il_running_ultra4d_white_1,
            categoryId = 0,
            description = "The Ultra 4D White Shoes bring together futuristic design and advanced performance features. A seamless knit upper wraps your foot, while the cutting-edge 4D midsole provides excellent cushioning and energy return. These shoes are perfect for both casual wear and running, offering a blend of style and comfort.",
            rating = 1.0,
            isOnCart = false,
        ),
        ShoeEntity(
            id = 4,
            name = "Ultraboost 20 Shoes",
            price = 180.99,
            image = R.drawable.il_running_ultraboost_1,
            categoryId = 0,
            description = "Ultraboost 20 Shoes are designed for runners who demand maximum comfort and responsiveness. The Primeknit upper adapts to your foot’s movements, while the Boost midsole ensures unparalleled energy return with each step. Ideal for long-distance running or everyday wear, these shoes provide a snug, sock-like fit.",
            rating = 5.0,
            isOnCart = false,
        ),
        ShoeEntity(
            id = 5,
            name = "Lego Reg Sport Shoes",
            price = 89.90,
            image = R.drawable.il_walking_lego_1,
            categoryId = 1,
            description = "The Lego Reg Sport Shoes blend playfulness with functionality. Inspired by Lego designs, these shoes are perfect for casual walks or light exercise. Featuring a flexible sole and a fun design, they offer a comfortable and stylish way to get moving.",
            rating = 4.0,
            isOnCart = false,
        ),
        ShoeEntity(
            id = 6,
            name = "Fortarun Running Shoes",
            price = 72.45,
            image = R.drawable.il_walking_fortarun_1,
            categoryId = 1,
            description = "The Fortarun Running Shoes offer great performance for both casual walkers and runners. They feature a breathable mesh upper, providing flexibility and ventilation. With lightweight cushioning, these shoes ensure comfort during longer walks or runs.",
            rating = 4.5,
            isOnCart = false,
        ),
        ShoeEntity(
            id = 7,
            name = "Supernova Running Shoes",
            price = 95.10,
            image = R.drawable.il_walking_supernova_1,
            categoryId = 1,
            description = "The Supernova Running Shoes combine responsive cushioning with a supportive fit, making them ideal for runners who enjoy long-distance performance. The breathable upper provides a soft, natural feel, while the flexible sole enhances each stride.",
            rating = 4.7,
            isOnCart = true,
        ),
        ShoeEntity(
            id = 8,
            name = "Faito Summer Tokyo Shoes",
            price = 60.00,
            image = R.drawable.il_walking_faito_1,
            categoryId = 1,
            description = "The Faito Summer Tokyo Shoes are the perfect companions for your summer walks. Their lightweight construction and breathable fabric make them ideal for hot weather, while the bright design adds a touch of fun and style to your outfit.",
            rating = 1.8,
            isOnCart = false,
        ),
        ShoeEntity(
            id = 9,
            name = "Dome 7 Shoes",
            price = 120.50,
            image = R.drawable.il_basket_dame_1,
            categoryId = 2,
            description = "The Dome 7 Shoes are built for performance on the basketball court. With enhanced ankle support and a grippy outsole, these shoes allow you to make quick movements and sharp turns while staying stable. The cushioned sole absorbs impact, protecting your feet during jumps and landings.",
            rating = 4.1,
            isOnCart = true,
        ),
        ShoeEntity(
            id = 10,
            name = "D O N Issue 2 Shoes",
            price = 115.00,
            image = R.drawable.il_basket_don_issue_1,
            categoryId = 2,
            description = "The D O N Issue 2 Shoes offer a perfect blend of style and performance, designed for those who want to dominate the court. Featuring a high-cut design for added ankle support and a responsive midsole, these shoes are ideal for aggressive players who need stability and control.",
            rating = 4.5,
            isOnCart = false,
        ),
        ShoeEntity(
            id = 11,
            name = "Harden Vol 4 Shoes",
            price = 140.75,
            image = R.drawable.il_basket_harden_1,
            categoryId = 2,
            description = "The Harden Vol 4 Shoes are engineered for precision and power, inspired by the on-court moves of NBA star James Harden. With a lightweight feel and responsive cushioning, these shoes provide excellent traction and stability for quick cuts and explosive movements.",
            rating = 4.8,
            isOnCart = true,
        ),
        ShoeEntity(
            id = 12,
            name = "Pro Boost Low Shoes",
            price = 115.60,
            image = R.drawable.il_basket_proboost_1,
            categoryId = 2,
            description = "The Pro Boost Low Shoes feature a sleek, low-cut design that enhances mobility while keeping your feet secure. The cushioning provides excellent shock absorption, making these shoes ideal for fast-paced basketball games.",
            rating = 4.2,
            isOnCart = false,
        ),
        ShoeEntity(
            id = 11,
            name = "Terrex Trailmaker Hiking Shoes",
            price = 110.40,
            image = R.drawable.il_hiking_terrex_1,
            categoryId = 1,
            description = "The Terrex Trailmaker Hiking Shoes are crafted for rugged terrains. With durable traction and reinforced protection around the toes, these shoes ensure stability and grip on uneven trails. They are lightweight and comfortable, perfect for long hikes.",
            rating = 4.7,
            isOnCart = true,
        ),
        ShoeEntity(
            id = 14,
            name = "D O N Issue 2 Trekking Shoes",
            price = 149.95,
            image = R.drawable.il_hiking_don_issue_1,
            categoryId = 1,
            description = "The D O N Issue 2 Trekking Shoes offer rugged durability and performance for outdoor adventures. With enhanced support and a waterproof design, these shoes can handle tough trails and unpredictable weather, making them an ideal choice for trekkers.",
            rating = 4.5,
            isOnCart = false,
        ),
        ShoeEntity(
            id = 15,
            name = "Terrex Urban Low Hiking Shoes",
            price = 110.80,
            image = R.drawable.il_hiking_terrex_urban_1,
            categoryId = 1,
            description = "The Terrex Urban Low Hiking Shoes combine style and functionality for both urban exploration and outdoor hiking. Their breathable design and reliable traction make them suitable for varied terrains, while their sleek appearance makes them perfect for everyday wear.",
            rating = 4.1,
            isOnCart = false,
        ),
        ShoeEntity(
            id = 16,
            name = "Terrex AX1 Hiking Shoes",
            price = 115.00,
            image = R.drawable.il_hiking_terrex_ax_1,
            categoryId = 1,
            description = "The Terrex AX1 Hiking Shoes are built for stability and comfort on rocky paths. With a durable, grippy outsole and lightweight design, these shoes ensure that you stay steady on your feet, whether you're navigating mountain trails or forest paths.",
            rating = 4.9,
            isOnCart = true,
        )
    )

    fun getImagesById(id: Int): List<Int> {
        return when (id) {
            1 -> listOf(
                R.drawable.il_running_ultra4d_1,
                R.drawable.il_running_ultra4d_2,
                R.drawable.il_running_ultra4d_3
            )

            2 -> listOf(
                R.drawable.il_running_sl20_1,
                R.drawable.il_running_sl20_2,
                R.drawable.il_running_sl20_3
            )

            3 -> listOf(
                R.drawable.il_running_ultra4d_white_1,
                R.drawable.il_running_ultra4d_white_2,
                R.drawable.il_running_ultra4d_white_3
            )

            4 -> listOf(
                R.drawable.il_running_ultraboost_1,
                R.drawable.il_running_ultraboost_2,
                R.drawable.il_running_ultraboost_3
            )

            5 -> listOf(
                R.drawable.il_walking_lego_1,
                R.drawable.il_walking_lego_2,
                R.drawable.il_walking_lego_3
            )

            6 -> listOf(
                R.drawable.il_walking_fortarun_1,
                R.drawable.il_walking_fortarun_2,
                R.drawable.il_walking_fortarun_3
            )

            7 -> listOf(
                R.drawable.il_walking_supernova_1,
                R.drawable.il_walking_supernova_2,
                R.drawable.il_walking_supernova_3
            )

            8 -> listOf(
                R.drawable.il_walking_faito_1,
                R.drawable.il_walking_faito_2,
                R.drawable.il_walking_faito_3
            )

            9 -> listOf(
                R.drawable.il_basket_dame_1,
                R.drawable.il_basket_dame_2,
                R.drawable.il_basket_dame_3
            )

            10 -> listOf(
                R.drawable.il_basket_don_issue_1,
                R.drawable.il_basket_don_issue_2,
                R.drawable.il_basket_don_issue_3
            )

            11 -> listOf(
                R.drawable.il_basket_harden_1,
                R.drawable.il_basket_harden_2,
                R.drawable.il_basket_harden_3
            )

            12 -> listOf(
                R.drawable.il_basket_proboost_1,
                R.drawable.il_basket_proboost_2,
                R.drawable.il_basket_proboost_3
            )

            13 -> listOf(
                R.drawable.il_hiking_terrex_1,
                R.drawable.il_hiking_terrex_2,
                R.drawable.il_hiking_terrex_3
            )

            14 -> listOf(
                R.drawable.il_hiking_don_issue_1,
                R.drawable.il_hiking_don_issue_2,
                R.drawable.il_hiking_don_issue_3
            )

            15 -> listOf(
                R.drawable.il_hiking_terrex_urban_1,
                R.drawable.il_hiking_terrex_urban_2,
                R.drawable.il_hiking_terrex_urban_3
            )

            16 -> listOf(
                R.drawable.il_hiking_terrex_ax_1,
                R.drawable.il_hiking_terrex_ax_2,
                R.drawable.il_hiking_terrex_ax_3
            )

            else -> emptyList()
        }
    }
}
