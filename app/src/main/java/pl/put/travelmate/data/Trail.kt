package pl.put.travelmate.data

enum class Difficulty {
    EASY,
    MEDIUM,
    HARD
}

data class Trail(
    val id: Int,
    val name: String,
    val description: String,
    val distance: String?,
    val startLocation: String?,
    val stopLocation: String?,
    val elevation: Int?,
    val difficulty: Difficulty?,
    val longDescription: String?,
    val time: String?,
    val steps: List<TrailStep>,
    val imageUrl: String?
)

data class TrailStep(
    val id: Int,
    val name: String,
    val distance: String?,
    val time: String?
)

fun getTrails () = listOf(
    Trail(
        id = 1,
        name = "Śnieżka",
        description = "The highest peak in the Karkonosze mountains",
        distance = "10 km",
        startLocation = "Karpacz",
        stopLocation = "Śnieżka",
        elevation = 1602,
        difficulty = Difficulty.MEDIUM,
        longDescription = "Śnieżka is the highest peak in the Karkonosze mountains, located on the border between Poland and the Czech Republic. The peak is a popular destination for hikers and tourists, offering stunning views of the surrounding landscape.",
        time = "4:00",
        steps = listOf(
            TrailStep(
                id = 1,
                name = "Lorem Ipsum",
                distance = "0 km",
                time = "0:00"
            ),
            TrailStep(
                id = 2,
                name = "Dolor Sit",
                distance = "2 km",
                time = "1:00"
            ),
            TrailStep(
                id = 3,
                name = "Amet Consectetur",
                distance = "4 km",
                time = "2:00"
            ),
            TrailStep(
                id = 4,
                name = "Adipiscing Elit",
                distance = "6 km",
                time = "3:00"
            ),
            TrailStep(
                id = 5,
                name = "Sed Do Eius",
                distance = "8 km",
                time = "4:00"
            ),
            TrailStep(
                id = 6,
                name = "Tempor Incididunt",
                distance = "10 km",
                time = "5:00"
            )
        ),
        imageUrl = "data\\image.jpg"
    ),
    Trail(
        id = 2,
        name = "Morskie Oko",
        description = "A beautiful lake in the Tatra mountains",
        distance = "8 km",
        startLocation = "Zakopane",
        stopLocation = "Morskie Oko",
        elevation = 1395,
        difficulty = Difficulty.EASY,
        longDescription = "Morskie Oko is a beautiful lake located in the Tatra mountains in southern Poland. The lake is a popular destination for hikers and tourists, offering stunning views of the surrounding mountains and forests. The lake is accessible by foot or horse-drawn carriage, and there are several trails that lead to the lake. The most popular route is the green trail, which starts in Zakopane and takes about 2-3 hours to reach the lake. Once at the lake, visitors can enjoy a leisurely walk around the shore, or relax at one of the nearby mountain huts.",
        time = "4:00",
        steps = emptyList(),
        imageUrl = "data\\image.jpg"
    ),
    Trail(
        id = 3,
        name = "Bieszczady",
        description = "A remote and wild mountain range in southeastern Poland",
        distance = "15 km",
        startLocation = "Ustrzy",
        stopLocation = "Tarnica",
        elevation = 1346,
        difficulty = Difficulty.EASY,
        longDescription = "The Bieszczady mountains are a remote and wild mountain range located in southeastern Poland. The mountains are part of the Carpathian range, and are known for their rugged terrain, dense forests, and abundant wildlife. The Bieszczady mountains are a popular destination for hikers and nature lovers, offering a wide range of trails and routes to explore. The most popular route is the blue trail, which starts in Ustrzyki Dolne and takes about 4-5 hours to reach the summit of Tarnica, the highest peak in the range. Once at the top, visitors can enjoy panoramic views of the surrounding mountains and valleys, as well as the opportunity to spot rare and endangered species such as the European bison and the brown bear.",
        time = "6:00",
        steps = emptyList(),
        imageUrl = "data\\image.jpg"
    ),
    Trail(
        id = 4,
        name = "Trzy korony",
        description = "A popular peak in the Pieniny mountains",
        distance = "12 km",
        startLocation = "Szczawnica",
        stopLocation = "Trzy korony",
        elevation = 982,
        difficulty = Difficulty.MEDIUM,
        longDescription = "Trzy Korony is a popular peak in the Pieniny mountains, located on the border between Poland and Slovakia. The peak is known for its stunning views of the Dunajec river and the surrounding mountains, as well as its unique rock formations and diverse flora and fauna. The peak is accessible by foot or bike, and there are several trails that lead to the summit. The most popular route is the yellow trail, which starts in Szczawnica and takes about 3-4 hours to reach the summit. Once at the top, visitors can enjoy panoramic views of the surrounding landscape, as well as the opportunity to explore the nearby ruins of the medieval castle of Czorsztyn.",
        time = "4:00",
        steps = emptyList(),
        imageUrl = "data\\image.jpg"
    ),
    Trail(
        id = 5,
        name = "Śnieżka",
        description = "The highest peak in the Karkonosze mountains",
        distance = "10 km",
        startLocation = "Karpacz",
        stopLocation = "Śnieżka",
        elevation = 1602,
        difficulty = Difficulty.MEDIUM,
        longDescription = "Śnieżka is the highest peak in the Karkonosze mountains, located on the border between Poland and the Czech Republic. The peak is a popular destination for hikers and tourists, offering stunning views of the surrounding landscape. The mountain is accessible by foot, bike, or chairlift, and there are several trails that lead to the summit. The most popular route is the red trail, which starts in Karpacz and takes about 3-4 hours to reach the summit. Once at the top, visitors can enjoy panoramic views of the Karkonosze mountains, as well as the Giant Mountains and the Jizera Mountains in the distance.",
        time = "4:00",
        steps = emptyList(),
        imageUrl = "data\\image.jpg"
    ),
    Trail(
        id = 6,
        name = "Morskie Oko",
        description = "A beautiful lake in the Tatra mountains",
        distance = "8 km",
        startLocation = "Zakopane",
        stopLocation = "Morskie Oko",
        elevation = 1395,
        difficulty = Difficulty.EASY,
        longDescription = "Morskie Oko is a beautiful lake located in the Tatra mountains in southern Poland. The lake is a popular destination for hikers and tourists, offering stunning views of the surrounding mountains and forests. The lake is accessible by foot or horse-drawn carriage, and there are several trails that lead to the lake. The most popular route is the green trail, which starts in Zakopane and takes about 2-3 hours to reach the lake. Once at the lake, visitors can enjoy a leisurely walk around the shore, or relax at one of the nearby mountain huts.",
        time = "4:00",
        steps = emptyList(),
        imageUrl = "data\\image.jpg"
    ),
    Trail(
        id = 7,
        name = "Bieszczady",
        description = "A remote and wild mountain range in southeastern Poland",
        distance = "15 km",
        startLocation = "Ustrzy",
        stopLocation = "Tarnica",
        elevation = 1346,
        difficulty = Difficulty.EASY,
        longDescription = "The Bieszczady mountains are a remote and wild mountain range located in southeastern Poland. The mountains are part of the Carpathian range, and are known for their rugged terrain, dense forests, and abundant wildlife. The Bieszczady mountains are a popular destination for hikers and nature lovers, offering a wide range of trails and routes to explore. The most popular route is the blue trail, which starts in Ustrzyki Dolne and takes about 4-5 hours to reach the summit of Tarnica, the highest peak in the range. Once at the top, visitors can enjoy panoramic views of the surrounding mountains and valleys, as well as the opportunity to spot rare and endangered species such as the European bison and the brown bear.",
        time = "6:00",
        steps = emptyList(),
        imageUrl = ""
    ),
    Trail(
        id = 8,
        name = "Trzy korony",
        description = "A popular peak in the Pieniny mountains",
        distance = "12 km",
        startLocation = "Szczawnica",
        stopLocation = "Trzy korony",
        elevation = 982,
        difficulty = Difficulty.MEDIUM,
        longDescription = "Trzy Korony is a popular peak in the Pieniny mountains, located on the border between Poland and Slovakia. The peak is known for its stunning views of the Dunajec river and the surrounding mountains, as well as its unique rock formations and diverse flora and fauna. The peak is accessible by foot or bike, and there are several trails that lead to the summit. The most popular route is the yellow trail, which starts in Szczawnica and takes about 3-4 hours to reach the summit. Once at the top, visitors can enjoy panoramic views of the surrounding landscape, as well as the opportunity to explore the nearby ruins of the medieval castle of Czorsztyn.",
        time = "4:00",
        steps = emptyList(),
        imageUrl = ""
    )
)

fun findTrailById(trails: List<Trail>, trailId: String?): Trail {
    return trails.first { it.id.toString() == trailId }
}