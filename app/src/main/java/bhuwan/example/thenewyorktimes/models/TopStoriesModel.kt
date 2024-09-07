package bhuwan

data class TopStoriesModel(

    val status: String? = null,
    val copyright: String? = null,
    val section: String? = null,
    val lastUpdated: String? = null,
    val numResults: Long? = null,
    val results: List<Result>? = null
)

data class Result(
    val section: String? = null,
    val subsection: String? = null,
    val title: String? = null,
    val abstract: String? = null,
    val url: String? = null,
    val uri: String? = null,
    val byline: String? = null,
    val itemType: ItemType? = null,
    val updatedDate: String? = null,
    val createdDate: String? = null,
    val publishedDate: String? = null,
    val materialTypeFacet: String? = null,
    val kicker: Kicker? = null,
    val desFacet: List<String>? = null,
    val orgFacet: List<String>? = null,
    val perFacet: List<String>? = null,
    val geoFacet: List<String>? = null,
    val multimedia: List<Multimedia>? = null,
    val shortURL: String? = null
)

enum class ItemType {
    Article,
    Interactive,
    Promo
}

enum class Kicker {
    Empty,
    NewsAnalysis,
    TopNews
}

data class Multimedia(
    val url: String? = null,
    val format: Format? = null,
    val height: Long? = null,
    val width: Long? = null,
    val type: Type? = null,
    val subtype: Subtype? = null,
    val caption: String? = null,
    val copyright: String? = null
)

enum class Format {
    LargeThumbnail,
    SuperJumbo,
    ThreeByTwoSmallAt2X
}

enum class Subtype {
    Photo
}

enum class Type {
    Image
}
